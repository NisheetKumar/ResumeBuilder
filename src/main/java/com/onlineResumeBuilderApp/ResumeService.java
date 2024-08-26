package com.onlineResumeBuilderApp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeService<E> {
	private Scanner scanner=new Scanner(System.in);
	
	public User getUserInfo() {
		System.out.println("Enter your firstname");
		String firstName=scanner.nextLine();
		
		System.out.println("Enter your lastname");
		String lastname=scanner.nextLine();
		
		System.out.println("Enter your email");
		String email=scanner.nextLine();
		
		System.out.println("Enter your phonenumber");
		String phoneNumber=scanner.nextLine();
		
		 System.out.print("Enter a brief summary about yourself: ");
	     String summary = scanner.nextLine();
		return new User(firstName, lastname, email, phoneNumber, summary);
	}
	public List<Experience>getExperience(){
		
		List<Experience>experienceList=new ArrayList();
		while(true) {
		System.out.print("Enter the company name: ");
        String company = scanner.nextLine();
        System.out.print("Enter the position: ");
        String position = scanner.nextLine();
        System.out.print("Enter the start date (YYYY-MM): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter the end date (YYYY-MM) or 'present' if currently working: ");
        String endDate = scanner.nextLine();
        System.out.print("Enter a brief description of your role: ");
        String description = scanner.nextLine();
        experienceList.add(new Experience(company, position, startDate, endDate, description));
        
        System.out.print("Do you want to add another experience? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("no")) {
            break;
        }
		}
		return experienceList;
	}
	

    public void generateResume(User user, List<Experience> experiences) {
        try (FileWriter writer = new FileWriter("//C://Users//nvign//OneDrive//Desktop//Resume.txt")) {
            writer.write("Resume\n");
            writer.write("======\n\n");
            writer.write("Personal Information\n");
            writer.write("--------------------\n");
            writer.write("Name: " + user.getFirstName() + " " + user.getLastName() + "\n");
            writer.write("Email: " + user.getEmail() + "\n");
            writer.write("Phone: " + user.getPhone() + "\n");
            writer.write("Summary: " + user.getSummary() + "\n\n");

            writer.write("Experience\n");
            writer.write("----------\n");
            for (Experience exp : experiences) {
                writer.write("Company: " + exp.getCompany() + "\n");
                writer.write("Position: " + exp.getPosition() + "\n");
                writer.write("From: " + exp.getStartDate() + " To: " + exp.getEndDate() + "\n");
                writer.write("Description: " + exp.getDescription() + "\n\n");
            }

            System.out.println("Resume generated successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the resume.");
            e.printStackTrace();
        }
    }
}


