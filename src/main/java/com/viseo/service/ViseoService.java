package com.viseo.service;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class ViseoService {

	private static final Logger log = LogManager.getLogger(ViseoService.class);

	public final Map<String, Long> countryToCountMap = new HashMap<String, Long>(){
		{
			put("IN", new Long(1000));
		}
		{
			put("US", new Long(3000));
		}
		{
			put("ES", new Long(4000));
		}
		{
			put("IT", new Long(5000));
		}
		{
			put("UK", new Long(2000));
		}

	};

	public long getCronaCountWorld() {
		log.info("got the getCronaCountWorld call");
		return 15000l;
	}

	public long getCronaCountByCountry(@NonNull String country) {
		log.info("got the getCronaCountByCountry call");
		Long count = countryToCountMap.get(country.trim().toUpperCase());
		return count == null? 0 : count.longValue();
	}
}
