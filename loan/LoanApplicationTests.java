package com.example.loan;

import com.example.loan.entity.Loan;
import com.example.loan.repo.LoanRepository;
import com.example.loan.service.LoanService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoanApplicationTests {
    @InjectMocks
    LoanService loanService;
    @Mock
    LoanRepository loanRepository;

    @Test
    void testCreateLoan() {
        Loan loan = new Loan();
        loan.setLoanAmount(10000);
        loan.setInterestRate(5);
        loan.setDuration(12);
        loan.setBorrowerInfo("John");
        loan.setLoanType("Personal Loan");
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);
        Loan loanResponse = loanService.createLoan(loan);
    }

    @Test
    void testGetAllLoans() {
        Loan loan = new Loan();
        loan.setLoanAmount(10000);
        loan.setInterestRate(5);
        loan.setDuration(12);
        loan.setBorrowerInfo("John");
        loan.setLoanType("Personal Loan");
        when(loanRepository.findAll()).thenReturn(List.of(loan));
        List<Loan> loans = loanService.getAllLoans();
    }

    @Test
    void testUpdateLoan() {
        Loan loan = new Loan();
        loan.setId(1l);
        loan.setLoanAmount(10000);
        loan.setInterestRate(5);
        loan.setDuration(12);
        loan.setBorrowerInfo("John");
        loan.setLoanType("Personal Loan");
        when(loanRepository.findById(anyLong())).thenReturn(Optional.of(loan));
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);
        Loan loanResponse = loanService.updateLoan(1l, loan);
    }

    @Test
    void testDeleteLoan() {
        Loan loan = new Loan();
        loan.setLoanAmount(10000);
        loan.setInterestRate(5);
        loan.setDuration(12);
        loan.setBorrowerInfo("John");
        loan.setLoanType("Personal Loan");
        loanService.deleteLoan(1l);
    }
}