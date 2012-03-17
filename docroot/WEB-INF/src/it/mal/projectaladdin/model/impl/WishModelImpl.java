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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.mal.projectaladdin.model.Wish;
import it.mal.projectaladdin.model.WishModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the Wish service. Represents a row in the &quot;ALD_Wish&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.mal.projectaladdin.model.WishModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WishImpl}.
 * </p>
 *
 * @author MAL
 * @see WishImpl
 * @see it.mal.projectaladdin.model.Wish
 * @see it.mal.projectaladdin.model.WishModel
 * @generated
 */
public class WishModelImpl extends BaseModelImpl<Wish> implements WishModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wish model instance should use the {@link it.mal.projectaladdin.model.Wish} interface instead.
	 */
	public static final String TABLE_NAME = "ALD_Wish";
	public static final Object[][] TABLE_COLUMNS = {
			{ "wishId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "price", Types.DOUBLE },
			{ "url", Types.VARCHAR },
			{ "image", Types.VARCHAR },
			{ "creationDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table ALD_Wish (wishId LONG not null primary key,name VARCHAR(75) null,description VARCHAR(75) null,price DOUBLE,url VARCHAR(75) null,image VARCHAR(75) null,creationDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table ALD_Wish";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.mal.projectaladdin.model.Wish"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.mal.projectaladdin.model.Wish"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.mal.projectaladdin.model.Wish"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.mal.projectaladdin.model.Wish"));

	public WishModelImpl() {
	}

	public long getPrimaryKey() {
		return _wishId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWishId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_wishId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Wish.class;
	}

	public String getModelClassName() {
		return Wish.class.getName();
	}

	public long getWishId() {
		return _wishId;
	}

	public void setWishId(long wishId) {
		_wishId = wishId;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getImage() {
		if (_image == null) {
			return StringPool.BLANK;
		}
		else {
			return _image;
		}
	}

	public void setImage(String image) {
		_image = image;
	}

	public Date getCreationDate() {
		return _creationDate;
	}

	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Wish toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Wish)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					Wish.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		WishImpl wishImpl = new WishImpl();

		wishImpl.setWishId(getWishId());
		wishImpl.setName(getName());
		wishImpl.setDescription(getDescription());
		wishImpl.setPrice(getPrice());
		wishImpl.setUrl(getUrl());
		wishImpl.setImage(getImage());
		wishImpl.setCreationDate(getCreationDate());
		wishImpl.setModifiedDate(getModifiedDate());

		wishImpl.resetOriginalValues();

		return wishImpl;
	}

	public int compareTo(Wish wish) {
		long primaryKey = wish.getPrimaryKey();

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

		Wish wish = null;

		try {
			wish = (Wish)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wish.getPrimaryKey();

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
		WishModelImpl wishModelImpl = this;

		wishModelImpl._originalName = wishModelImpl._name;

		wishModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Wish> toCacheModel() {
		WishCacheModel wishCacheModel = new WishCacheModel();

		wishCacheModel.wishId = getWishId();

		wishCacheModel.name = getName();

		String name = wishCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			wishCacheModel.name = null;
		}

		wishCacheModel.description = getDescription();

		String description = wishCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			wishCacheModel.description = null;
		}

		wishCacheModel.price = getPrice();

		wishCacheModel.url = getUrl();

		String url = wishCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			wishCacheModel.url = null;
		}

		wishCacheModel.image = getImage();

		String image = wishCacheModel.image;

		if ((image != null) && (image.length() == 0)) {
			wishCacheModel.image = null;
		}

		Date creationDate = getCreationDate();

		if (creationDate != null) {
			wishCacheModel.creationDate = creationDate.getTime();
		}
		else {
			wishCacheModel.creationDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wishCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wishCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return wishCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{wishId=");
		sb.append(getWishId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", creationDate=");
		sb.append(getCreationDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.mal.projectaladdin.model.Wish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>wishId</column-name><column-value><![CDATA[");
		sb.append(getWishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Wish.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Wish.class
		};
	private long _wishId;
	private String _name;
	private String _originalName;
	private String _description;
	private double _price;
	private String _url;
	private String _image;
	private Date _creationDate;
	private Date _modifiedDate;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Wish _escapedModelProxy;
}