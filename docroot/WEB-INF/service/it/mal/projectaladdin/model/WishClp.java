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

import it.mal.projectaladdin.service.WishLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author MAL
 */
public class WishClp extends BaseModelImpl<Wish> implements Wish {
	public WishClp() {
	}

	public Class<?> getModelClass() {
		return Wish.class;
	}

	public String getModelClassName() {
		return Wish.class.getName();
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

	public long getWishId() {
		return _wishId;
	}

	public void setWishId(long wishId) {
		_wishId = wishId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
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
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getImage() {
		return _image;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			WishLocalServiceUtil.addWish(this);
		}
		else {
			WishLocalServiceUtil.updateWish(this);
		}
	}

	@Override
	public Wish toEscapedModel() {
		return (Wish)Proxy.newProxyInstance(Wish.class.getClassLoader(),
			new Class[] { Wish.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WishClp clone = new WishClp();

		clone.setWishId(getWishId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setPrice(getPrice());
		clone.setUrl(getUrl());
		clone.setImage(getImage());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
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

		WishClp wish = null;

		try {
			wish = (WishClp)obj;
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

	private long _wishId;
	private String _name;
	private String _description;
	private double _price;
	private String _url;
	private String _image;
	private Date _creationDate;
	private Date _modifiedDate;
}