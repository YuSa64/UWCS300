import java.util.Iterator;

public class driver {
  public static void main(String[] args) {
    SongCollection songs = new SongCollection();
    System.out.println("a");
    analysisMethodA(songs);
    System.out.println("b");
    analysisMethodB(songs);
    System.out.println("c");
    analysisMethodC(songs);
  }

  public static void analysisMethodA(SongCollection songs) {
    songs.add(new Song("C is for Cookie.", "Cookie Monster"));
    songs.add(new Song("Rubber Duckie.", "Ernie"));
    songs.add(new Song("Elmo's Song.", "Elmo"));
  }

  public static void analysisMethodB(SongCollection songs) {
    SongCollection copy = new SongCollection();
    for (Song song : songs)
      copy.add(song);
    for (Song song : copy)
      System.out.println(song);
  }

  public static void analysisMethodC(SongCollection songs) {
    Iterator<Song> playlist = songs.iterator();
    for (int i = 0; i < 1000; i++)
      if (playlist.hasNext())
        System.out.println(playlist.next());
  }
}
