package concurrency.basics;

public class Basics {

    public static void main(String[] args) {
        ThreadX threadXF = new ThreadX("ThreadX 1", 10);
        ThreadX threadXS = new ThreadX("ThreadX 2", 10);
        ThreadX threadXT = new ThreadX("ThreadX 3", 10);

        Thread threadF = new Thread(threadXF, "Thread F");
        Thread threadS = new Thread(threadXS, "Thread S");
        Thread threadT = new Thread(threadXT, "Thread T");

        threadF.setPriority(Thread.MIN_PRIORITY);
        threadT.setPriority(Thread.MAX_PRIORITY);
        threadS.setPriority(Thread.MIN_PRIORITY);

        threadF.start();
        threadS.start();
        threadT.start();
    }
}

class ThreadX implements Runnable {
    int count;
    String name;

    ThreadX(String name, int count) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < count; i++) {
            System.out.println(name + " : " + i);
        }
    }
}
