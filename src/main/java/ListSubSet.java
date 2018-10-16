import java.util.*;

public class ListSubSet {

    static <T> List<List<T>> getSubsets(List<T> values, int teamSize) {
        T[] elements = (T[]) values.toArray();
        List<List<T>> powerSet = new ArrayList<>();

        final int elementArrayLength = 1 << elements.length;
        for (int binarySet = 0; binarySet < elementArrayLength; binarySet++) {
            List<T> subset = new ArrayList<>();
            for (int bit = 0; bit < elements.length; bit++) {
                int mask = 1 << bit;
                if ((binarySet & mask) != 0) {
                    subset.add(elements[bit]);
                }
            }

            if (subset.size() == teamSize)
                powerSet.add(subset);
        }

        return powerSet;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 10, 4, 8, 3, 6, 5, 10, 4, 8, 3, 6};
        List<Integer> values = Arrays.asList(arr);
        int teamSize = 4;

        List<List<Integer>> result = getSubsets(values, teamSize);

        OptionalInt min;
        OptionalInt max;

        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> l : result) {
            min = l.stream().mapToInt(v -> v).min();
            max = l.stream().mapToInt(v -> v).max();
            int diff = max.getAsInt() - min.getAsInt();
            resultList.add(diff);
        }

        resultList.sort(Comparator.naturalOrder());

        int finalResult = -1;
        for(int i = 0; i < teamSize; i++) {
            finalResult += resultList.get(i);
        }

        System.out.println(finalResult);
    }
}
