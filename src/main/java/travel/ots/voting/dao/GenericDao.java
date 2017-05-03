package travel.ots.voting.dao;

import travel.ots.voting.entity.EntityObject;

/**
 * The GenericDao interface announces general methods to access the data domain.
 *
 * @param <T> entity type which extends EntityObject abstract class.
 * @param <K> type of entity ID.
 */
public interface GenericDao<T extends EntityObject, K extends Number> {

    /**
     *
     * @param object - object, that will be inserted in the table.
     * @return inserted object.
     */
    T insert(T object);

    /**
     *
     * @param object - object, that will be updated in the table.
     * @return updated object.
     */
    T update(T object);

    /**
     *
     * @param object - object, that will be deleted from the table.
     */
    void delete(T object);

    /**
     *
     *
     * @param id - ID of object, that wiil be found in the table.
     * @return found object.
     */
    T getById(K id);
}
