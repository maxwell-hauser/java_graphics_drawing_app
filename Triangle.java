import javax.swing.JOptionPane;

public class Triangle {
	// data members
	private int x1, y1, x2, y2, x3, y3;
	private double side1, side2, side3, S;
	// constructors
	public Triangle()  // no-argument constructor
	{
		x1 = 0;
		y1 = 0;
		x2 = 5;
		y2 = 0;
		x3 = 0;
		y3 = 5;
	}
	
	public Triangle(int x1s, int y1s, int x2s, int y2s, int x3s, int y3s)  // yes-argument constructor
	{
		x1 = x1s;
		y1 = y1s;
		x2 = x2s;
		y2 = y2s;
		x3 = x3s;
		y3 = y3s;
	}
	
	// accessors
	public int getx1() {return x1;}
	public int gety1() {return y1;}
	public int getx2() {return x2;}
	public int gety2() {return y2;}
	public int getx3() {return x3;}
	public int gety3() {return y3;}

	// other methods
	public double getSide1()
	{
		side1 = Math.sqrt(Math.pow(x2 - x1, 2)
			  + Math.pow(y2 - y1, 2));
		
		return side1;
	}

	public double getSide2()
	{
		side2 = Math.sqrt(Math.pow(x3 - x2, 2)
			  + Math.pow(y3 - y2, 2));
		
		return side2;
	}
	
	public double getSide3()
	{
		side3 = Math.sqrt(Math.pow(x1 - x3, 2)
			  + Math.pow(y1 - y3, 2));
		
		return side3;
	}
	
	public double getPerimeter()
	{
		double a = getSide1();
		double b = getSide2();
		double c = getSide3();
		return a + b + c;
	}
	
	public double getArea()
	{
		double a = getSide1();
		double b = getSide2();
		double c = getSide3();
		double s = (a + b + c)/2.0;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
	
	public void getAttributes()
	{
		String input = JOptionPane.showInputDialog(null,
			    "Enter first x-coordinate:",
			    "x1", JOptionPane.QUESTION_MESSAGE);
		x1 = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
				"Enter first y-coordinate:",
				"y1", JOptionPane.QUESTION_MESSAGE);
		y1 = Integer.parseInt(input);		
	
		input = JOptionPane.showInputDialog(null,
				"Enter second x-coordinate:",
				"x2", JOptionPane.QUESTION_MESSAGE);
		x2 = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null,
				"Enter second y-coordinate:",
				"y2", JOptionPane.QUESTION_MESSAGE);
		y2 = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null,
				"Enter third x-coordinate:",
				"x3", JOptionPane.QUESTION_MESSAGE);
		x3 = Integer.parseInt(input);

		input = JOptionPane.showInputDialog(null,
				"Enter third y-coordinate:",
				"y3", JOptionPane.QUESTION_MESSAGE);
		y3 = Integer.parseInt(input);
	}
}