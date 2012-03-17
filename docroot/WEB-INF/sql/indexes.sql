create index IX_8C53BC29 on ALD_Category (author);
create index IX_1204F029 on ALD_Category (name);
create index IX_C798F326 on ALD_Category (parentCategory);

create index IX_1E0B2DD2 on ALD_Wish (name);
create index IX_572268F3 on ALD_Wish (price, price);

create index IX_4E8A7BC2 on ALD_Wishlist (rating);
create index IX_2533722B on ALD_Wishlist (userId);
create index IX_F63478FC on ALD_Wishlist (userId, rating);