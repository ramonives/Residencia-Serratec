select pedidoitem.cod_pedidoitem, pedidoitem.cod_pedido, produto.nome_produto 
from pedidoitem 
inner join produto on pedidoitem.cod_produto = produto.cod_produto 