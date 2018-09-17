package hw5;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public abstract class  Hw5 implements ActionListener
{
    private  static JMenuBar mBar;
    private  static JMenu menu;
    private  static JMenuItem mItem;
    private  static JMenuItem project;
    
	public static void main(String[] args)
        {
            mBar = new JMenuBar();
            menu = new JMenu("About");
            mBar.add(menu);
            mItem = new JMenuItem("People");
            menu.add(mItem);
            mItem.addActionListener(new MenuItemListener());
            mItem.setActionCommand("People");
            project = new JMenuItem("Project");
            menu.add(project);
            project.addActionListener(new MenuItemListener());
            project.setActionCommand("Project");
    		Calculator a = new Calculator();
		Calculatortwo b = new Calculatortwo();
		Calculatorthree c = new Calculatorthree();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(1,1));
		f.setJMenuBar(mBar);
		f.add(a);
		f.add(b);
		f.add(c);
		f.pack();
                f.setVisible(true);
	}

}
class MenuItemListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
      {
        String s = e.getActionCommand();
        if(s.equals("People"))
        {
            JOptionPane.showMessageDialog(null,"SRAVAN KUMAR REDDY.");
        }
        if(s.equals("Project"))
        {
            JOptionPane.showMessageDialog(null,"Three types of calculators on a single frame.");
        }
        
      }
}