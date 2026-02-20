package com.senai.biblioteca.service;

import com.senai.biblioteca.DAO.BookDAO;
import com.senai.biblioteca.DAO.LoanDAO;
import com.senai.biblioteca.DAO.UserDAO;
import com.senai.biblioteca.model.Loan;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LoanService {
    LoanDAO dao;
    BookDAO daoBook;
    UserDAO daoUser;
    public LoanService(LoanDAO dao, BookDAO daoBook, UserDAO daoUser){this.dao = dao; this.daoBook = daoBook; this.daoUser = daoUser;}
    public Loan SignLoan(Loan loan){
        try{
            if(!(daoBook.bookExists(loan.getBookId()) && daoUser.userExists(loan.getUserId()))){
                throw new RuntimeException("Livro ou Usuario não existente");
            }
            return dao.SignLoan(loan);
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Loan> listLoan(){
        try{
            return dao.getAllLoans();
        }catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Loan listLoanId(Long id){
        try{
            return dao.getLoanId(id);
        } catch (SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public Loan updLoan(Loan loan, Long id){
        try{
            return dao.updLoan(loan, id);
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
