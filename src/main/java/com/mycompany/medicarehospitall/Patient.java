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
  
  public Patient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition, String patientCategory){
  
      this.patientID=patientID;
      this.firstName=firstName;
      this.lastName=lastName;
      this.age=age;
      this.gender=gender;
      this.medicalCondition=medicalCondition;
      this.patientCategory=patientCategory;
  }
}