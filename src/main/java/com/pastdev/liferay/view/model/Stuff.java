package com.pastdev.liferay.view.model;

public class Stuff {
	private String stuff;
	
	private Stuff() {}
	
	public static Builder builder() {
		return new Builder();
	}

    public String getStuff() {
    	return stuff;
    }
    
    public static class Builder {
    	private Stuff stuff;

    	private Builder() {
    		stuff = new Stuff();
    	}
    	
    	public Stuff build() {
    		return stuff;
    	}
    	
    	public Builder setStuff( String stuff ) {
    		this.stuff.stuff = stuff;
    		return this;
    	}
    }
}
