/**
	MapSearch.java
    2013 version
	search for map traversal
*/


//import Search;
//import SearchNode;
//import Carta;

import java.util.*;

public class MapSearch extends Search {

  private Carta map; //map we're searching
  private String goal; //goal city

  public Carta getMap(){
    return map;
  }
  public String getGoal(){
    return goal;
  }

  public MapSearch(Carta m, String g){
    map=m;
    goal=g;
  }
}










