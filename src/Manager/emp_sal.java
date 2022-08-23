package Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

class emp_sal extends JFrame implements ActionListener{
    int var = 0;
    JFrame j;
    JLabel l,Year,Id,Month;
    JButton submit;
    JButton clear;
    JLabel emp[] = new JLabel[16];

    String labels[] = {"Pay No","Employee ID","Employee Name","Account Number",
            "Absence","HRA","Basic","Overtime","Season Bonus","Other Bonus",
            "Medical Allowance","House Allowance","Total Pay"};
    JTextField area[] = new JTextField[16],dep;
    JComboBox year,month;
    String years[] = {"Select","2000","2001","2002","2003","2004",
            "2005","2006","2007","2008","2009",
            "2010","2011","2012","2013","2014","2015","2016",
            "2017","2018","2019","2020","2021"};
    String months[] = {"Select","January","February","March","April","May","June","July",
            "August","September","October","November","Decenber"};
    private String dept;

    emp_sal() throws SQLException, ClassNotFoundException {
        ImageIcon background=new ImageIcon("images/image.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1050,650,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backs=new JLabel(background);
        backs.setBounds(0,0,1050,650);

        j = new JFrame("Employee Details");
        j.getContentPane();
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setSize(900,650);
        j.setBounds(376, 50,900, 650);

        l = new JLabel("Employee Salary Details");
        l.setSize(400,40);
        l.setFont(new Font("Arial",Font.BOLD,24));
        l.setForeground(Color.WHITE);
        l.setLocation(260,5);
        l.setVisible(true);

        for(int i=0;i<7;i++){
            emp[i] = new JLabel(labels[i]);
            emp[i].setSize(200,40);
            emp[i].setForeground(Color.WHITE);
            emp[i].setLocation(60,36*(i+1));
            emp[i].setVisible(true);
            j.add(emp[i]);
        }

        for(int k=7;k<13;k++){
            emp[k] = new JLabel(labels[k]);
            emp[k].setSize(200,40);
            emp[k].setForeground(Color.WHITE);
            emp[k].setLocation(405,37*(13-k));
            emp[k].setVisible(true);
            j.add(emp[k]);
        }

        for(int a=0;a<7;a++){
            area[a] = new JTextField();
            area[a].setSize(180,17);
            area[a].setLocation(210, (int) (37*(a+1.25)));
            area[a].setVisible(true);
            j.add(area[a]);
        }

        for(int b=7;b<13;b++){
            area[b] = new JTextField();
            area[b].setSize(180,17);
            area[b].setLocation(580, (int) (37*((13-b)+0.25)));
            area[b].setVisible(true);
        }

        area[1].addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent y) {
            }

            @Override
            public void keyPressed(KeyEvent y) {

            }

            @Override
            public void keyReleased(KeyEvent y) {
                String ddk = area[1].getText();
                if(ddk.isEmpty()) {
                    area[2].setText("");
                    dep.setText("");
                    area[3].setText("");
                    area[6].setText("");
                    area[2].setEditable(true);
                    area[3].setEditable(true);
                    area[6].setEditable(true);
                    dept = "";
                    var=0;
                }else
                if(ddk.length()==4){
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/paroll", "root", "");
                        PreparedStatement s1 = cn.prepareStatement("SELECT Name, salary,Depart_id, b_accno  FROM employee where Employee_id =? LIMIT 1");
                        String rn = area[1].getText();
                        s1.setString(1,rn);
                        ResultSet r1 = s1.executeQuery();
                        while(r1.next()){
                            area[2].setText(r1.getString("Name"));
                            dept = r1.getString("Depart_id");
                            area[3].setText(r1.getString("b_accno"));
                            area[6].setText(r1.getString("salary"));
                            area[2].setEditable(false);
                            area[3].setEditable(false);
                            area[6].setEditable(false);
                            if(dept.isEmpty() == false){
                                PreparedStatement s2 = cn.prepareStatement("SELECT Depart_name  FROM department where Depart_id = ? LIMIT 1");
                                s2.setString(1,dept);
                                ResultSet r2 = s2.executeQuery();
                                while(r2.next()){
                                    dep.setText(r2.getString("Depart_name"));
                                }
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();


                    }
                }
            }
        });
        for(int c= 7;c<13;c++){
            j.add(area[c]);
        }

        Id = new JLabel("Current Department");
        Id.setSize(200,40);
        Id.setForeground(Color.WHITE);
        Id.setLocation(405,295);
        Id.setVisible(true);

        Year = new JLabel("Year");
        Year.setSize(200,40);
        Year.setForeground(Color.WHITE);
        Year.setLocation(60,295);
        Year.setVisible(true);

        Month = new JLabel("Month");
        Month.setSize(200,40);
        Month.setForeground(Color.WHITE);
        Month.setLocation(405,258);
        Month.setVisible(true);

        dep = new JTextField();
        dep.setSize(180,17);
        dep.setLocation(580,305);
        dep.setVisible(true);

        year = new JComboBox();
        year.setSize(180,17);
        year.setFont(new Font("Arial", Font.BOLD,15));
        year.setLocation(210,305);
        year.setVisible(true);

        month = new JComboBox(months);
        month.setSize(180,19);
        month.setFont(new Font("Arial", Font.BOLD,15));
        month.setLocation(580,268);
        month.setVisible(true);

        submit = new JButton("Submit");
        submit.setSize(150,20);
        submit.addActionListener(this::actionPerformed);
        submit.setLocation(240,360);
        submit.setBackground(Color.GREEN);
        submit.isOpaque();

        clear = new JButton("Clear");
        clear.setSize(150,20);
        clear.addActionListener(this::actionPerformed);
        clear.setLocation(440,360);
        clear.setBackground(Color.GREEN);
        clear.isOpaque();

        j.add(l);
        j.add(dep);
        j.add(year);
        j.add(month);
        j.add(Id);
        j.add(Year);
        j.add(Month);
        j.add(submit);
        j.add(clear);
        j.add(backs);
        j.setLayout(null);
        j.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        if (str.equals("Submit")){
            int pay_no = Integer.parseInt(area[0].getText());
            String emp_id = area[1].getText();
            String name = area[2].getText();
            int accno = Integer.parseInt(area[3].getText());
            int absence = Integer.parseInt(area[4].getText());
            int HRA = Integer.parseInt(area[5].getText());
            int Basic = Integer.parseInt(area[6].getText());
            float overtime = Float.parseFloat(area[7].getText());
            float season_bonus = Float.parseFloat(area[8].getText());
            float other_bonus = Float.parseFloat(area[9].getText());
            float medi_allow = Float.parseFloat(area[10].getText());
            float house_allow = Float.parseFloat(area[11].getText());
            float total_pay = Float.parseFloat(area[12].getText());

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");

                PreparedStatement st = (PreparedStatement) con.prepareStatement("Insert into payment values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                st.setInt(1,pay_no);
                st.setString(2,emp_id);
                st.setString(3,name);
                st.setInt(4,accno);
                st.setObject(5,year.getSelectedItem());
                st.setObject(6,month.getSelectedItem());
                st.setInt(7,absence);
                st.setInt(8,HRA);
                st.setInt(9,Basic);
                st.setFloat(10,overtime);
                st.setObject(11,dept);
                st.setFloat(12,season_bonus);
                st.setFloat(13,other_bonus);
                st.setFloat(14,medi_allow);
                st.setFloat(15,house_allow);
                st.setFloat(16,total_pay);
                st.executeUpdate();

                JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
                for(int c=0;c<13;c++){
                    area[c].setText(null);
                }

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

        else if(str.equals("Clear")){
            for(int h=0;h<14;h++){
                area[h].setText(null);
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new emp_sal();
    }
}