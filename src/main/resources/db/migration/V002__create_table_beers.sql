CREATE TABLE beers (
    id bigint GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created TIMESTAMP NOT NULL,
    modified TIMESTAMP,
    modifier_user varchar(255),
    valid BOOLEAN NOT NULL DEFAULT TRUE,

    name varchar(100),
    description varchar(255),
    type varchar(100),
    ibu int,
    abv float,
    id_manufacturer bigint NOT NULL,

    CONSTRAINT pk_beer PRIMARY KEY (id),
    CONSTRAINT fk_beer_manufacturer FOREIGN KEY (id_manufacturer) REFERENCES manufacturers (id)
);

CREATE UNIQUE INDEX uk_name_beer ON beers(name);