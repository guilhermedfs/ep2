import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	private int choice;

	public static void main(String[] args) {
		new Menu();
	}
	
	public void start () {
		JFrame obj = new JFrame();
		Menu.setObj();
		Gameplay gameplay = new Gameplay ();
		obj.setBounds(10, 10, 905, 700);
		obj.setBackground(Color.LIGHT_GRAY);
		obj.setResizable(true);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
