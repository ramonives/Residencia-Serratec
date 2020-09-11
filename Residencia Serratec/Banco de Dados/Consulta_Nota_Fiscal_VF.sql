select cliente.nome_completo, cliente.cpf_cliente, 
endereco.cep,endereco.estado, endereco.cidade, endereco.bairro, endereco.rua, endereco.numero_residencia, endereco.complemento,
pedido.data_pedido, pedido.cod_pedido,
produto.nome_produto, produto.descricao_produto,
pedidoitem.quantidade_item, pedidoitem.valor_item, (pedidoitem.quantidade_item * pedidoitem.valor_item) as valor_total
from pedido 
inner join cliente on cliente.cod_cliente = pedido.cod_cliente 
inner join endereco on endereco.cod_cliente = cliente.cod_cliente 
inner join pedidoitem on pedidoitem.cod_pedido = pedido.cod_pedido 
inner join produto on produto.cod_produto = pedidoitem.cod_produto 
where cliente.cod_cliente = '8'