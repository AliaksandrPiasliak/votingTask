package travel.ots.voting.service;

import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Vote;
import travel.ots.voting.entity.Voting;


public interface OptionService extends GenericService<Option, Long> {

    void addOptions(Voting voting);

    void addVote(Vote vote);
}
