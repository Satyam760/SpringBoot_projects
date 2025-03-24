package com.nt.docoment;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "PLAYER_INFO")
@Data

public class PlayerInfo {
	@Id
	private String id;
	private String pname;
	private String paddrs;
	private List<String>nickNames;
	private Set<Long> contactNumber;
	private String[] friends;
	private Map<String, String>impKnocks;
	private Properties idDetails;
	
	
	
}
