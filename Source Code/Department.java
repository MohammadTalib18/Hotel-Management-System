
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Department extends JFrame implements ActionListener {
    JTable table;
   JButton back;
  
         Department(){
        
         setTitle("Deaprtment");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      
            
            JLabel j1=new JLabel("Department");
            j1.setBounds(100,10,100,30);
            add(j1);
        
 
             JLabel j2=new JLabel("Budget");
            j2.setBounds(350,10,100,30);
            add(j2);
            

            
            
             table = new JTable();
            table.setBounds(50,50,400,300);
            add(table);
             try{
            conn c = new conn ();
            ResultSet rs= c.s.executeQuery("select * from department01;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)  {
                e.printStackTrace();
            }
            
            
            
        back = new JButton("Back");
        back.addActionListener(this);
	back.setBounds(200, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
    
    setBounds(380,180,500,500);
    setVisible(true);
    
    }
    
    
      public void actionPerformed(ActionEvent ae){
          
      setVisible(false);
      new Reception();
      
      
      }
      public static void main(String [] args){
    
        new Department();
    }
}



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
//
//
//public class Department  extends JFrame implements ActionListener{
//    
//    JTable table;
//   JButton back;
//         Department(){
//        
//        
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//      
//            
//            JLabel j1= new JLabel("Department");
//            setBounds(180,30,100,20);
//            add(j1);
//            
//           
//              
//            JLabel j2= new JLabel("Budget");
//            setBounds(370,30,100,20);
//            add(j2);
//            
//     
//            
//             table = new JTable();
//            table.setBounds(0,40,500,400);
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
//	back.addActionListener(this);
//	back.setBounds(200, 400, 120, 30);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//	add(back);
//    
//    setBounds(250,130,800,550);
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
//    
//    
//    public static void main(String [] args){
//    
//        new Department();
//    }
//}
