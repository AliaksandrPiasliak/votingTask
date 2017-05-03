package travel.ots.voting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Voting extends EntityObject<Long> - object representation of the voting entity of database.
 *
 */
@Entity
@Table(name = "voting")
public class Voting extends EntityObject<Long> {

    @Column(name = "voting_topic", nullable = false, length = 100)
    private String votingTopic;

    @Column(name = "voting_link", nullable = true, length = 100)
    private String votingLink;

    @Column(name = "voting_status", nullable = false, length = 45)
    private String status;

    @OneToMany(mappedBy = "voting")
    @JsonIgnoreProperties("voting")
    private List<Option> optionList;

    /**
     * Default constructor of {@code Voting} object.
     *
     */
    public Voting(){}

    /**
     *
     *
     * @param id Voting ID.
     * @param topic Voting topic.
     * @param link Voting link.
     * @param status Voting status.
     */
    public Voting(Long id, String topic, String link, String status){
        super(id);
        this.votingTopic = topic;
        this.votingLink = link;
        this.status = status;
    }


    public String getVotingTopic() {
        return votingTopic;
    }

    public void setVotingTopic(String votingTopic) {
        this.votingTopic = votingTopic;
    }

    public String getVotingLink() {
        return votingLink;
    }

    public void setVotingLink(String votingLink) {
        this.votingLink = votingLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "votingTopic='" + votingTopic + '\'' +
                ", votingLink='" + votingLink + '\'' +
                ", status='" + status + '\'' +
                ", optionList=" + optionList +
                '}';
    }
}