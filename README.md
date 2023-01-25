# Projeto Assembleia Sicredi
Projeto para cadastro de uma pauta para votação, um administrador cadastra uma pauta,
o usuário vota na pauta selecionando a Pauta, digitando seu CPF, e escolhendo um voto (sim ou não.)
<br><br><br>

### Chamadas

Acesso `local` via: `http://localhost:8080`<br>
Consultar todas as pautas cadastradas - GET <code>/pautas/v1</code> <br>
Consultar uma pauta por ID - GET <code>/pautas/v1/{pautaId}</code> <br>
Cria uma nova pauta - POST <code>/pautas/v1</code> <br>
Edita uma pauta existente - PATCH <code>/pautas/v1/{pautaId}</code> <br>
Abre uma sessão de votação - PATCH <code>/pautas/v1/abrir/{pautaId}</code> <br>
<br><br>


### TECNOLOGIAS UTILIZADAS
- Java 11
- Spring Boot
- JPA
- PostgreSQL
- Maven
- ModelMapper
- Swagger
- JUnit
- Mockito
<br>
<br>

### CONFIGURAÇÃO DO PROJETO
Criar banco de dados no postgreSQL com o nome de assembleiaBD<br>
usar as configurações abaixo:<br>
- <code>username: postgres</code><br>
- <code>password: sicredi<br></code>
- <code>localhost: 5432</code>
<br>
<br>
<br>

### VERSIONAMENTO DO PROJETO
Foi utilizado o sistema de versionamento pela api, onde foi incluido na URI o <code>/v1</code>
para identificar que o sistema está na sua versão 1, posteriomente em caso de novas versões, bastaria
construir a rota v2 para uma nova versão.
<br>
<br>

### SWAGGER
O Swagger pode ser acessado pela url: 
- <code>http://localhost:8080/swagger-ui.html#/ </code>
<br>
<br>

## OSERVAÇOES FINAIS

- A tarefa Bonus 1 foi implementada na classe `ServiceCPF` contida no pacote `external`, porem não foi chamada
no UseCase pois estava retornando um erro, mesmo assim deixei ela implementada para analise da forma que foi feita.
para contornar esse problema e simular a chamada externa, foi criado um metodo que recebe um random e
retorna se o CPF é válido, Apto para o voto ou inapto, tudo feito de forma aleatória, não há validação alguma de CPF.
- Alguns testes unitários não foram feitos devido a falta de tempo para entrega do projeto, a cobertura não está 100%.
- A tarefa bonus 2 não foi feita.
- A tarefa 3 foi descrita acima. 
- A arquitetura usada foi a clean architecture pois é a que tenho mais familiaridade.