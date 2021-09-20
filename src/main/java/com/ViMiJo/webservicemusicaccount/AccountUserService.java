package com.ViMiJo.webservicemusicaccount;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class AccountUserService {


    public ArrayList<AccountUser> aul = new ArrayList<AccountUser>();
    public List<AccountUser> allUsers() {
        if(aul.size()==0) {
            AccountUser user1 = new AccountUser(2, "JolleH", "Joel Holewa", "12345");
            AccountUser user2 = new AccountUser(3, "MirreF", "Miranda Frisö", "12345");
            AccountUser user3 = new AccountUser(4, "VirreW", "Victor Wiksell", "12345");
            aul.add(user1);
            aul.add(user2);
            aul.add(user3);
            return aul;
        }
        else{
            return aul;
        }
       //return List.of(new AccountUser(1,"PelleGurkan","Pelle", "Hejsvejs123!"));
    }

    public String createUser(int id,String userName, String name, String passWord) {
        AccountUser userNew = new AccountUser(id, userName, name, passWord);
        aul.add(userNew);
        return "Ny kontoanvändare har lagts till" + aul;

    }

    public AccountUser updateUser(String name) {
        AccountUser accountUser = new AccountUser(10,"joppe", "jonas", "hejsan123");
        accountUser.setName(name);
        return accountUser;
    }

    public AccountUser deleteUser(int id) {
        AccountUser accountUser = new AccountUser("joppe", "jonas", "hejsan123");
        return accountUser;
    }
}
