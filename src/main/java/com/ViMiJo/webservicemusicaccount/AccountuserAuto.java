
package com.ViMiJo.webservicemusicaccount;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class AccountuserAuto {

    @Bean
    CommandLineRunner commandLineRunner(AccountuserRepository repository){
        return args -> {
            Accountuser joel = new Accountuser(
                    "JolleH",
                    "Joel Holewa",
                    "1234"
            );
            Accountuser miranda = new Accountuser(
                    "MirreF",
                    "Miranda Frisö",
                    "4weqw"
            );
            Accountuser victor = new Accountuser(
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
