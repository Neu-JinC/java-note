package book.jvm.chapter.seven;

/**
 * 子类引用父类的静态字段，不会导致子类的初始化
 *
 * 通过数组定义引用类，不会触发此类的初始化
 *
 * 常量在编译阶段会存入常量池中，本质上并没有直接引用到定义常量的类，因此不会触发订单常量的类的初始化
 */
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SuperClass.value);
//        SuperClass[] superClasses = new SuperClass[10];
        System.out.println(SuperClass.HELLO_WORLD);
    }
}

class SuperClass {
    static {
        System.out.println("Super class init");
    }

    public static int value = 123;

    public static final String HELLO_WORLD = "Hello World!";
}

class SubClass extends SuperClass {
    static {
        System.out.println("Sub class init");
    }
}