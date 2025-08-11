package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JTextField usernameField, emailField, phoneField;
    JPasswordField passwordField, confirmPasswordField;
    JButton signupButton, cancelButton;

    Signup() {
        setTitle("Hospital Management Sign Up");
        setSize(750, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(118, 231, 130));
        setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(118, 231, 130));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Logo
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/Medical center logo.png"));
        Image scaledImage = icon.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(logoLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(118, 231, 130));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);

        usernameField = new JTextField(18);
        usernameField.setFont(new Font("Tahoma", Font.BOLD, 17));
        usernameField.setBackground(Color.WHITE);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(emailLabel, gbc);

        emailField = new JTextField(18);
        emailField.setFont(new Font("Tahoma", Font.BOLD, 17));
        emailField.setBackground(Color.WHITE);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(phoneLabel, gbc);

        phoneField = new JTextField(18);
        phoneField.setFont(new Font("Tahoma", Font.BOLD, 17));
        phoneField.setBackground(Color.WHITE);
        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(18);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        passwordField.setBackground(Color.WHITE);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        // Confirm Password
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(confirmPasswordLabel, gbc);

        confirmPasswordField = new JPasswordField(18);
        confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        confirmPasswordField.setBackground(Color.WHITE);
        gbc.gridx = 1;
        formPanel.add(confirmPasswordField, gbc);

        // Buttons
        signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("serif", Font.BOLD, 20));
        signupButton.setPreferredSize(new Dimension(140, 40));
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(signupButton, gbc);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("serif", Font.BOLD, 20));
        cancelButton.setPreferredSize(new Dimension(140, 40));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        gbc.gridx = 1;
        formPanel.add(cancelButton, gbc);

        mainPanel.add(formPanel);

        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        add(mainPanel, frameGbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
                return;
            }

            try {
                conn c = new conn();
                String query = "INSERT INTO login (ID, PW, Email, Phone) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + phone + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Sign Up Successful! Please log in.");
                setVisible(false);
                new Login();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error during sign up.");
            }

        } else if (e.getSource() == cancelButton) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
