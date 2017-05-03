package travel.ots.voting.dao.realization;

import org.springframework.stereotype.Repository;
import travel.ots.voting.dao.OptionDao;
import travel.ots.voting.entity.Option;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * OptionDaoImpl implements OptionDao
 * The class is responsible for implementing the basic methods needed to access the data in the options entity
 * of the database.
 *
 */
@Repository
public class OptionDaoImpl implements OptionDao {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Default constructor of {@code OptionDaoImpl} object.
     */
    public OptionDaoImpl(){

    }

    /**
     *
     *
     * @param object - object, that will be inserted in the table.
     * @return {@code Option} inserted object.
     */
    @Override
    public Option insert(Option object) {
        entityManager.persist(object);
        return object;
    }

    /**
     *
     * @param object - object, that will be updated in the table.
     * @return {@code Option} updated object.
     */
    @Override
    public Option update(Option object) {
        return entityManager.merge(object);
    }

    /**
     *
     * @param object - object, that will be deleted from the table.
     */
    @Override
    public void delete(Option object) {
        entityManager.remove(object);
    }

    /**
     *
     * @param id - ID of object, that wiil be found in the table.
     * @return {@code Option} found object.
     */
    @Override
    public Option getById(Long id) {
        return entityManager.find(Option.class, id);
    }
}