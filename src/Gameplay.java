import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener, Runnable{
	private int [] snakexlength = new int[750];
	private int [] snakeylength = new int[750];
	public static int option;
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	private boolean gameover = false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	
	private Timer timer;
	private int delay = 100;
	private int moves = 0;
	
	private int score = 0;
	
	private ImageIcon snakeimage;
	
	private int[] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	private int[] appletype= {1,2,4,1,1,1,1,1,1,1,1,1,1,1,1,4,2};

	
	private Random random = new Random();
	
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	private int apple = random.nextInt(12);
	private ImageIcon titleImage;

	public Gameplay () {
		 addKeyListener(this);
		 setFocusable(true);
		 setFocusTraversalKeysEnabled(false);
		 timer = new Timer (delay, this);
		 timer.start();
	}
	
	public void paint (Graphics g) {
		if (moves == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;
			
			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;
			
		}
		//draw title image border
		g.setColor(Color.GREEN);
		g.drawRect(24, 10, 851, 55);
		
		//draw title image
		titleImage = new ImageIcon ("snaketitle.png");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw border to gameplay
		g.setColor(Color.YELLOW);
		g.drawRect(24, 74, 851, 625);
		
		//draw background for the gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 700);
		
		//draw scores
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores: " + score, 780, 30);
		//draw length
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: " + Snake.getLength(), 780, 50);
		
		//draw snake
		
		rightmouth = new ImageIcon ("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		
		
		for (int a = 0; a < Snake.getLength(); a++) {
			if(a == 0 && right) {
				rightmouth = new ImageIcon ("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a == 0 && left) {
				leftmouth = new ImageIcon ("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a == 0 && down) {
				downmouth = new ImageIcon ("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if(a == 0 && up) {
				upmouth = new ImageIcon ("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			
			if(a != 0) {
				snakeimage = new ImageIcon ("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
		
		}
		Apple set = new Apple();
		Apple set2 = new Apple();

		SimpleSnake scor = new SimpleSnake();
		

		set.chooseApple(appletype[apple]);
		set.getApple().paintIcon(this, g, enemyxpos[xpos],enemyypos[ypos]);
		
		
		if ((enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0] && appletype[apple] == 1)) {
			increase();
			Snake.setLength(Snake.getLength() + 1); 
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
			apple = random.nextInt(4);
		}
		
		if ((enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0] && appletype[apple] == 2)) {
			Snake.setLength(3);
			increase();
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
			apple = random.nextInt(4);
		}
		
		if ((enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0] && appletype[apple] == 4)) {
			if(option == 2) {
			score += 2*option;
			} else {
				score += 2;
			}
			
			Snake.setLength(Snake.getLength() + 1); 
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
			apple = random.nextInt(4);
		}
		
		
		
		for(int b = 1; b < Snake.getLength(); b++) {
			if((snakexlength[b] == snakexlength [0] && snakeylength[b] == snakeylength[0])||gameover == true) {
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.white);
				g.setFont(new Font ("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 350, 340);
				
			}
		}
		
		
		g.dispose();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(right) {
			for(int r = Snake.getLength()-1; r>=0; r--) {
				snakeylength[r+1] = snakeylength[r];
			}
			for(int r = Snake.getLength(); r>=0; r--) {
				if (r == 0) {
					snakexlength[r] = snakexlength[r] + 25;
				}
				else {
					snakexlength[r] = snakexlength[r-1];
				}
				if (snakexlength[r] > 850) {
					if(option == 3) {
						gameover = true;
					}else {
						snakexlength[r] = 25;
					}
				}
			}
			repaint();
		}
		
		if(left) {
			for(int r = Snake.getLength()-1; r>=0; r--) {
				snakeylength[r+1] = snakeylength[r];
			}
			for(int r = Snake.getLength(); r>=0; r--) {
				if (r == 0) {
					snakexlength[r] = snakexlength[r] - 25;
				}
				else {
					snakexlength[r] = snakexlength[r-1];
				}
				if (snakexlength[r] < 25) {
					if(option == 3) {
						gameover = true;
					}else {
					snakexlength[r] = 850;	
					}
				}
			}
			repaint();
			
		}
		
		if(up) {
			for(int r = Snake.getLength()-1; r>=0; r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for(int r = Snake.getLength(); r>=0; r--) {
				if (r == 0) {
					snakeylength[r] = snakeylength[r] - 25;
				}
				else {
					snakeylength[r] = snakeylength[r-1];
				}
				if (snakeylength[r] < 75) {
					if(option == 3) {
						gameover = true;
					}else {
						snakeylength[r] = 625;	
					}
				}
			}
			repaint();
			
		}
		
		if(down) {
			for(int r = Snake.getLength()-1; r>=0; r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for(int r = Snake.getLength(); r>=0; r--) {
				if (r == 0) {
					snakeylength[r] = snakeylength[r] + 25;
				}
				else {
					snakeylength[r] = snakeylength[r-1];
				}
				if (snakeylength[r] > 625) {
					if(option == 3) {
						gameover = true;
					}else {
						snakeylength[r] = 75;
					}
						
				}
			}
			repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			gameover = false;
			Snake.setLength(3);
			repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if(!left) {
				right = true;
			}
			else {
				right = false;
				left = true;
			}

			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if(!right) {
				left = true;
			}
			else {
				left = false;
				right = true;
			} 
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;
			if(!down) {
				up = true;
			}
			else {
				up = false;
				down = true;
			} 
			left = false;
			right = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if(!up) {
				down = true;
			}
			else {
				up = true;
				down = false;
			} 
			left = false;
			right = false;
		}
		
	}
	
	
	public int increase() {
		if(option == 1 || option == 3) {
			return score++;
		}
		if(option == 2) {
			return score+=2;
		}
		
		return score;
	}
	
	
	//@Override
	//public void run () {
		/*try {
			new Thread.start(delay);
		}catch() {
			
		}
		
	}*/
	
	public void paint3 (Graphics gameplay) {
		Apple set = new Apple();
		set.chooseApple(appletype[0]);
		set.getApple().paintIcon(this, gameplay, enemyxpos[xpos],enemyypos[ypos]);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
	
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

}
	

