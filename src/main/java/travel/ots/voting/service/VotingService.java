package travel.ots.voting.service;

import org.springframework.web.util.UriComponentsBuilder;
import travel.ots.voting.entity.Voting;

public interface VotingService extends GenericService<Voting, Long> {

    Voting setOpenVotingParameters(Voting voting, UriComponentsBuilder builder);

    Voting setCloseVotingParameters(Voting voting);

}
