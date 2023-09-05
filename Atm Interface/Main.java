import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private double balance = 1000.0; // Initial balance for the account
    private String currentUserRole = "Guest"; // Default role

    private JTextField amountField;
    private JTextArea displayArea;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton checkBalanceButton;
    private JButton manageUsersButton;
    private JButton changeSettingsButton;
    private JButton logoutButton; // Add a Logout button

    public Main() {
        // Set up the JFrame
        setTitle("ATM Interface");
        setSize(1000, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField(10);
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        checkBalanceButton = new JButton("Check Balance");
        manageUsersButton = new JButton("Manage Users");
        changeSettingsButton = new JButton("Change Settings");
        logoutButton = new JButton("Logout"); // Create a Logout button

        displayArea = new JTextArea(5, 20);
        displayArea.setEditable(false);

        // Add components to the JFrame
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(manageUsersButton);
        panel.add(changeSettingsButton);
        panel.add(logoutButton); // Add the Logout button

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Action listeners for buttons
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = getAmountFromField();
                withdraw(amount);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = getAmountFromField();
                deposit(amount);
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBalance();
            }
        });

        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUserRole.equals("Admin")) {
                    // Implement user management logic for Admin
                    JOptionPane.showMessageDialog(Main.this, "User management option for Admin.");
                } else {
                    JOptionPane.showMessageDialog(Main.this, "You do not have permission for this action.");
                }
            }
        });

        changeSettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUserRole.equals("Admin")) {
                    // Implement system settings change for Admin
                    JOptionPane.showMessageDialog(Main.this, "Change settings option for Admin.");
                } else {
                    JOptionPane.showMessageDialog(Main.this, "You do not have permission for this action.");
                }
            }
        });

        // Action listener for Logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        // Simulate user login with a dialog (replace with your authentication logic)
        loginDialog();
    }

    private void loginDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {
            "Username:", usernameField,
            "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(
            this, message, "Login", JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Simplified authentication (replace with your authentication logic)
            if (username.equals("admin") && new String(password).equals("adminpass")) {
                currentUserRole = "Admin";
            } else if (username.equals("user") && new String(password).equals("userpass")) {
                currentUserRole = "RegularUser";
            } else {
                currentUserRole = "Guest";
            }

            applyRBAC();
        }
    }

    private void applyRBAC() {
        // Disable or enable buttons based on the user's role
        if (currentUserRole.equals("Admin")) {
            withdrawButton.setEnabled(true);
            depositButton.setEnabled(true);
            checkBalanceButton.setEnabled(true);
            manageUsersButton.setEnabled(true);
            changeSettingsButton.setEnabled(true);
            logoutButton.setEnabled(true); // Enable Logout for Admin
        } else if (currentUserRole.equals("RegularUser")) {
            withdrawButton.setEnabled(true);
            depositButton.setEnabled(true);
            checkBalanceButton.setEnabled(true);
            manageUsersButton.setEnabled(false);
            changeSettingsButton.setEnabled(false);
            logoutButton.setEnabled(true); // Enable Logout for RegularUser
        } else {
            withdrawButton.setEnabled(false);
            depositButton.setEnabled(false);
            checkBalanceButton.setEnabled(true);
            manageUsersButton.setEnabled(false);
            changeSettingsButton.setEnabled(false);
            logoutButton.setEnabled(true); // Disable Logout for Guest
        }
    }

    private double getAmountFromField() {
        try {
            return Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.");
            return 0.0;
        }
    }

    private void withdraw(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid amount.");
        } else if (amount > balance) {
            JOptionPane.showMessageDialog(this, "Insufficient balance.");
        } else {
            balance -= amount;
            displayBalance();
        }
    }

    private void deposit(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid amount.");
        } else {
            balance += amount;
            displayBalance();
        }
    }

    private void displayBalance() {
        displayArea.setText("Current Balance: $" + balance);
    }

    private void logout() {
        // Reset the user role to Guest
        currentUserRole = "Guest";

        // Disable all buttons except the login button
        withdrawButton.setEnabled(false);
        depositButton.setEnabled(false);
        checkBalanceButton.setEnabled(false);
        manageUsersButton.setEnabled(false);
        changeSettingsButton.setEnabled(false);
        logoutButton.setEnabled(false);

        // Clear the display area
        displayArea.setText("Logged out.");
        
        // Show login dialog again
        loginDialog();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
