import javax.swing.ImageIcon;

public class Snake {
	private static int length = 3;
	private int snaketype;
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;

	public static int getLength() {
		return length;
	}

	public static void setLength(int length) {
		Snake.length = length;
	}

	public int getSnaketype() {
		return snaketype;
	}

	public void setSnaketype(int snaketype) {
		this.snaketype = snaketype;
	}
	

}
