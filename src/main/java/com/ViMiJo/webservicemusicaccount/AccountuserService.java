package com.ViMiJo.webservicemusicaccount;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AccountuserService {

    private final AccountuserRepository accountuserRepository;

    @Autowired
    public AccountuserService(AccountuserRepository accountuserRepository)
    {
        this.accountuserRepository = accountuserRepository;
    }

    public List<Accountuser> getAccountusers(){
        return accountuserRepository.findAll();
    }

    public void addNewAccountuser(Accountuser accountuser){
        Optional<Accountuser> accountUserOptional =
                accountuserRepository.findAccountuserByUserName(accountuser.getUserName());
        if (accountUserOptional.isPresent()) {
            throw new IllegalStateException("Sorry, användarnamet är upptaget");
        }
        accountuserRepository.save(accountuser);
    }

    public void deleteaccountuser(Long accoutuserId){
        boolean exist = accountuserRepository.existsById(accoutuserId);
        if (!exist){
            throw new IllegalStateException(
                    "Användare med id " + accoutuserId + " finns inte"
            );
        }
        accountuserRepository.deleteById(accoutuserId);
    }

    @Transactional
    public void updateAccountuser(Long accountuserId, String userName, String name, String passWord){
        Accountuser accountuser = accountuserRepository.findById(accountuserId)
                .orElseThrow(()-> new IllegalStateException(
                        "Användare med id " + accountuserId + " finns inte"
                ));
        if(userName != null && userName.length()> 0 && !Objects.equals(accountuser.getUserName(), userName)){
            Optional<Accountuser> accountuserOptional = accountuserRepository
                    .findAccountuserByUserName(userName);
            if (accountuserOptional.isPresent()){
                throw new IllegalStateException("Sorry användarnamnet är upptaget, Hitt på nå nytt ba!");
            }
            accountuser.setUserName(userName);
        }
        if (name != null && name.length() > 0 && !Objects.equals(accountuser.getName(), name))
        {
            accountuser.setName(name);
        }

        if (passWord != null && passWord.length() > 0 && !Objects.equals(accountuser.getPassWord(), passWord))
        {
            accountuser.setPassWord(passWord);
        }


    }

}