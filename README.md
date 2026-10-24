# FichasTecnicasEtapa6

## Projeto Integrador — Módulo B | Senac

Projeto desenvolvido como parte da Etapa 6 do Projeto Integrador do curso Técnico em Desenvolvimento de Sistemas.

O objetivo desta etapa é refatorar o sistema desktop de fichas técnicas desenvolvido anteriormente, melhorando a organização do código, aplicando princípios de programação orientada a objetos e preparando as regras de negócio para uma futura aplicação web.

## Tecnologias utilizadas

- Java
- Java Swing
- Maven
- MySQL
- JDBC
- Apache NetBeans
- Git e GitHub

## Funcionalidades

O sistema permite:

- Cadastrar produtos.
- Listar os produtos cadastrados.
- Pesquisar produtos.
- Consultar os detalhes de um produto.
- Criar e vincular fichas técnicas aos produtos.
- Atualizar a composição do tecido, o tipo de costura e o processo de fabricação.
- Validar informações antes de salvar no banco de dados.

## Arquitetura do projeto

O código foi organizado em camadas para separar as responsabilidades:

**Model:** classes que representam os dados do sistema, como `Produto` e `FichaTecnicaDetalhe`.

**Repository:** classes responsáveis pelas consultas e operações no banco de dados MySQL.

**Service:** classes responsáveis pelas validações e regras de negócio.

**View:** telas Java Swing responsáveis pela interação com o usuário.

**Util:** classe responsável por disponibilizar a conexão JDBC.

## Refatorações realizadas

Durante a Etapa 6, foram realizadas as seguintes melhorias:

1. Remoção dos comandos SQL das telas Swing.
2. Centralização das operações de banco de dados nas classes Repository.
3. Centralização das validações nas classes Service.
4. Utilização de objetos Model para transportar os dados entre as camadas.
5. Redução da duplicação de código.
6. Utilização de `try-with-resources` para gerenciar recursos JDBC.
7. Tratamento de exceções e mensagens de validação.
8. Utilização de variável de ambiente para a senha do banco de dados.

## Princípios SOLID

O principal princípio aplicado foi o **SRP (Single Responsibility Principle)**, ou Princípio da Responsabilidade Única.

Cada camada passou a possuir uma responsabilidade definida, facilitando a manutenção, os testes e a reutilização do código.

A separação entre as camadas também prepara o sistema para futuras melhorias arquiteturais.

## Testes realizados

Foram realizados testes de:

- Listagem e pesquisa de produtos.
- Cadastro de produtos.
- Validação de campos obrigatórios e datas.
- Consulta de detalhes.
- Criação automática e vinculação de fichas técnicas.
- Atualização de informações da ficha técnica.
- Persistência dos dados no MySQL.
- Compilação do projeto com Maven.

## Configuração do banco de dados

O projeto utiliza um banco MySQL chamado `tecnica`, contendo as tabelas `produto` e `ficha_tecnica`.

A senha de acesso ao banco deve ser configurada na variável de ambiente `DB_PASSWORD`.

A classe `Conexao.java` utiliza essa variável para estabelecer a conexão JDBC.

É necessário configurar o banco de dados e a variável de ambiente antes de executar o projeto.

## Objetivo futuro

A arquitetura refatorada permitirá reutilizar as classes de modelo e regras de negócio no desenvolvimento de uma versão web do sistema, reduzindo o acoplamento com a interface desktop.

## Repositório

https://github.com/Pedrootavio204/FichasTecnicasEtapa6

## Instituição

Senac — Curso Técnico em Desenvolvimento de Sistemas.
