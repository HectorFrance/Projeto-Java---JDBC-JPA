create database loja;

use loja;

CREATE TABLE `acessorios` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `cod_fab` int(11) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
);


CREATE TABLE `computadores` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `HD` int(11) DEFAULT NULL,
  `RAM` int(11) DEFAULT NULL,
  `cod_fab` int(11) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ;


CREATE TABLE `consoles` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `cod_fab` int(11) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ;


CREATE TABLE `endereco` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
);


CREATE TABLE `fabricante` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
);
 
 
CREATE TABLE `funcionario` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `cod_end` int(11) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `setor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ;


CREATE TABLE `impressora` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `cod_fab` int(11) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ;


CREATE TABLE `pedido` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(255) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  `qaunt_p` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ;


CREATE TABLE `vendas` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `cod_Cliente` int(11) DEFAULT NULL,
  `cod_endereco` int(11) DEFAULT NULL,
  `cod_pedido` int(11) DEFAULT NULL,
  `cod_vendedor` int(11) DEFAULT NULL,
  `nome_Cliente` varchar(255) DEFAULT NULL,
  `nome_Vendedor` varchar(255) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  PRIMARY KEY (`cod`)
);

CREATE TABLE `cliente` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `cod_end` int(11) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ;

alter table acessorios add constraint fk_acessorios_fab foreign key (cod_fab) references fabricante (cod);
alter table computadores add constraint fk_computadores_fab foreign key (cod_fab) references fabricante (cod);
alter table consoles add constraint fk_console_fab foreign key (cod_fab) references fabricante (cod);
alter table funcionario add constraint fk_funcionario_end foreign key (cod_end) references endereco (cod);
alter table impressora add constraint fk_impressora_fab foreign key (cod_fab) references fabricante (cod);
alter table vendas add constraint fk_vendas_cliente foreign key (cod_Cliente) references cliente (cod);
alter table vendas add constraint fk_vendas_end foreign key (cod_endereco) references endereco (cod);
alter table vendas add constraint fk_vendas_pedido foreign key (cod_pedido) references pedido (cod);
alter table vendas add constraint fk_vendas_vendedor foreign key (cod_vendedor) references funcionario(cod);

insert into endereco( estado, cidade, bairro, rua, numero, complemento) values('Pernanbuco', 'Recife','Vasco', 'jesuania', '40', '');
insert into endereco( estado, cidade, bairro, rua, numero, complemento) values('Paraiba', 'Joãp pessoa','x1', 'x2', '30', 'casa');
insert into endereco( estado, cidade, bairro, rua, numero, complemento) values('Ri grande', 'Natal','y2', 'y1', '20', 'apartamento');

insert into fabricante(nome) values('Sony');
insert into fabricante(nome) values('mycrosoft');
insert into fabricante(nome) values('nitendo');
insert into fabricante(nome) values('Razer');
insert into fabricante(nome) values('Acer');

insert into acessorios(cod_fab, modelo, preco, tipo) values(4 ,'Cyclossa', 120.00 , 'teclado');

insert into computadores(HD,RAM,cod_fab,modelo,preco) values(500,4,2,'modelo x1',1000.00 );

insert into consoles(cod_fab,modelo,preco) values(1,'playstation 4',1200.00);

insert into impressora(cod_fab,modelo,preco,tipo) values(2,'xp-400',500,'jato de tinta');

insert into funcionario(cod_end,cpf,nome,telefone,setor) values(3,'111111','carlos','1111111','vedas');

insert into cliente(cod_end,cpf,nome,telefone) values(1,'2222222','robert','22222222');


