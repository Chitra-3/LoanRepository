package com.example.loan;
import com.example.loan.entity.Loan;
import com.example.loan.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
public class LoanApplicationTests {
	@MockBean
	private LoanService loanService;
	@Test
	public void testCreateLoan() {
		Loan loan = new Loan();
		loan.setLoanAmount(10000);
		loan.setInterestRate(5);
		loan.setDuration(12);
		loan.setBorrowerInfo("John");
		loan.setLoanType("Personal Loan");
		Loan createdLoan = loanService.createLoans(loan);
		assertNotNull(createdLoan);
		assertEquals(loan.getLoanAmount(), createdLoan.getLoanAmount());
		assertEquals(loan.getInterestRate(), createdLoan.getInterestRate());
		assertEquals(loan.getDuration(), createdLoan.getDuration());
		assertEquals(loan.getBorrowerInfo(), createdLoan.getBorrowerInfo());
		assertEquals(loan.getLoanType(), createdLoan.getLoanType());
	}
	@Test
	public void testUpdateLoan() {
		Loan loan = new Loan();
		loan.setLoanAmount(10000);
		loan.setInterestRate(5);
		loan.setDuration(12);
		loan.setBorrowerInfo("John");
		loan.setLoanType("Personal Loan");
		Loan createdLoan = loanService.updateLoan(loan);
		createdLoan.setInterestRate(6);
		Loan updatedLoan = loanService.updateLoan(createdLoan);
		assertNotNull(updatedLoan);
		assertEquals(createdLoan.getLoanById(), updatedLoan.getLoanById());
		assertEquals(createdLoan.getLoanAmount(), updatedLoan.getLoanAmount());
		assertEquals(createdLoan.getInterestRate(), updatedLoan.getInterestRate());
		assertEquals(createdLoan.getDuration(), updatedLoan.getDuration());
		assertEquals(createdLoan.getBorrowerInfo(), updatedLoan.getBorrowerInfo());
		assertEquals(createdLoan.getLoanType(), updatedLoan.getLoanType());
	}
	@Test
	public void testDeleteLoan() {
		Loan loan = new Loan();
		loan.setLoanAmount(10000);
		loan.setInterestRate(5);
		loan.setDuration(12);
		loan.setBorrowerInfo("John");
		loan.setLoanType("Personal Loan");
		Loan createdLoan = LoanService.deleteLoan(loan);
		loanService.deleteLoan(createdLoan.getLoanById());
		int deletedLoan = loanService.getLoanById(createdLoan.getLoanById());
		assertNotNull(deletedLoan);
	}
}





