package com.ViMiJo.webservicemusicaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("group2/musicaccount/user")
public class AccountUserController {

    private AccountUserService accountUserService = new AccountUserService();

    @Autowired
    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    //Get
    @GetMapping()
    public List<AccountUser> allUsers() {
        return accountUserService.allUsers();
    }

    //Post
    @PostMapping()
    public String createUser(@RequestParam(required = true) String userName, String name, String passWord) {
        return accountUserService.createUser(userName, name, passWord);
    }

    //Put
    @PutMapping()
    public AccountUser updateUser(@RequestParam(required = true)String name) {
        return accountUserService.updateUser(name);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id")int id) {
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


