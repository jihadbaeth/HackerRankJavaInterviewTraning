import java.util.*;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();

        fillMap(magazineMap, magazine);
        fillMap(noteMap, note);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");

    }

    public void fillMap(Map<String, Integer> map, String value) {
        if (value == null) return;

        String[] words = value.split("\\s+");

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                Integer current = map.get(word);
                if (current == null) current = 0;
                map.put(word, current + 1);
            }
        }
    }

    public boolean solve() {
        for (String key : noteMap.keySet()) {
            // If magazine doesn't have a word that's on a note, then return false right the way
            if (!magazineMap.containsKey(key)) return false;

            // Now make sure there are enough words on magazine for a given word
            Integer magazineCount = magazineMap.get(key);
            Integer noteCount = noteMap.get(key);

            if (magazineCount < noteCount) return false;
        }

        return true;
    }
}