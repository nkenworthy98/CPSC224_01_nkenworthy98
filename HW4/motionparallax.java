/*********************
 * Homework #4 
 * Due Date: 3/25/2019
 * Name: Nick Kenworthy (Worked by myself)
 * Github URL: https://github.com/nkenworthy98/CPSC224_01_nkenworthy98
 ********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class motionparallax extends JFrame
{
    private int rectCurrentX = -50; 
    private int rectCurrentY = -100; 
    private int width = 2000;
    private int height = 1000;

    private int tri1CurrentX1 = 0;
    private int tri1CurrentX2 = 150;
    private int tri1CurrentX3 = 300;
    private int tri1CurrentY1 = 200;
    private int tri1CurrentY2 = 0;
    private int tri1CurrentY3 = 200;
    private int triangle1XValues[] = { tri1CurrentX1, tri1CurrentX2, tri1CurrentX3 };
    private int triangle1YValues[] = { tri1CurrentY1, tri1CurrentY2, tri1CurrentY3 };

    private int tri2CurrentX1 = 200;
    private int tri2CurrentX2 = 350;
    private int tri2CurrentX3 = 500;
    private int tri2CurrentY1 = 200;
    private int tri2CurrentY2 = 0;
    private int tri2CurrentY3 = 200;
    private int triangle2XValues[] = { tri2CurrentX1, tri2CurrentX2, tri2CurrentX3 };
    private int triangle2YValues[] = { tri2CurrentY1, tri2CurrentY2, tri2CurrentY3 };
               
    private int tri3CurrentX1 = 200;
    private int tri3CurrentX2 = 350;
    private int tri3CurrentX3 = 500;
    private int tri3CurrentY1 = 200;
    private int tri3CurrentY2 = 0;
    private int tri3CurrentY3 = 200;
    private int triangle3XValues[] = { tri3CurrentX1, tri3CurrentX2, tri3CurrentX3 };
    private int triangle3YValues[] = { tri3CurrentY1, tri3CurrentY2, tri3CurrentY3 };

    private int circleXValue = 30;
    private int circleYValue = 50;
    private int circleRadius = 100;

   public static void main(String[] args)
   {
       new motionparallax();
   }
   
   motionparallax()
   {
       setTitle("HW4: Motion Parallax");

      // Add a mouse listener and a mouse motion listener.
      addMouseListener(new MyMouseListener());
      addMouseMotionListener(new MyMouseMotionListener());

      setSize(500,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      

      // Draws the blue sky
      g.setColor(Color.blue);
      g.fillRect(0, 0, 3000, 3000);

      // Draws the sun
      g.setColor(Color.yellow);
      g.fillOval(circleXValue, circleYValue, circleRadius, circleRadius);

      // Draws the black mountain
      g.setColor(Color.black);
      g.fillPolygon(triangle3XValues, triangle3YValues, 3);

      // Draws the orange mountain
      g.setColor(Color.orange);
      g.fillPolygon(triangle2XValues, triangle2YValues, 3);

      // Draws the red mountain
      g.setColor(Color.red);
      g.fillPolygon(triangle1XValues, triangle1YValues, 3);

      // Draw the grass
      g.setColor(Color.green);
      g.fillRect(rectCurrentX - 800, rectCurrentY - 100, width, height);

   }

   private class MyMouseListener
                       implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
      }

      public void mouseClicked(MouseEvent e)
      {
	  repaint();
      }

      public void mouseReleased(MouseEvent e)
      {
      }

      public void mouseEntered(MouseEvent e)
      {
      }

      public void mouseExited(MouseEvent e)
      {
      }
   }

   private class MyMouseMotionListener
                   implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
      }
      
      public void mouseMoved(MouseEvent e)
      {
	  // Moves grass as mouse moves.
	  rectCurrentX = e.getX() - 5;
	  rectCurrentY = e.getY() - 5;

	  // Moves red mountain as mouse moves.
	  triangle1XValues[0] = (e.getX() - 5) + e.getX()/4;
	  triangle1XValues[1] = (e.getX() - 155) + e.getX()/4;
	  triangle1XValues[2] = (e.getX() - 305) + e.getX()/4;
	  triangle1YValues[0] = (e.getY() - 105) + e.getY()/4;
	  triangle1YValues[1] = (e.getY() - 305) + e.getY()/4;
	  triangle1YValues[2] = (e.getY() - 105) + e.getY()/4;

	  // Moves orange mountain as mouse moves
	  triangle2XValues[0] = (e.getX() + 45) + e.getX()/4;
	  triangle2XValues[1] = (e.getX() + 205) + e.getX()/4;
	  triangle2XValues[2] = (e.getX() + 355) + e.getX()/4;
	  triangle2YValues[0] = (e.getY() - 125) + e.getY()/4;
	  triangle2YValues[1] = (e.getY() - 455) + e.getY()/4;
	  triangle2YValues[2] = (e.getY() - 125) + e.getY()/4;

	  // Moves black mountain as mouse moves
	  triangle3XValues[0] = (e.getX() - 165) + e.getX()/10;
	  triangle3XValues[1] = (e.getX() + 45) + e.getX()/10;
	  triangle3XValues[2] = (e.getX() + 245) + e.getX()/10;
	  triangle3YValues[0] = (e.getY() - 125) + e.getY()/10;
	  triangle3YValues[1] = (e.getY() - 455) + e.getY()/10;
	  triangle3YValues[2] = (e.getY() - 125) + e.getY()/10;

	  // Moves sun as mouse moves
	  circleXValue = (e.getX() - 150) + e.getX()/100;
	  circleYValue = (e.getY() - 400) + e.getY()/100;
	  repaint();
      }
   }
}
