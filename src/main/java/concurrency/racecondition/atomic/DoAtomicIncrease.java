package concurrency.racecondition.atomic;

public class DoAtomicIncrease implements Runnable {

    private AtomicCounter atomicCounter;

    public DoAtomicIncrease(AtomicCounter aVar) {
        this.atomicCounter = aVar;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Current Value: " + atomicCounter.getCounter().get());
            atomicCounter.increase();
            System.out.println(Thread.currentThread().getName() + " - New Value: " + atomicCounter.getCounter().get());
        }
    }
}
