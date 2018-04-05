package edu.handong.csee.java.Lab09;
import java.util.Scanner;

/**
 * 
 * @author JHS
 */
public class SalesAnalyzer {
	private double highestSales;
	private double averageSales;
	private String highestName;
	private SalesAssociate[] team;
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		SalesAnalyzer sAnalyze = new SalesAnalyzer();
		
		
		System.out.println("Enter number of sales associates : ");
		int times = keyboard.nextInt();
		//SalesAssociate[] team = new SalesAssociate[times];
		
		for(int i=0; i < times; i++) {
			System.out.println("Enter data for associate number " + i+1);
			sAnalyze.getData(i);
			System.out.println("");
		}
		
		sAnalyze.computeAverage(times);
		sAnalyze.computeHighestSales(times);
		
		System.out.println("Average sales per associate is $" + sAnalyze.averageSales);
		System.out.println("The highest sales figure is $" + sAnalyze.highestSales);
		System.out.println("");
		
		System.out.println("The following had the highest sales : ");
		System.out.println("Name : " + sAnalyze.highestName);
		System.out.println("Sales : " + sAnalyze.highestSales);
		System.out.println("$" + (sAnalyze.highestSales-sAnalyze.averageSales) + "above the average.");
		
		
		
			

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
	public void computeAverage(int times) {
		double sum = 0;
		for(int i=0; i < times; i++) {
			sum += team[i].sales;
		}
		this.averageSales = sum / times;
	}
	
	/**
	 * 
	 */
	public void computeHighestSales(int times) {
		for(int i=0; i < times; i++) 
			if(this.highestSales <= team[i].sales) {
				highestSales = team[i].sales;
				this.highestName = team[i].name;
			}
	}
	
	/**
	 * 
	 */
	public void displayResults() {
		//Syste
	}
	
}
