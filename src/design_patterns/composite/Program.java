package design_patterns.composite;
// References -: Design Pattern course from coursera by Univ of Alberta
public class Program {
    public static void main(String[] args) {
       Playlist sadPlaylist=new Playlist("Sad Playlist");

       Playlist pankajUdhas=new Playlist("Pankaj Udhas's Playlist");
       pankajUdhas.add(new Song("Thodi Thodi peya karo","Pankaj Udhas"));
       pankajUdhas.add(new Song("Chithi Aaaye hai","Pankaj Udhas"));

       Playlist jagjitSingh=new Playlist("Jagjit Sing's Playlist");
       jagjitSingh.add(new Song("Kagaz ki kashti","Jagjit Singh"));
       jagjitSingh.add(new Song("Mein nashe mein huun","Jagjit Singh"));

       sadPlaylist.add(pankajUdhas);
       sadPlaylist.add(jagjitSingh);

       Playlist punjabiPlaylist=new Playlist("Punjabi playlist");

       Playlist sheeryMaan=new Playlist("Sherry Maan's Playlist");
       sheeryMaan.add(new Song("3 Peg","Sherry Maan"));
       sheeryMaan.add(new Song("Yaar Anmulle","Sheery Mann"));
       sheeryMaan.add(new Song("Shadi.com","Sherry Mann"));

       Playlist jassManak=new Playlist("Jass Manak's Songs");
       jassManak.add(new Song("Lehenga","Jass Manank"));
       jassManak.add((new Song("Shooping","Jass Manak")));

       punjabiPlaylist.add(sheeryMaan);
       punjabiPlaylist.add(jassManak);

       Playlist myFavouratePlaylist=new Playlist("My favourate Playlist");
       myFavouratePlaylist.add(sadPlaylist);
       myFavouratePlaylist.add(punjabiPlaylist);

       myFavouratePlaylist.setPlaybackSpeed(1.5f);
//       myFavouratePlaylist.play();

       myFavouratePlaylist.setPlaybackSpeed(1f);
       sadPlaylist.setPlaybackSpeed(0.5f);
       punjabiPlaylist.setPlaybackSpeed(1.5f);
       myFavouratePlaylist.play();


    }
}
