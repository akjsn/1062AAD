package com.paperscissorsstonegame;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

public class wintest{ //rantest == random test
    private MainActivity m;

    @Before public void setUp(){
        m = new MainActivity();
    }

    @After
    public void tearDown(){
        m = null;
    }

    @Test
    public void dotest(){ //win=100 lose=0 draw=50
        assertEquals(100,m.verdict(1,3));
        assertEquals(0,m.verdict(3,1));
        assertEquals(50,m.verdict(1,1));
        assertEquals(100,m.verdict(2,1));
        assertEquals(0,m.verdict(1,2));
        assertEquals(50,m.verdict(2,2));
        assertEquals(100,m.verdict(3,2));
        assertEquals(0,m.verdict(2,3));
        assertEquals(50,m.verdict(3,3));
    }

}