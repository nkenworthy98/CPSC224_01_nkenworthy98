/**************
 * In Class Assignment #2
 * Due Date: 2/8/2019
 * Name: Nick Kenworthy
 * *********/

import java.util.Scanner;

public class PetDemo
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Pet thePet = new Pet();

		System.out.println("Enter in the name of your animal: ");
		thePet.setName(keyboard.nextLine());

		System.out.println("Enter in the type of animal that you have: ");
		thePet.setAnimal(keyboard.nextLine());

		System.out.println("Enter in the age of the animal: ");
		thePet.setAge(keyboard.nextInt());
		
		System.out.println("Here is the name of the pet: " + thePet.getName());
		System.out.println("Here is the type of animal: " + thePet.getAnimal());
		System.out.println("Here is the age of the pet: " + thePet.getAge());
	}
}
