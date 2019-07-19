package com.github.brelok.user;

public interface UserServiceS  {
    User findByLogin(String login);

    void saveUser(User user);
}
