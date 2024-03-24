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
 * Stack Overflow
 */

 //Test (testAdd()) was successful
 //was moved from MSJN