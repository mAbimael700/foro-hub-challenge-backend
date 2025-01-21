create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(255) not null,
    correo_electronico   datetime not null,
    primary key(id)
);

create table perfiles(
    id bigint not null auto_increment,
    nombre varchar(255) not null,
    primary key(id)
);

create table usuarios_perfiles (
    id_perfil bigint not null,
    id_usuario bigint not null,

    CONSTRAINT fk_usuarios_perfiles_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id) ON DELETE CASCADE,
    CONSTRAINT fk_usuarios_perfiles_perfil FOREIGN KEY (id_perfil) REFERENCES perfiles (id) ON DELETE CASCADE
);