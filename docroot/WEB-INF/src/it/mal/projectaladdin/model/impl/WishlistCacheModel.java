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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.mal.projectaladdin.model.Wishlist;

import java.io.Serializable;

/**
 * The cache model class for representing Wishlist in entity cache.
 *
 * @author MAL
 * @see Wishlist
 * @generated
 */
public class WishlistCacheModel implements CacheModel<Wishlist>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{wishlistId=");
		sb.append(wishlistId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", wishId=");
		sb.append(wishId);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	public Wishlist toEntityModel() {
		WishlistImpl wishlistImpl = new WishlistImpl();

		wishlistImpl.setWishlistId(wishlistId);
		wishlistImpl.setUserId(userId);
		wishlistImpl.setWishId(wishId);
		wishlistImpl.setRating(rating);

		if (comment == null) {
			wishlistImpl.setComment(StringPool.BLANK);
		}
		else {
			wishlistImpl.setComment(comment);
		}

		wishlistImpl.resetOriginalValues();

		return wishlistImpl;
	}

	public long wishlistId;
	public long userId;
	public long wishId;
	public int rating;
	public String comment;
}