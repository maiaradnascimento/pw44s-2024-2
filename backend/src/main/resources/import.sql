insert into category_tb (name) values ('Informática');
insert into category_tb (name) values ('UD');
insert into category_tb (name) values ('Cozinha');
insert into category_tb (name) values ('Móveis');
insert into category_tb (name) values ('Eletrônico');

insert into product_tb(name, description, price, category_id, img) values ('Refrigerador 429L','Refrigerador 429L Branco, duplex....',1990.0,2, 'https://a-static.mlcdn.com.br/800x560/geladeira-refrigerador-brastemp-frost-free-duplex-429l-inox-ative-brm50nr/magazineluiza/010066400/ba2f31022021a84a6a27492a0ab9dc0d.jpg');
insert into product_tb(name, description, price, category_id, img) values ('Notebook Azus 15.6','Notebook Azus 15.6 Core I7, 16Gb Ram...',2449.0,1, 'https://images.tcdn.com.br/img/img_prod/789576/notebook_15_6_celeron_asus_x515ma_br933ws_cinza_dm9t145008n_1673371_1_7dad25a48f325c1b215f52f2a0462a19.png');
insert into product_tb(name, description, price, category_id, img) values ('Monitor 27pol','Monitor Gamer 27pol 144Hz, 1ms',1129.99,1, 'https://img.terabyteshop.com.br/produto/g/monitor-gamer-superframe-precision-27-pol-curvo-full-hd-1ms-240hz-freesync-hdmidp-sfp2702g_154061.jpg');
insert into product_tb(name, description, price, category_id, img) values ('Kit Teclado e Mouse','Kit com teclado ABNT e mouse com 5 botões',199.0,1, 'https://cdn.shoppub.io/cdn-cgi/image/w=1000,h=1000,q=80,f=auto/oficinadosbits/media/uploads/produtos/foto/ohbawvew/file.png');
insert into product_tb(name, description, price, category_id, img) values ('Smartphone XYZ','Smatphone com tela de 9pol, 12GB....',9999.0,5, 'https://imgs.casasbahia.com.br/55066421/1g.jpg');
insert into product_tb(name, description, price, category_id, img) values ('TV LCD 75pol','TV LCD 75pol, 5 HDMI...',7555.0,5, 'https://images.epto.it/immagini/big/SAM/QE75Q70AATXZT_0.jpg');
insert into product_tb(name, description, price, category_id, img) values ('Fogão 6 Bocas','Fogão 6 Bocas em aço inox, ...', 799.99,3, 'https://venaxstore.com.br/venaxstore/23643/17340019188.jpg');
insert into product_tb(name, description, price, category_id, img) values ('Roteador Wi-Fi 5.4GhZ','Roteador Wi-Fi 5.4GhZ, 6 antenas...',1299.0,1, 'https://s2-techtudo.glbimg.com/9Sj8J_Jxq02QdKt7aDH0B6D1DgM=/0x0:695x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/z/X/uoMMdfTD6UI8zPNtdv6g/2015-07-31-dir-816l1.jpg');

INSERT INTO user_tb(display_name, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO user_tb(display_name, username, password) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');