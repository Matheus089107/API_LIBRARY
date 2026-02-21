package com.senai.biblioteca.controller;

import com.senai.biblioteca.dto.requisicao.LoanRequisition;
import com.senai.biblioteca.dto.respostas.LoanResponse;
import com.senai.biblioteca.model.Loan;
import com.senai.biblioteca.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public LoanResponse signLoan(@RequestBody LoanRequisition loan) {
        return service.SignLoan(loan);
    }

    @PutMapping
    public LoanResponse UpdLoan(@RequestBody LoanRequisition loan, @PathVariable Long id) {
        return service.updLoan(loan, id);
    }

    @GetMapping
    public List<LoanResponse> listLoan() {
        return service.listLoan();
    }

    @GetMapping("/{id}")
    public LoanResponse listLoanId(@PathVariable Long id) {
        return service.listLoanId(id);
    }

    @PutMapping("/{id}")
    public Loan returnBook() {
        return null;
    }

    @DeleteMapping("/{id}")
    public void dltLoan(@PathVariable Long id) {
        service.dltLoan(id);
    }
}
