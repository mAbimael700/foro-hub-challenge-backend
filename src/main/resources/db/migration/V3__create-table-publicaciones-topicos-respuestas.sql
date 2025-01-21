create table publicaciones(
    id bigint not null auto_increment,
    mensaje varchar(1000) not null,
    fecha_creacion datetime not null,
    id_autor bigint,
    primary key(id),
    constraint fk_publicaciones_usuario_id foreign key(id_autor) references usuarios(id)
);

create table topicos(
    id bigint not null,
    id_curso bigint not null,
    status varchar(50) not null,
    primary key(id),
    constraint fk_topicos_publicacion_id foreign key(id) references publicaciones(id),
    constraint fk_topicos_curso_id foreign key(id_curso) references cursos(id)
);

create table respuestas(
    id bigint not null,
    id_topico bigint not null,
    solucion varchar(1000) not null,
    primary key(id),
    constraint fk_respuestas_publicacion_id foreign key(id) references publicaciones(id),
    constraint fk_respuestas_topico_id foreign key(id_topico) references topicos(id)
);
