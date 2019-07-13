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
import com.github.davidepastore.liferay.model.DDMDocumentAndMedia;
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

	@SuppressWarnings("unused")
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
		assertTrue(testJournalArticle.getMyMagicBoolean().booleanValue());

		//Date value
		assertEquals(new Date(1438732800000l), testJournalArticle.getDate());

		//Decimal value
		assertEquals(new Double(32.0), testJournalArticle.getDecimal());

		//Image value
		assertNotNull(testJournalArticle.getImage());
		assertEquals("46245", testJournalArticle.getImage().getClassPK());
		assertEquals("20127", testJournalArticle.getImage().getGroupId());
		assertEquals("Header.png", testJournalArticle.getImage().getTitle());
		assertEquals("document", testJournalArticle.getImage().getType());
		assertEquals("223fac3c-abe2-e24a-1097-31cd1ce030155", testJournalArticle.getImage().getUuid());
		assertEquals("", testJournalArticle.getImage().getName());
		assertEquals("", testJournalArticle.getImage().getAlt());
		assertEquals("", testJournalArticle.getImage().getFileEntryId());
		assertEquals("", testJournalArticle.getImage().getResourcePrimKey());

		//Documents and media value
		assertNotNull(testJournalArticle.getDocumentsAndMedia());
		assertEquals("46245", testJournalArticle.getDocumentsAndMedia().getClassPK());
		assertEquals("20127", testJournalArticle.getDocumentsAndMedia().getGroupId());
		assertEquals("Footer.png", testJournalArticle.getDocumentsAndMedia().getTitle());
		assertEquals("document", testJournalArticle.getDocumentsAndMedia().getType());
		assertEquals("223fac3c-abe2-e24a-1097-31cd1ce030156", testJournalArticle.getDocumentsAndMedia().getUuid());

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

		//Text Area value
		assertEquals("Text area", testJournalArticle.getTextArea());

		// Geolocation
		assertNotNull(testJournalArticle.getGeolocation());
		assertEquals(43.89193, testJournalArticle.getGeolocation().getLatitude());
		assertEquals(12.51133, testJournalArticle.getGeolocation().getLongitude());
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
		assertFalse(testJournalArticle.getMyMagicBoolean().booleanValue());
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
		assertTrue(testJournalArticle.getMyMagicBoolean().booleanValue());

		//Date value
		assertEquals(new Date(1438732800000l), testJournalArticle.getDate());

		//Decimal value
		assertEquals(new Double(32.0), testJournalArticle.getDecimal());

		//Image value
		assertNotNull(testJournalArticle.getImage());
		assertEquals("46245", testJournalArticle.getImage().getClassPK());
		assertEquals("20127", testJournalArticle.getImage().getGroupId());
		assertEquals("Header.png", testJournalArticle.getImage().getTitle());
		assertEquals("document", testJournalArticle.getImage().getType());
		assertEquals("", testJournalArticle.getImage().getName());
		assertEquals("", testJournalArticle.getImage().getAlt());
		assertEquals("", testJournalArticle.getImage().getFileEntryId());
		assertEquals("", testJournalArticle.getImage().getResourcePrimKey());

		//Documents and media value
		assertNotNull(testJournalArticle.getDocumentsAndMedia());
		assertEquals("46245", testJournalArticle.getDocumentsAndMedia().getClassPK());
		assertEquals("20127", testJournalArticle.getDocumentsAndMedia().getGroupId());
		assertEquals("Footer.png", testJournalArticle.getDocumentsAndMedia().getTitle());
		assertEquals("document", testJournalArticle.getDocumentsAndMedia().getType());
		assertEquals("223fac3c-abe2-e24a-1097-31cd1ce030156", testJournalArticle.getDocumentsAndMedia().getUuid());

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

		//Text Area value
		assertEquals("Text area", testJournalArticle.getTextArea());
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
		assertTrue(nestedJournalArticle.getMyBoolean().booleanValue());
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

		DDMDocumentAndMedia ddmDocumentAndMedia = new DDMDocumentAndMedia();
		ddmDocumentAndMedia.setClassPK("46245");
		ddmDocumentAndMedia.setGroupId("20127");
		ddmDocumentAndMedia.setTitle("Footer.png");
		ddmDocumentAndMedia.setType("document");
		ddmDocumentAndMedia.setUuid("223fac3c-abe2-e24a-1097-31cd1ce030156");
		
		//Add first
		DocumentsAndMediaJournalArticle documentsAndMedia = new DocumentsAndMediaJournalArticle();
		documentsAndMedia.setMyBoolean(true);
		documentsAndMedia.setMyText("Text 1");
		documentsAndMedia.setDocumentsAndMedia(ddmDocumentAndMedia);
		documentsAndMediaList.add(documentsAndMedia);

		//Add second
		documentsAndMedia = new DocumentsAndMediaJournalArticle();
		documentsAndMedia.setMyBoolean(false);
		documentsAndMedia.setMyText("Text 2");
		documentsAndMedia.setDocumentsAndMedia(ddmDocumentAndMedia);
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
