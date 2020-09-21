package com.automation.training.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.WikiHomePage;

public class WikiTests extends BaseTests{
	
	/*
	@Test
	public void testWikiSearch() {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.buscar("Java");
		Assert.assertEquals(articlePage.getPageTitle(), "Java");	
	}*/

	@Test
	public void testArticleBasicInteraction() {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.buscar("Noruega");
		Assert.assertEquals(articlePage.getPageTitle(), "Noruega");
		articlePage.buscar("Italia");
		Assert.assertEquals(articlePage.getPageTitle(), "Italia");
	}



}
