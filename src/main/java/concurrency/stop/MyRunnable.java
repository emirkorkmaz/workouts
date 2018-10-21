package concurrency.stop;

public class MyRunnable implements Runnable {

    private boolean stopped = false;

    public synchronized void stopThread() {
        this.stopped = true;
    }

    public synchronized boolean shouldThreadKeepRunning() {
        return this.stopped == false;
    }

    @Override
    public void run() {
        while (shouldThreadKeepRunning()) {
            System.out.println("Running");

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
