package com.senai.biblioteca.dto.respostas;

import java.sql.Date;

public record LoanResponse(long id, long bookId, long userId, Date loanDate, Date returnDate) {
}
