public abstract class Ticket {
    // Default price for all tickets
    private double price = 35.0;
    // Name of venue
    private String venue;
    // Stores seat row
    private char row;
    // Stores seat number
    private int seat;
    // Stores seat
    private String sectionRow;
    // Contains number of existing tickets
    public static int numTickets;

    // Constructor with seat information
    public Ticket(String venue, char row, int seat, String sectionRow) {
        this.venue = venue;
        this.row = row;
        this.seat = seat;
        this.sectionRow = sectionRow;
        numTickets++;
    }

    // Constructor without seat information (for standing tickets)
    public Ticket(String venue) {
        this.venue = venue;
        numTickets++;
    }

    // Returns the price
    public double getPrice() {
        return price;
    }

    // Sets the price
    public void setPrice(double p) {
        price = p;
    }

    // Returns the venue
    public String getVenue() {
        return venue;
    }

    // Returns the seat
    public String getSectionRow() {
        return sectionRow;
    }

    // Abstract method to adjust price in subclasses
    public abstract void adjustPrice();

    // Abstract method to print specific ticket information
    public abstract void getTicket();

    // Method to return detailed ticket information as a string
    public String getTicketDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Venue: ").append(venue).append("\n");
        details.append("Price: $").append(price).append("\n");
        if (sectionRow != null && !sectionRow.isEmpty()) {
            details.append("Seat: ").append(sectionRow).append("\n");
        } else {
            details.append("Standing Ticket\n");
        }
        return details.toString();
    }
}