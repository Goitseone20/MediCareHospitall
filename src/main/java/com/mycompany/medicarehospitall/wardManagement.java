/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitall;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Tshireletso
 */
public class wardManagement {
    
    private String[][] beds=new String[4][5];
    private final int ROWS=4;
    private final int COLS=5;
    private List<Patient>patients;
    private final String wardNumber="W01";
    
    public wardManagement(){
        
        patients = new ArrayList<>();
        beds = new String[4][5];
    }
    public boolean registerPatient(Patient patient) {
        
        if (findPatientbyId(patient.getPatientID())  !=null) {
            return false; // Duplicate ID prevented
        }
        patients.add(patient);
        return true;
    }
    public Patient findPatientbyId(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientID().equalsIgnoreCase(patientId)) {
                return p;
            }
        }
        return null;
    }
    public boolean updatePatientDetails(String patientId, String firstName, String lastName, int age, String gender, String condition) {
        Patient p = findPatientbyId(patientId);
        if (p == null) return false;

       p.setfirstName(firstName);
       p.setlastName(lastName);
       p.setgender(gender);
       p.setage(age);
       p.setmedicalCondition(condition);
       
       return true;
    }
    public boolean deletePatient(String patientID){
        
        Patient p= findPatientbyId(patientID);
        if(p==null)return false;
         
        
            if (p.getPatientID() != null) {
                releaseBed(p.getPatientID());
            }
            return patients.remove(p);
        }
    public boolean allocateBed(String patientID, String bedNumber){
        Patient p= findPatientbyId(patientID);
        
        if (isBedOccupied(bedNumber)) {
            return false;
        }

        int[] pos = getBedCoordinates(bedNumber);
        if (pos == null) return false;

        InPatient inpatient = (InPatient) p;
        if (inpatient.getbedNumber() != null) {
            releaseBed(inpatient.getbedNumber()); // Release previous allocation if reassigning
        }

        beds[pos[0]][pos[1]] = "OCCUPIED";
        inpatient.setwardNumber(wardNumber);
        inpatient.setbedNumber(bedNumber);
        return true;
    }
    public boolean releaseBed(String bedNumber) {
        int[] pos = getBedCoordinates(bedNumber);
        if (pos == null && !isBedOccupied(bedNumber)) return false;

        // Search coordinate if it's marked as occupied
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int expectedNum = i * COLS + j + 1;
                String expectedCode = String.format("B%02d", expectedNum);
                if (expectedCode.equalsIgnoreCase(bedNumber)) {
                    beds[i][j] = expectedCode;
                    break;
                }
            }
        }

        for (Patient p : patients) {
            if (p instanceof InPatient) {
                InPatient inp = (InPatient) p;
                if (bedNumber.equalsIgnoreCase(inp.getbedNumber())) {
                    inp.setbedNumber(null);
                    inp.setwardNumber(null);
                }
            }
        }
        return true;
    }

    public boolean isBedOccupied(String bedNumber) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int expectedNum = i * COLS + j + 1;
                String expectedCode = String.format("B%02d", expectedNum);
                if (expectedCode.equalsIgnoreCase(bedNumber)) {
                    return beds[i][j].equals("OCCUPIED");
                }
            }
        }
        return false;
    }

    private int[] getBedCoordinates(String bedNumber) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int expectedNum = i * COLS + j + 1;
                String expectedCode = String.format("B%02d", expectedNum);
                if (expectedCode.equalsIgnoreCase(bedNumber)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public void displayWardLayout() {
        System.out.println("\n--- Ward Bed Layout (4x5) ---");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(String.format("%-10s", beds[i][j]));
            }
            System.out.println();
        }
    }

    public List<String> getAvailableBeds() {
        List<String> available = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!beds[i][j].equals("OCCUPIED")) {
                    available.add(beds[i][j]);
                }
            }
        }
        return available;
    }

    public List<String> getOccupiedBeds() {
        List<String> occupied = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (beds[i][j].equals("OCCUPIED")) {
                    int expectedNum = i * COLS + j + 1;
                    occupied.add(String.format("B%02d", expectedNum));
                }
            }
        }
        return occupied;
    }

    public List<Patient> getPatients() { return patients; }
     
    public void sortPatientbySurname(){
     patients.sort(Comparator.comparing(Patient::getlastName, String.CASE_INSENSITIVE_ORDER));
    }
   public void sortPatientbyID(){
      patients.sort(Comparator.comparing(Patient::getlastName, String.CASE_INSENSITIVE_ORDER));
     
   }
   public double calculateOccupancyPercentage() {
        int totalBeds = ROWS * COLS;
        int occupied = getOccupiedBeds().size();
        return ((double) occupied / totalBeds) * 100.0;
    }
    
    
}
