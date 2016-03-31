//Eli Tatro, Ben Hamor, Hunter Zhang, Caity Corcoran
package cs314_A4;

public class AdventureGameModelFacade {
	private Player thePlayer;
	private Adventure theCave;
	private Room startRm;
	private String extra;
	private Item[] roomContents;
	
	
  public AdventureGameModelFacade() { // we initialize
	  thePlayer = new Player();
	  theCave = new Adventure();
	  startRm = theCave.createAdventure();
	  thePlayer.setRoom(startRm);	
	  extra = "";
  }

  public void goUp(){
	  extra = thePlayer.go(4);
  }

  public void goDown(){
	  extra = thePlayer.go(5);
    }

  public void goNorth(){
	  extra = thePlayer.go(0);
    }
      
  public void goSouth(){
	  extra = thePlayer.go(1);
    }

  public void goEast(){
	  extra = thePlayer.go(2);
    }
      
  public void goWest(){
	  extra = thePlayer.go(3);
    }

  // You need to finish these getView and getItems methods.
  public String getView(){ 
	  return(extra + thePlayer.look());
     }

  public String getItems(){
	  return("You are carying: " + thePlayer.showMyThings());
  }

  public String[] getContents(){
	  Item[] contentsArray = thePlayer.getLoc().getRoomContents();
	  String[] toReturn = new String[contentsArray.length];
	  for(int i=0; i<contentsArray.length; i++){
		  toReturn[i] = contentsArray[i].getDesc();
	  }
	  return toReturn;
  }

  public String[] getHands(){
	  Item[] contentsArray = thePlayer.showMyThingsArray();
	  String[] toReturn = new String[contentsArray.length];
	  for(int i=0; i<contentsArray.length; i++){
		  toReturn[i] = contentsArray[i].getDesc();
	  }
	  return toReturn;
  }
  
  public void pickupItem(int itemID){
	  roomContents = thePlayer.getLoc().getRoomContents();
	  extra ="";
	  
	  if(roomContents.length==0){
		  extra+= "The Room is empty \n"; 
	  }
	  if(itemID>roomContents.length || itemID<1){
		  extra += "That Item is not in the room \n";
	  } 
	  if(thePlayer.numItemsCarried()>=2){
		  extra += "Your hands are full"; 
	  }
	  if(thePlayer.numItemsCarried()<2){ 
		  if(roomContents.length>=itemID && itemID>0){
			  thePlayer.pickUp(roomContents[itemID-1]);
		  }
	  }
  }
  public void dropItem(int itemID){
	  extra ="";

	  roomContents =thePlayer.getLoc().getRoomContents();
	  if(thePlayer.numItemsCarried()<itemID){
		  extra += "You do not have that item to drop.\n";
	  }
	  if(roomContents.length>=2){
		  extra = "You know that Giant Cave you are in? Well..."
		  		+ "There is not enough room on the floor... To put down your item.\n";
	  }
	  if(thePlayer.numItemsCarried()>=1 && itemID!=0 && itemID<=thePlayer.numItemsCarried()){
		  thePlayer.drop(itemID);
	  }

  }

}
