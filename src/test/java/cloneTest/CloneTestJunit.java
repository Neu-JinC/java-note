package cloneTest;

import job.written.examination.CloneTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CloneTestJunit {

    @Test
    public void cloneTest() {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setStr("test");
        cloneTest.setNums(123);
        cloneTest.setDate(new Date());

        try {
            CloneTest cloneTest1 = cloneTest.clone();
            boolean test = cloneTest.equals(cloneTest1);

            System.out.println("test : " + test);
            Assert.assertTrue(test);
        } catch (CloneNotSupportedException c) {
            c.printStackTrace();
        }
    }

    @Test
    public void cloneTest2() {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setStr("test");
        cloneTest.setNums(123);
        cloneTest.setDate(new Date());

        CloneTest cloneTest1 = new CloneTest();
        cloneTest.setStr("test");
        cloneTest.setNums(123);
        cloneTest.setDate(new Date());
        boolean test = cloneTest.equals(cloneTest1);

        Assert.assertFalse(test);

    }

    @Test
    public void cloneTest3() {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setStr("test");
        cloneTest.setNums(123);
        cloneTest.setDate(new Date());

        CloneTest cloneTest1 = null;
        boolean test = cloneTest.equals(cloneTest1);

        Assert.assertFalse(test);
    }

    @Test
    public void cloneTest4() {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setStr("test");
        cloneTest.setNums(123);
        cloneTest.setDate(new Date());

        Date date = new Date();
        boolean test = cloneTest.equals(date);

        Assert.assertFalse(test);

        System.out.println("test : " + test);
    }
}
