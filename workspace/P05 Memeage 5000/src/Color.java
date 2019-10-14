
public class Color extends FourBytes {
  public Color(int argb) {
    super(argb);
  }

  public Color(int alpha, int red, int green, int blue) {
    super(0);
    super.setBits(8, 0, blue);
    super.setBits(8, 8, green);
    super.setBits(8, 16, red);
    super.setBits(8, 24, alpha);
  }

  public Color(Color other) {
    super(0);
    super.setInt(other.getInt());
  }

  public int getARGB() {
    return super.getInt();
  }

  public int getAlpha() {
    return super.getBits(8, 24);
  }

  public int getRed() {
    return super.getBits(8, 16);
  }

  public int getGreen() {
    return super.getBits(8, 8);
  }

  public int getBlue() {
    return super.getBits(8, 0);
  }

  public void setARGB(int argb) {
    super.setInt(argb);
  }

  public void setAlpha(int alpha) {
    super.setBits(8, 24, alpha);
  }

  public void setRed(int red) {
    super.setBits(8, 16, red);
  }

  public void setGreen(int green) {
    super.setBits(8, 8, green);
  }

  public void setBlue(int blue) {
    super.setBits(8, 0, blue);
  }
}
