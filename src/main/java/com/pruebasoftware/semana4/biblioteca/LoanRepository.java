package com.pruebasoftware.semana4.biblioteca;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(String id);

    List<Loan> findAll();
}
