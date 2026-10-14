package com.ocp.lambdas;

import java.util.*;
import java.util.function.Supplier;

class LambdaDrill {

    // =====================================================================
    //  DRILL AREA: rewrite these from memory every day.
    //  Each exercise names the API to use. Pass it a lambda you write yourself.
    //  Not allowed: streams, method references, ready-made comparators
    //  (Comparator.comparing, Collections.reverseOrder, ...).
    //  A method that returns null shows up as skip in the test output.
    // =====================================================================

    // 1. Arrays.sort: start ascending; equal starts -> end DESCENDING.
    //    Sort in place and return the same array.
    int[][] sortIntervals(int[][] intervals) {
        return null; // TODO
    }

    // 2. Arrays.sort: largest first. Sort in place and return the same array.
    Integer[] sortDescending(Integer[] nums) {
        return null; // TODO
    }

    // 3. List.sort: shortest first; equal lengths -> alphabetical.
    //    Sort in place and return the same list.
    List<String> sortByLengthThenAlpha(List<String> words) {
        return null; // TODO
    }

    // 4. removeIf: keep only values in [lo, hi] (inclusive). Return the same list.
    List<Integer> keepInRange(List<Integer> nums, int lo, int hi) {
        return null; // TODO
    }

    // 5. Iterable.forEach: total number of characters across all words.
    Integer totalLength(List<String> words) {
        return null; // TODO
    }

    // 6. Map.forEach: swap keys and values (values are unique). Return a new map.
    Map<Integer, String> invert(Map<String, Integer> map) {
        return null; // TODO
    }

    // 7. computeIfAbsent: undirected adjacency map. Neighbors in edge order.
    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        return null; // TODO
    }

    // 8. computeIfAbsent: group anagrams, keyed by the word's letters sorted
    //    ("eat" -> "aet"). Words inside a group keep their input order.
    Map<String, List<String>> groupAnagrams(List<String> words) {
        return null; // TODO
    }

    // 9. computeIfPresent: one c was used up, so decrement its count.
    //    When a count reaches 0 the key must disappear. If c is absent, change nothing.
    //    Return the same map.
    Map<Character, Integer> useOne(Map<Character, Integer> counts, char c) {
        return null; // TODO
    }

    // 10. Map.replaceAll: promoted people get +10%, everyone else +2%.
    //     Integer math: salary * 110 / 100 and salary * 102 / 100. Return the same map.
    Map<String, Integer> applyRaises(Map<String, Integer> salaries, Set<String> promoted) {
        return null; // TODO
    }

    // 11. Optional.orElseGet: the nickname if present, else defaultName(userId).
    //     defaultName is "expensive" and must only run when the nickname is empty.
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
                        new int[][]{{MIN, 0}, {0, MAX}, {0, MIN}, {MAX, 0}}))));

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
