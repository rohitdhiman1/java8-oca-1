package com.oca.tree;

import java.util.*;
import java.util.function.Supplier;

class TreeAsEdge {

    // =====================================================================
    //  DRILL AREA: rewrite these from memory every day. Root is node 0.
    //  A method that returns null shows up as SKIP in the test output.
    //  Add any helper methods you need right here.
    // =====================================================================

    // 1. Build the adjacency list. Nodes are 0..n-1, where n = edges.length + 1.
    List<List<Integer>> buildAdj(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i < edges.length+1 ; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    // 2. Recursive DFS. Return the nodes in the order you first visit them.
    List<Integer> dfsOrderRecursive(List<List<Integer>> adj) {
        return null; // TODO
    }

    

    // 3. Iterative DFS with an explicit stack. Any valid DFS order is accepted.
    List<Integer> dfsOrderIterative(List<List<Integer>> adj) {
        return null; // TODO
    }

    // 4. BFS. Return the nodes in the order they leave the queue.
    List<Integer> bfsOrder(List<List<Integer>> adj) {
        return null; // TODO
    }

    // 5. Bottom-up recursive DFS: size of the subtree rooted at every node.
    int[] subtreeSizes(List<List<Integer>> adj) {
        return null; // TODO
    }

    // 6. Top-down ITERATIVE DFS: depth of every node (root has depth 0).
    int[] depths(List<List<Integer>> adj) {
        return null; // TODO
    }

    // 7. Level-by-level BFS: number of nodes on each level, root level first.
    List<Integer> levelCounts(List<List<Integer>> adj) {
        return null; // TODO
    }

    // =====================================================================
    //  TEST HARNESS: no need to edit anything below this line.
    // =====================================================================

    private static final String[] COLUMNS =
            {"adj", "dfs-rec", "dfs-iter", "bfs", "sizes", "depths", "levels"};
    private static final String[] METHOD_NAMES =
            {"buildAdj", "dfsOrderRecursive", "dfsOrderIterative", "bfsOrder",
             "subtreeSizes", "depths", "levelCounts"};

    private static final List<String> details = new ArrayList<>();
    private static boolean sawStackOverflowWarning = false;

    private static class TestCase {
        final String name;
        final int[][] edges;
        final int[] sizes, depths;
        final List<Integer> levels;
        final boolean deep;

        TestCase(String name, int[][] edges, int[] sizes, int[] depths, List<Integer> levels, boolean deep) {
            this.name = name; this.edges = edges; this.sizes = sizes;
            this.depths = depths; this.levels = levels; this.deep = deep;
        }
    }

    public static void main(String[] args) {
        TreeAsEdge t = new TreeAsEdge();
        List<TestCase> cases = testCases();
        String[][] grid = new String[cases.size()][COLUMNS.length];
        for (int i = 0; i < cases.size(); i++) runCase(t, cases.get(i), grid[i]);
        printTable(cases, grid);
    }

    private static List<TestCase> testCases() {
        List<TestCase> cases = new ArrayList<>();

        cases.add(new TestCase("single edge",
                new int[][]{{0, 1}},
                new int[]{2, 1}, new int[]{0, 1}, List.of(1, 1), false));

        cases.add(new TestCase("full binary (7)",
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}},
                new int[]{7, 3, 3, 1, 1, 1, 1}, new int[]{0, 1, 1, 2, 2, 2, 2}, List.of(1, 2, 4), false));

        cases.add(new TestCase("lopsided (9)",
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}},
                new int[]{9, 7, 5, 3, 1, 1, 1, 1, 1}, new int[]{0, 1, 2, 3, 4, 1, 2, 3, 4},
                List.of(1, 2, 2, 2, 2), false));

        cases.add(new TestCase("star, center = root",
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}},
                new int[]{5, 1, 1, 1, 1}, new int[]{0, 1, 1, 1, 1}, List.of(1, 4), false));

        cases.add(new TestCase("star, root is a leaf",
                new int[][]{{0, 2}, {1, 2}, {2, 3}, {2, 4}},
                new int[]{5, 1, 4, 1, 1}, new int[]{0, 2, 1, 2, 2}, List.of(1, 1, 3), false));

        cases.add(new TestCase("child-first edges",
                new int[][]{{1, 0}, {2, 1}, {3, 1}},
                new int[]{4, 3, 1, 1}, new int[]{0, 1, 2, 2}, List.of(1, 1, 2), false));

        int n = 100_000;
        int[][] chain = new int[n - 1][];
        int[] chainSizes = new int[n], chainDepths = new int[n];
        for (int i = 0; i < n - 1; i++) chain[i] = new int[]{i, i + 1};
        for (int i = 0; i < n; i++) { chainSizes[i] = n - i; chainDepths[i] = i; }
        cases.add(new TestCase("chain 100k (stress)",
                chain, chainSizes, chainDepths, Collections.nCopies(n, 1), true));

        return cases;
    }

    private static void runCase(TreeAsEdge t, TestCase tc, String[] row) {
        int n = tc.edges.length + 1;
        int[][] ref = reference(tc.edges);   // ref[0] = parent, ref[1] = depth

        List<List<Integer>> built = null;
        String adjResult;
        try {
            built = t.buildAdj(tc.edges);
            adjResult = checkAdj(built, tc.edges, n);
        } catch (Throwable e) {
            adjResult = "threw " + e;
        }
        record(tc, row, 0, adjResult);
        if (adjResult != null) {
            for (int c = 1; c < row.length; c++) row[c] = "-";
            return;
        }
        final List<List<Integer>> adj = built;

        test(tc, row, 1, tc.deep, () -> checkDfsOrder(t.dfsOrderRecursive(adj), ref[0], n));
        test(tc, row, 2, false,   () -> checkDfsOrder(t.dfsOrderIterative(adj), ref[0], n));
        test(tc, row, 3, false,   () -> checkBfsOrder(t.bfsOrder(adj), ref[1], n));
        test(tc, row, 4, tc.deep, () -> checkArray(t.subtreeSizes(adj), tc.sizes));
        test(tc, row, 5, false,   () -> checkArray(t.depths(adj), tc.depths));
        test(tc, row, 6, false,   () -> checkList(t.levelCounts(adj), tc.levels));
    }

    private static void test(TestCase tc, String[] row, int col, boolean recursionStress, Supplier<String> check) {
        String result;
        try {
            result = check.get();
        } catch (StackOverflowError e) {
            if (recursionStress) {
                row[col] = "WARN";
                sawStackOverflowWarning = true;
                return;
            }
            result = "StackOverflowError (is this method accidentally recursive?)";
        } catch (Throwable e) {
            result = "threw " + e;
        }
        record(tc, row, col, result);
    }

    private static void record(TestCase tc, String[] row, int col, String result) {
        if (result == null) row[col] = "PASS";
        else if (result.equals("SKIP")) row[col] = "skip";
        else {
            row[col] = "FAIL";
            details.add("[" + tc.name + "] " + METHOD_NAMES[col] + ": " + result);
        }
    }

    private static void printTable(List<TestCase> cases, String[][] grid) {
        int nameWidth = "tree".length();
        for (TestCase tc : cases) nameWidth = Math.max(nameWidth, tc.name.length());
        int[] widths = new int[COLUMNS.length];
        for (int c = 0; c < COLUMNS.length; c++) widths[c] = Math.max(COLUMNS[c].length(), 4);

        StringBuilder sep = new StringBuilder("+").append("-".repeat(nameWidth + 2)).append("+");
        for (int w : widths) sep.append("-".repeat(w + 2)).append("+");

        System.out.println();
        System.out.println(sep);
        System.out.println(row("tree", nameWidth, COLUMNS, widths));
        System.out.println(sep);
        int pass = 0, fail = 0, skip = 0, warn = 0;
        for (int i = 0; i < cases.size(); i++) {
            System.out.println(row(cases.get(i).name, nameWidth, grid[i], widths));
            for (String cell : grid[i]) {
                switch (cell) {
                    case "PASS": pass++; break;
                    case "FAIL": fail++; break;
                    case "WARN": warn++; break;
                    case "skip": skip++; break;
                    default: break;
                }
            }
        }
        System.out.println(sep);
        System.out.printf("  PASS %d   FAIL %d   skip %d   WARN %d%n", pass, fail, skip, warn);
        System.out.println("  skip = method returns null (not written yet)   - = needs a working buildAdj");

        if (sawStackOverflowWarning) {
            System.out.println();
            System.out.println("  WARN = StackOverflowError on the 100k chain. Expected for recursion;");
            System.out.println("         this is why the iterative versions exist (those must PASS).");
        }
        if (!details.isEmpty()) {
            System.out.println();
            System.out.println("  Failures:");
            for (String d : details) System.out.println("   * " + d);
        }
        System.out.println();
    }

    private static String row(String name, int nameWidth, String[] cells, int[] widths) {
        StringBuilder sb = new StringBuilder("| ").append(pad(name, nameWidth)).append(" |");
        for (int c = 0; c < cells.length; c++) sb.append(" ").append(center(cells[c], widths[c])).append(" |");
        return sb.toString();
    }

    private static String pad(String s, int w) { return s + " ".repeat(w - s.length()); }

    private static String center(String s, int w) {
        int left = (w - s.length()) / 2;
        return " ".repeat(left) + s + " ".repeat(w - s.length() - left);
    }

    // ---- checkers: return null on pass, "SKIP" if not implemented, else a message ----

    private static String checkAdj(List<List<Integer>> adj, int[][] edges, int n) {
        if (adj == null) return "SKIP";
        if (adj.size() != n) return "expected " + n + " neighbor lists, got " + adj.size();
        long total = 0;
        for (List<Integer> list : adj) {
            if (list == null) return "a neighbor list is null";
            total += list.size();
        }
        if (total != 2L * edges.length)
            return "expected " + (2 * edges.length) + " total entries (each edge twice), got " + total;
        for (int[] e : edges) {
            if (!adj.get(e[0]).contains(e[1]) || !adj.get(e[1]).contains(e[0]))
                return "edge " + e[0] + "-" + e[1] + " is not stored in both directions";
        }
        return null;
    }

    private static String checkDfsOrder(List<Integer> order, int[] parent, int n) {
        if (order == null) return "SKIP";
        String basic = checkPermutation(order, n);
        if (basic != null) return basic;
        Deque<Integer> path = new ArrayDeque<>();
        path.push(order.get(0));
        for (int i = 1; i < n; i++) {
            int v = order.get(i);
            while (!path.isEmpty() && path.peek() != parent[v]) path.pop();
            if (path.isEmpty())
                return "position " + i + ": node " + v + " visited, but its parent " + parent[v]
                        + " is not on the current DFS path (not a valid DFS order)";
            path.push(v);
        }
        return null;
    }

    private static String checkBfsOrder(List<Integer> order, int[] depth, int n) {
        if (order == null) return "SKIP";
        String basic = checkPermutation(order, n);
        if (basic != null) return basic;
        for (int i = 1; i < n; i++) {
            int prev = order.get(i - 1), cur = order.get(i);
            if (depth[cur] < depth[prev])
                return "node " + cur + " (depth " + depth[cur] + ") came after node " + prev
                        + " (depth " + depth[prev] + "), so this is not level order";
        }
        return null;
    }

    private static String checkPermutation(List<Integer> order, int n) {
        if (order.size() != n) return "expected " + n + " nodes, got " + order.size();
        if (order.get(0) != 0) return "traversal must start at root 0, started at " + order.get(0);
        boolean[] seen = new boolean[n];
        for (int v : order) {
            if (v < 0 || v >= n) return "invalid node id " + v;
            if (seen[v]) return "node " + v + " visited more than once";
            seen[v] = true;
        }
        return null;
    }

    private static String checkArray(int[] actual, int[] expected) {
        if (actual == null) return "SKIP";
        if (actual.length != expected.length)
            return "expected length " + expected.length + ", got " + actual.length;
        for (int i = 0; i < expected.length; i++) {
            if (actual[i] != expected[i])
                return "node " + i + ": expected " + expected[i] + ", got " + actual[i];
        }
        return null;
    }

    private static String checkList(List<Integer> actual, List<Integer> expected) {
        if (actual == null) return "SKIP";
        if (actual.size() != expected.size())
            return "expected " + expected.size() + " levels, got " + actual.size();
        for (int i = 0; i < expected.size(); i++) {
            if (!actual.get(i).equals(expected.get(i)))
                return "level " + i + ": expected " + expected.get(i) + " nodes, got " + actual.get(i);
        }
        return null;
    }

    // Trusted parent/depth arrays (from its own BFS), used to validate traversal orders.
    private static int[][] reference(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) { g.get(e[0]).add(e[1]); g.get(e[1]).add(e[0]); }
        int[] parent = new int[n], depth = new int[n];
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0); seen[0] = true; parent[0] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (seen[v]) continue;
                seen[v] = true; parent[v] = u; depth[v] = depth[u] + 1;
                q.offer(v);
            }
        }
        return new int[][]{parent, depth};
    }
}