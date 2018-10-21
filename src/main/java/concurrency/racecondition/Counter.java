package concurrency.racecondition;

public class Counter {

    private int count;

    public Counter(int value) {
        this.count = value;
    }

    public void increase() {
        this.count++;
    }

    public void decrease() {
        this.count--;
    }

    public int getCount() {
        return count;
    }
}
