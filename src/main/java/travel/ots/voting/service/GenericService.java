package travel.ots.voting.service;

/**
 *
 * The GenericService interface announces a number of methods for working with entity repository.
 * It uses DAO layer.
 *
 * @param <T> entity type which extends EntityObject abstract class.
 * @param <K> type of entity ID.
 */
public interface GenericService<T,K> {

    /**
     *
     * @param object - object, that contains data to insert record to the database.
     * @return inserted object.
     */
    T insert(T object);

    /**
     *
     * @param object - object, that contains data to update record in the database.
     * @return update object.
     */
    T update(T object);

    /**
     *
     *
     * @param object - object, which will be deleted
     */
    void delete(T object);

    /**
     *
     * @param id ID of object, which will be found.
     * @return found object
     */
    T getById(K id);
}
