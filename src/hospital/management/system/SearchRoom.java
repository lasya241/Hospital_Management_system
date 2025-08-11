package hospital.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel forLabel = new JLabel("Search for Room");
        forLabel.setBounds(250, 20, 200, 25);
        forLabel.setForeground(Color.white);
        forLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(forLabel);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(70, 70, 80, 20);
        statusLabel.setForeground(Color.white);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(statusLabel);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 187, 700, 210);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(23, 162, 150, 20);
        roomNo.setForeground(Color.white);
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(roomNo);

        JLabel available = new JLabel("Availability");
        available.setBounds(175, 162, 150, 20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(458, 162, 150, 20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(580, 162, 150, 20);
        bed.setForeground(Color.white);
        bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bed);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(200, 420, 120, 25);
        searchBtn.setBackground(Color.BLACK);
        searchBtn.setForeground(Color.WHITE);
        panel.add(searchBtn);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '" + choice.getSelectedItem() + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(380, 420, 120, 25);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        panel.add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(450, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
