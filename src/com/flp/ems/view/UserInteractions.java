package com.flp.ems.view;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;

import sun.print.resources.serviceui;

public class UserInteractions {
	static Scanner scanner = new Scanner(System.in) ;
	static HashMap transfer = new HashMap<String,String>() ;
	static EmployeeServiceImpl service = new EmployeeServiceImpl() ;
	
	public static void addEmployee() throws ParseException
	{
		System.out.println("Enter the details of the Employee to be added");
		System.out.println("Enter the name of the Employee");
		String name=scanner.next() ;
		System.out.println("Enter the phone number of the Employee");
		String phoneNo=scanner.next() ;
		System.out.println("Enter the date of birth of Employee");
		String dob = scanner.next() ;
		System.out.println("Enter the date of joining of Employee");
		String doj=scanner.next() ;
		System.out.println("Enter the address of Employee");
		String address=scanner.next() ;
		transfer.put("name", name) ;
		transfer.put("phoneNo", phoneNo) ;
		transfer.put("address", address) ;
		transfer.put("doj", doj) ;
		transfer.put("dob", dob) ;
		
		service.addEmployee(transfer);
	}
	public static void modifyEmployee()
	{
		getAllEmployee();
		System.out.println("From the list enter id of the employee whose details are to be modified") ;
		int idModigy=Integer.parseInt(scanner.next()) ;
		
		System.out.println("Select fild to be edited") ;
		System.out.println("1. Name");
		System.out.println("2. Phone Number");
		System.out.println("3. Address");
		System.out.println("4. Date of Birth");
		System.out.println("5. Date of Joining");
		
		int choice; 
		boolean flag =true ;
		while(flag)
		{
			
			choice=scanner.nextInt() ;
			
			switch(choice)
			{
			
			case 1:
				System.out.println("Enter Name");
				String name=scanner.next() ;
				transfer.put("name", name) ;
				break ;
			case 2:
				System.out.println("Enter Phone Number");
				String phoneNo=scanner.next() ;
				transfer.put("phoneNo", phoneNo) ;
				break ;
			case 3:
				System.out.println("Enter Address");
				String address=scanner.next() ;
				transfer.put("address", address) ;
				break ;
			case 4:
				System.out.println("Enter Date of Borth");
				String dob=scanner.next() ;
				transfer.put("dob", dob) ;
				break ;
			case 5:
				System.out.println("Enter Date of Joining");
				String doj=scanner.next() ;
				transfer.put("doj", doj) ;
				break ;
				default:
				
					flag=false ;
					
					break ;
				
			}
			System.out.println("Again enter choice") ;
		}
			
		service.modifyEmployee(transfer,idModigy);
		getAllEmployee();
		}
		
		
	
	public static void removeEmployee()
	{
	 System.out.println("Enter the id of the employee to ne deleted") ;
	 String id=scanner.next() ;
	 boolean result=service.removeEmployee(id);
	 if(!result)
	 {
		 System.out.println("Employee to be removed not found");
	 }
	}
	public static void searchEmployee()
	{
	HashMap<String,String> searchMap=new HashMap() ;
		System.out.println("Enter Criteria through which you want to search") ;
		System.out.println("1. Id");
		System.out.println("2. Name");
		System.out.println("3. KinId");
		
		int choice=scanner.nextInt() ;
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter id");
			int id=scanner.nextInt() ;
			searchMap.put("id", ""+id) ;
			service.searchEmployee(searchMap) ;
			break ;
		case 2:
			System.out.println("Enter Name");
			String name=scanner.next() ;
			searchMap.put("name", name) ;
			System.out.println("In ui");
			service.searchEmployee(searchMap) ;
			break ;
		case 3:
			System.out.println("Enter kinid");
			String kinid=scanner.next() ;
			searchMap.put("kinid", kinid) ;
			break ;
		}
	}
	public static void getAllEmployee()
	{
		HashMap<String,String>[] hashArray=service.getAllEmployee();
		
		for(HashMap a : hashArray)
		{
			System.out.println(a.get("id")+" "+a.get("name")+a.get("dob").toString()+a.get("doj").toString());
		}
	}
}
