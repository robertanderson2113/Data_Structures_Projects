package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;



public class Main extends ResizableArrayBag {

    public static void main(String[]args) throws IOException {
        int idCounter = 61;

        //create files using the FileCreator class
        //the file that will track the "Without Gap" approach
        PrintWriter toFile1 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\Project_2\\src\\com\\company\\p2artists2a.txt");
        //the file that will track the "Use Delete Field" approach
        PrintWriter toFile2 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\Project_2\\src\\com\\company\\p2artists2b.txt");
        //the file that will track the "Use Next Field" approach
        PrintWriter toFile3 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\Project_2\\src\\com\\company\\p2artists2c.txt");


        Scanner inFile1 = new Scanner(new File("C:\\Users\\Robert Anderson\\IdeaProjects\\Project_2\\src\\com\\company\\p1artists.txt")).useDelimiter("\t");
        Scanner inFile2 = new Scanner(new File("C:\\Users\\Robert Anderson\\IdeaProjects\\Project_2\\src\\com\\company\\p2changes.txt")).useDelimiter("\t");

        Artist[] artistArray1 = new Artist[60];
        Artist[] artistArrayAdd = new Artist[30];
        Artist[] artistArrayDelete = new Artist[30];
        Artist[] artistArrayBag = new Artist[100];
        ResizableArrayBag<Artist> artistBag1 = new ResizableArrayBag<>();
        ArrayList<Artist> artistList = new ArrayList<>();

        //put the contents of the first file into an array
        while (inFile1.hasNextLine()) {
            for (int i = 0; i < artistArray1.length; i++) {
                String[] line = inFile1.nextLine().split("\t");
                artistArray1[i] = new Artist(Integer.parseInt(line[0]), line[1], null);
                artistList.add(artistArray1[i]);
                artistBag1.add(artistArray1[i]);

            }
        }

/*            for (Artist anArtistArray1 : artistArray1) {
                System.out.println(anArtistArray1);
                artistBag1.add(anArtistArray1);
            }*/
        //read the file to an array and print contents to console
        while (inFile2.hasNextLine()) {
            for (int i = 0; i < artistArrayAdd.length; i++) {
                String[] line2 = inFile2.nextLine().split("\t");
                if (line2[0].equalsIgnoreCase("D")) {
                    for (Artist each : artistList) {
                        if (Integer.valueOf(line2[1]) == each.getArtistId()) {

                            //each.setArtistId(0);
                            //each.setAddDelete(null);
                            //each.setArtistName(null);
                            int temp = artistBag1.getIndexOf(each);
                            artistBag1.removeEntry(temp);

                        }
                    }
                } else if (line2[0].equalsIgnoreCase("a")) {
                    artistArrayAdd[i] = new Artist(idCounter, line2[1], line2[0]);
                    artistList.add(artistArrayAdd[i]);
                    artistBag1.add(artistArrayAdd[i]);
                    idCounter++;


                }
            }
            //Print out the size of the artist Bag to ensure no spaces are being left open
            System.out.println(artistBag1.getCurrentSize());

            //Print the list of all artists whether added or deleted.
/*            for (int i = 0; i < artistList.size(); i++)
            {
                toFile2.println(artistList.get(i));
            }*/
            System.out.println(artistList.toString());

            //Print the contents of the file to console and file
            System.out.println(Arrays.toString(artistBag1.toArray()));

            toFile1.write(Arrays.toString(artistBag1.toArray()));


        }
        toFile1.close();
        toFile2.close();
    }



    //fix the file to split the contents into separate arrays


/*                for (Artist anArtistArray2 : artistArrayAdd) {
                    System.out.println(anArtistArray2);
                }
                for (Artist anArtistArray3 : artistArrayDelete) {
                    System.out.println(anArtistArray3);
                }*/

               /* for (int i = 0 ; i < 82 ; i++){
                    if(artistArrayDelete[i].getAddDelete().equalsIgnoreCase("D")){
                        // get the artist Id and delete it from the bag
                    }
                }*/


    //SWITCH TO READING THE ADD FILE FIRST
    //  for (int i = 0; i < artistArray1.length; i++) {
/*                for (int j = 0; j < artistArrayAdd.length; j++) {
                    Artist tempArtist2 = new Artist(artistArrayAdd[j].getArtistId(), artistArrayAdd[j].getArtistName(), artistArrayAdd[j].getAddDelete());

                    String addDelete = artistArrayAdd[j].getAddDelete();
                    if (addDelete.equalsIgnoreCase("A")) {
                        // artistBag1.add(tempArtist1);

                        artistBag1.add(tempArtist2);
                    } else if (addDelete.equalsIgnoreCase("D")) {
                        if(tempArtist2.getArtistId()==artistArrayAdd[j].getArtistId()){
                            artistBag1.remove(tempArtist2);
                    }
                }*/


    //System.out.println(Arrays.toString(artistBag1.toArray()));








//create a text file from the given input and return the file
private static PrintWriter createTextFile(String fileName) {
        boolean fileOpened = true;
        PrintWriter toFile = null;
        try {
        toFile = new PrintWriter(fileName);
        System.out.println("File " + fileName + " created successfully");
        } catch (FileNotFoundException e) {
        fileOpened = false;
        System.out.println("File not created");
        }


        if (fileOpened) {
        Scanner inFile = new Scanner(fileName);
        while (inFile.hasNextLine()) {
        String line = inFile.nextLine();
        }

        }//end createTextFile
        return toFile;

        }

        }// end main


class Artist {
    private String artistName; // name of artist
    private int artistId; //id of artist
    //private int artId ; // id of painting
    //private String artName ; //name of painting
    //private int value ; // value of the painting
    private String addDelete ; // A or D will tell the program whether to add or delete a record


    // constructor
    Artist(int artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName ;
    }
    Artist (String addDelete, int artistId){
        this.addDelete = addDelete ;
        this.artistId = artistId ;
    }
    Artist (String addDelete, String artistName){
        this.addDelete = addDelete ;
        this.artistName = artistName ;
    }
    Artist (int artistId, String artistName, String addDelete){
        this.addDelete = addDelete ;
        this.artistId = artistId ;
        this.artistName = artistName ;
    }

/*        Artist(int artId, String artName, int artistId, int value) {
            this.artId = artId ;
            this.artName = artName ;
            this.artistId = artistId ;
            this.value = value ;
        }*/
/*        Artist (int artId, String artName, String artistName, int artistId, int value ){
            this.artId = artId ;
            this.artName = artName ;
            this.artistName = artistName ;
            this.artistId = artistId ;
            this.value = value ;

        }*/


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
    public void setArtistId( int artistId) {
        this.artistId = artistId;
    }

    // toString method
    @Override
    public String toString() {
        return this.artistId + "\t" + this.artistName + /*"\t" +  this.addDelete +*/ "\n";
    }

    public String getAddDelete() {
        return addDelete;
    }

    public void setAddDelete(String addDelete) {
        this.addDelete = addDelete;
    }
}



// end OnlineShopper