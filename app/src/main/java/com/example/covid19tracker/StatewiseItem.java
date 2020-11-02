package com.example.covid19tracker;

import androidx.recyclerview.widget.RecyclerView;

public class StatewiseItem {
	private String recovered;
	private String active;
	private String state;
	private String confirmed;
	private String deaths;
    public StatewiseItem()
	{}
	public StatewiseItem(String recovered,String act,String st,String con,String dea) {
	   this.recovered=recovered;
	   this.active=act;
	   this.state=st;
	   this.confirmed=con;
	   this.deaths=dea;
    }
	public void setRecovered(String recovered){
		this.recovered = recovered;
	}

	public String getRecovered(){
		return recovered;
	}
	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setConfirmed(String confirmed){
		this.confirmed = confirmed;
	}

	public String getConfirmed(){
		return confirmed;
	}

	public void setDeaths(String deaths){
		this.deaths = deaths;
	}

	public String getDeaths(){
		return deaths;
	}
}
