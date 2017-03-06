package accounts.controller;

import accounts.domain.Account;
import accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    public String home() {
        return "Welcome to [ Accounts Service ] !";
    }

    @RequestMapping(path = "/findAccount/{accountId}", method = RequestMethod.GET)
    public Account findAccount(@PathVariable int accountId){
        System.out.println("[FindAccount] Id:" + accountId);
        return accountService.findById(accountId);
    }

    @RequestMapping(path = "/createNewAccount", method = RequestMethod.POST)
    public Account createNewAccount(@RequestBody Account newAccount){
        System.out.println("[CreateAccount] Name:" + newAccount.getName());
        return accountService.create(newAccount);
    }

    @RequestMapping(path = "/saveAccountInfo", method = RequestMethod.PUT)
    public Account saveAccountInfo(@RequestBody Account account){
        System.out.println("[SaveAccountInfo] Id:" + account.getId());
        return accountService.saveChanges(account);
    }

}
