package by.trofimov.hibernate.dao;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;

public interface DAO<K extends Serializable, E> {

    E save(E entity);

    void delete(K id);

    void update(E entity);

    Optional<E> findById(K id);

    List<E> findAll();

}
