package com.pastdev.liferay.service.impl;

import com.pastdev.liferay.service.StuffService;
import com.pastdev.liferay.view.model.Stuff;

public class StuffServiceImpl implements StuffService {
	private String value;

	public Stuff getStuff() {
		return Stuff.builder()
				.setStuff( value )
				.build();
	}
	
	public void setValue( String value ) {
		this.value = value;
	}
}
