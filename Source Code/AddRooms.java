
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*; 


public class AddRooms  extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
     AddRooms(){
         
         getContentPane().setBackground(Color.WHITE);
         
         setLayout(null);
         setTitle("Add Rooms");
         
         
         JLabel heading= new JLabel("Add Rooms");
         heading.setBounds(150,20,200,20);
         heading.setFont(new Font("Tahoma",Font.BOLD,17));
         add(heading);
         
         
         
         JLabel lblroomno= new JLabel("Room Number");
         lblroomno.setBounds(60,80,120,30);
         lblroomno.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblroomno);
      
              tfroom = new JTextField();
            tfroom.setBounds(200, 80, 150, 30);
            add(tfroom);
            
            
             
         JLabel lblavailable= new JLabel("Available");
         lblavailable.setBounds(60,130,120,30);
         lblavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblavailable);
         
         String availableOptions[]= { "Available", "Occupied" };
          availablecombo = new JComboBox(availableOptions);
         availablecombo.setBounds(200,130,150,30);
          availablecombo.setBackground(Color.WHITE);
          add(availablecombo);
         
          
                   
         JLabel lblclean= new JLabel("Cleaning Status");
         lblclean.setBounds(60,180,120,30);
         lblclean.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblclean);
         
         String cleanOptions[]= { "Clean", "Dirty" };
          cleancombo = new JComboBox(cleanOptions);
         cleancombo.setBounds(200,180,150,30);
          cleancombo.setBackground(Color.WHITE);
          add(cleancombo);
          
          
          
                JLabel lblprice= new JLabel("Price");
              lblprice.setBounds(60,230,120,30);
              lblprice.setFont(new Font("Tahoma",Font.PLAIN,14));
              add(lblprice);
      
          tfprice = new JTextField();
           tfprice.setBounds(200, 230, 150, 30);
            add(tfprice);
            
          
          
            JLabel lbltype= new JLabel("Bed Type");
         lbltype.setBounds(60,280,120,30);
         lbltype.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lbltype);
         
         String typeOptions[]= { "Single Bed", "Double Bed" };
          typecombo = new JComboBox(typeOptions);
         typecombo.setBounds(200,280,150,30);
          typecombo.setBackground(Color.WHITE);
          add(typecombo);
          
          
         add = new JButton("Add");
	add.addActionListener(this);
	add.setBounds(220, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);
        
        
          cancel = new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(60, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	add(cancel);
        
        
           
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
            
                JLabel image = new JLabel(i1);
                image.setBounds(400,30,500,350);
                add(image);
        
            
         setBounds(200,180,940,470);
         setVisible(true);
            
}   
     
      public void actionPerformed(ActionEvent ae){
          
    if(ae.getSource() == add){
                    String roomnumber = tfroom.getText();
                String availability = (String)availablecombo.getSelectedItem();
                String status = (String)cleancombo.getSelectedItem();
                String price  = tfprice.getText();
                String type = (String)typecombo.getSelectedItem();
                
                try{
                    conn conn = new conn();
                 String str = "INSERT INTO room01 values('"+roomnumber+"', '"+availability+"', '"+status+"','"+price+"', '"+type+"')";
                 
                 conn.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"New Room added Successfully");
                 setVisible(false);
                 
                 
                }catch(Exception e){
                    e.printStackTrace();
                
                }
                
                
                
    }   else if(ae.getSource() == cancel){
                this.setVisible(false);
            }   
          
      }
     
     
      public static void main(String[]args){
   new AddRooms();
}
    
}



