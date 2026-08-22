/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.medicarehospitall;
import java.util.Scanner;
/**
 *
 * @author Tshireletso
 */
public class MediCareHospitall {

    private static wardManagement ward=new wardManagement();
    private static Scanner scan=new Scanner(System.in);
    
    public static void main(String[] args) {
       int option=0;
       
       do{
           System.out.println("\n==========================================");
            System.out.println("  MediCare Hospital Admission System");
            System.out.println("==========================================");
            System.out.println("1. Register New Patient");
            System.out.println("2. Search Patient by ID");
            System.out.println("3. Update Patient Details");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Display Ward Layout");
            System.out.println("7. Allocate Bed to Inpatient");
            System.out.println("8. Release Bed");
            System.out.println("9. Generate Ward Reports");
            System.out.println("10. Sort Patients");
            System.out.println("11. Exit");
            System.out.print("Select an option 1-11 ");
            
            option=scan.nextInt();
            
            if(scan.hasNextInt()){
                handleOption(option);
            }else{
                System.out.println("Invalid input! Please enter a number.");
      
            }
            
       }while (option !=11);
    }
    private static void handleOption(int option){
        
        switch (option){
            case 1-> registerPatient();
            case 2-> searchPatient();
            case 3-> updatePatient();
            case 4-> deletePatient();
            case 5-> displayPatients();
            case 6-> ward.displayWardLayout();
            case 7-> allocateBed();
            case 8-> releaseBed();
            case 9-> printReport();
            case 10-> sortPatientsMenu();
            case 11-> System.out.println("Exiting system. Goodbye!");
            default -> System.out.println("Invalid option selected.");         

        }   
    }
    private static void registerPatient(){
     
        System.out.println("Enter patient ID");
        String id=scan.nextLine();
        
        System.out.println("Enter first name");
        String name=scan.nextLine();
        
        System.out.println("Enter last name");
        String surname=scan.nextLine();
        
        System.out.println("Enter age");
        int age=scan.nextInt();
        
        System.out.println("Enter gender");
        String gender=scan.nextLine();
        
        System.out.println("Enter medical condition");
        String condition=scan.nextLine();
        
        System.out.println("Select Category: 1.Inpatient 2.Outpatient 3.Emergency");
        int choice=Integer.parseInt(scan.nextLine());
        Patient patient = null;
        
        if(ward.registerPatient(patient)){
            System.out.println("Patient registered successfully");
        }else{
            System.out.println("Patient ID already exists");
        }
    }
    private static void searchPatient(){
      System.out.print("Enter Patient ID to search: ");
        String id = scan.nextLine();
        Patient p = ward.findPatientbyId(id);
        if (p != null) {
            System.out.println(p.printDetails());
        } else {
            System.out.println("Patient not found.");
        }
    }
    private static void updatePatient(){
        
        System.out.print("Enter Patient ID to update: ");
        String id = scan.nextLine();
        
        System.out.print("New First Name: ");
        String fname = scan.nextLine();
        System.out.print("New Last Name: ");
        String lname = scan.nextLine();
        System.out.print("New Age: ");
        int age = Integer.parseInt(scan.nextLine());
        System.out.print("New Gender: ");
        String gender = scan.nextLine();
        System.out.print("New Medical Condition: ");
        String condition=scan.nextLine();
        
        if(ward.updatePatientDetails(gender, fname, lname, age, gender, condition)){
            System.out.println("Patient details updated successfully.");
        }
    }
    public static void deletePatient(){
        System.out.print("Enter Patient ID to delete: ");
        String id = scan.nextLine();
        if(ward.deletePatient(id)){
            System.out.println("Patient removed successfully.");
        }else{
            System.out.println("Patient not found");
        }
    }
    private static void displayPatients(){
        
        if(ward.getPatients().isEmpty()){
            System.out.println("No registered patients.");
            return;
        }
        for(Patient p: ward.getPatients()){
            System.out.println(p.printDetails());
        }
    }
    private static void allocateBed(){
        
        
    }
    }
