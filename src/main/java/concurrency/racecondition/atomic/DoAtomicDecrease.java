package concurrency.racecondition.atomic;

public class DoAtomicDecrease implements Runnable {

    private AtomicCounter atomicCounter;

    public DoAtomicDecrease(AtomicCounter aVar) {
        this.atomicCounter = aVar;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Current Value: " + atomicCounter.getCounter().get());
            atomicCounter.decrease();
            System.out.println(Thread.currentThread().getName() + " - New Value: " + atomicCounter.getCounter().get());
        }
    }
}
