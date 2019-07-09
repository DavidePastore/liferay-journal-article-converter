package com.github.davidepastore.liferay.model;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Christian Palombella
 *
 */
public class DDMDocumentAndMedia {

	private String classPK;
	private String groupId;
	private String title;
	private String type;
	private String uuid;

	public DDMDocumentAndMedia() {
		super();
	}

	/**
	 * @param classPK
	 * @param groupId
	 * @param title
	 * @param type
	 * @param uuid
	 */
	public DDMDocumentAndMedia(String classPK, String groupId, String title, String type, String uuid) {
		super();
		this.classPK = classPK;
		this.groupId = groupId;
		this.title = title;
		this.type = type;
		this.uuid = uuid;
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

	public String getUrl() {
		if(Validator.isNotNull(this.groupId) && Validator.isNotNull(this.classPK) && Validator.isNotNull(this.title) && Validator.isNotNull(this.uuid))
			return "/documents/" + this.groupId + "/" + this.classPK + "/" + this.title + "/" + this.uuid;
		else return "";
	}
	
	/**
	 * Check if the object are equals.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof DDMDocumentAndMedia
				&& groupId.equals(((DDMDocumentAndMedia) obj)
						.getGroupId())
				&& classPK.equals(((DDMDocumentAndMedia) obj)
						.getClassPK())
				&& uuid.equals(((DDMDocumentAndMedia) obj)
						.getUuid())
				&& type.equals(((DDMDocumentAndMedia) obj)
						.getType())
				&& title.equals(((DDMDocumentAndMedia) obj)
						.getTitle());
	}

}
