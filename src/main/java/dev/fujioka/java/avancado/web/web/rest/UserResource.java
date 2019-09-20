package dev.fujioka.java.avancado.web.web.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }
    
    @GetMapping("/user/id/{id}")
    public List<User> getById(@PathVariable Long id){
    	return userService.findProductById(id);
    }
    
    @GetMapping("/user/login/{login}")
    public List<User> getByLogin(@PathVariable String login){
    	return userService.findProductByLogin(login);
    }
    
    @GetMapping("/user/dtCreation/{dtCreation}")
    public List<User> getByDtCreation(@PathVariable Date dtCreation){
    	return userService.findProductByDtCreation(dtCreation);
    }
    
    @GetMapping("/user/dtUpdate/{dtUpdate}")
    public List<User> getByDtUpdate(@PathVariable Date dtUpdate){
    	return userService.findProductByDtUpdate(dtUpdate);
    }
    
    @GetMapping("/user/firstName/{firstName}")
    public List<User> getByFirstName(@PathVariable String firstName){
    	return userService.findProductByFirstName(firstName);
    }
    
    @GetMapping("/user/lastName/{lastName}")
    public List<User> getByLastName(@PathVariable String lastName){
    	return userService.findProductByLastName(lastName);
    }

    @PostMapping("/user")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user")
    public ResponseEntity update(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
       return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }


}
