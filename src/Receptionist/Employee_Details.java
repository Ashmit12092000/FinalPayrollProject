package Receptionist;

import Manager.TextPrompt.TextPrompt;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;

public class Employee_Details implements ActionListener{
    private static final int HEADER_HEIGHT =22 ;
    JFrame f1;
     JFrame f2;
     JPanel panel1;
     JTextField search;
     JPanel panel2;
     JButton delete;
     JPanel panel3;
     JTable table1;
     JButton refresh;
     JTable table2;
     JButton gpdf;
    ImageIcon background;
    ImageIcon bg;
    ImageIcon tbackground;
    DefaultTableModel model;
     JLabel Header_s;

     JButton add_employee;
     JButton search_button;
     JButton back;

    String[] column={ "Emp ID", "Name","Email","Phone","Job Title","Dept ID","D.O.B","Date of Joining","Salary",};
    public Employee_Details() {
        f1=new JFrame();
        f1.setType(javax.swing.JFrame.Type.UTILITY);
        search=new JTextField();
        search.setFont(new Font("Arial",Font.BOLD,13));
        search.setBounds(780,90,150,30);
        TextPrompt tp7 = new TextPrompt("Search by EmpID/name", search);
        f1.add(search);

        search_button=new JButton("Search");
        search_button.setBounds(950,90,110,30);
        search_button.setFont(new Font("Arial",Font.BOLD,14));
        search_button.setBackground(new Color(140, 50, 205));
        search_button.setForeground(Color.WHITE);
        search_button.addActionListener(this);
        f1.add(search_button);

        back =new JButton("< Back");
        back.setBounds(10,90,110,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(75,0,130));
        back.addActionListener(this);
        f1.add(back);

        add_employee =new JButton("Add New");
        add_employee.setBounds(140,90,110,30);
        add_employee.setFont(new Font("Arial",Font.BOLD,14));
        add_employee.addActionListener(this);
        add_employee.setForeground(Color.WHITE);
        add_employee.setBackground(new Color(50,205,50));
        f1.add(add_employee);


        refresh =new JButton("Refresh");
        refresh.setBounds(420,90,110,30);
        refresh.setFont(new Font("Arial",Font.BOLD,14));
        refresh.addActionListener(this);
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(new Color(255,127,80));
        f1.add(refresh);


        gpdf =new JButton("Generate PDF");
        gpdf.setBounds(560,90,140,30);
        gpdf.setFont(new Font("Arial",Font.BOLD,14));
        gpdf.addActionListener(this);
        gpdf.setForeground(Color.WHITE);
        gpdf.setBackground(new Color(248, 6, 6));
        f1.add(gpdf);



        delete =new JButton("Delete");
        delete.setBounds(280,90,110,30);
        delete.setFont(new Font("Arial",Font.BOLD,14));
        delete.addActionListener(this);
        delete.setForeground(Color.WHITE);
        delete.setBackground(new Color(178,34,34));
        f1.add(delete);



        panel1=new JPanel();
        panel1.setBounds(10,5,1050,75);
        panel1.setLayout(null);
        panel1.setBorder(BorderUIResource.getEtchedBorderUIResource());


        Header_s=new JLabel("Employee Details");
        Header_s.setFont(new Font("Arial", Font.BOLD, 20));
        Header_s.setSize(250,80);
        Header_s.setForeground(new Color(255,255,255));
        Header_s.setLocation(355,2);




        background=new ImageIcon("images/image.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1050,75,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backs=new JLabel(background);
        backs.setLayout(null);
        backs.setBounds(0,0,1050,75);


        panel1.add(Header_s);
        panel1.add(backs);
        f1.add(panel1);


        panel2=new JPanel();
        panel2.setBounds(10,130,1050,450);
        panel2.setLayout(null);
        panel2.setBorder(BorderUIResource.getEtchedBorderUIResource());

        tbackground=new ImageIcon("images/image.png");
        Image imgs=background.getImage();
        Image temps=imgs.getScaledInstance(1050,75,Image.SCALE_SMOOTH);
        background=new ImageIcon(temps);
        JLabel tbacks=new JLabel(background);
        backs.setLayout(null);
        backs.setBounds(0,0,1050,75);



        f1.setBounds(350, 50,1100, 720);

        f1.setLayout(null);
        //f1.pack();
        f1.setVisible(true);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);


        table1=new JTable(model);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFont(new Font("Arial",Font.PLAIN,15));
        table1.setBackground(new Color(255,214,200));
        JScrollPane scroll=new JScrollPane(table1);
        JTableHeader th = table1.getTableHeader();
        th.setFont(new Font("Arial",Font.BOLD,12));
        th.setPreferredSize(new Dimension(0, 50));
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10,10,1035,450);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
            String sql="Select Employee_id,Name,Email,Phone_no,jobtitle,Depart_id,d_birth,Start_Date,salary from employee";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            int i=0;
            while(rs.next()){
                String empid=rs.getString("Employee_id");
                String name=rs.getString("Name");
                String email=rs.getString("Email");
                String phone_no=rs.getString("Phone_no");
                String jobtitle=rs.getString("jobtitle");
                String dob=rs.getString("d_birth");
                String dept=rs.getString("Depart_id");
                String start_date=rs.getString("Start_Date");
                String salary=rs.getString("salary");
                model.addRow(new Object[]{empid,name,email,phone_no,jobtitle,dept,dob,start_date,"Rs."+salary});
                i++;
            }

            table1.getColumnModel().getColumn(0).setPreferredWidth(40);
            table1.getColumnModel().getColumn(1).setPreferredWidth(125);
            table1.getColumnModel().getColumn(2).setPreferredWidth(200);
            table1.getColumnModel().getColumn(3).setPreferredWidth(120);
            table1.getColumnModel().getColumn(5).setPreferredWidth(40);
            table1.getColumnModel().getColumn(6).setPreferredWidth(110);
            table1.setRowHeight(30);
            table1.revalidate();
            if(i<1){
                JOptionPane.showMessageDialog(null,
                        "No Records Found!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        panel2.add(tbacks);
        panel2.add(scroll);



        f1.add(panel2);



       /*&Action logout = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = (JFrame)e.getSource();
                JFrame fr=new Receptionist.LoginFrame();
                JOptionPane.showMessageDialog(null,"Session has been expired!Please login again.");
                frame.dispose();
                fr.setVisible(true);
            }
        };
        Manager.InactivityListener listener = new Manager.InactivityListener(f1, logout, 5);
        listener.start();*/
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        new Employee_Details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_button) {
            SearchDisplayResult();
        }
        if (e.getSource() == add_employee) {
            new Add_Employee();
        }
        if (e.getSource() == back) {
            f1.dispose();
        }
        if (e.getSource() == delete) {

            int confirm = JOptionPane.showOptionDialog(f1,
                    "Are You Sure want to Delete?",
                    "Delete Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == JOptionPane.YES_OPTION) {
                delete_row();
            }

        }
        if (e.getSource() == refresh) {
            model.setRowCount(0);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                String sql = "Select Employee_id,Name,Email,Phone_no,jobtitle,Depart_id,d_birth,Start_Date,salary from employee";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    String empid = rs.getString("Employee_id");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phone_no = rs.getString("Phone_no");
                    String jobtitle = rs.getString("jobtitle");
                    String dob = rs.getString("d_birth");
                    String dept = rs.getString("Depart_id");
                    String start_date = rs.getString("Start_Date");
                    String salary = rs.getString("salary");
                    model.addRow(new Object[]{empid, name, email, phone_no, jobtitle, dept, dob, start_date, "Rs." + salary});

                    i++;
                }

                table1.getColumnModel().getColumn(0).setPreferredWidth(40);
                table1.getColumnModel().getColumn(1).setPreferredWidth(125);
                table1.getColumnModel().getColumn(2).setPreferredWidth(200);
                table1.getColumnModel().getColumn(3).setPreferredWidth(120);
                table1.getColumnModel().getColumn(5).setPreferredWidth(40);
                table1.getColumnModel().getColumn(6).setPreferredWidth(110);
                table1.setRowHeight(30);
                table1.revalidate();


                if (i < 1) {
                    JOptionPane.showMessageDialog(null,
                            "No Records Found!");
                }
            } catch (ClassNotFoundException | SQLException se) {
                se.printStackTrace();
            }


        }
        if (e.getSource() == gpdf) {
            MessageFormat header=new MessageFormat("Employee Details");
            MessageFormat footer=new MessageFormat("Page{0,number,integer}");
            try {
                table1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public void delete_row(){
        int row = table1.getSelectedRow();
        if(row>=0) {
            System.out.println(row);
            String cell = table1.getModel().getValueAt(row, 0).toString();
            String sql = "Delete from employee where Employee_id=" + cell;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                PreparedStatement ps = con.prepareStatement(sql);
                ps.execute();

                JOptionPane.showMessageDialog(null, "Deleted Succesfully");
                model.removeRow(row);
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Select the row to delete!");
        }
    }

    private void SearchDisplayResult() {
        String textfiled_text = search.getText();

        if(!(textfiled_text.isEmpty())) {
            f2 = new JFrame("Database Results");
            f2.setLayout(null);
            panel3 = new JPanel();
            panel3.setBounds(10, 50, 1000, 400);
            panel3.setLayout(null);
            panel3.setBorder(BorderUIResource.getEtchedBorderUIResource());

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(column);

            JButton dback=new JButton("Back");
            dback =new JButton("Back");
            dback.setBounds(10,15,110,30);
            dback.setFont(new Font("Arial",Font.BOLD,14));
            dback.setForeground(Color.WHITE);
            dback.setBackground(new Color(75,0,130));
            dback.addActionListener(this);
            dback.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f2.dispose();
                }
            });
            f2.add(dback);

            JButton ddelete =new JButton("Delete");
            ddelete.setBounds(280,15,110,30);
            ddelete.setFont(new Font("Arial",Font.BOLD,14));
            ddelete.addActionListener(this);
            ddelete.setForeground(Color.WHITE);
            ddelete.setBackground(new Color(178,34,34));
            ddelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row=table2.getSelectedRow();
                    if(row>=0) {
                        System.out.println(row);
                        String cell = table2.getModel().getValueAt(row, 0).toString();
                        String sql = "Delete from employee where Employee_id=" + cell;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.execute();

                            JOptionPane.showMessageDialog(null, "Deleted Succesfully");
                            model.removeRow(row);
                        } catch (ClassNotFoundException | SQLException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please Select the row to delete!");
                    }
                }
            });
            f2.add(ddelete);



            table2 = new JTable(model);
            table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table2.setFont(new Font("Arial", Font.PLAIN, 15));
            table2.setBackground(new Color(255, 214, 200));
            table2.getColumnModel().getColumn(0).setPreferredWidth(40);
            table2.getColumnModel().getColumn(1).setPreferredWidth(125);
            table2.getColumnModel().getColumn(2).setPreferredWidth(200);
            table2.getColumnModel().getColumn(3).setPreferredWidth(120);
            table2.getColumnModel().getColumn(5).setPreferredWidth(40);
            table2.getColumnModel().getColumn(6).setPreferredWidth(110);
            table2.setRowHeight(30);
            JScrollPane scroll = new JScrollPane(table2);
            JTableHeader th = table2.getTableHeader();
            th.setFont(new Font("Arial", Font.BOLD, 12));
            th.setPreferredSize(new Dimension(0, 50));
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(5, 20, 1000, 380);
          try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                PreparedStatement ps = con.prepareStatement("Select Employee_id,Name,Email,Phone_no,jobtitle,Depart_id,d_birth,Start_Date,salary from employee where Employee_id=? or Name=?");
                ps.setString(1, textfiled_text);
                ps.setString(2, textfiled_text);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String empid=rs.getString("Employee_id");
                    String name=rs.getString("Name");
                    String email=rs.getString("Email");
                    String phone_no=rs.getString("Phone_no");
                    String jobtitle=rs.getString("jobtitle");
                    String dob=rs.getString("d_birth");
                    String dept=rs.getString("Depart_id");
                    String start_date=rs.getString("Start_Date");
                    String salary=rs.getString("salary");
                    model.addRow(new Object[]{empid,name,email,phone_no,jobtitle,dept,dob,start_date,"Rs."+salary});
                    f2.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No Records Found!");
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            panel3.add(scroll);
            f2.add(panel3);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Please Enter something to search!");
            f2.setVisible(false);
        }
        f2.setBounds(300, 150,955, 500);
    }

}
