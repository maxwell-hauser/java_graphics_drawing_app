import javax.swing.JOptionPane;

public class Rectangle {
	// data members
	private int xTopLeft;
	private int yTopLeft;
	private int width;
	private int height;
	
	// constructors
	public Rectangle()  // no-argument constructor
	{
		xTopLeft = 100;
		yTopLeft = 100;
		width = 100;
		height = 100;
	}
	
	public Rectangle(int x, int y, int w, int h)  // yes-argument constructor
	{
		xTopLeft = x;
		yTopLeft = y;
		width = w;
		height = h;
	}
	
	// accessors
	public int getxTopLeft() {return xTopLeft;}
	public int getyTopLeft() {return yTopLeft;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}

	// other methods
	public int getPerimeter()
	{
		return 2 * (width + height);
	}
	
	public int getArea()
	{
		return width*height;
	}
	
	public void getAttributes()
	{
		String input = JOptionPane.showInputDialog(null,
					    "Enter top left corner x-coordinate:",
					    "x Top Left", JOptionPane.QUESTION_MESSAGE);
		xTopLeft = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
						"Enter top left corner y-coordinate:",
						"y Top Left", JOptionPane.QUESTION_MESSAGE);
		yTopLeft = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
						"Enter width:",
						"Width", JOptionPane.QUESTION_MESSAGE);
		width = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null,
						"Enter height:",
						"Height", JOptionPane.QUESTION_MESSAGE);
		height = Integer.parseInt(input);
	}
}