# Type Conversion Cheat Sheet: The 3-Verb Pattern

> **Runnable companion:** [WrapperClasses.java](com/oca/wrapperclasses/WrapperClasses.java) — run it to see every method's output.

Every wrapper class follows the **same three method patterns** — learn the pattern once instead of memorizing each class's method names separately.

## 1. The Pattern

Applies to every wrapper class (`Integer`, `Long`, `Double`, `Float`, `Short`, `Byte`, `Boolean`, `Character`):

| Direction | Method pattern | Returns | Example |
|---|---|---|---|
| String → primitive | `Type.parseType(String)` | primitive | `Integer.parseInt("42")` |
| String → Wrapper | `Type.valueOf(String)` | Wrapper object | `Integer.valueOf("42")` |
| primitive → Wrapper | `Type.valueOf(primitive)` or autoboxing | Wrapper object | `Integer.valueOf(42)` / `Integer x = 42;` |
| Wrapper → primitive | `wrapper.typeValue()` or autounboxing | primitive | `wrapInt.intValue()` / `int i = wrapInt;` |
| anything → String | `String.valueOf(x)` or `x.toString()` | String | `String.valueOf(42)` |

## 2. Per-Class Quick Reference

See [WrapperClasses.java](com/oca/wrapperclasses/WrapperClasses.java) for runnable versions of every row.

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

## 3. Traps to Remember Alongside the Table

| Trap | Rule |
|---|---|
| Invalid string parsed | `parseX`/`valueOf(String)` throw `NumberFormatException` (e.g. `Integer.parseInt("abc")`) |
| Unboxing a `null` wrapper | Throws `NullPointerException` (e.g. `Integer i = null; int x = i;`) |
| Integer cache | `Integer`/`Short`/`Long`/`Byte` cache **-128 to 127**; `Character` caches **0-127**; `Boolean` always caches both values; `Float`/`Double` **never** cache |
| `==` on wrapper objects | Compares references, not values — use `.equals()` instead |

## 4. Primitive Widening / Narrowing

Separate from wrapper conversions — no method calls involved:

| Direction | Rule | Example |
|---|---|---|
| Widening | Automatic, no cast needed | `byte → short → int → long → float → double` |
| Narrowing | Requires explicit cast, may lose data | `(int) 9.99` truncates to `9`; `(byte) 200` overflows/wraps |

## The 3 Verbs to Remember

- **`parse___`** → always returns a **primitive**
- **`valueOf`** → always returns a **wrapper object**
- **`___Value()`** (called on a wrapper instance) → always returns a **primitive**
