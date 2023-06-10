/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.s.student2.utility;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author alfredoparreira
 */
public class Validation {
    
    
    public static String checkString(String value)
    {
       if(value == null || value.isBlank())
        {
            throw new NullPointerException("First Name can't be null.");
        }
       
       return value;
    }
    
    public static LocalDate checkDate(LocalDate date)
    {
        if(date.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Your date of birth must be before than today");
        }   
        
        return Objects.requireNonNull(date); 
    }
}
