package oldFiles; //was originally package msjn during testing, but I don't like having errors

/*
 * Stacey's test
 * reusing my keywordTest
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

class GradeTest {


public static enum GradeType{
   A, 
   B,
   C,
   D,
   F,
   WF,
   W;

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

}


    // private final String GradeType;

    // private GradeType(String s) {
    //     GradeType = s;
    // }

    // public boolean equalsName(String otherName ){
    //     return (otherName == null) ? false:GradeType.equals(otherName);
    // }

    // public String toString(){
    //     return GradeType;
    // }

    @Test
        public void testAdd(){
            assertEquals(GradeType.B, GradeType.B);
        }
}


/**
 * Resources:
 * How to test ENUMS using JUNIT by Stack Overflow
 */

 //Test was successful
 //was moved from MSJN to oldfiles
