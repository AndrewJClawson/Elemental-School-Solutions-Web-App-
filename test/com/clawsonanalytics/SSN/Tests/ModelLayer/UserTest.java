/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.Tests.ModelLayer;

import com.clawsonanalytics.SSN.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.SSN.ModelLayer.User;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrewclawson
 */
public class UserTest {
    private static User SUT;
    private static TestEnvironment environment;
    
    public UserTest() {
        environment = new TestEnvironment();
        environment.Setup("No Data");
        environment.CreateTestTableForModelByTablename(User.getTablename());
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        SUT = new User();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        environment.DropTestTableForModelByTablename(User.getTablename());
        environment.TearDown();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals("USERS",User.getTablename());
        
    }
    
    @Test
    public void CanSetModelName(){
        Assert.assertEquals(User.getModelName(), User.class.getSimpleName());
    }
    
    
}