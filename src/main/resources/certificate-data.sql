insert into certificate (name, issue_date, organization, credential_url, certificate_type)
values ('Oracle Certified Associate, Java SE 8 Programmer', TO_DATE('09/2016', 'MM/YYYY'), 'Oracle', 'https://www.youracclaim.com/badges/3ec8731f-0c1a-4075-bdf0-b6c8d5f0cbe3/linked_in_profile', 1),
       ('Professional Scrum Developer I', TO_DATE('04/2017', 'MM/YYYY'), 'Scrum.org', 'https://www.scrum.org/user/243806', 1),
       ('EXIN Agile Scrum Foundation', TO_DATE('09/2019', 'MM/YYYY'), 'Exin', 'https://exeed.pro/badge/43740', 1),
       ('deep.learning.specialization', TO_DATE('05/2019', 'MM/YYYY'), 'Coursera', 'https://www.coursera.org/account/accomplishments/specialization/SXJNRZSW2FNQ', 0),
       ('ai.for.everyone', TO_DATE('03/2019', 'MM/YYYY'), 'Coursera', 'https://www.coursera.org/account/accomplishments/verify/FL5WAVUSXLXE', 0),
       ('angular.challenge',  TO_DATE('05/2019', 'MM/YYYY'), 'NG-BE, Google, Innovatus, Showpad, EDITx', 'https://photos.google.com/share/AF1QipMGr_Fnj3VeEW0UJ7GJ_71Imb5zBI6m8JhO99nQPDmf_5mOqX9EtOi4rlBuEtU18Q?key=QXplbTItTExCZGhrd0FCNGMzc3Jwd05EVTJRYVlB', 2)
;

insert into translated_value (language, key, value)
values ('fr', 'deep.learning.specialization', 'Spécialisation de l''apprentissage profond'), ('nl', 'deep.learning.specialization', 'Deep Learning Specialisatie'), ('en', 'deep.learning.specialization', 'Deep Learning Specialization'),
       ('fr', 'ai.for.everyone', 'L''IA pour tous'), ('nl', 'ai.for.everyone', 'AI voor iedereen'), ('en', 'ai.for.everyone', 'AI For Everyone'),
       ('fr', 'angular.challenge', 'Finaliste d''Angular Challenge'), ('nl', 'angular.challenge', 'Angular Challenge Finalist'), ('en', 'angular.challenge', 'Angular Challenge Finalist');
