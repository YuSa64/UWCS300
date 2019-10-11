//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Matching Game
// Files: MatchingGame.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MatchingGame {
  // Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
  // Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
  // Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!";
  // 2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES =
      new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170}, {170, 324}, {324, 324},
          {478, 324}, {632, 324}, {170, 478}, {324, 478}, {478, 478}, {632, 478}};
  // Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png", "ball.png",
      "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};

  private static PApplet processing; // PApplet object that represents
  // the graphic display window
  private static Card[] cards; // one dimensional array of cards
  private static PImage[] images; // array of images of the different cards
  private static Random randGen; // generator of random numbers
  private static Card selectedCard1; // First selected card
  private static Card selectedCard2; // Second selected card
  private static boolean winner; // boolean evaluated true if the game is won,
  // and false otherwise
  private static int matchedCardsCount; // number of cards matched so far
  // in one session of the game
  private static String message; // Displayed message to the display window

  public static void main(String[] args) {
    Utility.runApplication();
  }

  /**
   * Defines the initial environment properties of this game as the program starts
   */
  public static void setup(PApplet processing) {
    MatchingGame.processing = processing;
    images = new PImage[CARD_IMAGES_NAMES.length];
    for (int i = 0; i < images.length; i++) {
      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }
    initGame();
  }

  /**
   * Initializes the Game
   */
  public static void initGame() {
    randGen = new Random(Utility.getSeed());
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";
    cards = new Card[CARD_IMAGES_NAMES.length * 2];
    // making random int array
    int[] randAry = new int[cards.length];
    int count = 0;
    boolean loop = true;
    do {
      boolean isSame = false;
      randAry[count] = randGen.nextInt(cards.length);
      for (int i = 0; i < count; i++) {
        if (randAry[count] == randAry[i])
          isSame = true;
      }
      if (!isSame)
        count++;
      if (count >= 12)
        loop = false;
    } while (loop);
    // stack cards with a random position
    for (int i = 0; i < CARD_IMAGES_NAMES.length; i++) {
      cards[i] =
          new Card(images[i], CARDS_COORDINATES[randAry[i]][0], CARDS_COORDINATES[randAry[i]][1]);
      cards[i + CARD_IMAGES_NAMES.length] =
          new Card(images[i], CARDS_COORDINATES[randAry[i + CARD_IMAGES_NAMES.length]][0],
              CARDS_COORDINATES[randAry[i + CARD_IMAGES_NAMES.length]][1]);
    }

  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {
    if (processing.key == 'n' || processing.key == 'N') {
      initGame();
    }
  }

  /**
   * Callback method draws continuously this application window display
   */
  public static void draw() {
    // Set the color used for the background of the Processing window
    processing.background(245, 255, 250); // Mint cream color
    for (Card c : cards) {
      c.draw();
    }
    // messages
    if (selectedCard2 != null) { // if cards all selected
      if (matchingCards(selectedCard1, selectedCard2)) { // if cards match
        if (matchedCardsCount < 6) {
          message = MATCHED;
        }
      } else {
        message = NOT_MATCHED;
      }
    }
    if (winner)
      message = CONGRA_MSG;
    displayMessage(message);
  }

  /**
   * Displays a given message to the display window
   * 
   * @param message to be displayed to the display window
   */
  public static void displayMessage(String message) {
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }

  /**
   * Checks whether the mouse is over a given Card
   * 
   * @return true if the mouse is over the storage list, false otherwise
   */
  public static boolean isMouseOver(Card card) {
    float cX = card.getX();
    float cY = card.getY();
    int cW = card.getImage().width;
    int cH = card.getImage().height;
    int mX = processing.mouseX;
    int mY = processing.mouseY;
    if (mX >= cX - cW / 2 && mX <= cX + cW / 2 && mY >= cY - cH / 2 && mY <= cY + cH / 2)
      return true;
    else
      return false;
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    message = "";
    if (selectedCard2 != null) {
      if (!matchingCards(selectedCard1, selectedCard2)) {
        selectedCard1.setVisible(false);
        selectedCard2.setVisible(false);
        selectedCard1.deselect();
        selectedCard2.deselect();
      }
      selectedCard1 = null;
      selectedCard2 = null;
    }
    if (selectedCard1 == null) {
      for (Card c : cards) {
        if (isMouseOver(c) && !c.isVisible()) {
          c.setVisible(true);
          c.select();
          selectedCard1 = c;
        }
      }
    } else {
      for (Card c : cards) {
        if (isMouseOver(c) && !c.equals(selectedCard1) && !c.isVisible()) {
          c.setVisible(true);
          c.select();
          selectedCard2 = c;
        }
      }
    }
    if (selectedCard2 != null) {
      if (matchingCards(selectedCard1, selectedCard2)) {
        if (matchedCardsCount < 6)
          matchedCardsCount++;
      }
    }
    if (matchedCardsCount == 6) // if all cards matched
      winner = true;

  }


  /**
   * Checks whether two cards match or not
   * 
   * @param card1 reference to the first card
   * @param card2 reference to the second card
   * @return true if card1 and card2 image references are the same, false otherwise
   */
  public static boolean matchingCards(Card card1, Card card2) {
    PImage card1I = card1.getImage();
    PImage card2I = card2.getImage();
    if (card1I.equals(card2I)) {
      return true;
    } else {
      return false;
    }

  }
}
