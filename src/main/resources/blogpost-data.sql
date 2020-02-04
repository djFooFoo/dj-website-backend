insert into blogpost (title, publication_date, url, category)
values ('blogpost.title.1', TO_DATE('12/02/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/02/12/hey-alexa-order-us-two-pizzas-please/', 'AI'),
       ('Machine learning on source code', TO_DATE('08/06/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/06/08/machine-learning-on-source-code/', 'AI'),
       ('Deep Instinct – Malware detection using deep learning', TO_DATE('02/11/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/11/02/deep-instinct-malware-detection-using-deep-learning/', 'AI'),
       ('Destructuring', TO_DATE('08/05/2019', 'DD/MM/YYYY'), 'https://www.continuum.be/2019/05/08/destructuring-javascript/', 'Frontend'),
       ('blogpost.title.5', TO_DATE('07/12/2019', 'DD/MM/YYYY'), 'https://medium.com/@dieterjordens/fantastic-translations-and-where-to-find-them-421ee46f59db?source=friends_link&sk=7ddb4e05714d19bcf4671fbc0856fdd1', 'Frontend'),
       ('blogpost.title.6', TO_DATE('09/01/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/how-to-create-a-websocket-in-python-b68d65dbd549?source=friends_link&sk=556dcc527edf1d277053396332a270bd', 'Backend'),
       ('blogpost.title.7', TO_DATE('22/01/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/what-goes-into-a-dockerfile-ff0ace591060?source=friends_link&sk=6a4bdaf97cb6e7e76afe8fc733a1023f', 'Programming'),
       ('blogpost.title.8', TO_DATE('29/01/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/what-is-a-uuid-and-how-are-they-generated-17f0acbd7233?source=friends_link&sk=9a136dd22416eccab08ed346b556e6b2', 'Programming'),
       ('blogpost.title.9', TO_DATE('03/02/2020', 'DD/MM/YYYY'), 'https://towardsdatascience.com/top-5-ai-conferences-to-visit-in-europe-in-2020-7a6f068aff34?source=friends_link&sk=f74b76e9f6844de729e3e81cf84b57cc', 'AI')
;
insert into translated_value (language, key, value)
values ('en', 'blogpost.title.1', 'Hey Alexa! Order us two pizzas please.'),
       ('nl', 'blogpost.title.1', 'Hey Alexa! Bestel ons twee pizza''s alstublieft.'),
       ('fr', 'blogpost.title.1', 'Hé Alexa! Commandez-nous deux pizzas s''il vous plaît.');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.5', 'Angular & Ngx-Translate: Fantastic Translations And Where To Find Them'),
       ('nl', 'blogpost.title.5', 'Angular & Ngx-Translate: Fantastische Vertalingen En Waar U Ze Kunt Vinden'),
       ('fr', 'blogpost.title.5', 'Angular & Ngx-Translate: Traductions Fantastiques Et Où Les Trouver');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.6', 'How To Create a WebSocket in Python: An introduction to WebSockets'),
       ('nl', 'blogpost.title.6', 'Hoe maak je een WebSocket in Python: Een inleiding tot WebSockets'),
       ('fr', 'blogpost.title.6', 'Comment créer un WebSocket en Python : Une introduction aux WebSockets');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.7', 'What goes into a Dockerfile? Build a Dockerfile from the ground up, no experience necessary'),
       ('nl', 'blogpost.title.7', 'Wat gaat er in een Dockerfile? Leer hoe je een Dockerfile maakt, geen ervaring vereist.'),
       ('fr', 'blogpost.title.7', 'Que contient un Dockerfile? Construire un Dockerfile à partir de zéro, aucune expérience n''est nécessaire');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.8', 'What Is a UUID and How Are They Generated? A look at Universally Unique Identifiers'),
       ('nl', 'blogpost.title.8', 'Wat is een UUID en hoe worden ze gegenereerd? Een blik op Universally Unique Identifiers'),
       ('fr', 'blogpost.title.8', 'Qu''est-ce qu''une UUID et comment est-elle générée ? Un regard sur les identificateurs universels uniques');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.9', 'Top 5 AI Conferences To Visit in Europe in 2020. Machine and Deep Learning Conferences in Europe I think have the most interesting line-up this year.'),
       ('nl', 'blogpost.title.0', 'Top 5 AI-conferenties te bezoeken in Europa in 2020. Deze machine en Deep Learning Conferenties in Europa hebben volgens mij de meest interessante line-up dit jaar.'),
       ('fr', 'blogpost.title.9', 'Les 5 plus grandes conférences sur l''IA à visiter en Europe en 2020. Les conférences sur la machine et l''apprentissage profond en Europe sont, à mon avis, les plus intéressantes cette année.');
