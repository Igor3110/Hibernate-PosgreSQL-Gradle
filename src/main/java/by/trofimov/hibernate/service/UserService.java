package by.trofimov.hibernate.service;

import java.util.List;
import java.util.Optional;
import by.trofimov.hibernate.entity.User;
import by.trofimov.hibernate.mapper.UserCreateMapper;
import lombok.RequiredArgsConstructor;
import by.trofimov.hibernate.dto.UserReadDto;
import by.trofimov.hibernate.dto.UserCreateDto;
import by.trofimov.hibernate.mapper.UserReadMapper;
import by.trofimov.hibernate.dao.UserRepository;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserReadMapper userReadMapper;

    public Integer create(UserCreateDto userDto) {
        User user = userCreateMapper.mapFrom(userDto);
        return userRepository.save(user).getId();
    }

    public boolean delete(Integer id) {
        var maybeUser = userRepository.findById(id);
        maybeUser.ifPresent(user -> userRepository.delete(user.getId()));
        return maybeUser.isPresent();
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public Optional<UserReadDto> findById(Integer id) {
        return userRepository.findById(id).map(userReadMapper::mapFrom);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
