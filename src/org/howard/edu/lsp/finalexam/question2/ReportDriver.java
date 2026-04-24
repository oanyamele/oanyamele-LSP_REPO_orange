package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class to demonstrate polymorphism.
 */
public class ReportDriver {
    public static void main(String[] args) {

        List<Report> reports = new ArrayList<>();

        // Add different report types
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        // Polymorphic behavior
        for (Report report : reports) {
            report.generateReport();
        }
    }
}