package com.pruebasoftware.semana4.biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Loan {
    private final String id;
    private final String bookTitle;
    private final String borrowerName;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public Loan(String id, String bookTitle, String borrowerName, LocalDate loanDate, LocalDate dueDate) {
        this.id = requireText(id, "id");
        this.bookTitle = requireText(bookTitle, "bookTitle");
        this.borrowerName = requireText(borrowerName, "borrowerName");
        this.loanDate = Objects.requireNonNull(loanDate, "loanDate is required");
        this.dueDate = Objects.requireNonNull(dueDate, "dueDate is required");

        if (dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("dueDate cannot be before loanDate");
        }
    }

    public int calculateDaysLate(LocalDate returnDate) {
        Objects.requireNonNull(returnDate, "returnDate is required");

        if (!returnDate.isAfter(dueDate)) {
            return 0;
        }

        return Math.toIntExact(ChronoUnit.DAYS.between(dueDate, returnDate));
    }

    public String getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
        return value;
    }
}
