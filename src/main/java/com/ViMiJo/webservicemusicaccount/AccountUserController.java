package com.ViMiJo.webservicemusicaccount;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/vimijo.com")
public class AccountUserController {

    private final AccountuserService accountUserService;

    @Autowired
    public AccountUserController(AccountuserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    //Hämta en bild. TODO: Eventuellt ändra till at produces.
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response) throws IOException {
        var imgFile = new ClassPathResource("Image/LoginWindow.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    @GetMapping("/getuser/{accountUserId}")
    public Optional<AccountUser> getOneUser(@PathVariable("accountUserId" ) Long accountUserId) {
        return accountUserService.getOneUser(accountUserId);
    }

    @GetMapping("/getusers")
    public List<AccountUser> getAccountUsers() {
        return accountUserService.getAccountusers();
    }

    @PostMapping("/createuser")
    public String newAccountUser(@RequestBody AccountUser accountuser) {
        accountUserService.addNewAccountuser(accountuser);
        return "Användaren skapad: " + accountuser;
    }

    @DeleteMapping(path = "/deleteuser/{accountuserId}")
    public String deleteAccountUser(@PathVariable("accountuserId") Long accountuserId) {
        return accountUserService.deleteaccountuser(accountuserId);
    }

    //Put
    @PutMapping("/updateuser/{accountUserId}")
    public void updateAccountUser(
            @PathVariable("accountUserId") Long accountUserId,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String passWord) {
        accountUserService.updateAccountuser(accountUserId, userName, name, passWord);
    }
}



