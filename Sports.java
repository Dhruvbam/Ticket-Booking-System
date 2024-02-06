/**
 * Handles tickets to sporting events
 */
public class Sports extends Ticket {
	//If ticket is for on-field spot
    private boolean onField;
    //Stores sport ticket is for
    private String sport;

    //Constructor 1
    public Sports(String venue, char row, int seat, String sectionRow, 
    		boolean onField, String sport) {
        super(venue, row, seat, sectionRow);
        this.sport = sport;
        this.onField = onField;
    }
    
    //Constructor 2
    public Sports(String venue, boolean onField, String sport) {
  super(venue);
  this.sport = sport;
  this.onField = onField;
}

    @Override
    public void adjustPrice() {
    	double tempPrice = this.getPrice();
    	if(this.getField()){
    		tempPrice *= 3;
      }
      this.setPrice(tempPrice);
    }

    /*
     * Returns sport
     */
    public String getSport() {
        return sport;
    }
    
    /*
     * Returns if ticket is on field
     */
    public boolean getField() {
    	return onField;
    }
    
    @Override
    public void getTicket() {
    	System.out.println("Price: " + this.getPrice());
    	System.out.println("Venue: " + this.getVenue());
    	if(!onField) {
    		System.out.println("Seat: " + this.getSectionRow());
    	}
    	else {
    		System.out.println("On Field Ticket");
    	}
    	System.out.println("Sport Name: " + sport);
    }
}
