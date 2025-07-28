
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*; 




public class AddDriver extends JFrame implements ActionListener{
    
    
     JButton add,back;
    JTextField tfname,tfmodel,tfage,tfcompany,tflocation;
    JComboBox availablecombo,gendercombo;

            
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         setTitle("Add Drivers");
         
           JLabel heading= new JLabel("Add Drivers");
         heading.setBounds(150,10,200,20);
         heading.setFont(new Font("Tahoma",Font.BOLD,17));
         add(heading);
         
         
         
         
         
           JLabel lblname= new JLabel("Name");
         lblname.setBounds(60,50,120,30);
         lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblname);
      
              tfname = new JTextField();
            tfname.setBounds(200, 50, 150, 30);
            add(tfname);
         
         
            
         
         
           JLabel lblage= new JLabel("Age");
         lblage.setBounds(60,90,120,30);
         lblage.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblage);
      
              tfage = new JTextField();
            tfage.setBounds(200, 90, 150, 30);
            add(tfage);
         
            
            
         
         
                     
         JLabel lblgender= new JLabel("Gender");
         lblgender.setBounds(60,130,120,30);
         lblgender.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblgender);
         
         String genderOptions[]= { "Male", "Female" };
          gendercombo = new JComboBox(genderOptions);
         gendercombo.setBounds(200,130,150,30);
          gendercombo.setBackground(Color.WHITE);
          add(gendercombo);
          
            
         
         
               JLabel lblcompany= new JLabel("Car Company");
         lblcompany.setBounds(60,170,120,30);
         lblcompany.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblcompany);
      
              tfcompany = new JTextField();
            tfcompany.setBounds(200, 170, 150, 30);
            add(tfcompany);
         
            
            
            
              JLabel lblmodel= new JLabel("Car Model");
         lblmodel.setBounds(60,210,120,30);
         lblmodel.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblmodel);
      
              tfmodel = new JTextField();
            tfmodel.setBounds(200, 210, 150, 30);
            add(tfmodel);
         
            
            
            
              JLabel lblavailable= new JLabel("Available");
         lblavailable.setBounds(60,250,120,30);
         lblavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblavailable);
         
         String availableOptions[]= { "Yes", "No" };
          availablecombo = new JComboBox(availableOptions);
         availablecombo.setBounds(200,250,150,30);
          availablecombo.setBackground(Color.WHITE);
          add(availablecombo);
         
          
          
          
              JLabel lblloaction= new JLabel("Location");
         lblloaction.setBounds(60,290,120,30);
         lblloaction.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblloaction);
      
              tflocation = new JTextField();
            tflocation.setBounds(200, 290, 150, 30);
            add(tflocation);
            
            
              
         add = new JButton("Add");
	add.addActionListener(this);
	add.setBounds(220, 350, 130, 33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);
        
        
          back = new JButton("Back");
	back.addActionListener(this);
	back.setBounds(60, 350, 130, 33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
        
        
        
          ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
         Image i2=i1.getImage().getScaledInstance(500,350, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
             image.setBounds(400,30,500,350);
                add(image);
            
           setBounds(200,180,940,450);
         setVisible(true);
            
    }
    
    
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == add){
                 String name = tfname.getText();
                String age = tfage.getText();         
                String gender = (String)gendercombo.getSelectedItem();
                String company  = tfcompany.getText();
                String model = tfmodel.getText();
                String available = (String)availablecombo.getSelectedItem();
                String location = tflocation.getText();
                
                try{
                    conn conn = new conn();
                 String str = "INSERT INTO DRIVER values('"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"','"+available+"','"+location+"')";
                 
                 conn.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"New driver added Successfully");
                 setVisible(false);
                 
                 
                }catch(Exception e){
                    e.printStackTrace();
                
                }
                
                
                
    }   else if(ae.getSource() == back){
                this.setVisible(false);
            }   
          
      
      }
    
    
    
    
    

public static void main(String [] args){

new AddDriver();

}
}