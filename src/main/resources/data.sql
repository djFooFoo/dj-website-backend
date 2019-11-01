INSERT INTO book (isbn, title, authors, year_read)
VALUES (9781934356340, 'The Passionate Programmer: Creating a Remarkable Career in Software Development', 'Chad Fowler', 2019),
       (9781118957400, 'Oracle Certified Associate Java SE 8 Programmer I Study Guide', 'Jeanne Boyarsky and Scott Selikoff', 2016),
       (9781985170285, 'Ng-book: the complete book on Angular', 'Nathan Murray, Felipe Coury, Ari Lerner and Carlos Taborda', 2019),
       (9781119067900, 'Oracle Certified Professional Java SE 8 Programmer II Study Guide', 'Jeanne Boyarsky and Scott Selikoff', 2019),
       (9780137081073, 'The Clean Coder: A code of Conduct for Professional Programmers', 'Robert Cecil Martin', 2018),
       (9780134685991, 'Effective Java: A Programming Language Guide', 'Joshua Bloch', 2019),
       (9780132350884, 'Clean Code: A Handbook of Agile Software Craftsmanship', 'Robert Cecil Martin', 2019),
       (9780596007126, 'Head First Design Patterns: A Brain-Friendly Guide', 'Elisabeth Freeman and Kathy Sierra', 2016),
       (9781491925614, 'Fundamentals of Deep Learning', 'Nicholas Locascio and Nikhil Buduma', 2018),
       (9780321579362, 'Succeeding with Agile: Software Development Using Scrum', 'Mike Cohn', 2017),
       (9780982866917, 'The Elements of Scrum', 'Christopher A. Sims and Hillary Louise Johnson', 2016),
       (9781511317290, '7 Habits of highly effective people', 'Stephen Covey', 2018),
       (9780671027032, 'How to win friends and influence people', 'Dale Carnegie', 2018),
       (9781449344856, 'AngularJS', 'Brad Green and Shyam Seshadri', 2017),
       (9780980846904, 'HTML5 & CSS3 For The Real World', 'Alexis Goldstein, Estelle Weyl and Louis Lazaris', 2017),
       (9781935182023, 'JUnit in Action', 'Ted Husted and Vincent Massol', 2016),
       (9781783982509, 'Mastering Unit Testing Using Mockito, JUnit', 'Sujoy Acharya', 2016),
       (9781617291203, 'Spring in Action', 'Craig Walls', 2017),
       (9781617290459, 'Java Persistence with Hibernate', 'Cornelis Bauer and Gavin King', 2017);

insert into translated_value (language, key, value)
values ('nl', '7 Habits of highly effective people', 'De zeven eigenschappen van effectief leiderschap'),
       ('fr', '7 Habits of highly effective people', 'Les 7 habitudes de ceux qui réalisent tout ce qu''ils entreprennent'),
       ('nl', 'The Passionate Programmer: Creating a Remarkable Career in Software Development', 'The Passionate Programmer: Het creëren van een opmerkelijke carrière in software-ontwikkeling'),
       ('fr', 'The Passionate Programmer: Creating a Remarkable Career in Software Development', 'The Passionate Programmer : Créer une carrière remarquable dans le développement de logiciels'),
       ('nl', 'Oracle Certified Associate Java SE 8 Programmer I Study Guide', 'Oracle Certified Associate Java SE 8 Programmer I Studiegids'),
       ('fr', 'Oracle Certified Associate Java SE 8 Programmer I Study Guide', 'Oracle Certified Associate Java SE 8 Programmer I Guide d''étude'),
       ('nl', 'Ng-book: the complete book on Angular', 'Ng-book: het complete boek over Angular'),
       ('fr', 'Ng-book: the complete book on Angular', 'Ng-book: le livre complet sur Angular'),
       ('nl', 'Oracle Certified Professional Java SE 8 Programmer II Study Guide', 'Oracle Certified Professional Java SE 8 Programmer II Studiegids'),
       ('fr', 'Oracle Certified Professional Java SE 8 Programmer II Study Guide', 'Oracle Certified Professional Java SE 8 Programmer II Guide d''étude'),
       ('nl', 'The Clean Coder: A code of Conduct for Professional Programmers', 'The Clean Coder: Een gedragscode voor Professionele Programmeurs'),
       ('fr', 'The Clean Coder: A code of Conduct for Professional Programmers', 'The Clean Coder: Un code de conduite pour les Programmeurs Professionnels'),
       ('nl', 'Effective Java: A Programming Language Guide', 'Effective Java: Een programmeertaalgids'),
       ('fr', 'Effective Java: A Programming Language Guide', 'Effective Java: Guide du langage de programmatione'),
       ('nl', 'Clean Code: A Handbook of Agile Software Craftsmanship', 'Clean Code: Een Handboek van Agile Software Vakmanschap'),
       ('fr', 'Clean Code: A Handbook of Agile Software Craftsmanship', 'Clean Code: Un manuel d''Agile Software Craftsmanship'),
       ('nl', 'Head First Design Patterns: A Brain-Friendly Guide', 'Head First Design Patterns: Een hersenvriendelijke gids'),
       ('fr', 'Head First Design Patterns: A Brain-Friendly Guide', 'Head First Design Patterns: Un guide convivial pour le cerveau'),
       ('nl', 'Succeeding with Agile: Software Development Using Scrum', 'Succeeding with Agile: Softwareontwikkeling met behulp van Scrum'),
       ('fr', 'Succeeding with Agile: Software Development Using Scrum', 'Succeeding with Agile: Développement de logiciels à l''aide de Scrum'),
       ('nl', 'How to win friends and influence people', 'Hoe je vrienden maakt en mensen beïnvloedt'),
       ('fr', 'How to win friends and influence people', 'Comment se faire des amis et influencer les autres')
;

insert into translated_value (language, key, value)
values ('nl', 'Jeanne Boyarsky and Scott Selikoff', 'Jeanne Boyarsky en Scott Selikoff'),
       ('fr', 'Jeanne Boyarsky and Scott Selikoff', 'Jeanne Boyarsky et Scott Selikoff'),
       ('nl', 'Nathan Murray, Felipe Coury, Ari Lerner and Carlos Taborda', 'Nathan Murray, Felipe Coury, Ari Lerner en Carlos Taborda'),
       ('fr', 'Nathan Murray, Felipe Coury, Ari Lerner and Carlos Taborda', 'Nathan Murray, Felipe Coury, Ari Lerner et Carlos Taborda'),
       ('nl', 'Elisabeth Freeman and Kathy Sierra', 'Elisabeth Freeman en Kathy Sierra'),
       ('fr', 'Elisabeth Freeman and Kathy Sierra', 'Elisabeth Freeman et Kathy Sierra'),
       ('nl', 'Nicholas Locascio and Nikhil Buduma', 'Nicholas Locascio en Nikhil Buduma'),
       ('fr', 'Nicholas Locascio and Nikhil Buduma', 'Nicholas Locascio et Nikhil Buduma'),
       ('nl', 'Christopher A. Sims and Hillary Louise Johnson', 'Christopher A. Sims en Hillary Louise Johnson'),
       ('fr', 'Christopher A. Sims and Hillary Louise Johnson', 'Christopher A. Sims et Hillary Louise Johnson'),
       ('nl', 'Brad Green and Shyam Seshadri', 'Brad Green en Shyam Seshadri'),
       ('fr', 'Brad Green and Shyam Seshadri', 'Brad Green et Shyam Seshadri'),
       ('nl', 'Alexis Goldstein, Estelle Weyl and Louis Lazaris', 'Alexis Goldstein, Estelle Weyl en Louis Lazaris'),
       ('fr', 'Alexis Goldstein, Estelle Weyl and Louis Lazaris', 'Alexis Goldstein, Estelle Weyl et Louis Lazaris'),
       ('nl', 'Ted Husted and Vincent Massol', 'Ted Husted en Vincent Massol'),
       ('fr', 'Ted Husted and Vincent Massol', 'Ted Husted et Vincent Massol'),
       ('nl', 'Cornelis Bauer and Gavin King', 'Cornelis Bauer en Gavin King'),
       ('fr', 'Cornelis Bauer and Gavin King', 'Cornelis Bauer et Gavin King')
;
