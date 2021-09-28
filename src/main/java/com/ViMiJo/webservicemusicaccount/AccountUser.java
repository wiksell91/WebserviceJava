package com.ViMiJo.webservicemusicaccount;

//Kolla upp persistence!
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

    @Id
    //Tilldelar key-value (primary key)- Hur det läggs in i databasen.
    @SequenceGenerator(
            name = "accountuser_sequence",
            sequenceName = "accountuser_sequence",
            allocationSize = 1
    )
    //Genererar id
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

    public Accountuser(String userName, String name, String passWord) {
        this.userName = userName;
        this.name = name;
        this.passWord = passWord;
    }
}



