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
import processing.core.PApplet;

public class Point {
  
  private final static int POINT_DIAMETER = 8;

  private int x;
  private int y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int getX() {
    return this.x;
  }
  public int getY() {
    return this.y;
  }
  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public void draw(PApplet drawTo) { // draw a white circle at this point’s position
    drawTo.fill(-1);
    drawTo.circle(x, y, POINT_DIAMETER);
    
  }
  public boolean isOver(int x, int y) { // returns true when the position x, y
    // is within the circle drawn to visualize this point, otherwise returns false
    if(Math.sqrt((Math.pow(y-this.y, 2) + Math.pow(x-this.x, 2))) <= POINT_DIAMETER)
      return true;
    else return false;
  }
}
