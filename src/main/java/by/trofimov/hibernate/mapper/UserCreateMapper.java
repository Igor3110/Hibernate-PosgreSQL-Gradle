package by.trofimov.hibernate.mapper;

import by.trofimov.hibernate.entity.User;
import by.trofimov.hibernate.dto.UserCreateDto;

public class UserCreateMapper implements Mapper<UserCreateDto, User> {

    @Override
    public User mapFrom(UserCreateDto object) {
        return User.builder()
                .firstName(object.firstName())
                .lastName(object.lastName())
                .age(object.age())
                .company(object.company())
                .build();
    }

}
