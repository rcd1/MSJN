package testFiles; //was originally package msjn during testing, but I don't like having errors

/*
 * Stacey's test
 * reusing my Designator test code
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

class ApplicationIDTest {


public static enum ApplicationIDType{
   UNDECLARED,
   SCIENCE,
   MATH,
   DIGITALDESIGN,
   ROBOTICS,
   SPEECH;

}

    @BeforeClass
    public void oneTimeSetup() {

    }

    @AfterClass
    public void oneTimeTearDown() {

    }

    @BeforeEach
    public void setup() {
        //runs before each test
    }

    @AfterEach
    public void tearDown(){
        //runs after each test 
    }

    // private final String ApplicationIDType;

    // private ApplicationIDType(String s) {
    //     designatorType = s;
    // }

    // public boolean equalsName(String otherName ){
    //     return (otherName == null) ? false:designatorType.equals(otherName);
    // }

    // public String toString(){
    //     return designatorType;
    // }

    @Test
        public void testAdd(){
            assertEquals(ApplicationIDType.MATH, ApplicationIDType.MATH);
        }
}


/**
 * Resources:
 * How to test ENUMs using JUNIT by Stack Overflow
 * Professor Plante's Calculator Example
 */

 //Tests was successful
 //was moved from MSJN to oldfiles

