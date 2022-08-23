package Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class about_us  implements ActionListener {
    JFrame abt;
    JLabel d1,d2,d3,d4;
    JLabel heading;
    ImageIcon background;

    about_us(){
        abt = new JFrame("About us");


        heading = new JLabel("Admin Login");
        heading.setSize(220, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        heading.setLocation(370, 95);
        heading.setForeground(Color.WHITE);
        heading.setVisible(true);

        d1 = new JLabel("Ashmit Singh 1961062 \nSarthak Swapnil Dubey Reg. 1961056 \n Adarsh Singh Nishen 1961055\n Abuzar Ahmed Quadri 1961063");
        d1.setVisible(true);
        d1.setSize(300, 22);
        d1.setFont(new Font("Arial", Font.BOLD, 14));
        d1.setLocation(230, 180);
        d1.setForeground(Color.WHITE);

        d2 = new JLabel();
        d2.setVisible(true);
        d2.setSize(350, 20);
        Font fnt = new Font("Arial", Font.BOLD, 14);
        Map attributes = fnt.getAttributes();
        //attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        d2.setLocation(230, 200);
        d2.setForeground(Color.red);

        background=new ImageIcon("images/image.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(900,650,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backs=new JLabel(background);
        backs.setLayout(null);
        backs.setBounds(0,0,900,650);


        abt.setBounds(300, 150,900, 650);
        abt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        abt.setVisible(true);

        abt.add(heading);
        abt.add(d1);
        abt.add(d2);
        abt.add(backs);

    }
    public static void main(String[] args) {
        new about_us();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
