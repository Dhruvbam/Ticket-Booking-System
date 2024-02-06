/**
 * Handles theater tickets
 */
class Theater extends Ticket {
	//Standing audience
    private boolean standing;
    //Backstage ticket
    private boolean backstage;
    //Show name
    private String show;

    //Constructor
    public Theater(String venue, char row, int seat, String sectionRow, boolean standing, 
    		boolean backstage, String show) {
        super(venue, row, seat, sectionRow);
        this.standing = standing;
        this.show = show;
        this.backstage = backstage;
    }
    
    //Constructor
    public Theater(String venue, boolean standing, boolean backstage, String show) {
        super(venue);
        this.standing = standing;
        this.show = show;
        this.backstage = backstage;
    }
    
    @Override
    public void adjustPrice() {
    	double tempPrice = this.getPrice();
    	if(this.standing){
    		tempPrice /= 2;
      }
    	if(this.backstage) {
    		tempPrice *= 3;
    	}
      this.setPrice(tempPrice);
    }

    /*
     * Returns show name
     */
    public String getShow() {
        return show;
    }
    
    /*
     * Returns if standing audience or not
     */
    public boolean getStanding() {
    	return standing;
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
    	System.out.println("Show Name: " + show);
    }
}