package travel.ots.voting.dao.realization;

import org.springframework.stereotype.Repository;
import travel.ots.voting.dao.VotingDao;
import travel.ots.voting.entity.Voting;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * VotingDaoImpl implements VotingDao
 * The class is responsible for implementing the basic methods needed to access the data in the voting entity
 * of the database.
 *
 */
@Repository
public class VotingDaoImpl implements VotingDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor of {@code VotingDaoImpl} object.
     */
    public VotingDaoImpl(){

    }

    /**
     *
     * @param object - object, that will be inserted in the table.
     * @return {@code Voting} inserted object.
     */
    @Override
    public Voting insert(Voting object) {
        entityManager.persist(object);
        return object;
    }

    /**
     *
     *
     * @param object - object, that will be updated in the table.
     * @return {@code Voting} updated object.
     */
    @Override
    public Voting update(Voting object) {
        entityManager.merge(object);
        return object;
    }

    /**
     *
     * @param object - object, that will be deleted from the table.
     */
    @Override
    public void delete(Voting object) {
        entityManager.remove(object);
    }

    /**
     *
     * @param id - ID of object, that wiil be found in the table.
     * @return {@code Voting} found object.
     */
    @Override
    public Voting getById(Long id) {
        return entityManager.find(Voting.class, id);
    }
}