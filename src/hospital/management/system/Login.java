package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {
        setTitle("Hospital Management Login");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(109, 164, 170));
        setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(109, 164, 170));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image scaledImage = icon.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(logoLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(109, 164, 170));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel namelabel = new JLabel("Username:");
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(namelabel, gbc);

        textField = new JTextField(18);
        textField.setFont(new Font("Tahoma", Font.BOLD, 17));
        textField.setBackground(new Color(255, 179, 0));
        gbc.gridx = 1;
        formPanel.add(textField, gbc);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(password, gbc);

        jPasswordField = new JPasswordField(18);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jPasswordField.setBackground(new Color(255, 179, 0));
        gbc.gridx = 1;
        formPanel.add(jPasswordField, gbc);

        b1 = new JButton("Login");
        b1.setFont(new Font("serif", Font.BOLD, 20));
        b1.setPreferredSize(new Dimension(140, 40));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(b1, gbc);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("serif", Font.BOLD, 20));
        b2.setPreferredSize(new Dimension(140, 40));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        gbc.gridx = 1;
        formPanel.add(b2, gbc);

        mainPanel.add(formPanel);

        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        add(mainPanel, frameGbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = new String(jPasswordField.getPassword());

                String q = "SELECT * FROM login WHERE ID = '" + user + "' AND PW = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            System.exit(0);
        }
    }
}
