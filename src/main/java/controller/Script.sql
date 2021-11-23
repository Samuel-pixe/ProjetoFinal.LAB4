create table tb_disciplina(
  	id SERIAL,
	nome_materia varchar(255),
 	carga_horaria varchar(100),
	constraint pk_disciplina_id primary key (id)
);
create table tb_curso(
  	id SERIAL,
	nome_curso varchar(100),
 	duracao_curso varchar(50),
	nota_curso varchar(50),
	constraint pk_curso_id primary key (id)
);
create table tb_aluno(
  	cod SERIAL,
	id_curso integer,
	nome varchar(255),
	email varchar(255),
	endereco varchar(255),
	cidade varchar(255),
	telefone varchar(100),
	uf varchar(5),
	semestre varchar(100),
	constraint pk_aluno_id primary key (cod),
	constraint fk_curso_id foreign key (id_curso) references tb_curso(id)
);
