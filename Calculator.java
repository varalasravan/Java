package hw5;
import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Calculator extends JPanel implements ActionListener
{
    private JTextField xfield, yfield;
    private JLabel result;
    private JButton computeButton;
    private JPanel xpanel,bpanel;
  
    public Calculator()
    {
     	 xpanel = new JPanel();
         bpanel = new JPanel();
       	 
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
         
         computeButton = new JButton("Multiply");
         JButton b =new JButton("Add");
         JButton b1 =new JButton("Subtract");
         JButton b2=new JButton("Divide");
         JButton b3=new JButton("Pow");
         JButton b4=new JButton("Clear");
         bpanel.add(computeButton);
         bpanel.add(b);
         bpanel.add(b1);
         bpanel.add(b2);
         bpanel.add(b3);
         bpanel.add(b4);
         
         computeButton.addActionListener(this);
         b.addActionListener(this);
         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         b4.addActionListener(this);
         setVisible(true);
    }

public void actionPerformed(ActionEvent event)      
{
   
	int x = 0;
        int y = 0;
        String xText = xfield.getText();
        String yText = yfield.getText();
        String bname=event.getActionCommand();
 if(isInteger(xText)&&isInteger(yText))
 {
    if(bname.equals("Multiply"))
    {
        x = Integer.parseInt(xText);
        y = Integer.parseInt(yText);
        Font f = new Font("Verdana",Font.BOLD,12);
        result.setFont(f);
        result.setForeground(Color.red);
        result.setText(Integer.toString(x*y));
    }
    else if(bname.equals("Add"))
    {
        x = Integer.parseInt(xText);
        y = Integer.parseInt(yText);
        Font f = new Font("Verdana",Font.BOLD,12);
        result.setFont(f);
        result.setForeground(Color.red);
        result.setText(Integer.toString(x+y));    
    }
        
    else if(bname.equals("Subtract"))
    {
        x = Integer.parseInt(xText);
        y = Integer.parseInt(yText);
        Font f = new Font("Verdana",Font.BOLD,12);
        result.setFont(f);
        result.setForeground(Color.red);
        result.setText(Integer.toString(x-y));
            
    }
    else if(bname.equals("Divide"))
    {
        x = Integer.parseInt(xText);
        y = Integer.parseInt(yText);
        if(y!=0)
        {
            Font f = new Font("Verdana",Font.BOLD,12);
            result.setFont(f);
            result.setForeground(Color.red);
            result.setText(Integer.toString(x/y));
        }
        else
        {
          result.setText("Error");
          JOptionPane.showMessageDialog(null,"cannot divide by zero");
    
        }
    }
    else if(bname.equals("Pow"))
    {
        x = Integer.parseInt(xText);
        y = Integer.parseInt(yText);
            
        int z=(int)Math.pow((double)x,(double)y);
        Font f = new Font("Verdana",Font.BOLD,12);
        result.setFont(f);
        result.setForeground(Color.red);
        result.setText(Integer.toString(z));
            
    }
    else if(bname.equals("Clear"))
    {
        result.setText("0");
        xfield.setText("0");
        yfield.setText("0");
            
    }
    
    else
    {
        Font f = new Font("Verdana",Font.BOLD,12);
        result.setFont(f);
        result.setForeground(Color.red);
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
   
    

