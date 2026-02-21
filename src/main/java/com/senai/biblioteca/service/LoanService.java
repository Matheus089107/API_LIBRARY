package com.senai.biblioteca.service;

import com.senai.biblioteca.DAO.BookDAO;
import com.senai.biblioteca.DAO.LoanDAO;
import com.senai.biblioteca.DAO.UserDAO;
import com.senai.biblioteca.dto.requisicao.LoanRequisition;
import com.senai.biblioteca.dto.respostas.LoanResponse;
import com.senai.biblioteca.mapper.LoanMapper;
import com.senai.biblioteca.model.Loan;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LoanService {
    LoanDAO dao;
    BookDAO daoBook;
    UserDAO daoUser;
    LoanMapper mapper;
    public LoanService(LoanDAO dao, BookDAO daoBook, UserDAO daoUser,LoanMapper mapper){this.dao = dao; this.daoBook = daoBook; this.daoUser = daoUser;this.mapper = mapper;}
    public LoanResponse SignLoan(LoanRequisition requisition){
        try{
            Loan loan = mapper.toEntidy(requisition);
            if(!(daoBook.bookExists(loan.getBookId()) && daoUser.userExists(loan.getUserId()))){
                throw new RuntimeException("Livro ou Usuario não existente");
            }

            return mapper.toResponse(dao.SignLoan(loan));
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<LoanResponse> listLoan(){
        try{
            return mapper.toListResponse(dao.getAllLoans());
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public LoanResponse listLoanId(Long id){
        try{
            return mapper.toResponse(dao.getLoanId(id));
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public LoanResponse updLoan(LoanRequisition requisition, Long id){
        try{
            Loan loan = mapper.toEntidy(requisition);
            return mapper.toResponse(dao.updLoan(loan, id));
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void dltLoan(Long id){
        try{
            dao.dltLoan(id);
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
