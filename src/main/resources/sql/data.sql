USE jdbctemplate;

INSERT INTO role (name) VALUES
  ('ADMIN'),
  ('MODERATOR'),
  ('SELLER'),
  ('CUSTOMER');

INSERT INTO user (login, password) VALUES
/* Sellers */
  ('odin_ogame@ukr.net',    'arlekin'),
  ('mail4quest@mail.ru',    'quest'),
  ('vasapupkin@gmail.com',  'pupkin'),
  ('vasahopnik@rambler.ru', 'dver88'),
  ('dota2@gmail.com',       'noob23'),
  ('olgamoros@ukr.net',     'ole4ka'),
  ('sanja_ivanow@ukr.net',  '123qwerty'),
  ('kolja234@qmail.com',    'vasa567'),
  ('GUSbYa@gmail.com',      'maideniron987'),
  ('romawar@gmail.com',     'deuslovult'),

/* Customers */
  ('ramstein@ukr.net',      'duriechstsogut'),
  ('maidenFan@ukr.net',     'holysmoke'),
  ('TSRules@qmail.com',     'iwonarock'),
  ('tenderCustomer@gmail.com',   '1111'),
  ('egoManiac@qmail.com',   'iamtheking'),

/* Admin, moderators */
  ('TenderAdmin@gmail.com', 'thebestadmever'),
  ('modjunior@gmail.com',   'holysmoke'),
  ('modSenior@gmail.com',   'iwonarock'),
  ('modIntermid@gmail.com', 'iamtheking');

INSERT INTO user_role (user_id, role_id) VALUES
/* Sellers */
  (1,  3),
  (2,  3),
  (3,  3),
  (4,  3),
  (5,  3),
  (7,  3),
  (6,  3),
  (8,  3),
  (9,  3),
  (10, 3),

/* Customers */
  (11, 4),
  (12, 4),
  (13, 4),
  (14, 4),
  (15, 4),

/* Admin, moderators */
  (16, 1),
  (17, 2),
  (18, 2),
  (19, 2);