package net.idrok.Reminder.convertor;

import net.idrok.Reminder.dto.UserDTO;
import net.idrok.Reminder.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserDTOConvertor extends AbstractDTOConvertor<User,UserDTO>{
    @Override
    public UserDTO convert(final User entity) {
        final UserDTO dto = new UserDTO();
        super.convert(entity,dto);
        dto.setUsername(entity.getUsername());
        dto.setName(entity.getName());
        return dto;
    }
}
