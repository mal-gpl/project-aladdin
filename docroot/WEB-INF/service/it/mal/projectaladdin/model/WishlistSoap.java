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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    MAL
 * @generated
 */
public class WishlistSoap implements Serializable {
	public static WishlistSoap toSoapModel(Wishlist model) {
		WishlistSoap soapModel = new WishlistSoap();

		soapModel.setWishlistId(model.getWishlistId());
		soapModel.setUserId(model.getUserId());
		soapModel.setWishId(model.getWishId());
		soapModel.setRating(model.getRating());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static WishlistSoap[] toSoapModels(Wishlist[] models) {
		WishlistSoap[] soapModels = new WishlistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WishlistSoap[][] toSoapModels(Wishlist[][] models) {
		WishlistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WishlistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WishlistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WishlistSoap[] toSoapModels(List<Wishlist> models) {
		List<WishlistSoap> soapModels = new ArrayList<WishlistSoap>(models.size());

		for (Wishlist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WishlistSoap[soapModels.size()]);
	}

	public WishlistSoap() {
	}

	public long getPrimaryKey() {
		return _wishlistId;
	}

	public void setPrimaryKey(long pk) {
		setWishlistId(pk);
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

	private long _wishlistId;
	private long _userId;
	private long _wishId;
	private int _rating;
	private String _comment;
}