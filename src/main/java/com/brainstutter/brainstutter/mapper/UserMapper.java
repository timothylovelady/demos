package com.brainstutter.brainstutter.mapper;
import com.brainstutter.brainstutter.model.User;
import com.brainstutter.brainstutter.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO toUserDTO(User user);


}
