package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.hibernate.engine.jdbc.StreamUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/vimijo.com")
public class AccountuserController {

    private final AccountuserService accountuserService;

    @Autowired
    public AccountuserController(AccountuserService accountuserService) {
        this.accountuserService = accountuserService;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response) throws IOException {
        var imgFile = new ClassPathResource("Image/LoginWindow.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    //GET en användare
    @GetMapping(value = "/user/{accountUserId}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Optional<Accountuser> oneUser(@PathVariable("accountUserId" ) Long accountUserId) {
        return accountuserService.oneUser(accountUserId);
    }

    @GetMapping(path ="/users", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public List<Accountuser> getAccountUsers() {
        return accountuserService.getAccountUsers();
    }

    //Post
    @PostMapping
    public void newAccountuser(@RequestBody Accountuser accountuser){
        accountuserService.addNewAccountuser(accountuser);
    }


    //Delete
    @DeleteMapping(path = "{accountuserId}")
    public void deleteAccountuser(@PathVariable("accountuserId")Long accountuserId){
        accountuserService.deleteaccountuser(accountuserId);
    }

    //Put
    @PutMapping("{accountUserId}")
    public void updateAccountUser(
            @PathVariable("accountUserId") Long accountUserId,
            @RequestParam(required = false)String userName,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String passWord){
            accountuserService.updateAccountuser(accountUserId,userName, name, passWord);
    }
}



