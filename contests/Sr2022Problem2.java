import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Sr2022Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // X
        HashMap<String, ArrayList<String>> mustBePaired = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name1 = scanner.next();
            String name2 = scanner.next();
            addToListIfPresent(mustBePaired, name2, name1);
            addToListIfPresent(mustBePaired, name1, name2);
        }

        int m = scanner.nextInt(); // Y
        HashMap<String, ArrayList<String>> mustNotBePaired = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String name1 = scanner.next();
            String name2 = scanner.next();
            addToListIfPresent(mustNotBePaired, name2, name1);
            addToListIfPresent(mustNotBePaired, name1, name2);
        }

        int amountOfGroups = scanner.nextInt();
        String[][] groups = new String[amountOfGroups][3];
        int rulesBroken = 0;
        for (int i = 0; i < amountOfGroups; i++) {
            groups[i][0] = scanner.next();
            groups[i][1] = scanner.next();
            groups[i][2] = scanner.next();
            rulesBroken += getAmtBrokenRules(mustBePaired, mustNotBePaired, groups[i]);
        }
        scanner.close();
        System.out.println(rulesBroken/2);
    }

    private static void addToListIfPresent(HashMap<String, ArrayList<String>> mustBePaired, String name1, String name2) {
        if (!mustBePaired.containsKey(name2)) {
            mustBePaired.put(name2, new ArrayList<>(Arrays.asList(name1)));
        } else {
            ArrayList<String> newlist = mustBePaired.get(name2);
            newlist.add(name1);
            mustBePaired.put(name2, newlist);
        }
    }

    private static int getAmtBrokenRules(HashMap<String, ArrayList<String>> mustBePaired, HashMap<String, ArrayList<String>> mustNotBePaired, String[] group) {
        int total = 0;

        String person1 = group[0];
        ArrayList<String> person1Pairs = mustBePaired.get(person1);
        ArrayList<String> person1NotPairs = mustNotBePaired.get(person1);

        String person2 = group[1];
        ArrayList<String> person2Pairs = mustBePaired.get(person2);
        ArrayList<String> person2NotPairs = mustNotBePaired.get(person2);

        String person3 = group[2];
        ArrayList<String> person3Pairs = mustBePaired.get(person3);
        ArrayList<String> person3NotPairs = mustNotBePaired.get(person3);

        if (person1Pairs != null) {
            for (String person1Pair : person1Pairs) {
                if (person1Pair != null && !(person1Pair.equals(person2) || person1Pair.equals(person3))) {
                    //System.out.println("Adding one to total because " + person1 + " is paired with " + person1Pair + " and not " + person2 + " or " + person3);
                    total++;
                }
            }
        }
        if (person2Pairs != null) {
            for (String person2Pair : person2Pairs) {
                if (person2Pair != null && !(person2Pair.equals(person1) || person2Pair.equals(person3))) {
                    //System.out.println("Adding one to total because " + person2 + " is paired with " + person2Pair + " and not " + person1 + " or " + person3);
                    total++;
                }
            }
        }
        if (person3Pairs != null) {
            for (String person3Pair : person3Pairs) {
                if (person3Pair != null && !(person3Pair.equals(person2) || person3Pair.equals(person1))) {
                    //System.out.println("Adding one to total because " + person3 + " is paired with " + person3Pair + " and not " + person1 + " or " + person2);
                    total++;
                }
            }
        }

        if (person1NotPairs != null) {
            for (String person1NotPair : person1NotPairs) {
                if (person1NotPair != null && (person1NotPair.equals(person2) || person1NotPair.equals(person3))) {
                    total++;
                }
            }
        }
        if (person2NotPairs != null) {
            for (String person2NotPair : person2NotPairs) {
                if (person2NotPair != null && (person2NotPair.equals(person1) || person2NotPair.equals(person3))) {
                    total++;
                }
            }
        }
        if (person3NotPairs != null) {
            for (String person3NotPair : person3NotPairs) {
                if (person3NotPair != null && (person3NotPair.equals(person2) || person3NotPair.equals(person1))) {
                    total++;
                }
            }
        }


        return total;
    }

}
