package com.github.davidepastore.liferay.model;

import java.util.List;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class NestedListTestJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(name = "nested")
	private List<DocumentsAndMediaJournalArticle> documentsAndMedia;

	public List<DocumentsAndMediaJournalArticle> getDocumentsAndMedia() {
		return documentsAndMedia;
	}

	public void setDocumentsAndMedia(List<DocumentsAndMediaJournalArticle> documentsAndMedia) {
		this.documentsAndMedia = documentsAndMedia;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (DocumentsAndMediaJournalArticle documentsAndMediaJournalArticle : documentsAndMedia) {
			string += documentsAndMediaJournalArticle.toString();
		}
		return "documentsAndMedia: " + string;
	}

}
