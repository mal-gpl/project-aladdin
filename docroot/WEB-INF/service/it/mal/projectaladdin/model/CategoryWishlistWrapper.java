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
 * This class is a wrapper for {@link CategoryWishlist}.
 * </p>
 *
 * @author    MAL
 * @see       CategoryWishlist
 * @generated
 */
public class CategoryWishlistWrapper implements CategoryWishlist,
	ModelWrapper<CategoryWishlist> {
	public CategoryWishlistWrapper(CategoryWishlist categoryWishlist) {
		_categoryWishlist = categoryWishlist;
	}

	public Class<?> getModelClass() {
		return CategoryWishlist.class;
	}

	public String getModelClassName() {
		return CategoryWishlist.class.getName();
	}

	/**
	* Returns the primary key of this category wishlist.
	*
	* @return the primary key of this category wishlist
	*/
	public it.mal.projectaladdin.service.persistence.CategoryWishlistPK getPrimaryKey() {
		return _categoryWishlist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category wishlist.
	*
	* @param primaryKey the primary key of this category wishlist
	*/
	public void setPrimaryKey(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK primaryKey) {
		_categoryWishlist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category wishlist.
	*
	* @return the category ID of this category wishlist
	*/
	public long getCategoryId() {
		return _categoryWishlist.getCategoryId();
	}

	/**
	* Sets the category ID of this category wishlist.
	*
	* @param categoryId the category ID of this category wishlist
	*/
	public void setCategoryId(long categoryId) {
		_categoryWishlist.setCategoryId(categoryId);
	}

	/**
	* Returns the wishlist ID of this category wishlist.
	*
	* @return the wishlist ID of this category wishlist
	*/
	public long getWishlistId() {
		return _categoryWishlist.getWishlistId();
	}

	/**
	* Sets the wishlist ID of this category wishlist.
	*
	* @param wishlistId the wishlist ID of this category wishlist
	*/
	public void setWishlistId(long wishlistId) {
		_categoryWishlist.setWishlistId(wishlistId);
	}

	public boolean isNew() {
		return _categoryWishlist.isNew();
	}

	public void setNew(boolean n) {
		_categoryWishlist.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoryWishlist.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoryWishlist.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoryWishlist.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoryWishlist.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoryWishlist.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoryWishlist.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoryWishlist.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWishlistWrapper((CategoryWishlist)_categoryWishlist.clone());
	}

	public int compareTo(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist) {
		return _categoryWishlist.compareTo(categoryWishlist);
	}

	@Override
	public int hashCode() {
		return _categoryWishlist.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.mal.projectaladdin.model.CategoryWishlist> toCacheModel() {
		return _categoryWishlist.toCacheModel();
	}

	public it.mal.projectaladdin.model.CategoryWishlist toEscapedModel() {
		return new CategoryWishlistWrapper(_categoryWishlist.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoryWishlist.toString();
	}

	public java.lang.String toXmlString() {
		return _categoryWishlist.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryWishlist.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CategoryWishlist getWrappedCategoryWishlist() {
		return _categoryWishlist;
	}

	public CategoryWishlist getWrappedModel() {
		return _categoryWishlist;
	}

	public void resetOriginalValues() {
		_categoryWishlist.resetOriginalValues();
	}

	private CategoryWishlist _categoryWishlist;
}