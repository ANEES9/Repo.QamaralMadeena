package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {

	WebDriver driver;

	public BlogPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}

}
