insert into blogpost (title, publication_date, url, category)
values ('blogpost.title.1', TO_DATE('12/02/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/02/12/hey-alexa-order-us-two-pizzas-please/', 'AI'),
       ('Machine learning on source code', TO_DATE('08/06/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/06/08/machine-learning-on-source-code/', 'AI'),
       ('Deep Instinct – Malware detection using deep learning', TO_DATE('02/11/2018', 'DD/MM/YYYY'), 'https://www.continuum.be/2018/11/02/deep-instinct-malware-detection-using-deep-learning/', 'AI'),
       ('Destructuring', TO_DATE('08/05/2019', 'DD/MM/YYYY'), 'https://www.continuum.be/2019/05/08/destructuring-javascript/', 'Frontend'),
       ('blogpost.title.5', TO_DATE('07/12/2019', 'DD/MM/YYYY'), 'https://medium.com/better-programming/fantastic-translations-and-where-to-find-them-421ee46f59db?source=friends_link&sk=7ddb4e05714d19bcf4671fbc0856fdd1', 'Frontend'),
       ('blogpost.title.6', TO_DATE('09/01/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/how-to-create-a-websocket-in-python-b68d65dbd549?source=friends_link&sk=556dcc527edf1d277053396332a270bd', 'Backend'),
       ('blogpost.title.7', TO_DATE('22/01/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/what-goes-into-a-dockerfile-ff0ace591060?source=friends_link&sk=6a4bdaf97cb6e7e76afe8fc733a1023f', 'Programming'),
       ('blogpost.title.8', TO_DATE('29/01/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/what-is-a-uuid-and-how-are-they-generated-17f0acbd7233?source=friends_link&sk=9a136dd22416eccab08ed346b556e6b2', 'Programming'),
       ('blogpost.title.9', TO_DATE('03/02/2020', 'DD/MM/YYYY'), 'https://towardsdatascience.com/top-5-ai-conferences-to-visit-in-europe-in-2020-7a6f068aff34?source=friends_link&sk=f74b76e9f6844de729e3e81cf84b57cc', 'AI'),
       ('blogpost.title.10', TO_DATE('08/02/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/how-to-create-an-angular-dockerfile-75c059e7f8e8?source=friends_link&sk=363c8b21aafe83e1e5f84feed047e969', 'Frontend'),
       ('blogpost.title.11', TO_DATE('21/02/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/what-is-modularity-in-java-b1938a2304fd?source=friends_link&sk=202d13eb91c66a8fbec5580290b89c45', 'Backend'),
       ('blogpost.title.12', TO_DATE('10/03/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/how-does-docker-port-binding-work-b089f23ca4c8?source=friends_link&sk=40c9fbcdc4172bb065711ab554e9b1c2', 'Programming'),
       ('blogpost.title.13', TO_DATE('22/03/2020', 'DD/MM/YYYY'), 'https://towardsdatascience.com/increase-your-face-recognition-models-accuracy-by-improving-face-contrast-a3e71bb6b9fb?source=friends_link&sk=a51fd37b38a9f9770fc424208c93a6a2', 'AI'),
       ('blogpost.title.14', TO_DATE('31/03/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/test-driven-development-attempt-with-jest-and-angular-7e064b76ca2d?source=friends_link&sk=02e853220ce751e054222a67377ac804', 'Frontend'),
       ('blogpost.title.15', TO_DATE('20/04/2020', 'DD/MM/YYYY'), 'https://medium.com/better-programming/how-to-review-code-in-7-steps-98298003b7ec?source=friends_link&sk=648395f0913696002a267ee4f648a3c6', 'Programming'),
       ('blogpost.title.16', TO_DATE('23/04/2020', 'DD/MM/YYYY'), 'https://medium.com/@dieterjordens/decouple-tests-with-data-attributes-c920606c5f27?source=friends_link&sk=26885722b8f4f1896a157e2fb5fd060d', 'Frontend')
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
       ('nl', 'blogpost.title.9', 'Top 5 AI-conferenties te bezoeken in Europa in 2020. Deze machine en Deep Learning Conferenties in Europa hebben volgens mij de meest interessante line-up dit jaar.'),
       ('fr', 'blogpost.title.9', 'Les 5 plus grandes conférences sur l''IA à visiter en Europe en 2020. Les conférences sur la machine et l''apprentissage profond en Europe sont, à mon avis, les plus intéressantes cette année.');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.10', 'How to Create an Angular Dockerfile? A step-by-step guide to create an Angular container'),
       ('nl', 'blogpost.title.10', 'Hoe maak je een Angular Dockerfile aan? Een stap-voor-stap handleiding voor het maken van een Angular container.'),
       ('fr', 'blogpost.title.10', 'Comment créer un fichier de docker pour Angular? Un guide étape par étape pour créer un conteneur d''Angular');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.11', 'What Is Modularity in Java? A feature introduced since Java 9'),
       ('nl', 'blogpost.title.11', 'Wat betekenen modules in Java? Een feature die in Java 9 werd geïntroduceerd...'),
       ('fr', 'blogpost.title.11', 'Qu''est-ce que la modularité à Java ? Une caractéristique introduite depuis Java 9');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.12', 'How Does Docker Port Binding Work? Nail this common Docker interview question'),
       ('nl', 'blogpost.title.12', 'Hoe werkt Docker Port Binding? Beantwoordt deze gemeenschappelijke Docker interview vraag zonder moeite'),
       ('fr', 'blogpost.title.12', 'Comment fonctionne Docker Port Binding? Répondez à cette question courante de l''interview de Docker');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.13', 'Increase Your Face Recognition Model’s Accuracy by Improving Face Contrast. Pre-processing images for better results'),
       ('nl', 'blogpost.title.13', 'Verhoog de nauwkeurigheid van uw gezichtsherkenningsmodel door het gezichtscontrast te verbeteren. Beelden voorbewerken voor betere resultaten'),
       ('fr', 'blogpost.title.13', 'Augmentez la précision de votre modèle de reconnaissance faciale en améliorant le contraste des visages. Prétraitement des images pour de meilleurs résultats');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.14', 'Test-Driven Development Attempt With Jest and Angular'),
       ('nl', 'blogpost.title.14', 'Test-Driven Development Poging Met Jest en Angular'),
       ('fr', 'blogpost.title.14', 'Tentative de développement piloté par les tests avec Jest et Angular');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.15', 'How to Review Code in 7 Steps: What the ideal code review process looks like'),
       ('nl', 'blogpost.title.15', 'Hoe review je code in 7 stappen: Hoe ziet het ideale proces voor het beoordelen van code eruit?'),
       ('fr', 'blogpost.title.15', 'Comment réviser le code en 7 étapes : À quoi ressemble le processus idéal de révision d''un code');

insert into translated_value (language, key, value)
values ('en', 'blogpost.title.16', 'Decouple Tests With Data Attributes'),
       ('nl', 'blogpost.title.16', 'Tests ontkoppelen met data attributen'),
       ('fr', 'blogpost.title.16', 'Découplez vos tests avec des attributs de données');
