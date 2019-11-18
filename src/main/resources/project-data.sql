insert into project (id, icon, client, job_title, job_description, time_span)
values (3,
        'fa-file',
        'fod.justice',
        'Full-Stack Developer',
        'fod.justice.description',
        'fod.justice.time.span'),
       (2, 'fa-tree',
        'Ravago',
        'Java Developer',
        'ravago.description',
        'ravago.time.span'),
       (1, 'fa-headphones',
        'Bose',
        'Java Developer',
        'bose.description',
        'bose.time.span');

insert into technology (name, project_id)
values ('Java 8', 1),
       ('Javascript', 1),
       ('SCSS', 1),
       ('Groovy', 1),
       ('HTML5', 1),
       ('AEM', 1),
       ('Bamboo', 1),
       ('Mockito', 1),
       ('PowerMock', 1),
       ('Hybris', 1),
       ('Spring', 1),
       ('Intellij', 1),
       ('Scrum/Agile', 1);

insert into technology (name, project_id)
values ('Java 6', 2),
       ('Spring', 2),
       ('Selenium', 2),
       ('JBoss', 2),
       ('Mockito', 2),
       ('SQL', 2),
       ('Intellij', 2),
       ('Confluence', 2),
       ('Jira', 2),
       ('Git', 2),
       ('Bamboo', 2),
       ('JSP', 2),
       ('Scrum/Agile', 2),
       ('Jenkins', 2),
       ('Docker', 2);


/*insert into technology (name, project_id)
values ('Java 8', 3),
       ('Spring', 3),
       ('Angular 8', 3),
       ('Jasmine', 3),
       ('CouchDB', 3),
       ('Elastic', 3),
       ('Mockito', 3),
       ('JUnit', 3),
       ('REST Assured', 3),
       ('AssertJ', 3),
       ('Intellij', 3),
       ('Jira', 3),
       ('Git', 3),
       ('Jenkins', 3),
       ('Scrum/Agile', 3),
       ('Keycloak', 3),
       ('Docker', 3),
       ('Typescript', 3),
       ('Swagger', 3),
       ('Cypress', 3),
       ('Node', 3);*/

insert into translated_value (language, key, value)
values ('fr', 'fod.justice', 'Service Public Fédéral Justice'),
       ('nl', 'fod.justice', 'Federale Overheidsdienst Justitie'),
       ('en', 'fod.justice', 'Federal Public Service Justice');

insert into translated_value (language, key, value)
values ('nl', 'fod.justice.description', 'Uit respect voor de klant wordt hier momenteel niets over bekend gemaakt.'),
       ('fr', 'fod.justice.description', 'Par respect pour le client, rien n''est annoncé pour l''instant.'),
       ('en', 'fod.justice.description', 'Out of respect for the customer, nothing is being announced about this at the moment.'),
       ('nl', 'ravago.description',
        'Het ontwikkelen van een custom ERP tool die door alle bedrijven binnen de wereldwijde <a href="https://www.ravago.com/">Ravago</a> company group gebruikt wordt. De belangrijkste functies van dit systeem zijn het plaatsen van orders, het regelen van transport en het aanmaken van invoices. De grootste uitdaging vond ik hier in het refactoren van vaak oude code naar een performante nieuwe architectuur. Om de nieuwe ontwikkelingen te ondersteunen werd er naast de applicatie een end-to-end framework gebouwd. Naast mijn functies als agile developer voerde ik deploys uit naar UAT en hielp ik met de release coördinatie. Daarnaast was ik gedurende een periode plaatsvervangend scrum master.'),
       ('fr', 'ravago.description',
        'Le développement d''un outil ERP personnalisé qui est utilisé par toutes les sociétés du groupe mondial <a href="https://www.ravago.com/">Ravago</a>. Les principales fonctions de ce système sont la passation des commandes, l''organisation du transport et l''établissement des factures. Le plus grand défi que j''ai trouvé ici était le remaniement d''un code souvent ancien en une nouvelle architecture performante. Pour soutenir les nouveaux développements, un cadre E2E a été construit à côté de l''application. En plus de mes fonctions de développeur agile, j''ai effectué des déploiements en UAT et aidé à la coordination des versions. J''ai aussi été scrum master adjoint pendant un certain temps.'),
       ('en', 'ravago.description',
        'The development of a custom ERP tool that is used by all companies within the global <a href="https://www.ravago.com/">Ravago</a> company group. The main functions of this system are placing orders, arranging transport and creating invoices. The biggest challenge I found here was the refactoring of often old code to a performing new architecture. To support the new developments, an E2E framework was built next to the application. In addition to my functions as an agile developer, I carried out deploys to UAT and helped with the release coordination. I was also deputy Scrum Master for a period of time.'),
       ('nl', 'bose.description',
        'Het ontwikkelen van een wereldwijde website voor de bedrijven die klant zijn bij Bose. Via deze <a href="https://reseller.bose.com/en_us/landingpage.html">website</a> kunnen bedrijven bestellingen plaatsen, reparaties uitvoeren, Bose producten omruilen en zoveel meer. Het project startte in Genk en verhuisde later naar Maastricht, ik maakte deel uit van het agile developer team <a href="https://harrypotter.fandom.com/wiki/Alastor_Moody">Moody</a>.'),
       ('fr', 'bose.description',
        'Développement d''un site web mondial pour les entreprises clientes de Bose. Ce <a href="https://reseller.bose.com/en_us/landingpage.html">site web</a> permet aux entreprises de passer des commandes, d''effectuer des réparations, d''échanger des produits Bose et bien plus encore. Le projet a commencé à Genk et s''est ensuite déplacé à Maastricht, je faisais partie de l''équipe de développement agile <a href="https://harrypotter.fandom.com/wiki/Alastor_Moody">Moody</a>.'),
       ('en', 'bose.description',
        'Developing a global website for the companies that are customers of Bose. This <a href="https://reseller.bose.com/en_us/landingpage.html">website</a> allows companies to place orders, perform repairs, exchange Bose products and much more. The project started in Genk and later moved to Maastricht, I was part of the agile developer team <a href="https://harrypotter.fandom.com/wiki/Alastor_Moody">Moody</a>.');

insert into translated_value (language, key, value)
values ('nl', 'Full-Stack Developer', 'Full-Stack ontwikkelaar'),
       ('fr', 'Full-Stack Developer', 'Développeur de pile complète'),
       ('nl', 'Java Developer', 'Java ontwikkelaar'),
       ('fr', 'Java Developer', 'Développeur Java');

insert into translated_value (language, key, value)
values ('nl', 'fod.justice.time.span', 'September 2018 - heden'),
       ('en', 'fod.justice.time.span', 'September 2018 - present'),
       ('fr', 'fod.justice.time.span', 'Septembre 2018 à ce jour');

insert into translated_value (language, key, value)
values ('nl', 'ravago.time.span', 'Mei 2017 - Augustus 2018'),
       ('en', 'ravago.time.span', 'May 2017 - August 2018'),
       ('fr', 'ravago.time.span', 'Mai 2017 - Août 2018');

insert into translated_value (language, key, value)
values ('nl', 'bose.time.span', 'Oktober 2016 - Maart 2017'),
       ('en', 'bose.time.span', 'October 2016 - March 2017'),
       ('fr', 'bose.time.span', 'Octobre 2016 - Mars 2017');

/*       ('nl', 'fod.justice.description', 'De ontwikkeling van een modern document management systeem dat binnen FOD justitie in gebruik genomen gaat worden. De hoofdfunctionaliteiten van deze service zijn het toelaten van het opslaan van eender welk type document, het annoteren/taggen van documenten, het plaatsen van reacties, het leggen van associaties en het geavanceerd zoeken op documenten, tags etc.'),
       ('fr', 'fod.justice.description', 'L''élaboration d''un système moderne de gestion des documents qui sera mis en œuvre au sein du SFP Justice. Les principales fonctionnalités de ce service sont de permettre le stockage de tout type de document, l''annotation/étiquetage de documents, le placement des réponses, la création d''associations et la recherche avancée sur les documents, tags, etc.'),
       ('en', 'fod.justice.description', 'The development of a modern document management system that will be put into use within the FPS Justice. The main functionalities of this service are to allow the storage of any type of document, the annotation/tagging of documents, the placement of comments, the creation of associations and the advanced search on documents, tags, etc.')*/
