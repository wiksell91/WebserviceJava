package com.ViMiJo.webservicemusicaccount;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class TestUserHandler {
    public ArrayList<AccountUser> accountUsersList = new ArrayList<AccountUser>();

    public void createTestUsers() {
        AccountUser user1 = new AccountUser( "JolleH", "Joel Holewa", "12345");
        AccountUser user2 = new AccountUser( "MirreF", "Miranda Frisö", "12345");
        AccountUser user3 = new AccountUser( "VirreW", "Victor Wiksell", "12345");

        accountUsersList.add(user1);
        accountUsersList.add(user2);
        accountUsersList.add(user3);
    }
}
