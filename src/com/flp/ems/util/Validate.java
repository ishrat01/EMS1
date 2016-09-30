package com.flp.ems.util;

import java.util.Date;

class InvalidEntryException extends Exception{

	public InvalidEntryException(String message) {
		super(message);
		
	}
	
}
public class Validate 
{
	public static boolean validateName(String name)
	{
		try
	
		{
			 if(name==null||name.contains("[0-9]")||name.contains("!@#$%^&*()_"))
			{
				 throw new InvalidEntryException("Invalid Name") ;		
			}
			  
			
			 
		}catch(InvalidEntryException e)
		{
			System.out.println("Terminated");
		}
		System.out.println("Validated");
		 return true ;

	}
	public static boolean validateAddress(String address)
	{
		if(address==null)
		{
			try {
				throw new InvalidEntryException("Address should not be null") ;
			} catch (InvalidEntryException e) {
				System.out.println("Terminated");
			}
		}
		return true ;
	}
	public static boolean validateDOB(Date doj)
	{
		Date d= new Date() ;
		if(doj.compareTo(d)<0)
		{
			return true ;
		} else
		{
			try {
				throw new InvalidEntryException("Invalid Date of Birth") ;
			} catch (InvalidEntryException e) {
				System.out.println("Terminated");
				return false ;
			}
	
		}
		
	}
	
	public static boolean validateDate(String date)
	{
		return true ;
	}
	
	public static boolean validatePhoneNo(String phoneNo)
	{
		if(phoneNo==null||phoneNo.contains("[A-Za-z]"))
		{
			return true ;
		}
		return false ;
	}
	
	
	
	
	
	
}

