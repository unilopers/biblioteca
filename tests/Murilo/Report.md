# Modelo testado : Livros

Para realizar estes testes, primeiro foram criados livros utilizando a biblioteca Faker para geração de nomes aleatórios de livros e então, foram realizadas requisições GET para retornar os dados persistidos.

## Comportamento observado

Nos testes de persistência de dados, assim que o locust atingiu 360 usuários, o tempo de resposta aumentou drásticamente, além de causar instabilidade no tempo e quantidade de respostas. Para o cenário da consulta das informações, o mesmo aconteceu, porém apenas quando o locust atingiu cerca de 1000 usuários realizando requisições. Em ambos os cenários, não houveram timeout, gargalos ou erros. Ao alcançar os marcos acima mencionados, a aplicação apresentou um aumento crescente no tempo de resposta, tornando-a lenta.  Com isso, notamos que a operação que mais sofreu os efeitos do alto volume de usuários foi a de persistência de informações, provavelmente devido à persistência de dados ser mais demorada do que apenas uma consulta para retornar as informações já persistidas. Portanto, nota-se que, na máquina utilizada para efetuar estes testes, existe um limite baixo de usuários simultâneos até que a aplicação comece a apresentar inconsistências em suas respostas.

Imagens contendo o gráfico apresentando as oscilações dos parâmetros utilizados estão presentes na pasta Attachments, assim como o código.