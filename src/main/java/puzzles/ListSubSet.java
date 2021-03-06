package puzzles;

import java.util.*;

public class ListSubSet {

    /**
     * not quiet correct approach if we do not want repetitions
     * since List allows duplicates
     */
    static <T> List<List<T>> getSubList(List<T> values, int teamSize) {
        T[] valuesArray = (T[]) values.toArray();
        List<List<T>> allSubsets = new ArrayList<>();

        //total number of subsets of given list equals to 2^n while n is number of elements in list
        final int valuesArrayLength = 1 << valuesArray.length;
        for (int setIndex = 0; setIndex < valuesArrayLength; setIndex++) {
            List<T> subset = new ArrayList<>();
            for (int bit = 0; bit < valuesArray.length; bit++) {
                int mask = 1 << bit;
                if ((setIndex & mask) != 0) {
                    subset.add(valuesArray[bit]);
                }
            }

            if (subset.size() == teamSize)
                allSubsets.add(subset);
        }

        return allSubsets;
    }

    /**
     * better approach if we do not want repetitions
     * since Set does not allow duplicates
     */
    static <T> Set<Set<T>> getSubsets(List<T> values, int teamSize) {
        T[] valuesArray = (T[]) values.toArray();
        Set<Set<T>> allSubsets = new HashSet<>();

        //total number of subsets of given list equals to 2^n while n is number of elements in list
        final int valuesArrayLength = 1 << valuesArray.length;
        for (int setIndex = 0; setIndex < valuesArrayLength; setIndex++) {
            Set<T> subset = new HashSet<>();
            for (int bit = 0; bit < valuesArray.length; bit++) {
                int mask = 1 << bit;
                if ((setIndex & mask) != 0) {
                    subset.add(valuesArray[bit]);
                }
            }

            if (subset.size() == teamSize)
                allSubsets.add(subset);
        }

        return allSubsets;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 10, 4, 8, 3, 6, 5, 10, 4, 8, 3, 6};
        List<Integer> values = Arrays.asList(arr);
        int teamSize = 4;
        int numberOfTeams = arr.length / teamSize;

        Set<Set<Integer>> resultSet = getSubsets(values, teamSize);

        OptionalInt min;
        OptionalInt max;

        List<Integer> resultList = new ArrayList<>();
        for (Set<Integer> l : resultSet) {
            min = l.stream().mapToInt(v -> v).min();
            max = l.stream().mapToInt(v -> v).max();
            int diff = max.getAsInt() - min.getAsInt();
            resultList.add(diff);
        }

        resultList.sort(Comparator.naturalOrder());

        int finalResult = 0;
        for(int i = 0; i < numberOfTeams; i++) {
            finalResult += resultList.get(i);
        }

        System.out.println(finalResult);
    }
}
