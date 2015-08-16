package com.github.davidepastore.liferay.model;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class MultiNestedTestSecondLevelJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(name = "nestedLevelDecimal")
	private MultiNestedTestThirdLevelJournalArticle nestedLevelDecimal;

	@JournalArticleField(base = true)
	private Boolean myBoolean;

	public MultiNestedTestThirdLevelJournalArticle getNestedLevelDecimal() {
		return nestedLevelDecimal;
	}

	public void setNestedLevelDecimal(
			MultiNestedTestThirdLevelJournalArticle nestedLevelDecimal) {
		this.nestedLevelDecimal = nestedLevelDecimal;
	}

	public Boolean getMyBoolean() {
		return myBoolean;
	}

	public void setMyBoolean(Boolean myBoolean) {
		this.myBoolean = myBoolean;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MultiNestedTestSecondLevelJournalArticle
				&& nestedLevelDecimal.equals(((MultiNestedTestSecondLevelJournalArticle) obj)
						.getNestedLevelDecimal())
				&& myBoolean.equals(((MultiNestedTestSecondLevelJournalArticle) obj)
						.getMyBoolean());
	}

}
