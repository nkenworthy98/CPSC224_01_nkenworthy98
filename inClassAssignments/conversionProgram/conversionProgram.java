/*********************
 * In Class Assignment 1
 * Due Date: 1/25/2019
 * Name: Nick Kenworthy
 ********************/
import javax.swing.JOptionPane;

public class conversionProgram
{
	public static void main (String[] args)
	{
		String input;
		Integer distanceInMeters;
		Integer userChoice = 0;
		double convertedValue = 0;

		input = JOptionPane.showInputDialog("Enter a distance in meters: ");
		
		distanceInMeters = Integer.parseInt(input);

		while (userChoice != 4)
		{
			userChoice = Integer.parseInt(JOptionPane.showInputDialog("1. Convert to kilometers \n" +
				            	"2. Convert to inches \n" +
					    	"3. Convert to feet \n" +
					    	"4. Quit the program \n"));

			if (userChoice.equals(1))
			{
				convertedValue = showKilometers (distanceInMeters);
				JOptionPane.showMessageDialog(null, distanceInMeters + " meters is " + convertedValue + " kilometers.");
			}

			if (userChoice.equals(2))
			{
				convertedValue = showInches (distanceInMeters);
				JOptionPane.showMessageDialog(null, distanceInMeters + " meters is " + convertedValue + " inches.");
			}

			if (userChoice.equals(3))
			{
				convertedValue = showFeet (distanceInMeters);
				JOptionPane.showMessageDialog(null, distanceInMeters + " meters is " + convertedValue + " feet.");
			}

			if (userChoice.equals(4))
				JOptionPane.showMessageDialog(null, "Bye!");
		}
	}

	public static double  showKilometers (double distance)
	{
		double kilometers;

		kilometers = distance * 0.001;
		return kilometers;
	}

	public static double  showInches (double distance)
	{
		double inches;

		inches = distance * 39.37;
		return inches;
	}

	public static double  showFeet (double distance)
	{
		double feet;

		feet = distance * 3.281;
		return feet;
	}
}
