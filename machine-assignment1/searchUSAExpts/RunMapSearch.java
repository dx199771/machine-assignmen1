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
    map1.mapFromFile("map1.txt");
    map1.estsFromFile("map1_ests.txt"); //get the A* estimates
    
    Carta mapUSA= new Carta();
    mapUSA.mapFromFile("USA_links.txt");
    mapUSA.estsFromFile("DenverEsts90.txt");
    
    String[] USACities = {"Albany", "Atlanta", "Augusta", "Austin", "Bismarck",
                          "Boise", "Boston", "Chicago", "Dallas", "Denver", 
                          "Detroit", "Helena", "Indianapolis", "Jefferson City",
                          "Las Vegas", "Los Angeles", "Memphis", "Miami", 
                          "New Orleans", "New York", "Oklahoma City", "Phoenix",
                          "Pierre", "Salem", "Salt Lake City", "San Francisco",
                          "Santa Fe", "Seattle", "Tallahassee", "Washington DC"};
    
    // screen.println(map1.toString());
    //screen.println(map1.getLinks("Start"));

    MapSearch searcher = new MapSearch(map1,"Goal");
    SearchState initState = (SearchState) new MapState("Start",0,0);

   
    //SearchState USAinitState = (SearchState) new MapState("New York",0,0); //start
    
    //change from search1 - specify strategy
    //String res_df = searcher.runSearch(initState, "breadthFirst");
    //screen.println(res_df);
    //String res_bf = searcher.runSearch(initState, "depthFirst");
    //screen.println(res_bf);
    //String res_bb = searcher.runSearch(initState, "branchAndBound");

    //String res_astar = searcher.runSearch(initState, "AStar");
    //screen.println(res_astar);
    
    
    
    //Journeys to Denver from every US city
    
    MapSearch USAsearcher = new MapSearch(mapUSA,"Denver"); //goal
    //String USAres = USAsearcher.runSearch(USAinitState, "branchAndBound");
    //screen.println(USAres);
   
    for (String c : USACities)
     {SearchState USAinitState = (SearchState) new MapState(c,0,0); //start
      String USAres = USAsearcher.runSearch(USAinitState, "AStar");
      screen.println(c+" "+USAres);
     }

  }
}










