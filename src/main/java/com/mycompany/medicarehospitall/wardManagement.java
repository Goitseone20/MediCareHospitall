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
    
    private String[][] bedLayout=new String[4][5];
    private final int ROWS=4;
    private final int COLS=5;
    private List<Patient>patients;
    private final String wardNumber="W01";
    
    public wardManagement(){
        
        patients = new ArrayList<>();
        bedLayout = new String[4][5];
    }
    
    
}
