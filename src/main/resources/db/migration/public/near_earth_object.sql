create table near_earth_object
(
    id                    serial
        primary key,
    name                  varchar(30),
    kilo_diam_max         numeric(13, 10),
    kilo_diam_min         numeric(13, 10),
    feet_diam_max         numeric(17, 10),
    feet_diam_min         numeric(17, 10),
    is_hazard             boolean,
    close_approach_date   timestamp,
    kilometers_per_second numeric(13, 10),
    miles_per_hour        numeric(17, 10),
    kilo_miss_dist        numeric(20, 10),
    miles_miss_dist       numeric(20, 10),
    orbiting              varchar(31),
    is_sentry             boolean
);

comment on table near_earth_object is 'Near Earth objects.';

alter table near_earth_object
    owner to postgres;

