
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class graphics_drawing_app extends Frame implements ActionListener
{
	String command = "About";
	
	//2D Objects
	Line l;
	Rectangle r;
	Triangle t;
	Diamond d;
	
	//3D Objects
	Cube cu;
	TriangularPrism tp;
	Sphere s;
	Cylinder cy;
	Cone co;
	
	//Colors
	JColorChooser colorChooser = new JColorChooser();
	Color backgroundColor = new Color(0,0,0);
	Color foregroundColor = new Color(255,255,255);
		
	public static void main(String[] args)
	{
		Frame frame = new graphics_drawing_app();
		frame.setResizable(true);
		frame.setSize(1000,840);
		frame.setVisible(true);	
	}
	
	public graphics_drawing_app()
	{
		setTitle("Graphics");
		
		//Create Menu
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miColor = new MenuItem("Color");
		miColor.addActionListener(this);
		fileMenu.add(miColor);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
		Menu twoDMenu = new Menu("2D Shapes");
		mb.add(twoDMenu);
		
		MenuItem miLine = new MenuItem("Line");
		miLine.addActionListener(this);
		twoDMenu.add(miLine);
		
		MenuItem miRectangle = new MenuItem("Rectangle");
		miRectangle.addActionListener(this);
		twoDMenu.add(miRectangle);

		MenuItem miTriangle = new MenuItem("Triangle");
		miTriangle.addActionListener(this);
		twoDMenu.add(miTriangle);
	
		MenuItem miDiamond = new MenuItem("Diamond");
		miDiamond.addActionListener(this);
		twoDMenu.add(miDiamond);
		
		//3D Shapes Menu
		Menu threeDMenu = new Menu("3D Shapes");
		mb.add(threeDMenu);
		
		MenuItem miCube = new MenuItem("Cube");
		miCube.addActionListener(this);
		threeDMenu.add(miCube);
		
		MenuItem miTriangularPrism = new MenuItem("Triangular Prism");
		miTriangularPrism.addActionListener(this);
		threeDMenu.add(miTriangularPrism);
		
		//End program when window is closed	
		WindowListener l = new WindowAdapter()
		{		
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		//Register listeners
		this.addWindowListener(l);
		this.addComponentListener(k);
	}
	
//******************************************************************************
//Called by windows manager whenever the application window performs an action
//(select a menu item, close, resize, etc.)
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
	{
	//Figure out which command was issued
	
		command = ev.getActionCommand();
	
		//Take action accordingly
		switch (command)
		{
			case "About":
			{
				repaint();
				break;
			}
	
			case "Exit":
			{
				System.exit(0);
			}
	
			case "Color":
			{
				backgroundColor = JColorChooser.showDialog(
									null, "Choose Background Color",
									colorChooser.getBackground());

				foregroundColor = JColorChooser.showDialog(
									null, "Choose Drawing Color",
									colorChooser.getBackground());
				repaint();
				command = "About";
				repaint();
				break;
			}
		
			case "Line":
			{
				l = new Line();
				l.getAttributes();
				repaint();
				break;
			}	
	
			case "Rectangle":
			{
				r = new Rectangle();
				r.getAttributes();
				repaint();
				break;
			}
			
			case "Triangle":
			{
				t = new Triangle();
				t.getAttributes();
				repaint();
				break;
			}
			
			case "Diamond":
			{
				d = new Diamond();
				d.getAttributes();
				repaint();
				break;
			}
			
			//3D Shapes
			case "Cube":
			{
				cu = new Cube();
				cu.getAttributes();
				repaint();
				break;
			}
			
			case "Triangular Prism":
			{
				tp = new TriangularPrism();
				tp.getAttributes();
				repaint();
				break;	
			}
		}
	}
	
//********************************************************
//Called by repaint() to redraw the screen
//********************************************************
		
	public void paint(Graphics g)
	{
	//Check command issued, take action accordingly
		
		int ww = this.getWidth();;
		switch(command)
		{
			case "About":
			{
				g.drawString("Geometric Shapes",(int)(ww/5), 100);
				g.drawLine(0, 120, (int)(ww), 120);
				g.drawLine(0, 130, (int)(ww), 130);
				g.drawString("This program calculates and displays various values of the following geometric shapes." , (int)(ww/5), 150);
		
				g.drawString(" 1.      Line", (int)(ww/5), 200);
				g.drawString(" 2.      Triangle", (int)(ww/5), 220);
				g.drawString(" 3.      Rectangle", (int)(ww/5), 240);
				g.drawString(" 4.      Diamond", (int)(ww/5), 260);
				g.drawString(" 5.      Cube", (int)(ww/5), 280);
				g.drawString(" 6.      Triangular Prism", (int)(ww/5), 300);
				g.drawString(" 7.      Sphere", (int)(ww/5), 320);
				g.drawString(" 8.      Cylinder", (int)(ww/5), 340);
				g.drawString(" 9.      Cone", (int)(ww/5), 360);
				break;
			}

			case "Color":
			{
				this.setBackground(backgroundColor);
				this.setForeground(foregroundColor);
				break;	
			}
	
			//2D Shapes
			case "Line":
			{
				g.drawRect(30,50,200,150);
				g.drawLine(30,100,230,100);
				g.drawString("Line Properties", 80, 80);
				g.drawString("Start Point    :    (" + l.getxStart() + ", " + l.getyStart() + ")", 50, 130);
				g.drawString("End Point     :    (" + l.getxEnd() + ", " + l.getyEnd() + ")", 50, 150);
				g.drawString("Length         :     " + roundDigits(l.getLength(), 3), 50, 170);
				g.drawLine(l.getxStart(), l.getyStart(), l.getxEnd(), l.getyEnd());
				g.drawString("(" + l.getxStart() + ", " + l.getyStart() + ")", l.getxStart() - 20, l.getyStart() - 20);
				g.drawString("(" + l.getxEnd() + ", " + l.getyEnd() + ")", l.getxEnd() + 20, l.getyEnd() + 20);
				g.drawString(Double.toString(roundDigits(l.getLength(), 3)), l.getxStart() + (l.getxEnd()-l.getxStart())/2, l.getyStart() + (l.getyEnd()-l.getyStart())/2);
				break;	
			}
			
			case "Rectangle":
			{	
				g.drawRect(30,50,200,200);
				g.drawLine(30,100,230,100);
				g.drawString("Rectangle Properties", 70, 80);
				g.drawString("Top Left Corner:   (" + r.getxTopLeft() + ", " + r.getyTopLeft() + ")", 45, 130);
				g.drawString("Width:                   " + r.getWidth(), 45, 150);
				g.drawString("Height:                  " + r.getHeight(), 45, 170);
				g.drawString("Area:                     " + r.getArea(), 45, 190);
				g.drawString("Perimeter:             " + r.getPerimeter(), 45, 210);
				g.drawRect(r.getxTopLeft(), r.getyTopLeft(), r.getWidth(), r.getHeight());
				g.drawString("(" + r.getxTopLeft() + ", " + r.getyTopLeft() + ")", r.getxTopLeft() - 50 , r.getyTopLeft() - 5);
				g.drawString(Integer.toString(r.getHeight()), r.getxTopLeft() - 25, r.getyTopLeft() + r.getHeight()/2);
				g.drawString(Integer.toString(r.getWidth()), r.getxTopLeft() + r.getWidth()/2, r.getyTopLeft() - 10);
				break;
			}
			
			case "Triangle":
			{
				g.drawRect(30,50,200,320);
				g.drawLine(30,100,230,100);
				g.drawString("Triangle Properties", 70, 80);
				g.drawString("Corners", 105, 120);
				g.drawLine(30,130,230,130);				
				g.drawString("(" + t.getx1() + ", " + t.gety1() + ")", 100, 150);
				g.drawString("(" + t.getx2() + ", " + t.gety2() + ")", 100, 170);
				g.drawString("(" + t.getx3() + ", " + t.gety3() + ")", 100, 190);
				g.drawLine(30,210,230,210);
				g.drawString("Sides", 110, 230);
				g.drawLine(30,240,230,240);
				g.drawString(Double.toString(roundDigits(t.getSide1(), 3)), 100, 260);
				g.drawString(Double.toString(roundDigits(t.getSide2(), 3)), 100, 280);
				g.drawString(Double.toString(roundDigits(t.getSide3(), 3)), 100, 300);
				g.drawLine(30, 310, 230, 310);
				g.drawString("Perimeter:     " + Double.toString(roundDigits(t.getPerimeter(), 3)), 60, 330);
				g.drawString("Area:             " + Double.toString(roundDigits(t.getArea(), 3)), 60, 350);
				
				g.drawLine(t.getx1(),t.gety1(),t.getx2(),t.gety2());
				g.drawLine(t.getx2(),t.gety2(),t.getx3(),t.gety3());
				g.drawLine(t.getx3(),t.gety3(),t.getx1(),t.gety1());
				g.drawString("(" + t.getx1() + ", " + t.gety1() + ")", t.getx1() - 50 , t.gety1() - 10);
				g.drawString("(" + t.getx2() + ", " + t.gety2() + ")", t.getx2() + 10 , t.gety2() + 10);
				g.drawString("(" + t.getx3() + ", " + t.gety3() + ")", t.getx3() - 70 , t.gety3() + 10);
				g.drawString(Double.toString(roundDigits(t.getSide1(), 3)), t.getx1() + (t.getx2() - t.getx1())/2, t.gety1() + (t.gety2() - t.gety1())/2);
				g.drawString(Double.toString(roundDigits(t.getSide2(), 3)), t.getx2() + (t.getx3() - t.getx2())/2, t.gety2() + (t.gety3() - t.gety2())/2);
				g.drawString(Double.toString(roundDigits(t.getSide3(), 3)), t.getx3() + (t.getx1() - t.getx3())/2, t.gety3() + (t.gety1() - t.gety3())/2);
				break;
			}
		
			case "Diamond":
			{	
				g.drawRect(30,50,200,185);
				g.drawLine(30,100,230,100);
				g.drawString("Diamond Properties", 70, 80);
				g.drawString("Center:              (" + d.getxCenter() + ", " + d.getyCenter() + ")", 45, 130);
				g.drawString("Width:                " + d.getWidth(), 45, 150);
				g.drawString("Height:              " + d.getHeight(), 45, 170);
				g.drawString("Perimeter:          " + roundDigits(d.getPerimeter(), 3), 45, 190);
				g.drawString("Area:                  " + roundDigits(d.getArea(), 3), 45, 210);
				
				g.drawLine(d.getxCenter() - d.getWidth()/2, d.getyCenter(), d.getxCenter() + d.getWidth()/2, d.getyCenter());
				g.drawLine(d.getxCenter(), d.getyCenter() - d.getHeight()/2, d.getxCenter(), d.getyCenter() + d.getHeight()/2);
				g.drawLine(d.getxCenter(), d.getyCenter() - d.getHeight()/2, d.getxCenter() + d.getWidth()/2, d.getyCenter());
				g.drawLine(d.getxCenter(), d.getyCenter() - d.getHeight()/2, d.getxCenter() - d.getWidth()/2, d.getyCenter());
				g.drawLine(d.getxCenter(), d.getyCenter() + d.getHeight()/2, d.getxCenter() + d.getWidth()/2, d.getyCenter());
				g.drawLine(d.getxCenter(), d.getyCenter() + d.getHeight()/2, d.getxCenter() - d.getWidth()/2, d.getyCenter());
				g.drawString(Integer.toString(d.getWidth()), d.getxCenter() + d.getWidth()/6, d.getyCenter() - 10);
				g.drawString(Integer.toString(d.getHeight()), d.getxCenter() + 10, d.getyCenter() - d.getHeight()/6);
				g.drawString("(" + d.getxCenter() + ", " + d.getyCenter() + ")", d.getxCenter() - 70, d.getyCenter() + 15);
				break;
			}
			
			//3D Shapes
			case "Cube":
			{
				g.drawRect(30,50,200,150);
				g.drawLine(30,100,230,100);
				g.drawString("Cube Properties", 80, 80);
				g.drawString("Top Left Corner:  (" + cu.getxTopLeft() + ", " + cu.getyTopLeft() + ")", 45, 130);
				g.drawString("Side:                     " + cu.getSide(), 45, 150);
				g.drawString("Surface:                " + cu.getSurface(), 45, 170);
				g.drawString("Volume:                " + cu.getVolume(), 45, 190);
				g.drawRect(cu.getxTopLeft(), cu.getyTopLeft(), cu.getSide(), cu.getSide());
				g.drawLine(cu.getxTopLeft(), cu.getyTopLeft(), cu.getxTopLeft() + cu.getSide()/3, cu.getyTopLeft() - cu.getSide()/3);
				g.drawLine(cu.getxTopLeft() + cu.getSide(), cu.getyTopLeft(), cu.getxTopLeft() + cu.getSide() + cu.getSide()/3, cu.getyTopLeft() - cu.getSide()/3);
				g.drawLine(cu.getxTopLeft() + cu.getSide(), cu.getyTopLeft() + cu.getSide(), cu.getxTopLeft() + cu.getSide() + cu.getSide()/3, cu.getyTopLeft() + cu.getSide() - cu.getSide()/3);
				g.drawLine(cu.getxTopLeft() + cu.getSide()/3, cu.getyTopLeft() - cu.getSide()/3, cu.getxTopLeft() + cu.getSide() + cu.getSide()/3, cu.getyTopLeft() - cu.getSide()/3);
				g.drawLine(cu.getxTopLeft() + cu.getSide() + cu.getSide()/3, cu.getyTopLeft() - cu.getSide()/3, cu.getxTopLeft() + cu.getSide() + cu.getSide()/3, cu.getyTopLeft() + cu.getSide() - cu.getSide()/3);
				g.drawString("(" + cu.getxTopLeft() + ", " + cu.getyTopLeft() + ")", cu.getxTopLeft() - 60, cu.getyTopLeft() - 10);
				g.drawString(Integer.toString(cu.getSide()), cu.getxTopLeft() - 25, cu.getyTopLeft() + cu.getSide()/2);
				break;
			}

			case "Triangular Prism":
			{				
				g.drawRect(30,50,200,330);
				g.drawLine(30,100,230,100);
				g.drawString("Triangular Prism Properties", 50, 80);
				g.drawString("Corners", 105, 120);
				g.drawLine(30,130,230,130);				
				g.drawString("(" + tp.getx1() + ", " + tp.gety1() + ")", 100, 150);
				g.drawString("(" + tp.getx2() + ", " + tp.gety2() + ")", 100, 170);
				g.drawString("(" + tp.getx3() + ", " + tp.gety3() + ")", 100, 190);
				g.drawLine(30,210,230,210);
				g.drawString("Sides", 110, 230);
				g.drawLine(30,240,230,240);
				g.drawString(Double.toString(roundDigits(tp.getSide1(), 3)), 100, 260);
				g.drawString(Double.toString(roundDigits(tp.getSide2(), 3)), 100, 280);
				g.drawString(Double.toString(roundDigits(tp.getSide3(), 3)), 100, 300);
				g.drawLine(30, 310, 230, 310);
				g.drawString("Height:         " + Integer.toString(tp.getHeight()), 50, 330);
				g.drawString("Surface:        " + Double.toString(roundDigits(tp.getSurface(), 3)), 50, 350);
				g.drawString("Volume:        " + Double.toString(roundDigits(tp.getVolume(), 3)), 50, 370);
				
				g.drawLine(tp.getx1(),tp.gety1(),tp.getx2(),tp.gety2());
				g.drawLine(tp.getx2(),tp.gety2(),tp.getx3(),tp.gety3());
				g.drawLine(tp.getx3(),tp.gety3(),tp.getx1(),tp.gety1());
				g.drawString("(" + tp.getx1() + ", " + tp.gety1() + ")", tp.getx1() - 50 , tp.gety1() - 10);
				g.drawString("(" + tp.getx2() + ", " + tp.gety2() + ")", tp.getx2() + 10 , tp.gety2() + 10);
				g.drawString("(" + tp.getx3() + ", " + tp.gety3() + ")", tp.getx3() - 70 , tp.gety3() - 10);
				
				g.drawLine(tp.getx1(),tp.gety1(), tp.getx1(), tp.gety1() - tp.getHeight());
				g.drawLine(tp.getx2(),tp.gety2(),tp.getx2(),tp.gety2() - tp.getHeight());
				g.drawLine(tp.getx3(),tp.gety3(),tp.getx3(),tp.gety3() - tp.getHeight());
				g.drawLine(tp.getx1(),tp.gety1() - tp.getHeight(),tp.getx2(), tp.gety2() - tp.getHeight());
				g.drawLine(tp.getx2(),tp.gety2() - tp.getHeight(),tp.getx3(), tp.gety3() - tp.getHeight());
				g.drawLine(tp.getx3(),tp.gety3() - tp.getHeight(),tp.getx1(), tp.gety1() - tp.getHeight());
				g.drawString(Integer.toString(tp.getHeight()), tp.getx1() - 25, tp.gety1() - tp.getHeight()/2);
				break;
			}
		}		
	}
	
	public static double roundDigits(double x, int d)
	{
		return (Math.round(x*Math.pow(10, d))/Math.pow(10,d));
	}		
}