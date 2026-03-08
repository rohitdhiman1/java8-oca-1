# 09 - Working with Selected Classes from the Java API

## String

### Immutability

`String` objects in Java are **immutable**. Once created, their value cannot be changed. Any operation that appears to modify a String actually creates a **new** String object.

```java
String s = "hello";
s.toUpperCase();          // returns "HELLO" but s is still "hello"
s = s.toUpperCase();      // now s points to the new "HELLO" String
```

### String Pool

Java maintains a **String pool** (intern pool) in the heap to optimize memory usage.

- String literals are automatically placed in the pool.
- `new String("hello")` creates a new object on the heap, bypassing the pool.
- `intern()` returns the pooled version of the String.

```java
String s1 = "hello";              // from pool
String s2 = "hello";              // same object from pool
String s3 = new String("hello");  // new object on heap

System.out.println(s1 == s2);      // true  (same pool reference)
System.out.println(s1 == s3);      // false (different objects)
System.out.println(s1.equals(s3)); // true  (same content)
```

### Common String Methods

| Method | Returns | Description |
|---|---|---|
| `length()` | `int` | Number of characters |
| `charAt(int index)` | `char` | Character at given index |
| `indexOf(String/char)` | `int` | First index of match, or -1 |
| `substring(int begin)` | `String` | From begin to end |
| `substring(int begin, int end)` | `String` | From begin to end (exclusive) |
| `trim()` | `String` | Removes leading and trailing whitespace |
| `replace(char old, char new)` | `String` | Replaces all occurrences |
| `contains(CharSequence)` | `boolean` | Whether the String contains the sequence |
| `startsWith(String)` | `boolean` | Whether the String starts with prefix |
| `endsWith(String)` | `boolean` | Whether the String ends with suffix |
| `equals(Object)` | `boolean` | Content equality |
| `equalsIgnoreCase(String)` | `boolean` | Content equality, case-insensitive |
| `toUpperCase()` | `String` | Uppercase version |
| `toLowerCase()` | `String` | Lowercase version |
| `concat(String)` | `String` | Appends the argument |

**Exam trap:** `substring(int begin, int end)` -- the `end` index is **exclusive**. `"hello".substring(1, 3)` returns `"el"`.

---

## StringBuilder

### Mutability

`StringBuilder` is **mutable**. Operations modify the same object in place and return a reference to itself, enabling method chaining.

```java
StringBuilder sb = new StringBuilder("hello");
sb.append(" world").append("!");   // sb is now "hello world!"
```

### Common StringBuilder Methods

| Method | Returns | Description |
|---|---|---|
| `append(any)` | `StringBuilder` | Adds to the end |
| `insert(int offset, any)` | `StringBuilder` | Inserts at the given position |
| `delete(int start, int end)` | `StringBuilder` | Deletes characters from start to end (exclusive) |
| `deleteCharAt(int index)` | `StringBuilder` | Deletes one character |
| `replace(int start, int end, String)` | `StringBuilder` | Replaces range with new String |
| `reverse()` | `StringBuilder` | Reverses the character sequence |
| `toString()` | `String` | Converts to an immutable String |
| `length()` | `int` | Number of characters |
| `charAt(int index)` | `char` | Character at given index |

### String vs StringBuilder vs StringBuffer

| Feature | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Mutable | No | Yes | Yes |
| Thread-safe | Yes (immutable) | No | Yes (synchronized) |
| Performance | Slow for many modifications | Fast (single-threaded) | Slower than StringBuilder (synchronization overhead) |
| Use when | Value does not change often | Many modifications, single thread | Many modifications, multiple threads |

**OCA note:** The OCA exam focuses on `String` and `StringBuilder`. `StringBuffer` may appear as a distractor.

---

## String Concatenation with `+`

Rules for the `+` operator:

1. If **both** operands are numeric, `+` performs addition.
2. If **either** operand is a `String`, `+` performs concatenation.
3. Evaluation proceeds **left to right**.

```java
System.out.println(1 + 2 + "3");       // "33"  (1+2=3, then "3"+"3")
System.out.println("1" + 2 + 3);       // "123" ("1"+"2"="12", then "12"+"3")
System.out.println("1" + (2 + 3));      // "15"  (parentheses force 2+3=5 first)
```

---

## Date and Time API (Java 8)

Java 8 introduced the `java.time` package. All date/time classes in this package are **immutable** and **thread-safe**.

### Core Classes

| Class | Stores | Example |
|---|---|---|
| `LocalDate` | Date only (year, month, day) | `2024-01-15` |
| `LocalTime` | Time only (hour, minute, second, nano) | `14:30:00` |
| `LocalDateTime` | Date and time | `2024-01-15T14:30:00` |

### Creating Instances

```java
// Current date/time
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();

// Specific values
LocalDate date = LocalDate.of(2024, Month.JANUARY, 15);
LocalDate date2 = LocalDate.of(2024, 1, 15);             // same as above
LocalTime time = LocalTime.of(14, 30, 0);
LocalDateTime dt = LocalDateTime.of(date, time);

// Parsing
LocalDate parsed = LocalDate.parse("2024-01-15");
```

**Exam trap:** There is no public constructor. You **must** use factory methods (`now()`, `of()`, `parse()`). Calling `new LocalDate()` will not compile.

### Manipulating Dates and Times

All manipulation methods return a **new** object (immutability).

```java
LocalDate date = LocalDate.of(2024, 1, 15);
LocalDate later = date.plusDays(10);        // 2024-01-25
LocalDate earlier = date.minusMonths(1);    // 2023-12-15

// Method chaining
LocalDateTime dt = LocalDateTime.now()
    .plusWeeks(1)
    .minusHours(3);
```

### Period and Duration

| Class | Used With | Measures |
|---|---|---|
| `Period` | `LocalDate`, `LocalDateTime` | Years, months, days |
| `Duration` | `LocalTime`, `LocalDateTime` | Hours, minutes, seconds, nanos |

```java
Period period = Period.ofYears(1);            // P1Y
Period period2 = Period.of(1, 6, 15);         // 1 year, 6 months, 15 days

LocalDate future = LocalDate.now().plus(period);

Duration duration = Duration.ofHours(3);
LocalTime later = LocalTime.now().plus(duration);
```

**Exam trap:** `Period.of(1, 2, 3)` represents 1 year, 2 months, 3 days -- not cumulative. `Period.ofMonths(15)` does **not** normalize to 1 year and 3 months.

### DateTimeFormatter

```java
LocalDate date = LocalDate.of(2024, 1, 15);

// Predefined formatters
String s1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);     // 2024-01-15

// Custom patterns
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String s2 = date.format(fmt);                                  // 15/01/2024

// Parsing with formatter
LocalDate parsed = LocalDate.parse("15/01/2024", fmt);
```

Common pattern symbols: `y` (year), `M` (month), `d` (day), `H` (hour 0-23), `h` (hour 1-12), `m` (minute), `s` (second).

---

## Lambda Expressions

A lambda expression is a concise way to represent an instance of a **functional interface** (an interface with exactly one abstract method).

### Syntax

```java
// Full form
(String s) -> { return s.length(); }

// Simplified forms
(s) -> s.length()       // type inference, single expression (no return/braces)
s -> s.length()         // single parameter: parentheses optional
() -> 42                // no parameters
(a, b) -> a + b         // multiple parameters
```

**Rules:**
- Parameter types can be inferred and omitted, but if you specify the type for one parameter, you must specify it for all.
- Parentheses are optional only when there is **exactly one** parameter with no explicit type.
- If the body is a single expression, braces and `return` are omitted.
- If the body uses braces, a `return` statement is required (for non-void methods), and a semicolon is required after the return statement.

### Functional Interfaces

A functional interface has exactly **one abstract method**. The `@FunctionalInterface` annotation is optional but recommended.

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

### Built-in Functional Interfaces (OCA-relevant)

| Interface | Abstract Method | Description | Example |
|---|---|---|---|
| `Predicate<T>` | `boolean test(T t)` | Takes one argument, returns boolean | `s -> s.isEmpty()` |
| `Consumer<T>` | `void accept(T t)` | Takes one argument, returns nothing | `s -> System.out.println(s)` |
| `Supplier<T>` | `T get()` | Takes nothing, returns a value | `() -> new ArrayList<>()` |
| `Function<T, R>` | `R apply(T t)` | Takes one argument, returns a value | `s -> s.length()` |

### Using Lambdas

```java
// With Predicate
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.removeIf(s -> s.length() < 4);    // removes "Bob"

// With Consumer
names.forEach(s -> System.out.println(s));

// With Comparator (functional interface)
names.sort((a, b) -> a.compareTo(b));
```

**Exam trap:** Lambdas can access local variables from the enclosing scope, but those variables must be **effectively final** (assigned only once).

```java
int x = 10;
Predicate<Integer> p = n -> n > x;   // valid -- x is effectively final
// x = 20;                            // if this line existed, the lambda above would not compile
```

---

## Source Code References

| Topic | File |
|---|---|
| String operations | [`StringHandling.java`](../com/oca/stringhandling/StringHandling.java) |
| Date and Time API | [`DateTimeAPI.java`](../com/oca/datetime/DateTimeAPI.java) |
| Lambdas and Functional Interfaces | [`LambdaAndFunctionalInterfaces.java`](../com/oca/lambdas/LambdaAndFunctionalInterfaces.java) |
