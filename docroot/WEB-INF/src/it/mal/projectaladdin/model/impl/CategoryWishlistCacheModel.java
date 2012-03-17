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

package it.mal.projectaladdin.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import it.mal.projectaladdin.model.CategoryWishlist;

import java.io.Serializable;

/**
 * The cache model class for representing CategoryWishlist in entity cache.
 *
 * @author MAL
 * @see CategoryWishlist
 * @generated
 */
public class CategoryWishlistCacheModel implements CacheModel<CategoryWishlist>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", wishlistId=");
		sb.append(wishlistId);
		sb.append("}");

		return sb.toString();
	}

	public CategoryWishlist toEntityModel() {
		CategoryWishlistImpl categoryWishlistImpl = new CategoryWishlistImpl();

		categoryWishlistImpl.setCategoryId(categoryId);
		categoryWishlistImpl.setWishlistId(wishlistId);

		categoryWishlistImpl.resetOriginalValues();

		return categoryWishlistImpl;
	}

	public long categoryId;
	public long wishlistId;
}