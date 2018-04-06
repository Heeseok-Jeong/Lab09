package edu.handong.csee.java.Lab09;

/**
 * This class is a data of SalesAssociate which contains name and sales.
 * Furthermore, it has setter and getter of each members.
 * @author JHS
 */
public class SalesAssociate { //class name is SalesAssociate
	String name; //first member is string type name
	double sales; //second member is double type sales
	
	/**
	 * getter of name
	 */
	public String getName() { //this method name is getName
		return name; //return a string of name
	}
	
	/**
	 * setter of name
	 */
	public void setName(String name) { //this method name is setName
		this.name = name; //sets the instance variable name with parameter
	}
	
	/**
	 * getter of sales
	 */
	public double getSales() { //this method name is getSales
		return sales; //return a value of name
	}
	
	/**
	 * setter of sales
	 */
	public void setSales(double sales) { //this method name is setSales
		this.sales = sales; //sets the instance variable sales with parameter
	}
	
}
