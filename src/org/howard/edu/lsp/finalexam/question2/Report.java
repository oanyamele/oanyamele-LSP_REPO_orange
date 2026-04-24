package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class using Template Method pattern.
 * Defines the fixed workflow for generating a report.
 */
public abstract class Report {

    /**
     * Template method (final to prevent override).
     * Defines the workflow.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
    }

    // Steps to be implemented by subclasses
    protected abstract void loadData();
    protected abstract String formatHeader();
    protected abstract String formatBody();
    protected abstract String formatFooter();
}