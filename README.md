
# Biblioteca do CCC

A comunidade computação da UFCG cria muitos artefatos de pesquisa, como teses, artigos, TCC’s e dissertações, que acabam não sendo divulgados ou não são facilmente acessados. A ideia é criar uma plataforma onde seja possível disponibilizar diversos artefatos produzidos por alunos e professores. 
Cada usuário terá seu perfil que irá conter algumas informações pessoais e os seus artefatos de pesquisa.

## Como rodar: 
No projeto está sendo usado o maven como ferramenta de builder. Para conseguir subir o servidor localmente você deve: 
- Baixar o projeto 
- Instalar o maven [(aqui)](https://maven.apache.org/install.html)
- Entrar no diretório /projeto-daca/biblioteca
- Execute o comando: ``` mvn spring-boot:run ```

Pronto, você já pode fazer requisições http no endereço: 
 ```localhost:8080/```


## Arquitetura	
Esta é uma aplicação que usa o conceito de API REST, mais informações [aqui](https://becode.com.br/o-que-e-api-rest-e-restful/).
A aplicação está estruturada da seguinte maneira: existem classes modelo, controller, service e repository. 
- Modelo: Essas classes representam as entidades que compõem o sistema. Existem três, são elas: Artefato, Autor e Coleção.
- Controller: Essas fazem o mapeamento dos endpoints que estarão disponíveis na API. Os controllers se comunicam com os services.  
- Service: Essas classes encapsulam as regras de negócio da aplicação, e recebem chamadas dos controllers. Os services fazem chamadas para os repositories para recuperar as informações e atualizadas quando necessário.  
- Repository: São responsáveis por modelar as classes modelo para serem salvas no banco de dados.

Abaixo temos um diagrama simplificado da arquitetura: 

![Diagrama Arquitetura](https://drive.google.com/open?id=1Q7giEbDWiEQA6XS-agSla_MMpH1__V6f)

#### Uma requisição:
Você pode fazer uma requisição que liste todos os autores cadastrados usando uma chamado do tipo GET através da URL: ```localhost:8080/autor```. O controller de autor irá interceptar a chamada http e irá chamar o service de autor, o service de autor irá se comunicar com o repository de autor que irá recuperar a informação do BD. 

Para mais exemplos de chamadas você pode acessar o arquivo: [DACA.postman_collection.json](https://www.getpostman.com/collections/58e52e960e1488d6ffc2) 

## Segurança 
Para realizar o processo de autenticação e autorização está sendo usado tokens, mais especificamente o JWT. 
O usuário pode ter acesso de **ADMIN** e **USER**. Cada um desses só podem acessar rotas específicas. Com exceção da rota de cadastro todas as outras requerem autenticação.

Para apagar um autor do sistema é preciso ter acesso do tipo ADMIN, para isso você pode usar a chamada http do tipo **DELETE** com a URL ```localhost:8080/autor/{id}```. No header da chamada deve ser mandado um Basic Auth com o usuario="admin" e senha="samambaia". Existe apenas um único usuário ADMIN. 

O funcionamento do processo de autorização acontece da seguinte maneira: Ao fazer uma chamada para uma rota que requer autorização você tem que mandar um token válido.  

## Configurar o BD:
A aplicação usa como BD o postgres. É preciso ter o postgres instalado no seu computador. 
No arquivo application.properties você deve alterar as informações para o seu BD local:
```
server.port= < insira o número de sua porta >
spring.datasource.url=jdbc:postgresql://localhost: < insira sua porta/ insira o nome do seu BD >  (separado por barra)
spring.datasource.username= <insira o nome do usuário do seu BD>
spring.datasource.password= <insira as senha do seu BD>
```
*Você pode comentar todo o arquivo application.properties e usar o BD em memória H2. 

## Cache

Foi utilizado o serviço de cache na aplicação para melhorar o desempenho da aplicação. O Redis foi a tecnologia de cache utilizada. Você precisa estar com o redis rodando em suas maquina para o serviço de cache funcionar. Mais informações [aqui](https://redis.io/topics/quickstart).

A rota que faz a utilização de cache é do tipo GET feita para listagem dos autores cadastrados ```localhost:8080/autor/cache```.

## Jmeter

Para análisar o desempenho da aplicação foi utilizado o JMeter. Veja o relatório completo de desempenho no [doc](https://docs.google.com/document/d/14O6Wweh26GV3MgUefw6XV7p7ZaXKCvSXLknWytNQ-UE/edit?usp=sharing).
