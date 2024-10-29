/**
 * Handles tickets to sporting events
 */
public class Sports extends Ticket {
    // Indicates if the ticket is for an on-field spot
    private boolean onField;
    // Stores the type of sport
    private String sport;

    // Constructor with seat information
    public Sports(String venue, char row, int seat, String sectionRow, boolean onField, String sport) {
        super(venue, row, seat, sectionRow);
        this.onField = onField;
        this.sport = sport;
    }

    // Constructor without seat information (for on-field tickets)
    public Sports(String venue, boolean onField, String sport) {
        super(venue);
        this.onField = onField;
        this.sport = sport;
    }

    @Override
    public void adjustPrice() {
        double tempPrice = this.getPrice();
        if (onField) {
            tempPrice *= 3;  // Increase for on-field tickets
        }
        this.setPrice(tempPrice);
    }

    // Returns the type of sport
    public String getSport() {
        return sport;
    }

    // Returns if the ticket is for an on-field spot
    public boolean isOnField() {
        return onField;
    }

    @Override
    public void getTicket() {
        System.out.println("Price: " + this.getPrice());
        System.out.println("Venue: " + this.getVenue());
        if (!onField) {
            System.out.println("Seat: " + this.getSectionRow());
        } else {
            System.out.println("On-Field Ticket");
        }
        System.out.println("Sport Type: " + sport);
    }

    @Override
    public String getTicketDetails() {
        StringBuilder details = new StringBuilder(super.getTicketDetails());
        details.append("Event Type: Sports\n");
        if (onField) {
            details.append("On-Field Ticket\n");
        } else {
            details.append("Seat: ").append(this.getSectionRow()).append("\n");
        }
        details.append("Sport Type: ").append(sport).append("\n");
        return details.toString();
    }
}