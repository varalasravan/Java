package hw5;
import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Calculatortwo extends JPanel implements ActionListener
{
    //private JFrame frame2;
    private JTextField xfield, yfield;
    private JLabel result;
    private JButton computeButton;
    private JPanel apanel,ypanel;
    private JCheckBox cb;
    public Calculatortwo()
    {
         cb = new JCheckBox("Floating results");  
     	 apanel = new JPanel();
         ypanel = new JPanel();
         ypanel.add(cb);
         
         apanel.setLayout(new GridLayout(3,2));
	 ypanel.setLayout(new GridLayout(6,2));
	 
         apanel.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.yellow));
         JLabel x=new JLabel("x:");
         x.setHorizontalAlignment(JLabel.RIGHT);
         apanel.add(x);
         
       	 xfield = new JTextField("0", 5);
         apanel.add(xfield);
         JLabel y=new JLabel("y:");
         apanel.add(y);
         y.setHorizontalAlignment(JLabel.RIGHT);
         
         
         yfield = new JTextField("0", 5);
         apanel.add(yfield);
         yfield.setAlignmentX(JLabel.RIGHT);
         JLabel z=new JLabel("Total:");
         apanel.add(z);
         z.setHorizontalAlignment(JLabel.RIGHT);
         result = new JLabel("0");
         result.setBackground(Color.yellow);
         apanel.add(result);
         
         add(apanel, BorderLayout.NORTH);
         add(ypanel, BorderLayout.SOUTH);
  
         String[] menus={"Multiply","Add","Subtract","Divide","Pow","Clear"};
         JComboBox menu=new JComboBox(menus);
         ypanel.add(menu);
         menu.addActionListener(this);
         setVisible(true);
    }

public void actionPerformed(ActionEvent event)      
{
   
	int x = 0;
        int y = 0;
        String xText = xfield.getText();
        String yText = yfield.getText();
       
        
        JComboBox jcb = (JComboBox)event.getSource();
        String menu  = (String)jcb.getSelectedItem();
               
 if(isInteger(xText)&&isInteger(yText))
 {
     
        x = Integer.parseInt(xText);
        y = Integer.parseInt(yText);
        
        Font f = new Font("Verdana",Font.BOLD,12);
        result.setFont(f);
        result.setForeground(Color.red);
        
    if(menu.equals("Multiply"))
    {
        if(cb.isSelected())
            result.setText(Float.toString((float)x*y));
        else
            result.setText(Integer.toString(x*y));
    }
    else if(menu.equals("Add"))
    {
        if(cb.isSelected())
            result.setText(Float.toString((float)x+y));
        else
            result.setText(Integer.toString(x+y));    
    }
        
    else if(menu.equals("Subtract"))
    {
        if(cb.isSelected())
            result.setText(Float.toString((float)x-y));
        else
            result.setText(Integer.toString(x-y));
            
    }
    else if(menu.equals("Divide"))
    {
        if(y!=0)
        {
            if(cb.isSelected())
                result.setText(Float.toString((float)x/y));
            else                 
                result.setText(Integer.toString(x/y));
        }
        else
        {   
            result.setText("Error");
            JOptionPane.showMessageDialog(null, "cannot divide by zero");
    
        }
    }
    else if(menu.equals("Pow"))
    {
        if(cb.isSelected())
        {
            float p=(float)Math.pow((double)x,(double)y);
            
            result.setText(Float.toString(p));
        }
        else
        {
            int z=(int)Math.pow((double)x,(double)y);
            result.setText(Integer.toString(z));
        }   
    }
    else if(menu.equals("Clear"))
    {
        result.setText("0");
        xfield.setText("0");
        yfield.setText("0");
            
    }
    
    else
    {
        result.setText("Error");
    }
  }
   else
   {
        Font f = new Font("Verdana",Font.BOLD,12);
        if(!isInteger(xText))
        {    
        xfield.setFont(f);
        xfield.setForeground(Color.red);
        }
        if(!isInteger(yText))
        {    
        yfield.setFont(f);
        yfield.setForeground(Color.red);
        }
        result.setFont(f);
        result.setForeground(Color.red);
        result.setText("Error");
    }

 }

    private boolean isInteger(String xText)
    {
        for(int i = 0; i < xText.length(); i++)
        {
            if(!Character.isDigit(xText.charAt(i)))
            {
                 return false;
            }
        }
        return true;
    }

    
    
}
   
    

