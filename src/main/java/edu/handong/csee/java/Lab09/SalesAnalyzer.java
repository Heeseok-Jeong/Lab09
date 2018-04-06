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
	 * gets information of salesmen and shows the result comparing with average
	 */
	public static void main(String[] args) { //main method
		int i; //declare a variable i
		Scanner keyboard = new Scanner(System.in); //instantiate a keyboard
		SalesAnalyzer sAnalyze = new SalesAnalyzer(); //instantiate sAnalyze
		
		System.out.println("Enter number of sales associates : "); //print some message
		int times = keyboard.nextInt(); //times gets value from user
		System.out.println("");
		//SalesAssociate[] mTeam = new SalesAssociate[times]; //instantiate(?) SalesAssociate type array team 
		
		for(i=0; i < times; i++) { //repeat as times
			System.out.println("Enter data for associate number " + (i+1)); //print some message
			sAnalyze.getData(i); //gets person(i)'s value
			System.out.println(""); //make a one line
		}
		
		sAnalyze.computeAverage(); //computes sales average
		sAnalyze.computeHighestSales(); //computes that highest person's name, sales and index
		
		sAnalyze.displayResults(); //print all the results
	}

	/**
	 * gets a data of name and sales of person
	 */
	public void getData(int i) { //method name is getData
		//SalesAssociate[] mTeam = new SalesAssociate[i]; //instantiate(?) SalesAssociate type array team 
		Scanner keyboard = new Scanner(System.in); //instantiate keyboard to use scanner
		System.out.print("Enter name of sales associate : "); //print some message
		this.team[i].name = keyboard.nextLine();  //name gets string type value from user 
		System.out.print("Enter associate's sales : $"); //print some message
		this.team[i].sales = keyboard.nextDouble(); //sales gets double type value from user
		
	}
		
		
	
	/**
	 * this method computes a sales average
	 */
	public void computeAverage() { //this method name is computeAverage
		double sum = 0;
		for(int i=0; i < this.team.length; i++) {
			sum += this.team[i].sales;
		}
		this.averageSales = sum / team.length;
	}
	
	/**
	 * this method computes informations of who sells the highest prices
	 */
	public void computeHighestSales() { //this method name is computeHighestSales
		this.highestSales = 0; //this variable's value is 0
		for(int i=0; i < this.team.length; i++)  //loop until i's value is same team.length
			if(highestSales <= this.team[i].sales) { //if highestSales value is smaller or equal team[i].sales value
				highestSales = this.team[i].sales; //highestSalesvalue is that value
				this.highestName = this.team[i].name; //highestName is that name
				this.highestNum = i; //highestNum is that index
			}
	}
	
	/**
	 * this method shows sales average and highest sales ,also each people's evaluation comparing with average
	 */
	public void displayResults() { //this method name is displayResults
		System.out.println("Average sales per associate is $" + this.averageSales); //print sales average
		System.out.println("The highest sales figure is $" + this.highestSales); //print highest sales
		System.out.println(""); //add one line
		
		for(int i=0; i < this.team.length; i++) { //loop until i's value is same team.length
			if(i == this.highestNum) {  //if i is same this.highestNum
				System.out.println("The following had the highest sales : "); //print some message
				System.out.println("Name : " + this.highestName); //print highest seller's name
				System.out.println("Sales : " + this.highestSales); //print highest sales
				System.out.println("$" + (this.highestSales-this.averageSales) + "above the average.");
			}
			
			System.out.println("The rest performed as follows :");
			System.out.println("Name : " + this.team[i].name);
			System.out.println("Sales : $" + this.team[i].sales);
			if(this.team[i].sales > this.averageSales) 
				System.out.println("$" + (this.team[i].sales-this.averageSales) + " aobve the average.");
			if(this.team[i].sales == this.averageSales)
				System.out.println("$" + (this.team[i].sales-this.averageSales) + " same the average.");
			if(this.team[i].sales < this.averageSales)
				System.out.println("$" + (this.averageSales - this.team[i].sales) + " below the average.");
	
		}
	}
}
