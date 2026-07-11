# Java Collections Cheat Sheet (LeetCode / Assessment Prep)

> Quick-revision reference for coding assessments. Every snippet is Java 8 compatible.
> **Runnable companion:** [CollectionsCheatSheet.java](../com/ocp/collections/CollectionsCheatSheet.java) — run it to see every method's output.
>
> ⚠️ Beyond OCA (1Z0-808) scope — the exam only tests `ArrayList` in depth. This file is for interview/LeetCode prep.

---

## Which structure when?

| Need | Use | Key ops |
|---|---|---|
| Index-based access, ordered | `ArrayList` | `get`/`set` O(1), `add` amortized O(1) |
| Key → value lookup | `HashMap` | `get`/`put`/`containsKey` O(1) |
| Membership / dedupe | `HashSet` | `add`/`contains` O(1) |
| LIFO (stack) | `ArrayDeque` (`push`/`pop`) | O(1) |
| FIFO (queue, BFS) | `ArrayDeque` (`offer`/`poll`) | O(1) |
| Repeated min/max (heap) | `PriorityQueue` | `offer`/`poll` O(log n), `peek` O(1) |
| Sorted keys, floor/ceiling queries | `TreeMap` / `TreeSet` | all ops O(log n) |
| Building strings in a loop | `StringBuilder` | `append` O(1) |

---

## Time & Space Complexity

All structures use **O(n) space** for n elements (see notes for constant-factor differences).

### ArrayList (backed by a resizing array)

| Operation | Time | Notes |
|---|---|---|
| `get(i)` / `set(i, e)` | O(1) | direct index into the backing array |
| `add(e)` (append) | O(1) amortized | O(n) on the occasional resize (array copy) |
| `add(i, e)` / `remove(i)` | O(n) | shifts everything after index i |
| `contains(e)` / `indexOf(e)` | O(n) | linear scan |
| `remove(Object)` | O(n) | scan + shift |

Space note: capacity grows by ~1.5×, so the backing array can be up to ~50% larger than `size()`.

### HashMap / HashSet (hash table; HashSet is a HashMap underneath)

| Operation | Average | Worst | Notes |
|---|---|---|---|
| `put` / `get` / `remove` / `containsKey` / `contains` | O(1) | O(log n) | worst = many keys colliding in one bucket; Java 8 turns large buckets into red-black trees (pre-Java-8 worst was O(n)) |
| `containsValue` | O(n) | O(n) | scans all entries — no reverse index |
| iteration | O(n + capacity) | | why iterating a huge, mostly-empty map is slow |

O(1) assumes a well-distributed `hashCode()`. Space overhead is real: each entry is a node object (key ref + value ref + hash + next pointer), so a `HashMap` costs several times more memory than the raw data.

### ArrayDeque / Stack

| Operation | Time | Notes |
|---|---|---|
| `push` / `pop` / `peek` | O(1) amortized | both classes |
| `offer` / `poll` (queue ends) | O(1) amortized | `ArrayDeque` = circular array, resize is O(n) but rare |
| `contains(e)` | O(n) | it's not a set — don't use it for membership checks |
| index access | — | not supported; need it? use `ArrayList` |

### PriorityQueue (binary heap in an array)

| Operation | Time | Notes |
|---|---|---|
| `offer(e)` / `poll()` | O(log n) | sift up / sift down |
| `peek()` | O(1) | root of the heap |
| `remove(Object)` / `contains(e)` | O(n) | linear search first — avoid in hot loops |
| build from n elements | O(n log n) | via repeated `offer` |

Top-K pattern with a size-K heap: O(n log k) time, **O(k) space** — the whole point vs. sorting at O(n log n). Remember only the root is ordered; the rest of the array is not sorted.

### TreeMap / TreeSet (red-black tree, self-balancing BST)

| Operation | Time | Notes |
|---|---|---|
| `put` / `get` / `remove` / `contains` | O(log n) | guaranteed, not just average — no hash-collision worst case |
| `floorKey` / `ceilingKey` / `firstKey` / `lastKey` etc. | O(log n) | the reason to pay log n over HashMap's O(1) |
| in-order iteration | O(n) | always sorted |

Rule of thumb: `HashMap` unless you need sorted order or floor/ceiling queries — then `TreeMap`.

### String / StringBuilder

| Operation | Time | Notes |
|---|---|---|
| `s.charAt(i)` / `s.length()` | O(1) | |
| `s.substring(i, j)` / `s + t` / `equals` / `indexOf` | O(n) | every String "modification" copies — String is immutable |
| `s += x` **in a loop** | **O(n²) total** | copies the whole string every iteration — the classic accidental quadratic |
| `sb.append(x)` | O(1) amortized | this is the fix: build with StringBuilder, O(n) total |
| `sb.insert(i, x)` / `sb.deleteCharAt(i)` | O(n) | shifts the tail |
| `sb.reverse()` / `sb.toString()` | O(n) | |

### Sorting & searching

| Operation | Time | Notes |
|---|---|---|
| `Arrays.sort(int[])` | O(n log n) average | dual-pivot quicksort; O(n²) pathological worst (rare) |
| `Arrays.sort(T[])` / `Collections.sort(list)` | O(n log n) guaranteed | Timsort — also **stable** (equal elements keep their order), O(n) extra space |
| `Arrays.binarySearch` | O(log n) | input must already be sorted |
| `Collections.max` / `min` / `frequency` | O(n) | |

---

## ArrayList

```java
List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30)); // mutable copy
```

| Method | Notes |
|---|---|
| `add(e)` / `add(i, e)` | append / insert at index (shifts right) |
| `get(i)` / `set(i, e)` | read / replace at index |
| `remove(i)` | removes by **index** |
| `remove(Integer.valueOf(x))` | removes by **element** — the classic `List<Integer>` trap |
| `indexOf(e)` / `contains(e)` | linear scan, first match / `-1` if absent |
| `size()` / `isEmpty()` / `clear()` | |
| `removeIf(n -> n > 25)` | safe filtered removal (Java 8) |
| `subList(i, j)` | **view**, end exclusive — wrap in `new ArrayList<>(...)` to copy |
| `list.sort(cmp)` / `list.sort(null)` | sort in place (`null` = natural order) |

**Traps:** `Arrays.asList(...)` returns a fixed-size list — `add`/`remove` throw `UnsupportedOperationException`. Removing inside a for-each throws `ConcurrentModificationException` — use `removeIf` or an explicit `Iterator`.

---

## HashMap

```java
Map<String, Integer> map = new HashMap<>();
```

| Method | Notes |
|---|---|
| `put(k, v)` | inserts, **overwrites** existing key (returns old value or `null`) |
| `get(k)` | `null` if absent (never throws) |
| `getOrDefault(k, def)` | avoids null checks — huge time saver |
| `containsKey(k)` / `containsValue(v)` | O(1) / O(n) |
| `putIfAbsent(k, v)` | insert only if absent |
| `remove(k)` | returns removed value or `null` |
| `merge(k, 1, Integer::sum)` | one-line counter increment |
| `computeIfAbsent(k, x -> new ArrayList<>())` | build-bucket-on-first-use for grouping |
| `keySet()` / `values()` / `entrySet()` | the three iteration views |

**Frequency count** (the #1 map pattern):

```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray())
    freq.merge(c, 1, Integer::sum);          // or: freq.put(c, freq.getOrDefault(c, 0) + 1)
```

**Grouping:**

```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```

**Iteration** — use `entrySet()` when you need both key and value (one lookup instead of two):

```java
for (Map.Entry<String, Integer> e : map.entrySet())
    System.out.println(e.getKey() + " -> " + e.getValue());

map.forEach((k, v) -> ...);                  // Java 8
```

---

## HashSet

```java
Set<Integer> set = new HashSet<>(list);      // dedupe a list in one line
```

| Method | Notes |
|---|---|
| `add(e)` | returns **`false` if already present** — free duplicate detection |
| `contains(e)` / `remove(e)` | O(1) |
| `addAll(b)` / `retainAll(b)` / `removeAll(b)` | union / intersection / difference (mutate in place — copy first) |

**Seen-before pattern:**

```java
if (!seen.add(x)) return true;               // x is a duplicate
```

---

## Stack & ArrayDeque

Prefer `ArrayDeque` over legacy `java.util.Stack` (which is synchronized and slower).

```java
Deque<Integer> stack = new ArrayDeque<>();   // as stack (LIFO)
stack.push(x);    stack.pop();    stack.peek();    stack.isEmpty();

Queue<Integer> queue = new ArrayDeque<>();   // as queue (FIFO) — BFS
queue.offer(x);   queue.poll();   queue.peek();
```

| | Throws when empty | Returns `null` when empty |
|---|---|---|
| remove head | `pop()` / `remove()` | `poll()` |
| examine head | `element()` | `peek()` |

Prefer the `null`-returning versions in loop conditions: `while ((cur = queue.poll()) != null)`.

**Both ends** (sliding-window problems): `addFirst` / `addLast` / `pollFirst` / `pollLast` / `peekFirst` / `peekLast`.

**Trap:** `ArrayDeque` rejects `null` elements (`NullPointerException`).

---

## PriorityQueue (heap)

```java
Queue<Integer> minHeap = new PriorityQueue<>();                          // smallest first (default)
Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // largest first
Queue<int[]> byEnd = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
```

- `offer(e)` O(log n) · `poll()` O(log n) · `peek()` O(1)
- **Top-K pattern:** keep a min-heap of size K — `offer`, then `poll` when `size() > k`. The heap holds the K largest.
- **Traps:** iterating a `PriorityQueue` (or printing it) does **not** give sorted order — only repeated `poll()` does. Use `Integer.compare(a, b)`, never `(a - b)` (overflow).

---

## TreeMap / TreeSet (sorted)

```java
TreeMap<Integer, String> tm = new TreeMap<>();   // keys always sorted, ops O(log n)
```

| Method | Returns |
|---|---|
| `firstKey()` / `lastKey()` | min / max key |
| `floorKey(k)` / `ceilingKey(k)` | greatest key ≤ k / smallest key ≥ k (`null` if none) |
| `lowerKey(k)` / `higherKey(k)` | same but strict (< / >) |
| `headMap(k)` / `tailMap(k)` / `subMap(a, b)` | range views |
| `firstEntry()` / `pollFirstEntry()` | entry versions |

`TreeSet` mirrors these: `first()`, `last()`, `floor(e)`, `ceiling(e)`, `lower(e)`, `higher(e)`, `headSet`, `tailSet`.

Use for: "closest value ≤/≥ x", calendar/interval booking, anything needing sorted iteration while inserting.

---

## String & StringBuilder

**String** (immutable — every "modification" allocates a new string):

| Method | Notes |
|---|---|
| `charAt(i)` / `length()` | |
| `substring(i, j)` | end index **exclusive**; `substring(i)` to the end |
| `indexOf(x)` / `indexOf(x, from)` / `lastIndexOf(x)` | `-1` if absent |
| `toCharArray()` | for sorting or in-place two-pointer work |
| `split(regex)` | **regex!** dot is `split("\\.")`, pipe is `split("\\|")` |
| `String.join("-", parts)` | inverse of split |
| `equals` / `equalsIgnoreCase` | never `==` for content |
| `trim()` / `replace(a, b)` / `startsWith` / `endsWith` | |
| `String.valueOf(x)` / `Integer.parseInt(s)` | number ↔ string |

**char tricks:** `c - 'a'` → 0-25 index for count arrays (`new int[26]`); `Character.isDigit/isLetter/isLetterOrDigit/toLowerCase`.

**StringBuilder** — mandatory for building strings in loops (`String +=` in a loop is O(n²)):

| Method | Notes |
|---|---|
| `append(x)` | chains: `sb.append(a).append(b)` |
| `reverse()` | in place — palindrome checks |
| `insert(i, x)` / `deleteCharAt(i)` / `delete(i, j)` | |
| `setCharAt(i, c)` / `charAt(i)` / `length()` | |
| `setLength(0)` | fast clear for reuse |
| `toString()` | don't forget when returning |

---

## Arrays & Collections utilities

```java
import java.util.Arrays;     import java.util.Collections;
```

| Call | Notes |
|---|---|
| `Arrays.sort(arr)` | in place, ascending; `sort(arr, from, to)` for a range |
| `Arrays.sort(arr2d, (a, b) -> Integer.compare(a[0], b[0]))` | comparator needs **object** arrays (`int[][]`, `Integer[]` — not `int[]`) |
| `Arrays.binarySearch(arr, x)` | array must be sorted; negative result if absent |
| `Arrays.fill(arr, -1)` | DP / visited initialization |
| `Arrays.copyOf(arr, n)` / `copyOfRange(arr, i, j)` | end exclusive |
| `Arrays.toString(arr)` / `deepToString(arr2d)` | debug printing |
| `Arrays.equals(a, b)` | element-wise comparison (`==` compares references) |
| `Collections.sort(list)` / `sort(list, cmp)` | |
| `Collections.reverse(list)` / `reverseOrder()` | |
| `Collections.max(list)` / `min(list)` / `frequency(list, x)` / `swap(list, i, j)` | |

**Comparator building (Java 8):**

```java
list.sort(Comparator.comparing(String::length));                      // by one key
list.sort(Comparator.comparing(String::length).reversed());           // descending
list.sort(Comparator.comparing(String::length)
                    .thenComparing(Comparator.naturalOrder()));       // tie-breaker
```

---

## Conversions you always need mid-problem

| From → To | Code |
|---|---|
| `int[]` → `List<Integer>` | `Arrays.stream(arr).boxed().collect(Collectors.toList())` (or a for loop) — **not** `Arrays.asList(arr)`! |
| `List<Integer>` → `int[]` | `list.stream().mapToInt(Integer::intValue).toArray()` |
| `List<String>` → `String[]` | `list.toArray(new String[0])` |
| `String` → `char[]` → `String` | `s.toCharArray()` … `new String(chars)` (sorted-chars anagram key) |
| `List` ↔ `Set` | `new HashSet<>(list)` / `new ArrayList<>(set)` |
| array → fixed list | `Arrays.asList(a, b, c)` (no add/remove!) |

**Trap:** `Arrays.asList(intArray)` on an `int[]` gives a `List<int[]>` with one element, not a `List<Integer>` — primitives don't autobox inside arrays.

---

## Pre-assessment 60-second drill

1. Frequency map: `freq.merge(c, 1, Integer::sum)`
2. Grouping: `map.computeIfAbsent(k, x -> new ArrayList<>()).add(v)`
3. Stack/BFS queue: `ArrayDeque` with `push/pop` or `offer/poll`
4. Max-heap: `new PriorityQueue<>(Collections.reverseOrder())`
5. Duplicate check: `if (!set.add(x))`
6. `list.remove(index)` vs `list.remove(Integer.valueOf(element))`
7. `substring`/`copyOfRange`/`subList` — end index is always **exclusive**
8. `split("\\.")` — split takes a regex
9. Build strings with `StringBuilder`, never `+=` in a loop
10. Compare with `Integer.compare(a, b)`, never `a - b`
