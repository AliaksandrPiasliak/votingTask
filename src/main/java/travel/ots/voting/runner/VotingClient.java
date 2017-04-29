package travel.ots.voting.runner;

import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import travel.ots.voting.entity.Option;
import travel.ots.voting.entity.Vote;
import travel.ots.voting.entity.Voting;
import travel.ots.voting.enumeration.VotingStatus;

import java.util.ArrayList;
import java.util.List;

@Component
public class VotingClient {

    private static Logger logger = Logger.getLogger(VotingClient.class);
    private RestTemplate restTemplate;

    public VotingClient(){
        restTemplate = new RestTemplate();
    }

    public static void main(String[] args) {
        VotingClient client = new VotingClient();
        client.createVoting();
        client.startVoting();
        client.closeVoting();
        client.findVoting();
        client.registerVote();
        client.showStatistics();
    }

    private void createVoting(){
        logger.info("Testing create voting");
        Voting voting = new Voting();
        voting.setVotingTopic("Who is the best player of the Premier League 2017");
        voting.setStatus(VotingStatus.CREATED.getVotingStatus());
        List<Option> options = new ArrayList<>();
        options.add(new Option("Eden Hazard", 0));
        options.add(new Option("Harry Kane",0));
        options.add(new Option("Romelu Lukaku", 0));
        voting.setOptionList(options);
        Voting createdVoting = restTemplate.postForObject("http://localhost:8080/VotingTask/voting/createVoting",voting,Voting.class);
        logger.info(createdVoting);
    }

    private void startVoting(){
        logger.info("Testing start voting");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Voting> entity = new HttpEntity<>(headers);
        Voting voting = restTemplate.exchange("http://localhost:8080/VotingTask/voting/openVoting/15",HttpMethod.PUT,entity,Voting.class).getBody();
        logger.info("Voting " + voting.getVotingTopic() + " started. Link for voting: " + voting.getVotingLink());
    }

    private void closeVoting(){
        logger.info("Testing close voting");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Voting> entity = new HttpEntity<>(headers);
        Voting voting = restTemplate.exchange("http://localhost:8080/VotingTask/voting/closeVoting/6",HttpMethod.PUT,entity,Voting.class).getBody();
        logger.info("Voting " + voting.getVotingTopic() + "stopped.");
    }

    private void findVoting(){
        logger.info("Testing find voting");
        Voting voting = restTemplate.getForObject("http://localhost:8080/VotingTask/voting/15", Voting.class);
        logger.info(voting);
    }

    private void showStatistics(){
        logger.info("Testing show statistics for voting");
        Voting voting = restTemplate.getForObject("http://localhost:8080/VotingTask/voting/showStatistics/15", Voting.class);
        printStatistics(voting.getVotingTopic(),voting.getOptionList());
    }

    private void printStatistics(String votingName, List<Option> optionList){
        logger.info("Statistics for voting: " + votingName);
        for(Option option : optionList){
            logger.info("Option " + option.getOptionText() + ": " + option.getOptionSummary() + " votes");
        }
    }

    private void registerVote(){
        logger.info("Testing register vote for option");
        Vote newVote = new Vote();
        List<Long> checkedOptions = new ArrayList<>();
        checkedOptions.add((long)7);
        checkedOptions.add((long)8);
        newVote.setOptionsForVote(checkedOptions);
        restTemplate.put("http://localhost:8080/VotingTask/voting/registerVote/15", newVote);
        logger.info("Vote registered");
    }
}