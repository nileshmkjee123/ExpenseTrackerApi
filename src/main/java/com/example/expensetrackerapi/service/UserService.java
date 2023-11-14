package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.model.User;
import com.example.expensetrackerapi.model.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User getUser(Long id) throws Exception;

    User updateUser(Long id,UserModel user)throws Exception;

    void deleteUser(Long id) throws  Exception;
}
