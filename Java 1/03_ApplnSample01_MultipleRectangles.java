//Sample Java application illustrating a MULTIPLE RECTANGLES

package sample;

import java.awt.*;
import java.awt.event.*;

public class Sample extends Frame
{	
    public static void main(String[] args)
    {
        DrawingPanel myPanel = new DrawingPanel();
        Sample sampleAppln = new Sample();
        sampleAppln.setSize(400,250);
        sampleAppln.addWindowListener(new WindowEventHandler());
        sampleAppln.add(myPanel);
        sampleAppln.show();
    }
}

class WindowEventHandler extends WindowAdapter
{
    public void windowClosing(WindowEvent evt)
    {
        System.exit(0);
    }		
}

class DrawingPanel extends Panel
{
	public void paint(Graphics g) 
	{
		for (int count =1; count<=10; count ++)
		{
			g.drawRect(50 + 15*count, 50 + 10*count, 40, 20);
		}
	}
}


//  Update the program to place the rectangles further apart

//  Update the program to draw circles as well as rectangles
//  (Hint: drawOval)

//  Update the program to draw lines, circles and rectangles
//  (Hint: drawLine)
