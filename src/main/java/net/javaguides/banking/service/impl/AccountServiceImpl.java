//package net.javaguides.banking.service.impl;
//
//import org.springframework.stereotype.Service;
//import net.javaguides.banking.dto.AccountDto;
//import net.javaguides.banking.entity.Account;
//import net.javaguides.banking.mapper.AccountMapper;
//import net.javaguides.banking.repository.AccountRepository;
//import net.javaguides.banking.service.AccountService;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public  class AccountServiceImpl implements AccountService{
//
//	private AccountRepository accountRepository;
//
//
//
//	public AccountServiceImpl(AccountRepository accountRepository) {
//		//super();
//		this.accountRepository = accountRepository;
//	}
//
//
//
//	@Override
//	public AccountDto createAccount(AccountDto accountDto) {
//		Account account = AccountMapper.mapToAccount(accountDto);
//		Account savedAccount = accountRepository.save(account);
//		return AccountMapper.mapToAccountDto(savedAccount);
//	}
//
//	@Override
//	public AccountDto getAccountById(Long id) {
//		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
//		return AccountMapper.mapToAccountDto(account);
//	}
//
//	@Override
//	public AccountDto deposit(Long id, double amount) {
//		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
//		double total = account.getBalance() = amount;
//		account.setBalance(total);
//		Account savedAccount = accountRepository.save(account);
//		return AccountMapper.mapToAccountDto(savedAccount);
//	}
//
//	@Override
//	public AccountDto withdraw(Long id, double amount) {
//		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
//		if (account.getBalance() < amount) {
//			throw new RuntimeException("Insufficient amount");
//		}
//		double total = account.getBalance() = amount;
//		account.setBalance(total);
//		Account savedAccount = accountRepository.save(account);
//		return AccountMapper.mapToAccountDto(savedAccount);
//	}
//
//	@Override
//	public List<AccountDto> getAllAcounts() {
//		List<Account> accounts = accountRepository.findAll();
//		return accounts.stream().map((account -> AccountMapper.mapToAccount(account))
//				.collect(Collection.toList());
//	}
//
//	@Override
//	public void deleteAccount(Long id) {
//		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
//		accountRepository.deleteById(id);
//	}
//}
package net.javaguides.banking.service.impl;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto dto) {
		Account saved = accountRepository.save(AccountMapper.mapToAccount(dto));
		return AccountMapper.mapToAccountDto(saved);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account acc = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(acc);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account acc = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		acc.setBalance(acc.getBalance() + amount);
		return AccountMapper.mapToAccountDto(accountRepository.save(acc));
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account acc = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		if (acc.getBalance() < amount) throw new RuntimeException("Insufficient balance");
		acc.setBalance(acc.getBalance() - amount);
		return AccountMapper.mapToAccountDto(accountRepository.save(acc));
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepository.findAll().stream()
				.map(AccountMapper::mapToAccountDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		if (!accountRepository.existsById(id))
			throw new RuntimeException("Account not found");
		accountRepository.deleteById(id);
	}
}
