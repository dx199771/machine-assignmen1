/**
	MapSearch.java
    2013 version
	search for map traversal
*/


//import Search;
//import SearchNode;
//import Carta;

import java.util.*;
import sheffield.*;

public class MapSearch extends Search {

  private Carta map; //map we're searching
  private String goal; //goal city
  private int x;
  private int y;
 
  public Carta getMap(){
    return map;
  }
  public String getGoal(){
    return goal;
  }
    
  public MapSearch(Carta m, String g){
       TerrainMap tm = new TerrainMap(Carta.mapName);
    map=m;
    goal=g;
    //take x and y coordinate of the point
    x=Integer.parseInt(goal.substring(0,goal.indexOf(",")));
    y=Integer.parseInt(goal.substring(goal.indexOf(",")+1));
    //print out estimate cost
    EasyWriter file = new EasyWriter("est.txt");
	
	for(int i=0; i<tm.getDepth(); i++){
		for(int j=0; j<tm.getWidth(); j++){
		// if destination is higher than starting point
		// the cost will be the height difference + distance difference between two points
		if((tm.getTmap()[x][y]-tm.getTmap()[i][j])>0){
            file.println(i+","+j);
            file.println(x+","+y);
			//estimate method which use Manhattan Distance+height difference
            file.println(tm.getTmap()[x][y]-tm.getTmap()[i][j]+Math.abs(i-x)+Math.abs(j-y));
			//this is another estimate method which use Euclidean distance+height difference
			//file.println((int)(Math.sqrt(Math.abs(i-x)+Math.abs(j-y))+(tm.getTmap()[x][y]-tm.getTmap()[i][j])));
	
        }
		//if the destination is lower than starting point
		// the cost will be 1+distance difference
		else if((tm.getTmap()[x][y]-tm.getTmap()[i][j])<=0){
            file.println(i+","+j);
            file.println(x+","+y);
            file.println(1+Math.abs(i-x)+Math.abs(j-y));
			
        }
		}   
        
	}
     file.println("done");
 
}
}









