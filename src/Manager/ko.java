package Manager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class ko extends JFrame {

    JFrame j;
    JPanel p,p1,p2,p3,p4;
    JPanel r1,emp_panel,dept_panel,Attendence,pr_panel;
    JLabel l,l4,l5,l6,l7,l8,emp,dep;
    JButton emp_btn,dep_btn,pslip_btn,update_emp_btn,greport_btn,Logout;
    JPanel show,show1;
    JButton b;

    ko() {
        j = new JFrame();
        j.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        j.getContentPane();
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);

        p = new JPanel();
        p.setLayout(null);
        p.setLocation(0,0);
        //ImageIcon background=new ImageIcon("images/reg_back.jpg");
        JLabel bkg = new JLabel();
        bkg.setIcon(new ImageIcon("images/reg_back.jpg"));
        bkg.setBounds(350,0,1500,1000);

        emp_panel=new JPanel();
        emp_panel.setLayout(null);
        emp_panel.setLocation(450,100);
        emp_panel.setSize(300,250);
        emp_panel.setBackground(Color.WHITE);


        JLabel ei1=new JLabel();
        ei1.setIcon(new ImageIcon("images/image.png"));
        ei1.setSize(450,20);
        emp_panel.add(ei1);

        JLabel en=new JLabel("Total Employees");
        en.setLocation(80,30);
        en.setSize(200,50);
        en.setFont(new Font("Arial",Font.BOLD,20));
        emp_panel.add(en);



        JLabel ei2=new JLabel();
        ei2.setIcon(new ImageIcon("images/employee.png"));
        ei2.setLocation(20,85);
        ei2.setSize(1500,130);
        emp_panel.add(ei2);



        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");
            PreparedStatement st = con.prepareStatement("Select COUNT(Name) from employee;");
            ResultSet r = st.executeQuery();
            r.next();
            int count = r.getInt(1);
            JLabel emp_count=new JLabel(String.valueOf(count));
            emp_count.setSize(30,50);
            emp_count.setLocation(200,140);
            emp_count.setFont(new Font("Arial",Font.BOLD,50));
            emp_panel.add(emp_count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        dept_panel=new JPanel();
        dept_panel.setLayout(null);
        dept_panel.setLocation(900,100);
        dept_panel.setSize(300,250);
        dept_panel.setBackground(Color.WHITE);


        JLabel di1=new JLabel();
        di1.setIcon(new ImageIcon("images/image.png"));
        di1.setSize(450,20);
        dept_panel.add(di1);

        JLabel dn=new JLabel("Total Department");
        dn.setLocation(80,30);
        dn.setSize(200,50);
        dn.setFont(new Font("Arial",Font.BOLD,20));
        dept_panel.add(dn);



        JLabel di2=new JLabel();
        di2.setIcon(new ImageIcon("images/departments.png"));
        di2.setLocation(20,85);
        di2.setSize(1500,130);
        dept_panel.add(di2);



        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");
            PreparedStatement st = con.prepareStatement("Select COUNT(Depart_name) from department");
            ResultSet r = st.executeQuery();
            r.next();
            int count = r.getInt(1);
            JLabel dpt_count=new JLabel(String.valueOf(count));
            dpt_count.setSize(30,50);
            dpt_count.setLocation(200,140);
            dpt_count.setFont(new Font("Arial",Font.BOLD,50));
            dept_panel.add(dpt_count);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Attendence=new JPanel();
        Attendence.setLayout(null);
        Attendence.setLocation(450,400);
        Attendence.setSize(300,250);
        Attendence.setBackground(Color.WHITE);


        JLabel ai1=new JLabel();
        ai1.setIcon(new ImageIcon("images/image.png"));
        ai1.setSize(450,20);
        Attendence.add(ai1);

        JLabel an=new JLabel("Attendence");
        an.setLocation(80,30);
        an.setSize(200,50);
        an.setFont(new Font("Arial",Font.BOLD,20));
        Attendence.add(an);



        JLabel ai2=new JLabel();
        ai2.setIcon(new ImageIcon("images/employee.png"));
        ai2.setLocation(20,85);
        ai2.setSize(1500,130);
        Attendence.add(ai2);

        JLabel att_count=new JLabel();
        att_count.setSize(30,50);
        att_count.setLocation(200,140);
        att_count.setFont(new Font("Arial",Font.BOLD,50));
        Attendence.add(att_count);

        pr_panel=new JPanel();
        pr_panel.setLayout(null);
        pr_panel.setLocation(900,400);
        pr_panel.setSize(300,250);
        pr_panel.setBackground(Color.WHITE);


        JLabel pi1=new JLabel();
        pi1.setIcon(new ImageIcon("images/image.png"));
        pi1.setSize(450,20);
        pr_panel.add(pi1);

        JLabel pn=new JLabel("Prepared Report");
        pn.setLocation(80,30);
        pn.setSize(200,50);
        pn.setFont(new Font("Arial",Font.BOLD,20));
        pr_panel.add(pn);



        JLabel pi2=new JLabel();
        pi2.setIcon(new ImageIcon("images/departments.png"));
        pi2.setLocation(20,85);
        pi2.setSize(1500,130);
        pr_panel.add(pi2);


        JLabel pr_count=new JLabel();
        pr_count.setSize(30,50);
        pr_count.setLocation(200,140);
        pr_count.setFont(new Font("Arial",Font.BOLD,50));
        pr_panel.add(pr_count);


        p.add(emp_panel);
        p.add(dept_panel);
        p.add(Attendence);
        p.add(pr_panel);











        p.add(bkg);


        p1 = new JPanel();
        p1.setLayout(new GridLayout(10,1,4,7));
        p1.setBackground(new Color(64,15,100));
        p1.setSize(350,850);
        p1.setLocation(0,0);
        Border blackline = BorderFactory.createLineBorder(Color.black,8);
        p1.setBorder(blackline);

        r1 = new JPanel();
        r1.setBackground(new Color(64,15,100));
        p1.add(r1);

        l = new JLabel("Welcome Admin");
        l.setFont(new Font("Arial",Font.BOLD,24));
        l.setForeground(Color.WHITE);
        r1.add(l);

        emp_btn = new JButton("Employees");
        emp_btn.setFont(new Font("Arial",Font.BOLD,20));
        emp_btn.setIcon(new ImageIcon("images/worker.png"));
        emp_btn.setIconTextGap(5);
        emp_btn.setBackground(new Color(51,233,67));
        emp_btn.setForeground(Color.WHITE);
        emp_btn.setMargin(new Insets(5,0,0,0));
        emp_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_Details();
            }
        });
        p1.add(emp_btn);

        dep_btn = new JButton("Department");
        dep_btn.setFont(new Font("Arial",Font.BOLD,20));
        dep_btn.setBackground(new Color(249,25,106));
        dep_btn.setForeground(Color.WHITE);
        dep_btn.setIcon(new ImageIcon("images/department.png"));
        dep_btn.setMargin(new Insets(5,0,0,0));
        dep_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department_Details();
            }
        });

        p1.add(dep_btn);

        pslip_btn = new JButton("PaySlip");
        pslip_btn.setFont(new Font("Arial",Font.BOLD,20));

        pslip_btn.setBackground(new Color(240,85,23));
        pslip_btn.setIcon(new ImageIcon("images/wallet.png"));

        pslip_btn.setForeground(Color.WHITE);

        pslip_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new emp_sal();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        p1.add(pslip_btn);

        update_emp_btn = new JButton("Update Employee");
        update_emp_btn.setFont(new Font("Arial",Font.BOLD,20));
        update_emp_btn.setBackground(new Color(23,240,185));
        update_emp_btn.setIcon(new ImageIcon("images/edit.png"));
        update_emp_btn.setForeground(Color.WHITE);
        update_emp_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_emp();
            }
        });
        p1.add(update_emp_btn);

        greport_btn = new JButton("Generate Report");
        greport_btn.setFont(new Font("Arial",Font.BOLD,20));
        greport_btn.setIcon(new ImageIcon("images/immigration.png"));
        greport_btn.setBackground(new Color(250, 5, 46));
        greport_btn.setForeground(Color.WHITE);
        greport_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new  Receptionist.Update_emp();
            }
        });
        p1.add(greport_btn);

        JButton about = new JButton("About");
        about.setFont(new Font("Arial",Font.BOLD,20));
        about.setForeground(Color.WHITE);
        about.setBackground(new Color(128,0,255));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent y) {
                new about_us();

            }
        });
        p1.add(about);

        Logout = new JButton("Logout");
        Logout.setFont(new Font("Arial",Font.BOLD,20));
        Logout.setIcon(new ImageIcon("images/logout.png"));
        Logout.setForeground(Color.WHITE);
        Logout.setBackground(new Color(128,0,255));
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int conf = JOptionPane.showOptionDialog(j,"Are you sure you want yo logout","Logout Confirmation",JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,null,null);
                if(conf == JOptionPane.YES_OPTION){
                    j.dispose();
                    JFrame log= new LoginFrame();
                    log.setVisible(true);
                }
            }
        });
        p1.add(Logout);

        JLabel User = new JLabel();
        p1.add(User);
        p2 = new JPanel();
        p2.setLayout(new GridLayout(3,1,4,4));
        p2.setBackground(Color.BLUE);



       /* try{
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
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");
            PreparedStatement st = con.prepareStatement("Select COUNT(Depart_name) from department;");
            ResultSet rs = st.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            Receptionist.dep = new JLabel(String.valueOf(count));
            Receptionist.dep.setFont(new Font("Arial",Font.BOLD,30));
            show1.add(Receptionist.dep);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
*/




        p.add(p1);
        p.add(p2);

        j.add(p);
        j.setSize(1050,550);

        j.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        new ko();
    }
}