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
import com.liferay.portal.util.PortalUtil;

import it.mal.projectaladdin.service.WishlistLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author MAL
 */
public class WishlistClp extends BaseModelImpl<Wishlist> implements Wishlist {
	public WishlistClp() {
	}

	public Class<?> getModelClass() {
		return Wishlist.class;
	}

	public String getModelClassName() {
		return Wishlist.class.getName();
	}

	public long getPrimaryKey() {
		return _wishlistId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWishlistId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_wishlistId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getWishlistId() {
		return _wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		_wishlistId = wishlistId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getWishId() {
		return _wishId;
	}

	public void setWishId(long wishId) {
		_wishId = wishId;
	}

	public int getRating() {
		return _rating;
	}

	public void setRating(int rating) {
		_rating = rating;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WishlistLocalServiceUtil.addWishlist(this);
		}
		else {
			WishlistLocalServiceUtil.updateWishlist(this);
		}
	}

	@Override
	public Wishlist toEscapedModel() {
		return (Wishlist)Proxy.newProxyInstance(Wishlist.class.getClassLoader(),
			new Class[] { Wishlist.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WishlistClp clone = new WishlistClp();

		clone.setWishlistId(getWishlistId());
		clone.setUserId(getUserId());
		clone.setWishId(getWishId());
		clone.setRating(getRating());
		clone.setComment(getComment());

		return clone;
	}

	public int compareTo(Wishlist wishlist) {
		long primaryKey = wishlist.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WishlistClp wishlist = null;

		try {
			wishlist = (WishlistClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wishlist.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{wishlistId=");
		sb.append(getWishlistId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", wishId=");
		sb.append(getWishId());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.mal.projectaladdin.model.Wishlist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wishlistId</column-name><column-value><![CDATA[");
		sb.append(getWishlistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wishId</column-name><column-value><![CDATA[");
		sb.append(getWishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _wishlistId;
	private long _userId;
	private String _userUuid;
	private long _wishId;
	private int _rating;
	private String _comment;
}