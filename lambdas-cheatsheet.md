# Java Lambdas — Quick Reference

> **Runnable companions:** [LambdaAndFunctionalInterfaces.java](com/oca/lambdas/LambdaAndFunctionalInterfaces.java) and [LambdaVsAnonymousClass.java](com/oca/lambdas/LambdaVsAnonymousClass.java) — run them to see every rule below in action.

## 1. Core Mental Model

> A lambda expression provides an implementation of the SAM (Single Abstract Method) of a functional interface.

```java
Calculator c = (a, b) -> a + b;
```

- `Calculator` → functional interface / target type
- `c` → reference variable
- `(a, b) -> a + b` → lambda expression
- `calculate(int a, int b)` → SAM
- `c` refers to the lambda's runtime representation/object

---

## 2. Functional Interface

A functional interface has **exactly one abstract method**.

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

In an interface, an abstract method does **not** need the `abstract` keyword:

```java
int calculate(int a, int b);
```

is implicitly:

```java
public abstract int calculate(int a, int b);
```

---

## 3. Lambda Syntax

### No parameters

```java
() -> "Hello"
```

### One parameter

Parentheses are optional when the type is inferred:

```java
x -> x * 2
```

or:

```java
(x) -> x * 2
```

### Multiple parameters

Parentheses are mandatory:

```java
(a, b) -> a + b
```

### Explicit parameter types

Either infer **all** types:

```java
(a, b) -> a + b
```

or specify **all**:

```java
(int a, int b) -> a + b
```

Cannot mix:

```java
(double a, b) -> a + b  // ❌
```

---

## 4. Expression Body vs Block Body

### Expression body → implicit return

```java
x -> x * 2
```

If the SAM returns a value, the expression's result is returned automatically.

### Block body → explicit `return`

```java
x -> {
    return x * 2;
}
```

If the SAM returns `void`:

```java
x -> {
    System.out.println(x);
}
```

No `return` is required.

---

## 5. Target Typing ⭐

Java needs to know **which functional interface the lambda is targeting**.

This works:

```java
Comparator<String> c =
    (s1, s2) -> s1.length() - s2.length();
```

because `c` provides the target type.

This also works:

```java
words.sort(
    (s1, s2) -> s1.length() - s2.length()
);
```

because `sort()` expects a `Comparator`.

This does NOT work:

```java
System.out.println(x -> x * 2);
```

because `println()` does not provide a functional-interface target type for the lambda.

> **A lambda needs a target functional-interface type.**

---

## 6. Four Common Functional Interfaces

| Interface | Shape | SAM |
|---|---|---|
| `Predicate<T>` | `T → boolean` | `boolean test(T t)` |
| `Function<T,R>` | `T → R` | `R apply(T t)` |
| `Consumer<T>` | `T → void` | `void accept(T t)` |
| `Supplier<T>` | `() → T` | `T get()` |

Examples:

```java
Predicate<Integer> p = n -> n % 2 == 0;

Function<Integer, String> f = n -> "Number " + n;

Consumer<String> c = s -> System.out.println(s);

Supplier<Integer> s = () -> 42;
```

---

## 7. Lambda vs Anonymous Class

### Lambda

```java
Runnable r = () -> System.out.println("Hi");
```

- Provides behavior for a functional interface's SAM.
- Does **not** introduce its own `this`.
- `this` inside the lambda refers to the **enclosing instance**.
- Can capture local variables only when they are `final` or **effectively final**.

### Anonymous class

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hi");
    }
};
```

- Creates a one-off anonymous class/object.
- Has its **own `this`**.
- `this` inside the anonymous class refers to the anonymous object.
- Can define fields and additional methods.

### Key distinction

```text
Lambda:
reference ──→ lambda runtime representation
this inside lambda ──→ enclosing object

Anonymous class:
reference ──→ anonymous object
this inside class ──→ anonymous object
```

---

## 8. Variable Capture

A lambda can capture a local variable:

```java
int number = 10;

Runnable r = () -> System.out.println(number);
```

The captured variable must be:

- `final`, OR
- **effectively final** (assigned once and never reassigned)

This does NOT compile:

```java
int number = 10;

Runnable r = () -> System.out.println(number);

number = 20;  // ❌
```

### Object mutation vs reassignment

```java
List<String> list = new ArrayList<>();

Runnable r = () -> list.add("Hello");  // ✅
```

Modifying the object is allowed.

Reassigning the reference is not:

```java
list = new ArrayList<>();  // ❌ if list is captured
```

---

## 9. Method References

A method reference is mainly **syntactic sugar** for a lambda that directly delegates to an existing method.

```java
name -> System.out.println(name)
```

can become:

```java
System.out::println
```

The `::` is the **method reference operator**.

---

## 10. Comparator Example — Put It All Together

```java
List<String> words =
    Arrays.asList("cherry", "BANANA", "kiwi", "Apple");

words.sort(
    (s1, s2) -> Integer.compare(s1.length(), s2.length())
);
```

Mental expansion:

```text
words.sort(...)
      ↓
sort() expects Comparator
      ↓
lambda target type = Comparator<String>
      ↓
Comparator SAM = compare(String, String)
      ↓
lambda provides implementation
      ↓
compare(s1, s2)
      ↓
Integer.compare(...)
```

---

# ⭐ Rules Worth Memorising

1. **Lambda → implementation of a functional interface's SAM.**
2. **A lambda needs a target type.**
3. **One inferred parameter → parentheses optional.**
4. **Multiple parameters → parentheses required.**
5. **Explicit parameter types → specify them for all parameters.**
6. **Expression body → implicit return.**
7. **Block body `{}` → explicit `return` when a value is required.**
8. **Captured local variables → final or effectively final.**
9. **Lambda `this` → enclosing instance.**
10. **Anonymous-class `this` → anonymous object.**
11. **`Predicate` → boolean, `Function` → value, `Consumer` → void, `Supplier` → value with no input.**
12. **Method references (`::`) → shorthand when an existing method already matches the required functional-interface behavior.**
