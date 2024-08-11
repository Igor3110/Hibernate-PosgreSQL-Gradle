package by.trofimov.hibernate;

import java.util.List;
import java.lang.reflect.Proxy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import by.trofimov.hibernate.dao.*;
import by.trofimov.hibernate.entity.User;
import by.trofimov.hibernate.service.UserService;
import by.trofimov.hibernate.mapper.UserReadMapper;
import by.trofimov.hibernate.mapper.UserCreateMapper;

public class Runner {

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(User.class)
                .configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             var session = (Session) Proxy.newProxyInstance(sessionFactory.getClass().getClassLoader(),
                     new Class[]{Session.class},
                     (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1))) {

            session.beginTransaction();

            var userRepository = new UserRepository(session);
            var userCreateMapper = new UserCreateMapper();
            var userReadMapper = new UserReadMapper();

            var userService = new UserService(userRepository, userCreateMapper, userReadMapper);
            userService.findById(1).ifPresent(System.out::println);

            List<User> users = userService.findAll();
            System.out.println(users);

            session.getTransaction().commit();

        }

    }

}
