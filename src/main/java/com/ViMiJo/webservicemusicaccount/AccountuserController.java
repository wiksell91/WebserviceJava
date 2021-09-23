package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class AccountuserController {

    private final AccountuserService accountUserService;

    @Autowired
    public AccountuserController(AccountuserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    //Get
    @GetMapping
    public List<Accountuser> getaccountusers(){
        return accountUserService.getAccountusers();
    }

    //Post
    @PostMapping
    public void newAccountuser(@RequestBody Accountuser accountuser){
        accountUserService.addNewAccountuser(accountuser);
    }

    //Delete
    @DeleteMapping(path = "{accountuserId}")
    public void deleteAccountuser(@PathVariable("accountuserId")Long accountuserId){
        accountUserService.deleteaccountuser(accountuserId);
    }

    //Put
    @PutMapping("{accountUserId}")
    public void updateAccountUser(
            @PathVariable("accountUserId") Long accountUserId,
            @RequestParam(required = false)String userName,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String passWord){
            accountUserService.updateAccountuser(accountUserId,userName, name, passWord);
    }
}



