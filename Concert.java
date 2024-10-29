/**
 * Handles concert tickets
 */
public class Concert extends Ticket {
    // Stores if the ticket is for standing
    private boolean standing;
    // Stores if the ticket includes backstage access
    private boolean backstage;
    // Stores the name of the band
    private String bandName;

    // Constructor with seat information
    public Concert(String venue, char row, int seat, String sectionRow, boolean standing, boolean backstage, String bandName) {
        super(venue, row, seat, sectionRow);
        this.standing = standing;
        this.backstage = backstage;
        this.bandName = bandName;
    }

    // Constructor without seat information (for standing tickets)
    public Concert(String venue, boolean standing, boolean backstage, String bandName) {
        super(venue);
        this.standing = standing;
        this.backstage = backstage;
        this.bandName = bandName;
    }

    @Override
    public void adjustPrice() {
        double tempPrice = this.getPrice();
        if (standing) {
            tempPrice /= 2;  // Discount for standing tickets
        }
        if (backstage) {
            tempPrice *= 3;  // Increase for backstage access
        }
        this.setPrice(tempPrice);
    }

    // Returns if the ticket is for standing
    public boolean isStanding() {
        return standing;
    }

    // Returns the band name
    public String getBandName() {
        return bandName;
    }

    @Override
    public void getTicket() {
        System.out.println("Price: " + this.getPrice());
        System.out.println("Venue: " + this.getVenue());
        if (!standing) {
            System.out.println("Seat: " + this.getSectionRow());
        } else {
            System.out.println("Standing Ticket");
        }
        if (backstage) {
            System.out.println("Backstage Ticket");
        }
        System.out.println("Band Name: " + bandName);
    }

    @Override
    public String getTicketDetails() {
        StringBuilder details = new StringBuilder(super.getTicketDetails());
        details.append("Event Type: Concert\n");
        if (standing) {
            details.append("Standing Ticket\n");
        } else {
            details.append("Seat: ").append(this.getSectionRow()).append("\n");
        }
        if (backstage) {
            details.append("Backstage Access\n");
        }
        details.append("Band Name: ").append(bandName).append("\n");
        return details.toString();
    }
}