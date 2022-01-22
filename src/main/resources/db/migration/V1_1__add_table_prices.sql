
CREATE TABLE prices
(
    priceId   int(10) NOT NULL AUTO_INCREMENT,
    brandId   int(10),
    startDate timestamp,
    endDate   timestamp,
    priceList   int(10),
    productId   int(10),
    priority   int(10),
    price     double precision,
    curr      varchar(10)
);

insert into flyway.prices (priceId, brandId, startDate, endDate, priceList, productId, priority, price, curr) values (1, 1, PARSEDATETIME('2020-06-14-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 1, 35455, 0, 35.50, 'EUR');
insert into flyway.prices (priceId, brandId, startDate, endDate, priceList, productId, priority, price, curr) values (2, 1, PARSEDATETIME('2020-06-14-15.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-06-14-18.30.00','yyyy-MM-dd-HH.mm.ss'), 2, 35455, 1, 25.45, 'EUR');
insert into flyway.prices (priceId, brandId, startDate, endDate, priceList, productId, priority, price, curr) values (3, 1, PARSEDATETIME('2020-06-15-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-06-15-11.00.00','yyyy-MM-dd-HH.mm.ss'), 3, 35455, 1, 30.50, 'EUR');
insert into flyway.prices (priceId, brandId, startDate, endDate, priceList, productId, priority, price, curr) values (4, 1, PARSEDATETIME('2020-06-15-16.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2020-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 4, 35455, 1, 38.95, 'EUR');