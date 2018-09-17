package hw5;
import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Calculatorthree extends JPanel implements ActionListener
{
    private JTextField xfield, yfield;
    private JLabel result;
    private JButton computeButton;
    private JPanel xpanel,bpanel;
    private JRadioButton rb1,rb2;
    public Calculatorthree()
    {
         rb1 = new JRadioButton("Integer result",true);
         rb2 = new JRadioButton("Floating result",false);
     	 xpanel = new JPanel();
         bpanel = new JPanel();
         ButtonGroup bg=new ButtonGroup();
         bg.add(rb1);
         bg.add(rb2);
         bpanel.add(rb1);
         bpanel.add(rb2);
         
         
         xpanel.setLayout(new GridLayout(3,2));
	 bpanel.setLayout(new GridLayout(6,2));
	 
         xpanel.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.yellow));
         JLabel x=new JLabel("x:");
         x.setHorizontalAlignment(JLabel.RIGHT);
         xpanel.add(x);
         
       	 xfield = new JTextField("0", 5);
         xpanel.add(xfield);
         JLabel y=new JLabel("y:");
         xpanel.add(y);
         y.setHorizontalAlignment(JLabel.RIGHT);
         
         
         yfield = new JTextField("0", 5);
         xpanel.add(yfield);
         yfield.setAlignmentX(JLabel.RIGHT);
         
         JLabel z=new JLabel("Total:");
         xpanel.add(z);
         z.setHorizontalAlignment(JLabel.RIGHT);
         
         result = new JLabel("0");
         result.setBackground(Color.yellow);
         xpanel.add(result);
         
         add(xpanel, BorderLayout.NORTH);
         add(bpanel, BorderLayout.SOUTH);
  
         String[] menus={"Multiply","Add","Subtract","Divide","Pow","Clear"};
         JComboBox menu=new JComboBox(menus);
         bpanel.add(menu);
         menu.addActionListener(this);
         //frame3.pack();
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
        if(rb2.isSelected())
        {   
            result.setText(Float.toString((float)x*y));
        }
        else
        {   
            result.setText(Integer.toString(x*y));
        }
    }
    else if(menu.equals("Add"))
    {
        if(rb2.isSelected())
        {
            result.setText(Float.toString((float)x+y));
        }
        else
        {   
            result.setText(Integer.toString(x+y));
        }
    }
        
    else if(menu.equals("Subtract"))
    {
        if(rb2.isSelected())
        {   
            result.setText(Float.toString((float)x-y));
        }
        else
        {   
            result.setText(Integer.toString(x-y));
        }
    }
    else if(menu.equals("Divide"))
    {
        if(y!=0)
        {
            if(rb2.isSelected())
            {   
                result.setText(Float.toString((float)x/y));
            }
            else
            {   
                result.setText(Integer.toString(x/y));
            }
        
        }        
        else
        {
            result.setText("Error");
            JOptionPane.showMessageDialog(null, "cannot divide by zero");
        }
    }
    else if(menu.equals("Pow"))
    {
        if(rb2.isSelected())
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
   
    

