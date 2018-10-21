package puzzles;

import java.util.*;
import java.util.stream.Collectors;

/*
    https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class CheckMagazine {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        boolean result = true;
        List<String> magazineWords = Arrays.asList(magazine);
        List<String> noteWords = Arrays.asList(note);

        Map<String, Long> mWordCount = magazineWords.stream().
                collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        Map<String, Long> nWordCount = noteWords.stream().
                collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        for (String n : noteWords) {
            long occurance = null != mWordCount.get(n) ? mWordCount.get(n) : 0;

            if(nWordCount.get(n) > occurance) {
                result = false;
                break;
            }
        }

        String resultStr = result ? "Yes" : "No";
        System.out.println(resultStr);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
