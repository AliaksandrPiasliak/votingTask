package travel.ots.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import travel.ots.voting.entity.Vote;
import travel.ots.voting.entity.Voting;
import travel.ots.voting.service.OptionService;
import travel.ots.voting.service.VotingService;
import travel.ots.voting.validation.Validator;

@RestController
@CrossOrigin
@RequestMapping("/voting")
public class VotingTaskController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private OptionService optionService;

    @RequestMapping(value = "/createVoting", method = RequestMethod.POST)
    public ResponseEntity<?> createVoting(@RequestBody Voting voting){
        Voting createdVoting = votingService.insert(voting);
        optionService.addOptions(createdVoting);
        return new ResponseEntity<>(createdVoting, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/openVoting/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Voting> openVoting(@PathVariable long id, UriComponentsBuilder builder){
        Voting voting = votingService.getById(id);
        voting = votingService.update(votingService.setOpenVotingParameters(voting,builder));
        return new ResponseEntity<>(voting, HttpStatus.OK);
    }

    @RequestMapping(value = "/closeVoting/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Voting> closeVoting(@PathVariable long id){
        Voting voting = votingService.getById(id);
        voting = votingService.update(votingService.setCloseVotingParameters(voting));
        return new ResponseEntity<>(voting, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Voting> getVoting(@PathVariable long id){
        Voting voting = votingService.getById(id);
        return new ResponseEntity<>(voting, HttpStatus.OK);
    }

    @RequestMapping(value = "/showStatistics/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> showStatisticsForVoting(@PathVariable long id){
        Voting voting = votingService.getById(id);
        if(Validator.checkOptionList(voting.getOptionList())) {
            return new ResponseEntity<>(voting, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "registerVote/{votingId}", method = RequestMethod.PUT)
    public ResponseEntity registerVote(@PathVariable long votingId, @RequestBody Vote vote){
        Voting voting = votingService.getById(votingId);
        if(!Validator.checkOptionsForVoting(voting.getOptionList(), vote)) {
            optionService.addVote(vote);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
}