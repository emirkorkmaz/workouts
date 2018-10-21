package concurrency.racecondition;

public class DoDecrease implements Runnable {

    private Counter counter;

    public DoDecrease(Counter cVar) {
        this.counter = cVar;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            /**
             * Below part is critical section of thread since it calls @{@link Counter#decrease()} which uses
             * a shared object and so shared variable.
             * Hence, it is necessary to make it synchronized to avoid race conditions on this critical section
             */
            synchronized (counter) {
                System.out.println(Thread.currentThread().getName() + " - Current Value: " + counter.getCount());
                counter.decrease();
                System.out.println(Thread.currentThread().getName() + " - New Value: " + counter.getCount());
            }
        }
    }
}
