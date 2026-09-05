package com.pruebasoftware.semana4.biblioteca;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoanServiceIntegrationTest {
    @Test
    void registerLoanPersistsItInRepository() {
        LoanRepository repository = new InMemoryLoanRepository();
        LoanService service = new LoanService(repository);

        service.registerLoan(
                "loan-100",
                "Domain-Driven Design",
                "Maria Torres",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 15)
        );

        Optional<Loan> savedLoan = service.findLoan("loan-100");

        assertTrue(savedLoan.isPresent());
        assertEquals("Domain-Driven Design", savedLoan.get().getBookTitle());
        assertEquals("Maria Torres", savedLoan.get().getBorrowerName());
    }
}
