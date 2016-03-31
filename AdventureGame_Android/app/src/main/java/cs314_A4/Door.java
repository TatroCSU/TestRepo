//Eli Tatro, Ben Hamor, Hunter Zhang, Caity Corcoran 
package cs314_A4;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac cs314_A1.AdventureGame.java
     To run:     java cs314_A1.AdventureGame

     The main routine is AdventureGame.main
				    
**/

/** Ben Hamor, Feb 2, 2016
 * Added package name cs314_A1 to compile and run commands.
 * @author bhamor
 *
 */

// class Door

public class Door implements CaveSite {
  /** In this implementation doors are always locked.
      A player must have the correct key to get through
      a door.  Doors automatically lock after a player
      passes through. */

  private Key myKey;

  /** The door's location. */
  private CaveSite outSite;
  private CaveSite inSite;

  /** We can construct a door at the site. */
 public Door(CaveSite out, CaveSite in, Key k){
    outSite = out;
    inSite = in;
    myKey = k;
  }

 public void setOutSite(CaveSite out){
     outSite = out;
 }

 public void setInSite(CaveSite in){
     inSite = in;
 }

 public CaveSite getInSite(){
     return inSite;
 }
 public CaveSite getOutSite(){
     return outSite;
 }

 /** A player will need the correct key to enter. */
 public String enter(Player p){
	 String retVal;
	 if (p.haveItem(myKey)) {
	     retVal = "Your key works! The door creaks open, \nand slams behind you after you pass through. \n";
	    if (p.getLoc() == outSite){
            inSite.enter(p);
        }
	    else if (p.getLoc() == inSite){
            outSite.enter(p);
        }
	    
	 }
	 else {
		 retVal = "You don't have the key for this door! \nSorry. \n";
	 }
	 System.out.println(retVal);
	 return retVal;
 }

}

