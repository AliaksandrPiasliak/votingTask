package travel.ots.voting.enumeration;

/**
 * VotingStatus - contains statuses of voting.
 */
public enum VotingStatus {
    CREATED("Created"), OPENED("Opened"), FINISHED("Finished");

    private String statusValue;

    /**
     *
     * @param statusValue - value of the status.
     */
    VotingStatus(String statusValue){
        this.statusValue = statusValue;
    }

    public String getVotingStatus(){
        return statusValue;
    }
}
