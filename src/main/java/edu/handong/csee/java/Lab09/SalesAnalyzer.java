package edu.handong.csee.java.Lab09;
import java.util.Scanner; //call a package to use scanner

/**
 * This program gets number of salesmen, their names, sales and computes average of sales. 
 * Also, shows who sells the highest profit comparing with sales average and shows other members. 
 * @author JHS
 */
public class SalesAnalyzer { //the class name is SalesAnalyzer
	private double averageSales; //declare a instance variable
	private double highestSales; //declare a instance variable
	private String highestName; //declare a instance variable
	private int highestNum; 
	private SalesAssociate[] team; //declare an array which type is SalesAssociate
	
	/**
	 * 
	 */
	public static void main(String[] args) { //main method
		int i; //declare a variable i
		Scanner keyboard = new Scanner(System.in); //instantiate a keyboard
		SalesAnalyzer sAnalyze = new SalesAnalyzer(); //instantiate sAnalyze
		
		
		System.out.println("Enter number of sales associates : "); //print some message
		int times = keyboard.nextInt(); //times gets value from user
		SalesAssociate[] team = new SalesAssociate[times]; //instantiate(?) SaluesAssociate type array team 
		
		for(i=0; i < times; i++) { //repeat as times
			System.out.println("Enter data for associate number " + i+1); //print some message
			sAnalyze.getData(i); //gets person(i)'s value
			System.out.println(""); //make a one line
		}
		
		sAnalyze.computeAverage(); //computes sales average
		sAnalyze.computeHighestSales();
		
		sAnalyze.displayResults();
	}

	/**
	 * gets a data of name and sales of person
	 */
	public void getData(int i) { //method name is getData
		Scanner keyboard = new Scanner(System.in); //instantiate keyboard to use scanner
		System.out.print("Enter name of sales associate : "); //print some message
		team[i].name = keyboard.nextLine();  //name gets string type value from user 
		System.out.print("Enter associate's sales : $"); //print some message
		team[i].sales = keyboard.nextDouble(); //sales gets double type value from user
	}
		
		
	
	/**
	 * 
	 */
	public void computeAverage() {
		double sum = 0;
		for(int i=0; i < team.length; i++) {
			sum += team[i].sales;
		}
		this.averageSales = sum / team.length;
	}
	
	/**
	 * 
	 */
	public void computeHighestSales() {
		this.highestSales = 0;
		for(int i=0; i < team.length; i++) 
			if(highestSales <= team[i].sales) {
				highestSales = team[i].sales;
				this.highestName = team[i].name;
				this.highestNum = i;
			}
	}
	
	/**
	 * 
	 */
	public void displayResults() {
		System.out.println("Average sales per associate is $" + this.averageSales);
		System.out.println("The highest sales figure is $" + this.highestSales);
		System.out.println("");
		
		for(int i=0; i < team.length; i++) {
			if(i == this.highestNum) {
				System.out.println("The following had the highest sales : ");
				System.out.println("Name : " + this.highestName);
				System.out.println("Sales : " + this.highestSales);
				System.out.println("$" + (this.highestSales-this.averageSales) + "above the average.");
			}
			
			System.out.println("The rest performed as follows :");
			System.out.println("Name : " + team[i].name);
			System.out.println("Sales : $" + team[i].sales);
			if(team[i].sales > this.averageSales) 
				System.out.println("$" + team[i].sales + " aobve the average.");
			if(team[i].sales == this.averageSales)
				System.out.println("$" + team[i].sales + " same the average.");
			if(team[i].sales < this.averageSales)
				System.out.println("$" + team[i].sales + " below the average.");
	
		}
	}
}
