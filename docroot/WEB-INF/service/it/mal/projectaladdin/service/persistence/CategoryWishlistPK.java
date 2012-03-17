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

package it.mal.projectaladdin.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author MAL
 */
public class CategoryWishlistPK implements Comparable<CategoryWishlistPK>,
	Serializable {
	public long categoryId;
	public long wishlistId;

	public CategoryWishlistPK() {
	}

	public CategoryWishlistPK(long categoryId, long wishlistId) {
		this.categoryId = categoryId;
		this.wishlistId = wishlistId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public int compareTo(CategoryWishlistPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (categoryId < pk.categoryId) {
			value = -1;
		}
		else if (categoryId > pk.categoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (wishlistId < pk.wishlistId) {
			value = -1;
		}
		else if (wishlistId > pk.wishlistId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CategoryWishlistPK pk = null;

		try {
			pk = (CategoryWishlistPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((categoryId == pk.categoryId) && (wishlistId == pk.wishlistId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(categoryId) + String.valueOf(wishlistId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("categoryId");
		sb.append(StringPool.EQUAL);
		sb.append(categoryId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("wishlistId");
		sb.append(StringPool.EQUAL);
		sb.append(wishlistId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}