package com.github.davidepastore.liferay.model;

import com.github.davidepastore.liferay.annotation.JournalArticleField;
import com.github.davidepastore.liferay.converter.ConvertibleJournalArticle;

public class MultiNestedTestThirdLevelJournalArticle extends ConvertibleJournalArticle {

	@JournalArticleField(name = "doubleNestedSelect")
	private String doubleNestedSelect;

	@JournalArticleField(base = true)
	private Double baseLevelDecimal;

	public String getDoubleNestedSelect() {
		return doubleNestedSelect;
	}

	public void setDoubleNestedSelect(String doubleNestedSelect) {
		this.doubleNestedSelect = doubleNestedSelect;
	}

	public Double getBaseLevelDecimal() {
		return baseLevelDecimal;
	}

	public void setBaseLevelDecimal(Double baseLevelDecimal) {
		this.baseLevelDecimal = baseLevelDecimal;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MultiNestedTestThirdLevelJournalArticle
				&& doubleNestedSelect.equals(((MultiNestedTestThirdLevelJournalArticle) obj)
						.getDoubleNestedSelect())
				&& baseLevelDecimal.equals(((MultiNestedTestThirdLevelJournalArticle) obj)
						.getBaseLevelDecimal());
	}

}
