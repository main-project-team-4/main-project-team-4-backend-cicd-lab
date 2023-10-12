insert into category_large (id, name) values (1, '여성의류');
insert into category_mid (id, name, parent) VALUES (1, '아우터', 1);
insert into category_mid (id, name, parent) VALUES (2, '상의', 1);
insert into category_mid (id, name, parent) VALUES (3, '하의', 1);
insert into category_mid (id, name, parent) VALUES (4, '원피스', 1);
insert into category_mid (id, name, parent) VALUES (5, '신발', 1);

insert into category_large (id, name) values (2, '남성의류');
insert into category_mid (id, name, parent) VALUES (6, '아우터', 2);
insert into category_mid (id, name, parent) VALUES (7, '상의', 2);
insert into category_mid (id, name, parent) VALUES (8, '하의', 2);
insert into category_mid (id, name, parent) VALUES (9, '신발', 2);

insert into category_large (id, name) values (3, '패션잡화');
insert into category_mid (id, name, parent) VALUES (10, '가방', 3);
insert into category_mid (id, name, parent) VALUES (11, '지갑', 3);
insert into category_mid (id, name, parent) VALUES (12, '시계', 3);
insert into category_mid (id, name, parent) VALUES (13, '모자', 3);
insert into category_mid (id, name, parent) VALUES (14, '안경/선글라스', 3);
insert into category_mid (id, name, parent) VALUES (15, '기타', 3);

insert into category_large (id, name) values (4, '쥬얼리');
insert into category_mid (id, name, parent) VALUES (16, '목걸이', 4);
insert into category_mid (id, name, parent) VALUES (17, '반지', 4);
insert into category_mid (id, name, parent) VALUES (18, '귀걸이/피어싱', 4);
insert into category_mid (id, name, parent) VALUES (19, '팔찌', 4);
insert into category_mid (id, name, parent) VALUES (20, '기타', 4);

insert into item (name, price, comment, category_mid_id) values ('jacket1', 10000, 'nice man shirt1', 1);
insert into item (name, price, comment, category_mid_id) values ('jacket2', 5000, 'nice man shirt2', 1);
insert into item (name, price, comment, category_mid_id) values ('jacket3', 5000, 'nice woman shirt3', 3);
insert into item (name, price, comment, category_mid_id) values ('jacket4', 10000, 'nice woman shirt4', 3);
insert into item (name, price, comment, category_mid_id) values ('jean1', 10000, 'nice man pants1', 2);
insert into item (name, price, comment, category_mid_id) values ('jean2', 5000, 'nice man pants2', 2);
insert into item (name, price, comment, category_mid_id) values ('jean3', 10000, 'nice woman pants3', 4);
insert into item (name, price, comment, category_mid_id) values ('jean4', 5000, 'nice woman pants4', 4);

insert into member (nickname, password, phone_num, username, image)
values ('mock nickname1', '$2a$10$sw8G4sVnrHzd2rpGQ1GeoulDn3TvSA2N0v6LGGxwc/nGgMxMHZ.QW', '010-1234-5678', 'test1', 'https://imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2023/9/04/JK_CO_FQEE6hn23090409342563.gif?v=202309231627'),
       ('mock nickname2', '$2a$10$sw8G4sVnrHzd2rpGQ1GeoulDn3TvSA2N0v6LGGxwc/nGgMxMHZ.QW', '010-1234-5678', 'test2', 'https://imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2023/9/04/JK_CO_FQEE6hn23090409342563.gif?v=202309231627'),
       ('mock nickname3', '$2a$10$sw8G4sVnrHzd2rpGQ1GeoulDn3TvSA2N0v6LGGxwc/nGgMxMHZ.QW', '010-1234-5678', 'test3', 'https://imgs.jobkorea.co.kr/img1/_whitebg/200X80/Co_Logo/Logo/2023/9/04/JK_CO_FQEE6hn23090409342563.gif?v=202309231627');

insert into member (nickname) values ('iksadnorth');
insert into member (nickname) values ('iksadsouth');
insert into member (nickname) values ('iksadeast');
insert into member (nickname) values ('iksadwest');

insert into shop (seller_id, intro, star_avg, name) values (1, 'intro', 0, 'name');
insert into shop (seller_id, intro, star_avg, name) values (2, 'intro', 0, 'name');
insert into shop (seller_id, intro, star_avg, name) values (3, 'intro', 0, 'name');
insert into shop (seller_id, intro, star_avg, name) values (4, 'intro', 0, 'name');

insert into follow (member_id, shop_id) values (1, 3);
insert into follow (member_id, shop_id) values (1, 4);
insert into follow (member_id, shop_id) values (2, 3);
insert into follow (member_id, shop_id) values (2, 4);
insert into follow (member_id, shop_id) values (3, 4);

insert into wish (item_id, member_id) values (1, 1);
insert into wish (item_id, member_id) values (2, 1);
insert into wish (item_id, member_id) values (3, 1);
insert into wish (item_id, member_id) values (4, 1);
insert into wish (item_id, member_id) values (1, 2);
insert into wish (item_id, member_id) values (3, 2);
insert into wish (item_id, member_id) values (5, 2);
insert into wish (item_id, member_id) values (7, 2);
insert into wish (item_id, member_id) values (6, 3);
insert into wish (item_id, member_id) values (7, 3);
insert into wish (item_id, member_id) values (8, 3);