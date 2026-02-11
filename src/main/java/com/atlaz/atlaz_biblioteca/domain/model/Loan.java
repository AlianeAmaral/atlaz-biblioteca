package com.atlaz.atlaz_biblioteca.domain.model;

import java.time.LocalDateTime;

public class Loan {
    private Long id;
    private Long studentId;
    private Long bookId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LoanStatus loanStatus;

    public Loan(Long id, Long studentId, Long bookId, LocalDateTime startDate, LocalDateTime endDate, LoanStatus loanStatus) {
        this.id = id;
        this.studentId = studentId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loanStatus = loanStatus;
    }

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}