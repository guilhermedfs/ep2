import java.util.Random;

import javax.swing.ImageIcon;

public class Apple {
	
	private Random random = new Random();
	
	private ImageIcon apple;

	public ImageIcon getApple() {
		return apple;
	}

	public void setApple(ImageIcon apple) {
		this.apple = apple;
	}
	
	public void chooseApple(int choice) {
		if(choice == 1) {
		apple = new ImageIcon("applerred.png");
		}
		if(choice == 2) {
			apple = new ImageIcon("applereset.png");
		}
		if(choice == 3) {
			apple = new ImageIcon("appleend.png");
		}
		if(choice == 4) {
			apple = new ImageIcon("appledouble.png");
		}
	}


}
