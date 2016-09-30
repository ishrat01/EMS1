package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;
import com.flp.ems.domain.KinId;

public class EmployeeDaoImplForList {
	ArrayList<Employee> employeeList=new ArrayList<Employee>() ;
	public void addEmployee(Employee employee) 
	{
		employeeList.add(employee) ;
		System.out.println("Added");
	}
	public Employee searchModifyEmployee(int id)
	{
		for(int i=0 ; i<employeeList.size() ;i++)
		{
			if(employeeList.get(i).getEmployeeId()==id)
			{
				
				return employeeList.get(i) ;
			}
			
		}
		return null ;
	}

	public void modifyEmployee(Employee employee) 
	{
		System.out.println("In dao");
		for(int i=0 ; i<employeeList.size() ;i++)
		{
			if(employeeList.get(i).getEmployeeId()==employee.getEmployeeId())
			{
				//employeeList.add(i, employee);
				employeeList.set(i, employee) ;
				break ;
				
			}
			
		}
		System.out.println("ok dao");
		
	}
	
	public boolean removeEmployee(int idRemove) 
	{System.out.println("Outside loop");
	
		for(int i=0 ; i<employeeList.size() ;i++)
		{
			if(employeeList.get(i).getEmployeeId()==idRemove)
			{
				employeeList.remove(i) ;
				return true ;
			}
			
		}
		return false ;
	}
	
	public HashMap<String,String> searchEmployee(HashMap<String,String> searchMap) 
	{
		HashMap<String,String> searched=new HashMap<String,String>() ;
		if(searchMap.containsKey("id"))
		{
			
			int id=Integer.parseInt(searchMap.get("id")) ;
			System.out.println("In dao"+id);
			for(Employee a:employeeList)
			{
				if(a.getEmployeeId()==id)
				{
					System.out.println("matched");
				searched.put("name", a.getName()) ;
				searched.put("dob", a.getDob().toString()) ;
				searched.put("doj", a.getDoj().toString()) ;
				searched.put("kinid", a.getKinId().toString()) ;
//				searched.put("name", a.getName()) ;
//				searched.put("name", a.getName()) ;
//				searched.put("name", a.getName()) ;
//				searched.put("name", a.getName()) ;
//				searched.put("name", a.getName()) ;
				}
		
			}
		
		}
		else if(searchMap.containsKey("name"))
		{
			String name=searchMap.get("name") ;
			for(Employee a:employeeList)
			{System.out.println("In dao");
				if(a.getName().equals(name))
				{
					System.out.println("Found");
					searched.put("name", a.getName()) ;
					searched.put("dob", a.getDob().toString()) ;
					searched.put("doj", a.getDoj().toString()) ;
					//searched.put("kinid", a.getKinId().toString()) ;
				}
		
			}
		
		}
		else if(searchMap.containsKey("kinid"))
		{
			String kinid=searchMap.get("kinid") ;
			for(Employee a:employeeList)
			{
				if(a.getKinId().toString().equals(kinid))
				{
					searched.put("name", a.getName()) ;
					searched.put("dob", a.getDob().toString()) ;
					searched.put("doj", a.getDoj().toString()) ;
					searched.put("kinid", a.getKinId().toString()) ;
				}
		
			}
		
		}
	return searched ;
	}
	public ArrayList<Employee> getAllEmployee()
	{
		System.out.println(employeeList.size());
		return employeeList ;
	}
}
