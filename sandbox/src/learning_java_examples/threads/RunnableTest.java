package learning_java_examples.threads;

import java.util.concurrent.TimeUnit;

public class RunnableTest {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
