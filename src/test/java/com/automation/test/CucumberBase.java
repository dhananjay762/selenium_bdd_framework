package com.automation.test;

import com.automation.repository.HomePage;
import com.automation.repository.JacketsMen;
import com.automation.repository.MenPage;

public class CucumberBase {
	
	public HomePage getHomePage() {
		return new HomePage();
	}
	
	public MenPage getMenPage() {
		return new MenPage();
	}
	
	public JacketsMen getJacketsMenPage() {
		return new JacketsMen();
	}

}
