package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete implementation for student report.
 */
public class StudentReport extends Report {

    private String studentName;
    private double gpa;

    @Override
    protected void loadData() {
        // Hardcoded per instructions
        studentName = "John Doe";
        gpa = 3.8;
    }

    @Override
    protected String formatHeader() {
        return "Student Report";
    }

    @Override
    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    @Override
    protected String formatFooter() {
        return "End of Student Report";
    }
}