package travel.ots.voting.enumeration;


public enum VotingStatus {
    CREATED("Created"), OPENED("Opened"), FINISHED("Finished");

    private String statusValue;

    VotingStatus(String statusValue){
        this.statusValue = statusValue;
    }
    public String getVotingStatus(){
        return statusValue;
    }
}
