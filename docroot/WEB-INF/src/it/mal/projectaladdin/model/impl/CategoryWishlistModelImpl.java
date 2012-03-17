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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.mal.projectaladdin.model.CategoryWishlist;
import it.mal.projectaladdin.model.CategoryWishlistModel;
import it.mal.projectaladdin.service.persistence.CategoryWishlistPK;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the CategoryWishlist service. Represents a row in the &quot;ALD_CategoryWishlist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.mal.projectaladdin.model.CategoryWishlistModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CategoryWishlistImpl}.
 * </p>
 *
 * @author MAL
 * @see CategoryWishlistImpl
 * @see it.mal.projectaladdin.model.CategoryWishlist
 * @see it.mal.projectaladdin.model.CategoryWishlistModel
 * @generated
 */
public class CategoryWishlistModelImpl extends BaseModelImpl<CategoryWishlist>
	implements CategoryWishlistModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a category wishlist model instance should use the {@link it.mal.projectaladdin.model.CategoryWishlist} interface instead.
	 */
	public static final String TABLE_NAME = "ALD_CategoryWishlist";
	public static final Object[][] TABLE_COLUMNS = {
			{ "categoryId", Types.BIGINT },
			{ "wishlistId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ALD_CategoryWishlist (categoryId LONG not null,wishlistId LONG not null,primary key (categoryId, wishlistId))";
	public static final String TABLE_SQL_DROP = "drop table ALD_CategoryWishlist";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.mal.projectaladdin.model.CategoryWishlist"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.mal.projectaladdin.model.CategoryWishlist"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.mal.projectaladdin.model.CategoryWishlist"));

	public CategoryWishlistModelImpl() {
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

	public Class<?> getModelClass() {
		return CategoryWishlist.class;
	}

	public String getModelClassName() {
		return CategoryWishlist.class.getName();
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

	@Override
	public CategoryWishlist toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CategoryWishlist)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CategoryWishlistImpl categoryWishlistImpl = new CategoryWishlistImpl();

		categoryWishlistImpl.setCategoryId(getCategoryId());
		categoryWishlistImpl.setWishlistId(getWishlistId());

		categoryWishlistImpl.resetOriginalValues();

		return categoryWishlistImpl;
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

		CategoryWishlist categoryWishlist = null;

		try {
			categoryWishlist = (CategoryWishlist)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CategoryWishlist> toCacheModel() {
		CategoryWishlistCacheModel categoryWishlistCacheModel = new CategoryWishlistCacheModel();

		categoryWishlistCacheModel.categoryId = getCategoryId();

		categoryWishlistCacheModel.wishlistId = getWishlistId();

		return categoryWishlistCacheModel;
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

	private static ClassLoader _classLoader = CategoryWishlist.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CategoryWishlist.class
		};
	private long _categoryId;
	private long _wishlistId;
	private CategoryWishlist _escapedModelProxy;
}