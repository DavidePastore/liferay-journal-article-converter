package com.github.davidepastore.liferay;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.github.davidepastore.liferay.util.SimpleLocaleUtil;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleResource;
import com.liferay.journal.model.JournalFolder;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.CacheModel;

public class MockedJournalArticle implements JournalArticle{
	
	private static final long serialVersionUID = 8768627349017828838L;

	@SuppressWarnings("unused")
	private static Log log = LogFactoryUtil.getLog(MockedJournalArticle.class);
	
	private String content;

	public long getPrimaryKey() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Object clone(){
		return null;
	}

	public void setPrimaryKey(long primaryKey) {
		// TODO Auto-generated method stub
		
	}

	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUuid(String uuid) {
		// TODO Auto-generated method stub
		
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	public long getResourcePrimKey() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		// TODO Auto-generated method stub
		
	}

	public boolean isResourceMain() {
		// TODO Auto-generated method stub
		return false;
	}

	public long getGroupId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setGroupId(long groupId) {
		// TODO Auto-generated method stub
		
	}

	public long getCompanyId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCompanyId(long companyId) {
		// TODO Auto-generated method stub
		
	}

	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setUserId(long userId) {
		// TODO Auto-generated method stub
		
	}

	public String getUserUuid() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserUuid(String userUuid) {
		// TODO Auto-generated method stub
		
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		
	}

	public Date getCreateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCreateDate(Date createDate) {
		// TODO Auto-generated method stub
		
	}

	public Date getModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setModifiedDate(Date modifiedDate) {
		// TODO Auto-generated method stub
		
	}

	public long getFolderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setFolderId(long folderId) {
		// TODO Auto-generated method stub
		
	}

	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setClassName(String className) {
		// TODO Auto-generated method stub
		
	}

	public long getClassNameId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setClassNameId(long classNameId) {
		// TODO Auto-generated method stub
		
	}

	public long getClassPK() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setClassPK(long classPK) {
		// TODO Auto-generated method stub
		
	}

	public String getTreePath() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTreePath(String treePath) {
		// TODO Auto-generated method stub
		
	}

	public String getArticleId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setArticleId(String articleId) {
		// TODO Auto-generated method stub
		
	}

	public double getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setVersion(double version) {
		// TODO Auto-generated method stub
		
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle(Locale locale, boolean useDefault) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle(String languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle(String languageId, boolean useDefault) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitleCurrentLanguageId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitleCurrentValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Locale, String> getTitleMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	public void setTitle(String title, Locale locale) {
		// TODO Auto-generated method stub
		
	}

	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		// TODO Auto-generated method stub
		
	}

	public void setTitleCurrentLanguageId(String languageId) {
		// TODO Auto-generated method stub
		
	}

	public void setTitleMap(Map<Locale, String> titleMap) {
		// TODO Auto-generated method stub
		
	}

	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		// TODO Auto-generated method stub
		
	}

	public String getUrlTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUrlTitle(String urlTitle) {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription(Locale locale, boolean useDefault) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription(String languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription(String languageId, boolean useDefault) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescriptionCurrentLanguageId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescriptionCurrentValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Locale, String> getDescriptionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	public void setDescription(String description, Locale locale) {
		// TODO Auto-generated method stub
		
	}

	public void setDescription(String description, Locale locale,
			Locale defaultLocale) {
		// TODO Auto-generated method stub
		
	}

	public void setDescriptionCurrentLanguageId(String languageId) {
		// TODO Auto-generated method stub
		
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		// TODO Auto-generated method stub
		
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap,
			Locale defaultLocale) {
		// TODO Auto-generated method stub
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}

	public String getStructureId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStructureId(String structureId) {
		// TODO Auto-generated method stub
		
	}

	public String getTemplateId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTemplateId(String templateId) {
		// TODO Auto-generated method stub
		
	}

	public String getLayoutUuid() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLayoutUuid(String layoutUuid) {
		// TODO Auto-generated method stub
		
	}

	public Date getDisplayDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDisplayDate(Date displayDate) {
		// TODO Auto-generated method stub
		
	}

	public Date getExpirationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExpirationDate(Date expirationDate) {
		// TODO Auto-generated method stub
		
	}

	public Date getReviewDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setReviewDate(Date reviewDate) {
		// TODO Auto-generated method stub
		
	}

	public boolean getIndexable() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isIndexable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setIndexable(boolean indexable) {
		// TODO Auto-generated method stub
		
	}

	public boolean getSmallImage() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSmallImage() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setSmallImage(boolean smallImage) {
		// TODO Auto-generated method stub
		
	}

	public long getSmallImageId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSmallImageId(long smallImageId) {
		// TODO Auto-generated method stub
		
	}

	public String getSmallImageURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSmallImageURL(String smallImageURL) {
		// TODO Auto-generated method stub
		
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}

	public long getStatusByUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setStatusByUserId(long statusByUserId) {
		// TODO Auto-generated method stub
		
	}

	public String getStatusByUserUuid() throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		// TODO Auto-generated method stub
		
	}

	public String getStatusByUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatusByUserName(String statusByUserName) {
		// TODO Auto-generated method stub
		
	}

	public Date getStatusDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatusDate(Date statusDate) {
		// TODO Auto-generated method stub
		
	}

	public long getTrashEntryClassPK() {
		// TODO Auto-generated method stub
		return 0;
	}

	public TrashHandler getTrashHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isInTrash() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInTrashContainer() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getApproved() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isApproved() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDenied() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDraft() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInactive() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isIncomplete() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPending() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isScheduled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setNew(boolean n) {
		// TODO Auto-generated method stub
		
	}

	public boolean isCachedModel() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setCachedModel(boolean cachedModel) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEscapedModel() {
		// TODO Auto-generated method stub
		return false;
	}

	public Serializable getPrimaryKeyObj() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		// TODO Auto-generated method stub
		
	}

	public ExpandoBridge getExpandoBridge() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		// TODO Auto-generated method stub
		
	}

	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		// TODO Auto-generated method stub
		
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		// TODO Auto-generated method stub
		
	}

	public String[] getAvailableLanguageIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDefaultLanguageId() {
		return getDefaultLocale();
	}

	public int compareTo(JournalArticle journalArticle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public JournalArticle toEscapedModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public JournalArticle toUnescapedModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toXmlString() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getModelAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void resetOriginalValues() {
		// TODO Auto-generated method stub
		
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		// TODO Auto-generated method stub
		
	}

	public Class<?> getModelClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getModelClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	public StagedModelType getStagedModelType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void persist() throws SystemException {
		// TODO Auto-generated method stub
		
	}

	public void updateTreePath(String treePath) throws SystemException {
		// TODO Auto-generated method stub
		
	}

	public String buildTreePath() throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getArticleImageURL(ThemeDisplay themeDisplay) {
		// TODO Auto-generated method stub
		return null;
	}

	public JournalArticleResource getArticleResource() throws PortalException,
			SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getArticleResourceUuid() throws PortalException,
			SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getAvailableLocales() {
		Document document = Jsoup.parse(content);
		return document.select("root").first().attr("available-locales").split(",");
	}

	public String getContentByLocale(String languageId) {
		Document document = Jsoup.parse(content, "", Parser.xmlParser());
		String[] availableLocales = getAvailableLocales();
		Locale localeToUse = null;
		for (String availableLocale : availableLocales) {
			Locale locale = SimpleLocaleUtil.buildLocale(availableLocale);
			if(locale.getLanguage().startsWith(languageId)){
				localeToUse = locale;
			}
		}
		
		if(localeToUse == null){
			localeToUse = SimpleLocaleUtil.buildLocale(getDefaultLocale());
		}
		
		String localeToString = localeToUse.toString();
//		log.info("Using locale: " + localeToString);
		
		Elements dynamicContents = document.select("dynamic-content");
		for (Element element : dynamicContents) {
			if(!localeToString.equals(element.attr("language-id"))){
				element.remove();
			}
		}
		
		//Remove elements without children
		Elements dynamicElements = document.select("dynamic-element");
		for (Element element : dynamicElements) {
			if(element.children().isEmpty()){
				element.remove();
			}
		}
		
		return document.toString();
	}

	public String getDefaultLocale() {
		Document document = Jsoup.parse(content);
		return document.select("root").first().attr("default-locale");
	}

	public JournalFolder getFolder() throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSmallImageType() throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasApprovedVersion() throws SystemException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTemplateDriven() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setSmallImageType(String smallImageType) {
		// TODO Auto-generated method stub
		
	}

	public boolean isInTrashExplicitly() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInTrashImplicitly() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEntityCacheEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFinderCacheEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public long getArticleImageId(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DDMStructure getDDMStructure() throws PortalException {
		// TODO Auto-generated method stub
		return null;
	}

	public DDMTemplate getDDMTemplate() throws PortalException {
		// TODO Auto-generated method stub
		return null;
	}

	public com.liferay.portal.kernel.xml.Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	public Layout getLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDefaultLanguageId(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setDocument(com.liferay.portal.kernel.xml.Document arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getDDMStructureKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDDMTemplateKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getLastPublishDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry() throws PortalException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDDMStructureKey(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setDDMTemplateKey(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setExpandoBridgeAttributes(com.liferay.portal.kernel.model.BaseModel<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setExpandoBridgeAttributes(com.liferay.portal.kernel.service.ServiceContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setLastPublishDate(Date arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getArticleImageURL(com.liferay.portal.kernel.theme.ThemeDisplay arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheModel<JournalArticle> toCacheModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepareLocalizedFieldsForImport() throws LocaleException {
		// TODO Auto-generated method stub
		
	}

	public void prepareLocalizedFieldsForImport(Locale arg0)
			throws LocaleException {
		// TODO Auto-generated method stub
		
	}
}