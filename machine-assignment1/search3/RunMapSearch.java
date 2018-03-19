 /**
   * RunMapSearch.java
   *
   * @author <a href="mailto: "Phil Green</a>
   * 2013 version

   run a map traversal

 */

import sheffield.*;
import java.util.*;

public class RunMapSearch {

  public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    Carta map1= new Carta();
    map1.mapFromFile("diablo11.pgm");
    //screen.println(map1.toString());
    //screen.println(map1.getLinks("Start"));
    String[] MapPoint = {"0,0","30,0","60,0","0,20","30,20","60,20","0,40","30,40","60,40","0,60","30,60","60,60"};  
    RamblersSearch searcher = new RamblersSearch(map1,"33,30");
    //SearchState initState = (SearchState) new RamblersState("0,0",0);

    //change from search1 - specify strategy
    //String res_df = searcher.runSearch(initState, "breadthFirst");
    //screen.println(res_df);
    //String res_bf = searcher.runSearch(initState, "depthFirst");
    //screen.println(res_bf);
    
	//String res_bb = searcher.runSearch(initState, "branchAndBound");
    //screen.println(res_bb);
	   
	   
	   for (String c : MapPoint)
     {SearchState initState = (SearchState) new RamblersState(c,0); //start
      String res_bb = searcher.runSearch(initState, "branchAndBound");
      screen.println(c+" "+res_bb);
     }
  }
}










