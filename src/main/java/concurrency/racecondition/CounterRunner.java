package concurrency.racecondition;

public class CounterRunner {

    public static void main(String[] args) {
        Counter counter = new Counter(80);

        DoIncrease doIncrease = new DoIncrease(counter);
        DoDecrease doDecrease = new DoDecrease(counter);

        Thread incThr = new Thread(doIncrease, "Increase Thread");
        Thread decThr = new Thread(doDecrease, "Decrease Thread");

        incThr.start();
        decThr.start();
    }
}
