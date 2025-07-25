//package net.javaguides.banking.service;
//
//import net.javaguides.banking.dto.AccountDto;
//
//import java.util.List;
//
//public interface AccountService {
//
//	AccountDto createAccount(AccountDto accountDto);
//
//	AccountDto getAccountById(Long id);
//
//	AccountDto deposit(Long id , double amount);
//
//	AccountDto withdraw(Long id, double amount);
//
//	List<AccountDto> getAllAcounts();
//
//	void deleteAccount(Long id);
//
//}
package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;
import java.util.List;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto deposit(Long id, double amount);
	AccountDto withdraw(Long id, double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(Long id);
}
