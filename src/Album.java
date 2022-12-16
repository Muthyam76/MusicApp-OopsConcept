import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
     String name;
     String artistName;
     ArrayList<Song> songs;
     Album(String name,String artistName){
         this.name=name;
         this.artistName=artistName;
         this.songs=new ArrayList<Song>();

     }
     //searching for a song present in album or not?
     public boolean findSong(String title){
         for(Song song : songs){
             if(song.getTitle().equals(title))
                 return true;
         }
         return false;
     }
     //adding songs to albums
     public void addSongToAlbum(String title,double duration){

         boolean isPresent=false;
         for(Song song : songs){
             if(song.getTitle().equals(title)) {
                 System.out.println("this song already present this album:"+title);
                 isPresent=true;
             }
         }
         if(isPresent==false) {
             Song song = new Song(title, duration);
             songs.add(song);
             System.out.println("successfully song added this song:"+title);
         }
     }
     //adding songs to playlist by song album song title
     public void addToPlayList(String title, LinkedList<Song> playList){
         int count=1;
         for(Song song : songs){
             if(song.getTitle().equals(title)) {
                 if(!playList.contains(song)){
                     playList.add(song);
                     System.out.println("successfully song added to this playList");
                 }
                 else
                 System.out.println("this song already present this album");
                 break;
             }
         }

     }
     // add song to playList by song number in album
     public void addToPlayList(int trackNo,LinkedList<Song>playList) {
         int index = trackNo - 1;
         if (index >= 0 && index < songs.size()) {
             if (!playList.contains(songs.get(index))) {
                 playList.add(songs.get(index));
                 System.out.println("successfully song added to this playList");
             } else
                 System.out.println("this song already present this album");

         }
     }

}
