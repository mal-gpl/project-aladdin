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

package it.mal.projectaladdin.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.mal.projectaladdin.model.Category;

import java.util.List;

/**
 * The persistence utility for the category service. This utility wraps {@link CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see CategoryPersistence
 * @see CategoryPersistenceImpl
 * @generated
 */
public class CategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Category category) {
		getPersistence().clearCache(category);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Category> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Category update(Category category, boolean merge)
		throws SystemException {
		return getPersistence().update(category, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Category update(Category category, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(category, merge, serviceContext);
	}

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public static void cacheResult(
		it.mal.projectaladdin.model.Category category) {
		getPersistence().cacheResult(category);
	}

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public static void cacheResult(
		java.util.List<it.mal.projectaladdin.model.Category> categories) {
		getPersistence().cacheResult(categories);
	}

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public static it.mal.projectaladdin.model.Category create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static it.mal.projectaladdin.model.Category updateImpl(
		it.mal.projectaladdin.model.Category category, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(category, merge);
	}

	/**
	* Returns the category with the primary key or throws a {@link it.mal.projectaladdin.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the categories where name = &#63;.
	*
	* @param name the name
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByName(name);
	}

	/**
	* Returns a range of all the categories where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the categories where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first category in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence().findByByName_First(name, orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence().findByByName_Last(name, orderByComparator);
	}

	/**
	* Returns the categories before and after the current category in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current category
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category[] findByByName_PrevAndNext(
		long categoryId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence()
				   .findByByName_PrevAndNext(categoryId, name, orderByComparator);
	}

	/**
	* Returns all the categories where author = &#63;.
	*
	* @param author the author
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByAuthor(
		long author) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByAuthor(author);
	}

	/**
	* Returns a range of all the categories where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByAuthor(
		long author, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByAuthor(author, start, end);
	}

	/**
	* Returns an ordered range of all the categories where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByAuthor(
		long author, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByAuthor(author, start, end, orderByComparator);
	}

	/**
	* Returns the first category in the ordered set where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByByAuthor_First(
		long author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence().findByByAuthor_First(author, orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByByAuthor_Last(
		long author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence().findByByAuthor_Last(author, orderByComparator);
	}

	/**
	* Returns the categories before and after the current category in the ordered set where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current category
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category[] findByByAuthor_PrevAndNext(
		long categoryId, long author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence()
				   .findByByAuthor_PrevAndNext(categoryId, author,
			orderByComparator);
	}

	/**
	* Returns all the categories where parentCategory = &#63;.
	*
	* @param parentCategory the parent category
	* @return the matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByParentCategory(
		long parentCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByParentCategory(parentCategory);
	}

	/**
	* Returns a range of all the categories where parentCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentCategory the parent category
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByParentCategory(
		long parentCategory, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByParentCategory(parentCategory, start, end);
	}

	/**
	* Returns an ordered range of all the categories where parentCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentCategory the parent category
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findByByParentCategory(
		long parentCategory, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByParentCategory(parentCategory, start, end,
			orderByComparator);
	}

	/**
	* Returns the first category in the ordered set where parentCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentCategory the parent category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByByParentCategory_First(
		long parentCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence()
				   .findByByParentCategory_First(parentCategory,
			orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where parentCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentCategory the parent category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a matching category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category findByByParentCategory_Last(
		long parentCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence()
				   .findByByParentCategory_Last(parentCategory,
			orderByComparator);
	}

	/**
	* Returns the categories before and after the current category in the ordered set where parentCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current category
	* @param parentCategory the parent category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws it.mal.projectaladdin.NoSuchCategoryException if a category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.mal.projectaladdin.model.Category[] findByByParentCategory_PrevAndNext(
		long categoryId, long parentCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchCategoryException {
		return getPersistence()
				   .findByByParentCategory_PrevAndNext(categoryId,
			parentCategory, orderByComparator);
	}

	/**
	* Returns all the categories.
	*
	* @return the categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.mal.projectaladdin.model.Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the categories where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByName(name);
	}

	/**
	* Removes all the categories where author = &#63; from the database.
	*
	* @param author the author
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByAuthor(long author)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByAuthor(author);
	}

	/**
	* Removes all the categories where parentCategory = &#63; from the database.
	*
	* @param parentCategory the parent category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByParentCategory(long parentCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByParentCategory(parentCategory);
	}

	/**
	* Removes all the categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of categories where name = &#63;.
	*
	* @param name the name
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByName(name);
	}

	/**
	* Returns the number of categories where author = &#63;.
	*
	* @param author the author
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByAuthor(long author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByAuthor(author);
	}

	/**
	* Returns the number of categories where parentCategory = &#63;.
	*
	* @param parentCategory the parent category
	* @return the number of matching categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByParentCategory(long parentCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByParentCategory(parentCategory);
	}

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryPersistence)PortletBeanLocatorUtil.locate(it.mal.projectaladdin.service.ClpSerializer.getServletContextName(),
					CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CategoryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CategoryUtil.class, "_persistence");
	}

	private static CategoryPersistence _persistence;
}