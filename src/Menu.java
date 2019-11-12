import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame implements WindowListener, ActionListener{
	private JButton simple = new JButton();
	private JButton star = new JButton();
	private JButton kitty = new JButton();
	private static JFrame obj = new JFrame();
	public Menu() {
	
	obj.setBounds(10, 10, 400, 300);
	obj.setBackground(Color.LIGHT_GRAY);
	obj.setResizable(false);
    simple.setVisible(true);
    simple.setText("Simple Snake");
    star.setVisible(true);
    star.setText("Star Snake");
    kitty.setVisible(true);
    kitty.setText("Kitty Snake");
    obj.setLayout(new FlowLayout());
    obj.add(simple);
    obj.add(star);
    obj.add(kitty);
    obj.setVisible(true);
    simple.addActionListener(this); 
    star.addActionListener(this);
    kitty.addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
       if(e.getSource() == simple)  {
    	   Gameplay.option = 1;
    	   Main start = new Main();
    	   start.start();
       }
       if(e.getSource() == star)  {
    	   Gameplay.option = 2;
    	   Main start = new Main();
    	   start.start();
       }
       if(e.getSource() == kitty)  {
    	   Gameplay.option = 3;
    	   Main start = new Main();
    	   start.start();
       }
	 }
	 
	 public static void setObj() {
		 obj.setVisible(false);
	 }

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
