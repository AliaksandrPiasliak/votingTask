package travel.ots.voting.dao.realization;

import org.springframework.stereotype.Repository;
import travel.ots.voting.dao.OptionDao;
import travel.ots.voting.entity.Option;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OptionDaoImpl implements OptionDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Option insert(Option object) {
        entityManager.persist(object);
        return object;
    }

    @Override
    public Option update(Option object) {
        return entityManager.merge(object);
    }

    @Override
    public void delete(Option object) {
        entityManager.remove(object);
    }

    @Override
    public Option getById(Long id) {
        return entityManager.find(Option.class, id);
    }
}