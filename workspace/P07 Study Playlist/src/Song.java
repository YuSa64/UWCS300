
public class Song {
  private String title;
  private String artist;
  public Song(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }
  public boolean equals(Object other) {
    return this.toString().equals(((Song)other).toString());
  }
  public String toString() {
    return title.toUpperCase() + " by " +artist.toUpperCase();
  }
}
