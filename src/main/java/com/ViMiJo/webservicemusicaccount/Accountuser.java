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
public class Accountuser {
                //TODO: Autogenerera Id eller felhantgering vid id  -- skriva en autogeneringsmetod?
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
    private String passWord;

    public Accountuser() {
    }

    //public Accountuser(Long id, String userName, String name, String passWord) {  //tar bort id från konstruktorn för tänker att en "user" inte behöver skriva sitt egna id?
      //  this.id = id;
        //this.userName = userName;
        //this.name = name;
        //this.passWord = passWord;
    //}

    public Accountuser(String userName, String name, String passWord) {
        this.userName = userName;
        this.name = name;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Accountuser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}



