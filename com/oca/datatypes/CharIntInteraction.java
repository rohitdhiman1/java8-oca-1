package com.oca.datatypes;

public class CharIntInteraction {

    public static void main(String[] args) {

        // =========================================================
        // 1. char is stored as its Unicode (ASCII) code point
        // =========================================================
        char c = 'A';
        int codePoint = c;              // implicit widening — no cast needed
        System.out.println("'A' as int  : " + codePoint);          // 65
        System.out.println("(int)'a'    : " + (int) 'a');          // 97
        System.out.println("(int)'0'    : " + (int) '0');          // 48

        // =========================================================
        // 2. Numeric promotion — ANY arithmetic on char → int
        // =========================================================
        char x = 'e';
        // x + 1 is int, NOT char
        System.out.println("\n'e' + 1     : " + (x + 1));          // 102 (int)
        System.out.println("'a' + 'b'   : " + ('a' + 'b'));        // 195 (int), NOT "ab"

        // To keep result as char, cast explicitly:
        char next = (char) (x + 1);
        System.out.println("next letter : " + next);               // f

        // ++ on a char variable stays char (no promotion — assigns back)
        char ch = 'a';
        ch++;
        System.out.println("'a'++ = " + ch);                       // b

        // =========================================================
        // 3. Letter <-> alphabet index (0-25)
        // =========================================================
        char letter = 'e';
        int idx = letter - 'a';                     // char - char → int
        System.out.println("\n'e' - 'a'   : " + idx);              // 4

        char fromIdx = (char) ('a' + 4);            // int → must cast back to char
        System.out.println("'a' + 4     : " + fromIdx);            // e
        // char bad = 'a' + 4;                      // ← compile error without cast

        // =========================================================
        // 4. Digit char <-> numeric value
        // =========================================================
        char digit = '7';
        int numVal = digit - '0';                   // 55 - 48 = 7
        System.out.println("\n'7' - '0'   : " + numVal);           // 7  ← numeric value
        System.out.println("(int)'7'    : " + (int) digit);        // 55 ← code point (trap!)

        char backToChar = (char) ('0' + 7);         // 48 + 7 = 55 → '7'
        System.out.println("'0' + 7     : " + backToChar);         // 7 (the character)

        // =========================================================
        // 5. Case conversion: uppercase ↔ lowercase differ by 32
        // =========================================================
        char upper = 'G';
        char lower = (char) (upper + 32);
        System.out.println("\n'G' + 32    : " + lower);            // g
        System.out.println("'g' - 32    : " + (char) ('g' - 32)); // G

        // =========================================================
        // 6. The invisible char[] trap
        //    Default value of char is '\0' (code point 0) — prints nothing
        // =========================================================
        char[] freq = new char[5];
        freq[0] = 2;  freq[1] = 1;     // stores code points 2 and 1, NOT '2' / '1'
        System.out.println("\nraw new String(freq)  : [" + new String(freq) + "]");  // invisible
        System.out.print("as integers           : ");
        for (char fc : freq) System.out.print((int) fc + " ");     // 2 1 0 0 0
        System.out.println();

        // Fix: skip '\0' chars when building a string result
        StringBuilder sb = new StringBuilder();
        for (char fc : freq) {
            if (fc != '\0') sb.append(fc);
        }
        System.out.println("filtered string       : [" + sb + "]"); // [invisible but only 2 chars]

        // =========================================================
        // 7. The + operator trap: arithmetic vs. string concatenation
        //    Rule: left-to-right; once a String appears, + = concat
        // =========================================================
        int a = 342, b = 100;
        System.out.println("\n--- + operator trap ---");
        System.out.println("\"res=\" + a + b      : " + "res=" + a + b);    // res=342100
        System.out.println("\"res=\" + (a + b)    : " + "res=" + (a + b));  // res=442
        System.out.println("a + b + \"=res\"      : " + (a + b + "=res"));  // 442=res  (int+int first)
        System.out.println("a + b + \"=\" + a + b : " + (a + b + "=" + a + b)); // 442=342100
    }
}
