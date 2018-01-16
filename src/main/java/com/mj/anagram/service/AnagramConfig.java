package com.mj.anagram.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AnagramConfig {
	@Value("${anagram.protocol}")
	private String protocol;
	
	@Value("${anagram.domain}")
	private String domain;
	
	@Value("${anagram.path}")
	private String path;
	
	@Value("${anagram.file}")
	private String file;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	public String getURL(){
		return this.protocol + this.domain + this.path + this.file;
	}

}
