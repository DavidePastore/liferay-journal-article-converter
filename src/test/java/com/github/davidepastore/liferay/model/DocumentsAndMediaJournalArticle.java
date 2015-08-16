package com.github.davidepastore.liferay.model;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class DocumentsAndMediaJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(name = "nestedBoolean")
	private Boolean myBoolean;

	@JournalArticleField(name = "nestedText")
	private String myText;

	@JournalArticleField(base = true)
	private String documentsAndMedia;

	public Boolean getMyBoolean() {
		return myBoolean;
	}

	public void setMyBoolean(Boolean myBoolean) {
		this.myBoolean = myBoolean;
	}

	public String getMyText() {
		return myText;
	}

	public void setMyText(String myText) {
		this.myText = myText;
	}

	public String getDocumentsAndMedia() {
		return documentsAndMedia;
	}

	public void setDocumentsAndMedia(String documentsAndMedia) {
		this.documentsAndMedia = documentsAndMedia;
	}

	@Override
	public String toString() {
		return "[myBoolean = " + myBoolean + ", myText = " + myText + ", documentsAndMedia = " + documentsAndMedia + "]";
	}

	/**
	 * Check if the object are equals.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof DocumentsAndMediaJournalArticle
				&& myBoolean.equals(((DocumentsAndMediaJournalArticle) obj)
						.getMyBoolean())
				&& myText.equals(((DocumentsAndMediaJournalArticle) obj)
						.getMyText())
				&& documentsAndMedia.equals(((DocumentsAndMediaJournalArticle) obj)
						.getDocumentsAndMedia());
	}

}
