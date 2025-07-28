package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Customerinfo extends JFrame implements ActionListener{
    
   JTable table;
   JButton back;
   JScrollBar s;
    JLabel label;
    Customerinfo(){
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
     setTitle("Customer Info");
           
            
         JLabel j1=new JLabel("Document");
            j1.setBounds(50,10,100,30);
            add(j1);
        
 
             JLabel j2=new JLabel("Number");
            j2.setBounds(130,10,100,30);
            add(j2);
            

            
             JLabel j3=new JLabel("Name");
            j3.setBounds(220,10,100,30);
            add(j3);
            
      
            
              JLabel j4=new JLabel(" Gender");
            j4.setBounds(280,10,100,30);
            add(j4);
            
            
            
              JLabel j5=new JLabel(" Country");
            j5.setBounds(350,10,100,30);
            add(j5);
            
             
              JLabel j6=new JLabel(" Room-No");
            j6.setBounds(420,10,100,30);
            add(j6);
            
              
              JLabel j7=new JLabel(" checkin time");
            j7.setBounds(490,10,100,30);
            add(j7);
            
            
             
              JLabel j8=new JLabel(" Deposit");
            j8.setBounds(570,10,100,30);
            add(j8);
            
            
            table = new JTable();
            table.setBounds(50,50,590,300);
            add(table);
             try{
            conn c = new conn ();
            ResultSet rs= c.s.executeQuery("select * from customer02");
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
    
//
//          label = new JLabel();          
//    label.setHorizontalAlignment(JLabel.RIGHT);    
//    label.setSize(600,100);  
//     JScrollBar s=new JScrollBar();  
//    s.setBounds(600,50, 50,600);  
//    label.add(s);   
//    
//   label.setLayout(null);  
//   label.setVisible(true); 
        
         
    setBounds(300,170,700,500);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
      new Reception();
    }
    
    
    public static void main(String []args){
    new Customerinfo();
    
    }
}
