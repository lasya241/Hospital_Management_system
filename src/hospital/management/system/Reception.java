package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame {

    Reception() {
        setTitle("Hospital Reception");
        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setBounds(5, 160, screenSize.width - 10, screenSize.height - 200);
        panel.setBackground(new Color(118, 231, 130));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(118, 231, 130));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Medical center logo.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(1300, -60, 250, 250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(970,30,300,100);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30, 15, 200, 30);
        panel1.add(btn1);
        btn1.addActionListener(e -> new NewPatient());

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 200, 30);
        panel1.add(btn2);
        btn2.addActionListener( e -> new Room());

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 200, 30);
        panel1.add(btn3);
        btn3.addActionListener(e -> new Department());

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270, 15, 200, 30);
        panel1.add(btn4);
        btn4.addActionListener(e -> new Employee_info());

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270, 58, 200, 30);
        panel1.add(btn5);
        btn5.addActionListener(e -> new ALL_Patient_Info());

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270, 100, 200, 30);
        panel1.add(btn6);
        btn6.addActionListener(e -> new patient_discharge());

        JButton btn7 = new JButton("Update Patient Detail");
        btn7.setBounds(510, 15, 200, 30);
        panel1.add(btn7);
        btn7.addActionListener(e -> new update_patient_details());

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(510, 58, 200, 30);
        panel1.add(btn8);
        btn8.addActionListener(e -> new Ambulance());

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510, 100, 200, 30);
        panel1.add(btn9);
        btn9.addActionListener(e -> new SearchRoom());

        JButton btn10 = new JButton("Log out");
        btn10.setBounds(750, 15, 200, 30);
        panel1.add(btn10);
        btn10.addActionListener(e -> {
            dispose();
            new Login();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
