insert into users (username, password, enabled) values ('francis', '$2a$10$ZFJLAIAt3xKVs9B.Iepgy.Dwxcj9RKW3oKJWKR4JhX5DmhQRBvVma', true);

insert into authorities (username, authority) values ('francis', 'RSVP_ADMIN');
insert into authorities (username, authority) values ('francis', 'EVENT_PUBLISHER');
insert into authorities (username, authority) values ('francis', 'REGISTERED_USER');