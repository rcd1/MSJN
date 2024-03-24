package oldFiles; //was originally package msjn during testing, but I don't like having errors

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

class KeywordTest {


public static enum KeywordType{
    Honors,
    VSR,
    GSS,
    AP1,
    CRW,
    AP2,
    SPCHC,
    CSCME,
    SCI,
    AP5;

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
            assertEquals(KeywordType.CSCME, KeywordType.CSCME);
        }
}


/**
 * Resources:
 * How to test ENUMs using JUNIT by Stack Overflow
 * Professor Plante's Calculator Example
 */

 //Tests was successful
 //was moved from MSJN to oldfiles
