package project3;

import java.io.*;
import java.util.*;

public class Main extends LinkedBag {

    public static void main(String[] args) throws IOException {
        int idCounter = 61;

        //create files using the FileCreator class
        PrintWriter toFile1 = createTextFile("Z:\\IdeaProjects\\Project_3\\src\\project3\\p3artists.txt");
        PrintWriter toFile2 = createTextFile("Z:\\IdeaProjects\\Project_3\\src\\project3\\p3artists_arts.txt");

        Scanner inFile1 = new Scanner(new File("Z:\\IdeaProjects\\Project_3\\src\\project3\\p1artists.txt")).useDelimiter("\t");
        Scanner inFile2 = new Scanner(new File("Z:\\IdeaProjects\\Project_3\\src\\project3\\p2changes.txt")).useDelimiter("\t");
        Scanner inFile3 = new Scanner(new File("Z:\\IdeaProjects\\Project_3\\src\\project3\\p1arts.txt")).useDelimiter("\t");

        Artist[] artistArrayArtists = new Artist[60];
        Artist[] artistArrayChanges = new Artist[30];
        Artist[] artistArrayArts = new Artist[116];
        ArrayList<Artist> artistList = new ArrayList<>();
        ArrayList<Artist> artistList2 = new ArrayList<>();
        LinkedBag<Artist> artistLinkedBag = new LinkedBag<>();

        //put the contents of the first file into an array
        while (inFile1.hasNextLine()) {
            for (int i = 0; i < artistArrayArtists.length; i++) {
                String[] line = inFile1.nextLine().split(",");
                artistArrayArtists[i] = new Artist(Integer.parseInt(line[0]), line[1]);
                artistList.add(artistArrayArtists[i]);
                idCounter++;
            }
        }

        while (inFile2.hasNextLine()) {
            for (int i = 0; i < artistArrayChanges.length; i++) {
                String[] line2 = inFile2.nextLine().split("\t");
                if (line2[0].equalsIgnoreCase("D")) {
                    for (Artist each : artistList) {
                        if (Integer.valueOf(line2[1]) == each.getArtistId()) {

                            each.setArtistId(0);
                            each.setAddDelete("T");
                            each.setArtistName(null);
                            artistList.remove(each);

                        }
                    }
                } else if (line2[0].equalsIgnoreCase("a")) {
                    artistArrayChanges[i] = new Artist(idCounter, line2[1], "F");

                    artistList.add(artistArrayChanges[i]);
                    idCounter++;


                }
            }

            while (inFile3.hasNextLine()) {
                for (int i = 0; i < artistArrayArts.length; i++) {
                    String[] line = inFile3.nextLine().split("\t");
                    artistArrayArts[i] = new Artist(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                    artistList.add(artistArrayArts[i]);

                }
            }

            // System.out.println("Test of Input File 1");
            //System.out.println(Arrays.toString(artistBag1.toArray()));
            for (int i = artistList.size(); i > 0; i--) {
                for (Artist anArtistArray1 : artistList) {
                    if (anArtistArray1.getArtistId() == i) {
                        artistLinkedBag.add(anArtistArray1);
                    }
                }
            }

         // for (int i = 0; i < artistList.size(); i++) {
         //     for (Artist anArtistArray1 : artistList) {
         //         if (anArtistArray1.getArtistId() == i) {
         //             artistLinkedBag.add(anArtistArray1);
         //         }
         //     }
         // }

            //read the file to an array and print contents to console
            long startTime = System.nanoTime();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            //Print out the size of the artist Bag to ensure no spaces are being left open and to prove items are actually being removed
            // toFile3.write("Total artists in the bag: " + artistBag1.getCurrentSize() + "\n");
            toFile2.write("Total time of method: " + duration + "\n\n");


            toFile1.write(Arrays.toString(artistLinkedBag.toArray()));

            //Print out the size of the artist Bag to ensure no spaces are being left open
            //System.out.println(artistBag1.getCurrentSize());
            //System.out.println(Arrays.toString(artistBag1.toArray()));
            //  toFile3.write(Arrays.toString(artistBag1.toArray()));
            toFile1.close();
            toFile2.close();


        }
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




