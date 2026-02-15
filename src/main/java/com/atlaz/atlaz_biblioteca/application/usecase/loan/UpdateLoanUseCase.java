package com.atlaz.atlaz_biblioteca.application.usecase.loan;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateLoanUseCase {

    private final LoanRepository loanRepository;

    public UpdateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan execute(Long id, Loan loanUpdate) {
        // busca um empréstimo existente
        return loanRepository.findById(id)
                .map(existingLoan -> {
                    existingLoan.setRegistration(loanUpdate.getRegistration());
                    existingLoan.setBookCode(loanUpdate.getBookCode());
                    existingLoan.setStartDate(loanUpdate.getStartDate());
                    existingLoan.setEndDate(loanUpdate.getEndDate());
                    existingLoan.setLoanStatus(loanUpdate.getLoanStatus());

                    //salva versão atualizada
                    return loanRepository.save(existingLoan);
                })
                .orElseThrow(() -> new RuntimeException("Empréstimo com o ID: " + id + " não encontrado"));
    }
}
