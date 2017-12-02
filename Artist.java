package project3;

import java.util.Collections;
import java.util.Comparator;

public class Artist {
    private String artistName; // name of artist
    int artistId; //id of artist
    private int artId ; // id of painting
    private String artName ; //name of painting
    private int value ; // value of the painting
    private int next;
    private String addDelete ;


    // constructor
    Artist(int artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }

    Artist(int artistId, String artistName, int next) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.next = next;
    }

    Artist(int artId, String artName, int artistId, int value) {
        this.artistId = artistId;
        this.artId = artId;
        this.value = value ;
        this.artName = artName;
        //this.next = next;
    }

    public Artist(int idCounter, String artistName, String addDelete) {
        this.artistId = idCounter;
        this.artistName = artistName ;
        this.addDelete = addDelete;
            }


    //return the artistName
    public String getArtistName() {
        return artistName;
    }

    //set the artistName
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    //return the artistId
    public int getArtistId() {
        return artistId;
    }

    // set the artistId
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%5d, %10s, %5d, %30s, %8d\n", this.artistId,this.artistName,this.artId,this.artName,this.value);
    }


    public void setNext(int next) {
        this.next = next;
    }

    public int getNext() {
        return next;
    }

    public void setAddDelete(String addDelete) {
        this.addDelete = addDelete;
    }

}