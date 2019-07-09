/* ====================================================================
 * Inera s.r.l.
 * Via Gaetano Malasoma, 18 - 56121 Ospedaletto Pisa (PI), Italy.
 * Email: info@inera.it
 * Tel:   (+39) (0)50 9911800
 * Fax:   (+39) (0)50 9911830
 *
 * Copyright (C) 2019.  All Rights Reserved.
 */
package com.github.davidepastore.liferay.model;

import com.liferay.portal.kernel.util.Validator;

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

	/**
	 * @param classPK
	 * @param groupId
	 * @param name
	 * @param alt
	 * @param title
	 * @param type
	 * @param uuid
	 * @param fileEntryId
	 * @param resourcePrimKey
	 */
	public DDMImage(String classPK, String groupId, String name, String alt, String title, String type, String uuid,
			String fileEntryId, String resourcePrimKey) {
		super();
		this.classPK = classPK;
		this.groupId = groupId;
		this.name = name;
		this.alt = alt;
		this.title = title;
		this.type = type;
		this.uuid = uuid;
		this.fileEntryId = fileEntryId;
		this.resourcePrimKey = resourcePrimKey;
	}



	public String getClassPK() {
		return classPK;
	}

	public void setClassPK(String classPK) {
		this.classPK = classPK;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public String getResourcePrimKey() {
		return resourcePrimKey;
	}

	public void setResourcePrimKey(String resourcePrimKey) {
		this.resourcePrimKey = resourcePrimKey;
	}

	public String getUrl() {
		if(Validator.isNotNull(this.groupId) && Validator.isNotNull(this.classPK) && Validator.isNotNull(this.title) && Validator.isNotNull(this.uuid))
			return "/documents/" + this.groupId + "/" + this.classPK + "/" + this.title + "/" + this.uuid;
		else return "";
	}
}
