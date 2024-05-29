Existe 3 MicroServiços
ms-client para o cadastro do clinte
ms-deadline para saber o prazo de um cliente
ms-order faz uma pedido para um cliente e coloca o prazo de pagamento do cliente de acordo com o resultado do micro serviço de deadline.

A ideia e apresentar um jeito de colocar um circuit breaker para que se o serviço de deadline esteja fora vamos utilizar o valor padrão

Configuração do POM
<dependency>
<groupId>io.github.resilience4j</groupId>
<artifactId>resilience4j-spring-boot3</artifactId>
<version>2.2.0</version>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-aop</artifactId>
</dependency>

Pegar o arquivo resources 
application.yaml -> aqui te todas as configurações do resilience4j utilizadas no projeto.

com essa anotaçao ativa o circuit breaker no metodo
@CircuitBreaker(name="backendC",fallbackMethod="fetchDataFallback")

Quando o circuit abrir e entrar enviar os dados padrões vc precisa configurar esse cara para que ele de tempos em tempo ele retente novamente
waitDurationInOpenState: 3600 #tem de espera no estado de aberto.