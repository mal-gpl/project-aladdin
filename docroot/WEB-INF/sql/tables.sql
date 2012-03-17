create table ALD_Category (
	categoryId LONG not null primary key,
	name VARCHAR(75) null,
	author LONG,
	description VARCHAR(75) null,
	parentCategory LONG
);

create table ALD_CategoryWishlist (
	categoryId LONG not null,
	wishlistId LONG not null,
	primary key (categoryId, wishlistId)
);

create table ALD_Wish (
	wishId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	price DOUBLE,
	url VARCHAR(75) null,
	image VARCHAR(75) null,
	creationDate DATE null,
	modifiedDate DATE null
);

create table ALD_Wishlist (
	wishlistId LONG not null primary key,
	userId LONG,
	wishId LONG,
	rating INTEGER,
	comment_ VARCHAR(75) null
);