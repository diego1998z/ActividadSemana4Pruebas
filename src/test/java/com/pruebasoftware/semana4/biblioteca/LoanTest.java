package com.pruebasoftware.semana4.biblioteca;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanTest {
    @Test
    void calculateDaysLateReturnsZeroWhenBookIsReturnedBeforeDueDate() {
        Loan loan = new Loan(
                "loan-0",
                "Effective Java",
                "Lucia Ramos",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 10)
        );

        int daysLate = loan.calculateDaysLate(LocalDate.of(2026, 9, 8));

        assertEquals(5, daysLate);
    }

    @Test
    void calculateDaysLateReturnsZeroWhenBookIsReturnedOnDueDate() {
        Loan loan = new Loan(
                "loan-1",
                "Clean Code",
                "Ana Perez",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 10)
        );

        int daysLate = loan.calculateDaysLate(LocalDate.of(2026, 9, 10));

        assertEquals(0, daysLate);
    }

    @Test
    void calculateDaysLateReturnsDifferenceWhenBookIsReturnedAfterDueDate() {
        Loan loan = new Loan(
                "loan-2",
                "Refactoring",
                "Luis Gomez",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 10)
        );

        int daysLate = loan.calculateDaysLate(LocalDate.of(2026, 9, 14));

        assertEquals(4, daysLate);
    }
}
