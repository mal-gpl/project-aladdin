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

import it.mal.projectaladdin.model.Wish;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Wish in entity cache.
 *
 * @author MAL
 * @see Wish
 * @generated
 */
public class WishCacheModel implements CacheModel<Wish>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{wishId=");
		sb.append(wishId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", price=");
		sb.append(price);
		sb.append(", url=");
		sb.append(url);
		sb.append(", image=");
		sb.append(image);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public Wish toEntityModel() {
		WishImpl wishImpl = new WishImpl();

		wishImpl.setWishId(wishId);

		if (name == null) {
			wishImpl.setName(StringPool.BLANK);
		}
		else {
			wishImpl.setName(name);
		}

		if (description == null) {
			wishImpl.setDescription(StringPool.BLANK);
		}
		else {
			wishImpl.setDescription(description);
		}

		wishImpl.setPrice(price);

		if (url == null) {
			wishImpl.setUrl(StringPool.BLANK);
		}
		else {
			wishImpl.setUrl(url);
		}

		if (image == null) {
			wishImpl.setImage(StringPool.BLANK);
		}
		else {
			wishImpl.setImage(image);
		}

		if (creationDate == Long.MIN_VALUE) {
			wishImpl.setCreationDate(null);
		}
		else {
			wishImpl.setCreationDate(new Date(creationDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wishImpl.setModifiedDate(null);
		}
		else {
			wishImpl.setModifiedDate(new Date(modifiedDate));
		}

		wishImpl.resetOriginalValues();

		return wishImpl;
	}

	public long wishId;
	public String name;
	public String description;
	public double price;
	public String url;
	public String image;
	public long creationDate;
	public long modifiedDate;
}