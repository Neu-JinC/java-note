package job.written.examination;

import com.google.common.collect.HashBasedTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class PrintSequence {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Hashtable hashtable = new Hashtable();
        HashSet hashSet = new HashSet<>();
        B b = new B();
    }
}

class A {
    {
        System.out.println("I am A class");
    }
    static {
        System.out.println("static A class");
    }

    public A () {
        System.out.println("Hello A class");
    }
}

class B extends A {
    {
        System.out.println("I am B class");
    }
    static {
        System.out.println("static B class");
    }

    public B () {
        System.out.println("Hello B class");
    }
}
