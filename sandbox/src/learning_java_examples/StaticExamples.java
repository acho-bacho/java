package learning_java_examples;

public class StaticExamples {

    public static void main(String[] args) {
        Koala k = new Koala();
        System.out.println(k.count); // k is a Koala
        k = null;
        System.out.println(k.count); // k is still a Koala
    }
}

class Koala {
    static public int count = 0;
}
