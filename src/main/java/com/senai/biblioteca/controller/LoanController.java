package com.senai.biblioteca.controller;

import com.senai.biblioteca.model.Loan;
import com.senai.biblioteca.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {
    LoanService service;
    @PutMapping
    public Loan updLoan(){
        return null;
    }
    @PostMapping
    public Loan cadastrarLoan(){
        return null;
    }
    @GetMapping
    public Loan listLoan() {
    return null;
    }
    @GetMapping("/{id}")
    public Loan listLoanId(){
        return null;
    }
    @PutMapping("/{id}")
    public Loan updLoanId(){
        return null;
    }

}
