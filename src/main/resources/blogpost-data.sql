insert into blogpost (title, publication_date, url, category)
values ('blogpost.title.1', TO_DATE('12/02/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/02/12/hey-alexa-order-us-two-pizzas-please/', 'AI'),
       ('Machine learning on source code', TO_DATE('08/06/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/06/08/machine-learning-on-source-code/', 'AI'),
       ('Deep Instinct – Malware detection using deep learning', TO_DATE('02/11/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/11/02/deep-instinct-malware-detection-using-deep-learning/', 'AI'),
       ('Destructuring', TO_DATE('08/05/2019', 'DD/MM/YYYY'), 'https://www.continuum.be/2019/05/08/destructuring-javascript/', 'Frontend'),
       ('blogpost.title.5', TO_DATE('07/12/2019', 'DD/MM/YYYY'), 'https://medium.com/@dieterjordens/fantastic-translations-and-where-to-find-them-421ee46f59db?source=friends_link&sk=7ddb4e05714d19bcf4671fbc0856fdd1', 'Frontend')
;
insert into translated_value (language, key, value)
values ('en', 'blogpost.title.1', 'Hey Alexa! Order us two pizzas please.'),
       ('nl', 'blogpost.title.1', 'Hey Alexa! Bestel ons twee pizza''s alstublieft.'),
       ('fr', 'blogpost.title.1', 'Hé Alexa! Commandez-nous deux pizzas s''il vous plaît.');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.5', 'Angular & Ngx-Translate: Fantastic Translations And Where To Find Them'),
       ('nl', 'blogpost.title.5', 'Angular & Ngx-Translate: Fantastische Vertalingen En Waar U Ze Kunt Vinden'),
       ('fr', 'blogpost.title.5', 'Angular & Ngx-Translate: Traductions Fantastiques Et Où Les Trouver');
