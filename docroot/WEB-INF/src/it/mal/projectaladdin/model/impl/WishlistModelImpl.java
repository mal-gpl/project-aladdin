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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.mal.projectaladdin.model.Wishlist;
import it.mal.projectaladdin.model.WishlistModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the Wishlist service. Represents a row in the &quot;ALD_Wishlist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.mal.projectaladdin.model.WishlistModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WishlistImpl}.
 * </p>
 *
 * @author MAL
 * @see WishlistImpl
 * @see it.mal.projectaladdin.model.Wishlist
 * @see it.mal.projectaladdin.model.WishlistModel
 * @generated
 */
public class WishlistModelImpl extends BaseModelImpl<Wishlist>
	implements WishlistModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wishlist model instance should use the {@link it.mal.projectaladdin.model.Wishlist} interface instead.
	 */
	public static final String TABLE_NAME = "ALD_Wishlist";
	public static final Object[][] TABLE_COLUMNS = {
			{ "wishlistId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "wishId", Types.BIGINT },
			{ "rating", Types.INTEGER },
			{ "comment_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ALD_Wishlist (wishlistId LONG not null primary key,userId LONG,wishId LONG,rating INTEGER,comment_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ALD_Wishlist";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.mal.projectaladdin.model.Wishlist"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.mal.projectaladdin.model.Wishlist"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.mal.projectaladdin.model.Wishlist"),
			true);
	public static long RATING_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.mal.projectaladdin.model.Wishlist"));

	public WishlistModelImpl() {
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

	public Class<?> getModelClass() {
		return Wishlist.class;
	}

	public String getModelClassName() {
		return Wishlist.class.getName();
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
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
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
		_columnBitmask |= RATING_COLUMN_BITMASK;

		if (!_setOriginalRating) {
			_setOriginalRating = true;

			_originalRating = _rating;
		}

		_rating = rating;
	}

	public int getOriginalRating() {
		return _originalRating;
	}

	public String getComment() {
		if (_comment == null) {
			return StringPool.BLANK;
		}
		else {
			return _comment;
		}
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Wishlist toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Wishlist)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					Wishlist.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		WishlistImpl wishlistImpl = new WishlistImpl();

		wishlistImpl.setWishlistId(getWishlistId());
		wishlistImpl.setUserId(getUserId());
		wishlistImpl.setWishId(getWishId());
		wishlistImpl.setRating(getRating());
		wishlistImpl.setComment(getComment());

		wishlistImpl.resetOriginalValues();

		return wishlistImpl;
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

		Wishlist wishlist = null;

		try {
			wishlist = (Wishlist)obj;
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
	public void resetOriginalValues() {
		WishlistModelImpl wishlistModelImpl = this;

		wishlistModelImpl._originalUserId = wishlistModelImpl._userId;

		wishlistModelImpl._setOriginalUserId = false;

		wishlistModelImpl._originalRating = wishlistModelImpl._rating;

		wishlistModelImpl._setOriginalRating = false;

		wishlistModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Wishlist> toCacheModel() {
		WishlistCacheModel wishlistCacheModel = new WishlistCacheModel();

		wishlistCacheModel.wishlistId = getWishlistId();

		wishlistCacheModel.userId = getUserId();

		wishlistCacheModel.wishId = getWishId();

		wishlistCacheModel.rating = getRating();

		wishlistCacheModel.comment = getComment();

		String comment = wishlistCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			wishlistCacheModel.comment = null;
		}

		return wishlistCacheModel;
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

	private static ClassLoader _classLoader = Wishlist.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Wishlist.class
		};
	private long _wishlistId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _wishId;
	private int _rating;
	private int _originalRating;
	private boolean _setOriginalRating;
	private String _comment;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Wishlist _escapedModelProxy;
}