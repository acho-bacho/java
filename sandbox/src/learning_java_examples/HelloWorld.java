package learning_java_examples;

interface ITest {
    public abstract void testMe(); //abstract is implicitly inferred

    public default void defInterfaceMeth() {
        System.out.println("ITest interface default method");
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null ? true : "".equals(str) ? true : false;
    }
}

interface ITestSub extends ITest {
    public abstract void testMe(); //abstract is implicitly inferred

    public default void defInterfaceMeth() {
        System.out.println("ITestSub interface default method");
    }

    static boolean isNull(String str) {
        System.out.println("ITestSub Interface Null Check");
        return str == null ? true : "".equals(str) ? true : false;
    }
}

class ImplementsTwoInterfaces implements ITest, ITestSub {
    public void testMe(){}
}

abstract class AbstractParent implements ITest {
    public abstract void abstractMethod();

    public void regular() {
    }
}

class Parent {
    private static final int MAXVAL_STATIC;
    private final int MAXVAL;
    int a;
    int parentA;

    static {
        System.out.println("PARENT static initializer block");
        MAXVAL_STATIC = 99; // can be done only here
    }

    {
        MAXVAL = 88; //it's ok
        System.out.println("PARENT initializer block");
    }

    public Parent() {
        //MAXVAL = 88; //it's ok
        System.out.println("PARENT ctor");
    }

    public void parentMethod() {
        System.out.println("in Parent");
    }

    public static void staticMethod() {
        System.out.println("static in Parent");
    }
}

abstract class AbstrMiddle extends Parent {
    @Override
    public abstract void parentMethod();
}

class EndLevel extends AbstrMiddle {
    public void parentMethod() {
        System.out.println("in EndLevel");
    }
}

public class HelloWorld extends Parent {
    private static final int MAXVAL_STATIC;
    private final int MAXVAL;
    int a;
    Nested nestedInstance = new Nested();
    public NestedStatic nestedStaticInstance = new NestedStatic();

    int shadowed = 1;

    public class Nested {
        int shadowed = 2;

        public void print() {
            //has access to Outer
            hwRegularMethod();
            hwStaticMethod();
            int a = MAXVAL;
            int b = MAXVAL_STATIC;

            System.out.println("i am nested");
            System.out.println("shadowed outer" + HelloWorld.this.shadowed);
            System.out.println("shadowed inner" + this.shadowed);
        }
    }

    public class NestedChild extends Nested {
        public void print() {
            System.out.println("i am nested CHILD");
        }
    }

    public static class NestedStatic {
        public static void staticPrint() {
            System.out.println("i am nested STATIC");
        }

        public void nonStaticPrint() {
            System.out.println("i am nested STATIC");
        }
    }

    static {
        System.out.println("static initializer block");
        MAXVAL_STATIC = 99; // can be done only here
    }

    {
        this.a = 1;
        super.a = 2;
        this.parentA = 3;
        MAXVAL = 88; //it's ok
        System.out.println("initializer block");
    }

    public HelloWorld() {
        //MAXVAL = 88; //it's ok
        System.out.println("ctor");
        Nested a;
        NestedStatic b;
    }

    public static void hwStaticMethod() {
        System.out.println("static in CHILD");
        Nested a;
        NestedStatic b;
    }

    public void hwRegularMethod() {
        System.out.println("regular in CHILD");
        Nested a;
        NestedStatic b;
    }

    public static void main(String[] args) {

        HelloWorld hwInst = new HelloWorld();
        Parent b = new HelloWorld();

        hwInst.hwStaticMethod();
        b.staticMethod();
        HelloWorld.hwStaticMethod();
        hwInst.nestedInstance.print();
        hwInst.nestedStaticInstance.nonStaticPrint();

        HelloWorld.NestedStatic.staticPrint();

        //instantiate inner class
        HelloWorld.Nested nestedInst = hwInst.new Nested();



        ITest test = new ImplementsTwoInterfaces();
        test.defInterfaceMeth();

        A instC = new C();
        A instB = new B();

        instC.print();
        instB.print();

        instB = (B) instC; //OK, slicing
        //instC = (C) instB; //ClassCastException at runtime
        instB.print();
    }
}
interface I {}
class A {
    void print() {
        System.out.println("A");
    }
}
class B extends A {
    void print() {
        System.out.println("B");
    }
}
class C extends B {

    void print() {
        System.out.println("C prints");
    }
}
class D extends A implements I  {}