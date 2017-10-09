
        package com.company;

        import com.sun.org.apache.xpath.internal.SourceTree;

        import java.io.*;
        import java.util.*;



public class Main extends ResizableArrayBag {

    public static void main(String[]args) throws IOException {
        int idCounter = 2;

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
                artistArray1[i] = new Artist(Integer.parseInt(line[0]), line[1], idCounter);
                artistList.add(artistArray1[i]);
                artistBag1.add(artistArray1[i]);
                idCounter++;
            }
        }
       // System.out.println("Test of Input File 1");
        //System.out.println(Arrays.toString(artistBag1.toArray()));


/*            for (Artist anArtistArray1 : artistArray1) {
                System.out.println(anArtistArray1);
                artistBag1.add(anArtistArray1);
            }*/
        //read the file to an array and print contents to console
        long startTime = System.nanoTime();

        while (inFile2.hasNextLine()) {
            for (int i = 0; i < artistArrayAdd.length; i++) {
                String[] line2 = inFile2.nextLine().split("\t");
                if (line2[0].equalsIgnoreCase("a")) {
                    artistArrayAdd[i] = new Artist(idCounter, line2[1], idCounter + 1);

                    artistList.add(artistArrayAdd[i]);
                    artistBag1.add(artistArrayAdd[i]);
                    idCounter++;}
                 else
                    if (line2[0].equalsIgnoreCase("D")) {
                        for (Artist each : artistList) {
                            if (Integer.valueOf(line2[1]) == each.getArtistId()) {
                                each.setNext(0);
                                artistList.get(each.getArtistId()-2).setNext(each.getArtistId()+1);
                            }

                        }
                    }

                }
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            //Print out the size of the artist Bag to ensure no spaces are being left open and to prove items are actually being removed
            toFile3.write("Total artists in the bag: " + artistBag1.getCurrentSize() + "\n");
            toFile3.write("Total time of method: " + duration + "\n\n");
            //Print out the size of the artist Bag to ensure no spaces are being left open
            //System.out.println(artistBag1.getCurrentSize());
            //System.out.println(Arrays.toString(artistBag1.toArray()));
            toFile3.write(Arrays.toString(artistBag1.toArray()));


        toFile1.close();
        toFile2.close();
        toFile3.close();
    }


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
    private int next ;


    // constructor
    Artist(int artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName ;
    }
    Artist(int artistId, String artistName, int next){
        this.artistId = artistId ;
        this.artistName = artistName ;
        this.next = next ; 
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
    public void setArtistId( int artistId) {
        this.artistId = artistId;
    }

    // toString method
    @Override
    public String toString() {
        return this.artistId + "\t" + this.artistName + "\t" + this.next + "\n";
    }


    public void setNext(int next) {
        this.next = next;
    }
    public int getNext() {
        return next;
    }
}



// end Main
