package com.oca.oops.abstraction;

/**
 * Demonstrates a class implementing MULTIPLE interfaces simultaneously.
 *
 * Java does not support multiple class inheritance (a class cannot extend two classes).
 * However, a class CAN implement multiple interfaces — this is how Java achieves
 * a form of multiple inheritance of type.
 *
 * OCA Exam focus:
 * - A class implements multiple interfaces separated by commas: implements A, B, C
 * - The class must provide concrete implementations for ALL abstract methods
 *   from ALL interfaces (or be declared abstract itself)
 * - If two interfaces declare the same default method, the implementing class
 *   MUST override it to resolve the conflict (diamond problem)
 * - A class can extend one class AND implement multiple interfaces at the same time
 */

// Interface 1
interface Printable {
    void print();

    default String getFormat() {
        return "Default format";
    }
}

// Interface 2
interface Saveable {
    void save();

    default String getStorageType() {
        return "Default storage";
    }
}

// Interface 3 — shares a default method name with Printable to show conflict resolution
interface Exportable {
    void export(String destination);

    // Same method name as Printable.getFormat() -> forces conflict resolution below
    default String getFormat() {
        return "Export format";
    }
}

/**
 * Document implements all three interfaces.
 * It must implement all abstract methods: print(), save(), export().
 * It must ALSO override getFormat() because both Printable and Exportable
 * declare it as a default method — the compiler will not compile without resolving this.
 */
class Document implements Printable, Saveable, Exportable {

    private String title;
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("[PRINT] " + title + ": " + content);
    }

    @Override
    public void save() {
        System.out.println("[SAVE] Saving document: " + title);
    }

    @Override
    public void export(String destination) {
        System.out.println("[EXPORT] Exporting '" + title + "' to " + destination);
    }

    /**
     * MUST override getFormat() — both Printable and Exportable have a default
     * version and the compiler cannot choose between them without this override.
     * We can delegate to one of them using InterfaceName.super.method().
     */
    @Override
    public String getFormat() {
        return Printable.super.getFormat() + " / " + Exportable.super.getFormat();
    }
}

/**
 * SmartPrinter extends one class AND implements two interfaces.
 * Demonstrates: extends + implements together.
 */
abstract class BasePrinter {
    abstract void warmUp();
}

class SmartPrinter extends BasePrinter implements Printable, Saveable {

    @Override
    public void warmUp() {
        System.out.println("[PRINTER] Warming up...");
    }

    @Override
    public void print() {
        System.out.println("[PRINTER] Printing document...");
    }

    @Override
    public void save() {
        System.out.println("[PRINTER] Saving print job...");
    }
}

public class MultipleInterfaces {

    public static void main(String[] args) {

        // --- Document: implements 3 interfaces ---
        System.out.println("--- Document (implements Printable, Saveable, Exportable) ---");
        Document doc = new Document("Report", "Q1 results");
        doc.print();
        doc.save();
        doc.export("/tmp/report.pdf");
        System.out.println("Format: " + doc.getFormat()); // resolved diamond

        // --- Polymorphism through interface references ---
        System.out.println("\n--- Interface reference polymorphism ---");
        Printable p = doc;  // Document IS-A Printable
        Saveable s = doc;   // Document IS-A Saveable
        Exportable e = doc; // Document IS-A Exportable

        p.print();
        s.save();
        e.export("/backup");

        // --- SmartPrinter: extends class + implements 2 interfaces ---
        System.out.println("\n--- SmartPrinter (extends BasePrinter + implements Printable, Saveable) ---");
        SmartPrinter printer = new SmartPrinter();
        printer.warmUp(); // from BasePrinter
        printer.print();  // from Printable
        printer.save();   // from Saveable

        // instanceof checks across multiple interfaces
        System.out.println("\n--- instanceof across multiple interfaces ---");
        System.out.println("doc instanceof Printable:  " + (doc instanceof Printable));
        System.out.println("doc instanceof Saveable:   " + (doc instanceof Saveable));
        System.out.println("doc instanceof Exportable: " + (doc instanceof Exportable));
        System.out.println("printer instanceof Exportable: " + (printer instanceof Exportable)); // false
    }
}
