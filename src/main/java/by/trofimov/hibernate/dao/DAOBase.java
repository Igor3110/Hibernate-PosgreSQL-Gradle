package by.trofimov.hibernate.dao;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import static by.trofimov.hibernate.util.Constant.*;

@RequiredArgsConstructor
public abstract class DAOBase<K extends Serializable, E> implements DAO<K, E> {

    private final Class<E> clazz;
    private final EntityManager entityManager;

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        entityManager.remove(id);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery(SQL_QUERY_FIND_ALL_USERS, clazz).getResultList();
    }

}
