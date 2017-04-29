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

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingDao votingDao;

    public VotingServiceImpl(){}

    public VotingServiceImpl(VotingDao votingDao){
        this.votingDao = votingDao;
    }

    @Override
    @Transactional
    public Voting insert(Voting object) {

        return votingDao.insert(object);
    }

    @Override
    @Transactional
    public Voting update(Voting object) {
        if(object == null){
            throw new EntityNotFoundException("Requested data is not found");
        }
        return votingDao.update(object);
    }

    @Override
    @Transactional
    public void delete(Voting object) {
        if(object == null){
            throw new EntityNotFoundException("Requested data is not found");
        }
        votingDao.delete(object);
    }

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

    @Override
    public Voting setOpenVotingParameters(Voting voting, UriComponentsBuilder builder) {
        voting.setVotingLink(builder.path("/voting/{id}").buildAndExpand(voting.getId()).toUriString());
        voting.setStatus(VotingStatus.OPENED.getVotingStatus());
        return voting;
    }

    @Override
    public Voting setCloseVotingParameters(Voting voting) {
        voting.setStatus(VotingStatus.FINISHED.getVotingStatus());
        return voting;
    }
}
