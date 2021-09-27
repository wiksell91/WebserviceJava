package com.ViMiJo.webservicemusicaccount;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table
public class AccountUser {

    @Id
    @SequenceGenerator(
            name = "accountuser_sequence",
            sequenceName = "accountuser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountuser_sequence"
    )

    private Long id;
    private String userName;
    private String name;
    private String password;

    public AccountUser() {
    }

    public AccountUser(String userName, String name, String passWord) {
        this.userName = userName;
        this.name = name;
        this.password = passWord;
    }
}



