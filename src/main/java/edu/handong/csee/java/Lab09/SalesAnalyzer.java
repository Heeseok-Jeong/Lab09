package edu.handong.csee.java.Lab09;
import java.util.Scanner; //call a package to use scanner

/**
 * This program gets number of salesmen, their names, sales and computes average of sales. 
 * Also, shows who sells the highest profit comparing with average and shows other members results. 
 * @author JHS
 */
public class SalesAnalyzer { //the class name is SalesAnalyzer
	private double averageSales; //declare an instance variable
	private double highestSales; //declare an instance variable
	private String highestName; //declare an instance variable 
	private int numberOfAssociate; //declare an instance variable
	private SalesAssociate[] team = new SalesAssociate[numberOfAssociate]; //declare and instantiate SalesAssociate type array
	Scanner keyboard = new Scanner(System.in); //instantiate a keyboard
	
	/**
	 * gets information of salesmen, computes stats and shows the result comparing with average.
	 */
	public static void main(String[] args) { //main method
		SalesAnalyzer sAnalyze = new SalesAnalyzer(); //instantiate this class
		sAnalyze.getData(); //get some people's data
		sAnalyze.computeStats(); //computes sales average and that highest person's name and sales
		sAnalyze.displayResults(); //print all the results
	}

	/**
	 * gets a name and sales of person
	 */
	public void getData() { //method name is getData
		System.out.println("Enter number of sales associates : "); //print some message
		this.numberOfAssociate = keyboard.nextInt(); //times gets value from user
		//keyboard.nextLine(); //this is for skipping enter key
		team = new SalesAssociate[numberOfAssociate]; //instantiate SalesAssociate array team 
		
		for(int i=0; i < numberOfAssociate; i++) { //repeat as times
			team[i] = new SalesAssociate();
			System.out.println("Enter data for associate number " + (i+1)); //print some message
			System.out.print("Enter name of sales associate : "); //print some message
			keyboard.nextLine(); //this is for skipping enter key
			team[i].name = keyboard.nextLine();  //name gets string type value from user 
			System.out.print("Enter associate's sales : $"); //print some message
			team[i].sales = keyboard.nextDouble(); //sales gets double type value from user
			System.out.println("");
		}
	}
		
		
	
	/**
	 * this method computes a sales average and informations of who sells the highest prices
	 */
	public void computeStats() { //this method name is computeAverage
		int i;
		double sum = 0;
		for(i=0; i < numberOfAssociate; i++) {
			sum += team[i].sales;
			
			if(highestSales <= team[i].sales) { //if highestSales value is less than team[i].sales value
				highestSales = team[i].sales; //highestSalesvalue is that value
				highestName = team[i].name; //highestName is that name
			}
		}
		averageSales = sum / numberOfAssociate;
	}
	
	/**
	 * this method shows sales average and highest sales ,also each people's evaluation comparing with average
	 */
	public void displayResults() { //this method name is displayResults
		System.out.println("Average sales per associate is $" + averageSales); //print sales average
		System.out.println("The highest sales figure is $" + highestSales); //print highest sales
		System.out.println(""); //add one line
		
		System.out.println("The following had the highest sales : "); //print some message
		System.out.println("Name : " + highestName); //print highest seller's name
		System.out.println("Sales : " + highestSales); //print highest sales
		System.out.println("$" + (highestSales-averageSales) + "above the average.");
		System.out.println(""); //add one line
		System.out.println("The rest performed as follows :");
		
		for(int i=0; i < team.length; i++) { //loop until i's value is same team.length
			if(team[i].sales != highestSales) {  //if i is same this.highestNum
				System.out.println("Name : " + team[i].name);
				System.out.println("Sales : $" + team[i].sales);
				if(team[i].sales > averageSales) 
					System.out.println("$" + (team[i].sales-averageSales) + " aobve the average.");
				if(team[i].sales == averageSales) 
					System.out.println("$" + (team[i].sales-averageSales) + " same the average.");
				if(this.team[i].sales < averageSales) 
					System.out.println("$" + (averageSales - team[i].sales) + " below the average.");
			}
		}
	}
}
