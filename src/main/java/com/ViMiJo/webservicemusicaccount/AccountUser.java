package com.ViMiJo.webservicemusicaccount;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class AccountUser {
    //TODO: Autogenerera Id eller felhantgering vid id  -- skriva en autogeneringsmetod?
    private int id;
    private String userName;
    private String name;
    private String passWord;

    public AccountUser(String userName, String name, String passWord) {  //tar bort id från konstruktorn för tänker att en "user" inte behöver skriva sitt egna id?
        this.userName = userName;
        this.name = name;
        this.passWord = passWord;
    }
}
