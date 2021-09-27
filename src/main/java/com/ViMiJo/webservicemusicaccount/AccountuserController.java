package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/vimijo.com")
public class AccountuserController {

    private final AccountuserService accountuserService;

    @Autowired
    public AccountuserController(AccountuserService accountuserService) {
        this.accountuserService = accountuserService;
    }



    //GET en användare
    @GetMapping("{accountuserId}")
    public Optional<Accountuser> oneUser(@PathVariable("accountuserId" ) Long accountuserId) {
        return accountuserService.oneUser(accountuserId);
    }

    @GetMapping(path ="/users", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public List<Accountuser> getAccountUsers() {
        return accountuserService.getAccountUsers();
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



