package com.example.covid19tracker;

import java.util.List;

public class Response{
	private List<StatewiseItem> statewise;

	public void setStatewise(List<StatewiseItem> statewise){
		this.statewise = statewise;
	}

	public List<StatewiseItem> getStatewise(){
		return statewise;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"statewise = '" + statewise + '\'' + 
			"}";
		}
}