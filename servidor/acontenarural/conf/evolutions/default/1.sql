# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table calendario_academico (
  id                            bigint not null,
  title                         varchar(255) not null,
  start                         varchar(255) not null,
  end                           varchar(255) not null,
  color                         varchar(255) not null,
  constraint pk_calendario_academico primary key (id)
);
create sequence calendario_academico_seq;

create table comentario (
  id                            bigint not null,
  publicacao_id                 bigint,
  usuario_id                    bigint not null,
  texto                         varchar(255) not null,
  data_criacao                  timestamp not null,
  data_modificacao              timestamp not null,
  constraint pk_comentario primary key (id)
);
create sequence comentario_seq;

create table publicacao (
  id                            bigint not null,
  usuario_id                    bigint not null,
  texto                         varchar(255) not null,
  data_criacao                  timestamp not null,
  data_modificacao              timestamp not null,
  constraint pk_publicacao primary key (id)
);
create sequence publicacao_seq;

create table reacao (
  id                            bigint not null,
  tipo                          integer not null,
  publicacao_id                 bigint not null,
  usuario_id                    bigint not null,
  data_criacao                  timestamp not null,
  data_modificacao              timestamp not null,
  constraint ck_reacao_tipo check (tipo in (0,1)),
  constraint pk_reacao primary key (id)
);
create sequence reacao_seq;

create table usuario (
  id                            bigint not null,
  ava_id                        integer not null,
  username                      varchar(255) not null,
  token                         varchar(255),
  nome                          varchar(255) not null,
  matricula                     varchar(255),
  imagem                        varchar(255),
  imagem_small                  varchar(255),
  cidade                        varchar(255),
  pais                          varchar(255),
  instituicao                   varchar(255),
  email                         varchar(255),
  departamento                  varchar(255),
  tempo_lembrete_ava            integer,
  data_criacao                  timestamp not null,
  data_modificacao              timestamp not null,
  constraint ck_usuario_tempo_lembrete_ava check (tempo_lembrete_ava in (0,1,2,3,4,5)),
  constraint pk_usuario primary key (id)
);
create sequence usuario_seq;

alter table comentario add constraint fk_comentario_publicacao_id foreign key (publicacao_id) references publicacao (id) on delete restrict on update restrict;
create index ix_comentario_publicacao_id on comentario (publicacao_id);

alter table comentario add constraint fk_comentario_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_comentario_usuario_id on comentario (usuario_id);

alter table publicacao add constraint fk_publicacao_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_publicacao_usuario_id on publicacao (usuario_id);

alter table reacao add constraint fk_reacao_publicacao_id foreign key (publicacao_id) references publicacao (id) on delete restrict on update restrict;
create index ix_reacao_publicacao_id on reacao (publicacao_id);

alter table reacao add constraint fk_reacao_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;
create index ix_reacao_usuario_id on reacao (usuario_id);


# --- !Downs

alter table comentario drop constraint if exists fk_comentario_publicacao_id;
drop index if exists ix_comentario_publicacao_id;

alter table comentario drop constraint if exists fk_comentario_usuario_id;
drop index if exists ix_comentario_usuario_id;

alter table publicacao drop constraint if exists fk_publicacao_usuario_id;
drop index if exists ix_publicacao_usuario_id;

alter table reacao drop constraint if exists fk_reacao_publicacao_id;
drop index if exists ix_reacao_publicacao_id;

alter table reacao drop constraint if exists fk_reacao_usuario_id;
drop index if exists ix_reacao_usuario_id;

drop table if exists calendario_academico;
drop sequence if exists calendario_academico_seq;

drop table if exists comentario;
drop sequence if exists comentario_seq;

drop table if exists publicacao;
drop sequence if exists publicacao_seq;

drop table if exists reacao;
drop sequence if exists reacao_seq;

drop table if exists usuario;
drop sequence if exists usuario_seq;

