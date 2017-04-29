package travel.ots.voting.dao;

import travel.ots.voting.entity.EntityObject;


public interface GenericDao<T extends EntityObject, K extends Number> {

    T insert(T object);

    T update(T object);

    void delete(T object);

    T getById(K id);
}
