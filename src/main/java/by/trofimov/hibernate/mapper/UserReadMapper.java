package by.trofimov.hibernate.mapper;

import by.trofimov.hibernate.entity.User;
import by.trofimov.hibernate.dto.UserReadDto;

public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto mapFrom(User object) {
        return new UserReadDto(
                object.getId(),
                object.getFirstName(),
                object.getLastName()
        );
    }

}
