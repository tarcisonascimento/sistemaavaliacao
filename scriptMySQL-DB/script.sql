create database dados;
use dados;

create table usuarios(
iduso int primary key auto_increment not null,
nome varchar(200) not null,
endereco varchar(200),
cidade varchar(100),
celular varchar(50) not null,
cref varchar(20),
datacontrato varchar(50) not null,
usuario varchar(50) not null,
senha varchar(50) not null,
perfil varchar(50),
cpf varchar(20)
);
insert into usuarios (nome,endereco,cidade,celular,cref,cpf,datacontrato,usuario,senha,perfil)
values ("Tarciso Nascimento Bezerra","Rua Presidente Prudente de Morais","Ariquemes/RO","(69) 9.9209-9315","1825-G/RO","983.284.252-20","01/05/2010","admin","admin","Administrador");

create table clientes(
idcli int primary key auto_increment not null,
clinome varchar(200) not null,
cliendereco varchar(200),
clicidade varchar(150),
clicelular varchar(50) not null,
clicpf varchar(30),
clidatanasc varchar(30) not null,
cliobjetvos varchar(600),
clidatacli timestamp default current_timestamp,
cliidade int (3) not null,
clisexo varchar(30) not null
);

create table empresa(
idempresa int primary key auto_increment not null,
empnomefantasia varchar (200) default 'Nome da Empresa',
emprazaosocial varchar (200) default 'Razão Social da Empresa',
empslogan varchar (200) default 'O melhor treinador do Brasil',
empcnpjcpf varchar (20) default '00.000.000/0000-00',
empinscricao varchar (20) default '00000',
empendereco varchar (200) default 'endereco nome da rua e nº',
empcidade varchar (100) default 'nome da cidade',
empestado varchar (2) default 'AC',
empcep varchar (15) default '00.000-000',
emptelefone varchar (14) default '(00)0000-0000',
empcelular varchar (16) default '(00)0.0000-0000',
empemail varchar (100) default 'exemplo@exemplo.com.br',
emplogo longblob,
empativado boolean default 0,
emphashdeativacao varchar (500)
);
insert into empresa (empnomefantasia) values ("Nome da Empresa");


create table avaliacao1 (
idava int(11) primary key auto_increment not null,
dataava timestamp default current_timestamp,
pd	varchar(5),
ps	varchar(5),
pdesf	varchar(5),
psesf	varchar(5),
fc	varchar(5),
fcesforco	varchar(5),
fcprotococloest	varchar(70),
debcard	varchar(7) default '00,00',
debcardproto	varchar(70),
vo2	varchar(7) default '00,00',
vs	varchar(7) default '00,00',
vsproto	varchar(70),
duploproduto varchar (7)  default '00',
duploproto	varchar(70),
mivo	varchar(7)  default '00,00',
mivoproto	varchar(70),
ana01	varchar(5),
ana02	varchar(5),
ana03	boolean default 0,
ana04	boolean default 0,
ana05	boolean default 0,
ana06	boolean default 0,
anatx01	varchar(60),
ana07	boolean default 0,
anatx02	varchar(60),
ana08	boolean default 0,
anatx03	varchar(60),
ana09	boolean default 0,
anatx04	varchar(60),
ana10	boolean default 0,
anatx05	varchar(60),
ana11	boolean default 0,
anatx06	varchar(60),
ana12	boolean default 0,
anaparq01	varchar(5),
anaparq02	varchar(5),
anaparq03	varchar(5),
anaparq04	varchar(5),
anaparq05	varchar(5),
anaparq06	varchar(5),
anaparq07	varchar(5),
anaparq08	varchar(5),
anaparq09	varchar(5),
imc	varchar(7) default '0,0',
imcclassifica	varchar(20) default 'RESULTADO',
imcgrau	varchar(20) default 'RESULTADO',
peso	varchar(8),
altura	varchar(7),
fotofrente	longblob,
fotocostas	longblob,
fotodireita	longblob,
fotoesquerda	longblob,
idcli	int(11) not null,
sexo	varchar(10), 
datareavaliacao	varchar(10),
idade	int(3) not null,
diapesc	varchar(7),
diaombro	varchar(7),
diatoraxrelax	varchar(7),
diatoraxinsp	varchar(7),
diaabdomem	varchar(7),
diacintura	varchar(7),
diaquadril	varchar(7),
diabracdir	varchar(7),
diabraesq	varchar(7),
diaantdir	varchar(7),
diaantesq	varchar(7),
diapunhdir	varchar(7),
diapunhesq	varchar(7),
diacoxaproxdir	varchar(7),
diacoxaproxesq	varchar(7),
diacoxameddir	varchar(7),
diacoxamedesq	varchar(7),
diacoxadistdir	varchar(7),
diacoxadistesq	varchar(7),
diaperdir	varchar(7),
diaperesq	varchar(7),
diatornodir	varchar(7),
diatornoesq	varchar(7),
cintquadrilvalor	varchar(7),
cintquadrilrisco	varchar(20),
diaradioulna	varchar(7),
diaumero	varchar(7),
diafemur	varchar(7),
diatornozelo	varchar(7),
somaendomorfo	varchar(7) default '0,0',
sommesomorfo	varchar(7) default '0,0',
somaectomorfo	varchar(7) default '0,0',
somaclassifica	varchar(30) default 'Não Calculado',
compoprotocolo	varchar(70),
compogordura	varchar(7) default '0,000',
compodensidade	varchar(7) default '0,000',
compopesoosseo	varchar(7) default '0,000',
compopesomuscu	varchar(7) default '0,000',
compopesoresid	varchar(7) default '0,000',
compogordabsoluta	varchar(7) default '0,000',
compomassamagra	varchar(7) default '0,000',
compopesoideal	varchar(7) default '0,000',
compopesoexesso	varchar(7) default '0,000',
dobrapeitoral	varchar(7),
dobrabiciptal	varchar(7),
dobratriciptal	varchar(7),
dobrasubescapular	varchar(7),
dobraaxilar	varchar(7),
dobrasuprailiaca	varchar(7),
dobraabdominal	varchar(7),
dobracoxa	varchar(7),
dobramedialperna	varchar(7),
foreign key(idcli) references clientes(idcli),
iduso int not null,
foreign key(iduso) references usuarios(iduso),
car01 varchar (60) default 'Selecione um protocolo', -- protocolo cardiopulmonar -- comeca aqui o cardiopulmonar
car02 varchar (25) default '0', -- condição funcional
car03 varchar (3), -- tempo minutos
car04 varchar (3), -- tempo segundos
car05 varchar (7), -- distancia
car06 varchar (4), --  potencia em whats
car07 varchar (2), -- estagio
car08 varchar (3), -- frequencia cardiaca 4
car09 varchar (3), -- frequencia cardiaca 5
car10 varchar (3), -- frequencia cardiaca geral
car11 varchar (15) default 'Não calculado', -- classifica vo2
carlat varchar (55) default 'Selecione um protocolo', -- protocolo latico
carlat01 varchar (6), -- t1
carlat02 varchar (6), -- t2
carlat03 varchar (6), -- t3
carlat04 varchar (6), -- t4
carlat05 varchar (6), -- t5
carlat06 varchar (6), -- t6
carlat07 varchar (6), -- t7
carlat08 varchar (6), -- t8
carlat09 varchar (6), -- t9
carlat10 varchar (6), -- t10
carlat11 varchar (7), -- distancia latico
carlat12 varchar (5) default '0,00', -- resultado latico
carlat13 varchar (20) default 'Não calculado', -- Classifica latico
carala varchar (55) default 'Selecione um protocolo', -- protocolo anlatico
carala01 varchar (6), -- tempo alatico
carala02 varchar (6), -- DISTANCIA ALATICO
carala03 varchar (5) default '0000', -- RESULTADO ALATICO
carala04 varchar (15) default 'Não calculado', -- Classifica alatico
carlac varchar (50) default 'Selecione um protocolo', -- protocolo limiar de lactato
carlac01 varchar (6), -- tempo lactato
carlac02 varchar (4) default '000', -- resultado lactato
carlac03 varchar (15) default 'Não calculado', -- classifica lactato
neuro01 varchar (80) default 'Selecione um protocolo', -- inicio neuro muscular protocolo abdomem
neuro02 varchar (4), -- valor da quantidade de abdominal
neuro03 varchar (25) default 'Não calculado', -- classifica abdomem
neuro04 varchar (80) default 'Selecione um protocolo', -- protocolo isotonico barra
neuro05 varchar (4), -- valor da quantidade de barra
neuro06 varchar (25) default 'Não calculado', -- classifica barra
neuro07 varchar (80) default 'Selecione um protocolo', -- protocolo isotonico braços
neuro08 varchar (4), -- valor da quantidade de flexoes
neuro09 varchar (25) default 'Não calculado', -- classifica flexoes
neuro10 varchar (80) default 'Selecione um protocolo', -- protocolo agachamento
neuro11 varchar (4), -- valor da quantidade de agachamento
neuro12 varchar (25) default 'Não calculado', -- classifica agachamento
neuro13 varchar (80) default 'Selecione um protocolo', -- protocolo força explosiva braços
neuro14 varchar (6), -- valor força explosiva braços
neuro15 varchar (25) default 'Não calculado', -- classifica força explosiva braços
neuro16 varchar (80) default 'Selecione um protocolo', -- protocolo impulso vertical
neuro17 varchar (4), -- valor do impulso vertical
neuro18 varchar (25) default 'Não calculado', -- classifica impulso vertical
neuro19 varchar (80) default 'Selecione um protocolo', -- protocolo impulso horizontal
neuro20 varchar (6), -- valor do impulso horizontal
neuro21 varchar (25) default 'Não calculado', -- classifica impulso horizontal
neuro22 varchar (80) default 'Selecione um protocolo', -- protocolo isometria membros superiores
neuro23 varchar (6), -- valor da isometria membros superiores
neuro24 varchar (25) default 'Não calculado', -- classifica isometria membros superiores
neuro25 varchar (80) default 'Selecione um protocolo', -- protocolo isometria membros inferiores e dorsal
neuro26 varchar (6), -- valor da isometria membros inferiores e dorsal
neuro27 varchar (25) default 'Não calculado', -- classifica isometria membros inferiores e dorsal
postu01 text, -- observaçoes da analise postural
postu02 boolean default 0, -- ombro direito
postu03 boolean default 0, -- ombro esquerdo
postu04 boolean default 0, -- coluna hiperlordose cervical
postu05 boolean default 0, -- coluna escoliose cervical
postu06 boolean default 0, -- coluna hipercifose toraxica
postu07 boolean default 0, -- coluna escoliose toraxica
postu08 boolean default 0, -- coluna hiperlordose lombar
postu09 boolean default 0, -- coluna escoliose lombar
postu10 boolean default 0, -- crista iliaca direita
postu11 boolean default 0, -- crista iliaca esquerda
postu12 boolean default 0, -- pes abdutos
postu13 boolean default 0, -- pes adutos
postu14 boolean default 0, -- pes cavos
postu15 boolean default 0, -- pes planos
postu16 boolean default 0, -- pes calcaneos
postu17 boolean default 0, --  pes equinos
postu18 boolean default 0, -- joelho valgo
postu19 boolean default 0, -- joelho varo
postu20 boolean default 0, -- joelho recurvato
postu21 varchar (5), -- alcance banco de wells
postu22 varchar (25) default 'Não calculado'

);