package com.example.loan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Loans")
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "loan_amount")
    @NotNull(message = "Loan amount cannot be null")
    private int loanAmount;
    @Column(name = "interest_rate")
    @NotNull(message = "Interest rate cannot be null")
    private int interestRate;
    @Column(name = "duration")
    @NotNull(message = "Loan duration cannot be null")
    private Integer duration;
    @Column(name = "borrower_info")
    @NotNull(message = "Borrower information cannot be null")
    private String borrowerInfo;
    @Column(name = "loan_type")
    @NotNull(message = "Loan Type cannot be null")
    private String loanType;

}