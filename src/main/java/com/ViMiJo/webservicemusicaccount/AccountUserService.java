package com.ViMiJo.webservicemusicaccount;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountUserService {

    public ArrayList<AccountUser> aul = new ArrayList<AccountUser>();

    public List<AccountUser> allUsers() {
        if(aul.size()==0) {
            AccountUser user1 = new AccountUser( "JolleH", "Joel Holewa", "12345");
            AccountUser user2 = new AccountUser( "MirreF", "Miranda Frisö", "12345");
            AccountUser user3 = new AccountUser( "VirreW", "Victor Wiksell", "12345");
            aul.add(user1);
            aul.add(user2);
            aul.add(user3);
        }
            return aul;
    }

    public String createUser(String userName, String name, String passWord) {
        AccountUser userNew = new AccountUser( userName, name, passWord);
        aul.add(userNew);
        return "Ny kontoanvändare har lagts till" + aul;
    }

    public AccountUser updateUser(String name) {
        AccountUser accountUser = new AccountUser("joppe", "jonas", "hejsan123");
        accountUser.setName(name);
        return accountUser;
    }

    public String deleteUser(int id) {
        aul.remove(id - 1);
        return "" + aul;
    }
}
