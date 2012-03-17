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
 * This class is a wrapper for {@link Wishlist}.
 * </p>
 *
 * @author    MAL
 * @see       Wishlist
 * @generated
 */
public class WishlistWrapper implements Wishlist, ModelWrapper<Wishlist> {
	public WishlistWrapper(Wishlist wishlist) {
		_wishlist = wishlist;
	}

	public Class<?> getModelClass() {
		return Wishlist.class;
	}

	public String getModelClassName() {
		return Wishlist.class.getName();
	}

	/**
	* Returns the primary key of this wishlist.
	*
	* @return the primary key of this wishlist
	*/
	public long getPrimaryKey() {
		return _wishlist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this wishlist.
	*
	* @param primaryKey the primary key of this wishlist
	*/
	public void setPrimaryKey(long primaryKey) {
		_wishlist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the wishlist ID of this wishlist.
	*
	* @return the wishlist ID of this wishlist
	*/
	public long getWishlistId() {
		return _wishlist.getWishlistId();
	}

	/**
	* Sets the wishlist ID of this wishlist.
	*
	* @param wishlistId the wishlist ID of this wishlist
	*/
	public void setWishlistId(long wishlistId) {
		_wishlist.setWishlistId(wishlistId);
	}

	/**
	* Returns the user ID of this wishlist.
	*
	* @return the user ID of this wishlist
	*/
	public long getUserId() {
		return _wishlist.getUserId();
	}

	/**
	* Sets the user ID of this wishlist.
	*
	* @param userId the user ID of this wishlist
	*/
	public void setUserId(long userId) {
		_wishlist.setUserId(userId);
	}

	/**
	* Returns the user uuid of this wishlist.
	*
	* @return the user uuid of this wishlist
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlist.getUserUuid();
	}

	/**
	* Sets the user uuid of this wishlist.
	*
	* @param userUuid the user uuid of this wishlist
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_wishlist.setUserUuid(userUuid);
	}

	/**
	* Returns the wish ID of this wishlist.
	*
	* @return the wish ID of this wishlist
	*/
	public long getWishId() {
		return _wishlist.getWishId();
	}

	/**
	* Sets the wish ID of this wishlist.
	*
	* @param wishId the wish ID of this wishlist
	*/
	public void setWishId(long wishId) {
		_wishlist.setWishId(wishId);
	}

	/**
	* Returns the rating of this wishlist.
	*
	* @return the rating of this wishlist
	*/
	public int getRating() {
		return _wishlist.getRating();
	}

	/**
	* Sets the rating of this wishlist.
	*
	* @param rating the rating of this wishlist
	*/
	public void setRating(int rating) {
		_wishlist.setRating(rating);
	}

	/**
	* Returns the comment of this wishlist.
	*
	* @return the comment of this wishlist
	*/
	public java.lang.String getComment() {
		return _wishlist.getComment();
	}

	/**
	* Sets the comment of this wishlist.
	*
	* @param comment the comment of this wishlist
	*/
	public void setComment(java.lang.String comment) {
		_wishlist.setComment(comment);
	}

	public boolean isNew() {
		return _wishlist.isNew();
	}

	public void setNew(boolean n) {
		_wishlist.setNew(n);
	}

	public boolean isCachedModel() {
		return _wishlist.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wishlist.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wishlist.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wishlist.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wishlist.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wishlist.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wishlist.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WishlistWrapper((Wishlist)_wishlist.clone());
	}

	public int compareTo(it.mal.projectaladdin.model.Wishlist wishlist) {
		return _wishlist.compareTo(wishlist);
	}

	@Override
	public int hashCode() {
		return _wishlist.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.mal.projectaladdin.model.Wishlist> toCacheModel() {
		return _wishlist.toCacheModel();
	}

	public it.mal.projectaladdin.model.Wishlist toEscapedModel() {
		return new WishlistWrapper(_wishlist.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wishlist.toString();
	}

	public java.lang.String toXmlString() {
		return _wishlist.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wishlist.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Wishlist getWrappedWishlist() {
		return _wishlist;
	}

	public Wishlist getWrappedModel() {
		return _wishlist;
	}

	public void resetOriginalValues() {
		_wishlist.resetOriginalValues();
	}

	private Wishlist _wishlist;
}