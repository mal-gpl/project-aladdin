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

package it.mal.projectaladdin.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WishlistLocalService}.
 * </p>
 *
 * @author    MAL
 * @see       WishlistLocalService
 * @generated
 */
public class WishlistLocalServiceWrapper implements WishlistLocalService,
	ServiceWrapper<WishlistLocalService> {
	public WishlistLocalServiceWrapper(
		WishlistLocalService wishlistLocalService) {
		_wishlistLocalService = wishlistLocalService;
	}

	/**
	* Adds the wishlist to the database. Also notifies the appropriate model listeners.
	*
	* @param wishlist the wishlist
	* @return the wishlist that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wishlist addWishlist(
		it.mal.projectaladdin.model.Wishlist wishlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.addWishlist(wishlist);
	}

	/**
	* Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	*
	* @param wishlistId the primary key for the new wishlist
	* @return the new wishlist
	*/
	public it.mal.projectaladdin.model.Wishlist createWishlist(long wishlistId) {
		return _wishlistLocalService.createWishlist(wishlistId);
	}

	/**
	* Deletes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wishlistId the primary key of the wishlist
	* @throws PortalException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWishlist(long wishlistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wishlistLocalService.deleteWishlist(wishlistId);
	}

	/**
	* Deletes the wishlist from the database. Also notifies the appropriate model listeners.
	*
	* @param wishlist the wishlist
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWishlist(it.mal.projectaladdin.model.Wishlist wishlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		_wishlistLocalService.deleteWishlist(wishlist);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.dynamicQueryCount(dynamicQuery);
	}

	public it.mal.projectaladdin.model.Wishlist fetchWishlist(long wishlistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.fetchWishlist(wishlistId);
	}

	/**
	* Returns the wishlist with the primary key.
	*
	* @param wishlistId the primary key of the wishlist
	* @return the wishlist
	* @throws PortalException if a wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wishlist getWishlist(long wishlistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.getWishlist(wishlistId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the wishlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wishlists
	* @param end the upper bound of the range of wishlists (not inclusive)
	* @return the range of wishlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.Wishlist> getWishlists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.getWishlists(start, end);
	}

	/**
	* Returns the number of wishlists.
	*
	* @return the number of wishlists
	* @throws SystemException if a system exception occurred
	*/
	public int getWishlistsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.getWishlistsCount();
	}

	/**
	* Updates the wishlist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wishlist the wishlist
	* @return the wishlist that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wishlist updateWishlist(
		it.mal.projectaladdin.model.Wishlist wishlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.updateWishlist(wishlist);
	}

	/**
	* Updates the wishlist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wishlist the wishlist
	* @param merge whether to merge the wishlist with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the wishlist that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.Wishlist updateWishlist(
		it.mal.projectaladdin.model.Wishlist wishlist, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wishlistLocalService.updateWishlist(wishlist, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wishlistLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wishlistLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WishlistLocalService getWrappedWishlistLocalService() {
		return _wishlistLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWishlistLocalService(
		WishlistLocalService wishlistLocalService) {
		_wishlistLocalService = wishlistLocalService;
	}

	public WishlistLocalService getWrappedService() {
		return _wishlistLocalService;
	}

	public void setWrappedService(WishlistLocalService wishlistLocalService) {
		_wishlistLocalService = wishlistLocalService;
	}

	private WishlistLocalService _wishlistLocalService;
}