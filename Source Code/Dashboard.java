
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard  extends JFrame implements ActionListener{
    Dashboard(){
        
        setBounds(0,0,1550,1000);
        setLayout(null);
        
         ImageIcon desh= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpeg"));
     Image icon =desh.getImage();
     setIconImage(icon);
        
         setTitle("Dashboard");
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/piexl13.jpg"));
         Image i2=i1.getImage().getScaledInstance(1300,660, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
             image.setBounds(0,0,1300,660);
                add(image);
                
        JLabel text = new JLabel("THE TAJ GROUP WELCOME YOU");
        text.setBounds(290,100,1000,50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font( "TOHAMA",Font.PLAIN,46));
                image.add(text);
         
        JMenuBar mb= new JMenuBar();
        mb.setBounds(0,0,1550,20);
        image.add(mb);
                
        JMenu hotel =new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);
        
        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        reception.setForeground(Color.BLACK);
        hotel.add(reception);
        
         JMenu admin =new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        mb.add(admin);
        
//         JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
//         addemployee.addActionListener(this);
//          admin.add(addemployee);
//        
//         JMenuItem addroom=new JMenuItem("ADD ROOMS");
//         addroom.addActionListener(this);
//        admin.add(addroom);
//        
//         JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
//         adddrivers.addActionListener(this);
//       admin.add(adddrivers);
       
       
       JMenuItem next=new JMenuItem("Next");
         next.addActionListener(this);
       admin.add(next);
        
       
                        setVisible(true);
                        
                       
}

    
    public void actionPerformed(ActionEvent ae){
//    if (ae.getActionCommand().equals("ADD EMPLOYEE")){
//        new AddEmployee();
//    }
//    else if (ae.getActionCommand().equals("ADD ROOMS")){
//    
//    new AddRooms();
//    }
//     else if (ae.getActionCommand().equals("ADD DRIVERS")){
//    
//    new AddDriver();
//    }
     if (ae.getActionCommand().equals("RECEPTION")){
    
    new Reception();
    }
    else if (ae.getActionCommand().equals("Next")){
    
    new Next();
    }
    }
    public static void main( String[]args){
         new Dashboard();
    }
}
