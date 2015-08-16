package com.github.davidepastore.liferay;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.io.IOUtils;

import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;
import com.github.davidepastore.liferay.model.DocumentsAndMediaJournalArticle;
import com.github.davidepastore.liferay.model.MultiNestedTestFirstLevelJournalArticle;
import com.github.davidepastore.liferay.model.MultiNestedTestSecondLevelJournalArticle;
import com.github.davidepastore.liferay.model.MultiNestedTestThirdLevelJournalArticle;
import com.github.davidepastore.liferay.model.NestedListTestJournalArticle;
import com.github.davidepastore.liferay.model.NestedTestJournalArticle;
import com.github.davidepastore.liferay.model.SimpleTestJournalArticle;
import com.github.davidepastore.liferay.model.TestJournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Unit test for {@link ConvertibleJournalArticle}.
 */
public class JournalArticleConverterTest extends TestCase {
	
	private static Log log = LogFactoryUtil.getLog(JournalArticleConverterTest.class);
	
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public JournalArticleConverterTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(JournalArticleConverterTest.class);
	}
	
	/**
	 * Test with a simple journal article structure.
	 * @throws Exception 
	 */
	public void testFromJournalArticleSimple() throws Exception {
		String content = getFileContent("structure0.xml");
		MockedJournalArticle article = new MockedJournalArticle();
		article.setContent(content);
		SimpleTestJournalArticle testJournalArticle = new SimpleTestJournalArticle();
		testJournalArticle.fromJournalArticle(article);
		String text = "English";
		
		//String value
		assertEquals(text, testJournalArticle.getText());
		
		//Boolean value
		assertEquals(true, testJournalArticle.getMyMagicBoolean().booleanValue());
		
		//Date value
		assertEquals(new Date(1438732800000l), testJournalArticle.getDate());
		
		//Decimal value
		assertEquals(new Double(32.0), testJournalArticle.getDecimal());
		
		//Image value
		String image = "/image/journal/article?img_id=22202&t=1439380567193";
		assertEquals(image, testJournalArticle.getImage());
		
		//Integer value
		assertEquals(new Integer(13), testJournalArticle.getInteger());
		
		//Link to layout value
		assertEquals("1@public@20281", testJournalArticle.getLinkToPage());
		
		//Number value
		assertEquals(new BigDecimal(444), testJournalArticle.getNumber());
		
		//Radio value
		assertEquals("value 1", testJournalArticle.getRadio());
		
		//List value
		List<String> list = new ArrayList<String>();
		list.add("value 2");
		list.add("value 3");
		assertEquals(list, testJournalArticle.getSelect());
		
		//Text Box value
		assertEquals("Text box", testJournalArticle.getTextBox());
	}

	/**
	 * Test fromJournalArticle method for catalan.
	 * @throws Exception 
	 */
	public void testFromJournalArticleForCatalan() throws Exception {
		String content = getFileContent("structure1.xml");
		MockedJournalArticle article = new MockedJournalArticle();
		article.setContent(content);
		String language = "ca";
		TestJournalArticle testJournalArticle = new TestJournalArticle();
		Locale locale = new Locale(language);
		testJournalArticle.fromJournalArticle(article, locale);
		List<String> text = new ArrayList<String>();
		text.add("Catalan");
		text.add("null");
		text.add("null");
		
		//List of String
		assertEquals(text, testJournalArticle.getText());
		
		//Boolean value
		assertEquals(false, testJournalArticle.getMyMagicBoolean().booleanValue());
	}
	
	/**
	 * Test fromJournalArticle method for default language.
	 * @throws Exception 
	 */
	public void testFromJournalArticleForDefaultLanguage() throws Exception {
		String content = getFileContent("structure1.xml");
		MockedJournalArticle article = new MockedJournalArticle();
		article.setContent(content);
		TestJournalArticle testJournalArticle = new TestJournalArticle();
		testJournalArticle.fromJournalArticle(article);
		List<String> text = new ArrayList<String>();
		text.add("English");
		text.add("Second text");
		text.add("Third text");
		
		//List of String
		assertEquals(text, testJournalArticle.getText());
		
		//Boolean value
		assertEquals(true, testJournalArticle.getMyMagicBoolean().booleanValue());
		
		//Date value
		assertEquals(new Date(1438732800000l), testJournalArticle.getDate());
		
		//Decimal value
		assertEquals(new Double(32.0), testJournalArticle.getDecimal());
		
		//Image value
		String image = "/image/journal/article?img_id=22202&t=1439380567193";
		assertEquals(image, testJournalArticle.getImage());
		
		//Documents and media value
		String documentsAndMedia = "/documents/20281/0/welcome_tools/ab4b08a2-a1ba-4b12-acd7-21b62db8887a?t=1439123008000";
		assertEquals(documentsAndMedia, testJournalArticle.getDocumentsAndMedia());
		
		//Integer value
		assertEquals(new Integer(13), testJournalArticle.getInteger());
		
		//Link to layout value
		assertEquals("1@public@20281", testJournalArticle.getLinkToPage());
		
		//Number value
		assertEquals(new BigDecimal(444), testJournalArticle.getNumber());
		
		//Radio value
		assertEquals("value 1", testJournalArticle.getRadio());
		
		//List value
		List<String> list = new ArrayList<String>();
		list.add("value 2");
		list.add("value 3");
		assertEquals(list, testJournalArticle.getSelect());
		
		//Text Box value
		assertEquals("Text box", testJournalArticle.getTextBox());
	}
	
	/**
	 * Test fromJournalArticle method for nested elements.
	 * @throws Exception 
	 */
	public void testFromJournalArticleForNestedElements() throws Exception {
		String content = getFileContent("structure2.xml");
		MockedJournalArticle article = new MockedJournalArticle();
		article.setContent(content);
		NestedTestJournalArticle nestedTestJournalArticle = new NestedTestJournalArticle();
		nestedTestJournalArticle.fromJournalArticle(article);
		DocumentsAndMediaJournalArticle nestedJournalArticle = nestedTestJournalArticle.getDocumentsAndMedia();
		//Nested value
		assertEquals(true, nestedJournalArticle.getMyBoolean().booleanValue());
		assertEquals("Nested Text :)", nestedJournalArticle.getMyText());
	}
	
	/**
	 * Test fromJournalArticle method for multi level nested elements.
	 * @throws Exception 
	 */
	public void testFromJournalArticleForMultiLevelNestedElements() throws Exception {
		String content = getFileContent("structure4.xml");
		MockedJournalArticle article = new MockedJournalArticle();
		article.setContent(content);
		MultiNestedTestFirstLevelJournalArticle nestedTestJournalArticle = new MultiNestedTestFirstLevelJournalArticle();
		nestedTestJournalArticle.fromJournalArticle(article);
		
		//Mock data
		MultiNestedTestFirstLevelJournalArticle firstLevelJournalArticle = new MultiNestedTestFirstLevelJournalArticle();
		MultiNestedTestSecondLevelJournalArticle secondLevelJournalArticle = new MultiNestedTestSecondLevelJournalArticle();
		MultiNestedTestThirdLevelJournalArticle thirdLevelJournalArticle = new MultiNestedTestThirdLevelJournalArticle();
		thirdLevelJournalArticle.setDoubleNestedSelect("value 3");
		thirdLevelJournalArticle.setBaseLevelDecimal(10.023);
		secondLevelJournalArticle.setNestedLevelDecimal(thirdLevelJournalArticle);
		secondLevelJournalArticle.setMyBoolean(true);
		firstLevelJournalArticle.setBaseLevelBoolean(secondLevelJournalArticle);
		
		//Multi nested value
		assertEquals(nestedTestJournalArticle, firstLevelJournalArticle);
	}
	
	/**
	 * Test fromJournalArticle method for list of nested elements.
	 * @throws Exception 
	 */
	public void testFromJournalArticleForListOfNestedElements() throws Exception {
		String content = getFileContent("structure3.xml");
		MockedJournalArticle article = new MockedJournalArticle();
		article.setContent(content);
		NestedListTestJournalArticle nestedListTestJournalArticle = new NestedListTestJournalArticle();
		nestedListTestJournalArticle.fromJournalArticle(article);
		List<DocumentsAndMediaJournalArticle> documentsAndMediaList = new ArrayList<DocumentsAndMediaJournalArticle>();
		
		//Add first
		DocumentsAndMediaJournalArticle documentsAndMedia = new DocumentsAndMediaJournalArticle();
		documentsAndMedia.setMyBoolean(true);
		documentsAndMedia.setMyText("Text 1");
		documentsAndMedia.setDocumentsAndMedia("/documents/20281/0/welcome_community/d83a745d-8624-44c0-baad-3c7d05e3b2dc?t=1439123090000");
		documentsAndMediaList.add(documentsAndMedia);
		
		//Add second
		documentsAndMedia = new DocumentsAndMediaJournalArticle();
		documentsAndMedia.setMyBoolean(false);
		documentsAndMedia.setMyText("Text 2");
		documentsAndMedia.setDocumentsAndMedia("/documents/20281/0/welcome_community/d83a745d-8624-44c0-baad-3c7d05e3b2dc?t=1439123092344");
		documentsAndMediaList.add(documentsAndMedia);
		
		List<DocumentsAndMediaJournalArticle> myDocumentAndMediaList = nestedListTestJournalArticle.getDocumentsAndMedia();
		
		//Nested value
		assertEquals(documentsAndMediaList, myDocumentAndMediaList);
	}
	
	/**
	 * Read the file content.
	 * @param name The file name.
	 * @return Returns the {@link File} instance.
	 * @throws IOException 
	 */
	private String getFileContent(String name) throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
	    return IOUtils.toString(classLoader.getResourceAsStream(name));
	}
}
