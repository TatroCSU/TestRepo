//Eli Tatro, Ben Hamor, Hunter Zhang, Caity Corcoran
package cs314_A4;

/** 
 
     Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac cs314_A1.AdventureGame.java
     To run:     java cs314_A1.AdventureGame

     The main routine is AdventureGame.main
				    
				    Sets and gets a string containing item description
**/

/** Ben Hamor, Feb 2, 2016
 * Added package name cs314_A1 to compile and run commands.  Added simple description to file.
 * @author bhamor
 *
 */


// class Item

public class Item {

  private String description;

  public void setDesc(String d){
      description = d;
  }

  public String getDesc(){
	     return description;
  }

}

