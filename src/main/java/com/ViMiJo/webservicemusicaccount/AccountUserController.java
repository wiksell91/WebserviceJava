package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    //Hämta en bild. TODO: startsida med inloggning
    @RequestMapping(value = "/argviking", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response) throws IOException {
        var imgFile = new ClassPathResource("Image/victor.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    //Get
    @GetMapping("/getusers")
    public List<Accountuser> getaccountusers(){
        return accountuserService.getAccountusers();
    }

    //GET en användare med en parameter
    @GetMapping("/getuser/{accountuserId}")
    public Optional<Accountuser> oneUser(@PathVariable("accountuserId" ) Long accountuserId) {
        return accountuserService.oneUser(accountuserId);
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



