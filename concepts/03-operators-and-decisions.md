# 03 - Using Operators and Decision Constructs

## Operator Precedence Table

Operators are listed from **highest** to **lowest** precedence:

| Precedence | Operator | Description | Associativity |
|-----------|----------|-------------|---------------|
| 1 | `()` `[]` `.` | Parentheses, array access, member access | Left to right |
| 2 | `++` `--` (postfix) | Post-increment, post-decrement | Left to right |
| 3 | `++` `--` (prefix) `+` `-` `~` `!` | Pre-increment, unary plus/minus, bitwise NOT, logical NOT | Right to left |
| 4 | `(type)` `new` | Cast, object creation | Right to left |
| 5 | `*` `/` `%` | Multiplication, division, modulus | Left to right |
| 6 | `+` `-` | Addition, subtraction, string concatenation | Left to right |
| 7 | `<<` `>>` `>>>` | Shift operators | Left to right |
| 8 | `<` `<=` `>` `>=` `instanceof` | Relational, type comparison | Left to right |
| 9 | `==` `!=` | Equality | Left to right |
| 10 | `&` | Bitwise AND | Left to right |
| 11 | `^` | Bitwise XOR | Left to right |
| 12 | `\|` | Bitwise OR | Left to right |
| 13 | `&&` | Logical AND (short-circuit) | Left to right |
| 14 | `\|\|` | Logical OR (short-circuit) | Left to right |
| 15 | `?:` | Ternary conditional | Right to left |
| 16 | `=` `+=` `-=` `*=` `/=` `%=` etc. | Assignment operators | Right to left |

## Arithmetic Operators

```java
int a = 10, b = 3;
a + b;    // 13   addition
a - b;    // 7    subtraction
a * b;    // 30   multiplication
a / b;    // 3    integer division (truncates toward zero)
a % b;    // 1    modulus (remainder)
```

**Exam trap:** Integer division truncates, it does not round. `7 / 2` is `3`, not `3.5`. To get a decimal result, at least one operand must be a floating-point type: `7.0 / 2` gives `3.5`.

## Unary Operators

```java
int x = 5;
+x;     // 5   unary plus (rarely used)
-x;     // -5  unary minus
!true;  // false  logical complement
~x;     // -6  bitwise complement

// Pre vs Post increment/decrement
int a = 5;
int b = ++a;   // a becomes 6, b = 6 (increment FIRST, then use)
int c = a++;   // c = 6 (use FIRST, then increment), a becomes 7
```

**Exam trap:** Pay close attention to pre vs post in expressions:
```java
int x = 3;
int y = ++x * x++;
// Step 1: ++x -> x becomes 4, value used is 4
// Step 2: x++ -> value used is 4, then x becomes 5
// y = 4 * 4 = 16, x = 5
```

## Assignment Operators

```java
int x = 10;    // simple assignment
x += 5;        // x = x + 5 -> 15
x -= 3;        // x = x - 3 -> 12
x *= 2;        // x = x * 2 -> 24
x /= 4;        // x = x / 4 -> 6
x %= 4;        // x = x % 4 -> 2
```

**Exam trap:** Compound assignment operators include an implicit cast:
```java
short s = 10;
// s = s + 1;    // DOES NOT COMPILE: s + 1 is promoted to int
s += 1;          // COMPILES: equivalent to s = (short)(s + 1)
```

## Relational Operators

```java
a == b     // equal to
a != b     // not equal to
a > b      // greater than
a < b      // less than
a >= b     // greater than or equal to
a <= b     // less than or equal to
a instanceof String  // type check (reference types only)
```

## == vs .equals()

| Scenario | `==` | `.equals()` |
|----------|------|-------------|
| **Primitives** | Compares values (correct) | N/A (primitives cannot call methods) |
| **Objects** | Compares **references** (same object in memory?) | Compares **content** (if properly overridden) |
| **Strings (literals)** | May return `true` (String pool) | Always compares content |
| **Strings (new)** | Returns `false` (different objects) | Always compares content |
| **Wrappers (-128 to 127)** | May return `true` (Integer cache) | Always compares values |
| **Wrappers (outside cache)** | Returns `false` | Always compares values |

**Rule of thumb:** Use `==` for primitives. Use `.equals()` for objects.

## Short-Circuit Evaluation

```java
// && (short-circuit AND) vs & (non-short-circuit AND)
// || (short-circuit OR)  vs | (non-short-circuit OR)
```

**Short-circuit** (`&&`, `||`): The right operand is **not evaluated** if the result can be determined from the left operand alone.

```java
String s = null;

// Safe: && short-circuits, s.length() is never called
if (s != null && s.length() > 0) { }

// Unsafe: & always evaluates both sides -> NullPointerException
if (s != null & s.length() > 0) { }
```

| Expression | Left is `false` | Left is `true` |
|-----------|-----------------|-----------------|
| `left && right` | Returns `false`, right **skipped** | Evaluates right |
| `left & right` | Evaluates **both** | Evaluates **both** |
| `left \|\| right` | Evaluates right | Returns `true`, right **skipped** |
| `left \| right` | Evaluates **both** | Evaluates **both** |

**Exam trap:** Side effects in short-circuited expressions:
```java
int x = 0;
boolean result = false && (++x > 0);
// x is still 0 because ++x was never evaluated!
```

## Ternary Operator

```java
// Syntax: condition ? valueIfTrue : valueIfFalse
int max = (a > b) ? a : b;

// Can be nested (but avoid for readability)
String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
```

**Exam points:**
- Both result expressions must be assignable to the target type.
- The ternary operator is an **expression**, not a statement -- it produces a value.

## if / else if / else

```java
if (condition1) {
    // executed if condition1 is true
} else if (condition2) {
    // executed if condition1 is false and condition2 is true
} else {
    // executed if all conditions are false
}
```

**Exam trap:** Without braces, only the **first statement** after `if` is conditional:
```java
if (false)
    System.out.println("A");   // skipped
    System.out.println("B");   // ALWAYS prints (not part of the if)
```

## switch Statement

```java
switch (variable) {
    case value1:
        // code
        break;
    case value2:
    case value3:
        // fall-through: handles both value2 and value3
        break;
    default:
        // optional, can appear anywhere
        break;
}
```

### Valid Types for switch

| Allowed | Not Allowed |
|---------|-------------|
| `byte`, `short`, `char`, `int` | `long` |
| `Byte`, `Short`, `Character`, `Integer` | `float`, `double` |
| `String` (since Java 7) | `boolean` |
| `enum` | Any other object type |

### Fall-Through Behavior

Without `break`, execution "falls through" to the next case:

```java
int x = 1;
switch (x) {
    case 1: System.out.println("One");    // prints
    case 2: System.out.println("Two");    // also prints (fall-through!)
    case 3: System.out.println("Three");  // also prints (fall-through!)
        break;
    default: System.out.println("Default");
}
// Output: One, Two, Three
```

**Exam traps:**
- Case values must be **compile-time constants** (literals, `final` variables with constant expressions, or enum constants).
- Variables (even effectively final ones without the `final` keyword) are **not** valid case values.
- `default` can appear anywhere in the switch, not just at the end.
- Duplicate case values cause a **compilation error**.

## Related Source Files

- [Operators.java](../com/oca/operators/Operators.java) -- arithmetic, unary, and assignment operator examples
- [ControlFlow.java](../com/oca/controlflow/ControlFlow.java) -- if/else, switch, and decision construct examples
