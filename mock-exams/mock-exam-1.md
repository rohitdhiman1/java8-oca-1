# OCA 1Z0-808 Mock Exam 1

**Time Limit:** 150 minutes
**Number of Questions:** 70
**Passing Score:** 65% (46 out of 70)

---

## Java Basics (Questions 1-8)

**Question 1**
What is the output of the following code?

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello" + 3 + 7);
        System.out.println(3 + 7 + "Hello");
    }
}
```

A. `Hello37` and `37Hello`  
B. `Hello10` and `10Hello`  
C. `Hello37` and `10Hello`  
D. `Hello10` and `37Hello`  
E. Compilation error  

---

**Question 2**
Which of the following are valid Java identifiers? (Choose all that apply)

A. `_myVar`  
B. `2ndValue`  
C. `$amount`  
D. `class`  
E. `my-var`  
F. `PUBLIC`  

---

**Question 3**
What is the result of compiling and running the following code?

```java
package com.exam;

public class Test {
    static int x = 10;

    public static void main(String[] args) {
        int x = 20;
        System.out.println(x);
    }
}
```

A. 10  
B. 20  
C. Compilation error due to duplicate variable name  
D. Runtime exception  

---

**Question 4**
Which of the following statements about the `main` method are true? (Choose all that apply)

A. The `main` method must be declared `public`  
B. The `main` method must be declared `static`  
C. The `main` method must return `void`  
D. The parameter can be declared as `String... args`  
E. The parameter can be declared as `String args[]`  
F. All of the above  

---

**Question 5**
What happens when you compile and run the following code?

```java
public class Init {
    static { System.out.print("A "); }
    { System.out.print("B "); }

    public Init() { System.out.print("C "); }

    public static void main(String[] args) {
        System.out.print("D ");
        new Init();
        System.out.print("E ");
        new Init();
    }
}
```

A. `A D B C E B C`  
B. `D A B C E B C`  
C. `A B C D B C E`  
D. `A D B C E A B C`  
E. Compilation error  

---

**Question 6**
Which of the following statements about Java packages are true? (Choose all that apply)

A. The `java.lang` package is automatically imported  
B. Importing `java.util.*` also imports `java.util.concurrent.*`  
C. You can import a class with two different import statements without error  
D. A class in the default package can be imported by other packages  
E. The `package` statement must be the first non-comment line in a source file  

---

**Question 7**
What is the output?

```java
public class Scope {
    static int x = 5;

    public static void main(String[] args) {
        int x = 10;
        {
            int y = 20;
            System.out.println(x + y);
        }
        // System.out.println(y); // Line 1
        System.out.println(x);
    }
}
```

A. `30` then `10`  
B. `30` then `5`  
C. `25` then `5`  
D. Compilation error  
E. `30` then `10` (Line 1 would cause error if uncommented)  

---

**Question 8**
Given the following file structure, which compiles successfully?

```
// File: Animal.java
package zoo;
public class Animal {
    String name = "Generic";
}

// File: Zoo.java
package zoo.exhibit;
// INSERT CODE HERE
public class Zoo {
    public static void main(String[] args) {
        Animal a = new Animal();
    }
}
```

A. `import zoo;`  
B. `import zoo.Animal;`  
C. `import zoo.exhibit.Animal;`  
D. `import zoo.*;`  
E. Both B and D  

---

## Data Types (Questions 9-16)

**Question 9**
What is the output of the following code?

```java
public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }
}
```

A. `true true true`  
B. `true false true`  
C. `false false true`  
D. `true false false`  
E. `false true true`  

---

**Question 10**
Which of the following are valid declarations? (Choose all that apply)

A. `int x = 0b1010;`  
B. `int y = 0xFACE;`  
C. `int z = 09;`  
D. `long w = 3_000_000L;`  
E. `double d = 1_000_.50;`  
F. `int a = 0_7;`  

---

**Question 11**
What is the output?

```java
public class Wrapper {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;

        System.out.println(a == b);
        System.out.println(c == d);
    }
}
```

A. `true true`  
B. `false false`  
C. `true false`  
D. `false true`  
E. Compilation error  

---

**Question 12**
What is the output?

```java
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.delete(7, 8);
        System.out.println(sb);
    }
}
```

A. `Hello,World`  
B. `Hello, orld`  
C. `Hello,orld`  
D. `Hello, World`  
E. `Hello,Wrld`  

---

**Question 13**
What is the result?

```java
public class Casting {
    public static void main(String[] args) {
        byte b = 127;
        b++;
        System.out.println(b);
    }
}
```

A. 128  
B. -128  
C. 0  
D. Compilation error  
E. Runtime exception  

---

**Question 14**
Which of the following compile? (Choose all that apply)

```java
// A
float f1 = 3.14;

// B
float f2 = 3.14f;

// C
char c1 = 'A' + 1;

// D
byte b1 = 100 + 27;

// E
byte b2 = 100 + 28;
```

A. Only B  
B. B and C  
C. B, C, and D  
D. B, C, D, and E  
E. All of them  

---

**Question 15**
What is the output?

```java
public class StringMethods {
    public static void main(String[] args) {
        String s = "Java Programming";
        System.out.println(s.substring(5, 8));
        System.out.println(s.indexOf('a', 3));
        System.out.println(s.replace('a', 'o'));
    }
}
```

A. `Pro`, `3`, `Jovo Progromming`  
B. `Pro`, `3`, `Java Programming`  
C. `rog`, `3`, `Jovo Progromming`  
D. `Pro`, `14`, `Jovo Progromming`  
E. `Prog`, `3`, `Jovo Progromming`  

---

**Question 16**
What is the output?

```java
public class NullString {
    public static void main(String[] args) {
        String s = null;
        s += "Hello";
        System.out.println(s);
    }
}
```

A. `Hello`  
B. `nullHello`  
C. NullPointerException  
D. Compilation error  
E. An empty string followed by `Hello`  

---

## Operators and Decisions (Questions 17-24)

**Question 17**
What is the output?

```java
public class Operators {
    public static void main(String[] args) {
        int x = 5;
        int y = x++ + ++x + x++;
        System.out.println(x + " " + y);
    }
}
```

A. `8 19`  
B. `7 18`  
C. `8 18`  
D. `8 21`  
E. `7 19`  

---

**Question 18**
What is the output?

```java
public class Ternary {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int z = x > y ? x++ : y++;
        System.out.println(x + " " + y + " " + z);
    }
}
```

A. `5 11 10`  
B. `6 10 5`  
C. `5 10 10`  
D. `6 11 10`  
E. `5 11 11`  

---

**Question 19**
What is the output?

```java
public class SwitchTest {
    public static void main(String[] args) {
        int x = 2;
        switch(x) {
            case 1: System.out.print("A ");
            case 2: System.out.print("B ");
            case 3: System.out.print("C ");
            default: System.out.print("D ");
        }
    }
}
```

A. `B`  
B. `B C`  
C. `B C D`  
D. `B D`  
E. `A B C D`  

---

**Question 20**
Which of the following are valid switch variable types in Java 8? (Choose all that apply)

A. `byte`  
B. `long`  
C. `String`  
D. `char`  
E. `boolean`  
F. `int`  

---

**Question 21**
What is the output?

```java
public class ShortCircuit {
    public static void main(String[] args) {
        int x = 0;
        boolean result = (x != 0) && (10 / x > 1);
        System.out.println(result);
    }
}
```

A. `false`  
B. `true`  
C. ArithmeticException  
D. Compilation error  
E. `0`  

---

**Question 22**
What is the output?

```java
public class IfElse {
    public static void main(String[] args) {
        int x = 10;
        if (x > 5)
            if (x > 20)
                System.out.println("A");
        else
            System.out.println("B");
    }
}
```

A. `A`  
B. `B`  
C. No output  
D. Compilation error  
E. `A` and `B`  

---

**Question 23**
What is the output?

```java
public class Equality {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        System.out.println(a = b);
        System.out.println(a);
    }
}
```

A. `false false`  
B. `true false`  
C. `false true`  
D. `true true`  
E. Compilation error  

---

**Question 24**
What is the output?

```java
public class Precedence {
    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        int z = x * y + y * ++x - x;
        System.out.println(z);
    }
}
```

A. 12  
B. 15  
C. 14  
D. 18  
E. 11  

---

## Arrays (Questions 25-30)

**Question 25**
Which of the following array declarations are valid? (Choose all that apply)

A. `int[] arr = new int[3]{1, 2, 3};`  
B. `int[] arr = {1, 2, 3};`  
C. `int arr[] = new int[]{1, 2, 3};`  
D. `int[] arr = new int[3];`  
E. `int[] arr; arr = {1, 2, 3};`  

---

**Question 26**
What is the output?

```java
import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5};
        int[] b = a;
        Arrays.sort(b);
        System.out.println(a[0] + " " + a[4]);
    }
}
```

A. `3 5`  
B. `1 5`  
C. `1 4`  
D. `3 1`  
E. ArrayIndexOutOfBoundsException  

---

**Question 27**
What is the output?

```java
public class MultiArray {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{3, 4, 5};
        arr[2] = new int[]{6};

        System.out.println(arr.length);
        System.out.println(arr[1].length);
    }
}
```

A. `3` and `3`  
B. `3` and `2`  
C. `6` and `3`  
D. `3` and `5`  
E. Compilation error  

---

**Question 28**
What is the output?

```java
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 3};
        System.out.println(Arrays.binarySearch(arr, 5));
    }
}
```

A. 1  
B. -1  
C. The result is undefined  
D. 2  
E. ArrayIndexOutOfBoundsException  

---

**Question 29**
What is the output?

```java
public class ArrayInit {
    public static void main(String[] args) {
        String[] arr = new String[3];
        System.out.println(arr[0]);

        int[] nums = new int[2];
        System.out.println(nums[0]);

        boolean[] flags = new boolean[1];
        System.out.println(flags[0]);
    }
}
```

A. `null`, `0`, `false`  
B. `""`, `0`, `false`  
C. NullPointerException  
D. `null`, `null`, `null`  
E. Compilation error  

---

**Question 30**
What is the output?

```java
public class ArrayCast {
    public static void main(String[] args) {
        Object[] objs = new String[3];
        objs[0] = "Hello";
        objs[1] = new StringBuilder("World");
        System.out.println(objs[0]);
    }
}
```

A. `Hello`  
B. Compilation error  
C. ArrayStoreException at runtime  
D. NullPointerException  
E. `Hello` then exception at `objs[1]`  

---

## Loop Constructs (Questions 31-36)

**Question 31**
What is the output?

```java
public class ForLoop {
    public static void main(String[] args) {
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.print(i + " ");
        }
    }
}
```

A. `0 1 2 3 4`  
B. `0 1 2 3 4 5`  
C. `0 1 2 3 4 5 6 7 8 9`  
D. Infinite loop  
E. Compilation error  

---

**Question 32**
What is the output?

```java
public class BreakLabel {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) break outer;
                System.out.print(i + "" + j + " ");
            }
        }
    }
}
```

A. `00 01 02 10`  
B. `00 01 02 10 11`  
C. `00 01 02 10 12 20 21 22`  
D. `00 01 02`  
E. Compilation error  

---

**Question 33**
What is the output?

```java
public class WhileTest {
    public static void main(String[] args) {
        int x = 0;
        do {
            x++;
            if (x == 3) continue;
            System.out.print(x + " ");
        } while (x < 5);
    }
}
```

A. `1 2 4 5`  
B. `1 2 3 4 5`  
C. `1 2 4`  
D. `0 1 2 4 5`  
E. Infinite loop  

---

**Question 34**
What is the output?

```java
public class ForEach {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        for (String s : arr) {
            s = "X";
        }
        System.out.println(arr[0] + arr[1] + arr[2]);
    }
}
```

A. `XXX`  
B. `ABC`  
C. Compilation error  
D. NullPointerException  
E. `XBC`  

---

**Question 35**
Which of the following will compile? (Choose all that apply)

```java
// A
for ( ; ; ) { break; }

// B
for (int i = 0; ; i++) { break; }

// C
while (false) { System.out.println("Hi"); }

// D
do { break; } while (true);

// E
for (int i = 0; i < 10; ) { i++; }
```

A. All of them  
B. A, B, D, E only  
C. A, B, C, D, E  
D. A, B, D only  
E. B, D, E only  

---

**Question 36**
What is the output?

```java
public class NestedLoop {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```

A. 9  
B. 6  
C. 3  
D. 5  
E. 7  

---

## Methods and Encapsulation (Questions 37-46)

**Question 37**
What is the output?

```java
public class PassByValue {
    public static void change(int x) {
        x = 100;
    }

    public static void change(int[] arr) {
        arr[0] = 100;
    }

    public static void main(String[] args) {
        int a = 5;
        int[] b = {5, 10};
        change(a);
        change(b);
        System.out.println(a + " " + b[0]);
    }
}
```

A. `100 100`  
B. `5 100`  
C. `5 5`  
D. `100 5`  
E. Compilation error  

---

**Question 38**
Which of the following method signatures are valid overloads in the same class? (Choose all that apply)

```java
public void print(int x) {}
```

A. `public int print(int x) { return x; }`  
B. `public void print(long x) {}`  
C. `public void print(int x, int y) {}`  
D. `private void print(int x) {}`  
E. `public void print(Integer x) {}`  

---

**Question 39**
What is the output?

```java
public class VarArgs {
    public static void method(int... x) {
        System.out.println(x.length);
    }

    public static void main(String[] args) {
        method();
        method(1, 2, 3);
        method(new int[]{4, 5});
    }
}
```

A. `0 3 2`  
B. Compilation error  
C. `0 3 1`  
D. `1 3 2`  
E. NullPointerException  

---

**Question 40**
What is the result?

```java
public class StaticTest {
    int x = 10;
    static int y = 20;

    public static void method() {
        System.out.println(x + y); // Line 1
    }

    public static void main(String[] args) {
        method();
    }
}
```

A. 30  
B. 20  
C. Compilation error at Line 1  
D. Runtime exception  
E. 10  

---

**Question 41**
What is the output?

```java
public class Overloading {
    public static void print(Object o) { System.out.println("Object"); }
    public static void print(String s) { System.out.println("String"); }
    public static void print(int i) { System.out.println("int"); }

    public static void main(String[] args) {
        print(null);
        print(42);
        print("Hello");
    }
}
```

A. `Object int String`  
B. `String int String`  
C. Compilation error  
D. `Object int Object`  
E. NullPointerException  

---

**Question 42**
What access modifiers allow a member to be accessed from a subclass in a different package? (Choose all that apply)

A. `public`  
B. `protected`  
C. default (package-private)  
D. `private`  
E. None of the above  

---

**Question 43**
What is the output?

```java
public class InitOrder {
    static int a = initA();
    int b = initB();

    static int initA() { System.out.print("A "); return 1; }
    int initB() { System.out.print("B "); return 2; }

    static { System.out.print("C "); }
    { System.out.print("D "); }

    public InitOrder() { System.out.print("E "); }

    public static void main(String[] args) {
        System.out.print("F ");
        new InitOrder();
    }
}
```

A. `A C F B D E`  
B. `F A C B D E`  
C. `A C F D B E`  
D. `C A F B D E`  
E. `A C B D E F`  

---

**Question 44**
What is the output?

```java
public class FinalVar {
    public static void main(String[] args) {
        final int x;
        x = 10;
        // x = 20; // Line 1
        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Line 2
        System.out.println(x + " " + sb);
    }
}
```

A. `10 Hello World`  
B. Compilation error at Line 2  
C. `10 Hello`  
D. Compilation error - final variable `x` not initialized  
E. Runtime exception  

---

**Question 45**
Which of the following are true about encapsulation? (Choose all that apply)

A. Instance variables should be marked `private`  
B. Getter methods should be marked `public`  
C. A class with only `private` constructors cannot be instantiated outside the class  
D. Encapsulation requires all methods to be `private`  
E. JavaBean naming convention requires `get`/`set` prefix for accessor/mutator methods  

---

**Question 46**
What is the output?

```java
public class Autoboxing {
    public static void method(Integer i) {
        System.out.print("Integer ");
    }
    public static void method(long l) {
        System.out.print("long ");
    }

    public static void main(String[] args) {
        int x = 5;
        method(x);
    }
}
```

A. `Integer`  
B. `long`  
C. Compilation error - ambiguous  
D. Runtime exception  
E. `int`  

---

## Inheritance (Questions 47-56)

**Question 47**
What is the output?

```java
class Animal {
    String name = "Animal";
    public void speak() { System.out.println("..."); }
}

class Dog extends Animal {
    String name = "Dog";
    public void speak() { System.out.println("Woof"); }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        System.out.println(a.name);
        a.speak();
    }
}
```

A. `Animal` and `Woof`  
B. `Dog` and `Woof`  
C. `Animal` and `...`  
D. `Dog` and `...`  
E. Compilation error  

---

**Question 48**
Which of the following are true about inheritance? (Choose all that apply)

A. A class can extend multiple classes  
B. A class can implement multiple interfaces  
C. An interface can extend multiple interfaces  
D. An abstract class must have at least one abstract method  
E. A concrete class must implement all inherited abstract methods  

---

**Question 49**
What is the output?

```java
class Parent {
    public Parent() {
        System.out.print("P ");
    }
}

class Child extends Parent {
    public Child() {
        System.out.print("C ");
    }
}

class GrandChild extends Child {
    public GrandChild() {
        System.out.print("G ");
    }
}

public class Test {
    public static void main(String[] args) {
        new GrandChild();
    }
}
```

A. `G C P`  
B. `G`  
C. `P C G`  
D. `G P C`  
E. Compilation error  

---

**Question 50**
What is the result?

```java
class Base {
    public Base(int x) {
        System.out.print("Base ");
    }
}

class Derived extends Base {
    public Derived() {
        System.out.print("Derived ");
    }
}

public class Test {
    public static void main(String[] args) {
        new Derived();
    }
}
```

A. `Base Derived`  
B. `Derived`  
C. `Derived Base`  
D. Compilation error  
E. Runtime exception  

---

**Question 51**
What is the output?

```java
abstract class Shape {
    abstract double area();

    public String toString() {
        return "Area: " + area();
    }
}

class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }

    double area() { return Math.PI * radius * radius; }
}

public class Test {
    public static void main(String[] args) {
        Shape s = new Circle(1);
        System.out.println(s);
    }
}
```

A. Compilation error - cannot instantiate abstract class  
B. `Area: 3.141592653589793`  
C. `Area: 0.0`  
D. Runtime exception  
E. Compilation error - `area()` is not public  

---

**Question 52**
What is the result?

```java
class Animal {
    public void eat(Animal a) { System.out.println("Animal eats Animal"); }
}

class Dog extends Animal {
    public void eat(Dog d) { System.out.println("Dog eats Dog"); }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        Dog d = new Dog();
        a.eat(d);
    }
}
```

A. `Dog eats Dog`  
B. `Animal eats Animal`  
C. Compilation error  
D. Runtime exception  
E. `Dog eats Animal`  

---

**Question 53**
Which of the following compile? (Choose all that apply)

```java
interface Flyable {
    void fly();
}

// A
abstract class Bird implements Flyable {}

// B
class Sparrow implements Flyable {}

// C
class Eagle implements Flyable {
    public void fly() { System.out.println("Eagle flies"); }
}

// D
interface FastFlyable extends Flyable {
    void flyFast();
}
```

A. A and C only  
B. A, C, and D  
C. All of them  
D. C only  
E. C and D only  

---

**Question 54**
What is the output?

```java
class Vehicle {
    protected void start() { System.out.println("Vehicle starts"); }
}

class Car extends Vehicle {
    void start() { System.out.println("Car starts"); }
}

public class Test {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
    }
}
```

A. `Vehicle starts`  
B. `Car starts`  
C. Compilation error  
D. Runtime exception  
E. No output  

---

**Question 55**
What is the output?

```java
class A {
    public A() { this(10); System.out.print("A() "); }
    public A(int x) { System.out.print("A(int) "); }
}

class B extends A {
    public B() { System.out.print("B() "); }
    public B(int x) { this(); System.out.print("B(int) "); }
}

public class Test {
    public static void main(String[] args) {
        new B(5);
    }
}
```

A. `A(int) A() B() B(int)`  
B. `B(int) B() A(int) A()`  
C. `A() B() B(int)`  
D. `A(int) A() B(int)`  
E. Compilation error  

---

**Question 56**
What is the output?

```java
class Parent {
    int x = 10;
    int getX() { return x; }
}

class Child extends Parent {
    int x = 20;
    int getX() { return x; }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.x + " " + p.getX());
    }
}
```

A. `10 10`  
B. `20 20`  
C. `10 20`  
D. `20 10`  
E. Compilation error  

---

## Exceptions (Questions 57-64)

**Question 57**
What is the output?

```java
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            System.out.print("A ");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.print("B ");
        } finally {
            System.out.print("C ");
        }
        System.out.print("D ");
    }
}
```

A. `A B C D`  
B. `A B C`  
C. `A B D`  
D. `A C D`  
E. `A B`  

---

**Question 58**
Which of the following are checked exceptions? (Choose all that apply)

A. `RuntimeException`  
B. `IOException`  
C. `NullPointerException`  
D. `FileNotFoundException`  
E. `Error`  
F. `ClassNotFoundException`  

---

**Question 59**
What is the result?

```java
public class MultiCatch {
    public static void main(String[] args) {
        try {
            String s = null;
            s.length();
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
        }
    }
}
```

A. `Caught: NullPointerException`  
B. Compilation error - cannot multi-catch  
C. NullPointerException (uncaught)  
D. `Caught: ArithmeticException`  
E. Compilation error - exceptions in multi-catch must be unrelated  

---

**Question 60**
What is the output?

```java
public class FinallyReturn {
    public static int getValue() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(getValue());
    }
}
```

A. 1  
B. 2  
C. Compilation error  
D. Runtime exception  
E. 0  

---

**Question 61**
What is the result of compiling and running this code?

```java
public class CheckedException {
    public static void method() {
        throw new Exception("Error"); // Line 1
    }

    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

A. `Error`  
B. Compilation error at Line 1  
C. Runtime exception  
D. No output  
E. Compilation error at catch block  

---

**Question 62**
What is the output?

```java
public class ExceptionOrder {
    public static void main(String[] args) {
        try {
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (Exception e) {
            System.out.print("A ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("B ");
        }
        System.out.print("C");
    }
}
```

A. `A C`  
B. `B C`  
C. `A B C`  
D. Compilation error  
E. `B A C`  

---

**Question 63**
What is the output?

```java
public class TryCatch {
    public static void main(String[] args) {
        try {
            System.out.print("A ");
            int x = 10 / 0;
            System.out.print("B ");
        } catch (ArithmeticException e) {
            System.out.print("C ");
            int y = 10 / 0;
            System.out.print("D ");
        } finally {
            System.out.print("E ");
        }
        System.out.print("F ");
    }
}
```

A. `A C E F`  
B. `A C D E F`  
C. `A C E` then ArithmeticException  
D. `A C` then ArithmeticException  
E. `A E` then ArithmeticException  

---

**Question 64**
Which of the following are valid? (Choose all that apply)

```java
// A
try {
    // code
} finally {
    // cleanup
}

// B
try {
    // code
}

// C
try {
    // code
} catch (Exception e) {
    // handle
} catch (RuntimeException re) {
    // handle
}

// D
try {
    // code
} catch (Exception e) {
    // handle
} finally {
    // cleanup
}
```

A. A and D only  
B. A, B, and D  
C. A, C, and D  
D. All of them  
E. D only  

---

## Java API Classes (Questions 65-70)

**Question 65**
What is the output?

```java
import java.time.LocalDate;
import java.time.Month;

public class DateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, Month.JANUARY, 31);
        date.plusMonths(1);
        System.out.println(date.getMonth());
    }
}
```

A. `FEBRUARY`  
B. `JANUARY`  
C. `MARCH`  
D. DateTimeException  
E. Compilation error  

---

**Question 66**
What is the output?

```java
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "D");
        list.set(2, "E");
        list.remove(0);
        System.out.println(list);
    }
}
```

A. `[D, E, C]`  
B. `[A, D, E, C]`  
C. `[D, B, C]`  
D. `[D, E]`  
E. `[A, D, E]`  

---

**Question 67**
What is the output?

```java
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 3, 15);
        LocalTime time = LocalTime.of(14, 30);
        LocalDateTime dt = LocalDateTime.of(date, time);
        System.out.println(dt);
    }
}
```

A. `2024-03-15 14:30`  
B. `2024-03-15T14:30`  
C. `Mar 15, 2024 2:30 PM`  
D. Compilation error  
E. Runtime exception  

---

**Question 68**
What is the output?

```java
import java.util.ArrayList;

public class Generics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        System.out.println(list);
    }
}
```

A. `[2, 3]`  
B. `[1, 3]`  
C. `[1, 2]`  
D. `[1, 2, 3]`  
E. Compilation error  

---

**Question 69**
What is the output?

```java
import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2024, 1, 1);
        Period period = Period.ofMonths(2);
        LocalDate end = start.plus(period);
        System.out.println(end);
        System.out.println(Period.of(1, 2, 3));
    }
}
```

A. `2024-03-01` and `P1Y2M3D`  
B. `2024-03-01` and `1 year 2 months 3 days`  
C. `2024-02-29` and `P1Y2M3D`  
D. Compilation error  
E. Runtime exception  

---

**Question 70**
What is the output?

```java
import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("banana");
        list.add("Apple");
        list.add("cherry");
        Collections.sort(list);
        System.out.println(list);
    }
}
```

A. `[Apple, banana, cherry]`  
B. `[apple, banana, cherry]`  
C. `[banana, Apple, cherry]`  
D. `[Apple, cherry, banana]`  
E. Compilation error  

---

# Answer Key

1. **C** - String concatenation is left-to-right. `"Hello" + 3` produces `"Hello3"`, then `+ 7` produces `"Hello37"`. In the second line, `3 + 7` is integer addition producing `10`, then `+ "Hello"` produces `"10Hello"`.

2. **A, C, F** - Identifiers must start with a letter, `$`, or `_`. `2ndValue` starts with a digit (invalid). `class` is a reserved word. `my-var` contains a hyphen (invalid). `PUBLIC` is valid since keywords are case-sensitive.

3. **B** - The local variable `x` shadows the static variable `x`. The local variable is in scope, so `20` is printed.

4. **F** - All statements are true. The main method must be `public static void`. The parameter can be `String[] args`, `String args[]`, or `String... args`.

5. **A** - Static initializer runs first (`A`), then main starts (`D`), then for each `new Init()`: instance initializer (`B`) then constructor (`C`).

6. **A, C, E** - `java.lang` is auto-imported. Wildcard imports do not import sub-packages. Duplicate imports are allowed. Default package classes cannot be imported. The `package` statement must be first.

7. **A** - `x + y` = `10 + 20` = `30`. After the block, `y` is out of scope but Line 1 is commented out. Then `x` (local) prints `10`. The answer choice E describes behavior but A is the actual output.

8. **E** - Both `import zoo.Animal;` and `import zoo.*;` correctly import the `Animal` class from the `zoo` package.

9. **B** - `s1` and `s2` refer to the same string pool object (`==` is `true`). `s3` is a new object on the heap (`==` is `false`). `equals()` compares content (`true`).

10. **A, B, D, F** - `0b1010` is valid binary. `0xFACE` is valid hex. `09` is invalid octal (digits 0-7 only). `3_000_000L` is valid. `1_000_.50` is invalid (underscore next to decimal point). `0_7` is valid octal.

11. **C** - Integer caching: values -128 to 127 are cached, so `a == b` is `true`. Values outside this range create new objects, so `c == d` is `false`.

12. **A** - After `append`: `"Hello World"`. After `insert(5, ",")`: `"Hello, World"`. `delete(7, 8)` removes index 7 (the space): `"Hello,World"`.

13. **B** - `byte` ranges from -128 to 127. `b++` uses compound assignment which casts implicitly. `127 + 1` overflows to `-128`.

14. **C** - A: `3.14` is a `double`, needs cast or `f` suffix. B: valid. C: `'A' + 1` = `66`, which is a compile-time constant that fits in `char`. D: `100 + 27` = `127`, fits in `byte`. E: `100 + 28` = `128`, does not fit in `byte`.

15. **A** - `substring(5, 8)` returns `"Pro"` (indices 5, 6, 7). `indexOf('a', 3)` searches from index 3, finds `'a'` at index 3 in "Java". `replace('a', 'o')` replaces all `a` with `o`.

16. **B** - When `null` is concatenated with a String using `+=`, Java converts `null` to the string `"null"`, producing `"nullHello"`.

17. **C** - `x++ = 5` (x becomes 6), `++x = 7` (x becomes 7), `x++ = 7` (x becomes 8). `y = 5 + 7 + 7 = 19`. Wait: let me recalculate. `x++ = 5` (x=6), `++x = 7` (x=7), `x++ = 7` (x=8). `y = 5 + 7 + 7 = 19`. But answer is `8 19`. Actually: the expression is evaluated left to right. `x++` yields 5 (x=6), `++x` yields 7 (x=7), `x++` yields 7 (x=8). `y = 5+7+7 = 19`. Output: `8 19`. Answer is **A**.

18. **A** - `x > y` is `false`, so `y++` is evaluated (returns 10, then y becomes 11). `x` is unchanged. `z = 10`. Output: `5 11 10`.

19. **C** - Switch matches `case 2`, then falls through to `case 3` and `default` because there are no `break` statements. Output: `B C D`.

20. **A, C, D, F** - Valid switch types: `byte`, `short`, `char`, `int`, their wrapper classes, `String`, and enums. `long` and `boolean` are NOT valid.

21. **A** - Short-circuit evaluation: `x != 0` is `false`, so the right side is never evaluated. No division by zero occurs. Result is `false`.

22. **B** - The `else` matches the nearest `if`, which is `if (x > 20)`. Since `x > 5` is `true` but `x > 20` is `false`, the `else` branch executes, printing `B`.

23. **A** - `a = b` is an assignment, not comparison. It assigns `false` to `a` and the expression evaluates to `false`. So both lines print `false`.

24. **C** - Left to right: `x * y` = `2 * 3` = `6`. Then `++x` makes x=3. `y * ++x` = `3 * 3` = `9`. Then `- x` = `- 3`. Total: `6 + 9 - 3 = 12`. Wait: `z = x * y + y * ++x - x`. `x*y = 2*3 = 6` (x still 2). `++x` makes x=3. `y * 3 = 9`. `- x = -3`. `z = 6 + 9 - 3 = 12`. Answer is **A** (12).

25. **B, C, D** - A: cannot specify size and initializer. B: anonymous array with declaration. C: valid syntax. D: valid. E: anonymous initializer cannot be used separately from declaration.

26. **B** - `b` is a reference to the same array as `a`. Sorting `b` also sorts `a`. After sort: `{1, 1, 3, 4, 5}`. `a[0] = 1`, `a[4] = 5`.

27. **A** - `arr.length = 3` (three rows). `arr[1].length = 3` (three elements in second row). Wait: `arr[1] = {3, 4, 5}` which has 3 elements. Output: `3` and `3`.

28. **C** - `binarySearch` requires a sorted array. The array `{2, 5, 1, 8, 3}` is not sorted, so the result is undefined/unpredictable.

29. **A** - Default values: `String[]` defaults to `null`, `int[]` defaults to `0`, `boolean[]` defaults to `false`.

30. **C** - `objs` is declared as `Object[]` but points to a `String[]`. Assigning a `String` works fine. Assigning a `StringBuilder` to a `String[]` throws `ArrayStoreException` at runtime.

31. **A** - `i=0,j=10`: print 0. `i=1,j=9`: print 1. `i=2,j=8`: print 2. `i=3,j=7`: print 3. `i=4,j=6`: print 4. `i=5,j=5`: condition false. Output: `0 1 2 3 4`.

32. **A** - The loop prints `00 01 02` for i=0, then `10` for i=1,j=0. When i=1,j=1 the `break outer` exits both loops. Output: `00 01 02 10`.

33. **A** - Loop increments x first. x=1: print 1. x=2: print 2. x=3: continue (skip print). x=4: print 4. x=5: print 5, then condition false. Output: `1 2 4 5`.

34. **B** - The enhanced for loop variable `s` is a copy of the reference. Reassigning `s` does not modify the array. The original array is unchanged.

35. **B** - A: infinite loop with break is valid. B: valid. C: `while(false)` causes compilation error because the body is unreachable. D: valid (do-while doesn't check reachability the same way). E: valid.

36. **B** - i=0: j runs 0,1,2 (3 iterations). i=1: j runs 1,2 (2 iterations). i=2: j runs 2 (1 iteration). Total: 3+2+1 = 6.

37. **B** - Primitives are passed by value (unchanged). Arrays are passed by reference value (the reference is copied, but both point to the same array). `a` stays 5, `b[0]` becomes 100.

38. **B, C, E** - A: same parameters, different return type is NOT a valid overload. B: different parameter type (long vs int). C: different number of parameters. D: same parameters, different access modifier is NOT a valid overload. E: different parameter type (Integer vs int).

39. **A** - Varargs accepts zero or more arguments. `method()` has length 0. `method(1,2,3)` has length 3. `method(new int[]{4,5})` has length 2. Output: `0 3 2`.

40. **C** - Static method `method()` cannot access instance variable `x` without an object reference. Compilation error.

41. **B** - Java chooses the most specific overload. `null` matches `String` (more specific than `Object`). `42` matches `int`. `"Hello"` matches `String`.

42. **A, B** - `public` members are accessible everywhere. `protected` members are accessible from subclasses (even in different packages). Default access is package-only. `private` is class-only.

43. **A** - Static members first: `initA()` prints `A`, static block prints `C`. Then `main` prints `F`. Then `new InitOrder()`: `initB()` prints `B`, instance block prints `D`, constructor prints `E`.

44. **A** - `final` local variables can be assigned once. `x` is assigned to 10 (valid). `final` on a reference means the reference can't change, but the object's contents can. `sb.append()` modifies the object, not the reference.

45. **A, B, C, E** - D is false. Encapsulation does not require all methods to be private; it requires instance variables to be private with public getters/setters.

46. **B** - When an `int` is passed and both `Integer` and `long` overloads exist, Java prefers widening (`int` to `long`) over autoboxing (`int` to `Integer`).

47. **A** - Fields are not polymorphic; `a.name` uses the declared type (`Animal`), printing `"Animal"`. Methods are polymorphic; `a.speak()` calls the `Dog` version, printing `"Woof"`.

48. **B, C, E** - A: Java has single class inheritance. B: true. C: true. D: abstract classes can have zero abstract methods. E: true.

49. **C** - Constructor chaining calls parent constructors first. `GrandChild()` calls `Child()` which calls `Parent()`. Output: `P C G`.

50. **D** - `Base` has no no-arg constructor (only `Base(int)`). `Derived()` implicitly calls `super()`, which doesn't exist. Compilation error.

51. **B** - The `toString()` method calls `area()` which is polymorphically resolved to `Circle.area()`. The area of a circle with radius 1 is `PI`. Output: `Area: 3.141592653589793`.

52. **B** - `Dog.eat(Dog)` does not override `Animal.eat(Animal)` because the parameter type is different. It overloads it. Since `a` is declared as `Animal`, the compiler sees `eat(Animal)`. The `Dog` version with `eat(Dog)` is not visible. The `Animal.eat(Animal)` method is called.

53. **B** - A: abstract class doesn't need to implement interface methods. B: concrete class must implement `fly()` but doesn't - compilation error. C: implements `fly()` correctly. D: interface extending interface is valid.

54. **C** - `Car.start()` has default (package-private) access, which is more restrictive than `protected`. You cannot reduce visibility when overriding. Compilation error.

55. **A** - `new B(5)` calls `B(int)` which calls `this()` -> `B()` which calls `super()` -> `A()` which calls `this(10)` -> `A(int)`. Unwinding: `A(int)` prints "A(int) ", `A()` prints "A() ", `B()` prints "B() ", `B(int)` prints "B(int) ".

56. **C** - `p.x` accesses the field based on declared type (`Parent`), so `10`. `p.getX()` is polymorphic, calls `Child.getX()`, returning `20`.

57. **A** - Exception is thrown, caught by catch block, finally runs, then execution continues after the try-catch-finally. Output: `A B C D`.

58. **B, D, F** - `RuntimeException` and its subclasses (like `NullPointerException`) are unchecked. `Error` is unchecked. `IOException`, `FileNotFoundException`, and `ClassNotFoundException` are checked.

59. **A** - Multi-catch is valid when the exceptions are unrelated (neither is a subclass of the other). `NullPointerException` and `ArithmeticException` are siblings. The `NullPointerException` is caught.

60. **B** - The `finally` block's `return 2` overrides the `try` block's `return 1`. The method returns `2`.

61. **B** - `method()` throws a checked exception (`Exception`) but doesn't declare it with `throws`. Compilation error at Line 1.

62. **D** - Catch blocks must be ordered from most specific to most general. `Exception` is a superclass of `ArrayIndexOutOfBoundsException`. The second catch is unreachable. Compilation error.

63. **C** - `A` prints, exception at `10/0`, caught in catch: `C` prints, another `10/0` in catch throws exception, but `finally` still runs: `E` prints. Then the exception propagates. Output: `A C E` followed by ArithmeticException.

64. **A** - A: try-finally without catch is valid. B: try without catch or finally is invalid. C: catch order is wrong (Exception before RuntimeException), so it won't compile. D: try-catch-finally is valid.

65. **B** - `LocalDate` is immutable. `date.plusMonths(1)` returns a new object, but the result is not assigned. `date` still refers to January 31. Output: `JANUARY`.

66. **A** - Start: `[A, B, C]`. `add(1, "D")`: `[A, D, B, C]`. `set(2, "E")`: `[A, D, E, C]`. `remove(0)`: `[D, E, C]`.

67. **B** - `LocalDateTime.toString()` uses ISO-8601 format with `T` separator: `2024-03-15T14:30`.

68. **B** - `list.remove(1)` calls `remove(int index)` not `remove(Object)`. It removes the element at index 1 (which is `2`). Result: `[1, 3]`.

69. **A** - January 1 + 2 months = March 1. `Period.of(1, 2, 3)` prints in ISO-8601 format: `P1Y2M3D`.

70. **A** - `Collections.sort()` uses natural ordering for Strings, which is lexicographic (Unicode). Uppercase letters come before lowercase. `"Apple"` < `"banana"` < `"cherry"`.
