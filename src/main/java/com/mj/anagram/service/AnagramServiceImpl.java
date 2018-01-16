package com.mj.anagram.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("anagramService")
public class AnagramServiceImpl implements AnagramService {
	public static final Logger LOGGER = LoggerFactory.getLogger(AnagramServiceImpl.class);
	
	private static final Map<String, Set<String>> WORD_STORE = new HashMap<>();
	
	@Autowired AnagramConfig anagramConfig;
	
	@PostConstruct
	private void reloadStore(){
		LOGGER.info( "Reload Store ...." );
		LOGGER.info( anagramConfig.getURL() );
		
		URL url = null;
		try {
			url = new URL( anagramConfig.getURL() );
		} catch (MalformedURLException e) {
			LOGGER.error(e.getMessage());
		}
		
		if( url != null )
		try(
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		){			
	        String line;
	        while ((line = in.readLine()) != null) {
	            String key = normaliseAnagram(line); 
	            if(WORD_STORE.get(key) == null )
	            	WORD_STORE.put(key, new HashSet<>());
	            WORD_STORE.get(key).add( line );
	        }
		}catch(IOException ioe){
			LOGGER.error( ioe.getMessage() );
		}
   }
	
	public static String normaliseAnagram(String word){
		char[] charArray = word.replaceAll("\\s", "").toLowerCase().toCharArray();
		Arrays.sort( charArray );
		
		return new String( charArray );
	}

	@Override
	public Map<String, Set<String>> getAnagrams(String words) {
		Map<String, Set<String>> result = new HashMap<>();
		
		if(words != null && ! words.isEmpty())
		for(String word: words.split(",") ){
			String key = normaliseAnagram( word );
			Set<String> anagrams = WORD_STORE.get( key );
			result.put( word, anagrams != null? anagrams: new HashSet<>());
		}
				
		return result;
	}
}
