package concurrency.racecondition.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterRunner {

    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter(new AtomicInteger(100));

        DoAtomicIncrease doAtomicIncrease = new DoAtomicIncrease(atomicCounter);
        DoAtomicDecrease doAtomicDecrease = new DoAtomicDecrease(atomicCounter);

        Thread atomicIncThr = new Thread(doAtomicIncrease, "Atomic Increase");
        Thread atomicDecThr = new Thread(doAtomicDecrease, "Atomic Decrease");

        atomicIncThr.start();
        atomicDecThr.start();
    }
}
