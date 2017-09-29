package com.company;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class OnlineShopperDNM extends ResizableArrayBag {
    public static void main(String[] args) throws IOException {
     int counter = 0 ; // accumulator for number of paintings
     int counter1 = 0 ; //counter for error line reading file 1
     int value = 0 ; // value accumulator for all paintings


        //create files using the FileCreator class
        PrintWriter toFile1 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\ArrayBagDemo\\src\\com\\company\\p1artists_output1.txt");
        PrintWriter toFile2 = createTextFile("C:\\Users\\Robert Anderson\\IdeaProjects\\ArrayBagDemo\\src\\com\\company\\p1arts_output1.txt");


        //Testing the Artist constructor(s) using the following data:
        Artist artist1 = new Artist(1, "Acconci");
        Artist artist2 = new Artist(2, "Ames");
        Artist artist3 = new Artist(3, "Aserty");
        Artist artist4 = new Artist(4, "Baron");
        Artist artist5 = new Artist(5, "Battenberg");
        Artist artist6 = new Artist(1001, "Red Rock Mountain", "Mogan", 50, 18000);

        Artist[] artistTest = {artist1, artist2, artist3, artist4, artist5, artist6};
        for (Artist temp : artistTest) {
            System.out.println(temp.toString());
        }//End constructor test

        Scanner inFile1 = new Scanner(new File("C:\\Users\\Robert Anderson\\IdeaProjects\\ArrayBagDemo\\src\\com\\company\\p1artists.txt")).useDelimiter("\t");

        Artist[] artistArray1 = new Artist[60];
        Artist[] artistArray2 = new Artist[116];
        ResizableArrayBag<Artist> artistBag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Artist> artistBag2 = new ResizableArrayBag<>();

        //put the contents of the first file into an array
        while (inFile1.hasNextLine()) {
            for (int i = 0; i < artistArray1.length; i++) {
                String[] line = inFile1.nextLine().split("\t");
                //add artistTest to the array from the file
                artistArray1[i] = new Artist(Integer.parseInt(line[0]), line[1]);
                //artistBag1.add(new Artist(Integer.parseInt(line[0]), line[1])); //load the first artist bag-test
                try {
                    toFile1.write(artistArray1[i].getArtistId() + "\t" + artistArray1[i].getArtistName()+ "\n");
                } catch (Exception e) {
                    System.out.println("Error in file 1, line: " + counter1);
                }
                counter1++;
            }
        }
        //Print out the first artist array
/*        System.out.println(Arrays.toString(artistBag1.toArray()));
        for (int i = 0; i < artistArray1.length; i++) {
            System.out.println(artistArray1[i].toString());
        }*/
        Scanner inFile2 = new Scanner(new File("C:\\Users\\Robert Anderson\\IdeaProjects\\ArrayBagDemo\\src\\com\\company\\p1arts.txt")).useDelimiter("\t");

        //put the contents of the second file into an array
        while (inFile2.hasNextLine()) {
            for (int i = 0; i < 116; i++) {
                String[] line2 = inFile2.nextLine().split("\t");
                //add artistTest to the array from the file
                artistArray2[i] = new Artist(Integer.parseInt(line2[0]), line2[1], Integer.parseInt(line2[2]), Integer.parseInt(line2[3]));

            }
        }
        //test the array was filled (print array)
/*        for (Artist anArtistArray2 : artistArray2) {
            System.out.println(anArtistArray2.toString());
            // System.out.println(Arrays.toString(artistBag2.toArray()));
        }*/

        //populate the second array with the artistName from the first array
        //
        for (int i = 0; i < artistArray2.length; i++) {
            Artist anArtistArray21 = artistArray2[i];
            // if artist name == null (in art file 2), search file 1 for the corresponding artistId
            // get the artistName from (file 1), then add those records to array 3
            int tempId1 = anArtistArray21.getArtistId();
            Artist artistToAdd = artistArray2[i];

            for (Artist anArtistArray1 : artistArray1) {
                int tempId2 = anArtistArray1.getArtistId();
                if (tempId1 == tempId2) {
                    //System.out.println("Match");
                    anArtistArray21.setArtistName(anArtistArray1.getArtistName());
                    artistBag2.add(artistToAdd);
                } /*else if (tempId1 != tempId2) {
                    // System.out.println("No match found");
                    // anArtistArray21.setArtistName("--N/A--");
                }*/ //this else block was used as a test to ensure the arrays were being matched up

            }
            counter++;
            value = value + artistToAdd.getValue();

        }
        toFile2.write("Art ID"+"\t"+"Art Name" + "\t\t\t" + "Artist Name" + "\t" + "Artist ID" +"\t" +"Value" +"\n");
        for (int i = 0 ; i< artistArray2.length ; i++){
            toFile2.write(artistArray2[i].getArtId()+"\t"+artistArray2[i].getArtName() + "\t" +
            artistArray2[i].getArtistName() + "\t" + artistArray2[i].getArtistId() + "\t" + artistArray2[i].getValue() +"\n");
        }
        //toFile2.write(Arrays.toString(artistBag2.toArray()));//write the contents of the populated bag to a file
        toFile2.write("\n");
        toFile2.write("Total number of paintings:"+  counter + "\n");
        toFile2.write("Total value of paintings:" + value);
            //System.out.println(Arrays.toString(artistBag2.toArray()));

            toFile1.close();
            toFile2.close();
            artistBag1.clear();

    }





/*    private static Scanner writeTextFile(String infileName, PrintWriter outfileName) throws IOException {
        Scanner inFile = null;
        BufferedWriter bw = new BufferedWriter(outfileName);
        int counter = 0;
        try {
            Scanner fileData = new Scanner(new File(infileName));
            while (fileData.hasNextLine()) {
                //fileData.nextInt();
                String[] line = fileData.nextLine().split("\t");
                for (int i = 0; i < line.length; i++) {
                    outfileName.write(String.valueOf(line[i]) + "\t");
                }
                outfileName.println();
                //System.out.println(line);

            } // end while loop
            fileData.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be read");
            e.getMessage();
        }

        return null;
    }*/


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
    static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}// end main


class Artist {
    private String artistName; // name of artist
    private int artistId; //id of artist
    private int artId ; // id of painting
    private String artName ; //name of painting
    private int value ; // value of the painting

    // constructor
    Artist(int artistId, String ArtistName) {
        this.artistId = artistId;
        this.artistName = ArtistName ;
    }
    Artist(int artId, String artName, int artistId, int value) {
        this.artId = artId ;
        this.artName = artName ;
        this.artistId = artistId ;
        this.value = value ;
    }
    Artist (int artId, String artName, String artistName, int artistId, int value ){
        this.artId = artId ;
        this.artName = artName ;
        this.artistName = artistName ;
        this.artistId = artistId ;
        this.value = value ;

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
    public void setArtistId(Artist artistToAdd, int artistId) {
        this.artistId = artistId;
    }

    //return the artId
    public int getArtId() {
        return artId;
    }

    // set the artId
    public void setArtId(Artist artistToAdd, int artId) {
        this.artistId = artId;
    }


    //return the artId
    public String getArtName() {
        return artName;
    }

    // set the artId
    public void setArtName(Artist artistToAdd, String artName) {
        this.artName = artName;
    }

    //return the value
    public int getValue() {
        return value;
    }

    // set the value
    public void setValue(Artist artistToAdd, int value) {
        this.value = value;
    }

    // toString method
    @Override
    public String toString() {
    return (this.artId + "\t" + this.artName + "\t" + this.artistName + "\t" + this.artistId + "\t" + this.value) ;
    }

}



// end OnlineShopper