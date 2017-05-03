package travel.ots.voting.service;

import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Vote;
import travel.ots.voting.entity.Voting;

/**
 * The OptionService interface announces a number of methods for working with options entity.
 * It uses DAO layer.
 */
public interface OptionService extends GenericService<Option, Long> {

    /**
     *
     * @param voting - voting for adding options.
     */
    void addOptions(Voting voting);

    /**
     *
     * @param vote - {@code Vote} object, which add votes for options in voting.
     */
    void addVote(Vote vote);
}
