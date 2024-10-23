import java.util.*;

public class Apriori {
    public static void main(String[] args) {
        List<Set<String>> transactions = Arrays.asList(
            new HashSet<>(Arrays.asList("Milk", "Bread", "Butter")),
            new HashSet<>(Arrays.asList("Bread", "Diaper", "Beer", "Eggs")),
            new HashSet<>(Arrays.asList("Milk", "Bread", "Diaper", "Beer")),
            new HashSet<>(Arrays.asList("Milk", "Bread")),
            new HashSet<>(Arrays.asList("Bread", "Butter", "Diaper"))
        );

        double minSupport = 0.4;
        Set<Set<String>> freqItems = apriori(transactions, minSupport);
        
        System.out.println("Frequent Itemsets:");
        freqItems.forEach(System.out::println);
    }

    public static Set<Set<String>> apriori(List<Set<String>> trans, double minSupport) {
        Map<Set<String>, Integer> itemCounts = new HashMap<>();
        int totalTrans = trans.size();
        Set<Set<String>> freqItems = new HashSet<>();

        trans.forEach(t -> t.forEach(item -> 
            itemCounts.put(Collections.singleton(item), 
                itemCounts.getOrDefault(Collections.singleton(item), 0) + 1)
        ));

        itemCounts.forEach((itemSet, count) -> {
            if (count / (double) totalTrans >= minSupport) freqItems.add(itemSet);
        });

        Set<Set<String>> curItems = new HashSet<>(freqItems);
        int size = 2;
        while (!curItems.isEmpty()) {
            Set<Set<String>> candidates = getCandidates(curItems, size);
            itemCounts.clear();
            trans.forEach(t -> candidates.forEach(candidate -> {
                if (t.containsAll(candidate)) 
                    itemCounts.put(candidate, itemCounts.getOrDefault(candidate, 0) + 1);
            }));
            curItems.clear();
            itemCounts.forEach((itemSet, count) -> {
                if (count / (double) totalTrans >= minSupport) curItems.add(itemSet);
            });
            freqItems.addAll(curItems);
            size++;
        }
        return freqItems;
    }

    private static Set<Set<String>> getCandidates(Set<Set<String>> itemsets, int size) {
        Set<Set<String>> candidates = new HashSet<>();
        List<Set<String>> list = new ArrayList<>(itemsets);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Set<String> candidate = new HashSet<>(list.get(i));
                candidate.addAll(list.get(j));
                if (candidate.size() == size) candidates.add(candidate);
            }
        }
        return candidates;
    }
}
