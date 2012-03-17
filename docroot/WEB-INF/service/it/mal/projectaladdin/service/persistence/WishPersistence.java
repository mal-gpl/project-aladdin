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

import com.liferay.portal.service.persistence.BasePersistence;

import it.mal.projectaladdin.model.Wish;

/**
 * The persistence interface for the wish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see WishPersistenceImpl
 * @see WishUtil
 * @generated
 */
public interface WishPersistence extends BasePersistence<Wish> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WishUtil} to access the wish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the wish in the entity cache if it is enabled.
	*
	* @param wish the wish
	*/
	public void cacheResult(it.mal.projectaladdin.model.Wish wish);

	/**
	* Caches the wishs in the entity cache if it is enabled.
	*
	* @param wishs the wishs
	*/
	public void cacheResult(
		java.util.List<it.mal.projectaladdin.model.Wish> wishs);

	/**
	* Creates a new wish with the primary key. Does not add the wish to the database.
	*
	* @param wishId the primary key for the new wish
	* @return the new wish
	*/
	public it.mal.projectaladdin.model.Wish create(long wishId);

	/**
	* Removes the wish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wishId the primary key of the wish
	* @return the wish that was removed
	* @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wish remove(long wishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException;

	public it.mal.projectaladdin.model.Wish updateImpl(
		it.mal.projectaladdin.model.Wish wish, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the wish with the primary key or throws a {@link it.mal.projectaladdin.NoSuchWishException} if it could not be found.
	*
	* @param wishId the primary key of the wish
	* @return the wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wish findByPrimaryKey(long wishId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException;

	/**
	* Returns the wish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wishId the primary key of the wish
	* @return the wish, or <code>null</code> if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wish fetchByPrimaryKey(long wishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the wishs where name = &#63;.
	*
	* @param name the name
	* @return the matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wish> findByByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the wishs where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @return the range of matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wish> findByByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the wishs where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wish> findByByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first wish in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a matching wish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wish findByByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException;

	/**
	* Returns the last wish in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a matching wish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wish findByByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException;

	/**
	* Returns the wishs before and after the current wish in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param wishId the primary key of the current wish
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wish
	* @throws it.mal.projectaladdin.NoSuchWishException if a wish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wish[] findByByName_PrevAndNext(
		long wishId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.mal.projectaladdin.NoSuchWishException;

	/**
	* Returns all the wishs.
	*
	* @return the wishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the wishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @return the range of wishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wish> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the wishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishs
	* @param end the upper bound of the range of wishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wish> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wishs where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of wishs where name = &#63;.
	*
	* @param name the name
	* @return the number of matching wishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of wishs.
	*
	* @return the number of wishs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}