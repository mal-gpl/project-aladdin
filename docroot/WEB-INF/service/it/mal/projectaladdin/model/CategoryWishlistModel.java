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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.mal.projectaladdin.service.persistence.CategoryWishlistPK;

import java.io.Serializable;

/**
 * The base model interface for the CategoryWishlist service. Represents a row in the &quot;ALD_CategoryWishlist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.mal.projectaladdin.model.impl.CategoryWishlistModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.mal.projectaladdin.model.impl.CategoryWishlistImpl}.
 * </p>
 *
 * @author MAL
 * @see CategoryWishlist
 * @see it.mal.projectaladdin.model.impl.CategoryWishlistImpl
 * @see it.mal.projectaladdin.model.impl.CategoryWishlistModelImpl
 * @generated
 */
public interface CategoryWishlistModel extends BaseModel<CategoryWishlist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category wishlist model instance should use the {@link CategoryWishlist} interface instead.
	 */

	/**
	 * Returns the primary key of this category wishlist.
	 *
	 * @return the primary key of this category wishlist
	 */
	public CategoryWishlistPK getPrimaryKey();

	/**
	 * Sets the primary key of this category wishlist.
	 *
	 * @param primaryKey the primary key of this category wishlist
	 */
	public void setPrimaryKey(CategoryWishlistPK primaryKey);

	/**
	 * Returns the category ID of this category wishlist.
	 *
	 * @return the category ID of this category wishlist
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category wishlist.
	 *
	 * @param categoryId the category ID of this category wishlist
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the wishlist ID of this category wishlist.
	 *
	 * @return the wishlist ID of this category wishlist
	 */
	public long getWishlistId();

	/**
	 * Sets the wishlist ID of this category wishlist.
	 *
	 * @param wishlistId the wishlist ID of this category wishlist
	 */
	public void setWishlistId(long wishlistId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(CategoryWishlist categoryWishlist);

	public int hashCode();

	public CacheModel<CategoryWishlist> toCacheModel();

	public CategoryWishlist toEscapedModel();

	public String toString();

	public String toXmlString();
}