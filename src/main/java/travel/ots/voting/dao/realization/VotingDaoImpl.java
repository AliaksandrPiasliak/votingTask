package travel.ots.voting.dao.realization;

import org.springframework.stereotype.Repository;
import travel.ots.voting.dao.VotingDao;
import travel.ots.voting.entity.Voting;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VotingDaoImpl implements VotingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Voting insert(Voting object) {
        entityManager.persist(object);
        return object;
    }

    @Override
    public Voting update(Voting object) {
        entityManager.merge(object);
        return object;
    }

    @Override
    public void delete(Voting object) {
        entityManager.remove(object);
    }

    @Override
    public Voting getById(Long id) {
        return entityManager.find(Voting.class, id);
    }
}