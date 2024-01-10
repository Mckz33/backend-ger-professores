# Gerenciamento de Professores e Sobrecarga de Horário.
<b>Nome do Projeto:</b> backend-ger-professores</br>
<b>Descrição:</b> Um projeto voltado para a parte da lógica e do tratamento das regras de negócios. O principal objetivo é a construção de um sistema único de controle de professores em suas grades horárias de suas escolas/faculdades/universidades, onde, o coordenador do curso poderá validar a carga horário do docente de acordo com as regras passadas pela instituição de ensino.

## Tecnologias Usadas
- <b>Linguagem:</b> Java.
- <b>IDE:</b> Visual Studio Code.
- <b>Ferramentas:</b> Spring Web, Spring Data JPA, Spring MariaDB, Spring Security, Spring Validation, Lombok, Devtools, ModelMapper, JJWT-api e Vaadin.

## Detalhamento do Projeto
Este projeto em Java foi desenvolvido seguindo as melhores práticas de programação e arquitetura, com ênfase na modularidade e reutilização de código. Abaixo, estão destacados os principais tópicos abordados durante a produção do sistema:

<b>1. Arquitetura no Padrão de Boas Práticas:</b>
  - Separação de responsabilidades entre camadas, como controle, serviço e acesso a dados.

<b>2. Sistema de Login e Senha:</b>
  - Implementação de um sistema robusto de autenticação de usuários.

<b>3. Autenticação JWT:</b>
  - Utilização de JSON Web Tokens (JWT) para autenticação de usuários.
  - Geração, validação e renovação de tokens para garantir a segurança do sistema.

<b>4. Roles de Permissão de Usuário:</b>
  - Definição de diferentes papéis (roles) para usuários, como professor, gestor e coordenador.
  - Controle de acesso baseado nas permissões atribuídas a cada papel.

<b>5. Paginação, Filtros, Responses e Requests:</b>
  - Implementação de mecanismos de paginação para facilitar a navegação pelos dados.
  - Adoção de filtros para personalizar consultas e melhorar a eficiência.
  - Estruturação de responses e requests padronizados para facilitar a integração com clientes.

<b>6. Validação de Dados:</b>
  - Validação rigorosa de dados de entrada para prevenir erros e garantir a integridade do sistema.
  - Utilização de anotações de validação e customizações para garantir a consistência dos dados.
    
<b>7. Exceptions Personalizadas:</b>
  - Implementação de exceções personalizadas para lidar com situações específicas do domínio.
  - Tratamento adequado de erros, proporcionando mensagens claras e informativas.

<b>8. Swagger Implementado:</b>
  - Integração do Swagger para documentação automática da API.
  - Facilitação da compreensão e teste da API por desenvolvedores e usuários.

<b>9. Lógicas para CRUD e Tratamento dos Dados:</b>
  - Desenvolvimento de lógicas robustas para as operações CRUD (Create, Read, Update, Delete).
  - Implementação de estratégias eficientes para lidar com sobreposição de horários na grade curricular.

## Extras
<b>Link de acesso ao Swagger do projeto:</b>
http://localhost:8080/swagger-ui/index.html#/

## Autores
- Mackenzie Maxwell - (https://github.com/Mckz33)
- Victor Miguel Rocha - (https://github.com/vtr363)
- Matheus Tavares Correia - (https://github.com/mtcorreia)
