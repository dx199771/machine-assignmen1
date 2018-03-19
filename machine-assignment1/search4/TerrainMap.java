//package terrainmap;

/**
 * @(#)TerrainMap.java
 * Terrain Maps for the Rambler's problem
 * store and display as PGM images
 * @author PDG
 * @version 2.00 2018/1/10
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import sheffield.*;
//import Coords.*;

public class TerrainMap {
 private int[][] tmap; //the map, array of pixels
 private int width; //max x dimension
 private int depth; //max y dimension
 private int height; //max height
 private String mno; //magic number
 private String irfan; //irfan comment line
 //accessors
 
 public int[][] getTmap() {return tmap;}; 
 public int getWidth() {return width;}; 
 public int getDepth() {return depth;}; 
 public int getHeight() {return height;};
 
 private static final int MAXVAL = 255; // We'll use a constant maximum greyscale value
     
   
 /**
   * constructor, given a PGM image 
   * Reads a PGM file. The maximum greyscale
   * value is rescaled to be between 0 and 255.
   * @param filename
   * @return
   * @throws FileNotFoundException
   */
 public TerrainMap(String filename) { 
    try {
      Scanner scanner = new Scanner(new File(filename));
      mno = scanner.next(); // magic number
      if (!scanner.hasNextInt()){irfan = scanner.nextLine();}; //advance until next Int
      if (!scanner.hasNextInt()){irfan = scanner.nextLine();};
      width = scanner.nextInt();
      depth = scanner.nextInt();
      height = scanner.nextInt();
    
      tmap=new int[depth][width];
    
      // read pixels
      for (int i = 0; i < depth; ++i)
      { 
        for (int j = 0; j < width; ++j)
        {
        
          int value = (int) scanner.nextInt();
        // normalize to 255
          value = (int) Math.round( ((double) value) / height * MAXVAL);
          tmap[i][j] = value;  
        }
      }
    }
    catch (FileNotFoundException e) {
    	    System.err.println("FileNotFoundException: " + e.getMessage());
    }
  }
 
  // write a terrain map to a file
  public void writeTMap (String fname) {

    try {
        FileWriter writer = new FileWriter(fname, true);
        writer.write (mno+"\n");
        writer.write (width+" ");
        writer.write (depth+"\n");
        writer.write (height+"\n");
        
        for (int i = 0; i < depth; ++i)
         { 
          for (int j = 0; j < width; ++j)
           {                                               
                  writer.write(tmap[i][j]+" ");
            }
            writer.write("\n");   // write new line
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

} 
// show a path on a terrain map
// path is ArrayList of Coords
// make every pixel on path 255

public void showPath (ArrayList<Coords> path){
  for (Coords c : path) tmap [c.gety()][c.getx()] =255;
}
}


                