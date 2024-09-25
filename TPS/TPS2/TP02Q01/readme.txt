Crie uma classe Pokémon seguindo todas as regras apresentadas no slide 
https://github.com/icei-pucminas/aeds2/blob/master/aulas/u00\%20Nivelamento/unidade00l_nivelamento_introducaoOO.pdf. 
Sua classe terá os atributos privado id int, generation int, name String, description String, types Lista, 
abilities Lista, weight double, height double, captureRate int, isLegendary boolean, captureDate Date. 
Sua classe também terá pelo menos dois construtores, e os métodos gets, sets, clone, imprimir e ler.

O método $imprimir$ mostra os atributos do registro (ver cada linha da saída padrão) e o ler lê os atributos 
de um registro. Atenção para o arquivo de entrada, pois em alguns registros faltam valores e esse foi substituído
 pelo valor 0 (zero) ou vazio. A entrada padrão é composta por várias linhas e cada uma contém um número inteiro 
 indicando o id do Pokémon a ser lido.

A última linha da entrada contém a palavra FIM. A saída padrão também contém várias linhas, uma para cada registro
 contido em uma linha da entrada padrão, no seguinte formato: 
[#id -> name: description - [types] - [abilities] - weight - height - captureRate - isLegendary - generation] - captureDate].

Exemplo: [#181 -> Ampharos: Light Pokémon - ['electric'] - ['Static', 'Plus'] - 61.5kg - 1.4m - 45% - false - 2 gen] - 25/05/1999