package com.brainstutter.brainstutter.service;
import com.brainstutter.brainstutter.mapper.UserMapperImpl;
import com.brainstutter.brainstutter.model.User;
import com.brainstutter.brainstutter.model.UserDTO;
import com.brainstutter.brainstutter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;




    public UserDTO saveUser(User user) {
        UserMapperImpl userMapper = new UserMapperImpl();
        User tempUser = userRepository.save(user);
        return userMapper.toUserDTO(tempUser);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDTO findById(Integer id) {
        UserMapperImpl userMapper = new UserMapperImpl();
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
            return userMapper.toUserDTO(user);
    }
    public String delete(Integer id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
            try {
                userRepository.deleteById(foundUser.getId());
                return "User Removed";
            }
            catch(UnknownError err) {
                return "server error";
            }

        }

    }


