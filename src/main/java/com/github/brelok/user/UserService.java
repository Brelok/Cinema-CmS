package com.github.brelok.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List findAllDtoDisplay(){

        List<User> list = userRepository.findAll();

        return list.stream()
                .map(UserDtoDisplay::new)
                .collect(Collectors.toList());

    }

    public UserDtoDisplay findOneUserDto(Long id){
        return new UserDtoDisplay(userRepository.findOne(id));
    }

    public User findOne(Long id){
        return userRepository.findOne(id);
    }

    public void createUser(UserDtoSave userDtoSave){
        User user = new User();
        userRepository.save(setValuesUserFromDtoValues(user, userDtoSave));
    }

    public User setValuesUserFromDtoValues (User user, UserDtoSave userDtoSave){

        user.setFirstName(userDtoSave.getFirstName());
        user.setLastName(userDtoSave.getLastName());
        user.setEmail(userDtoSave.getEmail());
        user.setLogin(userDtoSave.getLogin());
        user.setPassword(userDtoSave.getPassword());

        return user;
    }

    public void delete (User user){
        userRepository.delete(user);
    }

    public void edit(UserDtoSave userDtoSave) {
        User existing = userRepository.findOne(userDtoSave.getId());

        userRepository.save(setValuesUserFromDtoValues(existing,userDtoSave));
    }
}
