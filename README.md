# Locadora de Veículos

Este projeto é uma aplicação de uma locadora de veículos, desenvolvida como parte de um exercício prático para aplicar conceitos de programação orientada a objetos e arquitetura MVC.

## Funcionalidades
- Cadastro, alteração e busca de veículos por parte do nome.
- Cadastro e alteração de clientes (pessoa física e jurídica).
- Aluguel e devolução de veículos para pessoas físicas e jurídicas.
- Paginação nas listagens de veículos e clientes.

## Regras de Negócio
1. Os veículos não podem ser repetidos, utilizando a placa como identificador de unicidade.
2. Tipos de veículos considerados: PEQUENO, MÉDIO e SUV.
3. Os aluguéis e devoluções incluem local, data e horário.
4. Aluguéis em horas quebradas são considerados como diárias completas.
5. Veículos alugados não estão disponíveis.
6. Clientes não podem ser duplicados, utilizando CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade.
7. Regras de devolução:
   - Cliente pessoa física com mais de 5 diárias tem direito a 5% de desconto.
   - Cliente pessoa jurídica com mais de 3 diárias tem direito a 10% de desconto.

## Estrutura do Projeto
O projeto segue a arquitetura MVC (Model-View-Controller), com a separação das camadas de modelo, visão e controle para facilitar a organização e manutenção do código.

## Conceitos Aplicados
Durante o desenvolvimento deste projeto, foram aplicados os seguintes conceitos:

### Interfaces
Interfaces foram utilizadas para definir contratos entre diferentes partes do sistema, como os serviços de aluguel e clientes. Isso permite uma maior flexibilidade na implementação e facilita a substituição de componentes.

### Generics
Generics foram empregados em várias partes do código para aumentar a reusabilidade e a segurança de tipos. Por exemplo, as listas de veículos e clientes são parametrizadas com generics para evitar castings desnecessários.

### Princípios do SOLID
Os princípios do SOLID foram considerados durante o desenvolvimento para garantir que o código seja modular, extensível e de fácil manutenção. Por exemplo, a separação de responsabilidades entre as camadas MVC segue o princípio da responsabilidade única.

## Dificuldades e Facilidades

### Facilidades
- A utilização da arquitetura MVC facilitou a organização do código e a separação de responsabilidades entre as diferentes partes do sistema.
- A utilização de generics e interfaces tornou o código mais flexível e reutilizável, permitindo uma implementação mais limpa e concisa.

### Dificuldades
- A implementação das regras de devolução com base no tempo de aluguel foi desafiadora, especialmente a lógica para calcular os descontos com base no tipo de cliente.
- A gestão dos aluguéis e sua associação com os clientes e veículos exigiu um planejamento cuidadoso para garantir a consistência dos dados.

## Como Executar o Projeto

Para executar o projeto, siga estas etapas:

1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter o Java JDK instalado em seu sistema.
3. Execute o arquivo Main.java para iniciar o sistema.

