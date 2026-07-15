# Java SE 8 Programmer I (1Z0-808) - Study Roadmap

> **Exam Details:** 70 questions | 150 minutes | 65% passing score | Multiple choice

This roadmap stitches together all concepts, source code, and mock exams in a step-by-step order. Follow it sequentially for best results.

---

## Phase 1: Java Foundations (Week 1)

### Step 1 - Java Basics
- **Concept:** [01 - Java Basics](concepts/01-java-basics.md)
  - JDK vs JRE vs JVM, platform independence, bytecode
  - Class structure, package, imports, main method
  - Variable scopes (local, instance, class/static)
- **Code Lab:**
  - [DataTypes.java](com/oca/datatypes/DataTypes.java) - 8 primitive types, ranges, reference types
  - [Dog.java](com/oca/oops/classes/Dog.java) - Class structure, fields, methods, constructors

### Step 2 - Data Types and Variables
- **Concept:** [02 - Working with Java Data Types](concepts/02-data-types.md)
  - Primitives vs references, default values
  - Object lifecycle, garbage collection eligibility
  - Wrapper classes, autoboxing/unboxing, Integer cache trap
- **Code Lab:**
  - [DataTypes.java](com/oca/datatypes/DataTypes.java) - Primitive declarations and ranges
  - [WrapperClasses.java](com/oca/wrapperclasses/WrapperClasses.java) - Autoboxing, unboxing, Integer cache
  - [ObjectLifecycle.java](com/oca/objectlifecycle/ObjectLifecycle.java) - GC eligibility, island of isolation
  - [Conversions.java](com/oca/conversions/Conversions.java) - Type conversions and casting

#### Conversion Cheat Sheet: The 3-Verb Pattern

Every wrapper class follows the **same three method patterns** — learn the pattern once instead of memorizing each class's method names separately.

**1. The pattern (applies to every wrapper class):**

| Direction | Method pattern | Returns | Example |
|---|---|---|---|
| String → primitive | `Type.parseType(String)` | primitive | `Integer.parseInt("42")` |
| String → Wrapper | `Type.valueOf(String)` | Wrapper object | `Integer.valueOf("42")` |
| primitive → Wrapper | `Type.valueOf(primitive)` or autoboxing | Wrapper object | `Integer.valueOf(42)` / `Integer x = 42;` |
| Wrapper → primitive | `wrapper.typeValue()` or autounboxing | primitive | `wrapInt.intValue()` / `int i = wrapInt;` |
| anything → String | `String.valueOf(x)` or `x.toString()` | String | `String.valueOf(42)` |

**2. Per-class quick reference** — see [WrapperClasses.java](com/oca/wrapperclasses/WrapperClasses.java) for runnable versions of every row:

| Wrapper | parseX(String) → primitive | valueOf(String) → Wrapper | xValue() → primitive |
|---|---|---|---|
| `Integer` | `parseInt` | `valueOf` | `intValue` |
| `Long` | `parseLong` | `valueOf` | `longValue` |
| `Double` | `parseDouble` | `valueOf` | `doubleValue` |
| `Float` | `parseFloat` | `valueOf` | `floatValue` |
| `Short` | `parseShort` | `valueOf` | `shortValue` |
| `Byte` | `parseByte` | `valueOf` | `byteValue` |
| `Boolean` | `parseBoolean` | `valueOf` | `booleanValue` |
| `Character` | *(none — no parseChar)* | `valueOf(char)` | `charValue` |

**3. Traps to remember alongside the table:**

| Trap | Rule |
|---|---|
| Invalid string parsed | `parseX`/`valueOf(String)` throw `NumberFormatException` (e.g. `Integer.parseInt("abc")`) |
| Unboxing a `null` wrapper | Throws `NullPointerException` (e.g. `Integer i = null; int x = i;`) |
| Integer cache | `Integer`/`Short`/`Long`/`Byte` cache **-128 to 127**; `Character` caches **0-127**; `Boolean` always caches both values; `Float`/`Double` **never** cache |
| `==` on wrapper objects | Compares references, not values — use `.equals()` instead |

**4. Primitive widening / narrowing** (separate from wrapper conversions — no method calls involved):

| Direction | Rule | Example |
|---|---|---|
| Widening | Automatic, no cast needed | `byte → short → int → long → float → double` |
| Narrowing | Requires explicit cast, may lose data | `(int) 9.99` truncates to `9`; `(byte) 200` overflows/wraps |

**The 3 verbs to remember:**
- **`parse___`** → always returns a **primitive**
- **`valueOf`** → always returns a **wrapper object**
- **`___Value()`** (called on a wrapper instance) → always returns a **primitive**

### Step 3 - Operators and Decision Constructs
- **Concept:** [03 - Operators and Decisions](concepts/03-operators-and-decisions.md)
  - Operator precedence, arithmetic, unary, relational, logical
  - == vs .equals(), short-circuit evaluation
  - if/else, switch (valid types, fall-through)
- **Code Lab:**
  - [Operators.java](com/oca/operators/Operators.java) - All operator types with examples
  - [ControlFlow.java](com/oca/controlflow/ControlFlow.java) - if-else, switch, ternary

---

## Phase 2: Arrays, Loops, and Strings (Week 2)

### Step 4 - Arrays and ArrayList
- **Concept:** [04 - Arrays and ArrayList](concepts/04-arrays-and-arraylist.md)
  - Declaration, instantiation, initialization (all syntax forms)
  - Multi-dimensional arrays, default values
  - ArrayList: add, remove, get, size, autoboxing
- **Code Lab:**
  - [ArraysExample.java](com/oca/arrays/ArraysExample.java) - Array operations
  - [CollectionsExample.java](com/oca/collections/CollectionsExample.java) - ArrayList and collections

### Step 5 - Loop Constructs
- **Concept:** [05 - Loop Constructs](concepts/05-loop-constructs.md)
  - for, enhanced for-each, while, do-while
  - break, continue, labeled loops
  - Common exam traps (infinite loops, off-by-one)
- **Code Lab:**
  - [ControlFlow.java](com/oca/controlflow/ControlFlow.java) - All loop types, break/continue
  - [LabeledLoops.java](com/oca/controlflow/LabeledLoops.java) - Labeled break/continue, matrix search

### Step 6 - String Handling
- **Concept:** [09 - Java API Classes](concepts/09-java-api-classes.md) (String section)
  - String immutability, String pool
  - StringBuilder mutability
  - Common String/StringBuilder methods
- **Code Lab:**
  - [StringHandling.java](com/oca/stringhandling/StringHandling.java) - String and StringBuilder operations

---

## Phase 3: OOP Fundamentals (Week 3)

### Step 7 - Methods and Encapsulation
- **Concept:** [06 - Methods and Encapsulation](concepts/06-methods-and-encapsulation.md)
  - Method signatures, overloading rules
  - Pass-by-value semantics (primitives vs references)
  - Constructors, constructor chaining
  - static, final keywords
  - Access modifiers, encapsulation
- **Code Lab:**
  - [PassByValue.java](com/oca/passbyvalue/PassByValue.java) - Pass-by-value with primitives and objects
  - [Person.java](com/oca/oops/encapsulation/Person.java) - Encapsulation, getters/setters
  - [StaticExample.java](com/oca/statics/StaticExample.java) - Static fields, methods, initializers
  - [FinalKeywordExample.java](com/oca/finalkeyword/FinalKeywordExample.java) - Final variables, methods, classes

### Step 8 - Inheritance and Polymorphism
- **Concept:** [07 - Inheritance and Polymorphism](concepts/07-inheritance-and-polymorphism.md)
  - extends, IS-A, method overriding rules
  - super/this keywords, constructor chaining in inheritance
  - Compile-time vs runtime polymorphism
  - Upcasting, downcasting, instanceof
  - Abstract classes vs interfaces
  - Overriding Object methods (toString, equals, hashCode)
  - Multiple interface implementation

#### 8a - Inheritance (read in order)

| # | File | What it teaches |
|---|---|---|
| 1 | [Animal.java](com/oca/oops/inheritance/Animal.java) | Base class — fields, constructor, instance methods |
| 2 | [Dog.java](com/oca/oops/inheritance/Dog.java) | Mid-level subclass — `extends`, `super()`, overrides with `super.method()` call |
| 3 | [Labrador.java](com/oca/oops/inheritance/Labrador.java) | Leaf subclass — 3-level chain, full constructor order, multiple overrides |

> **Chain:** `Animal` → `Dog` → `Labrador`
> **Key pattern in Dog.java:** `super.makeSound()` — how to extend (not replace) a parent method

#### 8b - Polymorphism (read in order)

| # | File | What it teaches |
|---|---|---|
| 1 | [MethodOverloading.java](com/oca/oops/polymorphism/MethodOverloading.java) | Compile-time polymorphism — same name, different params |
| 2 | [MethodOverriding.java](com/oca/oops/polymorphism/MethodOverriding.java) | Runtime polymorphism — dynamic dispatch, upcasting |
| 3 | [ReferenceCasting.java](com/oca/casting/ReferenceCasting.java) | Upcasting (implicit), downcasting (explicit), `instanceof`, `ClassCastException` |
| 4 | [ObjectMethods.java](com/oca/oops/polymorphism/ObjectMethods.java) | Overriding `toString()`, `equals()`, `hashCode()` from `Object` |
| 5 | [OopExamTraps.java](com/oca/oops/polymorphism/OopExamTraps.java) | **Exam traps:** static method hiding, field hiding, immutable objects |

#### 8c - Abstraction (read in order)

| # | File | What it teaches |
|---|---|---|
| 1 | [Shape.java](com/oca/oops/abstraction/Shape.java) | Abstract class — cannot instantiate, abstract + concrete methods |
| 2 | [Circle.java](com/oca/oops/abstraction/Circle.java) | Concrete subclass — must implement all abstract methods |
| 3 | [Rectangle.java](com/oca/oops/abstraction/Rectangle.java) | Second concrete subclass — polymorphism via abstract type |
| 4 | [Drawable.java](com/oca/oops/abstraction/Drawable.java) | Interface — abstract methods, default methods, static methods (Java 8) |
| 5 | [MultipleInterfaces.java](com/oca/oops/abstraction/MultipleInterfaces.java) | Implementing multiple interfaces, diamond default method conflict resolution |

---

## Phase 4: Exceptions and Java API (Week 4)

### Step 9 - Exception Handling
- **Concept:** [08 - Exception Handling](concepts/08-exception-handling.md)
  - Exception hierarchy (Throwable, Error, Exception, RuntimeException)
  - Checked vs unchecked exceptions
  - try-catch-finally, multi-catch, try-with-resources
  - throws vs throw, exception propagation
  - Common exception classes
- **Code Lab:**
  - [ExceptionHandling.java](com/oca/exceptions/ExceptionHandling.java) - try-catch, finally, throws
  - [CustomException.java](com/oca/exceptions/CustomException.java) - Custom exception classes

### Step 10 - Java 8 API: Date/Time and Lambdas
- **Concept:** [09 - Java API Classes](concepts/09-java-api-classes.md) (Date/Time and Lambda sections)
  - LocalDate, LocalTime, LocalDateTime
  - Period, Duration, DateTimeFormatter
  - Lambda syntax, functional interfaces
  - Predicate, Consumer, Supplier, Function
- **Code Lab:**
  - [DateTimeAPI.java](com/oca/datetime/DateTimeAPI.java) - Java 8 Date/Time API
  - [LambdaAndFunctionalInterfaces.java](com/oca/lambdas/LambdaAndFunctionalInterfaces.java) - Lambdas and functional interfaces

---

## Phase 5: Practice Exams (Week 5)

### Step 11 - Mock Exam 1 (Full Exam)
- [Mock Exam 1](mock-exams/mock-exam-1.md) - 70 questions, all topics
- Target: Identify weak areas
- Review wrong answers against concept files

### Step 12 - Mock Exam 2 (Full Exam)
- [Mock Exam 2](mock-exams/mock-exam-2.md) - 70 questions, tricky edge cases
- Focus on: String traps, Integer cache, switch fall-through, constructor order, casting

### Step 13 - Mock Exam 3 (Focused Practice)
- [Mock Exam 3](mock-exams/mock-exam-3.md) - 50 questions on commonly failed topics
- Covers: Operator tricks, String/StringBuilder gotchas, inheritance edge cases, exception flow, pass-by-value/wrapper traps

---

## Quick Reference: All Source Files

### OCA (1Z0-808) - Exam Scope

| Package | File | Topic |
|---|---|---|
| `datatypes` | [DataTypes.java](com/oca/datatypes/DataTypes.java) | 8 primitive types |
| `wrapperclasses` | [WrapperClasses.java](com/oca/wrapperclasses/WrapperClasses.java) | Autoboxing, Integer cache |
| `objectlifecycle` | [ObjectLifecycle.java](com/oca/objectlifecycle/ObjectLifecycle.java) | GC eligibility, finalize |
| `conversions` | [Conversions.java](com/oca/conversions/Conversions.java) | Type casting/conversions |
| `operators` | [Operators.java](com/oca/operators/Operators.java) | All operator types |
| `controlflow` | [ControlFlow.java](com/oca/controlflow/ControlFlow.java) | if/else, switch, loops |
| `controlflow` | [LabeledLoops.java](com/oca/controlflow/LabeledLoops.java) | Labeled break/continue |
| `arrays` | [ArraysExample.java](com/oca/arrays/ArraysExample.java) | Array operations |
| `collections` | [CollectionsExample.java](com/oca/collections/CollectionsExample.java) | ArrayList, collections |
| `stringhandling` | [StringHandling.java](com/oca/stringhandling/StringHandling.java) | String, StringBuilder |
| `passbyvalue` | [PassByValue.java](com/oca/passbyvalue/PassByValue.java) | Pass-by-value semantics |
| `oops/classes` | [Dog.java](com/oca/oops/classes/Dog.java) | Class structure, fields, constructor chaining |
| `oops/encapsulation` | [Person.java](com/oca/oops/encapsulation/Person.java) | Encapsulation, private fields, getters/setters |
| `oops/inheritance` | [Animal.java](com/oca/oops/inheritance/Animal.java) | Base class (level 1 of 3) |
| `oops/inheritance` | [Dog.java](com/oca/oops/inheritance/Dog.java) | Mid-level subclass, `super.method()` (level 2 of 3) |
| `oops/inheritance` | [Labrador.java](com/oca/oops/inheritance/Labrador.java) | Leaf subclass, 3-level constructor chain (level 3 of 3) |
| `oops/polymorphism` | [MethodOverloading.java](com/oca/oops/polymorphism/MethodOverloading.java) | Compile-time polymorphism |
| `oops/polymorphism` | [MethodOverriding.java](com/oca/oops/polymorphism/MethodOverriding.java) | Runtime polymorphism, dynamic dispatch |
| `oops/polymorphism` | [ObjectMethods.java](com/oca/oops/polymorphism/ObjectMethods.java) | `toString()`, `equals()`, `hashCode()` overrides |
| `oops/polymorphism` | [OopExamTraps.java](com/oca/oops/polymorphism/OopExamTraps.java) | Static hiding, field hiding, immutable objects |
| `oops/abstraction` | [Shape.java](com/oca/oops/abstraction/Shape.java) | Abstract class |
| `oops/abstraction` | [Circle.java](com/oca/oops/abstraction/Circle.java) | Concrete subclass of abstract class |
| `oops/abstraction` | [Rectangle.java](com/oca/oops/abstraction/Rectangle.java) | Second concrete subclass |
| `oops/abstraction` | [Drawable.java](com/oca/oops/abstraction/Drawable.java) | Interface with default/static methods |
| `oops/abstraction` | [MultipleInterfaces.java](com/oca/oops/abstraction/MultipleInterfaces.java) | Multiple interface implementation, diamond conflict |
| `casting` | [ReferenceCasting.java](com/oca/casting/ReferenceCasting.java) | Upcasting, downcasting, `instanceof`, `ClassCastException` |
| `statics` | [StaticExample.java](com/oca/statics/StaticExample.java) | Static keyword |
| `finalkeyword` | [FinalKeywordExample.java](com/oca/finalkeyword/FinalKeywordExample.java) | Final keyword |
| `exceptions` | [ExceptionHandling.java](com/oca/exceptions/ExceptionHandling.java) | try-catch-finally |
| `exceptions` | [CustomException.java](com/oca/exceptions/CustomException.java) | Custom exceptions |
| `datetime` | [DateTimeAPI.java](com/oca/datetime/DateTimeAPI.java) | Java 8 Date/Time |
| `lambdas` | [LambdaAndFunctionalInterfaces.java](com/oca/lambdas/LambdaAndFunctionalInterfaces.java) | Lambdas |

### OCP (1Z0-809) - Beyond Exam Scope (Bonus)

| Package | File | Topic |
|---|---|---|
| `streams` | [StreamsAPI.java](com/ocp/streams/StreamsAPI.java) | Streams API |
| `optional` | [OptionalExample.java](com/ocp/optional/OptionalExample.java) | Optional class |
| `generics` | [GenericsExample.java](com/ocp/generics/GenericsExample.java) | Generics |
| `concurrency` | [ConcurrencyExample.java](com/ocp/concurrency/ConcurrencyExample.java) | Synchronized |
| `multithreading` | [MultithreadingExample.java](com/ocp/multithreading/MultithreadingExample.java) | Threads |
| `operators` | [BitwiseOperators.java](com/ocp/operators/BitwiseOperators.java) | Bitwise operators |
| `collections` | [CollectionsCheatSheet.java](com/ocp/collections/CollectionsCheatSheet.java) | Collections methods for LeetCode-style assessments |

### Interview Prep (Bonus)

- [Collections Cheat Sheet](collections-cheatsheet.md) - Quick-revision reference for HashMap, HashSet, ArrayList, Stack, ArrayDeque, PriorityQueue, TreeMap, StringBuilder, Arrays/Collections utilities - with the runnable companion above

---

## Exam Day Tips

1. **Time management** - ~2 minutes per question, flag and come back to hard ones
2. **Read carefully** - Watch for "does NOT compile", "choose all that apply", exact output format
3. **Trace code by hand** - Write down variable values step by step for complex expressions
4. **Watch for traps** - String immutability, Integer cache, post-increment in expressions, switch fall-through
5. **Elimination** - Rule out obviously wrong answers first
