package com.parkinson.posterproject;

import org.w3c.dom.NodeList;

import us.monoid.web.Resty;

public class LibAPI {
	
	private NodeList nodes;
	
	private String api_host = "http://172.31.81.27:8085/PosterMaster/";
	
	// API caller class
	private Resty resty = new Resty();
	
	
	public boolean callAPI( String api, String get ) {
		
		try {
			nodes = resty.xml(api_host + api).get(get);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
	
	public NodeList getXML() {
		return nodes;
	}
	
}
