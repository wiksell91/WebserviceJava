package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class AccountUserController {

    private AccountUserService accountUserService = new AccountUserService();




    @Autowired
    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    //Get
    @GetMapping("/user")
    public List<AccountUser> allUsers() {
        return accountUserService.allUsers();
    }

    //Post
    @PostMapping("/user")
    public String createUser(@RequestParam(required = true) int id, String userName, String name, String passWord) {

        return accountUserService.createUser(id,userName, name, passWord);
    }

    //Put
    @PutMapping("/user")
    public AccountUser updateUser(@RequestParam(required = true)String name) {
        return accountUserService.updateUser(name);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        return "account deleted + " + accountUserService.deleteUser(id);
    }
}

//    @PutMapping("/user/{id}")
//    public ResponseEntity<AccountUser> updateEmployee(@PathVariable(value = "id") int AccountUserId,
//                                                   /*@Valid*/ @RequestBody AccountUser accountUserDetails) /*throws ResourceNotFoundException*/ {
//        Employee employee = employeeRepository.findById(employeeId);
////                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }


