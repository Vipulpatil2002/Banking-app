//package net.javaguides.banking.controller;
//import net.javaguides.banking.dto.AccountDto;
//import net.javaguides.banking.service.AccountService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/accounts")
//public class AccountController {
//
//    private AccountService accountService;
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }
//
//    // Add Account REST API
//    @PostMapping
//    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
//        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
//    }
//
//
//    // Get Account REST API
//    @GetMapping("/{id}")
//    public ResponseEntity<AccountDto>getAccountById(@PathVariable long id){
//        AccountDto accountDto = accountService.getAccountById(id);
//        return ResponseEntity.ok(accountDto);
//    }
//
//    // Deposit REST API
//    @PutMapping("/{id}/deposit")
//    public ResponseEntity<AccountDto>deposit(@PathVariable long id ,
//                                             @RequestBody Map<String, Double>request){
//        Double amount = request.get("amount");
//        AccountDto accountDto = accountService.deposit(id,amount);
//        return ResponseEntity.ok(accountDto);
//    }
//
//
//    // Withdraw REST API
//    @PutMapping("/{id}/withdraw")
//    public ResponseEntity<AccountDto>withdraw(@PathVariable long id,
//                                              @RequestBody Map<String, Double> request){
//        double amount = request.get("amount");
//        AccountDto accountDto = accountService.withdraw(id,amount);
//        return ResponseEntity.ok(accountDto);
//    }
//
//
//    // Get All Accounts REST API
//    @GetMapping
//    public ResponseEntity<List<AccountDto>>getAllAccounts(){
//       List<AccountDto> accounts = accountService.getAllAcounts();
//       return ResponseEntity.ok(accounts);
//    }
//
//
//    // Delete Accout REST API
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String>deleteAccount(@PathVariable Long id){
//        accountService.deleteAccount(id);
//        return ResponseEntity.ok("Account is deleted successfully ");
//    }
//}
package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService service) {
        this.accountService = service;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto dto) {
        return ResponseEntity.status(201).body(accountService.createAccount(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return ResponseEntity.ok(accountService.deposit(id, body.get("amount")));
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        return ResponseEntity.ok(accountService.withdraw(id, body.get("amount")));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully.");
    }
}
