
/**
 * MapLink.java
 *
 * A link in a map
 *
 * @author <a href="mailto: "Phil Green</a>
 * 2013 version
 */

public class MapLink {
  private String point1;
  private String point2;
  private int cost;

  public  MapLink(String p1, String p2, int c){
    point1=p1;
    point2=p2;
    cost=c;
  }
  //get starting point of the map
  public String getPoint1(){return point1;}
  //get desination of the map
  public String getPoint2(){return point2;}
  //get cost between two point
  public int getCost() {return cost;}

  public String toString() {return point1+ " <--> "+point2+" "+ cost;}

}

