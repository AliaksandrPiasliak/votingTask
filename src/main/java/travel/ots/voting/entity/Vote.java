package travel.ots.voting.entity;

import java.util.List;

public class Vote {

    private List<Long> optionsForVote;

    public List<Long> getOptionsForVote() {
        return optionsForVote;
    }

    public void setOptionsForVote(List<Long> optionsForVote) {
        this.optionsForVote = optionsForVote;
    }
}
