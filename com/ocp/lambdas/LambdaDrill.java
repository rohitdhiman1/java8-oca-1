package com.ocp.lambdas;

import java.util.*;
import java.util.function.Supplier;
import java.util.HashMap;

class LambdaDrill {

    // =====================================================================
    //  DRILL AREA: rewrite these from memory every day.
    //  Each exercise names the API to use. Pass it a lambda you write yourself.
    //  Not allowed: streams, method references, ready-made comparators
    //  (Comparator.comparing, Collections.reverseOrder, ...).
    //  A method that returns null shows up as skip in the test output.
    // =====================================================================

    // 1. Arrays.sort: each row is one interval {start, end}, i.e. row[0] = start,
    //    row[1] = end (n rows x 2 columns). Sort the rows by:
    //      - row[0] smallest first;
    //      - if two rows have the same row[0], the one with the LARGER row[1] comes first.
    //    e.g. {{3,4},{1,2},{1,5},{1,3}} -> {{1,5},{1,3},{1,2},{3,4}}
    //    Sort in place and return the same array.
    int[][] sortIntervals(int[][] intervals) {
        return null; // TODO
    }

    // 2. Arrays.sort
    //    Input : an Integer[] array (Integer objects, not int primitives).
    //    Task  : sort it from LARGEST to SMALLEST.
    //    Return: the same array, after sorting it in place.
    //    e.g. {3, 1, 2} -> {3, 2, 1}
    //    Heads-up: the test includes Integer.MAX_VALUE and Integer.MIN_VALUE.
    Integer[] sortDescending(Integer[] nums) {
        return null; // TODO
    }

    // 3. List.sort
    //    Input : a list of words.
    //    Task  : sort by word length, SHORTEST first.
    //            If two words have the same length, sort those two alphabetically (A -> Z).
    //    Return: the same list, after sorting it in place.
    //    e.g. ["pear", "fig", "apple", "date"] -> ["fig", "date", "pear", "apple"]
    //         ("date" and "pear" are both 4 letters, so "date" comes first alphabetically)
    List<String> sortByLengthThenAlpha(List<String> words) {
        return null; // TODO
    }

    // 4. removeIf
    //    Input : a list of numbers, and two bounds lo and hi.
    //    Task  : remove every number that is smaller than lo OR bigger than hi.
    //            Numbers equal to lo or hi STAY in the list.
    //    Return: the same list, after removing from it.
    //    e.g. nums = [5, -1, 10, 3, 7, 0], lo = 0, hi = 7 -> [5, 3, 7, 0]
    List<Integer> keepInRange(List<Integer> nums, int lo, int hi) {
        return null; // TODO
    }

    // 5. Iterable.forEach (call words.forEach(...), not a for loop)
    //    Input : a list of words.
    //    Task  : add up the length of every word.
    //    Return: the total (0 for an empty list).
    //    e.g. ["ab", "cde", ""] -> 2 + 3 + 0 = 5
    //    Heads-up: adding to a local int variable inside the lambda will not compile.
    //              Work out why, and find a way around it.
    Integer totalLength(List<String> words) {
        return null; // TODO
    }

    // 6. Map.forEach (call map.forEach(...))
    //    Input : a map like {"a"=1, "b"=2}. No two keys share the same value.
    //    Task  : build a NEW map where every key becomes a value and every value becomes a key.
    //    Return: the new map (leave the input map alone).
    //    e.g. {"a"=1, "b"=2, "c"=3} -> {1="a", 2="b", 3="c"}
    Map<Integer, String> invert(Map<String, Integer> map) {
        return null; // TODO
    }

    // 7. computeIfAbsent
    //    Input : edges of a graph. Each row is one edge {u, v}: row[0] = u, row[1] = v.
    //            Edges are two-way: u is connected to v AND v is connected to u.
    //    Task  : build a map from each node to the list of nodes it is connected to.
    //            Add neighbours in the same order the edges appear in the input.
    //    Return: the new map (no edges -> empty map).
    //    e.g. {{0,1}, {0,2}, {1,3}} -> {0=[1, 2], 1=[0, 3], 2=[0], 3=[1]}
    //    Use computeIfAbsent so a node's list is created the first time you see that node.
    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        return null; // TODO
    }

    // 8. computeIfAbsent
    //    Input : a list of words.
    //    Task  : put words made of the same letters (anagrams) in the same group.
    //            Each group's key is the word's letters sorted A -> Z: "eat" -> "aet".
    //            "eat", "tea" and "ate" all give "aet", so they share one group.
    //            Inside a group, keep the words in the order they appear in the input.
    //    Return: a new map from key -> list of words.
    //    e.g. ["eat", "tea", "tan", "ate", "nat", "bat"]
    //         -> {"aet"=["eat", "tea", "ate"], "ant"=["tan", "nat"], "abt"=["bat"]}
    Map<String, List<String>> groupAnagrams(List<String> words) {
        return null; // TODO
    }

    // 9. computeIfPresent
    //    Input : a map from letter -> how many of that letter we have, plus one letter c.
    //    Task  : we just used up one c, so lower c's count by 1.
    //            - If the count drops to 0, remove c from the map completely
    //              (the key must be gone, not left behind as c=0).
    //            - If c is not in the map at all, change nothing.
    //    Return: the same map, after changing it.
    //    e.g. {a=2, b=1}, c='a' -> {a=1, b=1}
    //         {a=2, b=1}, c='b' -> {a=2}
    //         {a=2, b=1}, c='z' -> {a=2, b=1}
    //    Hint: look up what computeIfPresent does when your lambda returns null.
    Map<Character, Integer> useOne(Map<Character, Integer> counts, char c) {
        return null; // TODO
    }

    // 10. Map.replaceAll
    //     Input : a map from name -> salary, and a set of names who got promoted.
    //     Task  : give everyone a raise by replacing each salary with a new one:
    //             - promoted names (in the set):  salary * 110 / 100   (+10%)
    //             - everyone else:                salary * 102 / 100   (+2%)
    //     Return: the same map, after changing it.
    //     e.g. {"ann"=1000, "bob"=2000}, promoted = {"bob"} -> {"ann"=1020, "bob"=2200}
    Map<String, Integer> applyRaises(Map<String, Integer> salaries, Set<String> promoted) {
        return null; // TODO
    }

    // 11. Optional.orElseGet
    //     Input : an Optional that may or may not hold a nickname, and a user id.
    //     Task  : if there is a nickname, return it.
    //             If the Optional is empty, return defaultName(userId) (the helper below).
    //     Pretend defaultName is slow and costly: it must ONLY be called when the
    //     Optional is empty. The test counts how many times it runs.
    //     e.g. Optional.of("ro"), "42" -> "ro"       (defaultName never called)
    //          Optional.empty(),  "42" -> "user-42"  (defaultName called once)
    String displayName(Optional<String> nickname, String userId) {
        return null; // TODO
    }

    // Provided helper for #11. Don't edit.
    String defaultName(String userId) {
        defaultNameCalls++;
        return "user-" + userId;
    }

    // =====================================================================
    //  TEST HARNESS: no need to edit anything below this line.
    // =====================================================================

    private static int defaultNameCalls = 0;
    private static final List<String> details = new ArrayList<>();

    private static class Case {
        final String name;
        final Supplier<String> check;

        Case(String name, Supplier<String> check) { this.name = name; this.check = check; }
    }

    private static Case c(String name, Supplier<String> check) { return new Case(name, check); }

    public static void main(String[] args) {
        LambdaDrill d = new LambdaDrill();
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        List<String[]> rows = new ArrayList<>();

        rows.add(run("1", "sortIntervals", "Arrays.sort",
                c("basic", () -> expect(
                        d.sortIntervals(new int[][]{{3, 4}, {1, 2}, {2, 9}}),
                        new int[][]{{1, 2}, {2, 9}, {3, 4}})),
                c("equal starts", () -> expect(
                        d.sortIntervals(new int[][]{{1, 2}, {1, 5}, {0, 1}, {1, 3}}),
                        new int[][]{{0, 1}, {1, 5}, {1, 3}, {1, 2}})),
                c("extreme values (does a - b overflow?)", () -> expect(
                        d.sortIntervals(new int[][]{{MAX, 0}, {MIN, 0}, {0, MIN}, {0, MAX}}),
                        new int[][]{{MIN, 0}, {0, MAX}, {0, MIN}, {MAX, 0}})),
                c("1000 rows with duplicates (equal rows must compare as 0)", () -> {
                    Random rnd = new Random(42);
                    int[][] in = new int[1000][];
                    for (int i = 0; i < in.length; i++) in[i] = new int[]{rnd.nextInt(3), rnd.nextInt(3)};
                    int[][] want = new int[in.length][];
                    for (int i = 0; i < in.length; i++) want[i] = in[i].clone();
                    Arrays.sort(want, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
                    return expect(d.sortIntervals(in), want);
                })));

        rows.add(run("2", "sortDescending", "Arrays.sort",
                c("basic", () -> expect(d.sortDescending(new Integer[]{3, 1, 2}), new Integer[]{3, 2, 1})),
                c("duplicates", () -> expect(d.sortDescending(new Integer[]{5, 1, 5, 3}), new Integer[]{5, 5, 3, 1})),
                c("extreme values (does b - a overflow?)", () -> expect(
                        d.sortDescending(new Integer[]{0, MIN, MAX, -1}), new Integer[]{MAX, 0, -1, MIN}))));

        rows.add(run("3", "sortByLengthThenAlpha", "List.sort",
                c("mixed", () -> expect(
                        d.sortByLengthThenAlpha(new ArrayList<>(List.of("pear", "fig", "apple", "kiwi", "banana", "date"))),
                        List.of("fig", "date", "kiwi", "pear", "apple", "banana"))),
                c("same length", () -> expect(
                        d.sortByLengthThenAlpha(new ArrayList<>(List.of("cc", "aa", "bb"))), List.of("aa", "bb", "cc"))),
                c("empty", () -> expect(d.sortByLengthThenAlpha(new ArrayList<>()), List.of()))));

        rows.add(run("4", "keepInRange", "removeIf",
                c("basic", () -> expect(
                        d.keepInRange(new ArrayList<>(List.of(5, -1, 10, 3, 7, 0)), 0, 7), List.of(5, 3, 7, 0))),
                c("all removed", () -> expect(d.keepInRange(new ArrayList<>(List.of(1, 2, 3)), 10, 20), List.of())),
                c("bounds inclusive", () -> expect(
                        d.keepInRange(new ArrayList<>(List.of(128, 1000, 127, 1001)), 128, 1000), List.of(128, 1000)))));

        rows.add(run("5", "totalLength", "Iterable.forEach",
                c("basic", () -> expect(d.totalLength(new ArrayList<>(List.of("ab", "cde", ""))), 5)),
                c("empty", () -> expect(d.totalLength(new ArrayList<>()), 0))));

        rows.add(run("6", "invert", "Map.forEach",
                c("basic", () -> expect(
                        d.invert(new HashMap<>(Map.of("a", 1, "b", 2, "c", 3))), Map.of(1, "a", 2, "b", 3, "c"))),
                c("empty", () -> expect(d.invert(new HashMap<>()), Map.of()))));

        rows.add(run("7", "buildGraph", "computeIfAbsent",
                c("small tree", () -> expect(
                        d.buildGraph(new int[][]{{0, 1}, {0, 2}, {1, 3}}),
                        Map.of(0, List.of(1, 2), 1, List.of(0, 3), 2, List.of(0), 3, List.of(1)))),
                c("child-first edges", () -> expect(
                        d.buildGraph(new int[][]{{1, 0}, {2, 1}}),
                        Map.of(0, List.of(1), 1, List.of(0, 2), 2, List.of(1)))),
                c("no edges", () -> expect(d.buildGraph(new int[0][]), Map.of()))));

        rows.add(run("8", "groupAnagrams", "computeIfAbsent",
                c("classic", () -> expect(
                        d.groupAnagrams(new ArrayList<>(List.of("eat", "tea", "tan", "ate", "nat", "bat"))),
                        Map.of("aet", List.of("eat", "tea", "ate"), "ant", List.of("tan", "nat"), "abt", List.of("bat")))),
                c("empty string", () -> expect(d.groupAnagrams(new ArrayList<>(List.of(""))), Map.of("", List.of("")))),
                c("no words", () -> expect(d.groupAnagrams(new ArrayList<>()), Map.of()))));

        rows.add(run("9", "useOne", "computeIfPresent",
                c("count 2 -> 1", () -> expect(
                        d.useOne(new HashMap<>(Map.of('a', 2, 'b', 1)), 'a'), Map.of('a', 1, 'b', 1))),
                c("count 1 -> key removed", () -> expect(
                        d.useOne(new HashMap<>(Map.of('a', 2, 'b', 1)), 'b'), Map.of('a', 2))),
                c("absent key -> unchanged", () -> expect(
                        d.useOne(new HashMap<>(Map.of('a', 2, 'b', 1)), 'z'), Map.of('a', 2, 'b', 1)))));

        rows.add(run("10", "applyRaises", "Map.replaceAll",
                c("mixed", () -> expect(
                        d.applyRaises(new HashMap<>(Map.of("ann", 1000, "bob", 2000, "cy", 50)), Set.of("bob")),
                        Map.of("ann", 1020, "bob", 2200, "cy", 51))),
                c("nobody promoted", () -> expect(
                        d.applyRaises(new HashMap<>(Map.of("ann", 1000)), Set.of()), Map.of("ann", 1020)))));

        rows.add(run("11", "displayName", "Optional.orElseGet",
                c("nickname present (default must not run)", () -> {
                    defaultNameCalls = 0;
                    String r = expect(d.displayName(Optional.of("ro"), "42"), "ro");
                    if (r != null) return r;
                    return defaultNameCalls == 0 ? null
                            : "defaultName() ran " + defaultNameCalls + "x although the nickname was present";
                }),
                c("nickname empty", () -> {
                    defaultNameCalls = 0;
                    String r = expect(d.displayName(Optional.empty(), "42"), "user-42");
                    if (r != null) return r;
                    return defaultNameCalls == 1 ? null
                            : "expected defaultName() to run once, ran " + defaultNameCalls + "x";
                })));

        printTable(rows);
    }

    private static String[] run(String id, String method, String api, Case... cases) {
        int pass = 0;
        boolean skipped = false;
        for (Case tc : cases) {
            String result;
            try {
                result = tc.check.get();
            } catch (Throwable e) {
                result = "threw " + e;
            }
            if (result == null) pass++;
            else if (result.equals("SKIP")) skipped = true;
            else details.add("#" + id + " " + method + " [" + tc.name + "]: " + result);
        }
        String status = skipped && pass == 0 ? "skip"
                : (pass == cases.length ? "PASS " : "FAIL ") + pass + "/" + cases.length;
        return new String[]{id, method, api, status};
    }

    // Returns null on pass, "SKIP" if not implemented, else a message.
    private static String expect(Object actual, Object expected) {
        if (actual == null) return "SKIP";
        boolean ok = actual instanceof Object[] && expected instanceof Object[]
                ? Arrays.deepEquals((Object[]) actual, (Object[]) expected)
                : actual.equals(expected);
        return ok ? null : "expected " + show(expected) + ", got " + show(actual);
    }

    private static String show(Object o) {
        return o instanceof Object[] ? Arrays.deepToString((Object[]) o) : String.valueOf(o);
    }

    private static void printTable(List<String[]> rows) {
        String[] header = {"#", "exercise", "API", "result"};
        int[] widths = new int[header.length];
        for (int i = 0; i < header.length; i++) widths[i] = header[i].length();
        for (String[] r : rows)
            for (int i = 0; i < r.length; i++) widths[i] = Math.max(widths[i], r[i].length());

        StringBuilder sep = new StringBuilder("+");
        for (int w : widths) sep.append("-".repeat(w + 2)).append("+");

        System.out.println();
        System.out.println(sep);
        System.out.println(line(header, widths));
        System.out.println(sep);
        int pass = 0, fail = 0, skip = 0;
        for (String[] r : rows) {
            System.out.println(line(r, widths));
            if (r[3].startsWith("PASS")) pass++;
            else if (r[3].startsWith("FAIL")) fail++;
            else skip++;
        }
        System.out.println(sep);
        System.out.printf("  PASS %d   FAIL %d   skip %d%n", pass, fail, skip);
        System.out.println("  skip = method returns null (not written yet)");

        if (!details.isEmpty()) {
            System.out.println();
            System.out.println("  Failures:");
            for (String d : details) System.out.println("   * " + d);
        }
        System.out.println();
    }

    private static String line(String[] cells, int[] widths) {
        StringBuilder sb = new StringBuilder("|");
        for (int i = 0; i < cells.length; i++)
            sb.append(' ').append(cells[i]).append(" ".repeat(widths[i] - cells[i].length())).append(" |");
        return sb.toString();
    }
}
