package travel.ots.voting.controller.validation;

import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Vote;

import java.util.List;

public class RequestDataValidator {

    private static Integer MINIMUM_OPTIONS_NUMBER = 2;
    private static Integer MINIMUM_OPTIONS_FOR_VOTE_NUMBER = 1;

    public static boolean checkOptionsForVoting(List<Option> optionList, Vote vote){
        return optionList.size() <= MINIMUM_OPTIONS_NUMBER && vote.getOptionsForVote().size() > MINIMUM_OPTIONS_FOR_VOTE_NUMBER;
    }

    public static boolean checkOptionList(List<Option> optionList){
        return optionList != null;
    }
}
