
/**
 * Carta.java
 *
 * a map for searching
 * called Carta to avoid confusion with Interface map
 *
 *
 * @author <a href="mailto: "Phil Green</a>
 * 2013 version
 */

import sheffield.*;
import java.util.*;

public class Carta{
  private ArrayList<MapLink> links; // all the links
  private HashSet cities;  // all the cities

  //accessors
  public ArrayList<MapLink> getAllLinks() {return links;}
  public HashSet getCities() {return cities;}
  public static String mapName;
  
  //constructor - empty map

  public Carta(){
  links = new ArrayList<MapLink>();
  }

  /**
  * addLink adds a link to a map
  * @param p1 point 1
  * @param p2 point 2
  * @param c cost of the link
  */
  public void addLink(String p1, String p2, int c){
    MapLink ml=new MapLink(p1,p2,c);
    links.add(ml);
  }

  public String toString(){
    StringBuffer buf = new StringBuffer("MAP WITH LINKS\n");
    for (MapLink lnk: links){
    	String lstr = lnk.toString();
    	buf.append(lstr+"\n");
    }
    return buf.toString();
  }

  /**
  * getLinks
  * returns all links to/from a given point
  * @param point - the point
  * @return ArrayList of links
  */
  public ArrayList<MapLink> getLinks(String point){
    ArrayList<MapLink> clinks = new ArrayList<MapLink>();
     for (MapLink l: links){
         if ((point.compareTo(l.getPoint1())==0)||(point.compareTo(l.getPoint2())==0))
         clinks.add(l);
     }

     return clinks;
  }

  /**
  * costbetween
  * returns cost between 2 cities
  * @param p1 point 1
  * @param p2 point 2
  */

  public int costbetween(String p1,String p2){
    ArrayList<MapLink> p1links=getLinks(p1);
    int ans=-1;
    Iterator i =p1links.iterator();
    while (i.hasNext()&&(ans<0)){
      MapLink l= (MapLink) i.next();
      if (p2.equals(l.getPoint1()) || p2.equals(l.getPoint2())){
        ans= l.getCost();
      }
    }
    return ans;
  }


  /**
  * mapFromFile
  * reads a map from file
  * @param fname - the file name
  */

  public void  mapFromFile(String fname){
    TerrainMap tm = new TerrainMap(fname);
     mapName = fname;
    for(int i=0; i<tm.getDepth()-1; i++){
		for(int j=0; j<tm.getWidth()-1; j++){
			 links.add(new MapLink(i+","+j, i+","+(j+1),Math.abs(tm.getTmap()[i][j+1]-tm.getTmap()[i][j])));
			 links.add(new MapLink(i+","+j, (i+1)+","+j,Math.abs(tm.getTmap()[i+1][j]-tm.getTmap()[i][j])));
		}
	}     
    findcities(); // uses the links to find the cities
  }

  // find all cities on the map

  private void findcities(){
    cities= new HashSet();
    for (MapLink l: links){
    	cities.add(l.getPoint1());
      cities.add(l.getPoint2());
    }
  }
}









