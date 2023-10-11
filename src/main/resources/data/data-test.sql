insert into category_large (id, name) values (1, 'man');
insert into category_large (id, name) values (2, 'woman');

insert into category_mid (id, name, parent) VALUES (1, 'man shirt', 1);
insert into category_mid (id, name, parent) VALUES (2, 'man pants', 1);
insert into category_mid (id, name, parent) VALUES (3, 'woman shirt', 2);
insert into category_mid (id, name, parent) VALUES (4, 'woman pants', 2);

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