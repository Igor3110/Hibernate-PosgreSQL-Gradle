package by.trofimov.hibernate.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);

}
