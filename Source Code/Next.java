
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public  class Next  extends JFrame implements ActionListener {
 
    Next(){
//    setSize(1366,568);
// setLocation(0,50);
  
        setLayout(null);
        setBounds(200,50,100,80);
    
 

  
 
  
   
   JButton next = new JButton("NEXT");
    next.setBounds(10,10,90,20);
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
     next.addActionListener(this);
    next.setFont(new Font("TAHOMA",Font.PLAIN,18));
    add(next);
 
      setVisible(true);
      
            
                 
    }
  public void actionPerformed(ActionEvent ac){
                    setVisible(false);
                        new Login01();
}
  
    public static void main(String[] args) {
        new Next();
        
    }
    
}
