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
 * This class is a wrapper for {@link CategoryWishlistLocalService}.
 * </p>
 *
 * @author    MAL
 * @see       CategoryWishlistLocalService
 * @generated
 */
public class CategoryWishlistLocalServiceWrapper
	implements CategoryWishlistLocalService,
		ServiceWrapper<CategoryWishlistLocalService> {
	public CategoryWishlistLocalServiceWrapper(
		CategoryWishlistLocalService categoryWishlistLocalService) {
		_categoryWishlistLocalService = categoryWishlistLocalService;
	}

	/**
	* Adds the category wishlist to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlist the category wishlist
	* @return the category wishlist that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist addCategoryWishlist(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.addCategoryWishlist(categoryWishlist);
	}

	/**
	* Creates a new category wishlist with the primary key. Does not add the category wishlist to the database.
	*
	* @param categoryWishlistPK the primary key for the new category wishlist
	* @return the new category wishlist
	*/
	public it.mal.projectaladdin.model.CategoryWishlist createCategoryWishlist(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK) {
		return _categoryWishlistLocalService.createCategoryWishlist(categoryWishlistPK);
	}

	/**
	* Deletes the category wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @throws PortalException if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCategoryWishlist(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_categoryWishlistLocalService.deleteCategoryWishlist(categoryWishlistPK);
	}

	/**
	* Deletes the category wishlist from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlist the category wishlist
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCategoryWishlist(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryWishlistLocalService.deleteCategoryWishlist(categoryWishlist);
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
		return _categoryWishlistLocalService.dynamicQuery(dynamicQuery);
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
		return _categoryWishlistLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _categoryWishlistLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _categoryWishlistLocalService.dynamicQueryCount(dynamicQuery);
	}

	public it.mal.projectaladdin.model.CategoryWishlist fetchCategoryWishlist(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.fetchCategoryWishlist(categoryWishlistPK);
	}

	/**
	* Returns the category wishlist with the primary key.
	*
	* @param categoryWishlistPK the primary key of the category wishlist
	* @return the category wishlist
	* @throws PortalException if a category wishlist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist getCategoryWishlist(
		it.mal.projectaladdin.service.persistence.CategoryWishlistPK categoryWishlistPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.getCategoryWishlist(categoryWishlistPK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the category wishlists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category wishlists
	* @param end the upper bound of the range of category wishlists (not inclusive)
	* @return the range of category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.mal.projectaladdin.model.CategoryWishlist> getCategoryWishlists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.getCategoryWishlists(start, end);
	}

	/**
	* Returns the number of category wishlists.
	*
	* @return the number of category wishlists
	* @throws SystemException if a system exception occurred
	*/
	public int getCategoryWishlistsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.getCategoryWishlistsCount();
	}

	/**
	* Updates the category wishlist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlist the category wishlist
	* @return the category wishlist that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist updateCategoryWishlist(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.updateCategoryWishlist(categoryWishlist);
	}

	/**
	* Updates the category wishlist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryWishlist the category wishlist
	* @param merge whether to merge the category wishlist with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category wishlist that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.mal.projectaladdin.model.CategoryWishlist updateCategoryWishlist(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryWishlistLocalService.updateCategoryWishlist(categoryWishlist,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoryWishlistLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoryWishlistLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryWishlistLocalService getWrappedCategoryWishlistLocalService() {
		return _categoryWishlistLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryWishlistLocalService(
		CategoryWishlistLocalService categoryWishlistLocalService) {
		_categoryWishlistLocalService = categoryWishlistLocalService;
	}

	public CategoryWishlistLocalService getWrappedService() {
		return _categoryWishlistLocalService;
	}

	public void setWrappedService(
		CategoryWishlistLocalService categoryWishlistLocalService) {
		_categoryWishlistLocalService = categoryWishlistLocalService;
	}

	private CategoryWishlistLocalService _categoryWishlistLocalService;
}