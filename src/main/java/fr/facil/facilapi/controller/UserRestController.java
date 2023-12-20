package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.User;
import fr.facil.facilapi.repository.UserRepository;
import fr.facil.facilapi.supplement.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
//@CrossOrigin(origins = { "*:8080"},methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);



    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userRepository.findUserByUsername(username);
    }
    @GetMapping(value = "/id/{userId}")
    public User findUserById(@PathVariable String userId) {
        return userRepository.findUserById(userId);
    }

    @GetMapping(value = "/email/{userEmail}")
    public User findUserByEmail(@PathVariable String userEmail) {
        return userRepository.findUserByEmail(userEmail);
    }

    @PutMapping(value = "/notfound")
    public User updatePassword(@RequestBody NotFound notfound) {

        User user = userRepository.findUserByEmail(notfound.getEmail());

        if (user == null){
            return null;
        }

        user.setId(user.getId());
        user.setPassword(Base64.getEncoder().encodeToString(notfound.getPassword().getBytes()));

        return userRepository.save(user);
    }

    @GetMapping(value = "/finduser/{username}/{password}")
    public User getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }


    @PostMapping(value = "/create")
    public User addUser(@RequestBody User user) {
        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userRepository.deleteById(userId);
    }

    @DeleteMapping(value = "/deletebyusername/{userName}")
    public void deleteUserByUsername(@PathVariable String userName) {

        User user = userRepository.findUserByUsername(userName);

        userRepository.deleteById(user.getId());
    }

    @GetMapping(value = "/findalluserinactive")
    public List<User> finUserActive(){
        return userRepository.findAllByActiveIsTrue();
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        user.setId(id);

        return userRepository.save(user);
    }

}
