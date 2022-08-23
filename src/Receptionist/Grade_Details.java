package Receptionist;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.*;
import javax.swing.*;

public class Grade_Details extends JFrame implements ActionListener {

    JTextField GN, BS, TA, HRA, PF, BN;
    JFrame c;
    JButton sub;
    JButton back;
    JButton Clear;


    public Grade_Details() {
        super("GRADE DETAILS");
        c = new JFrame();
        c.setBounds(300, 90, 900, 600);
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel  head = new JLabel("GRADE DETAILS");
        head.setFont(new Font("Arial", Font.BOLD, 35));
        head.setSize(300, 30);
        head.setLocation(300, 60);
        head.setForeground(Color.WHITE);

        JLabel L1 = new JLabel("Grade Name");
        L1.setFont(new Font("Arial", Font.BOLD, 14));
        L1.setSize(100, 22);
        L1.setLocation(250, 200);
        L1.setForeground(Color.white);
        c.add(L1);

        GN = new JTextField();
        GN.setFont(new Font("Arial", Font.BOLD, 13));
        GN.setSize(230, 30);
        GN.setLocation(400, 200);
        c.add(GN);


        JLabel L2 = new JLabel("Basic Pay");
        L2.setFont(new Font("Arial", Font.BOLD, 14));
        L2.setSize(100, 22);
        L2.setLocation(250, 250);
        L2.setForeground(Color.white);
        c.add(L2);

        BS = new JTextField();
        BS.setFont(new Font("Arial", Font.BOLD, 13));
        BS.setSize(230, 30);
        BS.setLocation(400, 250);
        c.add(BS);

        JLabel L3 = new JLabel("HRA");
        L3.setFont(new Font("Arial", Font.BOLD, 14));
        L3.setSize(100, 22);
        L3.setLocation(250, 300);
        L3.setForeground(Color.white);
        c.add(L3);

        HRA = new JTextField();
        HRA.setFont(new Font("Arial", Font.BOLD, 13));
        HRA.setSize(230, 30);
        HRA.setLocation(400, 300);
        c.add(HRA);

        JLabel L4 = new JLabel("TA");
        L4.setFont(new Font("Arial", Font.BOLD, 14));
        L4.setSize(100, 22);
        L4.setLocation(250, 350);
        L4.setForeground(Color.white);
        c.add(L4);

        TA = new JTextField("Ashmit Singh");
        TA.setFont(new Font("Arial", Font.BOLD, 13));
        TA.setSize(230, 30);
        TA.setLocation(400, 350);
        c.add(TA);

        JLabel L5 = new JLabel("PF");
        L5.setFont(new Font("Arial", Font.BOLD, 14));
        L5.setSize(100, 22);
        L5.setLocation(250, 400);
        L5.setForeground(Color.white);
        c.add(L5);


        PF = new JTextField();
        PF.setFont(new Font("Arial", Font.BOLD, 13));
        PF.setSize(230, 30);
        PF.setLocation(400, 400);
        c.add(PF);

        JLabel L6 = new JLabel("Bonus");
        L6.setFont(new Font("Arial", Font.BOLD, 14));
        L6.setSize(100, 22);
        L6.setLocation(250, 450);
        L6.setForeground(Color.white);
        c.add(L6);

        BN = new JTextField();
        BN.setFont(new Font("Arial", Font.BOLD, 13));
        BN.setSize(230, 30);
        BN.setLocation(400, 450);
        c.add(BN);

        sub = new JButton("SUBMIT");
        sub.setFont(new Font("Arial", Font.BOLD, 16));
        sub.setSize(100, 30);
        sub.setLocation(250, 525);
        sub.setBackground(new Color(255, 0, 0));
        sub.setForeground(new Color(255, 255, 255));
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sub) {

                    String Grade_Name = GN.getText();
                    String Basic = BS.getText();
                    String ta = TA.getText();
                    String hra = HRA.getText();
                    String pf = PF.getText();
                    String Bonus = BN.getText();


                    if (Grade_Name.isEmpty()) {
                        JOptionPane.showMessageDialog(null,

                                "Grade Name field is empty!");
                    } else if (Basic.isEmpty()) {
                        JOptionPane.showMessageDialog(null,

                                " Please Enter Basic Salary!");
                    } else if (ta.isEmpty()) {
                        JOptionPane.showMessageDialog(null,

                                " Please Enter TA!");
                    } else if (hra.isEmpty()) {
                        JOptionPane.showMessageDialog(null,

                                " Please Enter HRA!");
                    } else if (pf.isEmpty()) {
                        JOptionPane.showMessageDialog(null,

                                " Please Enter PF!");
                    } else if (Bonus.isEmpty()) {
                        JOptionPane.showMessageDialog(null,

                                " Please Enter Bonus!");
                    }
                    else{

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                            PreparedStatement ps = con.prepareStatement("insert into users values(id,?,?,?,?,?,?,?,?)");

                            ps.setString(1, Grade_Name);
                            ps.setString(2, Basic);
                            ps.setString(3, ta);
                            ps.setString(4, hra);
                            ps.setString(5, pf);
                            ps.setString(6, Bonus);
                            ps.executeUpdate();

                        } catch (ClassNotFoundException | SQLException classNotFoundException) {
                            JOptionPane.showMessageDialog(null, classNotFoundException.getMessage());
                        }
                    }
                }
            }

        });




        back = new JButton("< Back");
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setSize(100, 30);
        back.setLocation(20, 30);
        back.setBackground(new Color(220, 20, 60));
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    //  new Receptionist.LoginFrame();
                }
            }
        });

        Clear = new JButton("Clear");
        Clear.setFont(new Font("Arial", Font.BOLD, 16));
        Clear.setSize(100, 30);
        Clear.setLocation(470, 525);
        Clear.setBackground(new Color(255, 0, 0));
        Clear.setForeground(new Color(255, 255, 255));
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TA.print();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        ImageIcon background=new ImageIcon("images/image.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1050,850,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backs=new JLabel(background);
        backs.setLayout(null);
        backs.setBounds(0,0,900,600);

        c.add(head);
        c.add(Clear);
        c.add(sub);
        c.add(backs);
        c.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
    public static void main(String[] args){
        new Grade_Details();
    }
}