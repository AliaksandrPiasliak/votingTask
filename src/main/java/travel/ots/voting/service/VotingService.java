package travel.ots.voting.service;

import org.springframework.web.util.UriComponentsBuilder;
import travel.ots.voting.entity.Voting;

/**
 * The VotingService interface announces a number of methods for working with voting entity.
 * It uses DAO layer.
 */
public interface VotingService extends GenericService<Voting, Long> {

    /**
     *
     * @param voting - voting object.
     * @param builder - {@code UriComponentsBuilder} object for building links.
     * @return voting with parameters for opening.
     */
    Voting setOpenVotingParameters(Voting voting, UriComponentsBuilder builder);

    /**
     *
     * @param voting - voting object.
     * @return voting with parameters for closing.
     */
    Voting setCloseVotingParameters(Voting voting);

}
