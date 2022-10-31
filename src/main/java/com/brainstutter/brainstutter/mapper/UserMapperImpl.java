package com.brainstutter.brainstutter.mapper;

import com.brainstutter.brainstutter.model.User;
import com.brainstutter.brainstutter.model.UserDTO;

public class UserMapperImpl implements UserMapper{
    @Override
    public UserDTO toUserDTO(User user) {
        if(user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAvatarUrl(user.getAvatarUrl());
        userDTO.setCreated(user.getCreated());
        userDTO.setToken(user.getToken());
        return userDTO;
    }
}
