package com.senai.biblioteca.mapper;

import com.senai.biblioteca.dto.requisicao.LoanRequisition;
import com.senai.biblioteca.dto.respostas.LoanResponse;
import com.senai.biblioteca.model.Book;
import com.senai.biblioteca.model.Loan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanMapper {

    public Loan toEntidy(LoanRequisition requisition){
        return new Loan(requisition.bookId(), requisition.userId(), requisition.loanDate(), requisition.returnDate());

    }
    public LoanResponse toResponse(Loan loan){
        return new LoanResponse(loan.getId(), loan.getBookId(), loan.getUserId(), loan.getLoanDate(),loan.getReturnDate());
    }
    public List<LoanResponse> toListResponse(List<Loan> response){
        List<LoanResponse> responses = new ArrayList<>();

        for(Loan loan : response){
            responses.add(toResponse(loan));
        }
        return responses;
    }

}
