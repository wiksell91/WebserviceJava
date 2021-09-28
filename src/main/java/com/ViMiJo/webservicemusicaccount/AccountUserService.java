package com.ViMiJo.webservicemusicaccount;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountUserService {

    private final AccountUserRepository accountuserRepository;

    @Autowired
    public AccountUserService(AccountUserRepository accountuserRepository) {
        this.accountuserRepository = accountuserRepository;
    }

    public List<AccountUser> getAccountusers() {
        return accountuserRepository.findAll();
    }

    public Optional<AccountUser> getOneUser(long id) {
        return accountuserRepository.findById(id);
    }

    public String addNewAccountuser(AccountUser accountuser) {
        Optional<AccountUser> accountUserOptional =
                accountuserRepository.findAccountuserByUserName(accountuser.getUserName());
        if (accountUserOptional.isPresent()) {
            throw new IllegalStateException("Sorry, användarnamet är upptaget");
        }
        accountuserRepository.save(accountuser);
        return "Användare  " +
                accountuserRepository.findAccountuserByUserName(accountuser.getUserName()) +
                " är nu skapad!";
    }

    public String deleteaccountuser(Long accoutuserId) {
        boolean exist = accountuserRepository.existsById(accoutuserId);
        if (!exist) {
            throw new IllegalStateException(
                    "Användare med id " + accoutuserId + " finns inte"
            );
        }

        accountuserRepository.deleteById(accoutuserId);
        return "Användaren med id  " + accoutuserId + " är raderad";
    }

    @Transactional
    public void updateAccountuser(Long accountuserId, String userName, String name, String passWord) {
        AccountUser accountuser = accountuserRepository.findById(accountuserId)
                .orElseThrow(() -> new IllegalStateException(
                        "Användare med id " + accountuserId + " finns inte"
                ));
        if (userName != null && userName.length() > 0 && !Objects.equals(accountuser.getUserName(), userName)) {
            Optional<AccountUser> accountuserOptional = accountuserRepository
                    .findAccountuserByUserName(userName);
            if (accountuserOptional.isPresent()) {
                throw new IllegalStateException("Sorry användarnamnet är upptaget, Hitt på nå nytt ba!");
            }
            accountuser.setUserName(userName);
        }
        if (name != null && name.length() > 0 && !Objects.equals(accountuser.getName(), name)) {
            accountuser.setName(name);
        }

        if (passWord != null && passWord.length() > 0 && !Objects.equals(accountuser.getPassword(), passWord)) {
            accountuser.setPassword(passWord);
        }
    }
}
