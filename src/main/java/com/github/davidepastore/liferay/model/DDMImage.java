package com.github.davidepastore.liferay.model;

/**
 * @author Christian Palombella
 *
 */
public class DDMImage {

	private String classPK;
	private String groupId;
	private String name;
	private String alt;
	private String title;
	private String type;
	private String uuid;
	private String fileEntryId;
	private String resourcePrimKey;

	public DDMImage() {
		super();
	}

	public String getClassPK() {
		return classPK;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public String getAlt() {
		return alt;
	}

	public String getFileEntryId() {
		return fileEntryId;
	}

	public String getResourcePrimKey() {
		return resourcePrimKey;
	}

}