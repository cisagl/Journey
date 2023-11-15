## SQL PRACTICES

### Practice 1:

```bash
# Task 1: Film tablosunda bulunan title ve description sütunlarındaki verileri sıralayınız.
SELECT title, description FROM film;

# Task 2: Film tablosunda bulunan tüm sütunlardaki verileri film uzunluğu (length) 60 dan büyük VE 75 ten küçük olma koşullarıyla sıralayınız.
SELECT * FROM film WHERE length > 60 AND length < 75;

# Task 3: Film tablosunda bulunan tüm sütunlardaki verileri rental_rate 0.99 VE replacement_cost 12.99 VEYA 28.99 olma koşullarıyla sıralayınız.
SELECT * FROM film WHERE rental_rate = 0.99 AND replacement_cost = 12.99 OR replacement_cost = 28.99;

# Task 4: Customer tablosunda bulunan first_name sütunundaki değeri 'Mary' olan müşterinin last_name sütunundaki değeri nedir?
SELECT first_name, last_name FROM customer WHERE first_name = 'Mary';

# Task 5: Film tablosundaki uzunluğu(length) 50'den büyük OLMAYIP aynı zamanda rental_rate değeri 2.99 veya 4.99 OLMAYAN verileri sıralayınız.
SELECT * FROM film WHERE length < 50 AND rental_rate != 2.99 OR rental_rate != 4.99;
```

### Practice 2:

```bash
# Task 1: Film tablosunda bulunan tüm sütunlardaki verileri replacement cost değeri 12.99 dan büyük eşit ve 16.99 küçük olma koşuluyla sıralayınız ( BETWEEN - AND yapısını kullanınız.)
SELECT * FROM film WHERE replacement_cost BETWEEN 12.99 AND 16.99;

# Task 2: Actor tablosunda bulunan first_name ve last_name sütunlardaki verileri first_name 'Penelope' veya 'Nick' veya 'Ed' değerleri olması koşuluyla sıralayınız. ( IN operatörünü kullanınız.)
SELECT first_name, last_name FROM actor WHERE first_name IN ('Penelope', 'Nick', 'Ed');

# Task 3: Film tablosunda bulunan tüm sütunlardaki verileri rental_rate 0.99, 2.99, 4.99 VE replacement_cost 12.99, 15.99, 28.99 olma koşullarıyla sıralayınız. ( IN operatörünü kullanınız.)
SELECT * FROM film WHERE rental_rate IN (0.99, 2.99, 4.99) AND replacement_cost IN (12.99, 15.99, 28.99);
```

### Practice 3:

```bash
# Task 1: Country tablosunda bulunan country sütunundaki ülke isimlerinden 'A' karakteri ile başlayıp 'a' karakteri ile sonlananları sıralayınız.
SELECT country FROM country WHERE country LIKE 'A%a';

# Task 2: Country tablosunda bulunan country sütunundaki ülke isimlerinden en az 6 karakterden oluşan ve sonu 'n' karakteri ile sonlananları sıralayınız.SELECT first_name, last_name FROM actor WHERE first_name IN ('Penelope', 'Nick', 'Ed');
SELECT country FROM country WHERE country LIKE '_____n';

# Task 3: Film tablosunda bulunan title sütunundaki film isimlerinden en az 4 adet büyük ya da küçük harf farketmesizin 'T' karakteri içeren film isimlerini sıralayınız.SELECT * FROM film WHERE rental_rate IN (0.99, 2.99, 4.99) AND replacement_cost IN (12.99, 15.99, 28.99);
SELECT title FROM film WHERE title ILIKE '%t%';

# Task 4: Film tablosunda bulunan tüm sütunlardaki verilerden title 'C' karakteri ile başlayan ve uzunluğu (length) 90 dan büyük olan ve rental_rate 2.99 olan verileri sıralayınız.
SELECT * FROM film WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;
```

### Practice 4:

```bash
# Task 1: Film tablosunda bulunan replacement_cost sütununda bulunan birbirinden farklı değerleri sıralayınız.
SELECT DISTINCT replacement_cost FROM film;

# Task 2: Film tablosunda bulunan replacement_cost sütununda birbirinden farklı kaç tane veri vardır?
SELECT COUNT(DISTINCT replacement_cost) FROM film;

# Task 3: Film tablosunda bulunan film isimlerinde (title) kaç tanesini T karakteri ile başlar ve aynı zamanda rating 'G' ye eşittir?
SELECT COUNT(*) FROM film WHERE title LIKE 'T%' AND rating = 'G';

# Task 4: Country tablosunda bulunan ülke isimlerinden (country) kaç tanesi 5 karakterden oluşmaktadır?
SELECT COUNT(country) FROM country WHERE country LIKE '_____';

# Task 5: City tablosundaki şehir isimlerinin kaç tanesi 'R' ile başlar veya 'r' karakteri ile biter?
SELECT COUNT(city) FROM city WHERE city ILIKE 'R%' OR city ILIKE '%r';
```

### Practice 5:

```bash
# Task 1: Film tablosunda bulunan ve film ismi (title) 'n' karakteri ile biten en uzun (length) 5 filmi sıralayınız.
SELECT * FROM film WHERE title LIKE '%n' ORDER BY length DESC LIMIT 5;

# Task 2: Film tablosunda bulunan ve film ismi (title) 'n' karakteri ile biten en kısa (length) ikinci(6,7,8,9,10) 5 filmi(6,7,8,9,10) sıralayınız.
SELECT * FROM film WHERE title LIKE '%n' ORDER BY length ASC OFFSET 5 LIMIT 5;

# Task 3: Customer tablosunda bulunan last_name sütununa göre azalan yapılan sıralamada store_id 1 olmak koşuluyla ilk 4 veriyi sıralayınız.SELECT COUNT(*) FROM film WHERE title LIKE 'T%' AND rating = 'G';
SELECT * FROM customer WHERE store_id = 1 ORDER BY last_name DESC LIMIT 4;
```

### Practice 6:

```bash
# Task 1: Film tablosunda bulunan rental_rate sütunundaki değerlerin ortalaması nedir?
SELECT AVG(rental_rate) FROM film;

# Task 2: Film tablosunda bulunan filmlerden kaç tanesi 'C' karakteri ile başlar?
SELECT COUNT(*) FROM film WHERE title LIKE 'C%';

# Task 3: Film tablosunda bulunan filmlerden rental_rate değeri 0.99 a eşit olan en uzun (length) film kaç dakikadır?
SELECT MAX(length) FROM film WHERE rental_rate = 0.99;

# Task 4: Film tablosunda bulunan filmlerin uzunluğu 150 dakikadan büyük olanlarına ait kaç farklı replacement_cost değeri vardır?
SELECT COUNT (DISTINCT replacement_cost) FROM film WHERE length > 150;
```

### Practice 7:

```bash
# Task 1: Film tablosunda bulunan filmleri rating değerlerine göre gruplayınız.
SELECT rating FROM film GROUP BY rating;

# Task 2: Film tablosunda bulunan filmleri replacement_cost sütununa göre grupladığımızda film sayısı 50 den fazla olan replacement_cost değerini ve karşılık gelen film sayısını sıralayınız.
SELECT replacement_cost, COUNT(*) FROM film GROUP BY replacement_cost HAVING COUNT(*) > 50;

# Task 3: Customer tablosunda bulunan store_id değerlerine karşılık gelen müşteri sayılarını nelerdir?
SELECT store_id, COUNT(*) FROM customer GROUP BY store_id;

# Task 4: City tablosunda bulunan şehir verilerini country_id sütununa göre gruplandırdıktan sonra en fazla şehir sayısı barındıran country_id bilgisini ve şehir sayısını paylaşınız.
SELECT country_id, COUNT(*) FROM city GROUP BY country_id ORDER BY COUNT (*) DESC LIMIT 1;;
```

### Practice 8:

```bash
# Task 1: Test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
CREATE TABLE empoyee(id SERIAL PRIMARY KEY, name VARCHAR(50), birthday DATE, email VARCHAR(100));

# Task 2: Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
insert into employee (id, name, birthday, email) values (1, 'Simeon Maycock', '1962-10-04', 'smaycock0@newsvine.com');
insert into employee (id, name, birthday, email) values (2, 'Madella Arderne', '1993-06-02', 'marderne1@icio.us');
insert into employee (id, name, birthday, email) values (3, 'Jillane Shafto', '1958-11-07', 'jshafto2@va.gov');
insert into employee (id, name, birthday, email) values (4, 'Tallie Snooks', '1986-07-20', 'tsnooks3@opera.com');
insert into employee (id, name, birthday, email) values (5, 'Jennine Drees', '1967-04-28', 'jdrees4@hubpages.com');
insert into employee (id, name, birthday, email) values (6, 'Dannye Lackie', '1985-09-24', 'dlackie5@apache.org');
insert into employee (id, name, birthday, email) values (7, 'Sara-ann Mantha', '1952-03-24', 'smantha6@trellian.com');
insert into employee (id, name, birthday, email) values (8, 'Chantalle Gavrielly', '1996-06-21', 'cgavrielly7@discovery.com');
insert into employee (id, name, birthday, email) values (9, 'Honoria Reynalds', '1979-12-19', 'hreynalds8@photobucket.com');
insert into employee (id, name, birthday, email) values (10, 'Frankie Rankmore', '2003-12-22', 'frankmore9@purevolume.com');
insert into employee (id, name, birthday, email) values (11, 'Bartlett Leates', '1957-06-10', 'bleatesa@businessinsider.com');
insert into employee (id, name, birthday, email) values (12, 'Gavrielle Stamps', '1973-11-16', 'gstampsb@technorati.com');
insert into employee (id, name, birthday, email) values (13, 'Aprilette Blyth', '1981-12-25', 'ablythc@apache.org');
insert into employee (id, name, birthday, email) values (14, 'Hale Matys', '1970-05-13', 'hmatysd@newyorker.com');
insert into employee (id, name, birthday, email) values (15, 'Carine Senett', '1958-09-29', 'csenette@discuz.net');
insert into employee (id, name, birthday, email) values (16, 'Duffy Tither', '1969-05-06', 'dtitherf@uiuc.edu');
insert into employee (id, name, birthday, email) values (17, 'Eddi Botterell', '1982-07-08', 'ebotterellg@state.gov');
insert into employee (id, name, birthday, email) values (18, 'Somerset Galbraith', '1957-05-16', 'sgalbraithh@accuweather.com');
insert into employee (id, name, birthday, email) values (19, 'Paten Roseburgh', '1997-09-12', 'proseburghi@uiuc.edu');
insert into employee (id, name, birthday, email) values (20, 'Manny Unitt', '1968-01-03', 'munittj@cyberchimps.com');
insert into employee (id, name, birthday, email) values (21, 'Sybil Fulkes', '2001-04-15', 'sfulkesk@com.com');
insert into employee (id, name, birthday, email) values (22, 'Cointon Le Batteur', '2004-05-19', 'clel@google.es');
insert into employee (id, name, birthday, email) values (23, 'Antonius Fretson', '2004-11-04', 'afretsonm@hatena.ne.jp');
insert into employee (id, name, birthday, email) values (24, 'Ruthe Golt', '1961-08-21', 'rgoltn@sakura.ne.jp');
insert into employee (id, name, birthday, email) values (25, 'Brinna Ebunoluwa', '1989-05-22', 'bebunoluwao@eventbrite.com');
insert into employee (id, name, birthday, email) values (26, 'Cassi Sapir', '1984-03-29', 'csapirp@wp.com');
insert into employee (id, name, birthday, email) values (27, 'Karly Windsor', '1990-09-25', 'kwindsorq@statcounter.com');
insert into employee (id, name, birthday, email) values (28, 'Phaidra Rosindill', '1980-06-02', 'prosindillr@un.org');
insert into employee (id, name, birthday, email) values (29, 'Shalom Simeonov', '1996-10-17', 'ssimeonovs@blinklist.com');
insert into employee (id, name, birthday, email) values (30, 'Alfi Closs', '2006-10-10', 'aclosst@friendfeed.com');
insert into employee (id, name, birthday, email) values (31, 'Shalne McKenzie', '1951-07-08', 'smckenzieu@qq.com');
insert into employee (id, name, birthday, email) values (32, 'Anabella Tosney', '1997-06-19', 'atosneyv@marketwatch.com');
insert into employee (id, name, birthday, email) values (33, 'Emilia Boards', '2009-03-21', 'eboardsw@histats.com');
insert into employee (id, name, birthday, email) values (34, 'Antone Cheesworth', '1994-07-25', 'acheesworthx@slideshare.net');
insert into employee (id, name, birthday, email) values (35, 'Doris MacShirrie', '1999-11-11', 'dmacshirriey@geocities.com');
insert into employee (id, name, birthday, email) values (36, 'Dru Oddboy', '2007-04-17', 'doddboyz@creativecommons.org');
insert into employee (id, name, birthday, email) values (37, 'Jaynell Popelay', '2010-06-26', 'jpopelay10@answers.com');
insert into employee (id, name, birthday, email) values (38, 'Luz Beazey', '1962-09-21', 'lbeazey11@hhs.gov');
insert into employee (id, name, birthday, email) values (39, 'Maurise Tant', '1976-04-07', 'mtant12@archive.org');
insert into employee (id, name, birthday, email) values (40, 'Konstantin MacAlroy', '1969-12-26', 'kmacalroy13@vkontakte.ru');
insert into employee (id, name, birthday, email) values (41, 'Gunther Quinane', '1989-11-25', 'gquinane14@drupal.org');
insert into employee (id, name, birthday, email) values (42, 'Jerrome Twamley', '1981-02-25', 'jtwamley15@sourceforge.net');
insert into employee (id, name, birthday, email) values (43, 'Celestine Keward', '1955-10-04', 'ckeward16@scribd.com');
insert into employee (id, name, birthday, email) values (44, 'Auberon Swyn', '1965-06-14', 'aswyn17@omniture.com');
insert into employee (id, name, birthday, email) values (45, 'Cybil Lacoste', '2007-05-22', 'clacoste18@quantcast.com');
insert into employee (id, name, birthday, email) values (46, 'Jacklin Feaver', '1966-05-19', 'jfeaver19@huffingtonpost.com');
insert into employee (id, name, birthday, email) values (47, 'Wolfie Vain', '1998-03-21', 'wvain1a@ning.com');
insert into employee (id, name, birthday, email) values (48, 'Prue Muschette', '2001-09-29', 'pmuschette1b@nydailynews.com');
insert into employee (id, name, birthday, email) values (49, 'Mikkel Brailey', '2008-10-05', 'mbrailey1c@smugmug.com');
insert into employee (id, name, birthday, email) values (50, 'Briant Toppas', '1993-07-09', 'btoppas1d@addthis.com');

# Task 3: Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
UPDATE employee SET birthday = '1999-9-9' WHERE name ILIKE 'l%';
UPDATE employee SET email = 'null' WHERE id % 2 = 0;
UPDATE employee SET email = 'PLEASE USE .COM' WHERE email NOT LIKE '%.com';
UPDATE employee SET name = 'None' WHERE name LIKE '%l';
UPDATE employee SET name = 'Patika' WHERE id = 2;

# Task 4: Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
DELETE FROM employee WHERE id = 3;
DELETE FROM employee WHERE id % 2 != 0;
DELETE FROM employee WHERE birthday < '1985-10-10';
DELETE FROM employee WHERE name ILIKE 'a%';
DELETE FROM employee WHERE email LIKE 'P%'

```