<h1>Projeto Final - Santander Coders 2023.2 - Módulo III - Programação Orientada a Objetos II</h1>

<h3>ADA LocateCar - Locadora de veículo</h3>

  
Descrição do Projeto

O projeto final do Módulo III - Programação Orientada a Objetos II consiste na criação de uma aplicação que gerencie o aluguel de veículos, aplicando os conceitos vistos em aula, onde cada item abaixo seja considerado:

<h3>Itens obrigatórios</h3>

<ul>-<li>Cadastrar os veículos;</li>
<li>Alterar um veículo cadastrado;</li>
<li>Buscar um veículo por parte do nome;</li>
<li>Cadastrar o cliente (pessoa física e jurídica)</li>
<li>Alterar o cliente (pessoa física e jurídica)</li>
<li>Alugar um veículo para pessoa física e jurídica;</li>
<li>Devolver um veículo para pessoa física e jurídica;</li>
</ul>


<h3>Regras de negócio</h3>

RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;

RN2: Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;

RN3: Os aluguéis e devoluções terão o local, data e horário;

RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.

RN5: Os veículos que estiverem alugados não poderão estar disponíveis;

RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;

RN7: Regras de devolução:
Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.
Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.
Valores base da diária por tipo de veículo:

| Tipo de Veículo | Valor por dia | | --------------- | ------------- | | PEQUENO | R
100
,
00
∣
∣
�
�
�
�
�
∣
�
100,00∣∣MEDIO∣R 150,00 | | SUV | R$ 200,00 |

Itens bônus - Opcionais
Paginar as listagem envolvidas;
Gravar os dados em arquivos;
