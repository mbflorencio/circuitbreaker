Existe 3 MicroServiços
ms-client para o cadastro do clinte
ms-deadline para saber o prazo de um cliente
ms-order faz uma pedido para um cliente e coloca o prazo de pagamento do cliente de acordo com o resultado do micro serviço de deadline.

A ideia e apresentar um jeito de colocar um circuit breaker para que se o serviço de deadline esteja fora vamos utilizar o valor padrão
