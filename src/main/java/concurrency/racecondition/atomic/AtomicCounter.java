package concurrency.racecondition.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger counter;

    public AtomicCounter(AtomicInteger value) {
        this.counter = value;
    }

    public void increase() {
        this.counter.getAndIncrement();
    }

    public void decrease() {
        this.counter.getAndDecrement();
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}
