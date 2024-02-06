/**
 * Handles concert tickets
 */
public class Concert extends Ticket {
	//Stores if standing ticket
    private boolean standing;
    //Stores if backstage ticket
    private boolean backstage;
    //Stores band name
    private String bandName;

    //Constructor
    public Concert(String venue, char row, int seat, String sectionRow, boolean standing, boolean backStage, String band) {
        super(venue, row, seat, sectionRow);
        this.standing = standing;
        this.backstage = backStage;
        this.bandName = band;
    }
    
    //Constructor
    public Concert(String venue, boolean standing, boolean backStage, String band) {
        super(venue);
        this.standing = standing;
        this.backstage = backStage;
        this.bandName = band;
    }

    @Override
    public void adjustPrice() {
        double tempPrice = this.getPrice();
        if(standing) {
        	tempPrice /= 2;
        }
        if(backstage) {
        	tempPrice *= 3;
        }
        this.setPrice(tempPrice);
    }

    /*
     * Returns if ticket is standing
     */
    public boolean getStanding() {
    	return standing;
    }
    
    /*
     * Returns band name
     */
    public String getBandName() {
    	return bandName;
    }
    
    @Override
    public void getTicket() {
    	System.out.println("Price: " + this.getPrice());
    	System.out.println("Venue: " + this.getVenue());
    	if(!standing) {
    		System.out.println("Seat: " + this.getSectionRow());
    	}
    	else {
    		System.out.println("Standing Ticket");
    	}
    	if(backstage) {
    		System.out.println("Backstage Ticket");
    	}
    	System.out.println("Band Name: " + bandName);
    }
}