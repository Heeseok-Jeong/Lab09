package edu.handong.csee.java.Lab09;
import java.util.ArrayList;
import java.util.Scanner; //call a package to use scanner

/**
 * This program gets number of salesmen, their names, sales and computes average of sales by using ArrayList. 
 * Also, shows who sells the highest profit comparing with average and shows other members results. 
 * @author JHS
 */
public class SalesAnalyzer { //the class name is SalesAnalyzer
	private double averageSales; //declare an instance variable
	private double highestSales; //declare an instance variable
	private String highestName; //declare an instance variable 
	private SalesAssociate sAssociate = new SalesAssociate(); //instantiate SalesAssociate class
	private String name = sAssociate.name; //instantiate name in the SalesAssociate class
	private Double sales = sAssociate.sales; //instantiate sales in the SalesAssociate class
	private ArrayList<String> teamName = new ArrayList<String>(); //instantiate String type ArrayList 'teamName'
	private ArrayList<Double> teamSales = new ArrayList<Double>(); //instantiate Double type ArrayList 'teamSales'
	private int listSize; //declare an instance variable 
	Scanner keyboard = new Scanner(System.in); //instantiate Scanner
	
	/**
	 * gets information of salesmen, computes several stats and shows the result comparing with an average.
	 */
	public static void main(String[] args) { //main method
		SalesAnalyzer sAnalyze = new SalesAnalyzer(); //instantiate this class
		sAnalyze.getData(); //gets some people's data
		sAnalyze.computeStats(); //computes sales average and that highest person's name and sales
		sAnalyze.displayResults(); //prints all the results
	}

	/**
	 * gets a name and sales of person. The way how many people we take it is the word 'yes' which get from user
	 */
	public void getData() { //method name is getData
		int i = 1; //initialize a local variable
		boolean done = true; //initialize a local variable for loop
		
		while(done) { //if boolean type done is true, below things will loops
			System.out.println("Enter data for associate number " + i++); //print some message
			System.out.print("Enter name of sales associate : "); //print some message
			String name = keyboard.nextLine();  //local variable name gets string type value from user 
			teamName.add(name); //local variable name's value is added into the ArrayList teamName
			System.out.print("Enter associate's sales : $"); //print some message
			Double sales = keyboard.nextDouble(); //local variable sales gets double type value from user
			teamSales.add(sales); //local variable sales's value is added into the ArrayList teamSales
			keyboard.nextLine(); //this is for skipping enter key
			System.out.println(""); //print one line
			System.out.print ("More items for the list?('yes' for run or other key) "); //ask for user input 'yes' or not  
			String ans = keyboard.nextLine (); //local variable ans gets the answer from user
            if (!ans.equalsIgnoreCase ("yes")) //if ans's value isn't 'yes' or 'YES', 
                done = false; //done's value is false, then this loop will stop
            System.out.println(""); //print one line
		}
	}	
	
	/**
	 * this method computes a sales average and informations of who sells the highest prices
	 */
	public void computeStats() { //this method name is computeStats
		listSize = teamSales.size(); //the instance variable listSize's values is ArrayList teamSales's size(length)
		highestSales = 0.0; //set the instance variable highestSales's value zero
		double sum = 0.0; //initialize local variable sum's value zero
		for(int i = 0; i < listSize; i++) { //repeat listSize times
			sum += teamSales.get(i); //keep summing each people's sales value into sum
			
			if(highestSales <= teamSales.get(i)) { //if highestSales value is less than teamSales[i] value
				highestSales = teamSales.get(i); //highestSalesvalue is that value
				highestName = teamName.get(i); //highestName is that name
			}
		}
		
		averageSales = sum / listSize; //the average is sum / listSize
	}
	
	/**
	 * this method shows sales average and highest sales, also each people's evaluation comparing with average
	 */
	public void displayResults() { //this method name is displayResults
		System.out.println("Average sales per associate is $" + averageSales); //print sales average
		System.out.println("The highest sales figure is $" + highestSales); //print highest sales
		System.out.println(""); //add one line
		
		System.out.println("The following had the highest sales : "); //print some message
		System.out.println("Name : " + highestName); //print the highest seller's name
		System.out.println("Sales : " + highestSales); //print the highest sales
		System.out.println("$" + (highestSales-averageSales) + "above the average."); //print how much different between sales and average
		System.out.println(""); //add one line
		System.out.println("The rest performed as follows :"); //print some message
		
		for(int i=0; i < listSize; i++) { //repeat listSize times
			if(teamSales.get(i) != highestSales) {  //if teamSales[i]'s value isn't same highestSales 
				System.out.println("Name : " + teamName.get(i)); //print teamName[i]'s value(name)
				System.out.println("Sales : $" + teamSales.get(i)); //print teamSales[i]'s value(sales)
				if(teamSales.get(i) > averageSales)  //and if teamSales[i]'s value is larger than average
					System.out.println("$" + (teamSales.get(i) - averageSales) + " above the average."); //print how much different between sales and average
				else if(teamSales.get(i) == averageSales)  //or if teamSales[i]'s sales is same average
					System.out.println("$" + (teamSales.get(i) - averageSales) + " same the average."); //print how much different between sales and average
				else if(teamSales.get(i) < averageSales) //or if teamSales[i]'s sales is smaller than average
					System.out.println("$" + (averageSales - teamSales.get(i)) + " below the average."); //print how much different between sales and average
			}
		}
	}
}
