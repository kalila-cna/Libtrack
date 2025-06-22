package com.LibTrack.model.dropdown;

import java.util.ArrayList;
import java.util.List;

public class Year {
	private List<Integer> years;
	
	public Year() {
		years=new ArrayList<>();
		years.add(1);
		years.add(2);
		years.add(3);
		years.add(4);
	}
	
	public List<Integer> getYears() {
		return years;
	}
	
	public void setYears(List<Integer> years) {
		this.years = years;
	}

	
}
