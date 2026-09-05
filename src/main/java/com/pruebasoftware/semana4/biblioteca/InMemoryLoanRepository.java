package com.pruebasoftware.semana4.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLoanRepository implements LoanRepository {
    private final Map<String, Loan> loans = new ConcurrentHashMap<>();

    @Override
    public Loan save(Loan loan) {
        loans.put(loan.getId(), loan);
        return loan;
    }

    @Override
    public Optional<Loan> findById(String id) {
        return Optional.ofNullable(loans.get(id));
    }

    @Override
    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }
}
