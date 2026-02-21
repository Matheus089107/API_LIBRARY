package com.senai.biblioteca.dto.requisicao;

import java.sql.Date;

public record LoanRequisition(Long bookId, Long userId, Date loanDate, Date returnDate) {
}
