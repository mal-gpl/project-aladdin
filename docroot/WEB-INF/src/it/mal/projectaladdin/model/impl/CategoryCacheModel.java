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

import it.mal.projectaladdin.model.Category;

import java.io.Serializable;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author MAL
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", author=");
		sb.append(author);
		sb.append(", description=");
		sb.append(description);
		sb.append(", parentCategory=");
		sb.append(parentCategory);
		sb.append("}");

		return sb.toString();
	}

	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(categoryId);

		if (name == null) {
			categoryImpl.setName(StringPool.BLANK);
		}
		else {
			categoryImpl.setName(name);
		}

		categoryImpl.setAuthor(author);

		if (description == null) {
			categoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			categoryImpl.setDescription(description);
		}

		categoryImpl.setParentCategory(parentCategory);

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	public long categoryId;
	public String name;
	public long author;
	public String description;
	public long parentCategory;
}