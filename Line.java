import javax.swing.JOptionPane;

public class Line {
	// data members
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	
	// constructors
	public Line()  // no-argument constructor
	{
		xStart = 0;
		yStart = 0;
		xEnd = 100;
		yEnd = 100;
	}
	
	public Line(int x0, int y0, int x1, int y1)  // yes-argument constructor
	{
		xStart = x0;
		yStart = y0;
		xEnd = x1;
		yEnd = y1;
	}
	
	// accessors
	public int getxStart() {return xStart;}
	public int getyStart() {return yStart;}
	public int getxEnd() {return xEnd;}
	public int getyEnd() {return yEnd;}

	// other methods
	public double getLength()
	{
		return Math.sqrt(Math.pow((xEnd - xStart), 2)
			 + Math.pow(yEnd - yStart, 2));
	}
	
	public void getAttributes()
	{
		String input = JOptionPane.showInputDialog(null,
					    "Enter start x-coordinate:",
					    "x Start", JOptionPane.QUESTION_MESSAGE);
		xStart = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
						"Enter start y-coordinate:",
						"y Start", JOptionPane.QUESTION_MESSAGE);
		yStart = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
						"Enter end x-coordinate:",
						"x End", JOptionPane.QUESTION_MESSAGE);
		xEnd = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null,
						"Enter end y-coordinate:",
						"y End", JOptionPane.QUESTION_MESSAGE);
		yEnd = Integer.parseInt(input);
	}
}