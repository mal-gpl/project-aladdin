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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.mal.projectaladdin.service.CategoryWishlistLocalServiceUtil;
import it.mal.projectaladdin.service.persistence.CategoryWishlistPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author MAL
 */
public class CategoryWishlistClp extends BaseModelImpl<CategoryWishlist>
	implements CategoryWishlist {
	public CategoryWishlistClp() {
	}

	public Class<?> getModelClass() {
		return CategoryWishlist.class;
	}

	public String getModelClassName() {
		return CategoryWishlist.class.getName();
	}

	public CategoryWishlistPK getPrimaryKey() {
		return new CategoryWishlistPK(_categoryId, _wishlistId);
	}

	public void setPrimaryKey(CategoryWishlistPK primaryKey) {
		setCategoryId(primaryKey.categoryId);
		setWishlistId(primaryKey.wishlistId);
	}

	public Serializable getPrimaryKeyObj() {
		return new CategoryWishlistPK(_categoryId, _wishlistId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CategoryWishlistPK)primaryKeyObj);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getWishlistId() {
		return _wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		_wishlistId = wishlistId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CategoryWishlistLocalServiceUtil.addCategoryWishlist(this);
		}
		else {
			CategoryWishlistLocalServiceUtil.updateCategoryWishlist(this);
		}
	}

	@Override
	public CategoryWishlist toEscapedModel() {
		return (CategoryWishlist)Proxy.newProxyInstance(CategoryWishlist.class.getClassLoader(),
			new Class[] { CategoryWishlist.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CategoryWishlistClp clone = new CategoryWishlistClp();

		clone.setCategoryId(getCategoryId());
		clone.setWishlistId(getWishlistId());

		return clone;
	}

	public int compareTo(CategoryWishlist categoryWishlist) {
		CategoryWishlistPK primaryKey = categoryWishlist.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CategoryWishlistClp categoryWishlist = null;

		try {
			categoryWishlist = (CategoryWishlistClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		CategoryWishlistPK primaryKey = categoryWishlist.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", wishlistId=");
		sb.append(getWishlistId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.mal.projectaladdin.model.CategoryWishlist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wishlistId</column-name><column-value><![CDATA[");
		sb.append(getWishlistId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoryId;
	private long _wishlistId;
}