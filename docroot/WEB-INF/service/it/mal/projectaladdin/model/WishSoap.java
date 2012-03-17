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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    MAL
 * @generated
 */
public class WishSoap implements Serializable {
	public static WishSoap toSoapModel(Wish model) {
		WishSoap soapModel = new WishSoap();

		soapModel.setWishId(model.getWishId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setPrice(model.getPrice());
		soapModel.setUrl(model.getUrl());
		soapModel.setImage(model.getImage());
		soapModel.setCreationDate(model.getCreationDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WishSoap[] toSoapModels(Wish[] models) {
		WishSoap[] soapModels = new WishSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WishSoap[][] toSoapModels(Wish[][] models) {
		WishSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WishSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WishSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WishSoap[] toSoapModels(List<Wish> models) {
		List<WishSoap> soapModels = new ArrayList<WishSoap>(models.size());

		for (Wish model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WishSoap[soapModels.size()]);
	}

	public WishSoap() {
	}

	public long getPrimaryKey() {
		return _wishId;
	}

	public void setPrimaryKey(long pk) {
		setWishId(pk);
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

	private long _wishId;
	private String _name;
	private String _description;
	private double _price;
	private String _url;
	private String _image;
	private Date _creationDate;
	private Date _modifiedDate;
}