insert into blogpost (title, publication_date, url, category)
values ('blogpost.title.1', TO_DATE('12/02/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/02/12/hey-alexa-order-us-two-pizzas-please/', 'AI'),
       ('Machine learning on source code', TO_DATE('08/06/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/06/08/machine-learning-on-source-code/', 'AI'),
       ('Deep Instinct – Malware detection using deep learning', TO_DATE('02/11/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/11/02/deep-instinct-malware-detection-using-deep-learning/', 'AI'),
       ('Destructuring', TO_DATE('08/05/2019', 'DD/MM/YYYY'), 'https://www.continuum.be/2019/05/08/destructuring-javascript/', 'Frontend')
;
insert into translated_value (language, key, value)
values ('en', 'blogpost.title.1', 'Hey Alexa! Order us two pizzas please.'),
       ('nl', 'blogpost.title.1', 'Hey Alexa! Bestel ons twee pizza''s alstublieft.'),
       ('fr', 'blogpost.title.1', 'Hé Alexa! Commandez-nous deux pizzas s''il vous plaît.')
;

