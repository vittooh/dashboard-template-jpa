
create sequence hibernate_sequence start 1 increment 1;

create table if not exists sale (
   id int8 not null,
    create_date timestamp,
    update_at timestamp,
    amount_sale float8 not null,
    saled_at timestamp,
    sales_man_id int8,
    primary key (id)
);

create table if not exists salesman (
   id int8 not null,
    create_date timestamp,
    update_at timestamp,
    name varchar(255),
    primary key (id)
);

alter table sale 
   add constraint FKouus74axcii7ygib3c8i76hou 
   foreign key (sales_man_id) 
   references salesman;