 /**
   * TestTerrainMap.java
   *
   *
   * Created: Fri Dec  1 12:59:33 2000
   *
   * @author <a href="mailto: "Phil Green</a>
   * @version
   2013 version
   run a map traversal
   this version allows for A*

 */

import sheffield.*;
import java.util.*;
//import terrainmap.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class TestTerrainMap {

/**
   * constructor, given a PGM image 
   * Reads a PGM file. The maximum greyscale
   * value is rescaled to be between 0 and 255.
   * @param filename
   * @return
   * @throws FileNotFoundException
   */
  
   public static void main(String[] arg){

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();
    
    //File f=new File("eje.pgm");
    //Scanner scanner = new Scanner(f);
    TerrainMap tm = new TerrainMap("tmc.pgm");
    
    screen.println(tm.getWidth());
    screen.println(tm.getTmap()[7][2]);
    
  }
}
    