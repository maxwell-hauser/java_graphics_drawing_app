import javax.swing.JOptionPane;

public class Diamond {
	// data members
	private int xCenter;
	private int yCenter;
	private int width;
	private int height;
	
	// constructors
	public Diamond()  // no-argument constructor
	{
		xCenter = 0;
		yCenter = 0;
		width = 100;
		height = 100;
	}
	
	public Diamond(int x0, int y0, int w, int h)  // yes-argument constructor
	{
		xCenter = x0;
		yCenter = y0;
		width = w;
		height = h;
	}
	
	// accessors
	public int getxCenter() {return xCenter;}
	public int getyCenter() {return yCenter;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}

	// other methods
	public double getPerimeter()
	{
		return Math.sqrt(Math.pow(width/2.0, 2) + Math.pow(height/2.0, 2)) * 4;
	}
	
	public double getArea()
	{
		return (width * height) / 2.0;
	}
	
	public void getAttributes()
	{
		String input = JOptionPane.showInputDialog(null,
					    "Enter center x-coordinate:",
					    "x Center", JOptionPane.QUESTION_MESSAGE);
		xCenter = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
						"Enter center y-coordinate:",
						"y Center", JOptionPane.QUESTION_MESSAGE);
		yCenter = Integer.parseInt(input);		
	
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