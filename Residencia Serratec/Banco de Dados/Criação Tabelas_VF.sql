create table CLIENTE (
cod_cliente serial primary key not null,
cpf_cliente char (11) not null, 
nome_completo varchar (50) not null,
data_nascimento date not null,
nome_usuario varchar (10) not null,
e_mail varchar (100) not null,
senha_cliente varchar (20) not null
);

create table CATEGORIA (
cod_categoria serial primary key not null,
nome_categoria varchar (50) not null
);

create table FUNCIONARIO (
cod_funcionario serial primary key not null,
nome_funcionario varchar (50) not null,
cpf_funcionario char (11) not null
);

create table ENDERECO (
cod_endereco serial primary key not null, 
cep char (8) not null,
estado varchar (50) not null,
cidade varchar (50) not null,
bairro varchar (50) not null,
rua varchar (50) not null,
numero_residencia varchar (15) not null,
complemento varchar (100) not null,
cod_cliente serial not null,
foreign key (cod_cliente) references CLIENTE(cod_cliente)
);

create table PEDIDO (
cod_pedido serial primary key not null,
data_pedido date not null,
cod_cliente serial not null,
foreign key (cod_cliente) references CLIENTE(cod_cliente)
);

create table PRODUTO (
cod_produto serial primary key not null,
nome_produto varchar (100) not null,
descricao_produto varchar (500) not null,
valor_unitario money not null, -- preço cheio do item 
data_fabricacao date not null,
cod_categoria serial not null,
foreign key (cod_categoria) references CATEGORIA(cod_categoria)
);

create table PEDIDOITEM (
cod_pedidoitem serial primary key not null,
quantidade_item integer not null, 
valor_item money not null,--preço unitário do item, pode ser modificado em função de promoções 
cod_pedido serial not null,
cod_produto serial not null,
foreign key (cod_pedido) references PEDIDO(cod_pedido),
foreign key (cod_produto) references PRODUTO(cod_produto)
);

create table ESTOQUE (
cod_estoque serial primary key not null,
cod_produto serial not null,
foreign key (cod_produto) references PRODUTO(cod_produto),
quantidade_estoque integer not null,
cod_funcionario serial not null,
foreign key (cod_funcionario) references FUNCIONARIO(cod_funcionario)
)


