/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Test;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
/**
 *
 * @author andrewclawson
 */
public class ValidUser  extends User {
    public ValidUser(){
        this.setFirstname("validUserFIrst");
        this.setLastname("validUserLast");
        this.setEmail("validUserEmail");
        this.setPassword("validUserPassword");
        
    }
}
