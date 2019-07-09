package com.github.davidepastore.liferay.model;

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
