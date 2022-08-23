package hotel;//Employee details Page using Java Swing
import Manager.TextPrompt.TextPrompt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

class prac extends JFrame implements ActionListener{

    private final JTextField salary;
    int rprice;
    JScrollPane scrollPane;
     JTable table;
     JButton generateBillBtn;
    JFrame fr;
    JLabel name;
    JTextField nameField;
    JLabel cid;
    JTextField cidField;
    JLabel email ;
    JTextField emailField;
    JLabel phone ;
    JTextField phoneField;
    JLabel gender;
    JComboBox genderField;
    JLabel CheckOut;
    JTextField noofdaysField;
    JComboBox CheckOut_date;
    JComboBox CheckOut_month;
    JComboBox CheckOut_year;
    SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    java.util.Date dt= new Date();
    JLabel CheckIn;
    JComboBox CheckIn_date;
    JComboBox CheckIn_month;
    JComboBox CheckIn_year;
    JLabel pincode,roomcount;
    JTextField jpincode,roomCountField;
    JLabel add;
    JTextArea addField,genrtBookArea;
    JLabel roomtype;
    JComboBox roomtypeField;
    ImageIcon background;
    JLabel heading;
    String[] dptlist = {"Select","104","105","106","107","108"};
    int regn = 1000;
    String did;
    String chindate,choutdate;
    String calc_price;

    prac(){
        JFrame fr = new JFrame();
        fr.setTitle("Add Booking");
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setResizable(false);

        heading = new JLabel("Add Booking");
        heading.setSize(500, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        heading.setLocation(370, 30);
        heading.setForeground(Color.WHITE);
        heading.setVisible(true);

        name = new JLabel("Name");
        name.setSize(100 ,45);
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setLocation(100 , 150);
        name.setForeground(Color.WHITE);
        name.setVisible(true);

        nameField =new JTextField();
        nameField.setSize(200 ,30);
        nameField.setFont(new Font("Arial", Font.BOLD, 15));
        nameField.setLocation(200 ,160);
        nameField.setVisible(true);

        TextPrompt tp7 = new TextPrompt("First Name", nameField);

        cid = new JLabel("CustID");
        cid.setSize(100 ,45);
        cid.setFont(new Font("Arial", Font.BOLD, 16));
        cid.setLocation(100,100);
        cid.setForeground(Color.WHITE);
        cid.setVisible(true);

        roomtypeField = new JComboBox();
        roomtypeField.setSize(200,30);
        roomtypeField.addItem("SELECT");
        roomtypeField.setFont(new Font("Arial", Font.BOLD, 15));
        roomtypeField.setLocation(600, 110);
        roomtypeField.setVisible(true);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_db", "root", "");
            PreparedStatement s1 = cn.prepareStatement("SELECT roomno FROM roomcutomer ORDER BY roomno DESC LIMIT 1");
            ResultSet r1 = s1.executeQuery();
            if(r1.next()) {
                regn = r1.getInt(1) + 1;
            }
            PreparedStatement s2 = cn.prepareStatement("SELECT roomType from room");
            ResultSet r2 = s2.executeQuery();
            while (r2.next()){
                roomtypeField.addItem(r2.getString("roomType"));
            }




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }



        cidField = new JTextField();
        cidField.setSize(200,30);
        cidField.setText(String.valueOf(regn));
        cidField.setEditable(false);
        cidField.setFont(new Font("Arial", Font.BOLD, 15));
        cidField.setLocation(200,110);
        cidField.setVisible(true);

        email = new JLabel("Email");
        email.setSize(100,45);
        email.setFont(new Font("Arial", Font.BOLD, 16));
        email.setLocation(100,200);
        email.setVisible(true);
        email.setForeground(Color.WHITE);

        emailField = new JTextField();
        emailField.setSize(200,30);
        emailField.setFont(new Font("Arial", Font.BOLD, 15));
        emailField.setLocation(200,210);
        emailField.setVisible(true);

        phone = new JLabel("Phone");
        phone.setLocation(100,450);
        phone.setVisible(true);
        phone.setFont(new Font("Arial", Font.BOLD, 16));
        phone.setForeground(Color.WHITE);
        phone.setSize(100,45);

        phoneField = new JTextField();
        phoneField.setSize(200,30);
        phoneField.setFont(new Font("Arial", Font.BOLD, 15));
        phoneField.setLocation(200,460);
        phoneField.setVisible(true);



        pincode = new JLabel("Pincode");
        pincode.setLocation(100,400);
        pincode.setFont(new Font("Arial", Font.BOLD, 16));
        pincode.setSize(100,45);
        pincode.setVisible(true);
        pincode.setForeground(Color.WHITE);

        jpincode = new JTextField();
        jpincode.setLocation(200,410);
        jpincode.setFont(new Font("Arial", Font.BOLD, 15));
        jpincode.setFont(new Font("Arial", Font.BOLD, 15));
        jpincode.setSize(200,30);
        jpincode.setVisible(true);

        CheckOut = new JLabel("Stay Duration(Days)");
        CheckOut.setLocation(40,250);
        CheckOut.setFont(new Font("Arial", Font.BOLD, 16));
        CheckOut.setSize(180,45);
        CheckOut.setVisible(true);
        CheckOut.setForeground(Color.WHITE);

        noofdaysField= new JTextField();
        noofdaysField.setSize(200,30);
        noofdaysField.setFont(new Font("Arial", Font.BOLD, 15));
        noofdaysField.setLocation(200,260);
        noofdaysField.setVisible(true);

        

        /*String[] dates = {"DD", "01", "02", "03", "04", "05",
                "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31"};
        CheckOut_date = new JComboBox(dates);
        CheckOut_date.setFont(new Font("Arial", Font.BOLD, 16));
        CheckOut_date.setSize(60, 30);
        CheckOut_date.setLocation(200, 310);
        CheckOut_date.setVisible(true);

        String[] months = {"MM", "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12"};
        CheckOut_month = new JComboBox(months);
        CheckOut_month.setFont(new Font("Arial", Font.BOLD, 16));
        CheckOut_month.setSize(70,30);
        CheckOut_month.setVisible(true);
        CheckOut_month.setLocation(260,310);

        String[] yrs = {"YYYY", "1980", "1981", "1982", "1983",
                "1984", "1985", "1986", "1987",
                "1988", "1989", "1990", "1991",
                "1992", "1993", "1994", "1995",
                "1996", "1997", "1998", "1999",
                "2000", "2001", "2002",
                "2003", "2004"};
        CheckOut_year = new JComboBox(yrs);
        CheckOut_year.setFont(new Font("Arial", Font.BOLD, 16));
        CheckOut_year.setSize(74, 30);
        CheckOut_year.setVisible(true);
        CheckOut_year.setLocation(330,310);

        CheckIn = new JLabel("Check-In");
        CheckIn.setFont(new Font("Arial", Font.BOLD, 16));
        CheckIn.setLocation(100,250);
        CheckIn.setVisible(true);
        CheckIn.setForeground(Color.WHITE);
        CheckIn.setSize(100,45);

        CheckIn_date = new JComboBox(dates);
        CheckIn_date.setFont(new Font("Arial", Font.BOLD, 16));
        CheckIn_date.setSize(60, 30);
        CheckIn_date.setLocation(200, 260);
        CheckIn_date.setVisible(true);

        CheckIn_month = new JComboBox(months);
        CheckIn_month.setFont(new Font("Arial", Font.BOLD, 16));
        CheckIn_month.setSize(72,30);
        CheckIn_month.setVisible(true);
        CheckIn_month.setLocation(260,260);

        String[] years = {"YYYY", "1998", "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019", "2020", "2021"};
        CheckIn_year = new JComboBox(years);
        CheckIn_year.setFont(new Font("Arial", Font.BOLD, 16));
        CheckIn_year.setSize(80, 30);
        CheckIn_year.setVisible(true);
        CheckIn_year.setLocation(320,260);*/

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.BOLD, 16));
        add.setVisible(true);
        add.setLocation(100,350);
        add.setSize(100,45);
        add.setForeground(Color.WHITE);

        addField =new JTextArea();
        addField.setVisible(true);
        addField.setFont(new Font("Arial", Font.BOLD, 15));
        addField.setLocation(200,360);
        addField.setLineWrap(true);
        addField.setSize(200,30);

        roomtype= new JLabel("Room Type");
        roomtype.setFont(new Font("Arial", Font.BOLD, 16));
        roomtype.setForeground(Color.WHITE);
        roomtype.setSize(100,45);
        roomtype.setVisible(true);
        roomtype.setLocation(500,100);




      /*  acc = new JTextField();
        acc.setSize(200,30);
        acc.setFont(new Font("Arial", Font.BOLD, 15));
        acc.setLocation(600,410);
        acc.setVisible(true);

        accno = new JLabel("Account No.");
        accno.setFont(new Font("Arial", Font.BOLD, 16));
        accno.setLocation(500,400);
        accno.setVisible(true);
        accno.setSize(100,45);
        accno.setForeground(Color.WHITE);*/

        JLabel sal = new JLabel("Total");
        sal.setSize(200,30);
        sal.setFont(new Font("Arial", Font.BOLD, 15));
        sal.setLocation(110,500);
        sal.setForeground(Color.WHITE);
        sal.setVisible(true);
        fr.add(sal);

        salary = new JTextField();
        salary.setSize(200,30);
        salary.setFont(new Font("Arial", Font.BOLD, 15));
        salary.setLocation(200,510);
        salary.setVisible(true);
        fr.add(salary);

        roomcount = new JLabel("Rooms Count");
        roomcount.setLocation(50,300);
        roomcount.setFont(new Font("Arial", Font.BOLD, 16));
        roomcount.setSize(130,45);
        roomcount.setVisible(true);
        roomcount.setForeground(Color.WHITE);



        genrtBookArea = new JTextArea();
        genrtBookArea.setLocation(500,160);
        genrtBookArea.setFont(new Font("Arial", Font.BOLD, 16));
        genrtBookArea.setSize(350,350);
        genrtBookArea.setVisible(true);
        genrtBookArea.setForeground(Color.BLACK);

        roomCountField = new JTextField();
        roomCountField.setLocation(200,310);
        roomCountField.setFont(new Font("Arial", Font.BOLD, 15));
        roomCountField.setFont(new Font("Arial", Font.BOLD, 15));
        roomCountField.setSize(200,30);
        roomCountField.setVisible(true);



        JButton sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.BOLD, 16));
        sub.setSize(100, 30);
        sub.setBackground(new Color(50,205,50));
        sub.setForeground(new Color(255,255,255));
        sub.setLocation(500, 520);
        fr.add(sub);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_db", "root", "");
                    PreparedStatement s3=cn.prepareStatement("SELECT Price from room where roomType=?");
                    s3.setString(1, roomtypeField.getSelectedItem().toString());
                    System.out.println(roomtypeField.getSelectedItem().toString());
                    ResultSet r3 = s3.executeQuery();
                    if(r3.next()){
                        rprice=r3.getInt("Price");
                        System.out.println(rprice);
                    }

                } catch (Exception es) {
                    throw new RuntimeException(es);
                }
                addToDatabas();
                try {
                    salary.setText(calculatePrice());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton back= new JButton("<Back");
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setSize(100, 20);
        back.setLocation(20, 30);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setBorder(null);
        back.setFocusable(false);
        back.setForeground(new Color(255,255,255));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    fr.setVisible(false);
                }
            }
        });
        generateBillBtn = new JButton("Generate Bill");
        generateBillBtn.setFont(new Font("Arial", Font.BOLD, 16));
        generateBillBtn.setSize(180, 30);
        generateBillBtn.setLocation(650,520);
        generateBillBtn.setBackground(new Color(255,46,0));
        generateBillBtn.setForeground(new Color(255,255,255));
        generateBillBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                genrtBookArea.setText("**************************************************************************\n");
                genrtBookArea.setText(genrtBookArea.getText()+"******      	    YOUR BILL RECEIPT      	     ******\n");
                genrtBookArea.setText(genrtBookArea.getText()+"*************************************************************************\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"TIME     : "+sf.format(dt)+"\n\n");

                genrtBookArea.setText(genrtBookArea.getText()+"NAME     :    "+name.getText()+"\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"ADDRESS  :    "+add.getText()+"\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"PHONE NUM  :    "+phone.getText()+"\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"No. of days  :    "+noofdaysField.getText()+"\n\n");
                // genrtBookArea.setText(genrtBookArea.getText()+"Check-in date  :    "+CheckIn_date.getSelectedItem().toString()+"/"+ CheckIn_month.getSelectedItem().toString()+"/"+CheckIn_year.getSelectedItem().toString()+"\n\n");
                // genrtBookArea.setText(genrtBookArea.getText()+"Check-Out date  :    "+CheckOut_date.getSelectedItem().toString()+"/"+ CheckOut_month.getSelectedItem().toString()+"/"+CheckOut_year.getSelectedItem().toString()+"\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"PINCODE  : "+jpincode.getText()+"\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"ROOM TYPE  : "+roomtypeField.getSelectedItem().toString()+"\n\n");
                genrtBookArea.setText(genrtBookArea.getText()+"ROOM COUNT  : "+roomtypeField.getSelectedItem().toString()+"\n\n");
                try {
                    genrtBookArea.setText(genrtBookArea.getText()+"TOTAL AMOUNT   :   "+calculatePrice()+"\n\n");
                    salary.setText(calculatePrice());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 16));
        reset.setSize(100, 30);
        reset.setLocation(800,520);
        reset.setBackground(new Color(255,0,0));
        reset.setForeground(new Color(255,255,255));
        reset.addActionListener(e -> {

            /*nameField.setText("");
            phoneField.setText("");
            CheckOut_month.setSelectedIndex(0);
            CheckOut_year.setSelectedIndex(0);
            CheckOut_date.setSelectedIndex(0);
            CheckIn_year.setSelectedIndex(0);
            CheckIn_month.setSelectedIndex(0);
            CheckIn_date.setSelectedIndex(0);
            jpincode.setText("");
            emailField.setText("");
            addField.setText("");
            roomtypeField.setSelectedIndex(0);
            genderField.setSelectedIndex(0);*/
           // int rcount= Integer.parseInt(roomCountField.getText().toString());
            /*try {
                calc_price=calculatePrice(salary.getText());
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }*/



        });
       // fr.add(reset);

        background=new ImageIcon("images/image.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(1050,850,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backs=new JLabel(background);
        backs.setLayout(null);
        backs.setBounds(0,0,1000,600);

        scrollPane =new JScrollPane();
        scrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int i =table.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                //rno.setText(model.getValueAt(i, 0).toString());
                ///bedtype.setText(model.getValueAt(i,2).toString());
                //salary.setText(model.getValueAt(i,3).toString());


            }
        });

        fr.add(back);
        fr.add(roomtype);
        fr.add(roomtypeField);
        fr.add(addField);
        fr.add(add);
        fr.add(heading);
        fr.add(name);
        fr.add(nameField);
        fr.add(cid);
        fr.add(cidField);
        fr.add(email);
        fr.add(emailField);
        //fr.add(gender);
        //fr.add(genderField);
        fr.add(phone);
        fr.add(phoneField);
        fr.add(pincode);
        fr.add(jpincode);
        fr.add(generateBillBtn);
       fr.add(CheckOut);
       fr.add(noofdaysField);
        //fr.add(CheckOut_month);
        fr.add(genrtBookArea);
        //fr.add(CheckOut_date);
       // fr.add(CheckOut_year);
        //fr.add(CheckIn);
       // fr.add(CheckIn_date);
      //  fr.add(CheckIn_month);
        //fr.add(CheckIn_year);
        fr.add(roomCountField);
        fr.add(roomcount);
        fr.setSize(1000, 600);
        fr.setLocation(350, 50);
        fr.add(backs);
        fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fr.setLayout(null);
        fr.setVisible(true);

    }


    public void addToDatabas()
    {
        PreparedStatement ps = null;
        ResultSet result = null;
        try {

            GetConnection connect=new GetConnection();
            Connection conn=connect.getConnection();
            ps=conn.prepareStatement("INSERT INTO roomcutomer(name,address,phone,email,pincode,roomtype,price,status) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1,nameField.getText());
            ps.setString(2,addField.getText());
            ps.setString(3,phoneField.getText());
            ps.setString(4,emailField.getText());
            ps.setString(5,jpincode.getText());
            ps.setString(6,String.valueOf(roomtypeField.getSelectedItem().toString()));

            ps.setString(7,salary.getText());
            ps.setString(8,"0");

            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "New Customer Added");
            }

        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public String calculatePrice() throws ParseException {
        int days= Integer.parseInt(noofdaysField.getText());
        int total=days*rprice;
        return String.valueOf(total);

    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

        }catch(Exception e) {
            e.printStackTrace();
        }
        new prac();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void addToDatabase()
    {
        PreparedStatement ps = null;
        ResultSet result = null;
        try {

            GetConnection connect=new GetConnection();
            Connection conn=connect.getConnection();
            ps=conn.prepareStatement("INSERT INTO roomcutomer(name,address,phone,roomtype,bedtype,price,status) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,nameField.getText());
            ps.setString(2,add.getText());
            ps.setString(3,phoneField.getText());
            ps.setString(3,jpincode.getText());
            ps.setString(3,emailField.getText());
            ps.setString(4,roomtype.getText());
            ps.setString(5,calc_price);
            ps.setString(7,"0");

            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "New Customer Added");
            }

        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


}