package com.mj.anagram.service;

import java.util.Map;
import java.util.Set;

public interface AnagramService {
	public Map<String, Set<String>> getAnagrams(String words);
}
