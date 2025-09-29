package hibernate.basics;

import java.util.Scanner;

import hibernate.basics.entity.Teacher;
import hibernate.basics.service.TeacherService;

public class TeacherDriver {

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		
		TeacherService thService=new TeacherService();
		
		System.out.println("Welcome to our website!!");
		
		boolean flag=true;
		while(flag) {
			System.out.println("Press 1 for inserting Teacher details");
			System.out.println("Press 2 for updating Teacher details");
			System.out.println("Press 3 for deleting Teacher details");
			System.out.println("Press 4 for fetching Teacher details");
			System.out.println("Press 5 for exit our application");

			System.out.println("Enter your choice: ");
			int choice = scn.nextInt();
			
			switch (choice) {
			case 1:
			{
				System.out.println("Enter Teacher id: ");
				int id = scn.nextInt();
				scn.nextLine(); // new leftover line
				System.out.println("Enter Teacher name: ");
				String name = scn.nextLine();
				System.out.println("Enter Teacher age: ");
				int age = scn.nextInt();
				
				Teacher th=new Teacher();
				th.setId(id);
				th.setName(name);
				th.setAge(age);

				thService.insertData(th);
				
			}
				break;
			case 2: {
				// Updating part
								
				System.out.println("Enter Modified Teacher id: ");
				int id = scn.nextInt();
				
				Teacher th=new Teacher();
				th.setId(id);				
				thService.updateData(th);		
			}
			
			break;
			case 3: {
				// Deleting part
				
				System.out.println("Enter Delete Teacher id: ");
				int id = scn.nextInt();
				
				Teacher th=new Teacher();
				th.setId(id);				
				thService.deleteData(th);
				
				
				
			}
			break;
			
			case 4: {
				// fetching part
				
				thService.fetchData();
				
			}
			break;
			
			case 5: {
				// exit app
				
				scn.close();
				thService.exitApp();
				System.out.println("Thanked You! Visit Again!! :) ");
				flag=false;
			}
			break;

			default:
				System.out.println("Sorry! Invalid input!! :( ");
				break;
			}
			
			

		}
		
		

	}

}
