
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid ;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    AddCustomer(){
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    setTitle("Customer Form");
    
       JLabel newCustomer= new JLabel("New Customer Form");
         newCustomer.setBounds(100,10,300,30);
         newCustomer.setFont(new Font("Tahoma",Font.BOLD,17));
         add(newCustomer);
    
           JLabel lblid= new JLabel("ID");
         lblid.setBounds(35,70,100,20);
         lblid.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblid);
         
         String Options []={"Aadhar-Card","Pass-Port","Driving-License"};
         
        
         comboid= new JComboBox(Options);
         comboid.setFont(new Font("Tahoma",Font.PLAIN,14));
         comboid.setBounds(200,70,150,25);
          comboid.setBackground(Color.WHITE);
         add(comboid);
         
         JLabel lblnumber= new JLabel("Number");
         lblnumber.setBounds(35,110,100,20);
         lblnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblnumber);
         
          tfnumber =new JTextField();
         tfnumber.setBounds(200,110,150,25);
         add(tfnumber);
         
         
          JLabel lblname= new JLabel("Name");
         lblname.setBounds(35,150,100,20);
         lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblname);
         
          tfname =new JTextField();
         tfname.setBounds(200,150,150,25);
         add(tfname);
         
         
          JLabel lblgender = new JLabel("Gender");
            lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblgender.setBounds(35, 190, 120, 30);
            add(lblgender);
            
            rbmale=new  JRadioButton("MALE");
            rbmale.setBackground(Color.WHITE);
            rbmale.setBounds(200, 190, 60, 25);
            add(rbmale);
	
             rbfemale = new JRadioButton("FEMALE");
            rbfemale.setBackground(Color.WHITE);
            rbfemale.setBounds(280, 190, 100, 25);
            add(rbfemale);
            
            ButtonGroup bg=new ButtonGroup();
            bg.add(rbmale);
            bg.add(rbfemale);
            
             JLabel lblcountry= new JLabel("Country");
         lblcountry.setBounds(35,230,100,20);
         lblcountry.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblcountry);
         
          tfcountry =new JTextField();
         tfcountry.setBounds(200,230,150,25);
         add(tfcountry);
            
         
           JLabel lblroom= new JLabel(" Room Number");
         lblroom.setBounds(30,270,150,20);
         lblroom.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblroom);
         
         croom = new Choice();
         try{
            conn conn = new conn();
            String query= "select * from room01 where availability = 'Available'";
             ResultSet rs = conn.s.executeQuery(query);
             while (rs.next()){
             croom.add(rs.getString("roomnumber"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         croom.setBounds(200,270,150,25);
         add(croom);
         
         
         
           JLabel lbltime= new JLabel(" Check-in Time");
         lbltime.setBounds(30,310,110,20);
         lbltime.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lbltime);
         
         Date date = new Date();
         
         
           checkintime= new JLabel(" "+ date);
         checkintime.setBounds(200,310,170,25);
         checkintime.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(checkintime);
        
         
           JLabel lbldeposit= new JLabel("Deposit");
         lbldeposit.setBounds(35,350,100,20);
         lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lbldeposit);
         
          tfdeposit =new JTextField();
         tfdeposit.setBounds(200,350,150,25);
         add(tfdeposit);
         
         
         add = new JButton("Add");
	add.addActionListener(this);
	add.setBounds(240, 410, 120, 33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);
        
        
          back = new JButton("Back");
	back.addActionListener(this);
	back.setBounds(60, 410, 120, 33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
        
        
        
              ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
            Image i3 = i1.getImage().getScaledInstance(350, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(430,10,350,500);
            add(image);
        
         
    setBounds(250,130,800,500);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String id = (String)comboid.getSelectedItem();
             String name = tfname.getText();
             String number = tfnumber.getText();
             String gender = null;
            
             
              if(rbmale.isSelected()){
                        gender = "Male";
                    
                    }else if(rbfemale.isSelected()){
                        gender = "Female";
                    }
              
              String country = tfcountry.getText();
              String room= croom.getSelectedItem();
              String time = checkintime.getText();
              String deposit= tfdeposit.getText();
              
              try{
              
              String query= "insert into customer02 values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
              
              String query2="update room set availability ='Occupied' where roomnumber '"+room+"'";
              
              conn conn = new conn ();
              conn.s.executeUpdate(query);
              conn.s.executeUpdate(query2);
              
//              JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
               JOptionPane.showMessageDialog(null,"New customer added Successfully");
              setVisible(false);
              new Reception();
              
              }
              catch(Exception e){
              e.printStackTrace();
              
              }
             
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Reception();
                }
        
    }
    
    
    public static void main(String []args){
    new AddCustomer();
    
    }
}
