# OCA 1Z0-808 Mock Exam 2

**Time Limit:** 150 minutes
**Number of Questions:** 70
**Passing Score:** 65% (46 out of 70)

*This exam focuses on tricky edge cases and scenarios commonly encountered on the real exam.*

---

## Java Basics (Questions 1-8)

**Question 1**
What is the result of compiling and running this code?

```java
public class Main {
    static {
        System.out.print("1 ");
    }
    static {
        System.out.print("2 ");
    }
    {
        System.out.print("3 ");
    }
    {
        System.out.print("4 ");
    }
    public Main() {
        System.out.print("5 ");
    }
    public static void main(String[] args) {
        System.out.print("6 ");
        Main m = new Main();
        System.out.print("7 ");
    }
}
```

A. `1 2 6 3 4 5 7`  
B. `6 1 2 3 4 5 7`  
C. `1 2 3 4 5 6 7`  
D. `1 2 6 4 3 5 7`  
E. Compilation error  

---

**Question 2**
Which of the following are true about a Java source file? (Choose all that apply)

A. It can have multiple public classes  
B. It can have multiple non-public classes  
C. The file name must match the public class name  
D. If there is no public class, the file can have any name ending in `.java`  
E. A file with no class declarations will compile  

---

**Question 3**
What happens when you try to compile and run?

```java
public class Test {
    public static void main(String args) {
        System.out.println("Hello");
    }
}
```

A. Prints `Hello`  
B. Compilation error  
C. Compiles but throws `NoSuchMethodError` at runtime  
D. Compiles but prints nothing  
E. Compiles but throws `ClassNotFoundException`  

---

**Question 4**
What is the output?

```java
public class Shadowing {
    static int x = 10;
    int y = 20;

    public void method() {
        int x = 30;
        System.out.println(x + " " + this.x + " " + Shadowing.x);
    }

    public static void main(String[] args) {
        new Shadowing().method();
    }
}
```

A. `30 10 10`  
B. `30 30 10`  
C. Compilation error  
D. `10 10 10`  
E. `30 10 30`  

---

**Question 5**
What is the result?

```java
public class Comments {
    public static void main(String[] args) {
        // This is a comment \
        System.out.println("Line 1");
        System.out.println("Line 2");
    }
}
```

A. Prints `Line 1` and `Line 2`  
B. Prints only `Line 2`  
C. Compilation error  
D. Prints only `Line 1`  
E. No output  

---

**Question 6**
What is the output?

```java
public class Init {
    int x;
    int y = x + 1;

    public static void main(String[] args) {
        Init i = new Init();
        System.out.println(i.x + " " + i.y);
    }
}
```

A. `0 1`  
B. Compilation error - `x` not initialized  
C. `0 0`  
D. Runtime exception  
E. `null 1`  

---

**Question 7**
Given this code in a file called `Test.java`, what is the result?

```java
class Animal {}
class Dog extends Animal {}
public class Test {
    public static void main(String[] args) {
        System.out.println("OK");
    }
}
```

A. Prints `OK`  
B. Compilation error - multiple classes  
C. Compilation error - `Animal` and `Dog` must be in separate files  
D. Runtime exception  
E. Compilation error - `Animal` and `Dog` must be public  

---

**Question 8**
What is the output?

```java
public class Args {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);
    }
}
```
Run with: `java Args`

A. `0` then ArrayIndexOutOfBoundsException  
B. `0` then `null`  
C. Compilation error  
D. `1` then `Args`  
E. NullPointerException  

---

## Data Types (Questions 9-16)

**Question 9**
What is the output?

```java
public class StringPool {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hel" + "lo";
        String s3 = "Hel";
        String s4 = s3 + "lo";

        System.out.println(s1 == s2);
        System.out.println(s1 == s4);
        System.out.println(s1 == s4.intern());
    }
}
```

A. `true true true`  
B. `true false true`  
C. `true false false`  
D. `false false true`  
E. `true true false`  

---

**Question 10**
What is the output?

```java
public class StringImmutable {
    public static void main(String[] args) {
        String s = "Hello";
        s.concat(" World");
        s.toUpperCase();
        s.trim();
        System.out.println(s);
    }
}
```

A. `HELLO WORLD`  
B. `Hello World`  
C. `Hello`  
D. `HELLO`  
E. Compilation error  

---

**Question 11**
What is the output?

```java
public class SBTest {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

A. `false true true true`  
B. `false false true true`  
C. `true true true true`  
D. `false false false true`  
E. `false true false true`  

---

**Question 12**
What is the output?

```java
public class WrapperCompare {
    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        Integer c = Integer.valueOf(5);
        Integer d = Integer.valueOf(5);
        int e = 5;

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a == e);
    }
}
```

A. `false false true`  
B. `false true true`  
C. `true true true`  
D. `false false false`  
E. `false true false`  

---

**Question 13**
What is the output?

```java
public class CharTest {
    public static void main(String[] args) {
        char c1 = 65;
        char c2 = 'A' + 1;
        int i = 'A';
        System.out.println(c1 + " " + c2 + " " + i);
    }
}
```

A. `65 66 65`  
B. `A B 65`  
C. `A 66 A`  
D. `65 66 A`  
E. Compilation error  

---

**Question 14**
What is the output?

```java
public class Overflow {
    public static void main(String[] args) {
        short s = Short.MAX_VALUE;
        s = (short)(s + 1);
        System.out.println(s);

        int i = Integer.MAX_VALUE;
        i = i + 1;
        System.out.println(i);
    }
}
```

A. `32768` and `2147483648`  
B. `-32768` and `-2147483648`  
C. Compilation error  
D. Runtime exception - overflow  
E. `32767` and `2147483647`  

---

**Question 15**
What is the output?

```java
public class StringConcat {
    public static void main(String[] args) {
        String s = "abc";
        s += 1 + 2;
        System.out.println(s);

        String t = "abc" + 1 + 2;
        System.out.println(t);
    }
}
```

A. `abc3` and `abc12`  
B. `abc12` and `abc12`  
C. `abc3` and `abc3`  
D. `abc12` and `abc3`  
E. Compilation error  

---

**Question 16**
What is the output?

```java
public class SBChain {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("start");
        sb.append("1").append("2").delete(0, 5).insert(0, "X");
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
```

A. `X12` and `3`  
B. `Xstart12` and `8`  
C. `X12start` and `7`  
D. `12X` and `3`  
E. Compilation error  

---

## Operators and Decisions (Questions 17-24)

**Question 17**
What is the output?

```java
public class Tricky {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(x++ + ++x);
    }
}
```

A. 11  
B. 12  
C. 10  
D. 13  
E. 14  

---

**Question 18**
What is the output?

```java
public class SwitchString {
    public static void main(String[] args) {
        String s = "B";
        switch(s) {
            default: System.out.print("Default ");
            case "A": System.out.print("A ");
            case "B": System.out.print("B ");
                break;
            case "C": System.out.print("C ");
        }
    }
}
```

A. `B`  
B. `Default A B`  
C. `B C`  
D. `Default A B C`  
E. Compilation error  

---

**Question 19**
What is the output?

```java
public class SwitchFall {
    public static void main(String[] args) {
        final int x = 2;
        int y = 2;
        switch(y) {
            case x: System.out.print("Match ");
                break;
            default: System.out.print("Default ");
        }
    }
}
```

A. `Match`  
B. `Default`  
C. Compilation error - `x` is not a compile-time constant  
D. Compilation error - case labels must be literals  
E. `Match Default`  

---

**Question 20**
What is the output?

```java
public class BitOps {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011
        boolean x = true;
        boolean y = false;

        System.out.println(a & b);
        System.out.println(x | y);
        System.out.println(x & y);
    }
}
```

A. `1 true false`  
B. Compilation error  
C. `1 1 0`  
D. `5 true false`  
E. `1 true true`  

---

**Question 21**
What is the output?

```java
public class Assign {
    public static void main(String[] args) {
        int x;
        if (true)
            x = 5;
        System.out.println(x);
    }
}
```

A. 5  
B. 0  
C. Compilation error - `x` might not have been initialized  
D. Runtime exception  
E. Compilation error - other reason  

---

**Question 22**
What is the output?

```java
public class NaN {
    public static void main(String[] args) {
        double d = 0.0 / 0.0;
        System.out.println(d);
        System.out.println(d == d);
        System.out.println(Double.isNaN(d));
    }
}
```

A. ArithmeticException  
B. `NaN true true`  
C. `NaN false true`  
D. `Infinity true false`  
E. Compilation error  

---

**Question 23**
What is the output?

```java
public class Compound {
    public static void main(String[] args) {
        byte b = 10;
        b = b + 1;   // Line 1
        b += 1;       // Line 2
        b++;          // Line 3
        System.out.println(b);
    }
}
```

A. 13  
B. Compilation error at Line 1  
C. Compilation error at Line 2  
D. Compilation error at Line 3  
E. 12  

---

**Question 24**
What is the output?

```java
public class Nested {
    public static void main(String[] args) {
        int x = 10;
        int y = (x > 5) ? (x > 8 ? 1 : 2) : (x > 3 ? 3 : 4);
        System.out.println(y);
    }
}
```

A. 1  
B. 2  
C. 3  
D. 4  
E. Compilation error  

---

## Arrays (Questions 25-30)

**Question 25**
What is the output?

```java
public class ArrayRef {
    public static void modify(int[] arr) {
        arr = new int[]{10, 20, 30};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        modify(arr);
        System.out.println(arr[0]);
    }
}
```

A. 10  
B. 1  
C. 0  
D. NullPointerException  
E. Compilation error  

---

**Question 26**
What is the output?

```java
public class MultiDim {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4, 5}, {6}};
        int sum = 0;
        for (int[] row : arr) {
            for (int val : row) {
                sum += val;
            }
        }
        System.out.println(sum);
    }
}
```

A. 21  
B. 15  
C. 6  
D. ArrayIndexOutOfBoundsException  
E. Compilation error  

---

**Question 27**
What is the output?

```java
import java.util.Arrays;

public class ArrayCompare {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(Arrays.equals(a, b));
    }
}
```

A. `false false true`  
B. `false true true`  
C. `true true true`  
D. `false false false`  
E. Compilation error  

---

**Question 28**
What is the result?

```java
public class ArrayCast {
    public static void main(String[] args) {
        Object obj = new int[]{1, 2, 3};
        int[] arr = (int[]) obj;
        System.out.println(arr[1]);
    }
}
```

A. 2  
B. Compilation error  
C. ClassCastException  
D. ArrayIndexOutOfBoundsException  
E. 1  

---

**Question 29**
Which of the following compile? (Choose all that apply)

```java
// A
int[] a = new int[-1];

// B
int[][] b = new int[2][0];

// C
int[][] c = new int[0][];

// D
int[][][] d = new int[1][][];

// E
int[] e = new int[]{};
```

A. All of them  
B. B, C, D, E only  
C. All compile, but A throws exception at runtime  
D. B, D, E only  
E. None of them  

---

**Question 30**
What is the output?

```java
import java.util.Arrays;
import java.util.List;

public class ArraysList {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        List<String> list = Arrays.asList(arr);
        list.set(0, "X");
        System.out.println(arr[0]);
        list.add("D");
    }
}
```

A. `X` then UnsupportedOperationException  
B. `A` then UnsupportedOperationException  
C. `X` and the program completes normally  
D. Compilation error  
E. `A` and the program completes normally  

---

## Loop Constructs (Questions 31-36)

**Question 31**
What is the output?

```java
public class ForInit {
    public static void main(String[] args) {
        int i = 0;
        for (i++; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println(i);
    }
}
```

A. `1 2 3 4 5`  
B. `0 1 2 3 4 5`  
C. `1 2 3 4` then `5` on new line  
D. `1 2 3 4 5` on one line  
E. Compilation error  

---

**Question 32**
What is the output?

```java
public class ContinueLabel {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) continue outer;
                System.out.print(i + "" + j + " ");
            }
        }
    }
}
```

A. `00 01 10 11 20 21`  
B. `00 10 20`  
C. `00 02 10 12 20 22`  
D. `00 01 02 10 11 12 20 21 22`  
E. Compilation error  

---

**Question 33**
How many times does "Hello" print?

```java
public class DoWhile {
    public static void main(String[] args) {
        int x = 10;
        do {
            System.out.println("Hello");
            x++;
        } while (x < 5);
    }
}
```

A. 0 times  
B. 1 time  
C. 5 times  
D. Infinite loop  
E. Compilation error  

---

**Question 34**
What is the output?

```java
public class ForVar {
    public static void main(String[] args) {
        for (long i = 0; i < 3; i++) {
            System.out.print(i + " ");
        }
        // System.out.println(i); // Line 1
    }
}
```

A. `0 1 2` (Line 1 would cause error if uncommented)  
B. `0 1 2 3`  
C. Compilation error  
D. `0 1 2` then `3` from Line 1  
E. `0 1 2`  

---

**Question 35**
What is the output?

```java
public class InfiniteGuard {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ) {
            if (i == 5) break;
            i += 2;
            System.out.print(i + " ");
        }
    }
}
```

A. `2 4 6`  
B. `2 4`  
C. `0 2 4`  
D. Infinite loop  
E. `2 4 6 8 10`  

---

**Question 36**
What is the output?

```java
public class ReturnInLoop {
    public static int find() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find());
    }
}
```

A. 3  
B. -1  
C. 5  
D. 4  
E. Compilation error  

---

## Methods and Encapsulation (Questions 37-46)

**Question 37**
What is the output?

```java
public class PassRef {
    String name;

    public static void modify(PassRef obj) {
        obj.name = "Modified";
        obj = new PassRef();
        obj.name = "New";
    }

    public static void main(String[] args) {
        PassRef p = new PassRef();
        p.name = "Original";
        modify(p);
        System.out.println(p.name);
    }
}
```

A. `Original`  
B. `Modified`  
C. `New`  
D. NullPointerException  
E. Compilation error  

---

**Question 38**
What is the output?

```java
public class StringPass {
    public static void change(String s) {
        s = s + " World";
    }

    public static void change(StringBuilder sb) {
        sb.append(" World");
    }

    public static void main(String[] args) {
        String str = "Hello";
        StringBuilder sbr = new StringBuilder("Hello");
        change(str);
        change(sbr);
        System.out.println(str + " " + sbr);
    }
}
```

A. `Hello World Hello World`  
B. `Hello Hello World`  
C. `Hello World Hello`  
D. `Hello Hello`  
E. Compilation error  

---

**Question 39**
Which of the following compile? (Choose all that apply)

```java
public class Overload {
    // A
    public void m(int x, long y) {}
    // B
    public void m(long x, int y) {}
    // C
    public int m(int x, long y) { return 0; }
}
```

A. A and B together  
B. A and C together  
C. B and C together  
D. All three together  
E. None - all cause compilation errors  

---

**Question 40**
What is the output?

```java
public class StaticInit {
    static int x;

    static {
        x = 10;
        y = 20;
    }

    static int y;

    public static void main(String[] args) {
        System.out.println(x + " " + y);
    }
}
```

A. `10 20`  
B. Compilation error - `y` used before declaration  
C. `10 0`  
D. `0 20`  
E. `10 20` - static blocks can forward-reference for assignment  

---

**Question 41**
What is the output?

```java
public class WrapperPass {
    public static void change(Integer i) {
        i = i + 10;
    }

    public static void main(String[] args) {
        Integer x = 5;
        change(x);
        System.out.println(x);
    }
}
```

A. 15  
B. 5  
C. NullPointerException  
D. Compilation error  
E. 10  

---

**Question 42**
What is the output?

```java
public class Ambiguous {
    public static void print(int x, long y) {
        System.out.println("int, long");
    }
    public static void print(long x, int y) {
        System.out.println("long, int");
    }

    public static void main(String[] args) {
        print(5, 10);
    }
}
```

A. `int, long`  
B. `long, int`  
C. Compilation error - ambiguous method call  
D. Runtime exception  
E. `int, int`  

---

**Question 43**
What is the result?

```java
public class FinalMethod {
    public final void display() {
        System.out.println("Final method");
    }
}

class Child extends FinalMethod {
    public void display() {
        System.out.println("Child method");
    }
}
```

A. Prints `Child method`  
B. Prints `Final method`  
C. Compilation error - cannot override final method  
D. Runtime exception  
E. Both print  

---

**Question 44**
What is the output?

```java
public class Scope {
    private int x = 10;

    public void setX(int x) {
        x = x;
    }

    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        Scope s = new Scope();
        s.setX(20);
        System.out.println(s.getX());
    }
}
```

A. 20  
B. 10  
C. 0  
D. Compilation error  
E. NullPointerException  

---

**Question 45**
Which of the following are valid? (Choose all that apply)

```java
// A
public static final void main(String[] args) {}

// B
final public static void main(String[] args) {}

// C
static public void main(String[] args) {}

// D
public static void main(String... args) {}

// E
public static void main(String args[]) {}
```

A. All of them are valid entry points  
B. C, D, E only  
C. A, B, C, D, E are all valid  
D. D and E only  
E. C only  

---

**Question 46**
What is the output?

```java
public class ReturnVal {
    public static String method() {
        try {
            return "try";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
```

A. `try`  
B. `finally`  
C. `tryfinally`  
D. Compilation error  
E. Runtime exception  

---

## Inheritance (Questions 47-56)

**Question 47**
What is the output?

```java
class Animal {
    Animal() { System.out.print("Animal "); }
    Animal(String name) { this(); System.out.print(name + " "); }
}

class Dog extends Animal {
    Dog() { super("Buddy"); System.out.print("Dog "); }
}

public class Test {
    public static void main(String[] args) {
        new Dog();
    }
}
```

A. `Animal Buddy Dog`  
B. `Buddy Animal Dog`  
C. `Dog Buddy Animal`  
D. `Animal Dog`  
E. Compilation error  

---

**Question 48**
What is the result?

```java
class Parent {
    protected int x = 10;
    protected int getX() { return x; }
}

class Child extends Parent {
    protected int x = 20;

    public void test() {
        System.out.println(x);
        System.out.println(super.x);
        System.out.println(getX());
    }

    protected int getX() { return x; }
}

public class Test {
    public static void main(String[] args) {
        new Child().test();
    }
}
```

A. `20 10 20`  
B. `20 20 20`  
C. `10 10 10`  
D. `20 10 10`  
E. Compilation error  

---

**Question 49**
What is the result?

```java
interface Printable {
    default void print() {
        System.out.println("Printable");
    }
}

interface Showable {
    default void print() {
        System.out.println("Showable");
    }
}

class Display implements Printable, Showable {
    // no print() method defined
}

public class Test {
    public static void main(String[] args) {
        new Display().print();
    }
}
```

A. `Printable`  
B. `Showable`  
C. Compilation error  
D. Runtime exception  
E. No output  

---

**Question 50**
What is the output?

```java
class Base {
    void method() throws Exception {
        System.out.print("Base ");
    }
}

class Derived extends Base {
    void method() {
        System.out.print("Derived ");
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        Base b = new Derived();
        b.method();
    }
}
```

A. `Base`  
B. `Derived`  
C. Compilation error  
D. Runtime exception  
E. `Base Derived`  

---

**Question 51**
What is the output?

```java
class A {
    int x = 10;
    A() { printX(); }
    void printX() { System.out.println("A: " + x); }
}

class B extends A {
    int x = 20;
    void printX() { System.out.println("B: " + x); }
}

public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.printX();
    }
}
```

A. `A: 10` then `B: 20`  
B. `B: 0` then `B: 20`  
C. `B: 20` then `B: 20`  
D. `A: 10` then `A: 10`  
E. Compilation error  

---

**Question 52**
What is the result?

```java
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Dog);
        System.out.println(a instanceof Cat);
        System.out.println(a instanceof Object);
    }
}
```

A. `true true false true`  
B. `true true true true`  
C. `true false false true`  
D. Compilation error  
E. `true true` then ClassCastException  

---

**Question 53**
What is the result?

```java
abstract class Shape {
    int sides;
    abstract void draw();
    void info() { System.out.println("Shape with " + sides + " sides"); }
}

public class Test {
    public static void main(String[] args) {
        Shape s = new Shape() {
            { sides = 4; }
            void draw() { System.out.println("Drawing"); }
        };
        s.draw();
        s.info();
    }
}
```

A. `Drawing` then `Shape with 4 sides`  
B. Compilation error - cannot instantiate abstract class  
C. `Drawing` then `Shape with 0 sides`  
D. Runtime exception  
E. Compilation error - abstract method not implemented  

---

**Question 54**
What is the result?

```java
class Parent {
    static void greet() { System.out.println("Parent"); }
}

class Child extends Parent {
    static void greet() { System.out.println("Child"); }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.greet();
    }
}
```

A. `Child`  
B. `Parent`  
C. Compilation error  
D. Runtime exception  
E. `Parent` then `Child`  

---

**Question 55**
What is the result?

```java
class Animal {
    protected Animal create() {
        return new Animal();
    }
}

class Dog extends Animal {
    protected Dog create() {
        return new Dog();
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        System.out.println(a.create().getClass().getSimpleName());
    }
}
```

A. `Animal`  
B. `Dog`  
C. Compilation error - return type mismatch  
D. Runtime exception  
E. `Object`  

---

**Question 56**
What is the result?

```java
interface Walkable {
    void walk();
}

interface Swimmable {
    void swim();
}

abstract class Duck implements Walkable, Swimmable {
    public void walk() { System.out.println("Duck walks"); }
}

class MallardDuck extends Duck {
    public void swim() { System.out.println("Mallard swims"); }
}

public class Test {
    public static void main(String[] args) {
        Duck d = new MallardDuck();
        d.walk();
        d.swim();
    }
}
```

A. `Duck walks` then `Mallard swims`  
B. Compilation error - `Duck` must implement `swim()`  
C. Compilation error - `MallardDuck` must implement `walk()`  
D. Runtime exception  
E. `Duck walks` only  

---

## Exceptions (Questions 57-64)

**Question 57**
What is the output?

```java
public class ExFlow {
    public static void main(String[] args) {
        System.out.print("A ");
        try {
            System.out.print("B ");
            if (true) throw new RuntimeException();
            System.out.print("C ");
        } catch (RuntimeException e) {
            System.out.print("D ");
            return;
        } finally {
            System.out.print("E ");
        }
        System.out.print("F ");
    }
}
```

A. `A B D`  
B. `A B D E`  
C. `A B D E F`  
D. `A B C D E F`  
E. `A B D F`  

---

**Question 58**
What is the result?

```java
public class MultiCatch {
    public static void main(String[] args) {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException | IOException e) {
            System.out.println("Caught");
        }
    }
}
```

A. `Caught`  
B. Compilation error - `FileNotFoundException` is subclass of `IOException`  
C. Compilation error - missing import  
D. Runtime exception  
E. Both B and C  

---

**Question 59**
What is the result?

```java
public class ExOrder {
    public static void main(String[] args) {
        try {
            System.out.print("1 ");
            try {
                System.out.print("2 ");
                throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.print("3 ");
                throw new RuntimeException();
            } finally {
                System.out.print("4 ");
            }
        } catch (Exception e) {
            System.out.print("5 ");
        } finally {
            System.out.print("6 ");
        }
    }
}
```

A. `1 2 3 4 5 6`  
B. `1 2 3 5 6`  
C. `1 2 3 4 6`  
D. `1 2 3 6`  
E. `1 2 3 4`  

---

**Question 60**
What is the result?

```java
class CustomException extends RuntimeException {}
class SpecificException extends CustomException {}

public class Test {
    public static void method() throws CustomException {
        throw new SpecificException();
    }

    public static void main(String[] args) {
        try {
            method();
        } catch (CustomException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
```

A. `CustomException`  
B. `SpecificException`  
C. Compilation error  
D. Runtime exception - unhandled  
E. `RuntimeException`  

---

**Question 61**
What is the result?

```java
public class FinallyEx {
    public static void main(String[] args) {
        try {
            System.out.print("A ");
            System.exit(0);
            System.out.print("B ");
        } finally {
            System.out.print("C ");
        }
    }
}
```

A. `A C`  
B. `A B C`  
C. `A`  
D. `A B`  
E. Compilation error  

---

**Question 62**
Which are valid? (Choose all that apply)

```java
class Parent {
    void method() throws IOException {}
}

// A
class ChildA extends Parent {
    void method() throws Exception {}
}

// B
class ChildB extends Parent {
    void method() throws FileNotFoundException {}
}

// C
class ChildC extends Parent {
    void method() {}
}

// D
class ChildD extends Parent {
    void method() throws IOException, FileNotFoundException {}
}
```

A. B and C only  
B. B, C, and D  
C. All of them  
D. C only  
E. A, B, C, D - all valid  

---

**Question 63**
What is the output?

```java
public class TryReturn {
    static int x = 0;

    public static int method() {
        try {
            x = 1;
            return x;
        } finally {
            x = 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
        System.out.println(x);
    }
}
```

A. `1 2`  
B. `2 2`  
C. `1 1`  
D. `2 1`  
E. Compilation error  

---

**Question 64**
What is the result?

```java
public class Rethrow {
    public static void main(String[] args) {
        try {
            try {
                throw new Exception("inner");
            } catch (Exception e) {
                throw new RuntimeException("outer");
            } finally {
                System.out.print("finally ");
            }
        } catch (RuntimeException e) {
            System.out.print(e.getMessage());
        }
    }
}
```

A. `finally outer`  
B. `outer finally`  
C. `finally inner`  
D. `inner finally`  
E. Compilation error  

---

## Java API Classes (Questions 65-70)

**Question 65**
What is the output?

```java
import java.time.LocalDate;

public class DateMutate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 31);
        date = date.plusMonths(1);
        System.out.println(date);
    }
}
```

A. `2024-02-29`  
B. `2024-03-02`  
C. DateTimeException  
D. `2024-02-28`  
E. `2024-03-01`  

---

**Question 66**
What is the output?

```java
import java.util.ArrayList;

public class ListRemove {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(new Integer(2));
        System.out.println(list);
    }
}
```

A. `[1, 3]`  
B. `[1, 2]`  
C. `[2, 3]`  
D. Compilation error  
E. Runtime exception  

---

**Question 67**
What is the output?

```java
import java.time.LocalTime;

public class TimeTest {
    public static void main(String[] args) {
        LocalTime t = LocalTime.of(23, 59);
        t = t.plusMinutes(2);
        System.out.println(t);
    }
}
```

A. `00:01`  
B. DateTimeException  
C. `24:01`  
D. `23:61`  
E. Compilation error  

---

**Question 68**
What is the output?

```java
import java.util.ArrayList;
import java.util.List;

public class Diamond {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        Object obj = list.get(0);
        String str = list.get(0);
        System.out.println(obj + " " + str);
    }
}
```

A. Compilation error  
B. `Hello Hello`  
C. ClassCastException  
D. `Hello null`  
E. NullPointerException  

---

**Question 69**
What is the output?

```java
import java.time.Period;
import java.time.LocalDate;

public class PeriodChain {
    public static void main(String[] args) {
        Period p = Period.ofYears(1).ofMonths(2).ofDays(3);
        System.out.println(p);
    }
}
```

A. `P1Y2M3D`  
B. `P3D`  
C. `P1Y`  
D. `P2M`  
E. Compilation error  

---

**Question 70**
What is the output?

```java
import java.util.ArrayList;

public class AutoUnbox {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        int x = list.get(0);
        System.out.println(x);
    }
}
```

A. 0  
B. `null`  
C. NullPointerException  
D. Compilation error  
E. -1  

---

# Answer Key

1. **A** - Static initializers run in order first (`1 2`), then `main` starts (`6`), then instance initializers in order (`3 4`), then constructor (`5`), then rest of main (`7`).

2. **B, C, D** - A: only one public class per file. B: multiple non-public classes allowed. C: file must match public class name. D: if no public class, any valid name works. E: an empty file with no class won't compile as a valid Java source (actually it does compile in most compilers, but it produces no class file and is unusual - B, C, D are the safest correct answers).

3. **C** - The code compiles because `main(String args)` is a valid method. However, the JVM looks for `main(String[])` and cannot find it, so it throws `NoSuchMethodError` at runtime.

4. **A** - Local `x` is `30`. `this.x` refers to the static field `x` (accessible via `this` in instance context) which is `10`. `Shadowing.x` is the static field, `10`.

5. **A** - The `\` at the end of the comment line is just part of the comment in Java (Java does not support line continuation with backslash like C). Both lines execute normally.

6. **A** - Instance variable `x` is initialized to default value `0`. `y = x + 1 = 0 + 1 = 1`. Instance variables have default values unlike local variables.

7. **A** - Multiple non-public classes can exist in the same file. The file is named `Test.java` matching the public class. Everything compiles and runs.

8. **A** - When run without arguments, `args` is an empty array (length 0). `args[0]` throws `ArrayIndexOutOfBoundsException`.

9. **B** - `s1` and `s2` both resolve to the same pool string at compile time (concatenation of literals). `s4` is runtime concatenation (involves a variable), so it's a new object. `s4.intern()` returns the pool reference, matching `s1`.

10. **C** - Strings are immutable. `concat()`, `toUpperCase()`, and `trim()` all return new String objects. Since the results aren't assigned back, `s` remains `"Hello"`.

11. **B** - `StringBuilder` does not override `equals()` from `Object`, so `equals()` behaves like `==` (reference comparison). Both `==` and `equals()` are `false` for `sb1`/`sb2`. String pool makes `s1 == s2` true, and `equals()` compares content.

12. **B** - `new Integer(5)` always creates new objects, so `a == b` is `false`. `Integer.valueOf(5)` uses the cache (-128 to 127), so `c == d` is `true`. `a == e` unboxes `a` and compares values: `5 == 5` is `true`.

13. **B** - `char c1 = 65` assigns character 'A'. `char c2 = 'A' + 1` = character 'B' (compile-time constant fits in char). `int i = 'A'` stores 65 as int. `println` prints chars as characters and ints as numbers.

14. **B** - Integer overflow wraps around. `Short.MAX_VALUE + 1` overflows to `-32768`. `Integer.MAX_VALUE + 1` overflows to `-2147483648`. No runtime exception in Java for integer overflow.

15. **A** - In `s += 1 + 2`: the `1 + 2` is evaluated first (int addition = 3), then concatenated: `"abc3"`. In `"abc" + 1 + 2`: left-to-right string concatenation: `"abc1"` then `"abc12"`.

16. **A** - After `append("1").append("2")`: `"start12"`. `delete(0, 5)` removes indices 0-4: `"12"`. `insert(0, "X")`: `"X12"`. Length is 3.

17. **B** - `x++ = 5` (x becomes 6), `++x = 7` (x becomes 7). Sum: `5 + 7 = 12`.

18. **B** - Switch matches case `"B"` but there's no break, so... wait. Case `"B"` is matched, prints `B `, then break. Output is just `B`. Actually re-reading: `case "B"` prints `B ` and hits `break`. Answer is `B` only. But wait, looking at the answer choices - the switch matches `"B"`, prints `B `, encounters `break`, and exits. The answer is not in the listed options exactly. Let me re-read: the answer should just be `B`. Looking at the choices: A is `B`. Answer is **A**.

19. **A** - `final int x = 2` is a compile-time constant (final, initialized with literal). It can be used as a case label. `y` matches `x` (both 2). Output: `Match`.

20. **A** - `&` on ints is bitwise AND: `5 & 3 = 0101 & 0011 = 0001 = 1`. `|` and `&` on booleans perform logical OR and AND. `true | false = true`, `true & false = false`.

21. **A** - The compiler can determine that `if (true)` always executes, so `x` is definitely assigned. This compiles and prints `5`.

22. **C** - `0.0 / 0.0` produces `NaN` (not an exception for floating point). `NaN` is not equal to anything, including itself (`d == d` is `false`). `Double.isNaN(d)` returns `true`.

23. **B** - `b + 1` produces an `int` result. Assigning `int` to `byte` without cast is a compilation error. `+=` and `++` include implicit casting, so Lines 2 and 3 are fine.

24. **A** - `x > 5` is `true`, so evaluate `(x > 8 ? 1 : 2)`. `x > 8` is `true` (10 > 8), so `y = 1`.

25. **B** - `modify()` receives a copy of the reference. Reassigning the parameter to a new array doesn't affect the caller's reference. The original array is unchanged. `arr[0]` is still `1`.

26. **A** - `1+2+3+4+5+6 = 21`. Jagged arrays work fine with enhanced for loops.

27. **A** - Arrays don't override `equals()` from `Object`, so `a.equals(b)` is the same as `a == b` (reference comparison), which is `false`. `Arrays.equals()` compares element by element: `true`.

28. **A** - An `int[]` can be assigned to `Object`. Casting it back to `int[]` works fine. `arr[1]` is `2`.

29. **C** - All compile. `new int[-1]` compiles but throws `NegativeArraySizeException` at runtime. Zero-length arrays are valid. Partially specified multidimensional arrays are valid.

30. **A** - `Arrays.asList()` returns a fixed-size list backed by the array. `set()` modifies both list and array. `add()` throws `UnsupportedOperationException` because the list is fixed-size. `arr[0]` becomes `"X"` before the exception.

31. **C** - The init expression `i++` runs first: i becomes 1. Loop: 1, 2, 3, 4 are printed. When i reaches 5, condition fails. `println(i)` prints 5 on a new line (because it's `println` vs `print` in the loop).

32. **B** - When `j == 1`, `continue outer` skips the rest of the inner loop and continues with the next outer iteration. Only `j == 0` values are printed for each `i`: `00 10 20`.

33. **B** - A `do-while` loop always executes the body at least once. `x = 10`, body runs once, then condition `x < 5` is `false` (x is now 11). Prints once.

34. **A** - `i` is declared inside the for loop, so it's not accessible outside. If Line 1 were uncommented, it would cause a compilation error. The loop prints `0 1 2`.

35. **B** - i starts at 0. Iteration 1: `i != 5`, `i += 2` (i=2), print `2`. Iteration 2: `i != 5`, `i += 2` (i=4), print `4`. Iteration 3: `i != 5`, `i += 2` (i=6), print `6`. Wait: condition is `i < 10`. i=0: not 5, i becomes 2, print 2. i=2: not 5, i becomes 4, print 4. i=4: not 5, i becomes 6, print 6. i=6: not 5, i becomes 8, print 8. i=8: not 5, i becomes 10, print 10. i=10: `10 < 10` is false, exit. Output: `2 4 6 8 10`. That's answer E. Wait let me re-read. `for (int i = 0; i < 10; )` - no increment in for. Body: check `i == 5`, if so break. Else `i += 2`, print. So: i=0, not 5, i=2, print 2. i=2, not 5, i=4, print 4. i=4, not 5, i=6, print 6. i=6, not 5, i=8, print 8. i=8, not 5, i=10, print 10. Now condition: 10 < 10 = false, exit. Output: `2 4 6 8 10`. Answer **E**.

36. **A** - When `i == 3`, `return i` exits the method returning 3.

37. **B** - `modify()` first changes `obj.name` to `"Modified"` (this affects the original object). Then `obj` is reassigned to a new object (only the local reference changes). The original `p` still points to the object with name `"Modified"`.

38. **B** - String is immutable and passed by value. The reassignment in `change(String)` doesn't affect the caller. StringBuilder is mutable; `append()` modifies the same object. Output: `Hello Hello World`.

39. **A** - A and B have different parameter lists `(int, long)` vs `(long, int)`, so they're valid overloads. C has the same parameters as A `(int, long)` but different return type, which is not a valid overload. A and B together compile; adding C causes error.

40. **A** - Static initializers can assign to static fields declared later (forward reference for writing is allowed). Both `x` and `y` get their values. Output: `10 20`.

41. **B** - `Integer` is immutable. `i + 10` creates a new `Integer` object assigned to the local parameter `i`. The caller's reference `x` is unchanged. Output: `5`.

42. **C** - Both `int` arguments can be widened to `long` for either parameter position. The compiler cannot determine which method is more specific. Ambiguous method call error.

43. **C** - `final` methods cannot be overridden. Attempting to override `display()` in `Child` causes a compilation error.

44. **B** - In `setX`, `x = x` assigns the parameter to itself (shadowing). The instance variable `this.x` is never modified. It remains `10`.

45. **A** - All five are valid `main` method signatures. `final` doesn't affect the method being an entry point. Order of modifiers doesn't matter. Both `String[]` and `String...` are accepted.

46. **B** - The `finally` block's `return` overrides the `try` block's `return`. Method returns `"finally"`.

47. **A** - `new Dog()` calls `super("Buddy")` which calls `this()` in `Animal` (no-arg constructor prints `Animal `), then continues `Animal(String)` printing `Buddy `, then `Dog()` prints `Dog `.

48. **A** - `x` prints `20` (Child's field). `super.x` prints `10` (Parent's field). `getX()` calls Child's override returning Child's `x` = `20`.

49. **C** - When two interfaces provide the same default method, the implementing class must override it to resolve the conflict. Without an override, compilation fails.

50. **B** - An overriding method can declare fewer exceptions. `Derived.method()` doesn't throw any exception, which is valid. At runtime, `Dog`'s version is called polymorphically. Output: `Derived`.

51. **B** - When `new B()` is created, `A`'s constructor runs first and calls `printX()`. Due to polymorphism, `B.printX()` is called. But `B`'s field `x` hasn't been initialized yet (still `0`), so it prints `B: 0`. Then `B`'s `x` is set to `20`. The second call `a.printX()` prints `B: 20`.

52. **A** - `a` is a `Dog` at runtime. `instanceof Animal` is `true` (Dog extends Animal). `instanceof Dog` is `true`. `instanceof Cat` is `false` (Dog is not Cat). `instanceof Object` is `true`.

53. **A** - Anonymous inner classes can extend abstract classes if they implement all abstract methods. The anonymous class implements `draw()` and initializes `sides` to 4. Both method calls work.

54. **B** - Static methods are not polymorphic. They are resolved at compile time based on the reference type (`Parent`). `Parent.greet()` is called.

55. **B** - Covariant return types allow `Dog` to return `Dog` instead of `Animal`. At runtime, `Dog.create()` is called due to polymorphism, returning a `Dog`. `getClass().getSimpleName()` returns `"Dog"`.

56. **A** - `Duck` is abstract so it doesn't need to implement all interface methods. It implements `walk()`. `MallardDuck` (concrete) implements `swim()` and inherits `walk()`. Both methods work.

57. **B** - `A` prints, try block: `B` prints, exception thrown (C is skipped), catch: `D` prints, `return` is queued, but `finally` always runs: `E` prints. Then `return` executes (F is skipped).

58. **E** - Two issues: `FileNotFoundException` is a subclass of `IOException` which is invalid in multi-catch, AND both need to be imported (`java.io`). Both B and C are correct.

59. **A** - Inner try: `1 2`, exception thrown, caught: `3`, new exception thrown, inner finally: `4`, outer catch catches new exception: `5`, outer finally: `6`. Output: `1 2 3 4 5 6`.

60. **B** - `SpecificException` is thrown, caught by `catch(CustomException)` since it's a subclass. `getClass().getSimpleName()` returns the actual runtime class name: `"SpecificException"`.

61. **C** - `System.exit(0)` terminates the JVM immediately. The `finally` block does NOT execute when the JVM is terminated. Only `A` is printed.

62. **B** - A: Cannot throw broader exception (`Exception` is broader than `IOException`). B: `FileNotFoundException` is a subclass of `IOException` (narrower is OK). C: no exception is valid (narrower). D: `FileNotFoundException` is already a subclass of `IOException`, so this is effectively just `IOException` (valid).

63. **A** - `return x` captures the value of `x` (which is `1`) to return. The `finally` block then sets `x = 2`, but the return value was already captured. Method returns `1`. After the call, `x` is `2`.

64. **A** - Inner catch throws `RuntimeException("outer")`. Inner finally prints `finally `. Outer catch catches it and prints `outer`. Output: `finally outer`.

65. **A** - 2024 is a leap year, so January 31 plus 1 month adjusts to February 29 (the last valid day in February 2024).

66. **A** - `list.remove(new Integer(2))` calls `remove(Object)`, which removes the first occurrence of the value `2`. Result: `[1, 3]`.

67. **A** - `LocalTime` wraps around midnight. `23:59 + 2 minutes = 00:01`.

68. **B** - `list.get(0)` returns `"Hello"`. Assigning to `Object` or `String` both work. Output: `Hello Hello`.

69. **B** - `Period.ofYears(1)` returns a Period, but `.ofMonths(2)` is a static method call that creates a NEW Period (ignoring the previous one). Then `.ofDays(3)` again creates a NEW Period. Only the last one (`P3D`) is assigned to `p`.

70. **C** - `list.get(0)` returns `null` (the `Integer` null). Unboxing `null` to `int` throws `NullPointerException`.
