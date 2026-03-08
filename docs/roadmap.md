# Java SE 8 Programmer I (1Z0-808) - Study Roadmap

> **Exam Details:** 70 questions | 150 minutes | 65% passing score | Multiple choice

This roadmap stitches together all concepts, source code, and mock exams in a step-by-step order. Follow it sequentially for best results.

---

## Phase 1: Java Foundations (Week 1)

### Step 1 - Java Basics
- **Concept:** [01 - Java Basics](../concepts/01-java-basics.md)
  - JDK vs JRE vs JVM, platform independence, bytecode
  - Class structure, package, imports, main method
  - Variable scopes (local, instance, class/static)
- **Code Lab:**
  - [DataTypes.java](../com/oca/datatypes/DataTypes.java) - 8 primitive types, ranges, reference types
  - [Dog.java](../com/oca/oops/classes/Dog.java) - Class structure, fields, methods, constructors

### Step 2 - Data Types and Variables
- **Concept:** [02 - Working with Java Data Types](../concepts/02-data-types.md)
  - Primitives vs references, default values
  - Object lifecycle, garbage collection eligibility
  - Wrapper classes, autoboxing/unboxing, Integer cache trap
- **Code Lab:**
  - [DataTypes.java](../com/oca/datatypes/DataTypes.java) - Primitive declarations and ranges
  - [WrapperClasses.java](../com/oca/wrapperclasses/WrapperClasses.java) - Autoboxing, unboxing, Integer cache
  - [ObjectLifecycle.java](../com/oca/objectlifecycle/ObjectLifecycle.java) - GC eligibility, island of isolation
  - [Conversions.java](../com/oca/conversions/Conversions.java) - Type conversions and casting

### Step 3 - Operators and Decision Constructs
- **Concept:** [03 - Operators and Decisions](../concepts/03-operators-and-decisions.md)
  - Operator precedence, arithmetic, unary, relational, logical
  - == vs .equals(), short-circuit evaluation
  - if/else, switch (valid types, fall-through)
- **Code Lab:**
  - [Operators.java](../com/oca/operators/Operators.java) - All operator types with examples
  - [ControlFlow.java](../com/oca/controlflow/ControlFlow.java) - if-else, switch, ternary

---

## Phase 2: Arrays, Loops, and Strings (Week 2)

### Step 4 - Arrays and ArrayList
- **Concept:** [04 - Arrays and ArrayList](../concepts/04-arrays-and-arraylist.md)
  - Declaration, instantiation, initialization (all syntax forms)
  - Multi-dimensional arrays, default values
  - ArrayList: add, remove, get, size, autoboxing
- **Code Lab:**
  - [ArraysExample.java](../com/oca/arrays/ArraysExample.java) - Array operations
  - [CollectionsExample.java](../com/oca/collections/CollectionsExample.java) - ArrayList and collections

### Step 5 - Loop Constructs
- **Concept:** [05 - Loop Constructs](../concepts/05-loop-constructs.md)
  - for, enhanced for-each, while, do-while
  - break, continue, labeled loops
  - Common exam traps (infinite loops, off-by-one)
- **Code Lab:**
  - [ControlFlow.java](../com/oca/controlflow/ControlFlow.java) - All loop types, break/continue
  - [LabeledLoops.java](../com/oca/controlflow/LabeledLoops.java) - Labeled break/continue, matrix search

### Step 6 - String Handling
- **Concept:** [09 - Java API Classes](../concepts/09-java-api-classes.md) (String section)
  - String immutability, String pool
  - StringBuilder mutability
  - Common String/StringBuilder methods
- **Code Lab:**
  - [StringHandling.java](../com/oca/stringhandling/StringHandling.java) - String and StringBuilder operations

---

## Phase 3: OOP Fundamentals (Week 3)

### Step 7 - Methods and Encapsulation
- **Concept:** [06 - Methods and Encapsulation](../concepts/06-methods-and-encapsulation.md)
  - Method signatures, overloading rules
  - Pass-by-value semantics (primitives vs references)
  - Constructors, constructor chaining
  - static, final keywords
  - Access modifiers, encapsulation
- **Code Lab:**
  - [PassByValue.java](../com/oca/passbyvalue/PassByValue.java) - Pass-by-value with primitives and objects
  - [Person.java](../com/oca/oops/encapsulation/Person.java) - Encapsulation, getters/setters
  - [StaticExample.java](../com/oca/statics/StaticExample.java) - Static fields, methods, initializers
  - [FinalKeywordExample.java](../com/oca/finalkeyword/FinalKeywordExample.java) - Final variables, methods, classes

### Step 8 - Inheritance and Polymorphism
- **Concept:** [07 - Inheritance and Polymorphism](../concepts/07-inheritance-and-polymorphism.md)
  - extends, IS-A, method overriding rules
  - super/this keywords, constructor chaining in inheritance
  - Compile-time vs runtime polymorphism
  - Upcasting, downcasting, instanceof
  - Abstract classes vs interfaces
- **Code Lab:**
  - [Animal.java](../com/oca/oops/inheritance/Animal.java) / [Labrador.java](../com/oca/oops/inheritance/Labrador.java) - Inheritance hierarchy
  - [MethodOverloading.java](../com/oca/oops/polymorphism/MethodOverloading.java) - Compile-time polymorphism
  - [MethodOverriding.java](../com/oca/oops/polymorphism/MethodOverriding.java) - Runtime polymorphism
  - [Shape.java](../com/oca/oops/abstraction/Shape.java) / [Circle.java](../com/oca/oops/abstraction/Circle.java) - Abstract classes
  - [Drawable.java](../com/oca/oops/abstraction/Drawable.java) - Interfaces
  - [ReferenceCasting.java](../com/oca/casting/ReferenceCasting.java) - Upcasting, downcasting, instanceof

---

## Phase 4: Exceptions and Java API (Week 4)

### Step 9 - Exception Handling
- **Concept:** [08 - Exception Handling](../concepts/08-exception-handling.md)
  - Exception hierarchy (Throwable, Error, Exception, RuntimeException)
  - Checked vs unchecked exceptions
  - try-catch-finally, multi-catch, try-with-resources
  - throws vs throw, exception propagation
  - Common exception classes
- **Code Lab:**
  - [ExceptionHandling.java](../com/oca/exceptions/ExceptionHandling.java) - try-catch, finally, throws
  - [CustomException.java](../com/oca/exceptions/CustomException.java) - Custom exception classes

### Step 10 - Java 8 API: Date/Time and Lambdas
- **Concept:** [09 - Java API Classes](../concepts/09-java-api-classes.md) (Date/Time and Lambda sections)
  - LocalDate, LocalTime, LocalDateTime
  - Period, Duration, DateTimeFormatter
  - Lambda syntax, functional interfaces
  - Predicate, Consumer, Supplier, Function
- **Code Lab:**
  - [DateTimeAPI.java](../com/oca/datetime/DateTimeAPI.java) - Java 8 Date/Time API
  - [LambdaAndFunctionalInterfaces.java](../com/oca/lambdas/LambdaAndFunctionalInterfaces.java) - Lambdas and functional interfaces

---

## Phase 5: Practice Exams (Week 5)

### Step 11 - Mock Exam 1 (Full Exam)
- [Mock Exam 1](../mock-exams/mock-exam-1.md) - 70 questions, all topics
- Target: Identify weak areas
- Review wrong answers against concept files

### Step 12 - Mock Exam 2 (Full Exam)
- [Mock Exam 2](../mock-exams/mock-exam-2.md) - 70 questions, tricky edge cases
- Focus on: String traps, Integer cache, switch fall-through, constructor order, casting

### Step 13 - Mock Exam 3 (Focused Practice)
- [Mock Exam 3](../mock-exams/mock-exam-3.md) - 50 questions on commonly failed topics
- Covers: Operator tricks, String/StringBuilder gotchas, inheritance edge cases, exception flow, pass-by-value/wrapper traps

---

## Quick Reference: All Source Files

### OCA (1Z0-808) - Exam Scope

| Package | File | Topic |
|---|---|---|
| `datatypes` | [DataTypes.java](../com/oca/datatypes/DataTypes.java) | 8 primitive types |
| `wrapperclasses` | [WrapperClasses.java](../com/oca/wrapperclasses/WrapperClasses.java) | Autoboxing, Integer cache |
| `objectlifecycle` | [ObjectLifecycle.java](../com/oca/objectlifecycle/ObjectLifecycle.java) | GC eligibility, finalize |
| `conversions` | [Conversions.java](../com/oca/conversions/Conversions.java) | Type casting/conversions |
| `operators` | [Operators.java](../com/oca/operators/Operators.java) | All operator types |
| `controlflow` | [ControlFlow.java](../com/oca/controlflow/ControlFlow.java) | if/else, switch, loops |
| `controlflow` | [LabeledLoops.java](../com/oca/controlflow/LabeledLoops.java) | Labeled break/continue |
| `arrays` | [ArraysExample.java](../com/oca/arrays/ArraysExample.java) | Array operations |
| `collections` | [CollectionsExample.java](../com/oca/collections/CollectionsExample.java) | ArrayList, collections |
| `stringhandling` | [StringHandling.java](../com/oca/stringhandling/StringHandling.java) | String, StringBuilder |
| `passbyvalue` | [PassByValue.java](../com/oca/passbyvalue/PassByValue.java) | Pass-by-value semantics |
| `oops/classes` | [Dog.java](../com/oca/oops/classes/Dog.java) | Class structure |
| `oops/encapsulation` | [Person.java](../com/oca/oops/encapsulation/Person.java) | Encapsulation |
| `oops/inheritance` | [Animal.java](../com/oca/oops/inheritance/Animal.java) | Base class |
| `oops/inheritance` | [Labrador.java](../com/oca/oops/inheritance/Labrador.java) | Inheritance |
| `oops/polymorphism` | [MethodOverloading.java](../com/oca/oops/polymorphism/MethodOverloading.java) | Overloading |
| `oops/polymorphism` | [MethodOverriding.java](../com/oca/oops/polymorphism/MethodOverriding.java) | Overriding |
| `oops/abstraction` | [Shape.java](../com/oca/oops/abstraction/Shape.java) | Abstract class |
| `oops/abstraction` | [Circle.java](../com/oca/oops/abstraction/Circle.java) | Abstract class impl |
| `oops/abstraction` | [Drawable.java](../com/oca/oops/abstraction/Drawable.java) | Interface |
| `casting` | [ReferenceCasting.java](../com/oca/casting/ReferenceCasting.java) | Upcasting, downcasting, instanceof |
| `statics` | [StaticExample.java](../com/oca/statics/StaticExample.java) | Static keyword |
| `finalkeyword` | [FinalKeywordExample.java](../com/oca/finalkeyword/FinalKeywordExample.java) | Final keyword |
| `exceptions` | [ExceptionHandling.java](../com/oca/exceptions/ExceptionHandling.java) | try-catch-finally |
| `exceptions` | [CustomException.java](../com/oca/exceptions/CustomException.java) | Custom exceptions |
| `datetime` | [DateTimeAPI.java](../com/oca/datetime/DateTimeAPI.java) | Java 8 Date/Time |
| `lambdas` | [LambdaAndFunctionalInterfaces.java](../com/oca/lambdas/LambdaAndFunctionalInterfaces.java) | Lambdas |

### OCP (1Z0-809) - Beyond Exam Scope (Bonus)

| Package | File | Topic |
|---|---|---|
| `streams` | [StreamsAPI.java](../com/ocp/streams/StreamsAPI.java) | Streams API |
| `optional` | [OptionalExample.java](../com/ocp/optional/OptionalExample.java) | Optional class |
| `generics` | [GenericsExample.java](../com/ocp/generics/GenericsExample.java) | Generics |
| `concurrency` | [ConcurrencyExample.java](../com/ocp/concurrency/ConcurrencyExample.java) | Synchronized |
| `multithreading` | [MultithreadingExample.java](../com/ocp/multithreading/MultithreadingExample.java) | Threads |
| `operators` | [BitwiseOperators.java](../com/ocp/operators/BitwiseOperators.java) | Bitwise operators |

---

## Exam Day Tips

1. **Time management** - ~2 minutes per question, flag and come back to hard ones
2. **Read carefully** - Watch for "does NOT compile", "choose all that apply", exact output format
3. **Trace code by hand** - Write down variable values step by step for complex expressions
4. **Watch for traps** - String immutability, Integer cache, post-increment in expressions, switch fall-through
5. **Elimination** - Rule out obviously wrong answers first
