
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminWork  extends JFrame implements ActionListener{
    AdminWork(){
        
        setBounds(0,0,1550,1000);
        setLayout(null);
         setTitle("ADMIN");
         
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/pixel9.jpg"));
         Image i2=i1.getImage().getScaledInstance(1300,700, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
             image.setBounds(0,0,1300,700);
                add(image);
                
        JLabel text = new JLabel("THE TAJ GROUP WELCOME YOU");
        text.setBounds(20,80,700,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font( "TOHAMA",Font.PLAIN,30));
                image.add(text);
         
        JMenuBar mb= new JMenuBar();
        mb.setBounds(0,0,1550,20);
        image.add(mb);
                
      
        
      
        
         JMenu admin =new JMenu("ADMIN WORK");
        admin.setForeground(Color.BLACK);
        mb.add(admin);
        
         JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
         addemployee.addActionListener(this);
          admin.add(addemployee);
        
         JMenuItem addroom=new JMenuItem("ADD ROOMS");
         addroom.addActionListener(this);
        admin.add(addroom);
        
         JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
         adddrivers.addActionListener(this);
       admin.add(adddrivers);
                    
                        setVisible(true);
                        
                       
}

    
    public void actionPerformed(ActionEvent ae){
    if (ae.getActionCommand().equals("ADD EMPLOYEE")){
        new AddEmployee();
    }
    else if (ae.getActionCommand().equals("ADD ROOMS")){
    
    new AddRooms();
    }
     else if (ae.getActionCommand().equals("ADD DRIVERS")){
    
    new AddDriver();
    }
    }
    public static void main( String[]args){
         new AdminWork();
    }
}
