//Eli Tatro, Ben Hamor, Hunter Zhang, Caity Corcoran
package cs314_A4;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac cs314_A1.AdventureGame.java
     To run:     java cs314_A1.AdventureGame

     The main routine is AdventureGame.main
    
     Describes the current room and item contained within.  Allows player to enter and exit the room.
     
     Update August 2010: refactored Vector contents into ArrayList<Item> contents.
      This gets rid of the use of obsolete Vector and makes it type safe.
	
**/

/** Ben Hamor, Feb 2, 2016
 * Added package name cs314_A1 to compile and run commands.  Added simple description to file.
 * @author bhamor
 *
 */

// class Room

//2/2/2016 updated by Hunter Zhang, contain constructors for rooms

import java.util.ArrayList;
import java.util.ListIterator;


/*import java.util.Enumeration;
import java.util.Vector;     Tatro: Commented these out because the were not being used.
*/
public class Room implements CaveSite {

	private String description;

	private CaveSite[] side = new CaveSite[6];

	private ArrayList<Item> contents = new ArrayList<Item>(); // Tatro: Changed JRE to 1.5

  public Room() {
	  
    side[0] = new Wall();
    side[1] = new Wall();
    side[2] = new Wall();
    side[3] = new Wall();
    side[4] = new Wall();
    side[5] = new Wall();
    
    }
  
	public void setDesc(String d) {
		description = d;
	}

	public void setSide(int direction, CaveSite m) {
		side[direction] = m;
	}

	public void addItem(Item theItem) {
		contents.add(theItem);
	}

	public void removeItem(Item theItem) {
		contents.remove(theItem);
	}

	public boolean roomEmpty() {
		return contents.isEmpty();
	}

  // get what item is in the room
  public Item[] getRoomContents(){
   Item[] contentsArray = new Item[contents.size()];
   contentsArray = contents.toArray(contentsArray);
   return contentsArray;
  }
  
  public int getContentsSize(){
	  return contents.size();
  }

	public String enter(Player p) {
		p.setLoc(this);
		return "";
	}

	public String exit(int direction, Player p) {
		return side[direction].enter(p);
	}

  // describes the room
  public String getDesc(){
   int contentsIndex = 0;
   ListIterator<Item> roomContents = contents.listIterator(); 
   String contentString = "";
   while(roomContents.hasNext()){
	   contentsIndex++;
       contentString = contentString + contentsIndex + "." + " " + (roomContents.next()).getDesc() + "\n";
   }
    contentsIndex=0;
     return description + '\n' + '\n' + "Room Contents: \n" + contentString + '\n';
   }

}

