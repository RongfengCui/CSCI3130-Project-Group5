package ca.dal.csci3130.coursesmanagementsystem;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class unitTestforValidatePassword {
    private MainActivity valid = new MainActivity();
    @Test

    public void test1(){
        assertFalse(valid.validate("passwor3434343d"));
    }
    @Test
    public void test2(){
        assertFalse(valid.validate("qwertewewewewewe"));
    }
    @Test
    public void test3(){
        assertFalse(valid.validate("password"));
    }
    @Test
    public void test4(){
        assertFalse(valid.validate("qwe23w"));
    }
    @Test
    public void test5(){
        assertTrue(valid.validate("Qfef233354535"));
    }
    @Test
    public void test6(){
        assertTrue(valid.validate("Qw333erirej1234jte1"));
    }
}
