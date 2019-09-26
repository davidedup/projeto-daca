# Biblioteca do CCC
A comunidade computação da UFCG cria muitos artefatos de pesquisa, como teses, artigos, TCC’s e dissertações, que acabam não sendo divulgados ou não são facilmente acessados. A ideia é criar uma plataforma onde seja possível disponibilizar diversos artefatos produzidos por alunos e professores. 
Cada usuário terá seu perfil que irá conter algumas informações pessoais e os seus artefatos de pesquisa.

Arquitetura: O projeto está estruturado da seguinte maneira existem três classes de modelos no sistema, são elas: Artefato, Autor e Coleção.
Existem três controllers e services um para cada classe de modelo. Os controllers são responsáveis por fazer apenas mapeamentos das chamadas REST, não existem regras de negócio nos controllers. Os controllers chamam os services, nos services existem regras de negócios os services fazem chamadas para os Repositórios de cada modelo de forma a manter a integridade do sistema.

# Como rodar:

É preciso ter o maven instalado.
A aplicação usa como BD o postgres. É preciso ter o postgres instalado. 

No arquivo application.properties você deve alterar as informações para o seu BD local:

####server.port=<insira o número de sua porta>

####pring.datasource.url=jdbc:postgresql://localhost: <insira sua porta/ insira o nome do seu BD>  (separdo por barra)

####spring.datasource.username=<insira o o nome do usúario do seu BD>

####spring.datasource.password=<insira as senha do seu BD>

Após as configurações rode o comando abaixo na pasta com arquivo pom.xml
## mvn spring-boot:run
