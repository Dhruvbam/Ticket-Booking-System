/**
 * Handles theater tickets
 */
public class Theater extends Ticket {
    // Indicates if the ticket is for a standing area
    private boolean standing;
    // Indicates if the ticket includes backstage access
    private boolean backstage;
    // Stores the name of the show
    private String show;

    // Constructor with seat information
    public Theater(String venue, char row, int seat, String sectionRow, boolean standing, boolean backstage, String show) {
        super(venue, row, seat, sectionRow);
        this.standing = standing;
        this.backstage = backstage;
        this.show = show;
    }

    // Constructor without seat information (for standing tickets)
    public Theater(String venue, boolean standing, boolean backstage, String show) {
        super(venue);
        this.standing = standing;
        this.backstage = backstage;
        this.show = show;
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

    // Returns if the ticket is for a standing area
    public boolean isStanding() {
        return standing;
    }

    // Returns the show name
    public String getShow() {
        return show;
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
        System.out.println("Show Name: " + show);
    }

    @Override
    public String getTicketDetails() {
        StringBuilder details = new StringBuilder(super.getTicketDetails());
        details.append("Event Type: Theater\n");
        if (standing) {
            details.append("Standing Ticket\n");
        } else {
            details.append("Seat: ").append(this.getSectionRow()).append("\n");
        }
        if (backstage) {
            details.append("Backstage Access\n");
        }
        details.append("Show Name: ").append(show).append("\n");
        return details.toString();
    }
}