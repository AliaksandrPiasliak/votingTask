package travel.ots.voting.service;


public interface GenericService<T,K> {

     T insert(T object);

    T update(T object);

    void delete(T object);

    T getById(K id);
}
