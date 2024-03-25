package oldFiles; //was originally package msjn during testing, but I don't like having errors

/*
 * Stacey's test
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

class DesignatorTest {


public static enum DesignatorType{
    ACCT,
    CHEM,
    PEDU,
    IBUS,
    RETL,
    NURS,
    CSCE;

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


    // private final String designatorType;

    // private designatorType(String s) {
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
            assertEquals(DesignatorType.ACCT, DesignatorType.ACCT);
        }
}


/**
 * Resources:
 * How to test ENUMS using JUNIT by Stack Overflow
 */

 //Test (testAdd()) was successful
 //was moved from MSJN to oldfiles