/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.mal.projectaladdin.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author    MAL
 * @see       Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
	public CategoryWrapper(Category category) {
		_category = category;
	}

	public Class<?> getModelClass() {
		return Category.class;
	}

	public String getModelClassName() {
		return Category.class.getName();
	}

	/**
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Returns the name of this category.
	*
	* @return the name of this category
	*/
	public java.lang.String getName() {
		return _category.getName();
	}

	/**
	* Sets the name of this category.
	*
	* @param name the name of this category
	*/
	public void setName(java.lang.String name) {
		_category.setName(name);
	}

	/**
	* Returns the author of this category.
	*
	* @return the author of this category
	*/
	public long getAuthor() {
		return _category.getAuthor();
	}

	/**
	* Sets the author of this category.
	*
	* @param author the author of this category
	*/
	public void setAuthor(long author) {
		_category.setAuthor(author);
	}

	/**
	* Returns the description of this category.
	*
	* @return the description of this category
	*/
	public java.lang.String getDescription() {
		return _category.getDescription();
	}

	/**
	* Sets the description of this category.
	*
	* @param description the description of this category
	*/
	public void setDescription(java.lang.String description) {
		_category.setDescription(description);
	}

	/**
	* Returns the parent category of this category.
	*
	* @return the parent category of this category
	*/
	public long getParentCategory() {
		return _category.getParentCategory();
	}

	/**
	* Sets the parent category of this category.
	*
	* @param parentCategory the parent category of this category
	*/
	public void setParentCategory(long parentCategory) {
		_category.setParentCategory(parentCategory);
	}

	public boolean isNew() {
		return _category.isNew();
	}

	public void setNew(boolean n) {
		_category.setNew(n);
	}

	public boolean isCachedModel() {
		return _category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWrapper((Category)_category.clone());
	}

	public int compareTo(it.mal.projectaladdin.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.mal.projectaladdin.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	public it.mal.projectaladdin.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_category.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Category getWrappedCategory() {
		return _category;
	}

	public Category getWrappedModel() {
		return _category;
	}

	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private Category _category;
}