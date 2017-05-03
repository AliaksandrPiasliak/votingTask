package travel.ots.voting.service.realization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travel.ots.voting.dao.OptionDao;
import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Vote;
import travel.ots.voting.entity.Voting;
import travel.ots.voting.service.OptionService;
import travel.ots.voting.service.exception.EntityNotFoundException;
import travel.ots.voting.service.exception.OptionsNotFoundException;

import java.util.List;

/**
 * OptionServiceImpl implements OptionService
 * The class is responsible for implementing the basic methods needed to work with an options entity of the database.
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDao optionDao;

    /**
     * Default constructor of {@code OptionServiceImpl} object.
     */
    public OptionServiceImpl(){}

    /**
     *
     * @param optionDao - object, which giving the access to the DAO layer.
     */
    public OptionServiceImpl(OptionDao optionDao){
        this.optionDao = optionDao;
    }

    /**
     *
     * @param object - object, that contains data to insert record to the database.
     * @return {@code Option} inserted object.
     */
    @Override
    @Transactional
    public Option insert(Option object) {
        return optionDao.insert(object);
    }

    /**
     *
     * @param object - object, that contains data to update record in the database.
     * @return {@code Option} updated object.
     */
    @Override
    @Transactional
    public Option update(Option object) {
        if(object == null){
            throw new EntityNotFoundException("There is no data for edit.");
        }
        return optionDao.update(object);
    }

    /**
     *
     * @param object - object, which will be deleted
     */
    @Override
    @Transactional
    public void delete(Option object) {
        if(object == null){
            throw new EntityNotFoundException("There is no data for delete");
        }
        optionDao.delete(object);
    }

    /**
     *
     * @param id ID of object, which will be found.
     * @return {@code Option} found object.
     */
    @Override
    @Transactional
    public Option getById(Long id) {
        Option option = optionDao.getById(id);
        if(option == null){
            throw new EntityNotFoundException("Requested data is not found");
        }
        return option;
    }

    /**
     *
     * @param createdVoting - voting for adding options.
     */
    @Override
    @Transactional
    public void addOptions(Voting createdVoting) {
        List<Option> optionList = createdVoting.getOptionList();
        if(optionList != null) {
            for (Option option : optionList){
                option.setVoting(createdVoting);
                insert(option);
            }
        } else {
            throw new OptionsNotFoundException("Options for this voting don't found.");
        }
    }

    /**
     *
     * @param vote - {@code Vote} object, which add votes for options in voting.
     */
    @Override
    @Transactional
    public void addVote(Vote vote) {
        Option optionForVote;
        int voteSum;
        for (Long optionId : vote.getOptionsForVote()) {
            optionForVote = getById(optionId);
            voteSum = optionForVote.getOptionSummary();
            voteSum++;
            optionForVote.setOptionSummary(voteSum);
            update(optionForVote);
        }
    }
}