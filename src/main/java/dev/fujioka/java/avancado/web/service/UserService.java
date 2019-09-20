package dev.fujioka.java.avancado.web.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.repository.UserRepository;

@Service
public class UserService implements CrudInterface<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(User entity) {
        return Optional.of(userRepository.save(entity));
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }
    
    public List<User> findProductByLogin(String login){
    	return userRepository.findProductByLogin(login);
    }
    
    public List<User> findProductById(Long id){
    	return userRepository.findProductById(id);
    }
    
    public List<User> findProductByDtCreation(Date dtCreation){
    	return userRepository.findProductByDtCreation(dtCreation);
    }
    
    public List<User> findProductByDtUpdate(Date dtUpdate){
    	return userRepository.findProductByDtUpdate(dtUpdate);
    }
    
    public List<User> findProductByFirstName(String firtName){
    	return userRepository.findProductByFirstName(firtName);
    }
    
    public List<User> findProductByLastName(String lastName){
    	return userRepository.findProductByLastName(lastName);
    }
}
