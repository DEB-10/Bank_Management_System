package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3,button4;
    Login(){
        super("Bank Management System");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ba.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);


        label1=new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Lato",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2= new JLabel("Card No:");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.BLACK);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2=new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        label3=new JLabel("PIN:");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.BLACK);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3=new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        button1=new JButton("SIGN IN");
        button1.setFont(new Font("arial",Font.BOLD,14));
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(new Color(30, 30, 30)
                );  // Change color on hover
                button1.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(Color.LIGHT_GRAY);
                button1.setForeground(Color.BLACK);
            }
        });
        add(button1);

        button2=new JButton("CLEAR");
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.LIGHT_GRAY);
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setBackground(new Color(30, 30, 30)
                );  // Change color on hover
                button2.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button2.setBackground(Color.LIGHT_GRAY);
                button2.setForeground(Color.BLACK);
            }
        });
        add(button2);

        button3= new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.LIGHT_GRAY);
        button3.setBounds(300,350,100,30);
        button3.addActionListener(this);
        button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button3.setBackground(new Color(30, 30, 30)
                );  // Change color on hover
                button3.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button3.setBackground(Color.LIGHT_GRAY);  // Restore original color
                button3.setForeground(Color.BLACK);
            }
        });
        add(button3);

        button4= new JButton("EXIT");
        button4.setFont(new Font("Arial",Font.BOLD,14));
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.LIGHT_GRAY);
        button4.setBounds(427,350,100,30);
        button4.addActionListener(this);
        button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button4.setBackground(new Color(30, 30, 30)
                );
                button4.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button4.setBackground(Color.LIGHT_GRAY);
                button4.setForeground(Color.BLACK);
            }
        });
        add(button4);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("fire.png"));
        Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setUndecorated(true);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1) {
                if (textField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                } else {
                    Con c = new Con();
                    String cardno = textField2.getText();
                    String pin = passwordField3.getText();
                    String q = "select * from login where card_number = '" + cardno + "' and pin = '" + pin + "'";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    if (resultSet.next()) {
                        setVisible(false);
                        new main_Class(pin);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                }
            }
            else if(e.getSource()==button2){
                textField2.setText("");
                passwordField3.setText("");
            }
            else if(e.getSource()==button3){
                new signup();
                setVisible(false);
            }else if(e.getSource()==button4){
                System.exit(0);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
