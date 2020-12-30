package com.cg.service.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.cg.service.client.ServiceForms;
import com.cg.service.dao.ServiceFormsDAO;
import com.cg.service.service.ServiceFormService;

public class ServiceMain 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int mainChoice, customerChoice, adminChoice;
		
		ServiceFormsDAO serviceformDAO = new ServiceFormsDAO();
		ServiceFormService serviceformservice=new ServiceFormService();
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		do 
		{
			System.out.print("Select User Type \n1.Customer\n2.Admin\n3.Exit\n");
			mainChoice = sc.nextInt();
			switch(mainChoice)
			{
				case 1 : 
				do			
				{
				
			 	System.out.println("1.Fill Service Form\n2.Check status\n3.Check amount\n4.Exit");
			 	customerChoice = sc.nextInt();
			 	switch(customerChoice)
			 		{
			 			case 1 :serviceformservice.createServiceForm();	
			 					break;
			 	
			 			case 2 :System.out.println("****Check Status****"); 			 						 			 					
			 					System.out.println("Enter email");
			 					String email=sc.next();
			 					ServiceForms serviceform1=serviceformservice.searchServiceViaEmail(email)	;				 											
			 					System.out.println(serviceform1);
	
			 					break;	 		
			 			
			 			case 3 :System.out.println("****Check amount****");			 						 					
			 					System.out.println("Enter email");
			 					String email2=sc.next();
			 					ServiceForms serviceform2=serviceformservice.searchServiceViaEmail(email2)	;						
			 					System.out.println(serviceform2);										
			 					break;			 								 						
				 			
			 		}
			 	}while(customerChoice!=4);
			 	break;			 						 								 
				
			    case 2 : 
				do	
				{			
				
					System.out.println("1.Search Service By User Email\n2.Search Service By User Phone\n3.View Services\n4.Add prices\n5.Update Status\n6.Exit");
					adminChoice = sc.nextInt();
					switch(adminChoice)
					{
						case 1 :System.out.println("********Search Service By User Email********"); 
						System.out.println("Enter email");
						String email=sc.next();
						ServiceForms serviceform1=serviceformservice.searchServiceViaEmail(email);
						System.out.println(serviceform1);
				
						break;
			 			 
						case 2 :System.out.println("********Search Service By User Phone********"); 
						System.out.println("Enter phone no");
						String number=sc.next();
						ServiceForms serviceform2=serviceformservice.searchServiceViaPhone(number);
						System.out.println(serviceform2);
				
						break;
						
						case 3 : System.out.println("****View Services by status****");					 							
						System.out.println("Enter status to check services");
					 	String statusop=sc.next();
					 	List<ServiceForms> list = serviceformDAO.fetchServices(statusop);
			 	        list.stream().forEach(System.out::println);
						
					 	break;
					 									 															
						case 4 :System.out.println("****Add price****"); 												
						System.out.println("Enter id");
						int id=sc.nextInt();
						ServiceForms serviceform4=serviceformservice.searchServiceViaId(id);
						System.out.println(serviceform4);
						System.out.println("Enter service charge");
						float servicechg=sc.nextFloat();
						System.out.println("Enter parts charge");
						float partschg=sc.nextFloat();
						float totalchg=servicechg+partschg;
						serviceform4.setAmount(totalchg);							
						ServiceForms sfp = serviceformDAO.addAmount(id,totalchg);
						System.out.println(sfp);
						break;
						
							
						case 5 :System.out.println("****Update Status****"); 
						
						System.out.println("Enter id");
						int id2=sc.nextInt();
						ServiceForms serviceform5=serviceformservice.searchServiceViaId(id2);
						System.out.println(serviceform5);
						System.out.println("Enter Status");
						String statusch=sc.next();							
						ServiceForms sfs = serviceformDAO.updateStatus(id2,statusch);
						System.out.println(sfs);
						break;	
							
					}//switch
				}while(adminChoice!=6);//do
				break;
			}
		}while(mainChoice!=3);
		
		System.out.println("Thanks for visiting!!");

	}

}
