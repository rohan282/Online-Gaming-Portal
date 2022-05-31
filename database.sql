CREATE TABLE player (
    player_id int NOT NULL,
    first_name varchar(10) ,
    last_name varchar(10),
address varchar(20),
postal_code varchar(10),
province varchar(10),
phone_number varchar(10),
    PRIMARY KEY (player_id)
);



CREATE TABLE game (
    game_id int NOT NULL,
    game_title varchar(10) ,
    PRIMARY KEY (game_id)
);
 

CREATE TABLE playerandgame (
    player_game_id int NOT NULL,
game_id int,
player_id int,
playing_date date,
score int,
    PRIMARY KEY (player_game_id)
);