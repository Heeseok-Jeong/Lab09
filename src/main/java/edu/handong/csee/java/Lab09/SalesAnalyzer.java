package edu.handong.csee.java.Lab09;
import java.util.ArrayList;
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
	private SalesAssociate sAssociate = new SalesAssociate();
	private String name = sAssociate.name;
	private Double sales = sAssociate.sales;
	private ArrayList<String> teamName = new ArrayList<String>();
	private ArrayList<Double> teamSales = new ArrayList<Double>();
	private int listSize = teamName.size();
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
		int i = 1;
		boolean done = true;
		
		while(done) { //repeat as times
			System.out.println("Enter data for associate number " + i++); //print some message
			System.out.print("Enter name of sales associate : "); //print some message
			keyboard.nextLine(); //this is for skipping enter key
			String name = keyboard.nextLine();  //name gets string type value from user 
			teamName.add(name);
			System.out.print("Enter associate's sales : $"); //print some message
			Double sales = keyboard.nextDouble(); //sales gets double type value from user
			teamSales.add(sales);
			System.out.println(""); //print one line
			System.out.print ("More items for the list?('yes' for run or other key) ");
			String ans = keyboard.nextLine ();
            if (!ans.equalsIgnoreCase ("yes"))
                done = false;
            System.out.println(""); //print one line
		}
	}	
	
	/**
	 * this method computes a sales average and informations of who sells the highest prices
	 */
	public void computeStats() { //this method name is computeAverage
		 
		double sum = 0; //declare a local variable
		for(int i = 0; i < listSize; i++) { //repeat listSize times
			sum += teamSales.get(listSize); //keep summing person's sales value into sum
			
			highestSales = 0.0;
			if(highestSales <= teamSales.get(i)) { //if highestSales value is less than team[i].sales value
				highestSales = teamSales.get(i); //highestSalesvalue is that value
				highestName = teamName.get(i); //highestName is that name
			}
		}
		averageSales = sum / listSize; //the average is sum / listSize
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
		System.out.println("The rest performed as follows :"); //print some message
		
		for(int i=0; i < listSize; i++) { //loop until i's value is same team.length
			if(teamSales.get(i) != highestSales) {  //if i is same this.highestNum
				System.out.println("Name : " + teamName.get(i)); //print team[i]'s name
				System.out.println("Sales : $" + teamSales.get(i)); //print team[i]'s sales
				if(teamSales.get(i) > averageSales)  //and if team[i]'s sales is larger than average
					System.out.println("$" + (teamSales.get(i) - averageSales) + " above the average."); //print how much different between sales and average
				if(teamSales.get(i) == averageSales)  //or if team[i]'s sales is same than average
					System.out.println("$" + (teamSales.get(i) - averageSales) + " same the average."); //print how much different between sales and average
				if(teamSales.get(i) < averageSales) //or if team[i]'s sales is smaller than average
					System.out.println("$" + (averageSales - teamSales.get(i)) + " below the average."); //print how much different between sales and average
			}
		}
	}
}
