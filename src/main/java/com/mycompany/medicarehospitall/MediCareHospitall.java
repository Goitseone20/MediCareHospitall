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
}
            

