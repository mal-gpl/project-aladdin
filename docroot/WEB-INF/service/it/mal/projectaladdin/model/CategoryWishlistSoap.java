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

import it.mal.projectaladdin.service.persistence.CategoryWishlistPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    MAL
 * @generated
 */
public class CategoryWishlistSoap implements Serializable {
	public static CategoryWishlistSoap toSoapModel(CategoryWishlist model) {
		CategoryWishlistSoap soapModel = new CategoryWishlistSoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setWishlistId(model.getWishlistId());

		return soapModel;
	}

	public static CategoryWishlistSoap[] toSoapModels(CategoryWishlist[] models) {
		CategoryWishlistSoap[] soapModels = new CategoryWishlistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoryWishlistSoap[][] toSoapModels(
		CategoryWishlist[][] models) {
		CategoryWishlistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategoryWishlistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoryWishlistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoryWishlistSoap[] toSoapModels(
		List<CategoryWishlist> models) {
		List<CategoryWishlistSoap> soapModels = new ArrayList<CategoryWishlistSoap>(models.size());

		for (CategoryWishlist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoryWishlistSoap[soapModels.size()]);
	}

	public CategoryWishlistSoap() {
	}

	public CategoryWishlistPK getPrimaryKey() {
		return new CategoryWishlistPK(_categoryId, _wishlistId);
	}

	public void setPrimaryKey(CategoryWishlistPK pk) {
		setCategoryId(pk.categoryId);
		setWishlistId(pk.wishlistId);
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

	private long _categoryId;
	private long _wishlistId;
}