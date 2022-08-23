package Manager;

import Manager.TextPrompt.TextPrompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame implements ActionListener {
    JTextField username_field;
    JPasswordField password_field;
    JLabel nameLabel;
    JLabel passwordLabel;
    JButton Login;

    JButton Register;
    JLabel heading;
    ImageIcon background;
    JLabel gif;
    JButton ps;
    boolean tr =true;
    Icon seye = new ImageIcon("images/32.png");
    ImageIcon heye = new ImageIcon("images/hic.png");


    LoginFrame() {
        JLayeredPane f1 = getLayeredPane();
        setTitle("Admin Login");
        setLocation(280,90);
        setSize(1150,625);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setVisible(true);
        heading = new JLabel("Admin Login");
        heading.setSize(220, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        heading.setLocation(820, 95);
        heading.setForeground(Color.BLACK);
        heading.setVisible(true);

        nameLabel = new JLabel();
        nameLabel.setIcon(new ImageIcon("images/username_icon.png"));
        nameLabel.setSize(40, 25);
        nameLabel.setLocation(700, 180);
        nameLabel.setVisible(true);

        username_field = new JTextField();
        username_field.setSize(300, 40);
        username_field.setFont(new Font("Arial", Font.BOLD, 16));
        username_field.setLocation(780, 180);
        username_field.setVisible(true);
        username_field.setToolTipText(" Enter Username");
        TextPrompt tp7 = new TextPrompt("Enter Username",username_field);
        tp7.setForeground(Color.LIGHT_GRAY);


        //Button to show/hide password
        ps = new JButton(seye);
        ps.setLocation(1030,258);
        ps.setOpaque(false);
        ps.setBorderPainted(false);
        ps.setContentAreaFilled(false);
        ps.setSize(32,24);
        ps.setVisible(true);
        ps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tr){
                    password_field.setEchoChar((char)0);
                    ps.setIcon(heye);
                    f1.repaint();
                    tr = false;
                }
                else{
                    password_field.setEchoChar((Character)  UIManager.get("PasswordField.echoChar"));
                    ps.setIcon(seye);
                    f1.repaint();
                    tr = true;
                }
            }
        });

        passwordLabel = new JLabel("Passsword");
        passwordLabel.setSize(80, 40);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setLocation(680, 250);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setVisible(true);

        password_field = new JPasswordField();
        password_field.setSize(300, 40);
        password_field.setFont(new Font("Arial", Font.BOLD, 16));
        password_field.setLocation(780, 250);
        password_field.setVisible(true);
        password_field.setToolTipText(" Enter password");
        TextPrompt tp8 = new TextPrompt("Enter Password",password_field);
        tp8.setForeground(Color.LIGHT_GRAY);

        Login = new JButton("Login");
        Login.setFont(new Font("Arial", Font.BOLD, 14));
        Login.setSize(140, 50);
        Login.setBackground(new Color(30,144,255));
        Login.setForeground(Color.WHITE);
        Login.setLocation(780, 320);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Login){
                    String username = username_field.getText();
                    String password = password_field.getText();
                    framesecond(username, password);
                }
            }

        });
        Register=new JButton("Register");
        Register.setFont(new Font("Arial", Font.BOLD, 14));
        Register.setSize(145, 50);
        Register.setBackground(new Color(255,99,71));
        Register.setForeground(Color.WHITE);
        Register.setLocation(950, 320);
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Register){
                    try {
                        new Registration();
                    } catch (PrinterException printerException) {
                        printerException.printStackTrace();
                    }
                } else {

                    JOptionPane.showMessageDialog(null,

                            "Something went wrong!");

                }
            }
        });
        background =new ImageIcon("images/image.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(900,650,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backs=new JLabel(background);
        backs.setLayout(null);
        backs.setBounds(600,19,550,625);

        gif=new JLabel();
        gif.setIcon(new ImageIcon("images/round.gif"));
        gif.setSize(650,605);
        gif.setLocation(0,20);



        f1.setLayout(null);
        f1.setLocation(300,90);
        f1.setVisible(true);
        f1.add(heading);
        f1.add(nameLabel);
        f1.add(username_field);
        f1.add(passwordLabel);
        f1.add(password_field,1);
        f1.add(Login);
        f1.add(Register);
        f1.add(ps, Integer.valueOf(3));
        f1.add(backs);
        f1.add(gif);
        setResizable(false);


    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        }catch(Exception e) {
            e.printStackTrace();
        }
        LoginFrame panel = new LoginFrame();
        panel.setVisible(true);
    }

    private void framesecond(String username, String password) {

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null,

                    "Username field is empty!");
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null,

                    "Password field is empty!");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                PreparedStatement ps = con.prepareStatement("Select username from users where username=? and password=?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    dispose();
                    new dashsample();

                } else {

                    JOptionPane.showMessageDialog(null,

                            "Incorrect email-Id or password..Try Again with correct detail");

                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
