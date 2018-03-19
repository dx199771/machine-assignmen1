/**
	State in a map search
	2013 version
*/

import java.util.*;

public class RamblersState extends SearchState{

  //point for this state
  private String point;


  //constructor
  public RamblersState(String p, int lc){
    point=p;
    localCost=lc;
  }
  //accessor
  public String getPoint(){
    return point;
  }

  // goalP
  public boolean goalP(Search searcher) {
    RamblersSearch msearcher = (RamblersSearch) searcher;
    String tar=msearcher.getGoal(); // get target point
    return (point.compareTo(tar)== 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch msearcher = (RamblersSearch) searcher;
    Carta map=msearcher.getMap();
    ArrayList<MapLink> links=map.getLinks(point);
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

    for (MapLink l: links){
    	String spoint;
        if (point.compareTo(l.getPoint1())==0) {
        spoint=l.getPoint2();
        }
        else {
        spoint=l.getPoint1();};
        succs.add((SearchState)new RamblersState(spoint,l.getCost()));
    }
    return succs;
    }

  // sameState

  public boolean sameState(SearchState s2) {
    RamblersState ms2= (RamblersState) s2;
    return (point.compareTo(ms2.getPoint())==0);
  }


// toString
    public String toString () {
       return (point);
    }



}



