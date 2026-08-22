/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitall;

/**
 *
 * @author Tshireletso
 */
public class InPatient extends Patient{
    
   private String wardNumber;
   private String bedNumber;

    public InPatient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition, String patientCategory) {
        super(patientID, firstName, lastName, age, gender, medicalCondition, patientCategory);
        
        this.wardNumber=wardNumber;
        this.bedNumber=bedNumber;
    }
    public String getwardNumber(){return wardNumber; }
    public void setwardNumber(String bedNumber){this.wardNumber=wardNumber; }
    
    public String getbedNumber(){return bedNumber; }
    public void setbedNumber(String bedNumber){this.bedNumber=bedNumber; }
    
    @Override
    public String printDetails(){
        return super.printDetails()+"ward"+wardNumber +"bed"+bedNumber;
    }
}
