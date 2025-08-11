package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(118, 231, 130));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Adhaar Card", "Voter ID", "Driving Licence"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(2, 45, 48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name:");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(118, 231, 130));
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(118, 231, 130));
        r2.setBounds(350, 191, 80, 15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);


        JLabel labelDeposite = new JLabel("Deposit:");
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        panel.add(textFieldDeposite);

        b1.setForeground(Color.white);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.white);
        panel.add(b2);

        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }
    public static void main(String args[]) {
        new NewPatient();
    }
}
