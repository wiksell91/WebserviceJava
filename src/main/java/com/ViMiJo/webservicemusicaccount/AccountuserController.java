package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class AccountuserController {

    private final AccountuserService accountuserService;

    @Autowired
    public AccountuserController(AccountuserService accountuserService) {
        this.accountuserService = accountuserService;
    }

    //Get
    @GetMapping
    public List<Accountuser> getaccountusers(){
        return accountuserService.getAccountusers();
    }

    //GET en användare
    @GetMapping("{accountuserId}")
    public Optional<Accountuser> oneUser(@PathVariable("accountuserId" ) Long accountuserId) {
        return accountuserService.oneUser(accountuserId);
    }

    //Post
    @PostMapping
    public void newAccountuser(@RequestBody Accountuser accountuser){
        accountuserService.addNewAccountuser(accountuser);
    }


    //Delete
    @DeleteMapping(path = "{accountuserId}")
    public void deleteAccountuser(@PathVariable("accountuserId")Long accountuserId){
        accountuserService.deleteaccountuser(accountuserId);
    }

    //Put
    @PutMapping("{accountUserId}")
    public void updateAccountUser(
            @PathVariable("accountUserId") Long accountUserId,
            @RequestParam(required = false)String userName,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String passWord){
            accountuserService.updateAccountuser(accountUserId,userName, name, passWord);
    }
}



