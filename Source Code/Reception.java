
package hotel.management.system;


import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;


public class Reception extends JFrame implements ActionListener{
    
    JButton newCustomer,rooms,department,allemployeee,managerInfo,customers,searchRoom,check,update,roomStatus,pickup,logout;
     Reception(){
         
           getContentPane().setBackground(Color.WHITE);
           setLayout(null);
           setTitle("Reception");
           
            ImageIcon rec= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpeg"));
     Image icon =rec.getImage();
     setIconImage(icon);
        
           JLabel reception= new JLabel("Reception");
         reception.setBounds(300,20,300,30);
         reception.setFont(new Font("Tahoma",Font.BOLD,24));
         add(reception);
     
            newCustomer = new JButton("New Customer ");
           newCustomer.setBounds(550,30,200,30);
           newCustomer.setBackground(Color.BLACK);
           newCustomer.setForeground(Color.WHITE);
           newCustomer.addActionListener(this);
           add(newCustomer);
           
           
             
           rooms = new JButton("Rooms");
           rooms.setBounds(550,70,200,30);
           rooms.setBackground(Color.BLACK);
           rooms.setForeground(Color.WHITE);
           rooms.addActionListener(this);
           add(rooms);
           
           department = new JButton("Department");
           department.setBounds(550,110,200,30);
           department.setBackground(Color.BLACK);
           department.setForeground(Color.WHITE);
           department.addActionListener(this);
           add(department);
           
           
           allemployeee = new JButton("All Employee");
           allemployeee.setBounds(550,150,200,30);
           allemployeee.setBackground(Color.BLACK);
           allemployeee.setForeground(Color.WHITE);
           allemployeee.addActionListener(this);
           add(allemployeee);
           
           
                      
             customers = new JButton("Customer Info");
           customers.setBounds(550,190,200,30);
           customers.setBackground(Color.BLACK);
           customers.setForeground(Color.WHITE);
            customers.addActionListener(this);
           add(customers);
           
           
             managerInfo = new JButton("Manager Info");
           managerInfo.setBounds(550,230,200,30);
           managerInfo.setBackground(Color.BLACK);
           managerInfo.setForeground(Color.WHITE);
            managerInfo.addActionListener(this);
           add(managerInfo);
           
           
            
             check = new JButton("ChechOut");
           check.setBounds(550,270,200,30);
           check.setBackground(Color.BLACK);
           check.setForeground(Color.WHITE);
           check.addActionListener(this);
           add(check);
           
           update = new JButton("Update Status");
           update.setBounds(550,310,200,30);
           update.setBackground(Color.BLACK);
           update.setForeground(Color.WHITE);
           update.addActionListener(this);
           add(update);
           
           
                 roomStatus = new JButton("Update Room Status");
           roomStatus.setBounds(550,350,200,30);
           roomStatus.setBackground(Color.BLACK);
           roomStatus.setForeground(Color.WHITE);
           roomStatus.addActionListener(this);
           add(roomStatus);
           
                 pickup = new JButton("Pickup Services");
           pickup.setBounds(550,390,200,30);
           pickup.setBackground(Color.BLACK);
           pickup.setForeground(Color.WHITE);
           pickup.addActionListener(this);
           add(pickup);
           
           
               searchRoom = new JButton("Search Room");
           searchRoom.setBounds(550,430,200,30);
           searchRoom.setBackground(Color.BLACK);
           searchRoom.setForeground(Color.WHITE);
            searchRoom.addActionListener(this);
           add(searchRoom);
           
           
            
             logout = new JButton("Logout");
           logout.setBounds(550,470,200,30);
           logout.setBackground(Color.BLACK);
           logout.setForeground(Color.WHITE);
           logout.addActionListener(this);
           add(logout);
           
           
           
                 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/pixel15.jpg"));
         Image i2=i1.getImage().getScaledInstance(800,550, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
             image.setBounds(0,0,800,550);
                add(image);
           
                JTextArea ta= new JTextArea();
                ta.setBounds(0,0,700,500);
                add(ta);
                
              setBounds(250,100,800,570);
              setVisible(true);
           
      
     }
        
    
    
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== newCustomer){
        setVisible(false);
         new AddCustomer();
    }else if(ae.getSource()==rooms){
         setVisible(false);
           new Room();
          }else if(ae.getSource()==department){
        setVisible(false);
        new Department();
    }else if(ae.getSource()==allemployeee){
        setVisible(false);
        new Employeeinfo();
    }else if(ae.getSource()==managerInfo){
        setVisible(false);
        new Managerinfo();
    }else if(ae.getSource()==customers){
        setVisible(false);
        new Customerinfo();
    }else if(ae.getSource()==searchRoom){
        setVisible(false);
        new SearchRoom();
    }else if(ae.getSource()==update){
        setVisible(false);
        new UpdateCheck();
    }else if(ae.getSource()==roomStatus){
        setVisible(false);
        new UpdateRoom();
    }else if(ae.getSource()==pickup){
        setVisible(false);
        new Pickup();
    }else if(ae.getSource()==check){
        setVisible(false);
        new Checkout();
    }else if(ae.getSource()==logout){
        setVisible(false);
        System.exit(0);
    }
    
    
    }
    
    
    
    public static void main(String []args){
        new Reception();
    }
}
