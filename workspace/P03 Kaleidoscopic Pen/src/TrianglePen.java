//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Kaleidoscopic Pen
// Files: DriverApplication.java, KaleidoscopePen.java, TrianglePen.java, Point.java, Triangle.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import processing.core.PApplet;

public class TrianglePen {

  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private boolean showPoints;
  private static PApplet processing; // PApplet object that represents
  // the graphic display window
  private ArrayList<Point> points;
  private ArrayList<Triangle> triangles;
  private Point pointDrag;

  public TrianglePen(PApplet processing, boolean showPoints) {
    this.processing = processing;
    this.showPoints = showPoints;
    points = new ArrayList<Point>();
    triangles = new ArrayList<Triangle>();
  }

  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();
  }

  private void handleMousePress(int mouseX, int mouseY) {
    for (Point p : points) {
      if (p.isOver(mouseX, mouseY)) {
        pointDrag = p;
        return;
      }
    }
    points.add(new Point(mouseX, mouseY));
    if (points.size() % 3 == 0)
      triangles.add(new Triangle(points.get(points.size() - 3), points.get(points.size() - 2),
          points.get(points.size() - 1), 0));
  }

  private void handleMouseRelease(int mouseX, int mouseY) {
    pointDrag = null;
  }

  private void handleMouseDrag(int mouseX, int mouseY) {
    if (pointDrag != null) {
      pointDrag.setPosition(mouseX, mouseY);
    }
  }

  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    for (int i = triangles.size() - 1; i >= 0; i--) {
      if (triangles.get(i).isOver(mouseX, mouseY) && keyPressed >= '0' && keyPressed <= '7') {
        triangles.get(i).setColor(keyPressed - '0');
        break;
      }
    }
  }

  private void draw() {
    for (Triangle t : triangles) {
      t.draw(processing);
    }
    if (showPoints) {
      for (Point p : points) {
        p.draw(processing);
      }
    }
  }
}
