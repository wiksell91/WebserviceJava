package com.ViMiJo.webservicemusicaccount;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class AccountUserController {

    private final AccountuserService accountUserService;

    @Autowired
    public AccountUserController(AccountuserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    //Hämta en bild. TODO: Eventuellt ändra till at produces.
    @RequestMapping(value = "/argViking", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response) throws IOException {
        var imgFile = new ClassPathResource("image/victor.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
    @GetMapping
    public List<AccountUser> getAccountUsers(){
        return accountUserService.getAccountusers();
    }

    @PostMapping
    public void newAccountUser(@RequestBody AccountUser accountuser){
        accountUserService.addNewAccountuser(accountuser);
    }

    @DeleteMapping(path = "{accountuserId}")
    public void deleteAccountUser(@PathVariable("accountuserId")Long accountuserId){
        accountUserService.deleteaccountuser(accountuserId);
    }

    //Put
    @PutMapping("{accountUserId}")
    public void updateAccountUser(
            @PathVariable("accountUserId") Long accountUserId,
            @RequestParam(required = false)String userName,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String passWord){
            accountUserService.updateAccountuser(accountUserId,userName, name, passWord);
    }
}



