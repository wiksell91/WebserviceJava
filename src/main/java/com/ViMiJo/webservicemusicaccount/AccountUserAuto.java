package com.ViMiJo.webservicemusicaccount;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountUserAuto {

    @Bean
    CommandLineRunner commandLineRunner(AccountUserRepository repository){
        return args -> {
            AccountUser joel = new AccountUser(
                    "JolleH",
                    "Joel Holewa",
                    "1234"
            );
            AccountUser miranda = new AccountUser(
                    "MirreF",
                    "Miranda Frisö",
                    "4weqw"
            );
            AccountUser victor = new AccountUser(
                    "VirreW",
                    "Victor Wiksell",
                    "7872"
            );

            repository.saveAll(
                    List.of(joel, miranda, victor)
            );

        };
    }
}
