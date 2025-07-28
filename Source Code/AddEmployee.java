package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*; 
public class AddEmployee extends JFrame implements ActionListener{ 

    
	JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
        JRadioButton rbmale,rbfemale;
        JButton add,back;
        JComboBox cbjob;

         AddEmployee(){
            
                 setTitle("Add Employees");
      setLayout(null);
      
         JLabel heading= new JLabel("Add Employee");
         heading.setBounds(500,20,200,20);
         heading.setFont(new Font("Tahoma",Font.BOLD,20));
         add(heading);
      		
         
            JLabel lblname = new JLabel("NAME");
            lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblname.setBounds(60, 20, 120, 30);
            add(lblname);
            
            tfname = new JTextField();
            tfname.setBounds(200, 20, 150, 30);
            add(tfname);
            
            
            
            
            JLabel lblage = new JLabel("AGE");
            lblage.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblage.setBounds(60, 70, 120, 30);
            add(lblage);
            
             tfage = new JTextField();
            tfage.setBounds(200, 70, 150, 30);
            add(tfage);
      
            
            
            
                  
            JLabel lblgender = new JLabel("GENDER");
            lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblgender.setBounds(60, 120, 120, 30);
            add(lblgender);
            
            rbmale=new  JRadioButton("MALE");
            rbmale.setBackground(Color.WHITE);
            rbmale.setBounds(200, 110, 70, 30);
            add(rbmale);
	
             rbfemale = new JRadioButton("FEMALE");
            rbfemale.setBackground(Color.WHITE);
            rbfemale.setBounds(280, 110, 100, 30);
            add(rbfemale);
            
            ButtonGroup bg=new ButtonGroup();
            bg.add(rbmale);
            bg.add(rbfemale);
            
            
            
             JLabel  lbljob = new JLabel("JOB");
            lbljob.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lbljob.setBounds(60, 170, 150, 27);
            add(lbljob);
			
            String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            JComboBox rbjob = new JComboBox(str);
            rbjob.setBackground(Color.WHITE);
            rbjob.setBounds(200,170,150,30);
            add(rbjob);
            
            
            
            
              JLabel lblsalary = new JLabel("SALARY");
            lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblsalary.setBounds(60, 220, 120, 30);
            add(lblsalary);
            
             tfsalary = new JTextField();
            tfsalary.setBounds(200, 220, 150, 30);
            add(tfsalary);
            
            
            
            
              JLabel lblphone = new JLabel("PHONE");
            lblphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblphone.setBounds(60, 270, 120, 30);
            add(lblphone);
            
             tfphone = new JTextField();
            tfphone.setBounds(200, 270, 150, 30);
            add(tfphone);
            
            
            
            
              JLabel lblemail = new JLabel("E-MAIL");
            lblemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblemail.setBounds(60, 320, 120, 30);
            add(lblemail);
            
            tfemail = new JTextField();
            tfemail.setBounds(200, 320, 150, 30);
            add(tfemail);
        
            
            
               JLabel lblaadhar = new JLabel("AADHAR");
            lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblaadhar.setBounds(60, 370, 120, 30);
            add(lblaadhar);
            
            tfaadhar = new JTextField();
            tfaadhar.setBounds(200, 370, 150, 30);
            add(tfaadhar);
            
            
             
            add = new JButton("Add");
            add.setBounds(600, 400, 130, 30);
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.addActionListener(this);
            add(add);
            
            
            
         back = new JButton("Back");
	back.addActionListener(this);
	back.setBounds(410, 400, 130, 33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
            
            
              ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(380,60,450,370);
            add(image);
            
            
            
            getContentPane().setBackground(Color.WHITE);
            setBounds(230,180,850,500);
            setVisible(true);
        }
        
        
        public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String salary=tfsalary.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String aadhar=tfaadhar.getText();
            String job = (String)cbjob.getSelectedItem();
         
            String gender = null;
                    
            
                    if(rbmale.isSelected()){
                        gender = "Male";
                    
                    }else if(rbfemale.isSelected()){
                        gender = "Female";
                    }
        
                    
                  
                    
                    try{
                    conn conn = new conn();
                 String str = "INSERT INTO EMPLOYEE12 values('"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
                 
                 conn.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"New Employee Added Successfully");
                 setVisible(false);
                 
                    
                    } catch (Exception e) {
                        e.printStackTrace();
                      
        	    }  
            } else if(ae.getSource() == back){
                this.setVisible(false);
            }  
        }
        
    public static void main(String[] args){
        new AddEmployee();
    }   
}