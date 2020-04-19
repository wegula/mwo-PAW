package com.company.enroller.controllers;

import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;
import com.company.enroller.persistence.MeetingService;
import com.company.enroller.persistence.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/meetings")
public class MeetingRestController {

	@Autowired
	MeetingService meetingsService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getMeeting() {
		Collection<Meeting> meetings = meetingsService.getAll();
		return new ResponseEntity<Collection<Meeting>>(meetings, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMeeting(@PathVariable("id") long id) {
		Meeting meeting = meetingsService.findById(id);
		return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/participants", method = RequestMethod.GET)
	public ResponseEntity<?> getMeetingParticipants(@PathVariable("id") long id) {
		Meeting meeting = meetingsService.findById(id);
		return new ResponseEntity<Collection<Participant>>(meeting.getParticipants(), HttpStatus.OK);
	}

//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<?> getMeeting(@PathVariable("id") String login) {
//		Participant participant = meetingsService.findByLogin(login);
//		if (participant == null) {
//			return new ResponseEntity(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<Participant>(participant, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public ResponseEntity<?> registerParticipant(@RequestBody Participant participant) {
//		Participant foundParticipant = meetingsService.findByLogin(participant.getLogin());
//		if (foundParticipant != null) {
//			return new ResponseEntity("Unable to create. A participant with login " + participant.getLogin() + " already exist.", HttpStatus.CONFLICT);
//		}
//		meetingsService.add(participant);
//		return new ResponseEntity<Participant>(participant, HttpStatus.CREATED);
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<?> delete(@PathVariable("id") String login) {
//		Participant participant = meetingsService.findByLogin(login);
//		if (participant == null) {
//			return new ResponseEntity(HttpStatus.NOT_FOUND);
//		}
//		meetingsService.delete(participant);
//		//return new ResponseEntity<Participant>(participant, HttpStatus.OK);
//		return new ResponseEntity<Participant>(participant, HttpStatus.NO_CONTENT);
//	}
}


