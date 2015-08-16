package com.github.davidepastore.liferay.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class SimpleTestJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(title = true)
	private String title;

	@JournalArticleField(name = "text")
	private String text;

	@JournalArticleField(name = "aBoolean")
	private Boolean myMagicBoolean;

	@JournalArticleField(name = "date")
	private Date date;

	@JournalArticleField(name = "decimal")
	private Double decimal;

	@JournalArticleField(name = "html")
	private String html;

	@JournalArticleField(name = "image")
	private String image;

	@JournalArticleField(name = "integer")
	private Integer integer;

	@JournalArticleField(name = "linkToPage")
	private String linkToPage;

	@JournalArticleField(name = "number")
	private BigDecimal number;

	@JournalArticleField(name = "radio")
	private String radio;

	@JournalArticleField(name = "select")
	private List<String> select;

	@JournalArticleField(name = "textBox")
	private String textBox;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getMyMagicBoolean() {
		return myMagicBoolean;
	}

	public void setMyMagicBoolean(Boolean myMagicBoolean) {
		this.myMagicBoolean = myMagicBoolean;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getDecimal() {
		return decimal;
	}

	public void setDecimal(Double decimal) {
		this.decimal = decimal;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public String getLinkToPage() {
		return linkToPage;
	}

	public void setLinkToPage(String linkToPage) {
		this.linkToPage = linkToPage;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public List<String> getSelect() {
		return select;
	}

	public void setSelect(List<String> select) {
		this.select = select;
	}

	public String getTextBox() {
		return textBox;
	}

	public void setTextBox(String textBox) {
		this.textBox = textBox;
	}

}
