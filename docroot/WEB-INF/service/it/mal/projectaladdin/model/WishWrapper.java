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
 * This class is a wrapper for {@link Wish}.
 * </p>
 *
 * @author    MAL
 * @see       Wish
 * @generated
 */
public class WishWrapper implements Wish, ModelWrapper<Wish> {
	public WishWrapper(Wish wish) {
		_wish = wish;
	}

	public Class<?> getModelClass() {
		return Wish.class;
	}

	public String getModelClassName() {
		return Wish.class.getName();
	}

	/**
	* Returns the primary key of this wish.
	*
	* @return the primary key of this wish
	*/
	public long getPrimaryKey() {
		return _wish.getPrimaryKey();
	}

	/**
	* Sets the primary key of this wish.
	*
	* @param primaryKey the primary key of this wish
	*/
	public void setPrimaryKey(long primaryKey) {
		_wish.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the wish ID of this wish.
	*
	* @return the wish ID of this wish
	*/
	public long getWishId() {
		return _wish.getWishId();
	}

	/**
	* Sets the wish ID of this wish.
	*
	* @param wishId the wish ID of this wish
	*/
	public void setWishId(long wishId) {
		_wish.setWishId(wishId);
	}

	/**
	* Returns the name of this wish.
	*
	* @return the name of this wish
	*/
	public java.lang.String getName() {
		return _wish.getName();
	}

	/**
	* Sets the name of this wish.
	*
	* @param name the name of this wish
	*/
	public void setName(java.lang.String name) {
		_wish.setName(name);
	}

	/**
	* Returns the description of this wish.
	*
	* @return the description of this wish
	*/
	public java.lang.String getDescription() {
		return _wish.getDescription();
	}

	/**
	* Sets the description of this wish.
	*
	* @param description the description of this wish
	*/
	public void setDescription(java.lang.String description) {
		_wish.setDescription(description);
	}

	/**
	* Returns the price of this wish.
	*
	* @return the price of this wish
	*/
	public double getPrice() {
		return _wish.getPrice();
	}

	/**
	* Sets the price of this wish.
	*
	* @param price the price of this wish
	*/
	public void setPrice(double price) {
		_wish.setPrice(price);
	}

	/**
	* Returns the url of this wish.
	*
	* @return the url of this wish
	*/
	public java.lang.String getUrl() {
		return _wish.getUrl();
	}

	/**
	* Sets the url of this wish.
	*
	* @param url the url of this wish
	*/
	public void setUrl(java.lang.String url) {
		_wish.setUrl(url);
	}

	/**
	* Returns the image of this wish.
	*
	* @return the image of this wish
	*/
	public java.lang.String getImage() {
		return _wish.getImage();
	}

	/**
	* Sets the image of this wish.
	*
	* @param image the image of this wish
	*/
	public void setImage(java.lang.String image) {
		_wish.setImage(image);
	}

	/**
	* Returns the creation date of this wish.
	*
	* @return the creation date of this wish
	*/
	public java.util.Date getCreationDate() {
		return _wish.getCreationDate();
	}

	/**
	* Sets the creation date of this wish.
	*
	* @param creationDate the creation date of this wish
	*/
	public void setCreationDate(java.util.Date creationDate) {
		_wish.setCreationDate(creationDate);
	}

	/**
	* Returns the modified date of this wish.
	*
	* @return the modified date of this wish
	*/
	public java.util.Date getModifiedDate() {
		return _wish.getModifiedDate();
	}

	/**
	* Sets the modified date of this wish.
	*
	* @param modifiedDate the modified date of this wish
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wish.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _wish.isNew();
	}

	public void setNew(boolean n) {
		_wish.setNew(n);
	}

	public boolean isCachedModel() {
		return _wish.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wish.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wish.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wish.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wish.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wish.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wish.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WishWrapper((Wish)_wish.clone());
	}

	public int compareTo(it.mal.projectaladdin.model.Wish wish) {
		return _wish.compareTo(wish);
	}

	@Override
	public int hashCode() {
		return _wish.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.mal.projectaladdin.model.Wish> toCacheModel() {
		return _wish.toCacheModel();
	}

	public it.mal.projectaladdin.model.Wish toEscapedModel() {
		return new WishWrapper(_wish.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wish.toString();
	}

	public java.lang.String toXmlString() {
		return _wish.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wish.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Wish getWrappedWish() {
		return _wish;
	}

	public Wish getWrappedModel() {
		return _wish;
	}

	public void resetOriginalValues() {
		_wish.resetOriginalValues();
	}

	private Wish _wish;
}