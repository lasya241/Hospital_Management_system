package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        // Title
        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 300, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);

        // Name
        JLabel label2 = new JLabel("Name:");
        label2.setBounds(25, 88, 150, 15);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Patient_Info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Room Number
        JLabel label3 = new JLabel("Room Number:");
        label3.setBounds(25, 129, 150, 15);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        // In-Time
        JLabel label4 = new JLabel("In-Time:");
        label4.setBounds(25, 174, 100, 15);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldINTIME = new JTextField();
        textFieldINTIME.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTIME);

        // Amount Paid
        JLabel label5 = new JLabel("Amount Paid (Rs):");
        label5.setBounds(25, 216, 150, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);

        // Pending Amount
        JLabel label6 = new JLabel("Pending Amount (Rs):");
        label6.setBounds(25, 261, 200, 14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);

        // CHECK Button
        JButton check = new JButton("CHECK");
        check.setBounds(100, 378, 100, 25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "SELECT * FROM Patient_Info WHERE Name='" + id + "'";
                try {
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery(q);
                    while (rs.next()) {
                        textFieldR.setText(rs.getString("Room_Number"));
                        textFieldINTIME.setText(rs.getString("Time"));
                        textFieldAmount.setText(rs.getString("Deposite"));
                    }

                    ResultSet rs2 = c.statement.executeQuery(
                            "SELECT * FROM room WHERE room_no='" + textFieldR.getText() + "'");
                    while (rs2.next()) {
                        String price = rs2.getString("Price");
                        int pending = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(String.valueOf(pending));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // UPDATE Button
        JButton update = new JButton("UPDATE");
        update.setBounds(220, 378, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTIME.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("UPDATE Patient_Info SET Room_Number='" + room + "', Time='" + time + "', Deposite='" + amount + "' WHERE Name='" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // BACK Button
        JButton back = new JButton("BACK");
        back.setBounds(340, 378, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}
