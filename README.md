# Sistema de CRUD de Clientes em Java

Este é um sistema simples de CRUD (Create, Read, Update, Delete) implementado em Java para gerenciar informações de clientes. O sistema permite realizar operações de cadastro, consulta, exclusão e atualização de clientes utilizando interfaces gráficas com `JOptionPane`.

## Funcionalidades

- **Cadastro de Clientes**: Permite cadastrar clientes fornecendo dados como nome, CPF, telefone, endereço, número, cidade e estado.
- **Consulta de Clientes**: Permite consultar os dados de um cliente com base no seu CPF.
- **Exclusão de Clientes**: Permite excluir um cliente baseado no seu CPF.
- **Alteração de Dados**: Permite alterar as informações de um cliente já cadastrado.

## Tecnologias Utilizadas

- **Java 8+**: A versão mais recente do Java foi utilizada para garantir a compatibilidade com os recursos modernos, como o uso de Streams.
- **JOptionPane**: Para a criação de interfaces gráficas simples e interativas.
- **Coleções**: O sistema usa diferentes implementações de coleções (como `Set`, `Map`, etc.) para armazenar e manipular os dados dos clientes.

## Estrutura do Projeto

- **`App.java`**: Classe principal que executa a interface do usuário e gerencia as operações de CRUD.
- **`Cliente.java`**: Classe que representa um cliente com atributos como nome, CPF, telefone, etc.
- **`IClienteDAO.java`**: Interface que define os métodos para as operações CRUD.
- **`ClienteMapDAO.java`**: Implementação da interface `IClienteDAO` usando um `Map` (usando o CPF como chave).
- **`ClienteSetDAO.java`**: Implementação alternativa de `IClienteDAO` usando um `Set` para armazenar os clientes.

