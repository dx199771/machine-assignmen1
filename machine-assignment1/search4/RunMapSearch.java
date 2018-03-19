 /**
   * RunMapSearch.java
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


public class RunMapSearch {

  public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();
    Carta map1= new Carta();
    map1.mapFromFile("diablo11.pgm");
    
     
    //String[] MapPoint = {"0,0","30,0","60,0","0,20","30,20","60,20","0,40","30,40","60,40","0,60","30,60","60,60"};  
    
    // screen.println(map1.toString());
    //screen.println(map1.getLinks("Start"));
    MapSearch searcher = new MapSearch(map1,"33,30");
    
    SearchState initState = (SearchState) new MapState("0,0",0,0);
   
    map1.estsFromFile("est.txt"); //get the A* estimates
    //change from search1 - specify strategy
    //String res_df = searcher.runSearch(initState, "breadthFirst");
    //screen.println(res_df);
    //String res_bf = searcher.runSearch(initState, "depthFirst");
    //screen.println(res_bf);
    //String res_bb = searcher.runSearch(initState, "branchAndBound");
     
    String res_astar = searcher.runSearch(initState, "AStar");
    screen.println(res_astar);
      
     /*for (String c : MapPoint)
     {SearchState initState = (SearchState) new MapState(c,0,0); //start
      String res_astar = searcher.runSearch(initState, "AStar");
      screen.println(c+" "+res_astar);
     }*/
  }
}










