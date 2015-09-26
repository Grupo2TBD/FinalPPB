/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     08-07-2015 22:03:22                          */
/*==============================================================*/


drop table if exists ALBUM;

drop table if exists ALBUM_FOTOGRAFIA;

drop table if exists CAMARA;

drop table if exists COMENTARIO_ALBUM;

drop table if exists COMENTARIO_FOTOGRAFIA;

drop table if exists ETIQUETA_USUARIO;

drop table if exists EXIF;

drop table if exists FAVORITO_ALBUM;

drop table if exists FAVORITO_FOTOGRAFIA;

drop table if exists FOTOGRAFIA;

drop table if exists FOTOGRAFIA_TAG;

drop table if exists LOCALIZACION;

drop table if exists PERMISO_ALBUM;

drop table if exists PERMISO_FOTOGRAFIA;

drop table if exists PRIVACIDAD;

drop table if exists SEGUIDOR;

drop table if exists TAG;

drop table if exists TIPO_CLASIFICACION;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: ALBUM                                                 */
/*==============================================================*/
create table ALBUM
(
   ID_ALBUM             int not null,
   ID_USER              int not null,
   ID_PRIVACIDAD        int not null,
   ID_PERMISO_ALBUM     int,
   NOMBRE_ALBUM         varchar(20),
   FECHACREACION_ALBUM  datetime,
   DESCRIPCION_ALBUM    varchar(30),
   DIRECCION_FOTO_PORTADA_ALBUM varchar(50),
   CANTIDAD_FOTOGRAFIAS_ALBUM int,
   CANTIDAD_FAVORITOS   int,
   CANTIDAD_COMENTARIOS int,
   ULTIMA_ACTUALIZACION_ALBUM datetime,
   primary key (ID_ALBUM)
);

/*==============================================================*/
/* Table: ALBUM_FOTOGRAFIA                                      */
/*==============================================================*/
create table ALBUM_FOTOGRAFIA
(
   ID_ALBUM             int not null,
   ID_PHOTO             int not null,
   FECHA_AGREGADO_ALBUM datetime,
   primary key (ID_ALBUM, ID_PHOTO)
);

/*==============================================================*/
/* Table: CAMARA                                                */
/*==============================================================*/
create table CAMARA
(
   ID_CAMARA            int not null,
   MEGAPIXELES_CAMARA   int,
   ZOOM_CAMARA          int,
   TAMANO_PANTALLA_CAMARA int,
   TIPO_GUARDADO_CAMARA varchar(20),
   DIRECCION_IMAGEN_CAMARA varchar(50),
   NOMBRE_CAMARA        varchar(20),
   MARCA_CAMARA         varchar(20),
   PESO_CAMARA          int,
   CANTIDAD_FOTOGRAFIAS_CAMARA int,
   primary key (ID_CAMARA)
);

/*==============================================================*/
/* Table: COMENTARIO_ALBUM                                      */
/*==============================================================*/
create table COMENTARIO_ALBUM
(
   ID_COMENTARIO_ALBUM  int not null,
   ID_ALBUM             int not null,
   ID_USER              int not null,
   DESCRIPCION_COMENTARIO_ALBUM varchar(140),
   FECHA_PUBLICACION_COMENTARIO_ALBUM datetime,
   primary key (ID_COMENTARIO_ALBUM)
);

/*==============================================================*/
/* Table: COMENTARIO_FOTOGRAFIA                                 */
/*==============================================================*/
create table COMENTARIO_FOTOGRAFIA
(
   ID_COMENTARIO_PHOTO  int not null,
   ID_TIPO_CLASIFICACION int,
   ID_PHOTO             int not null,
   ID_USER              int not null,
   DESCRIPCION_COMENTARIO varchar(150),
   FECHA_PUBLICACION_COMENTARIO datetime,
   primary key (ID_COMENTARIO_PHOTO)
);

/*==============================================================*/
/* Table: ETIQUETA_USUARIO                                      */
/*==============================================================*/
create table ETIQUETA_USUARIO
(
   ID_USER              int not null,
   ID_PHOTO             int not null,
   primary key (ID_USER, ID_PHOTO)
);

/*==============================================================*/
/* Table: EXIF                                                  */
/*==============================================================*/
create table EXIF
(
   ID_PHOTO             int not null,
   ID_CAMARA            int not null,
   APERTURA_EXIF        varchar(20),
   LARGO_FOCO           int,
   FLASH_EXIF           bool,
   primary key (ID_PHOTO, ID_CAMARA)
);

/*==============================================================*/
/* Table: FAVORITO_ALBUM                                        */
/*==============================================================*/
create table FAVORITO_ALBUM
(
   ID_ALBUM             int not null,
   ID_USER              int not null,
   FECHA_FAVORITO_ALBUM datetime,
   primary key (ID_ALBUM, ID_USER)
);

/*==============================================================*/
/* Table: FAVORITO_FOTOGRAFIA                                   */
/*==============================================================*/
create table FAVORITO_FOTOGRAFIA
(
   ID_USER              int not null,
   ID_PHOTO             int not null,
   FECHA_FAVORITO       datetime,
   primary key (ID_USER, ID_PHOTO)
);

/*==============================================================*/
/* Table: FOTOGRAFIA                                            */
/*==============================================================*/
create table FOTOGRAFIA
(
   ID_PHOTO             int not null,
   ID_USER              int not null,
   ID_CAMARA            int not null,
   ID_LOCALIZACION      int,
   ID_PRIVACIDAD        int not null,
   ID_TIPO_CLASIFICACION int,
   ID_PERMISO_FOTOGRAFIA int,
   FECHA_SUBIDA_PHOTO   datetime,
   FECHA_TOMADA_PHOTO   datetime,
   CANTIDAD_VISITAS_PHOTO int,
   TITULO_PHOTO         varchar(20),
   DESCRIPCION_PHOTO    varchar(50),
   CANTIDAD_FAVORITOS_PHOTO int,
   FORMATO_PHOTO        varchar(20),
   DIRECCION_FISICA_PHOTO varchar(50),
   ULTIMA_ACTUALIZACION_PHOTO datetime,
   CANTIDAD_COMPARTIDOS int,
   CANTIDAD_DESCARGADAS int,
   CANTIDAD_COMENTARIOS_POSITIVOS int,
   CANTIDAD_COMENTARIOS_NEGATIVOS int,
   CANTIDAD_COMENTARIOS_NEUTROS int,
   primary key (ID_PHOTO)
);

/*==============================================================*/
/* Table: FOTOGRAFIA_TAG                                        */
/*==============================================================*/
create table FOTOGRAFIA_TAG
(
   ID_TAG               int not null,
   ID_PHOTO             int not null,
   primary key (ID_TAG, ID_PHOTO)
);

/*==============================================================*/
/* Table: LOCALIZACION                                          */
/*==============================================================*/
create table LOCALIZACION
(
   ID_LOCALIZACION      int not null,
   PUNTO_LOCALIZACION   char(255),
   primary key (ID_LOCALIZACION)
);

/*==============================================================*/
/* Table: PERMISO_ALBUM                                         */
/*==============================================================*/
create table PERMISO_ALBUM
(
   ID_PERMISO_ALBUM     int not null,
   CANSHAREALBUM        bool,
   CANFAVORITEALBUM     bool,
   CANCOMMENTALBUM      bool,
   primary key (ID_PERMISO_ALBUM)
);

/*==============================================================*/
/* Table: PERMISO_FOTOGRAFIA                                    */
/*==============================================================*/
create table PERMISO_FOTOGRAFIA
(
   ID_PERMISO_FOTOGRAFIA int not null,
   CANSHAREPHOTO        bool,
   CANCOMMENTPHOTO      bool,
   CANDOWNLOADPHOTO     bool,
   CANFAVORITEPHOTO     bool,
   primary key (ID_PERMISO_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: PRIVACIDAD                                            */
/*==============================================================*/
create table PRIVACIDAD
(
   ID_PRIVACIDAD        int not null,
   TIPO_PRIVACIDAD      varchar(20),
   primary key (ID_PRIVACIDAD)
);

/*==============================================================*/
/* Table: SEGUIDOR                                              */
/*==============================================================*/
create table SEGUIDOR
(
   ID_USER              int not null,
   USU_ID_USER          int not null,
   FECHA_FOLLOW         datetime,
   primary key (ID_USER, USU_ID_USER)
);

/*==============================================================*/
/* Table: TAG                                                   */
/*==============================================================*/
create table TAG
(
   ID_TAG               int not null,
   ID_USER              int not null,
   NOMBRE_TAG           varchar(20),
   primary key (ID_TAG)
);

/*==============================================================*/
/* Table: TIPO_CLASIFICACION                                    */
/*==============================================================*/
create table TIPO_CLASIFICACION
(
   ID_TIPO_CLASIFICACION int not null,
   TIPO_CLASIFICACION   varchar(20),
   primary key (ID_TIPO_CLASIFICACION)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   ID_USER              int not null,
   PASS_USER            varchar(20),
   FECHA_CREACION_CUENTA datetime,
   ALIAS_USER           varchar(20),
   NOMBRE_REAL_USER     varchar(20),
   DIRECCION_FOTO_PERFIL_USER varchar(50),
   APELLIDO_USER        varchar(20),
   SEXO_USER            varchar(8),
   DIRECCION_FOTO_PORTADA_USER varchar(50),
   FECHA_CUMPLEANOS_USER date,
   EMAIL_USER           varchar(30),
   FECHA_ULTIMA_ACTUALIZACION datetime,
   CANTIDAD_FOTOGRAFIAS_SUBIDAS int,
   CANTIDAD_ALBUMES_CREADOS int,
   CANTIDAD_SEGUIDORES  int,
   CANTIDAD_SEGUIDOS    int,
   UBICACION_USER       char(255),
   primary key (ID_USER)
);

alter table ALBUM add constraint FK_RELATIONSHIP_16 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table ALBUM add constraint FK_RELATIONSHIP_30 foreign key (ID_PERMISO_ALBUM)
      references PERMISO_ALBUM (ID_PERMISO_ALBUM) on delete restrict on update restrict;

alter table ALBUM add constraint FK_RELATIONSHIP_36 foreign key (ID_PRIVACIDAD)
      references PRIVACIDAD (ID_PRIVACIDAD) on delete restrict on update restrict;

alter table ALBUM_FOTOGRAFIA add constraint FK_RELATIONSHIP_17 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table ALBUM_FOTOGRAFIA add constraint FK_RELATIONSHIP_18 foreign key (ID_PHOTO)
      references FOTOGRAFIA (ID_PHOTO) on delete restrict on update restrict;

alter table COMENTARIO_ALBUM add constraint FK_RELATIONSHIP_34 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table COMENTARIO_ALBUM add constraint FK_RELATIONSHIP_35 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table COMENTARIO_FOTOGRAFIA add constraint FK_RELATIONSHIP_15 foreign key (ID_TIPO_CLASIFICACION)
      references TIPO_CLASIFICACION (ID_TIPO_CLASIFICACION) on delete restrict on update restrict;

alter table COMENTARIO_FOTOGRAFIA add constraint FK_RELATIONSHIP_40 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table COMENTARIO_FOTOGRAFIA add constraint FK_RELATIONSHIP_6 foreign key (ID_PHOTO)
      references FOTOGRAFIA (ID_PHOTO) on delete restrict on update restrict;

alter table ETIQUETA_USUARIO add constraint FK_RELATIONSHIP_2 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table ETIQUETA_USUARIO add constraint FK_RELATIONSHIP_3 foreign key (ID_PHOTO)
      references FOTOGRAFIA (ID_PHOTO) on delete restrict on update restrict;

alter table EXIF add constraint FK_RELATIONSHIP_41 foreign key (ID_PHOTO)
      references FOTOGRAFIA (ID_PHOTO) on delete restrict on update restrict;

alter table EXIF add constraint FK_RELATIONSHIP_42 foreign key (ID_CAMARA)
      references CAMARA (ID_CAMARA) on delete restrict on update restrict;

alter table FAVORITO_ALBUM add constraint FK_RELATIONSHIP_32 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table FAVORITO_ALBUM add constraint FK_RELATIONSHIP_33 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table FAVORITO_FOTOGRAFIA add constraint FK_RELATIONSHIP_13 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table FAVORITO_FOTOGRAFIA add constraint FK_RELATIONSHIP_14 foreign key (ID_PHOTO)
      references FOTOGRAFIA (ID_PHOTO) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_1 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_10 foreign key (ID_CAMARA)
      references CAMARA (ID_CAMARA) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_19 foreign key (ID_LOCALIZACION)
      references LOCALIZACION (ID_LOCALIZACION) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_23 foreign key (ID_PRIVACIDAD)
      references PRIVACIDAD (ID_PRIVACIDAD) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_29 foreign key (ID_PERMISO_FOTOGRAFIA)
      references PERMISO_FOTOGRAFIA (ID_PERMISO_FOTOGRAFIA) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_37 foreign key (ID_TIPO_CLASIFICACION)
      references TIPO_CLASIFICACION (ID_TIPO_CLASIFICACION) on delete restrict on update restrict;

alter table FOTOGRAFIA_TAG add constraint FK_RELATIONSHIP_4 foreign key (ID_PHOTO)
      references FOTOGRAFIA (ID_PHOTO) on delete restrict on update restrict;

alter table FOTOGRAFIA_TAG add constraint FK_RELATIONSHIP_5 foreign key (ID_TAG)
      references TAG (ID_TAG) on delete restrict on update restrict;

alter table SEGUIDOR add constraint FK_RELATIONSHIP_11 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table SEGUIDOR add constraint FK_RELATIONSHIP_12 foreign key (USU_ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

alter table TAG add constraint FK_RELATIONSHIP_31 foreign key (ID_USER)
      references USUARIO (ID_USER) on delete restrict on update restrict;

