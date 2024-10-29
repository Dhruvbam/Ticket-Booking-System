import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserInterface {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JComboBox<String> eventTypeComboBox;
    private JTextField venueField, rowField, seatField, eventNameField;
    private JCheckBox standingCheckBox, backstageCheckBox;
    private JTextArea ticketsDisplay;
    private ArrayList<Ticket> tickets;

    public UserInterface() {
        tickets = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        mainFrame = new JFrame("Ticket Booking System");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Ticket Booking System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Event Type:"));
        eventTypeComboBox = new JComboBox<>(new String[]{"Theater", "Concert", "Sports"});
        inputPanel.add(eventTypeComboBox);

        inputPanel.add(new JLabel("Venue:"));
        venueField = new JTextField();
        inputPanel.add(venueField);

        inputPanel.add(new JLabel("Row (if applicable):"));
        rowField = new JTextField();
        inputPanel.add(rowField);

        inputPanel.add(new JLabel("Seat Number (if applicable):"));
        seatField = new JTextField();
        inputPanel.add(seatField);

        inputPanel.add(new JLabel("Event Name:"));
        eventNameField = new JTextField();
        inputPanel.add(eventNameField);

        standingCheckBox = new JCheckBox("Standing Ticket");
        backstageCheckBox = new JCheckBox("Backstage Pass");
        inputPanel.add(standingCheckBox);
        inputPanel.add(backstageCheckBox);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton purchaseButton = new JButton("Purchase Ticket");
        JButton viewTicketsButton = new JButton("View Tickets");

        purchaseButton.addActionListener(new PurchaseButtonListener());
        viewTicketsButton.addActionListener(new ViewTicketsButtonListener());

        buttonPanel.add(purchaseButton);
        buttonPanel.add(viewTicketsButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private class PurchaseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String eventType = (String) eventTypeComboBox.getSelectedItem();
            String venue = venueField.getText();
            char row = rowField.getText().isEmpty() ? ' ' : rowField.getText().charAt(0);
            int seat = seatField.getText().isEmpty() ? 0 : Integer.parseInt(seatField.getText());
            String eventName = eventNameField.getText();
            boolean standing = standingCheckBox.isSelected();
            boolean backstage = backstageCheckBox.isSelected();

            if (venue.isEmpty() || eventName.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Please fill in all required fields.");
                return;
            }

            Ticket ticket;
            if ("Theater".equals(eventType)) {
                ticket = new Theater(venue, row, seat, "" + row + seat, standing, backstage, eventName);
            } else if ("Concert".equals(eventType)) {
                ticket = new Concert(venue, row, seat, "" + row + seat, standing, backstage, eventName);
            } else {
                ticket = new Sports(venue, row, seat, "" + row + seat, standing, eventName);
            }

            ticket.adjustPrice();
            tickets.add(ticket);
            JOptionPane.showMessageDialog(mainFrame, "Ticket purchased successfully! Price: $" + ticket.getPrice());
        }
    }

    private class ViewTicketsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame ticketsFrame = new JFrame("Purchased Tickets");
            ticketsFrame.setSize(400, 300);

            ticketsDisplay = new JTextArea(10, 30);
            ticketsDisplay.setEditable(false);
            for (int i = 0; i < tickets.size(); i++) {
                ticketsDisplay.append("Ticket #" + (i + 1) + ":\n" + tickets.get(i).getTicketDetails() + "\n\n");
            }

            JScrollPane scrollPane = new JScrollPane(ticketsDisplay);
            ticketsFrame.add(scrollPane);
            ticketsFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInterface());
    }
}