package travel.ots.voting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Option extends EntityObject<Long> - object representation of the options entity of database.
 *
 */
@Entity
@Table(name = "options")
public class Option extends EntityObject<Long> {

    @Column(name = "option_text", nullable = false, length = 100)
    private String optionText;

    @Column(name = "option_sum", nullable = false)
    private Integer optionSummary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_voting", nullable = false)
    @JsonIgnoreProperties("optionList")
    private Voting voting;

    /**
     * Default constructor of {@code Option} object.
     */
    public Option(){}

    /**
     *
     * @param id ID of option.
     * @param text Option text.
     * @param summary Number of users, that chose that option.
     */
    public Option(Long id, String text, Integer summary){
        super(id);
        this.optionText = text;
        this.optionSummary = summary;
    }

    /**
     *
     * @param text Option text.
     * @param summary Number of users, that chose that option.
     */
    public Option( String text, Integer summary){
        this.optionText = text;
        this.optionSummary = summary;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Integer getOptionSummary() {
        return optionSummary;
    }

    public void setOptionSummary(Integer optionSummary) {
        this.optionSummary = optionSummary;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionText='" + optionText + '\'' +
                ", optionSummary=" + optionSummary +
                '}';
    }
}