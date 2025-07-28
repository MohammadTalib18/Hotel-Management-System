package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Managerinfo extends JFrame implements ActionListener{
    
   JTable table;
   JButton back;
 
    Managerinfo(){
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
           setTitle("Manager Info");
            
         JLabel j1=new JLabel("Name");
            j1.setBounds(50,10,100,30);
            add(j1);
        
 
             JLabel j2=new JLabel("Age");
            j2.setBounds(120,10,100,30);
            add(j2);
            

            
             JLabel j3=new JLabel("Gender");
            j3.setBounds(190,10,100,30);
            add(j3);
            
      
            
              JLabel j4=new JLabel(" Job");
            j4.setBounds(260,10,100,30);
            add(j4);
            
            
            
              JLabel j5=new JLabel(" Salary");
            j5.setBounds(330,10,100,30);
            add(j5);
            
             
              JLabel j6=new JLabel(" Phone");
            j6.setBounds(400,10,100,30);
            add(j6);
            
              
              JLabel j7=new JLabel(" E-mail");
            j7.setBounds(470,10,100,30);
            add(j7);
            
            
             
              JLabel j8=new JLabel(" Aadhar");
            j8.setBounds(550,10,100,30);
            add(j8);
            
            
            table = new JTable();
            table.setBounds(50,50,600,340);
            add(table);
             try{
            conn c = new conn ();
            ResultSet rs= c.s.executeQuery("select * from employee12  where job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)  {
                e.printStackTrace();
            }
        
        back = new JButton("Back");
        back.addActionListener(this);
	back.setBounds(300, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
    
        
        
        
             
         
    setBounds(300,170,700,500);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
      new Reception();
    }
    
    
    public static void main(String []args){
    new Managerinfo();
    
    }
}
