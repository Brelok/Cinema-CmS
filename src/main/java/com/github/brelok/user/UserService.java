package com.github.brelok.user;

import com.github.brelok.security.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {


    private final RoleRepository roleRepository;
    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(RoleRepository roleRepository,
                       UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List findAllDtoDisplay(){

        List<User> list = userRepository.findAll();

        return list.stream()
                .map(UserDtoDisplay::new)
                .collect(Collectors.toList());

    }

    public UserDtoDisplay findOneUserDto(Long id){
        return new UserDtoDisplay(userRepository.getOne(id));
    }

    public User findOne(Long id){
        return userRepository.getOne(id);
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
        user.setPassword(bCryptPasswordEncoder.encode(userDtoSave.getPassword()));
        user.setEnabled(1);



        return user;
    }

    public void delete (User user){
        userRepository.delete(user);
    }

    public void edit(UserDtoSave userDtoSave) {
        User existing = userRepository.getOne(userDtoSave.getId());

        userRepository.save(setValuesUserFromDtoValues(existing,userDtoSave));
    }

    public boolean checkUserIsAdmin (User user){

        User userRepositoryByLogin = userRepository.findByLogin(user.getLogin());
        if(userRepositoryByLogin.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
