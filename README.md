# Biblioteca do CCC
A comunidade computação da UFCG cria muitos artefatos de pesquisa, como teses, artigos, TCC’s e dissertações, que acabam não sendo divulgados ou não são facilmente acessados. A ideia é criar uma plataforma onde seja possível disponibilizar diversos artefatos produzidos por alunos e professores. 
Cada usuário terá seu perfil que irá conter algumas informações pessoais e os seus artefatos de pesquisa.

Arquitetura: O projeto está estruturado da seguinte maneira existem três classes de modelos no sistema, são elas: Artefato, Autor e Coleção.
Existem três controllers e services um para cada classe de modelo. Os controllers são responsáveis por fazer apenas mapeamentos das chamadas REST, não existem regras de negócio nos controllers. Os controllers chamam os services, nos services existem regras de negócios os services fazem chamadas para os Repositórios de cada modelo de forma a manter a integridade do sistema.

Como rodar: baixar o projeto e rodar a classes principal que se chama BibliotecaApplication.java. Talvez seja necessário dar build no maven antes para baixar as dependência
