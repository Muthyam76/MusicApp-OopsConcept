import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Album sid=new Album("arya","sidsriram");
        sid.addSongToAlbum("1",4.00);
        sid.addSongToAlbum("2",3.22);
        sid.addSongToAlbum("3",3.22);
        sid.addSongToAlbum("4",3.66);
        sid.addSongToAlbum("5",7.9);
        LinkedList<Song>playList=new LinkedList<>();

        sid.addToPlayList("1",playList);
        sid.addToPlayList("2",playList);
        sid.addToPlayList("3",playList);
        sid.addToPlayList("4",playList);
        sid.addToPlayList("5",playList);
        play(playList);
    }
    public static void play(LinkedList<Song>playList) {


        ListIterator<Song> listIterator = playList.listIterator();
        System.out.println("welcome to Music-App");
        if (playList.size() > 0) {
            System.out.println("song playing:"+listIterator.next().toString());
        } else {
            System.out.println("no songs present in playList");
            return;
        }
        printMenu();
        System.out.println("enter your option:");
        Scanner sc = new Scanner(System.in);
        boolean forward=true;
        boolean quit =false;
        while(!quit){
             int option=sc.nextInt();
            switch (option){
                case 0:
                    quit=true;
                    break;
                case 1:
                   if(forward==false && listIterator.hasNext()){
                       listIterator.next();
                       forward=true;
                   }
                   if(listIterator.hasNext()){
                       System.out.println("playing next song:"+listIterator.next().toString());
                       forward=true;
                   }
                   else{
                       System.out.println("Sorry this song last in your playlist");
                       forward=false;
                   }
                   break;
                case 2:
                    if(forward==true && listIterator.hasPrevious()){
                        listIterator.previous();
                        forward=false;
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("playing previous song:"+listIterator.previous().toString());
                        forward=false;
                    }
                    else{
                        System.out.println("Sorry this song first in your playlist");
                        forward=true;

                    }
                    break;
                case 3:
                    if(forward==true){
                        System.out.println("playing again this song:"+listIterator.previous().toString());
                        forward=false;

                    }
                    else{
                        System.out.println("playing again song:"+listIterator.next().toString());
                        forward=true;

                    }
                    break;
                case 4:
                    ListIterator<Song> list = playList.listIterator();
                    System.out.println("list of all songs:");
                    while(list.hasNext()){
                        System.out.println(list.next().toString());

                    }
                    break;
                case 5:
                    printMenu();
                case 6:
                    System.out.println("deleteing song :");
                listIterator.remove();
                break;
                default:break;


            }
        }
    }
    public static void printMenu(){

        System.out.println("0 - to quit\n"+
                "1 - to play  song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song"
                );
    }

}