# Java SE 8 Programmer I (1Z0-808) OCA Preparation

This repository contains Java code examples covering the topics required for the Java SE 8 Programmer I (1Z0-808) certification exam.

## How to Use This Repository

Each concept is contained within its own Java file, located in a package that matches the concept's category.

Since there is no build tool, you can run each file directly in VS Code. Just open the Java file you want to study and click the "Run" button that appears above the `main` method.

---

## Exam Objectives & Topics

### 1. Java Basics
Covering the scope of variables, class structure, and basic data types.

| # | Topic | File Path |
|---|---|---|
| 1.1 | **Data Types** | [`com/oca/datatypes/DataTypes.java`](./com/oca/datatypes/DataTypes.java) |
| 1.2 | **Operators** | [`com/oca/operators/Operators.java`](./com/oca/operators/Operators.java) |
| 1.3 | **Bitwise Operators** | [`com/ocp/operators/BitwiseOperators.java`](./com/ocp/operators/BitwiseOperators.java) |
| 1.4 | **Control Flow** | [`com/ocp/controlflow/ControlFlow.java`](./com/oca/controlflow/ControlFlow.java) |

#### Primitive Data Types Reference

| Type | Size | Range | Default |
|------|------|-------|---------|
| `byte` | 8-bit | -2^7 to 2^7-1 (-128 to 127) | `0` |
| `short` | 16-bit | -2^15 to 2^15-1 (-32,768 to 32,767) | `0` |
| `int` | 32-bit | -2^31 to 2^31-1 | `0` |
| `long` | 64-bit | -2^63 to 2^63-1 | `0L` |
| `float` | 32-bit IEEE 754 | ~±3.4 × 10^38 (7 decimal digits) | `0.0f` |
| `double` | 64-bit IEEE 754 | ~±1.8 × 10^308 (15 decimal digits) | `0.0d` |
| `char` | 16-bit unsigned | 0 to 2^16-1 (0 to 65,535) | `'\u0000'` |
| `boolean` | JVM-dependent | `true` or `false` (2^1 possible values) | `false` |

### 2. Working With Java Data Types
Manipulation of strings, arrays, and other data structures.

| # | Topic | File Path |
|---|---|---|
| 2.1 | **Classes and Objects** | [`com/oca/oops/classes/Dog.java`](./com/oca/oops/classes/Dog.java) |
| 2.2 | **String Handling** | [`com/oca/stringhandling/StringHandling.java`](./com/oca/stringhandling/StringHandling.java) |
| 2.3 | **Arrays** | [`com/oca/arrays/ArraysExample.java`](./com/oca/arrays/ArraysExample.java) |
| 2.4 | **Type Conversions** | [`com/oca/conversions/Conversions.java`](./com/oca/conversions/Conversions.java) |
| 2.5 | **Collections Framework** | [`com/oca/collections/CollectionsExample.java`](./com/oca/collections/CollectionsExample.java) |
| 2.6 | **Generics** | [`com/oca/generics/GenericsExample.java`](./com/oca/generics/GenericsExample.java) |

### 3. Using Methods and Encapsulation
Designing classes with methods, accessors, and mutators.

| # | Topic | File Path |
|---|---|---|
| 3.1 | **Encapsulation** | [`com/oca/oops/encapsulation/Person.java`](./com/oca/oops/encapsulation/Person.java) |
| 3.2 | **Static Keyword** | [`com/oca/statics/StaticExample.java`](./com/oca/statics/StaticExample.java) |
| 3.3 | **Final Keyword** | [`com/oca/finalkeyword/FinalKeywordExample.java`](./com/oca/finalkeyword/FinalKeywordExample.java) |

### 4. Inheritance and Polymorphism
Implementing inheritance, polymorphism, and casting.

| # | Topic | File Path |
|---|---|---|
| 4.1 | **Inheritance** | [`com/oca/oops/inheritance/Labrador.java`](./com/oca/oops/inheritance/Labrador.java) |
| 4.2 | **Polymorphism (Overloading)** | [`com/oca/oops/polymorphism/MethodOverloading.java`](./com/oca/oops/polymorphism/MethodOverloading.java) |
| 4.3 | **Polymorphism (Overriding)** | [`com/oca/oops/polymorphism/MethodOverriding.java`](./com/oca/oops/polymorphism/MethodOverriding.java) |
| 4.4 | **Abstraction (Abstract Class)** | [`com/oca/oops/abstraction/Circle.java`](./com/oca/oops/abstraction/Circle.java) |
| 4.5 | **Abstraction (Interface)** | [`com/oca/oops/abstraction/Drawable.java`](./com/oca/oops/abstraction/Drawable.java) |

### 5. Exception Handling
Handling runtime, checked, and custom exceptions.

| # | Topic | File Path |
|---|---|---|
| 5.1 | **Exception Handling** | [`com/oca/exceptions/ExceptionHandling.java`](./com/oca/exceptions/ExceptionHandling.java) |
| 5.2 | **Custom Exceptions** | [`com/oca/exceptions/CustomException.java`](./com/oca/exceptions/CustomException.java) |

### 6. Working with Selected classes from the Java API
Using key classes from the Java API, including the new Java 8 features.

| # | Topic | File Path |
|---|---|---|
| 6.1 | **Date & Time API** | [`com/oca/datetime/DateTimeAPI.java`](./com/oca/datetime/DateTimeAPI.java) |
| 6.2 | **Lambdas & Functional Interfaces** | [`com/oca/lambdas/LambdaAndFunctionalInterfaces.java`](./com/oca/lambdas/LambdaAndFunctionalInterfaces.java) |
| 6.3 | **Streams API** | [`com/oca/streams/StreamsAPI.java`](./com/oca/streams/StreamsAPI.java) |
| 6.4 | **Optional Class** | [`com/oca/optional/OptionalExample.java`](./com/oca/optional/OptionalExample.java) |

### 7. Concurrency
Basic thread creation and synchronization.

| # | Topic | File Path |
|---|---|---|
| 7.1 | **Multithreading** | [`com/oca/multithreading/MultithreadingExample.java`](./com/oca/multithreading/MultithreadingExample.java) |
| 7.2 | **Concurrency (synchronized)** | [`com/oca/concurrency/ConcurrencyExample.java`](./com/oca/concurrency/ConcurrencyExample.java) |

---
Happy Revising!
