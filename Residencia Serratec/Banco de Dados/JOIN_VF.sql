select pedido.cod_pedido, pedido.cod_cliente, cliente.nome_completo
from pedido
inner join cliente on pedido.cod_cliente = cliente.cod_cliente