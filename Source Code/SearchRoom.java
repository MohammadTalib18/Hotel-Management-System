package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class SearchRoom extends JFrame implements ActionListener{
    
   JTable table;
   JButton back,submit;
    JComboBox bedtype;
      JCheckBox available ,occupied;
    SearchRoom(){
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
setTitle("Search Room");

JLabel text= new JLabel ("Search For Room");
text.setBounds(310,10,200,20);
 text.setFont(new Font("Tahoma", Font.PLAIN, 25));
add(text);


JLabel lblbed= new JLabel ("Bed Type");
 lblbed.setFont(new Font("Tahoma", Font.PLAIN, 17));
lblbed.setBounds(50,60,100,20);
add(lblbed);

bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
bedtype.setBounds(150,60,100,20);
 bedtype.setFont(new Font("Tahoma", Font.PLAIN, 14));
 bedtype.setBackground(Color.WHITE);
add(bedtype);



available = new JCheckBox("Only Display Available");
available.setBounds(600,60,180,20);
available.setBackground(Color.WHITE);
add(available);

occupied = new JCheckBox("Only Display Occupied");
occupied.setBounds(600,85,180,20);
occupied.setBackground(Color.WHITE);
add(occupied);

            JLabel j1=new JLabel("Room number");
            j1.setBounds(50,110,100,30);
            add(j1);
        
 
             JLabel j2=new JLabel("Availability");
            j2.setBounds(190,110,100,30);
            add(j2);
            

            
             JLabel j3=new JLabel("Cleaning Status");
            j3.setBounds(330,110,100,30);
            add(j3);
            
      
            
              JLabel j4=new JLabel(" Price");
            j4.setBounds(470,110,100,30);
            add(j4);
            
            
            
              JLabel j5=new JLabel(" Bed Type");
            j5.setBounds(610,110,100,30);
            add(j5);
            

            
          
            
            
           
             table = new JTable();
            table.setBounds(50,150,700,250);
            add(table);
             try{
            conn c = new conn ();
            ResultSet rs= c.s.executeQuery("select * from room01");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)  {
                e.printStackTrace();
            }
            
             
         submit = new JButton("Submit");
        submit.addActionListener(this);
	submit.setBounds(400, 400, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
	add(submit);
    
        
        
        back = new JButton("Back");
        back.addActionListener(this);
	back.setBounds(200, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
    
        
        
        
             
         
    setBounds(240,170,800,500);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
        
            try{
                String query1="select * from room01 where bed_type ='"+bedtype.getSelectedItem()+"'";
                String query2= "select * from room01 where availability= 'Available' AND bed_type ='"+bedtype.getSelectedItem()+"'";
                String query3= "select * from room01 where availability= 'Occupied' AND bed_type ='"+bedtype.getSelectedItem()+"'";
                
                
                conn conn= new conn();
                ResultSet rs;
                if(available.isSelected()){
                rs=conn.s.executeQuery(query2);
                }else if(occupied.isSelected()){
                     rs=conn.s.executeQuery(query3);
         
                } else {
                rs=conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
                
            }
            
        
        }else{       
        setVisible(false);
            new Reception();
        }
          
    }
    
    
    public static void main(String []args){
    new SearchRoom();
    
    }
}
