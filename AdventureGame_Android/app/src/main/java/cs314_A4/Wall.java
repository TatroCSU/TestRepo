//Eli Tatro, Ben Hamor, Hunter Zhang, Caity Corcoran
package cs314_A4;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac cs314_A1.AdventureGame.java
     To run:     java cs314_A1.AdventureGame

     The main routine is AdventureGame.main
     
     Returns a message when the player attempts to move and walks into a wall.
				    
**/

/** Ben Hamor, Feb 2, 2016
 * Added package name cs314_A1 to compile and run commands.  Added simple description to file.
 * @author bhamor
 *
 */

// class Wall



public class Wall implements CaveSite {

 public String enter(Player p){
   //System.out.println("Ouch! That hurts.");
	 System.out.println("Ouch!  That hurts.");
	 return "Ouch! That hurts. \n";
 }

}
