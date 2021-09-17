package com.ViMiJo.webservicemusicaccount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

//Get
    @GetMapping("/user")
    public List <AccountUser> allUsers(){
        return List.of(new AccountUser(1, "PelleGurkan","Pelle", "Hejsvejs123!"));

    }

}
