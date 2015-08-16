package com.github.davidepastore.liferay.model;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class MultiNestedTestFirstLevelJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(name = "baseLevelBoolean")
	private MultiNestedTestSecondLevelJournalArticle baseLevelBoolean;

	public MultiNestedTestSecondLevelJournalArticle getBaseLevelBoolean() {
		return baseLevelBoolean;
	}

	public void setBaseLevelBoolean(
			MultiNestedTestSecondLevelJournalArticle baseLevelBoolean) {
		this.baseLevelBoolean = baseLevelBoolean;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MultiNestedTestFirstLevelJournalArticle
				&& baseLevelBoolean.equals(((MultiNestedTestFirstLevelJournalArticle) obj)
						.getBaseLevelBoolean());
	}

}
