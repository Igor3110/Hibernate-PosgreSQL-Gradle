package by.trofimov.hibernate.dao;

import jakarta.persistence.EntityManager;
import by.trofimov.hibernate.entity.User;

public class UserRepository extends DAOBase<Integer, User> {

    public UserRepository(EntityManager entityManager) {
        super(User.class, entityManager);
    }

}
