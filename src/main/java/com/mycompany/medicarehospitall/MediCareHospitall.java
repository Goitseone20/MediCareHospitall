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
            
            
            
            if(scan.hasNextInt()){
                option=scan.nextInt();
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
     
       System.out.print("Enter Patient ID: ");
        String ID = scan.nextLine();
        System.out.print("Enter First Name: ");
        String fname = scan.nextLine();
        System.out.print("Enter Last Name: ");
        String lname = scan.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scan.nextLine());
        System.out.print("Enter Gender: ");
        String gender = scan.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scan.nextLine();

        System.out.println("Select Category: 1. Inpatient  2. Outpatient  3. Emergency");
        int Choice = Integer.parseInt(scan.nextLine());
      
        
        Patient patient = null;
        String patientCategory = null;
        if (Choice == 1) {
           
            patient = new InPatient( ID, fname, lname, age, gender, condition, patientCategory);
        } else if (Choice == 2) {
            patient = new InPatient(ID, fname, lname, age, gender, condition, patientCategory);
        } else {
            patient = new InPatient(ID, fname, lname, age, gender, condition, patientCategory);
        }
        
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
       
        System.out.print("Enter Inpatient ID: ");
        String id = scan.nextLine();
        System.out.print("Enter Bed Number to allocate (e.g., B01): ");
        String bed = scan.nextLine();
        
        if(ward.allocateBed(bed, bed)){
            System.out.println("Bed " + bed + " successfully allocated.");
        }else{
            System.out.println("Allocation failed: Invalid ID, patient is not an Inpatient, or Bed is already occupied.");
        }
    }
    private static void releaseBed(){
        
        System.out.print("Enter Bed Number to release (e.g., B01): ");
        String bed = scan.nextLine();
        
        if(ward.releaseBed(bed)){
            System.out.println("Bed " + bed + " is now released.");
        }else{
            System.out.println("Bed releasing failed.");
        }
    }
    private static void printReport(){
        
        System.out.println("===========REPORT=============");
        System.out.println("Total patients"+ ward.getPatients().size());
        System.out.println("Available beds"+ ward.getAvailableBeds());
        System.out.println("Occupied beds"+ ward.getOccupiedBeds());
        System.out.println("Total occupied beds"+ ward.getOccupiedBeds());
        System.out.println("Ward occupancy percentage"+ String.format("%.2f", ward.calculateOccupancyPercentage()));
    }
    private static void sortPatientsMenu(){
    }
    
}
