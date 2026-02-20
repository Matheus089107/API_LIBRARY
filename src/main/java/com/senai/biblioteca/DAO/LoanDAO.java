package com.senai.biblioteca.DAO;

import com.senai.biblioteca.model.Loan;
import com.senai.biblioteca.utils.DataBase;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository
public class LoanDAO {

    public Loan SignLoan(Loan loan) throws SQLException{
        String query = "insert into emprestimo (livro_id, usuario_id, data_emprestimo, data_devolucao) values (?,?,?,?)";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setLong(1, loan.getBookId());
            stmt.setLong(2, loan.getUserId());
            stmt.setDate(3, loan.getLoanDate());
            stmt.setDate(4, loan.getReturnDate());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                loan.setId(rs.getLong(1));
            }
        }
        return loan;
    }

    public List<Loan> getAllLoans() throws SQLException{
        String query = "select id, livro_id, usuario_id, data_emprestimo, data_devolucao from emprestimo";
        List<Loan> loans = new ArrayList<>();
        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                loans.add(new Loan(rs.getLong("id"),
                        rs.getLong("livro_id"),
                        rs.getLong("usuario_id"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("data_devolucao")));
            }
            return loans;
        }
    }
    public Loan getLoanId(Long id) throws SQLException{
        String query = "select id, livro_id, usuario_id, data_emprestimo, data_devolucao from emprestimo where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return new Loan(rs.getLong("id"), rs.getLong("livro_id"), rs.getLong("usuario_id"),rs.getDate("data_emprestimo"), rs.getDate("data_devolucao"));
            }
        }
        return null;
    }
    public Loan updLoan (Loan loan, Long id) throws SQLException{
        String query = "update emprestimo set livro_id, usuario_id, data_emprestimo, data_devolucao where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setLong(1,loan.getBookId());
            stmt.setLong(2, loan.getUserId());
            stmt.setDate(3, loan.getLoanDate());
            stmt.setDate(4, loan.getReturnDate());
            stmt.executeUpdate();
        }
        loan.setId(id);
        return loan;
    }

    public void dltLoan (Long id) throws SQLException{
        String query = "delete from emprestimo where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public Date addLoanDevolution(Long id, Date dateReturnal) throws SQLException{
        String query = "update emprestimo set data_devolucao = ? where id = ?";

        try(Connection conn = DataBase.connect();
        var stmt = conn.prepareStatement(query)){

            stmt.setDate(1, dateReturnal);
            stmt.setLong(2, id);
            stmt.executeUpdate();

        }
        return dateReturnal;
    }
}
