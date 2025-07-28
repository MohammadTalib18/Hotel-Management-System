package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Room extends JFrame implements ActionListener{
    
   JTable table;
   JButton back;
    
           
    Room(){
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setTitle("Room");
//      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jng"));
//           Image i3 = i1.getImage().getScaledInstance(200, 400,Image.SCALE_DEFAULT);
//            ImageIcon i2 = new ImageIcon(i3);
//            JLabel image = new JLabel(i2);
//            image.setBounds(400,10,200,400);
//           add(image);
  
            JLabel j1=new JLabel("Room number");
            j1.setBounds(50,10,100,30);
            add(j1);
        
 
             JLabel j2=new JLabel("Avaailability");
            j2.setBounds(190,10,100,30);
            add(j2);
            

            
             JLabel j3=new JLabel("Cleaning Status");
            j3.setBounds(330,10,100,30);
            add(j3);
            
      
            
              JLabel j4=new JLabel(" Price");
            j4.setBounds(470,10,100,30);
            add(j4);
            
            
            
              JLabel j5=new JLabel(" Bed Type");
            j5.setBounds(610,10,100,30);
            add(j5);
            

            
          
            
            
           
             table = new JTable();
            table.setBounds(50,50,700,300);
            add(table);
             try{
            conn c = new conn ();
            ResultSet rs= c.s.executeQuery("select * from room01");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)  {
                e.printStackTrace();
            }
            
        
        back = new JButton("Back");
        back.addActionListener(this);
	back.setBounds(350, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
    
        
        
        
             
         
    setBounds(220,180,800,500);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
      new Reception();
    }
    
    
    public static void main(String []args){
    new Room();
    
    }
}



//
//package hotel.management.system;
//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;
//import java.util.Date;
//import java.awt.event.*;
//
//public class Room extends JFrame implements ActionListener{
//    JComboBox comboid ;
//    JTextField tfnumber,tfname,tfcountry,tfdeposit;
//    JRadioButton rbmale,rbfemale;
//    Choice croom;
//    JLabel checkintime;
//    JButton add,back;
//    Room(){
//   getContentPane().setBackground(Color.WHITE);
//    setLayout(null);
//    
//              ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jng"));
//            Image i3 = i1.getImage().getScaledInstance(350, 500,Image.SCALE_DEFAULT);
//            ImageIcon i2 = new ImageIcon(i3);
//            JLabel image = new JLabel(i2);
//            image.setBounds(430,10,350,500);
//            add(image);
//            
//            JLabel j1= new JLabel("Room Number");
//            setBounds(10,10,100,20);
//           add(j1);
//              
//           
//            JLabel j2= new JLabel("Availability");
//            setBounds(120,10,100,20);
//            add(j2);
//            
//            
//            JLabel j3= new JLabel("Clean Status");
//            setBounds(230,10,100,20);
//            add(j3);
//            
//            JLabel j4= new JLabel("Price");
//            setBounds(340,10,100,20);
//            add(j4);
//            
//            
//            JLabel j5= new JLabel("Bed Type");
//            setBounds(450,10,100,20);
//            add(j5);
//            
//            JLabel j6= new JLabel("Room Number");
//            setBounds(560,10,100,20);
//            add(j6);
//            
//         
//         
//         
//          
//        
//         
//         
//         add = new JButton("Add");
//	add.addActionListener(this);
//	add.setBounds(240, 410, 120, 33);
//        add.setBackground(Color.BLACK);
//        add.setForeground(Color.WHITE);
//	add(add);
//        
//        
//          back = new JButton("Back");
//	back.addActionListener(this);
//	back.setBounds(60, 410, 120, 33);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//	add(back);
//        
//        
//        
//
//        
//         
//    setBounds(250,180,850,500);
//    setVisible(true);
//    
//    }
//    
//    public void actionPerformed(ActionEvent ae){
//        if (ae.getSource() == add){
//            String id = (String)comboid.getSelectedItem();
//             String name = tfname.getText();
//             String number = tfnumber.getText();
//             String gender = null;
//            
//             
//              if(rbmale.isSelected()){
//                        gender = "Male";
//                    
//                    }else if(rbfemale.isSelected()){
//                        gender = "Female";
//                    }
//              
//              String country = tfcountry.getText();
//              String room= croom.getSelectedItem();
//              String time = checkintime.getText();
//              String deposit= tfdeposit.getText();
//              
//              try{
//              
//              String query= "insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
//              
//              String query2="update room set availability ='Occupied' where roomnumber '"+room+"'";
//              
//              conn conn = new conn ();
//              conn.s.executeUpdate(query);
//              conn.s.executeUpdate(query2);
//              
//              JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
//              
//              setVisible(false);
//              new Reception();
//              
//              }
//              catch(Exception e){
//              e.printStackTrace();
//              
//              }
//             
//        }
//        else if (ae.getSource() == back){
//            setVisible(false);
//            new Reception();
//                }
//        
//    }
//    
//    
//    public static void main(String []args){
//    new Room();
//    
//    }
//}




//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import net.proteanit.sql.*;
//
//
//
//public class Room extends JFrame implements ActionListener {
//    JTable table;
//   JButton back;
//  
//         Room(){
//        
//        
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//      
//            
//              JLabel J1= new JLabel("Department");
//            setBounds(50,20,100,20);
//            add(J1);
//            
//           
//              
//          JLabel J2= new JLabel("Budget");
//            setBounds(150,20,100,20);
//            add(J2);
//            
//     
//            JLabel s2=new JLabel("Add me");
//            s2.setBounds(10,20,100,30);
//            add(s2);
//            
//            
//            
//             table = new JTable();
//            table.setBounds(50,40,500,400);
//            add(table);
//            
//            try{
//            conn c = new conn ();
//            ResultSet rs= c.s.executeQuery("select * from department");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//                
//            }catch(Exception e)  {
//                e.printStackTrace();
//            }
//            
//            
//        back = new JButton("Back");
//        back.addActionListener(this);
//	back.setBounds(200, 400, 120, 30);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//	add(back);
//    
//    setBounds(220,180,900,480);
//    setVisible(true);
//    
//    }
//    
//    
//      public void actionPerformed(ActionEvent ae){
//          
//      setVisible(false);
//      new Reception();
//      
//      
//      }
//      public static void main(String [] args){
//    
//        new Room();
//    }
//}