package com.ViMiJo.webservicemusicaccount;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountUserService {
    TestUserHandler testUserHandler = new TestUserHandler();
    ArrayList<AccountUser> accountUsersList = testUserHandler.getAccountUsersList();

    public List<AccountUser> getUsers() {
        if (accountUsersList.size() == 0) {
            testUserHandler.createTestUsers();
        }
        return testUserHandler.getAccountUsersList();
    }

    public String createUser(String userName, String name, String passWord) {
        AccountUser userNew = new AccountUser(userName, name, passWord);
        accountUsersList.add(userNew);
        return "Ny kontoanvändare har lagts till" + accountUsersList;
    }

    public AccountUser updateUser(String name) {
        AccountUser accountUser = new AccountUser("joppe", "jonas", "hejsan123");
        accountUser.setName(name);
        return accountUser;
    }

    public String deleteUser(int id) {
        accountUsersList.remove(id - 1);
        return "" + accountUsersList;
    }

    public AccountUser getOneUser(int id) {
        return accountUsersList.get(id - 1);
    }
}
