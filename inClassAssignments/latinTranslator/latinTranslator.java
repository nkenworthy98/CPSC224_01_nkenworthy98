/*********************
 * In Class Assignment 3
 * Due Date: 2/15/2019
 * Name: Nick Kenworthy
 ********************/
import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for event listener interface

public class latinTranslator extends JFrame
{
   private JButton button1;    // SINISTER button
   private JButton button2;    // DEXTER button
   private JButton button3;    // MEDIUM button
   private JPanel panel;       // A panel to hold components
   private final int WINDOW_WIDTH = 300; // Window width
   private final int WINDOW_HEIGHT = 70; // Window height

   /**
      Constructor
   */

   public latinTranslator()
   {
      // Set the title bar text.
      setTitle("Latin Translator to English");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the three buttons.
      button1 = new JButton("SINISTER");
      button2 = new JButton("DEXTER");
      button3 = new JButton("MEDIUM");

      // Register an event listener with all 3 buttons.
      button1.addActionListener(new ButtonListener());
      button2.addActionListener(new ButtonListener());
      button3.addActionListener(new ButtonListener());

      // Create a panel and add the buttons to it.
      panel = new JPanel();
      panel.add(button1);
      panel.add(button2);
      panel.add(button3);

      // Add the panel to the content pane.
      add(panel);

      // Display the window.
      setVisible(true);
   }

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Get the action command.
         String actionCommand = e.getActionCommand();

         // Determine which button was clicked and display
         // a message.
         if (actionCommand.equals("SINISTER"))
         {
            JOptionPane.showMessageDialog(null, "Left"); 
         }
         else if (actionCommand.equals("DEXTER"))
         {
            JOptionPane.showMessageDialog(null, "Right"); 
         }
         else if (actionCommand.equals("MEDIUM"))
         {
            JOptionPane.showMessageDialog(null, "Center"); 
         }
      }
   }
   
   public static void main(String[] args)
   {
      new latinTranslator();
   }
}
