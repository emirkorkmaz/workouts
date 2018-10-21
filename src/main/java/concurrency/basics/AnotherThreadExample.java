package concurrency.basics;

public class AnotherThreadExample {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        for (int i = 1; i < 11; i++) {
            new Thread("Thread - " + i) {
                @Override
                public void run() {
                    System.out.println(getName() + " is running");
                }
            }.start();
        }
    }
}
