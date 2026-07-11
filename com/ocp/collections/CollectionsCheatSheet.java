package com.ocp.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Runnable companion to docs/collections-cheatsheet.md.
 * Every section prints its results so you can run this file and see each method in action.
 * Focus: methods that save time in LeetCode-style assessments.
 */
public class CollectionsCheatSheet {

    public static void main(String[] args) {
        arrayListDemo();
        hashMapDemo();
        hashSetDemo();
        stackAndDequeDemo();
        priorityQueueDemo();
        treeMapAndTreeSetDemo();
        stringAndStringBuilderDemo();
        arraysAndCollectionsUtilDemo();
        conversionsDemo();
    }

    // ---------------------------------------------------------------
    // 1. ArrayList
    // ---------------------------------------------------------------
    static void arrayListDemo() {
        System.out.println("=== ArrayList ===");
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 20));

        list.add(40);                        // append -> [10, 20, 30, 20, 40]
        list.add(0, 5);                      // insert at index -> [5, 10, 20, 30, 20, 40]
        list.set(1, 15);                     // replace at index -> [5, 15, 20, 30, 20, 40]
        System.out.println("list = " + list);

        System.out.println("get(2) = " + list.get(2));
        System.out.println("indexOf(20) = " + list.indexOf(20));      // first match
        System.out.println("contains(30) = " + list.contains(30));
        System.out.println("size = " + list.size() + ", isEmpty = " + list.isEmpty());

        // THE classic trap: remove(int index) vs remove(Object element)
        list.remove(0);                        // removes INDEX 0 -> [15, 20, 30, 20, 40]
        list.remove(Integer.valueOf(20));      // removes ELEMENT 20 (first one) -> [15, 30, 20, 40]
        System.out.println("after removes = " + list);

        // Safe removal while iterating: removeIf (Java 8) or Iterator.remove
        list.removeIf(n -> n > 25);            // -> [15, 20]
        System.out.println("after removeIf(>25) = " + list);

        // subList is a VIEW (changes write through); copy it if you need independence
        List<Integer> copy = new ArrayList<>(list.subList(0, list.size()));
        System.out.println("copy = " + copy);
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 2. HashMap
    // ---------------------------------------------------------------
    static void hashMapDemo() {
        System.out.println("=== HashMap ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("apple", 5);                   // put on existing key OVERWRITES
        System.out.println("map = " + map);

        System.out.println("get(\"apple\") = " + map.get("apple"));
        System.out.println("get(\"grape\") = " + map.get("grape"));                    // null, not exception
        System.out.println("getOrDefault(\"grape\", 0) = " + map.getOrDefault("grape", 0));
        System.out.println("containsKey(\"banana\") = " + map.containsKey("banana"));
        System.out.println("containsValue(5) = " + map.containsValue(5));

        map.putIfAbsent("apple", 99);          // no-op: key exists
        map.putIfAbsent("cherry", 7);          // inserted
        map.remove("banana");
        System.out.println("after putIfAbsent/remove = " + map);

        // Frequency counting - the #1 LeetCode map pattern
        String word = "mississippi";
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : word.toCharArray()) {
            freq.merge(c, 1, Integer::sum);    // or: freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println("freq of 'mississippi' = " + freq);

        // Grouping - computeIfAbsent builds the bucket on first use
        Map<Integer, List<String>> byLength = new HashMap<>();
        for (String s : Arrays.asList("cat", "dog", "mouse", "elk")) {
            byLength.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
        }
        System.out.println("grouped by length = " + byLength);

        // The three iteration views
        System.out.println("keySet() = " + map.keySet());
        System.out.println("values() = " + map.values());
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("entry: " + e.getKey() + " -> " + e.getValue());
        }
        map.forEach((k, v) -> System.out.println("forEach: " + k + " -> " + v));
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 3. HashSet
    // ---------------------------------------------------------------
    static void hashSetDemo() {
        System.out.println("=== HashSet ===");
        Set<Integer> set = new HashSet<>();
        System.out.println("add(1) first time  = " + set.add(1));   // true
        System.out.println("add(1) second time = " + set.add(1));   // false - handy for duplicate detection
        set.add(2);
        set.add(3);
        System.out.println("contains(2) = " + set.contains(2));
        set.remove(2);
        System.out.println("set = " + set + ", size = " + set.size());

        // Dedupe a list in one line
        List<Integer> withDups = Arrays.asList(1, 2, 2, 3, 3, 3);
        Set<Integer> unique = new HashSet<>(withDups);
        System.out.println("deduped = " + unique);

        // Set algebra
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        Set<Integer> union = new HashSet<>(a);        union.addAll(b);
        Set<Integer> intersection = new HashSet<>(a); intersection.retainAll(b);
        Set<Integer> difference = new HashSet<>(a);   difference.removeAll(b);
        System.out.println("union = " + union + ", intersection = " + intersection + ", difference = " + difference);
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 4. Stack and ArrayDeque
    // ---------------------------------------------------------------
    static void stackAndDequeDemo() {
        System.out.println("=== Stack / ArrayDeque ===");

        // java.util.Stack works but is legacy (synchronized). Shown for completeness:
        Stack<Integer> legacy = new Stack<>();
        legacy.push(1);
        legacy.push(2);
        System.out.println("Stack pop = " + legacy.pop() + ", peek = " + legacy.peek());

        // Preferred stack: ArrayDeque
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);                          // add to front
        stack.push(2);
        stack.push(3);
        System.out.println("Deque-as-stack peek = " + stack.peek());   // 3 (top)
        System.out.println("Deque-as-stack pop  = " + stack.pop());    // 3 (LIFO)
        System.out.println("remaining = " + stack + ", isEmpty = " + stack.isEmpty());

        // Preferred queue: ArrayDeque (BFS!)
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("first");                   // add to back
        queue.offer("second");
        System.out.println("Queue peek = " + queue.peek());            // "first"
        System.out.println("Queue poll = " + queue.poll());            // "first" (FIFO)
        // poll()/peek() return null when empty; remove()/element() throw. Prefer poll/peek.
        queue.poll();
        System.out.println("poll on empty = " + queue.poll());

        // Double-ended operations (sliding window maximum etc.)
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);                      // -> [1, 2, 3]
        System.out.println("deque = " + deque);
        System.out.println("pollFirst = " + deque.pollFirst() + ", pollLast = " + deque.pollLast());
        // Note: ArrayDeque does NOT allow null elements (that's why poll's null means 'empty').
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 5. PriorityQueue + Comparator
    // ---------------------------------------------------------------
    static void priorityQueueDemo() {
        System.out.println("=== PriorityQueue ===");

        // Default = MIN-heap: poll() returns the smallest
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(3);
        System.out.println("minHeap peek = " + minHeap.peek());        // 1
        System.out.print("minHeap drain: ");
        while (!minHeap.isEmpty()) System.out.print(minHeap.poll() + " "); // 1 3 5
        System.out.println();

        // MAX-heap
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(5, 1, 3));
        System.out.println("maxHeap peek = " + maxHeap.peek());        // 5

        // Custom comparator, e.g. int[] pairs ordered by second element
        Queue<int[]> bySecond = new PriorityQueue<>((p, q) -> Integer.compare(p[1], q[1]));
        bySecond.offer(new int[]{1, 90});
        bySecond.offer(new int[]{2, 45});
        bySecond.offer(new int[]{3, 60});
        System.out.println("smallest by 2nd element = " + Arrays.toString(bySecond.poll())); // [2, 45]
        // Use Integer.compare(a, b), not (a - b): subtraction overflows on large values.
        // Note: iterating a PriorityQueue does NOT visit elements in sorted order - only poll() does.
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 6. TreeMap / TreeSet
    // ---------------------------------------------------------------
    static void treeMapAndTreeSetDemo() {
        System.out.println("=== TreeMap / TreeSet ===");
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(10, "ten");
        tm.put(30, "thirty");
        tm.put(20, "twenty");
        System.out.println("treeMap (sorted by key) = " + tm);
        System.out.println("firstKey = " + tm.firstKey() + ", lastKey = " + tm.lastKey());
        System.out.println("floorKey(25) = " + tm.floorKey(25));       // 20 (<= 25)
        System.out.println("ceilingKey(25) = " + tm.ceilingKey(25));   // 30 (>= 25)
        System.out.println("lowerKey(20) = " + tm.lowerKey(20));       // 10 (strictly <)
        System.out.println("higherKey(20) = " + tm.higherKey(20));     // 30 (strictly >)
        System.out.println("headMap(20) = " + tm.headMap(20) + ", tailMap(20) = " + tm.tailMap(20));

        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(4, 1, 9, 6));
        System.out.println("treeSet = " + ts);
        System.out.println("first = " + ts.first() + ", last = " + ts.last());
        System.out.println("floor(5) = " + ts.floor(5) + ", ceiling(5) = " + ts.ceiling(5));
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 7. String + StringBuilder
    // ---------------------------------------------------------------
    static void stringAndStringBuilderDemo() {
        System.out.println("=== String / StringBuilder ===");
        String s = "leetcode";
        System.out.println("charAt(0) = " + s.charAt(0));
        System.out.println("substring(1, 4) = " + s.substring(1, 4));  // "eet" - end index EXCLUSIVE
        System.out.println("indexOf('e', 2) = " + s.indexOf('e', 2));
        System.out.println("toCharArray -> " + Arrays.toString(s.toCharArray()));
        System.out.println("split: " + Arrays.toString("a,b,c".split(",")));
        System.out.println("split on dot needs escape: " + Arrays.toString("1.2.3".split("\\.")));
        System.out.println("String.join = " + String.join("-", "a", "b", "c"));
        System.out.println("valueOf(42) = " + String.valueOf(42) + ", parseInt(\"42\") = " + Integer.parseInt("42"));

        // char arithmetic - constant-time letter indexing
        char c = 'd';
        System.out.println("'d' - 'a' = " + (c - 'a'));                // 3
        System.out.println("isDigit('7') = " + Character.isDigit('7')
                + ", isLetter('x') = " + Character.isLetter('x')
                + ", toLowerCase('A') = " + Character.toLowerCase('A'));

        // StringBuilder: use it for ANY string built in a loop (String + in a loop is O(n^2))
        StringBuilder sb = new StringBuilder();
        sb.append("race").append("car");
        System.out.println("reverse = " + sb.reverse());               // palindrome check helper
        sb.reverse();                                                  // back to "racecar"
        sb.insert(0, ">> ");
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(0, '*');
        System.out.println("sb = " + sb + ", length = " + sb.length());
        sb.setLength(0);                                               // fast clear
        System.out.println("after setLength(0), empty = " + (sb.length() == 0));
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 8. Arrays + Collections utilities
    // ---------------------------------------------------------------
    static void arraysAndCollectionsUtilDemo() {
        System.out.println("=== Arrays / Collections utilities ===");
        int[] arr = {5, 2, 8, 1, 9};

        Arrays.sort(arr);                                              // in-place, ascending
        System.out.println("sorted = " + Arrays.toString(arr));
        System.out.println("binarySearch(8) = " + Arrays.binarySearch(arr, 8)); // requires sorted input

        int[] slice = Arrays.copyOfRange(arr, 1, 4);                   // end exclusive
        System.out.println("copyOfRange(1,4) = " + Arrays.toString(slice));

        int[] filled = new int[5];
        Arrays.fill(filled, -1);                                       // classic DP/visited init
        System.out.println("filled = " + Arrays.toString(filled));

        // Sorting with a comparator needs OBJECT arrays (Integer[], int[][]), not int[]
        int[][] intervals = {{3, 4}, {1, 2}, {2, 6}};
        Arrays.sort(intervals, (p, q) -> Integer.compare(p[0], q[0]));
        System.out.println("intervals by start = " + Arrays.deepToString(intervals));

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1));
        Collections.sort(list);                                        // or list.sort(null)
        System.out.println("sorted list = " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("desc list = " + list);
        Collections.reverse(list);
        System.out.println("reversed = " + list);
        System.out.println("max = " + Collections.max(list) + ", min = " + Collections.min(list));
        System.out.println("frequency of 2 = " + Collections.frequency(list, 2));
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("after swap(0, last) = " + list);

        // Comparator building (Java 8)
        List<String> words = new ArrayList<>(Arrays.asList("pear", "fig", "apple"));
        words.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("by length then alpha = " + words);
        words.sort(Comparator.comparing(String::length).reversed());
        System.out.println("by length desc = " + words);
        System.out.println();
    }

    // ---------------------------------------------------------------
    // 9. Conversions you always need mid-problem
    // ---------------------------------------------------------------
    static void conversionsDemo() {
        System.out.println("=== Conversions ===");

        // int[] -> List<Integer> (must box; Arrays.asList(int[]) does NOT do this!)
        int[] primitives = {1, 2, 3};
        List<Integer> boxed = new ArrayList<>();
        for (int n : primitives) boxed.add(n);
        // Java 8 stream alternative: Arrays.stream(primitives).boxed().collect(Collectors.toList())
        System.out.println("int[] -> List = " + boxed);

        // List<Integer> -> int[]
        int[] back = new int[boxed.size()];
        for (int i = 0; i < boxed.size(); i++) back[i] = boxed.get(i);
        // Java 8 stream alternative: boxed.stream().mapToInt(Integer::intValue).toArray()
        System.out.println("List -> int[] = " + Arrays.toString(back));

        // List<String> -> String[]
        List<String> names = Arrays.asList("a", "b");
        String[] nameArr = names.toArray(new String[0]);
        System.out.println("List -> String[] = " + Arrays.toString(nameArr));

        // String <-> char[]
        char[] chars = "abc".toCharArray();
        Arrays.sort(chars);                                            // anagram check pattern
        String rebuilt = new String(chars);
        System.out.println("String <-> char[] = " + rebuilt);

        // Set <-> List
        Set<Integer> set = new HashSet<>(boxed);
        List<Integer> fromSet = new ArrayList<>(set);
        System.out.println("Set -> List = " + fromSet);
    }
}
