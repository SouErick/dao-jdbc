# Projeto CRUD com DAO JDBC

Este é um projeto Java que implementa operações CRUD (Create, Read, Update, Delete) usando JDBC e o padrão DAO (Data Access Object). O projeto consiste em duas partes principais: uma para manipular entidades de Vendedor e outra para manipular entidades de Departamento.

## Vendedor

A classe `ProgramaVendedor` é responsável por operações relacionadas aos vendedores. Ele permite inserir, atualizar, excluir, pesquisar por ID e listar todos os vendedores.

### Funcionalidades

1. **Inserir Vendedor:** Permite inserir um novo vendedor no sistema.
2. **Atualizar Vendedor:** Permite atualizar informações de um vendedor existente.
3. **Pesquisar por ID:** Permite pesquisar um vendedor pelo seu ID.
4. **Excluir Vendedor:** Permite excluir um vendedor do sistema.
5. **Listar Todos:** Permite listar todos os vendedores cadastrados.

## Departamento

A classe `ProgramaDepartamento` é responsável por operações relacionadas aos departamentos. Assim como a classe de Vendedor, ela permite inserir, atualizar, excluir, pesquisar por ID e listar todos os departamentos.

### Funcionalidades

1. **Inserir Departamento:** Permite inserir um novo departamento no sistema.
2. **Atualizar Departamento:** Permite atualizar informações de um departamento existente.
3. **Pesquisar por ID:** Permite pesquisar um departamento pelo seu ID.
4. **Excluir Departamento:** Permite excluir um departamento do sistema.
5. **Listar Todos:** Permite listar todos os departamentos cadastrados.

## Dependências

- JDK (Java Development Kit)
- JDBC Driver (Para conexão com o banco de dados)

## Configuração

Antes de executar o projeto, certifique-se de configurar corretamente a conexão com o banco de dados no arquivo de configuração `db.properties`, o banco de dados usado nesse projeto foi o `MySQL`. Os comandos estão no arquivo `database.sql`.

## Vídeo Demonstrativo

[![Vídeo Demonstrativo](http://img.youtube.com/vi/SyvQblF6v2w/0.jpg)](http://www.youtube.com/watch?v=SyvQblF6v2w)

