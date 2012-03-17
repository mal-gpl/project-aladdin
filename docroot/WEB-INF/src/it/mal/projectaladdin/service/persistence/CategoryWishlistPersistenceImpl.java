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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.mal.projectaladdin.NoSuchCategoryWishlistException;
import it.mal.projectaladdin.model.CategoryWishlist;
import it.mal.projectaladdin.model.impl.CategoryWishlistImpl;
import it.mal.projectaladdin.model.impl.CategoryWishlistModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the category wishlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAL
 * @see CategoryWishlistPersistence
 * @see CategoryWishlistUtil
 * @generated
 */
public class CategoryWishlistPersistenceImpl extends BasePersistenceImpl<CategoryWishlist>
	implements CategoryWishlistPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryWishlistUtil} to access the category wishlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryWishlistImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
			CategoryWishlistModelImpl.FINDER_CACHE_ENABLED,
			CategoryWishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
			CategoryWishlistModelImpl.FINDER_CACHE_ENABLED,
			CategoryWishlistImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
			CategoryWishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the category wishlist in the entity cache if it is enabled.
	 *
	 * @param categoryWishlist the category wishlist
	 */
	public void cacheResult(CategoryWishlist categoryWishlist) {
		EntityCacheUtil.putResult(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
			CategoryWishlistImpl.class, categoryWishlist.getPrimaryKey(),
			categoryWishlist);

		categoryWishlist.resetOriginalValues();
	}

	/**
	 * Caches the category wishlists in the entity cache if it is enabled.
	 *
	 * @param categoryWishlists the category wishlists
	 */
	public void cacheResult(List<CategoryWishlist> categoryWishlists) {
		for (CategoryWishlist categoryWishlist : categoryWishlists) {
			if (EntityCacheUtil.getResult(
						CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
						CategoryWishlistImpl.class,
						categoryWishlist.getPrimaryKey()) == null) {
				cacheResult(categoryWishlist);
			}
			else {
				categoryWishlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all category wishlists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoryWishlistImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoryWishlistImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category wishlist.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryWishlist categoryWishlist) {
		EntityCacheUtil.removeResult(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
			CategoryWishlistImpl.class, categoryWishlist.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CategoryWishlist> categoryWishlists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoryWishlist categoryWishlist : categoryWishlists) {
			EntityCacheUtil.removeResult(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
				CategoryWishlistImpl.class, categoryWishlist.getPrimaryKey());
		}
	}

	/**
	 * Creates a new category wishlist with the primary key. Does not add the category wishlist to the database.
	 *
	 * @param categoryWishlistPK the primary key for the new category wishlist
	 * @return the new category wishlist
	 */
	public CategoryWishlist create(CategoryWishlistPK categoryWishlistPK) {
		CategoryWishlist categoryWishlist = new CategoryWishlistImpl();

		categoryWishlist.setNew(true);
		categoryWishlist.setPrimaryKey(categoryWishlistPK);

		return categoryWishlist;
	}

	/**
	 * Removes the category wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryWishlistPK the primary key of the category wishlist
	 * @return the category wishlist that was removed
	 * @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryWishlist remove(CategoryWishlistPK categoryWishlistPK)
		throws NoSuchCategoryWishlistException, SystemException {
		return remove((Serializable)categoryWishlistPK);
	}

	/**
	 * Removes the category wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category wishlist
	 * @return the category wishlist that was removed
	 * @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryWishlist remove(Serializable primaryKey)
		throws NoSuchCategoryWishlistException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CategoryWishlist categoryWishlist = (CategoryWishlist)session.get(CategoryWishlistImpl.class,
					primaryKey);

			if (categoryWishlist == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryWishlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoryWishlist);
		}
		catch (NoSuchCategoryWishlistException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CategoryWishlist removeImpl(CategoryWishlist categoryWishlist)
		throws SystemException {
		categoryWishlist = toUnwrappedModel(categoryWishlist);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, categoryWishlist);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(categoryWishlist);

		return categoryWishlist;
	}

	@Override
	public CategoryWishlist updateImpl(
		it.mal.projectaladdin.model.CategoryWishlist categoryWishlist,
		boolean merge) throws SystemException {
		categoryWishlist = toUnwrappedModel(categoryWishlist);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, categoryWishlist, merge);

			categoryWishlist.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
			CategoryWishlistImpl.class, categoryWishlist.getPrimaryKey(),
			categoryWishlist);

		return categoryWishlist;
	}

	protected CategoryWishlist toUnwrappedModel(
		CategoryWishlist categoryWishlist) {
		if (categoryWishlist instanceof CategoryWishlistImpl) {
			return categoryWishlist;
		}

		CategoryWishlistImpl categoryWishlistImpl = new CategoryWishlistImpl();

		categoryWishlistImpl.setNew(categoryWishlist.isNew());
		categoryWishlistImpl.setPrimaryKey(categoryWishlist.getPrimaryKey());

		categoryWishlistImpl.setCategoryId(categoryWishlist.getCategoryId());
		categoryWishlistImpl.setWishlistId(categoryWishlist.getWishlistId());

		return categoryWishlistImpl;
	}

	/**
	 * Returns the category wishlist with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category wishlist
	 * @return the category wishlist
	 * @throws com.liferay.portal.NoSuchModelException if a category wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryWishlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((CategoryWishlistPK)primaryKey);
	}

	/**
	 * Returns the category wishlist with the primary key or throws a {@link it.mal.projectaladdin.NoSuchCategoryWishlistException} if it could not be found.
	 *
	 * @param categoryWishlistPK the primary key of the category wishlist
	 * @return the category wishlist
	 * @throws it.mal.projectaladdin.NoSuchCategoryWishlistException if a category wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryWishlist findByPrimaryKey(
		CategoryWishlistPK categoryWishlistPK)
		throws NoSuchCategoryWishlistException, SystemException {
		CategoryWishlist categoryWishlist = fetchByPrimaryKey(categoryWishlistPK);

		if (categoryWishlist == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					categoryWishlistPK);
			}

			throw new NoSuchCategoryWishlistException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryWishlistPK);
		}

		return categoryWishlist;
	}

	/**
	 * Returns the category wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category wishlist
	 * @return the category wishlist, or <code>null</code> if a category wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryWishlist fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((CategoryWishlistPK)primaryKey);
	}

	/**
	 * Returns the category wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryWishlistPK the primary key of the category wishlist
	 * @return the category wishlist, or <code>null</code> if a category wishlist with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryWishlist fetchByPrimaryKey(
		CategoryWishlistPK categoryWishlistPK) throws SystemException {
		CategoryWishlist categoryWishlist = (CategoryWishlist)EntityCacheUtil.getResult(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
				CategoryWishlistImpl.class, categoryWishlistPK);

		if (categoryWishlist == _nullCategoryWishlist) {
			return null;
		}

		if (categoryWishlist == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				categoryWishlist = (CategoryWishlist)session.get(CategoryWishlistImpl.class,
						categoryWishlistPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (categoryWishlist != null) {
					cacheResult(categoryWishlist);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CategoryWishlistModelImpl.ENTITY_CACHE_ENABLED,
						CategoryWishlistImpl.class, categoryWishlistPK,
						_nullCategoryWishlist);
				}

				closeSession(session);
			}
		}

		return categoryWishlist;
	}

	/**
	 * Returns all the category wishlists.
	 *
	 * @return the category wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryWishlist> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CategoryWishlist> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the category wishlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category wishlists
	 * @param end the upper bound of the range of category wishlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryWishlist> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CategoryWishlist> list = (List<CategoryWishlist>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORYWISHLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYWISHLIST;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CategoryWishlist>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CategoryWishlist>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the category wishlists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CategoryWishlist categoryWishlist : findAll()) {
			remove(categoryWishlist);
		}
	}

	/**
	 * Returns the number of category wishlists.
	 *
	 * @return the number of category wishlists
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORYWISHLIST);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the category wishlist persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.mal.projectaladdin.model.CategoryWishlist")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CategoryWishlist>> listenersList = new ArrayList<ModelListener<CategoryWishlist>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CategoryWishlist>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CategoryWishlistImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = CategoryWishlistPersistence.class)
	protected CategoryWishlistPersistence categoryWishlistPersistence;
	@BeanReference(type = WishPersistence.class)
	protected WishPersistence wishPersistence;
	@BeanReference(type = WishlistPersistence.class)
	protected WishlistPersistence wishlistPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CATEGORYWISHLIST = "SELECT categoryWishlist FROM CategoryWishlist categoryWishlist";
	private static final String _SQL_COUNT_CATEGORYWISHLIST = "SELECT COUNT(categoryWishlist) FROM CategoryWishlist categoryWishlist";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryWishlist.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoryWishlist exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoryWishlistPersistenceImpl.class);
	private static CategoryWishlist _nullCategoryWishlist = new CategoryWishlistImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CategoryWishlist> toCacheModel() {
				return _nullCategoryWishlistCacheModel;
			}
		};

	private static CacheModel<CategoryWishlist> _nullCategoryWishlistCacheModel = new CacheModel<CategoryWishlist>() {
			public CategoryWishlist toEntityModel() {
				return _nullCategoryWishlist;
			}
		};
}