package com.cg.service.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.cg.service.client.ServiceForms;
import com.cg.service.dao.ServiceFormsDAO;

public class ServiceFormService {	
	
	public void createServiceForm() throws IOException
	{
		Scanner sc=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ServiceFormsDAO serviceformDAO = new ServiceFormsDAO();
		ServiceForms serviceform = new ServiceForms();
		System.out.println("*****Fill The form*******\n");
			System.out.println("Enter your name");
			serviceform.setName(br.readLine());

			System.out.println("Enter email");
			serviceform.setEmailid(br.readLine());

			System.out.println("Enter phone no");
			serviceform.setMobile(br.readLine());

			System.out.println("Enter vehicle type in wheels(eg:2,3,4)");			
			serviceform.setVeh_type(br.readLine());

			System.out.println("Choose your Service Option : \n1.Repairing your vehicle\n2.Request for new parts\n3.Wash and clean your Vehicle\n4.Fix an Appointment");			 
			int option=sc.nextInt();
			
			switch(option)
 			{
 				case 1:serviceform.setService_type("Repairing your vehicle");			 			
 				break;
 	
 				case 2:serviceform.setService_type("Request for new parts");			 								
 				System.out.println("Enter name n quantity of the parts you want to buy"); 
 				String li=br.readLine(); 				
 				serviceform.setParts_name(li);
 				break;								

 				case 3:serviceform.setService_type("Wash and clean your Vehicle");			 	
 				break;
 	
 				case 4:serviceform.setService_type("Or want to fix an Appointment");
 				System.out.println("We will update you about the details soon!!");
 				break;	
 			}
	
 			System.out.println("Submitted your service request!!");
			serviceformDAO.addService(serviceform);								
	}
	
	public ServiceForms searchServiceViaId(int id) {
		ServiceFormsDAO serviceformDAO = new ServiceFormsDAO();
		ServiceForms serviceform=serviceformDAO.findUserById(id);
		return serviceform;
	}
	
	public ServiceForms searchServiceViaEmail(String email) {
		ServiceFormsDAO serviceformDAO=new ServiceFormsDAO();
		ServiceForms serviceform=serviceformDAO.findUserByEmail(email);
		return serviceform;
	}
	
	public ServiceForms searchServiceViaPhone(String number) {
		ServiceFormsDAO serviceformDAO=new ServiceFormsDAO();
		ServiceForms serviceform=serviceformDAO.findUserByPhone(number);
		return serviceform;
	}		
		
}
