//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Memeage 5000
// Files: Color.java, ColorPlusChar.java, Memeage.java, MemeageTests.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.io.File;
import java.io.IOException;

public class Memeage extends Image {
  public Memeage(File file) throws IOException {
    super(file);
  }

  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    setMeme(meme);
  }

  public void setMeme(String meme) throws IllegalArgumentException {
    int length = meme.length();
    if (super.getHeight() * super.getWidth() < length)
      throw new IllegalArgumentException();
    loop: for (int i = 0; i < super.getHeight(); i++) {
      for (int j = 0; j < super.getWidth(); j++) {
        int num = super.getWidth() * i + j;
        if (num != length) {
          if ((int) meme.charAt(num) > 127)
            throw new IllegalArgumentException();
          ColorPlusChar temp = new ColorPlusChar(super.getColor(j, i), meme.charAt(num));
          super.setColor(j, i, temp);
        } else {
          ColorPlusChar temp = new ColorPlusChar(super.getColor(j, i), '\0');
          super.setColor(j, i, temp);
          break loop;
        }
      }
    }
  }

  public String getMeme() throws IllegalStateException {
    String output = "";
    boolean isNull = false;
    loop: for (int i = 0; i < super.getHeight(); i++) {
      for (int j = 0; j < super.getWidth(); j++) {
        char get = new ColorPlusChar(super.getColor(j, i)).revealChar();
        if ((int) get > 127)
          throw new IllegalStateException();
        if (get == '\0') {
          isNull = true;
          break loop;
        }
        output += get;
      }
    }
    if (!isNull)
      throw new IllegalStateException();
    return output;
  }
}
