package net.javaguides.banking.mapper;

//import net.javaguides.banking.dto.AccountDto;
//import net.javaguides.banking.entity.Account;
//
//public class AccountMapper {
//
//	public static Account mapToAccount(AccountDto accountDto) {
//		Account account = new Account(
//				accountDto.id(),
//				accountDto.accountHolderName(),
//				accountDto.balance()
//				);
//
//		return account;
//
//	}
//
//	public static AccountDto mapToAccountDto(Account account) {
//		AccountDto accountDto = new AccountDto(
//				account.getId(),
//				account.getAccountHolderName(),
//				account.getBalance()
//				);
//
//		return accountDto;
//	}
//}


import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto dto) {
		return new Account(dto.id(), dto.accountHolderName(), dto.balance());
	}

	public static AccountDto mapToAccountDto(Account account) {
		return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
	}
}
