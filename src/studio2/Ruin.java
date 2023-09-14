package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		double startAmount, winChance, winLimit, totalSimulations, simulationDay = 1;
		int numPlays = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many days will you be playing?");
		totalSimulations = scan.nextDouble();
		
		System.out.println("Enter your starting amount:");
		startAmount = scan.nextDouble();

		System.out.println("Enter your win probability (in decimals):");
		winChance = scan.nextDouble();
		
		while(winChance >= 1)
		{
			System.out.println("ERROR. Try again. Win chance cannot be greater than or equal to 1. Try again:");
			winChance = scan.nextDouble();
		}
			
		
		System.out.println("Enter your win limit:");
		winLimit = scan.nextDouble();
		
		while(simulationDay <= totalSimulations)
		{
			
			double currentAmount = startAmount;
			
			while(currentAmount < winLimit && currentAmount > 0)
			{
				
				if(Math.random() <= winChance){
					currentAmount++;
					//System.out.println("Win, +1: the current amount is " + currentAmount);
				}
				else //if(Math.random() > winChance) 
				{
					currentAmount--;
					//System.out.println("Loss, -1: the current amount is " + currentAmount);
					
				}
				
				numPlays++;
			}
			
			System.out.print("Simulation " + simulationDay + ": Played " + numPlays + " times");
			
			if(currentAmount > 0) {
				System.out.println(" WIN");
			}
			else {
				System.out.println(" LOSE");
			}
			
			numPlays = 0;
			simulationDay++;
		}
	}

}
