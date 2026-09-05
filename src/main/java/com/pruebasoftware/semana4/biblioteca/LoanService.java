package com.pruebasoftware.semana4.biblioteca;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = Objects.requireNonNull(loanRepository, "loanRepository is required");
    }

    public Loan registerLoan(String id, String bookTitle, String borrowerName, LocalDate loanDate, LocalDate dueDate) {
        Loan loan = new Loan(id, bookTitle, borrowerName, loanDate, dueDate);
        return loanRepository.save(loan);
    }

    public Optional<Loan> findLoan(String id) {
        return loanRepository.findById(id);
    }

    public List<Loan> listLoans() {
        return loanRepository.findAll();
    }
}
