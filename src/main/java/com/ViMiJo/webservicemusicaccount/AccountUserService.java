package com.ViMiJo.webservicemusicaccount;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserService {

    public List<AccountUser> allUsers() {
       return List.of(new AccountUser("PelleGurkan","Pelle", "Hejsvejs123!"));
    }

    public AccountUser createUser(String userName, String name, String password) {
        return new AccountUser(userName,name,password);
    }

    public AccountUser updateUser(String name) {
        AccountUser accountUser = new AccountUser("joppe", "jonas", "hejsan123");
        accountUser.setName(name);
        return accountUser;
    }

    public AccountUser deleteUser(int id) {
        AccountUser accountUser = new AccountUser("joppe", "jonas", "hejsan123");
        return accountUser;
    }
}
