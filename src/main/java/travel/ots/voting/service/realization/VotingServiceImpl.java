package travel.ots.voting.service.realization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;
import travel.ots.voting.dao.VotingDao;
import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Voting;
import travel.ots.voting.enumeration.VotingStatus;
import travel.ots.voting.service.VotingService;
import travel.ots.voting.service.exception.EntityNotFoundException;

/**
 * VotingServiceImpl implements VotingService
 * The class is responsible for implementing the basic methods needed to work with a voting entity of the database.
 */
@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingDao votingDao;

    /**
     * Default constructor of {@code VotingServiceImpl} object.
     */
    public VotingServiceImpl(){}

    /**
     *
     * @param votingDao - object, which giving the access to the DAO layer.
     */
    public VotingServiceImpl(VotingDao votingDao){
        this.votingDao = votingDao;
    }

    /**
     *
     * @param object - object, that contains data to insert record to the database.
     * @return {@code Voting} inserted object.
     */
    @Override
    @Transactional
    public Voting insert(Voting object) {
        return votingDao.insert(object);
    }

    /**
     *
     * @param object - object, that contains data to update record in the database.
     * @return {@code Voting} updated object.
     */
    @Override
    @Transactional
    public Voting update(Voting object) {
        if(object == null){
            throw new EntityNotFoundException("There is no data for edit.");
        }
        return votingDao.update(object);
    }

    /**
     *
     * @param object - object, which will be deleted
     */
    @Override
    @Transactional
    public void delete(Voting object) {
        if(object == null){
            throw new EntityNotFoundException("There is no data for delete");
        }
        votingDao.delete(object);
    }

    /**
     *
     * @param id ID of object, which will be found.
     * @return {@code Voting} found object.
     */
    @Override
    @Transactional
    public Voting getById(Long id) {
        Voting voting = votingDao.getById(id);
        if(voting == null){
            throw new EntityNotFoundException("Requested data is not found");
        }
        for(Option option : voting.getOptionList()){
            option.setVoting(voting);
        }
        return voting;
    }

    /**
     *
     * @param voting - voting object.
     * @param builder - {@code UriComponentsBuilder} object for building links.
     * @return voting with parameters for opening.
     */
    @Override
    public Voting setOpenVotingParameters(Voting voting, UriComponentsBuilder builder) {
        voting.setVotingLink(builder.path("/voting/{id}").buildAndExpand(voting.getId()).toUriString());
        voting.setStatus(VotingStatus.OPENED.getVotingStatus());
        return voting;
    }

    /**
     *
     * @param voting - voting object.
     * @return voting with parameters for closing.
     */
    @Override
    public Voting setCloseVotingParameters(Voting voting) {
        voting.setStatus(VotingStatus.FINISHED.getVotingStatus());
        return voting;
    }
}
