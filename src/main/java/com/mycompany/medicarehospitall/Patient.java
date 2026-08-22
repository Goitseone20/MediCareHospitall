/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitall;

/**
 *
 * @author Tshireletso
 */
public class Patient {
    
     private String patientID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private String patientCategory;
    
    public Patient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition,String patientCategory){
        
        this.patientID=patientID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.gender=gender;
        this.medicalCondition=medicalCondition;
        this.patientCategory=patientCategory;
    }
    public String getpatientID(){return patientID; }
    public void setpatientID(String patientID) {this.patientID=patientID;}
    
    public String getfirstName(){return firstName; }
    public void setfirstName(String firstName) {this.firstName=firstName;}
    
    public String getlastName() {return lastName; }
    public void setlastName(String lastName) {this.lastName=lastName; }
    
    public int getage(){return age; }
    public void setage(int age) {this.age=age; }
    
    public String getgender() {return gender; }
    public void setgender(String gender) {this.gender=gender; }
    
    public String getmedicalCondition() {return medicalCondition; }
    public void setmedicamCondition(String medicalCondition) {this.medicalCondition=medicalCondition; }
    
    public String getpatientCategory() {return patientCategory; }
    public void setpatientCategory(String patientCategory) {this.patientCategory=patientCategory; }
    
    public String printDetails(){
        return "Patient ID" + patientID + "first name" + firstName + "last name" + lastName + "age" + age +
                "gender" + gender + "condition" + medicalCondition + "category" + patientCategory;
    
    }
    
}
