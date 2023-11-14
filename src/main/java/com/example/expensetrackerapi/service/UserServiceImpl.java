package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.exception.ItemAlreadyExistsException;
import com.example.expensetrackerapi.model.User;
import com.example.expensetrackerapi.model.UserModel;
import com.example.expensetrackerapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public User createUser(UserModel user) {
        if(userRepository.existsByEmail(user.getEmail()))
            throw new ItemAlreadyExistsException("This Email Id is already used please provide a different email");
       User newUser = new User();
        BeanUtils.copyProperties(user,newUser);
        return userRepository.save(newUser);
    }

    @Override
    public User getUser(Long id) throws Exception{
        return userRepository.findById(id).orElseThrow(()->new Exception(
                "user with id: "+id+" not found"));
    }

    @Override
    public User updateUser(Long id, UserModel user)throws Exception {

      Optional<User> toUpdateUser = userRepository.findById(id);
      if(toUpdateUser.isEmpty())
          throw new Exception("id not found");
      User updateUser = toUpdateUser.get();
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setAge(user.getAge());
        if(userRepository.existsByEmail(updateUser.getEmail()))
            throw new ItemAlreadyExistsException("This Email Id is already used please provide a different email");
        userRepository.save(updateUser);
        return updateUser;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> toUpdateUser = userRepository.findById(id);
        if(toUpdateUser.isEmpty())
            throw new Exception("id not found");
        userRepository.deleteById(id);
        //return "id: "+id+" is deleted successfully";
    }


}
