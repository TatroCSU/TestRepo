//Eli Tatro, Ben Hamor, Hunter Zhang, Caity Corcoran
package cs314_A4;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac cs314_A1.AdventureGame.java
     To run:     java cs314_A1.AdventureGame

     The main routine is AdventureGame.main
     
     Stores and shows location of player and what player is carrying.
     Controls player movement as well as item manipulation.
				    
**/
 
/** 2/2/2016 updated by Hunter Zhang
 */

import java.util.ArrayList;

/** Ben Hamor, Feb 2, 2016
 * Added package name cs314_A1 to compile and run commands.  Added simple description to file.
 * @author bhamor
 *
 */


public class Player {

  private Room myLoc;

  private Item[] myThings = new Item[2];

  private int itemCount = 0;

  public void setRoom(Room r){
   myLoc = r;
   }

  public String look() {
   return myLoc.getDesc();
   }

  public String go(int direction){
     return myLoc.exit(direction, this);
  }

  // checking how many item a player is carrying, 
  // if less than 2, then it picks up the specified item
  // and removes it from the room
  public void pickUp(Item i){
   if (itemCount < 2) {
      myThings[itemCount] = i;
      itemCount++;
      myLoc.removeItem(i);
      }
  }

  // check to see if the specified item is in the player's inventory already
  public boolean haveItem(Item itemToFind){
     for (int n = 0; n < itemCount ; n++)
       if (myThings[n] == itemToFind) return true;
     return false;
  }

  // removes the specified item from player's inventory, and adds it in the current room object
  public void drop(int itemNum){
   if (itemNum > 0 & itemNum <= itemCount){
      switch(itemNum){
      case 1: { myLoc.addItem(myThings[0]);
	        myThings[0]=myThings[1];
	        itemCount--; 
	        break;
	      }
      case 2: { myLoc.addItem(myThings[1]);
		itemCount--;
		break;
	      } 
      }
   }
   }

  public void setLoc(Room r){myLoc = r;}

  public Room getLoc(){return myLoc;}

  public String showMyThings(){
   String outString = "";
   for (int n = 0; n < itemCount ; n++)
     outString = outString + Integer.toString(n+1) + ": " 
       + myThings[n].getDesc() + " ";
   return outString;
  }
  public Item[] showMyThingsArray(){
      Item[] toReturn = new Item[itemCount];
      for(int i=0; i<itemCount; i++){
          toReturn[i] = myThings[i];
      }
      return toReturn;
  }

  public boolean handsFull(){return itemCount==2;}

  public boolean handsEmpty(){return itemCount==0;}

  public int numItemsCarried(){return itemCount;}

}
