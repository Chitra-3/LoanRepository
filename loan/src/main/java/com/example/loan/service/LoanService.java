package com.example.loan.service;
import com.example.loan.entity.Loan;
import com.example.loan.exception.ResourceNotFoundException;
import com.example.loan.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {

        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {

        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id " + id));
    }

    public Loan updateLoan(Long id, Loan loanDetails) {
        Loan loan = getLoanById(id);

        loan.setLoanAmount(loanDetails.getLoanAmount());
        loan.setInterestRate(loanDetails.getInterestRate());
        loan.setDuration(loanDetails.getDuration());
        loan.setBorrowerInfo(loanDetails.getBorrowerInfo());
        loan.setLoanType(loanDetails.getLoanType());

        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {

        loanRepository.deleteById(id);
    }
}


