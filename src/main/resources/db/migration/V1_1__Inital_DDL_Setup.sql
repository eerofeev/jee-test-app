SET search_path = "courses";

create sequence sequence_person start 5;
alter sequence sequence_person owner to courses;

create sequence sequence_course start 3;
alter sequence sequence_course owner to courses;

create table person
(
    id bigint not null
        constraint person_pkey
            primary key,
    firstname varchar(255) not null,
    lastname varchar(255) not null
);
alter table person owner to courses;

create table course
(
    id bigint not null
        constraint course_pkey
            primary key,
    name varchar(255) not null,
    start date,
    duration int,
    teacher_id bigint not null
        constraint fk82lpl5bcnvcd5dm2suwud8n16
            references person
);
alter table course owner to courses;

create table course_participation
(
    course_id bigint not null
        constraint fkrf7xc25ll1t2n73y5qs9u4h0y
            references course,
    person_id bigint not null
        constraint fkcssv5b3wsb6dmu5gyyrgpvpv2
            references person,
    constraint course_participation_pkey
        primary key (course_id, person_id)
);
alter table course_participation owner to courses;

