package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public  class HotelManagementSystem  extends JFrame implements ActionListener{
 
    HotelManagementSystem(){
//    setSize(1366,568);
// setLocation(0,50);
        setLayout(null);
        setBounds(0,0,1550,1000);
     setTitle("HOTEL MANAGEMENT SYSTEM");
 
     ImageIcon hotel= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpeg"));
     Image icon =hotel.getImage();
     setIconImage(icon);
     
 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/pixel7.jpg"));
         Image i2=i1.getImage().getScaledInstance(1300,800, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
             image.setBounds(0,0,1300,800);
                add(image);

 
    JLabel text =new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(260,10,1000,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.PLAIN,50));
    image.add(text);
   
   JButton next = new JButton("NEXT");
    next.setBounds(1130,530,90,30);
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.addActionListener(this);
    next.setFont(new Font("TAHOMA",Font.PLAIN,18));
    image.add(next);
 
      setVisible(true);
      
            
//                  while(true){
//                        text.setVisible(false); // lid =  j label
//                    try{
//                        Thread.sleep(700); //1000 = 1 second
//                    }catch(Exception e){} 
//                        text.setVisible(true);
//                    try{
//                        Thread.sleep(700);
//                    }catch(Exception e){}
//                }
   
    }
                   public void actionPerformed(ActionEvent ac){
                    setVisible(true);
                        new Login();
}
 
  
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}
