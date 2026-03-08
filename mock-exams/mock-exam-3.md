# Mock Exam 3 - Focused Practice (Commonly Failed Topics)

**50 Questions | Recommended Time: 100 minutes | Passing Score: 65%**

---

## Tricky Operator Precedence and Expressions (Questions 1-10)

**Question 1**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        int x = 5;
        int y = x++ + ++x;
        System.out.println(x + " " + y);
    }
}
```

A. `6 11`  
B. `7 12`  
C. `7 11`  
D. `6 12`  
E. Compilation error  

---

**Question 2**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = a * b++ + ++a - b;
        System.out.println(a + " " + b + " " + c);
    }
}
```

A. `3 4 5`  
B. `3 4 6`  
C. `3 4 3`  
D. `2 4 5`  
E. `3 3 6`  

---

**Question 3**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        byte b = 10;
        b += 200;
        System.out.println(b);
    }
}
```

A. `210`  
B. `-46`  
C. Compilation error  
D. Runtime exception  
E. `200`  

---

**Question 4**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        int x = 1;
        int y = ~x;
        System.out.println(y);
    }
}
```

A. `0`  
B. `-1`  
C. `-2`  
D. `1`  
E. Compilation error  

---

**Question 5**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = a ^ b | b & a;
        System.out.println(c);
    }
}
```

A. `true`  
B. `false`  
C. Compilation error  
D. Runtime exception  

---

**Question 6**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        int x = 10;
        x += x -= x *= x;
        System.out.println(x);
    }
}
```

A. `0`  
B. `100`  
C. `-80`  
D. `-90`  
E. Compilation error  

---

**Question 7**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        byte b = 5;
        b = b + 1;
        System.out.println(b);
    }
}
```

A. `6`  
B. `5`  
C. Compilation error  
D. Runtime exception  

---

**Question 8**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        int i = 0;
        boolean result = (i++ == 0) && (i++ == 1) && (i++ == 2);
        System.out.println(i + " " + result);
    }
}
```

A. `3 true`  
B. `1 true`  
C. `2 true`  
D. `3 false`  
E. `1 false`  

---

**Question 9**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(x > 2 ? x < 4 ? 10 : 20 : 30);
    }
}
```

A. `10`  
B. `20`  
C. `30`  
D. Compilation error  

---

**Question 10**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        short s = 10;
        char c = 10;
        s = c;
        c = s;
        System.out.println(s + " " + c);
    }
}
```

A. `10 10`  
B. `10` followed by a character  
C. Compilation error  
D. Runtime exception  

---

## String/StringBuilder Gotchas (Questions 11-20)

**Question 11**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        System.out.println((s1 == s2) + " " + (s1 == s3));
    }
}
```

A. `true true`  
B. `true false`  
C. `false false`  
D. `false true`  

---

**Question 12**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hel" + "lo";
        String s3 = "Hel";
        String s4 = s3 + "lo";
        System.out.println((s1 == s2) + " " + (s1 == s4));
    }
}
```

A. `true true`  
B. `true false`  
C. `false false`  
D. `false true`  

---

**Question 13**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s = "Hello";
        s.concat(" World");
        s.toUpperCase();
        System.out.println(s);
    }
}
```

A. `Hello World`  
B. `HELLO WORLD`  
C. `HELLO`  
D. `Hello`  
E. Compilation error  

---

**Question 14**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World").delete(5, 6).insert(5, ",");
        System.out.println(sb);
    }
}
```

A. `Hello,World`  
B. `Hello, World`  
C. `Hello World`  
D. `Hello,World `  
E. Compilation error  

---

**Question 15**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        StringBuilder sb1 = new StringBuilder("Java");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(sb1));
        System.out.println(sb1.equals(s1));
    }
}
```

A. `true true true`  
B. `true false false`  
C. `true true false`  
D. `true false true`  
E. Compilation error  

---

**Question 16**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s = "ABCDE";
        System.out.println(s.substring(2, 4));
        System.out.println(s.charAt(4));
    }
}
```

A. `CD` and `E`  
B. `CDE` and `E`  
C. `CD` and `D`  
D. `BC` and `D`  
E. StringIndexOutOfBoundsException  

---

**Question 17**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(2, 4);
        sb.replace(1, 3, "XYZ");
        System.out.println(sb);
    }
}
```

A. `aXYZf`  
B. `aXYZef`  
C. `aXYZf`  
D. `abXYZf`  
E. StringIndexOutOfBoundsException  

---

**Question 18**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1.replace('l', 'l');
        System.out.println(s1 == s2);
    }
}
```

A. `true`  
B. `false`  
C. Compilation error  
D. It depends on the JVM implementation  

---

**Question 19**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(5);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }
}
```

A. `5` and `5`  
B. `0` and `5`  
C. `0` and `21`  
D. `5` and `21`  
E. Compilation error  

---

**Question 20**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.replace("World", "Java").trim().length());
    }
}
```

A. `10`  
B. `11`  
C. `9`  
D. `12`  
E. Compilation error  

---

## Inheritance/Polymorphism Edge Cases (Questions 21-30)

**Question 21**
What is the output of the following code?

```java
class Animal {
    public static void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    public static void eat() {
        System.out.println("Dog eats");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();
    }
}
```

A. `Dog eats`  
B. `Animal eats`  
C. Compilation error  
D. Runtime exception  

---

**Question 22**
What is the output of the following code?

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

**Question 23**
Which of the following code snippets compile? (Choose all that apply)

```java
// Snippet A
abstract class A {
    abstract void doWork();
    void helper() { System.out.println("help"); }
}

// Snippet B
abstract class B {
    abstract void doWork() { System.out.println("work"); }
}

// Snippet C
abstract class C {
    private abstract void doWork();
}

// Snippet D
abstract class D {
    abstract void doWork();
    abstract void doMore();
}
```

A. Snippet A  
B. Snippet B  
C. Snippet C  
D. Snippet D  
E. None of them  

---

**Question 24**
What is the output of the following code?

```java
class Base {
    Base() {
        System.out.print("Base ");
        this.display();
    }
    void display() {
        System.out.print("BaseDisplay ");
    }
}

class Derived extends Base {
    int x = 10;
    Derived() {
        System.out.print("Derived ");
    }
    void display() {
        System.out.print(x + " ");
    }
}

public class Test {
    public static void main(String[] args) {
        new Derived();
    }
}
```

A. `Base BaseDisplay Derived`  
B. `Base 10 Derived`  
C. `Base 0 Derived`  
D. `Derived Base 10`  
E. Compilation error  

---

**Question 25**
What is the result of compiling and running the following code?

```java
class Parent {
    protected Number getNumber() {
        return 10;
    }
}

class Child extends Parent {
    @Override
    protected Integer getNumber() {
        return 20;
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.getNumber());
    }
}
```

A. `10`  
B. `20`  
C. Compilation error because of incompatible return types  
D. Compilation error because @Override is incorrect  
E. Runtime exception  

---

**Question 26**
What is the output of the following code?

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

class Document implements Printable, Showable {
    public void print() {
        Printable.super.print();
    }
}

public class Test {
    public static void main(String[] args) {
        new Document().print();
    }
}
```

A. `Printable`  
B. `Showable`  
C. Compilation error because of conflicting defaults  
D. Compilation error because of illegal syntax  
E. Runtime exception  

---

**Question 27**
What is the output of the following code?

```java
class A {
    A() { System.out.print("A "); }
}

class B extends A {
    B() { System.out.print("B "); }
    B(int x) {
        this();
        System.out.print("B-int ");
    }
}

class C extends B {
    C() { super(5); System.out.print("C "); }
}

public class Test {
    public static void main(String[] args) {
        new C();
    }
}
```

A. `A B C`  
B. `A B B-int C`  
C. `C B-int B A`  
D. `A B-int B C`  
E. Compilation error  

---

**Question 28**
What is the result of compiling the following code?

```java
class Parent {
    void greet() throws Exception {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void greet() {
        System.out.println("Child");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.greet();
    }
}
```

A. Prints `Child`  
B. Prints `Parent`  
C. Compilation error in Child class  
D. Compilation error in main method  
E. Runtime exception  

---

**Question 29**
What is the output of the following code?

```java
abstract class Shape {
    String name;
    Shape(String name) {
        this.name = name;
    }
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    double area() {
        return Math.PI * radius * radius;
    }
}

public class Test {
    public static void main(String[] args) {
        Shape s = new Circle(0);
        System.out.println(s.name + " " + s.area());
    }
}
```

A. `Circle 0`  
B. `Circle 0.0`  
C. Compilation error because Shape cannot be instantiated  
D. Compilation error because area() is not public  
E. Runtime exception  

---

**Question 30**
What is the result of compiling and running the following code?

```java
class Animal {
    void makeSound() {
        System.out.println("...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof");
    }
    void fetch() {
        System.out.println("Fetching");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();
        ((Dog) a).fetch();

        Animal b = new Animal();
        ((Dog) b).makeSound();
    }
}
```

A. `Woof` then `Fetching` then `...`  
B. `Woof` then `Fetching` then ClassCastException  
C. `...` then `Fetching` then ClassCastException  
D. Compilation error  
E. `Woof` then `Fetching` then `Woof`  

---

## Exception Handling Flow (Questions 31-40)

**Question 31**
What is the output of the following code?

```java
public class Test {
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
D. `A C`  
E. `A B`  

---

**Question 32**
What is the output of the following code?

```java
public class Test {
    static int compute() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
    public static void main(String[] args) {
        System.out.println(compute());
    }
}
```

A. `1`  
B. `2`  
C. Compilation error  
D. Runtime exception  

---

**Question 33**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        try {
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.print("A ");
        } catch (Exception e) {
            System.out.print("B ");
        }
        System.out.print("C ");
    }
}
```

A. `A C`  
B. `B C`  
C. `A B C`  
D. `A`  
E. Compilation error  

---

**Question 34**
What is the result of compiling the following code?

```java
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("try");
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            e = new RuntimeException();
            System.out.println("catch");
        }
    }
}
```

A. Prints `try`  
B. Prints `try` then `catch`  
C. Compilation error because multi-catch parameter is effectively final  
D. Compilation error because RuntimeException is not in the catch list  
E. Runtime exception  

---

**Question 35**
What is the output of the following code?

```java
public class Test {
    static String result = "";
    static void method() {
        try {
            result += "A";
            throw new Exception();
        } catch (Exception e) {
            result += "B";
            return;
        } finally {
            result += "C";
        }
    }
    public static void main(String[] args) {
        method();
        System.out.println(result);
    }
}
```

A. `AB`  
B. `ABC`  
C. `AC`  
D. `A`  
E. Compilation error  

---

**Question 36**
What is the result of compiling and running the following code?

```java
public class Test {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        } finally {
            System.out.println("finally");
        }
    }
}
```

A. `finally` followed by RuntimeException  
B. Only `finally`  
C. Only RuntimeException  
D. Compilation error  
E. Nothing is printed  

---

**Question 37**
Which of the following are checked exceptions? (Choose all that apply)

A. `RuntimeException`  
B. `IOException`  
C. `NullPointerException`  
D. `FileNotFoundException`  
E. `Error`  
F. `ClassNotFoundException`  

---

**Question 38**
What is the result of compiling and running the following code?

```java
import java.io.*;

public class Test {
    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (IOException | FileNotFoundException e) {
            System.out.println("caught");
        }
    }
}
```

A. Prints `caught`  
B. Compilation error because FileNotFoundException is a subclass of IOException  
C. Compilation error because IOException is checked  
D. Runtime exception  
E. Prints nothing  

---

**Question 39**
What is the output of the following code?

```java
public class Test {
    static int count = 0;
    static int method() {
        try {
            count++;
            if (count < 3) throw new RuntimeException();
            return count;
        } catch (RuntimeException e) {
            count++;
            method();
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(method());
    }
}
```

A. `2`  
B. `3`  
C. `4`  
D. `5`  
E. StackOverflowError  

---

**Question 40**
What is the result of compiling the following code?

```java
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        } catch (RuntimeException e) {
            System.out.println("C");
        }
    }
}
```

A. Prints `A`  
B. Prints `A B`  
C. Prints `A C`  
D. Compilation error because RuntimeException is already caught by Exception  
E. Runtime exception  

---

## Pass-by-Value and Wrapper Class Traps (Questions 41-50)

**Question 41**
What is the output of the following code?

```java
public class Test {
    static void modify(int x) {
        x = x + 10;
    }
    public static void main(String[] args) {
        int a = 5;
        modify(a);
        System.out.println(a);
    }
}
```

A. `15`  
B. `5`  
C. `10`  
D. Compilation error  

---

**Question 42**
What is the output of the following code?

```java
public class Test {
    static void modify(StringBuilder sb) {
        sb.append(" World");
    }
    static void replace(StringBuilder sb) {
        sb = new StringBuilder("Goodbye");
    }
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("Hello");
        modify(s);
        replace(s);
        System.out.println(s);
    }
}
```

A. `Hello`  
B. `Hello World`  
C. `Goodbye`  
D. `Goodbye World`  
E. Compilation error  

---

**Question 43**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println((a == b) + " " + (c == d));
    }
}
```

A. `true true`  
B. `false false`  
C. `true false`  
D. `false true`  

---

**Question 44**
What is the output of the following code?

```java
public class Test {
    static void modify(String s) {
        s = s + " World";
    }
    public static void main(String[] args) {
        String str = "Hello";
        modify(str);
        System.out.println(str);
    }
}
```

A. `Hello World`  
B. `Hello`  
C. `World`  
D. Compilation error  
E. Runtime exception  

---

**Question 45**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        Integer x = null;
        int y = x;
        System.out.println(y);
    }
}
```

A. `0`  
B. `null`  
C. Compilation error  
D. NullPointerException  
E. NumberFormatException  

---

**Question 46**
What is the output of the following code?

```java
public class Test {
    static void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2};
        swap(nums);
        System.out.println(nums[0] + " " + nums[1]);
    }
}
```

A. `1 2`  
B. `2 1`  
C. `0 0`  
D. Compilation error  
E. Runtime exception  

---

**Question 47**
What is the output of the following code?

```java
public class Test {
    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        int c = 5;
        System.out.println((a == b) + " " + (a == c) + " " + a.equals(b));
    }
}
```

A. `true true true`  
B. `false true true`  
C. `false false true`  
D. `true false true`  
E. Compilation error  

---

**Question 48**
What is the output of the following code?

```java
public class Test {
    static void increment(Integer x) {
        x++;
    }
    public static void main(String[] args) {
        Integer val = 10;
        increment(val);
        System.out.println(val);
    }
}
```

A. `11`  
B. `10`  
C. `0`  
D. Compilation error  
E. NullPointerException  

---

**Question 49**
What is the output of the following code?

```java
public class Test {
    static void modify(int[] arr) {
        arr = new int[]{10, 20, 30};
    }
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        modify(original);
        System.out.println(original[0] + " " + original[1] + " " + original[2]);
    }
}
```

A. `10 20 30`  
B. `1 2 3`  
C. `0 0 0`  
D. Compilation error  
E. Runtime exception  

---

**Question 50**
What is the output of the following code? (Choose all that apply)

```java
public class Test {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        Long e = 100L;

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a.equals(e));
        System.out.println(e.equals(a));
    }
}
```

A. `true`, `true`, `true`, `true`  
B. `true`, `false`, `true`, `true`  
C. `true`, `false`, `false`, `false`  
D. `true`, `false`, `true`, `false`  
E. Compilation error  

---

# Answer Key

1. **B** - `x++` uses 5 then x becomes 6; `++x` makes x 7 then uses 7. So y = 5 + 7 = 12, and x = 7. Output: `7 12`.

2. **A** - `a * b++` evaluates as `2 * 3 = 6` (b becomes 4 after), `++a` makes a = 3. So c = 6 + 3 - 4 = 5. Final: a=3, b=4, c=5.

3. **B** - The compound assignment operator `+=` includes an implicit cast back to byte. 10 + 200 = 210, which overflows to -46 in byte range. No compilation error because `+=` handles the cast.

4. **C** - The bitwise complement `~x` flips all bits. For int value 1, `~1` equals `-2` because ~x = -(x+1).

5. **A** - Operator precedence: `&` binds tighter than `^`, which binds tighter than `|`. So it evaluates as `a ^ (b | (b & a))` -> wait, actually `&` > `^` > `|`. So: `(a ^ b) | (b & a)` is wrong. Correct: `a ^ (b | (b & a))` is also wrong. The expression is `a ^ b | b & a`. Precedence: `&` first: `b & a = false & true = false`. Then `^`: `a ^ b = true ^ false = true`. Then `|`: `true | false = true`. Result: `true`.

6. **C** - Right-to-left associativity for compound assignments. `x *= x` -> x = 10*10 = 100. `x -= x` -> x = 100-100 = 0. `x += x` -> x = 0+0... Wait, compound assignments evaluate left operand first. Let's trace: `x += x -= x *= x`. The value of x on the left of `+=` is captured as 10 before the right side evaluates. `x -= x *= x`: the value of x on the left of `-=` is captured as 10. `x *= x`: x = 10*10 = 100. Now `x -= ...`: x = 10 - 100 = -90. Now `x += ...`: x = 10 + (-90) = -80. Output: `-80`.

7. **C** - `b + 1` produces an int. Assigning int to byte requires explicit cast. Unlike `b += 1` which includes implicit casting, `b = b + 1` does not compile.

8. **A** - Short-circuit `&&`: `(0 == 0)` is true, i becomes 1. `(1 == 1)` is true, i becomes 2. `(2 == 2)` is true, i becomes 3. All true so result is true. Output: `3 true`.

9. **B** - Nested ternary: `x > 2` is true (5 > 2), so evaluate `x < 4 ? 10 : 20`. Since 5 < 4 is false, result is 20.

10. **C** - `s = c` compiles because char (unsigned 0-65535) can be assigned to short with potential loss, but actually this does NOT compile. `c = s` does not compile because short cannot be implicitly assigned to char (short is signed, char is unsigned). Both assignments fail, but specifically `c = s` causes a compilation error. Actually `s = c` also fails because char range (0-65535) doesn't fit in short (-32768 to 32767). Both lines cause compilation errors.

11. **B** - String literals are interned, so `s1 == s2` is true. `new String()` creates a new object on the heap, so `s1 == s3` is false.

12. **B** - `"Hel" + "lo"` is a compile-time constant, so s2 refers to the same interned String as s1. `s3 + "lo"` involves a variable, so it creates a new String object at runtime. Thus `s1 == s2` is true and `s1 == s4` is false.

13. **D** - Strings are immutable. `concat()` and `toUpperCase()` return new String objects, but the return values are not assigned back to `s`. So `s` still references `"Hello"`.

14. **A** - After `append(" World")`: `"Hello World"`. After `delete(5, 6)`: removes index 5 (the space), giving `"HelloWorld"`. After `insert(5, ",")`: inserts comma at index 5, giving `"Hello,World"`.

15. **B** - `s1 == s2` is true (String pool). `s1.equals(sb1)` is false because `String.equals()` checks if the argument is a String instance; StringBuilder is not. `sb1.equals(s1)` is false because `StringBuilder` does not override `equals()`, so it uses `Object.equals()` which checks reference equality.

16. **A** - `substring(2, 4)` returns characters at indices 2 and 3, which is `"CD"`. `charAt(4)` returns `'E'` (valid index 0-4).

17. **A** - After `delete(2, 4)`: removes indices 2-3, giving `"abef"`. After `replace(1, 3, "XYZ")`: replaces indices 1-2 (characters `"be"`) with `"XYZ"`, giving `"aXYZf"`.

18. **A** - When `replace()` is called with the same character for both old and new, the JVM returns the original String reference (an optimization in Java). So `s1 == s2` is `true`.

19. **B** - `new StringBuilder(5)` creates a StringBuilder with initial capacity of 5 but length 0 (no characters). `length()` returns 0, `capacity()` returns 5.

20. **A** - `"Hello World".replace("World", "Java")` gives `"Hello Java"` (length 10). `trim()` does nothing since there are no leading/trailing spaces. `length()` returns 10.

21. **B** - Static methods are resolved based on the reference type, not the object type. This is method hiding, not overriding. Since the reference is of type `Animal`, `Animal.eat()` is called, printing `"Animal eats"`.

22. **C** - Instance variables are resolved based on reference type (no polymorphism for fields), so `p.x` is 10. Instance methods are resolved based on object type (polymorphism), so `p.getX()` calls `Child.getX()` which returns 20.

23. **A, D** - Snippet A compiles: an abstract class can have both abstract and concrete methods. Snippet B fails: abstract methods cannot have a body. Snippet C fails: abstract methods cannot be private. Snippet D compiles: an abstract class can have multiple abstract methods.

24. **C** - Constructor chaining calls `Base()` first. Inside `Base()`, `this.display()` is polymorphic and calls `Derived.display()`. At this point, `Derived.x` has not been initialized yet (still default value 0). So output is `Base 0 Derived`.

25. **B** - `Integer` is a subclass of `Number`, so this is a valid covariant return type override. Polymorphism calls `Child.getNumber()` which returns 20.

26. **A** - When a class inherits conflicting default methods from two interfaces, it must override the method. The syntax `Printable.super.print()` is valid to call a specific interface's default method. Output: `"Printable"`.

27. **B** - `new C()` calls `super(5)` which calls `B(int x)`. `B(int x)` calls `this()` which calls `B()`. `B()` implicitly calls `super()` which calls `A()`. So order is: `A()` prints "A ", `B()` prints "B ", back in `B(int)` prints "B-int ", `C()` prints "C ". Output: `A B B-int C`.

28. **D** - `Child.greet()` correctly overrides `Parent.greet()` with a narrower exception (none). However, in `main`, the reference type is `Parent`, and `Parent.greet()` declares `throws Exception`. The caller must handle or declare this checked exception. Since `main` does neither, it causes a compilation error. Actually, `main` does not have `throws Exception`, so it fails to compile.

29. **B** - This compiles fine. An abstract class can have a constructor (called via `super()`). `Circle` extends `Shape` properly. `s.area()` returns `Math.PI * 0 * 0 = 0.0`. Output: `Circle 0.0`.

30. **B** - `a.makeSound()` calls `Dog.makeSound()` (polymorphism): prints `"Woof"`. `((Dog) a).fetch()`: valid cast, prints `"Fetching"`. `((Dog) b).makeSound()`: `b` is actually an `Animal`, so the cast throws `ClassCastException` at runtime.

31. **A** - try block prints "A ", throws RuntimeException, catch block prints "B ", finally block prints "C ", then execution continues and prints "D ".

32. **B** - The `return` in the `finally` block overrides the `return` in the `try` block. The method returns 2.

33. **A** - `ArrayIndexOutOfBoundsException` is caught by the first multi-catch block, printing "A ". Then execution continues after the try-catch, printing "C ".

34. **C** - In a multi-catch block, the exception parameter is implicitly final. Reassigning `e` to a new exception causes a compilation error.

35. **B** - `try` appends "A", exception is thrown, `catch` appends "B" then encounters `return`. Before returning, `finally` executes and appends "C". So result is "ABC".

36. **A** - The catch block throws a new RuntimeException. Before that exception propagates, the `finally` block executes and prints "finally". Then the RuntimeException propagates up and terminates the program (unhandled).

37. **B, D, F** - `IOException`, `FileNotFoundException` (subclass of IOException), and `ClassNotFoundException` are checked exceptions. `RuntimeException` and `NullPointerException` are unchecked. `Error` is not an exception (it's a separate branch of Throwable).

38. **B** - `FileNotFoundException` is a subclass of `IOException`. In a multi-catch, you cannot list both a parent and child exception type. This causes a compilation error: "Alternatives in a multi-catch statement cannot be related by subclassing."

39. **C** - First call: count becomes 1, throws exception, catch increments to 2, recursive call. Second call: count becomes 3, no exception thrown, returns 3... but actually returns count. Let's trace carefully. Call 1: count=0->1, throws, catch: count=1->2, calls method(). Call 2: count=2->3, 3 < 3 is false, returns count=3 (but this return value is ignored by call 1's catch block). Call 1's catch finishes, falls through to `return count` which is 3... wait, the catch block calls method() but doesn't return its value. After catch, it falls to the `return count` at the end. But actually there was a `return` in the catch's recursive call... no. The catch block calls `method()` and discards the result, then the catch block ends, and since there's a `return count` after the try-catch, it returns count which is now 4... let me re-trace. Call 1: count 0->1, throws, catch: count 1->2, calls method(). Call 2: count 2->3, no throw, returns 3. Back in call 1 catch, finishes. Falls to return count (count is 3). Hmm, count is 3 after call 2. But wait - no more increments. So answer is 3... but actually in call 1, after the recursive call in catch returns, execution reaches `return count;` at the bottom, and count is 3. But the try block's return already tried to return... no, the try block threw an exception. So yes, the answer should be **4**. Let me re-trace one more time: Call 1: try: count=1, throws. catch: count=2, method() is called. Call 2: try: count=3, no throw, returns 3 (to call 1 catch). Call 1: catch finishes, reaches `return count` after try-catch, count=3. Hmm, the answer is 3, not 4. Wait, I initially said C which is 4. Let me reconsider... Actually count goes 0->1 (try in call1), 1->2 (catch in call1), 2->3 (try in call2), then call2 returns 3, then call1 returns count which is 3. The answer is 3. But the listed answer is C (4). Let me fix: the answer is **B** (3). Actually, I need to re-examine: after call 2's try sets count=3 and `3 < 3` is false, it returns count=3. But wait, does count get incremented again? No. So count=3. The final return in call 1 returns count=3. Answer is **B** (3), not C.

40. **D** - `RuntimeException` is a subclass of `Exception`. Catching `Exception` first means `RuntimeException` is already caught, making the second catch block unreachable. This is a compilation error.

41. **B** - Java is pass-by-value. The method receives a copy of `a`'s value. Modifying `x` inside the method does not affect `a`. Output: `5`.

42. **B** - `modify(s)` passes the reference by value. The method can mutate the object through the reference, so `append(" World")` affects the original. `replace(s)` reassigns the local parameter to a new object, which does not affect the original reference. Output: `Hello World`.

43. **C** - Integer caches values from -128 to 127. `a` and `b` (127) reference the same cached object, so `==` is true. `c` and `d` (128) are outside the cache, so they are different objects and `==` is false.

44. **B** - Strings are immutable, and Java is pass-by-value. The method parameter `s` is a copy of the reference. `s = s + " World"` creates a new String and assigns it to the local copy. The original `str` is unaffected. Output: `Hello`.

45. **D** - Unboxing `null` (converting `Integer null` to `int`) throws a `NullPointerException` at runtime.

46. **B** - Arrays are objects. The method receives a copy of the reference to the same array. Modifying the array contents through this reference affects the original array. Output: `2 1`.

47. **B** - `new Integer(5)` creates distinct objects, so `a == b` is false. `a == c` compares Integer with int; the Integer is unboxed to int, so `5 == 5` is true. `a.equals(b)` compares values, so it's true.

48. **B** - Integer is immutable. `x++` unboxes x to 10, increments to 11, then autoboxes 11 into a new Integer object assigned to the local parameter `x`. The original `val` still references the Integer object with value 10.

49. **B** - The method parameter `arr` is a copy of the reference. Reassigning `arr` to a new array does not affect the original reference `original`. Output: `1 2 3`.

50. **C** - `a == b` is true (Integer cache, both 100). `c == d` is false (200 is outside cache). `a.equals(e)` is false because `Integer.equals()` checks if the argument is an Integer; `e` is a Long so it returns false. `e.equals(a)` is false because `Long.equals()` checks if the argument is a Long; `a` is an Integer so it returns false.
