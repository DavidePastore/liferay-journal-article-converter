# liferay-journal-article-converter
[![Build Status](https://travis-ci.org/DavidePastore/liferay-journal-article-converter.svg?branch=master)](https://travis-ci.org/DavidePastore/liferay-journal-article-converter)
[![Coverage Status](https://coveralls.io/repos/github/DavidePastore/liferay-journal-article-converter/badge.svg?branch=master)](https://coveralls.io/github/DavidePastore/liferay-journal-article-converter?branch=master)
[![Known Vulnerabilities](https://snyk.io/test/github/davidepastore/liferay-journal-article-converter/badge.svg)](https://snyk.io/test/github/davidepastore/liferay-journal-article-converter)

This project converts a Liferay Journal Article to a Custom Java Object.


## What is behind?

This project help me in my day to day work, where I have to convert a generic JournalArticle instance content in something that I can directly use in REST. You can also use this library to do data migration.


## Install

If you use Maven to manage the dependencies in your Java project (and you should!), you do not need to download; just place the following into your POM's <dependencies> section:
```xml
<dependency>
  <!-- Liferay Journal Article Converter library -->
  <groupId>com.github.davidepastore</groupId>
  <artifactId>liferay-journal-article-converter</artifactId>
  <version>7.0.0</version>
</dependency>
```


## Usage


### Basic Example

First inspect your Journal Article XML structure.

```xml
<?xml version="1.0"?>

<root available-locales="en_US,ca_ES" default-locale="en_US">
	<dynamic-element name="text" type="text" index-type="keyword" index="0">
		<dynamic-content language-id="en_US"><![CDATA[English]]></dynamic-content>
		<dynamic-content language-id="ca_ES"><![CDATA[Catalan]]></dynamic-content>
	</dynamic-element>
	<dynamic-element name="aBoolean" type="boolean" index-type="keyword" index="0">
		<dynamic-content language-id="en_US"><![CDATA[true]]></dynamic-content>
		<dynamic-content language-id="ca_ES"><![CDATA[]]></dynamic-content>
	</dynamic-element>
</root>
```

After create your Java Object that extends the ```ConvertibleJournalArticle``` object.

```java
public class Foo extends ConvertibleJournalArticle {

	@JournalArticleField(title = true)
	private String title;

	@JournalArticleField(name = "text")
	private String text;

	@JournalArticleField(name = "aBoolean")
	private Boolean myMagicBoolean;
	
	
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
}
```

As you can see every class field has the ```JournalArticleField``` annotation. There are three different attributes for that annotation:
- ```title```: the field annotated with this will contain the title.
- ```name```: the field annotated with this will be associated with the structure field with the given name value;
- ```base```: the field annotated with this will be associated with the base nested structure field. This has sense only in a nested objects/structures.

Now simply use it:

```java
long id = 20121l;
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(id);
Foo foo = new Foo();
foo.fromJournalArticle(journalArticle);
```

You could also get the Journal Article content only for a specific Locale:

```java
long id = 20121l;
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(id);
Locale locale = new Locale("ca");
Foo foo = new Foo();
foo.fromJournalArticle(journalArticle, locale);
```


### List Example
This library supports lists. Let's see an example:

XML structure:

```xml
<?xml version="1.0"?>

<root available-locales="en_US,ca_ES" default-locale="en_US">
	<dynamic-element name="text" type="text" index-type="keyword" index="0">
		<dynamic-content language-id="en_US"><![CDATA[English]]></dynamic-content>
		<dynamic-content language-id="ca_ES"><![CDATA[Catalan]]></dynamic-content>
	</dynamic-element>
	<dynamic-element name="text" type="text" index-type="keyword" index="1">
		<dynamic-content language-id="en_US"><![CDATA[Second text]]></dynamic-content>
		<dynamic-content language-id="ca_ES"><![CDATA[null]]></dynamic-content>
	</dynamic-element>
	<dynamic-element name="text" type="text" index-type="keyword" index="2">
		<dynamic-content language-id="en_US"><![CDATA[Third text]]></dynamic-content>
		<dynamic-content language-id="ca_ES"><![CDATA[null]]></dynamic-content>
	</dynamic-element>
</root>
```

Java Object:

```java
public class Bar extends ConvertibleJournalArticle {

	@JournalArticleField(title = true)
	private String title;

	@JournalArticleField(name = "text")
	private List<String> text;
	
	
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
}
```

Use it:

```java
long id = 20121l;
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(id);
Bar bar = new Bar();
bar.fromJournalArticle(journalArticle);
List<String> text = bar.getText(); //This will contain a List with values of "English", "Second text" and "Third text"
```


### Nested Example
This library supports nested structures. Let's see an example:


XML structure:

```xml
<?xml version="1.0"?>

<root available-locales="en_US,ca_ES" default-locale="en_US">
	<dynamic-element name="nested" type="document_library" index-type="keyword" index="0">
		<dynamic-element name="nestedBoolean" index="0" type="boolean" index-type="keyword">
			<dynamic-content language-id="en_US"><![CDATA[true]]></dynamic-content>
		</dynamic-element>
		<dynamic-element name="nestedText" index="0" type="text" index-type="keyword">
			<dynamic-content language-id="en_US"><![CDATA[Nested Text :)]]></dynamic-content>
		</dynamic-element>
		<dynamic-content language-id="en_US"><![CDATA[/documents/20281/0/welcome_community/d83a745d-8624-44c0-baad-3c7d05e3b2dc?t=1439123090000]]></dynamic-content>
	</dynamic-element>
</root>
```

Java Objects:

```java
public class NestedFoo extends ConvertibleJournalArticle {

	@JournalArticleField(name = "nested")
	private NestedBar nestedBar;

	public NestedBar getNestedBar() {
		return nestedBar;
	}

	public void setNestedBar(NestedBar nestedBar) {
		this.nestedBar = nestedBar;
	}
	
	@Override
	public String toString() {
		return "nestedBar: " + nestedBar;
	}

}
```

```java
public class NestedBar extends ConvertibleJournalArticle {

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
}
```

Use them:

```java
long id = 20121l;
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(id);
NestedFoo nestedFoo = new NestedFoo();
nestedFoo.fromJournalArticle(journalArticle);
NestedBar nestedBar = nestedFoo.getNestedBar();
System.out.println(nestedBar); //[myBoolean = true, myText = Nested Text :), documentsAndMedia = /documents/20281/0/welcome_community/d83a745d-8624-44c0-baad-3c7d05e3b2dc?t=1439123090000]
```


## Issues

If you find problems, please open an issue [here](https://github.com/DavidePastore/liferay-journal-article-converter/issues).
