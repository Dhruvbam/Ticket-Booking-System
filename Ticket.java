/**
 * General ticket information
 */
public abstract class Ticket {
	//Default price for all tickets
    private double price = 35;
    //Name of venue
    private String venue;
    //Stores seat row
    private char row;
    //Stores seat number
    private int seat;
    //Stores seat
    private String sectionRow;
    //Contains number of existing tickets
    public static int numTickets;

    //Constructor
    public Ticket(String venue, char row, int seat, String sectionRow) {
        this.venue = venue;
        this.row = row;
        this.seat = seat;
        this.sectionRow = sectionRow;
        numTickets++;
    }
    
    //Constructor
    public Ticket(String venue) {
        this.venue = venue;
        numTickets++;
    }

    //Returns the price
    public double getPrice() {
        return price;
    }
    
    //Returns the venue
    public String getVenue() {
    	return venue;
    }
    
    //Returns the seat
    public String getSectionRow() {
    	return sectionRow;
    }

    //Allows price to be changed
    public void setPrice(double p) {
    	price = p;
    }

    /*
     * Adjusts price using input variables for each specific ticket type
     */
    public abstract void adjustPrice();
    /*
     * Prints specific information about each ticket
     */
    public abstract void getTicket();
}