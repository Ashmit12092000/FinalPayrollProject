package Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

class dash extends JFrame {

    JFrame j;
    JPanel p,p1,p2,p3,p4,back;
    JPanel r1,r2,r3,g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,emp,dep;
    JPanel show,show1;
    JButton b;

    dash() {
        j = new JFrame();
        j.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        j.getContentPane();

        p = new JPanel();
        p.setLayout(new GridLayout(1,4,10,10));
        p.setBackground(Color.LIGHT_GRAY);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(9,1,4,4));
        p1.setBackground(Color.MAGENTA);

        r1 = new JPanel();
        r1.setBackground(Color.MAGENTA);
        p1.add(r1);

        l = new JLabel("Welcome Admin");
        l.setFont(new Font("Arial",Font.BOLD,24));
        r1.add(l);

        g3 = new JPanel();
        g3.setBackground(Color.MAGENTA);

        l1 = new JLabel("Employees");
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Employee_Details();
            }

        });
        g3.add(l1);
        p1.add(g3);

        g4 = new JPanel();
        g4.setBackground(Color.MAGENTA);

        l2 = new JLabel("Department");
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                j.dispose();
                new Department_Details();
            }
        });
        g4.add(l2);
        p1.add(g4);

        g5 = new JPanel();
        g5.setBackground(Color.MAGENTA);

        l3 = new JLabel("PaySlip");
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new emp_sal();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        g5.add(l3);
        p1.add(g5);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(3,1,4,4));
        p2.setBackground(Color.LIGHT_GRAY);

        g1 = new JPanel();
        g1.setBackground(Color.LIGHT_GRAY);
        p2.add(g1);

        l4 = new JLabel("Dashboard");
        l4.setFont(new Font("Arial",Font.BOLD,24));
        g1.add(l4);

        r2 = new JPanel();
        r2.setLayout(new GridLayout(3,1,4,4));
        r2.setBackground(Color.WHITE);
        p2.add(r2);

        g7 = new JPanel();
        g7.setBackground(Color.MAGENTA);
        r2.add(g7);

        show = new JPanel();
        show.setBackground(Color.WHITE);
        r2.add(show);

        l7 = new JLabel("Toatal Employees");
        l7.setFont(new Font("Arial",Font.BOLD,22));
        g7.add(l7);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");
            PreparedStatement st = con.prepareStatement("Select COUNT(Name) from employee;");
            ResultSet r = st.executeQuery();
            r.next();
            int count = r.getInt(1);
            emp = new JLabel(String.valueOf(count));
            emp.setFont(new Font("Arial",Font.BOLD,30));
            show.add(emp);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        g6 = new JPanel();
        g6.setLayout(new GridLayout(3,1,10,10));
        g6.setBackground(Color.WHITE);
        p2.add(g6);

        g10 = new JPanel();
        g10.setBackground(Color.MAGENTA);
        g6.add(g10);

        l5 = new JLabel("Notifications");
        l5.setFont(new Font("Arial",Font.BOLD,22));
        g10.add(l5);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(3,1,4,4));
        p3.setBackground(Color.LIGHT_GRAY);

        g2 = new JPanel();
        g2.setBackground(Color.LIGHT_GRAY);
        p3.add(g2);

        r3 = new JPanel();
        r3.setLayout(new GridLayout(3,1,4,4));
        r3.setBackground(Color.WHITE);
        p3.add(r3);

        g8 = new JPanel();
        g8.setBackground(Color.MAGENTA);
        r3.add(g8);

        show1 = new JPanel();
        show1.setBackground(Color.WHITE);
        r3.add(show1);

        l8 = new JLabel("Total Department");
        l8.setFont(new Font("Arial",Font.BOLD,22));
        g8.add(l8);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");
            PreparedStatement st = con.prepareStatement("Select COUNT(Depart_name) from department;");
            ResultSet rs = st.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            dep = new JLabel(String.valueOf(count));
            dep.setFont(new Font("Arial",Font.BOLD,30));
            show1.add(dep);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        g9 = new JPanel();
        g9.setLayout(new GridLayout(3,1,10,10));
        g9.setBackground(Color.WHITE);
        p3.add(g9);

        g11 = new JPanel();
        g11.setBackground(Color.MAGENTA);
        g9.add(g11);

        l6 = new JLabel("Prepare Report");
        l6.setFont(new Font("Arial",Font.BOLD,22));
        g11.add(l6);

        p4 = new JPanel();
        p4.setBackground(Color.LIGHT_GRAY);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        j.add(p);
        j.setSize(1050,550);
        j.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        new dash();
    }
}