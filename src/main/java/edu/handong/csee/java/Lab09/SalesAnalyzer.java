package edu.handong.csee.java.Lab09;
import java.util.Scanner;

/**
 * 
 * @author JHS
 */
public class SalesAnalyzer {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		SalesAnalyzer sAnalyze = new SalesAnalyzer();
		
		
		System.out.println("Enter number of sales associates : ");
		int times = keyboard.nextInt();
		
		for(int i=0; i < times; i++) {
			System.out.println("Enter data for associate number " + i+1);
			sAnalyze.getData(i);
			
		}

	}

	/**
	 * 
	 */
	public void getData(int i) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter name of sales associate : ");
		team[i].name = keyboard.nextLine();
		System.out.print("Enter associate's sales : $");
		team[i].sales = keyboard.nextDouble();
	}
		
		
	
	/**
	 * 
	 */
	public void computeAverage() {
	
	}
	
	/**
	 * 
	 */
	public void computeHighestSales() {
		
	}
	
	/**
	 * 
	 */
	public void displayResults() {
		Syste
	}
	
}
