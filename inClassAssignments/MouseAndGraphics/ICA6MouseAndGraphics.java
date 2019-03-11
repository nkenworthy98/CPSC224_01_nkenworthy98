/**************
 * In Class Assignment #6
 * Due Date: 3/10/2019
 * Name: Nick Kenworthy
 * Github URL: https://github.com/nkenworthy98/CPSC224_01_nkenworthy98
 * *********/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
   This applet demonstrates how mouse events and mouse
   motion events can be handled. It lets the user draw
   boxes by dragging the mouse.
*/

public class ICA6MouseAndGraphics extends JFrame
{
   private int currentX = 250; // Mouse cursor's X position
   private int currentY = 250; // Mouse cursor's Y position
   private int width = 100;    // The rectangle's width
   private int height = 50;   // The rectangle's height
               
   /**
      init method
   */

   public static void main(String[] args)
   {
       new ICA6MouseAndGraphics();
   }
   
   ICA6MouseAndGraphics()
   {
       setTitle("In Class Assignment 6: Mouse and Graphics");

      // Add a mouse listener and a mouse motion listener.
      addMouseListener(new MyMouseListener());
      addMouseMotionListener(new MyMouseMotionListener());

      setSize(500,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   /**
      paint method
      @param g The applet's Graphics object.
   */
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      
      // Draw a rectangle.
      g.drawRect(currentX, currentY, width, height);
   }
   
   /**
      Mouse listener class
   */

   private class MyMouseListener
                       implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         // Get the mouse cursor coordinates.
         currentX = e.getX();
         currentY = e.getY();
      }

      //
      // The following methods are unused, but still
      // required by the MouseListener interface.
      //

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
   
   /**
      Mouse Motion listener class
   */

   private class MyMouseMotionListener
                   implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
      }
      
      /**
         The mouseMoved method is unused, but still
         required by the MouseMotionListener interface.
      */
      
      public void mouseMoved(MouseEvent e)
      {
      }
   }
}
