package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public AccountUser createUser(@RequestParam(required = true) String userName, String name, String password) {
        return accountUserService.createUser(userName, name, password);
    }

    //Put
    @PutMapping("/user")
    public AccountUser updateUser(@RequestParam(required = true)String name) {
        return accountUserService.updateUser(name);
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


