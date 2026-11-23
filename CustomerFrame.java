import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CustomerEntryFrame extends JFrame {

    private JLabel logoLabel, nameLabel, phoneLabel;
    private JTextField nameField, phoneField;
    private JButton startBtn;
    private JPanel formPanel;

    public CustomerEntryFrame() {
        super("Smart Cafe - Welcome");

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        Color cafeBeige = new Color(245, 235, 224);
        Color espressoBrown = new Color(75, 46, 30);
        getContentPane().setBackground(cafeBeige);

        Icon logoIcon = new ImageIcon("logo.png");
        logoLabel = new JLabel("Welcome to Smart Cafe", logoIcon, SwingConstants.CENTER);
        logoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        logoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        logoLabel.setForeground(espressoBrown);
        logoLabel.setToolTipText("Cafe Official Logo");
        add(logoLabel);

        formPanel = new JPanel(new GridLayout(2, 2, 10, 15));
        formPanel.setBackground(cafeBeige);

        nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(espressoBrown);
        nameField = new JTextField(15);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 14));
        phoneLabel.setForeground(espressoBrown);
        phoneField = new JTextField(15);

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);

        add(formPanel);

        startBtn = new JButton("Start Order ->");
        startBtn.setFont(new Font("Arial", Font.BOLD, 14));
        startBtn.setBackground(espressoBrown);
        startBtn.setForeground(Color.WHITE);
        startBtn.setToolTipText("Click to open the menu");
        add(startBtn);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = nameField.getText();
                String customerPhone = phoneField.getText();

                if (customerName.isEmpty() || customerPhone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both Name and Phone Number!");
                } else {
                    JOptionPane.showMessageDialog(null, "Welcome " + customerName + "! Moving to Menu...");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerEntryFrame();
    }
}
