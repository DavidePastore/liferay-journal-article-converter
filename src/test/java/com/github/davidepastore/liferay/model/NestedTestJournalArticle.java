package com.github.davidepastore.liferay.model;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class NestedTestJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(name = "nested")
	private DocumentsAndMediaJournalArticle documentsAndMedia;

	public DocumentsAndMediaJournalArticle getDocumentsAndMedia() {
		return documentsAndMedia;
	}

	public void setDocumentsAndMedia(DocumentsAndMediaJournalArticle documentsAndMedia) {
		this.documentsAndMedia = documentsAndMedia;
	}
	
	@Override
	public String toString() {
		return "documentsAndMedia: " + documentsAndMedia;
	}

}
