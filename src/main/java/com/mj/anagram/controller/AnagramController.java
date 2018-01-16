package com.mj.anagram.controller;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mj.anagram.service.AnagramService;

@RestController
@RequestMapping("/anagram")
public class AnagramController {
	public static final Logger logger = LoggerFactory.getLogger(AnagramController.class);
	
	@Autowired AnagramService anagramService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{words}", method = RequestMethod.GET)
	public ResponseEntity<?> getAnagrams(@PathVariable("words") String words){
		Map<String, Set<String>> result = anagramService.getAnagrams(words);
		
		return new ResponseEntity<Map<String, Set<String>>>( result, HttpStatus.OK);
	}
}

/*
You need to put together a simple web application that can produce anagrams of words from a word list.

You can find a copy of our word list at http://static.abscond.org/wordlist.txt
Non-alphanumeric characters should be considered as part of the anagram (e.g. "he's" is not an anagram of "she")
The application should be able to respond to a request made every second
Assume that the application will be hosted on heroku
Details

The application should be able to receive an HTTP GET request with the requested word as the path. It should return the results as JSON. See the example below:

GET /crepitus

{"crepitus":["cuprites","pictures","piecrust"]}

 

 

GET /crepitus,paste,kinship,enlist,boaster,fresher,sinks,knits,sort

{"crepitus":["cuprites","pictures","piecrust"],"paste":["pates","peats","septa","spate","tapes","tepas"],"kinship":["pinkish"],"enlist":["elints","inlets","listen","silent","tinsel"],"boaster":["boaters","borates","rebatos","sorbate"],"fresher":["refresh"],"sinks":["skins"],"knits":["skint","stink","tinks"],"sort":["orts","rots","stor","tors"]}

 

 

GET /sdfwehrtgegfg

{"sdfwehrtgegfg":[]}

*/
