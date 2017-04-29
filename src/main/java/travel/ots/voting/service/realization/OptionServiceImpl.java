package travel.ots.voting.service.realization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import travel.ots.voting.dao.OptionDao;
import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Vote;
import travel.ots.voting.entity.Voting;
import travel.ots.voting.service.OptionService;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDao optionDao;

    public OptionServiceImpl(){}

    public OptionServiceImpl(OptionDao optionDao){
        this.optionDao = optionDao;
    }

    @Override
    @Transactional
    public Option insert(Option object) {
        return optionDao.insert(object);
    }

    @Override
    @Transactional
    public Option update(Option object) {
        return optionDao.update(object);
    }

    @Override
    @Transactional
    public void delete(Option object) {
        optionDao.delete(object);
    }

    @Override
    @Transactional
    public Option getById(Long id) {
        return optionDao.getById(id);
    }

    @Override
    @Transactional
    public void addOptions(Voting createdVoting) {
        List<Option> optionList = createdVoting.getOptionList();
        if(optionList != null) {
            for (Option option : optionList){
                option.setVoting(createdVoting);
                insert(option);
            }
        }
    }

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