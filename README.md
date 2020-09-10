# prova_4all

Para execução dos seguintes testes:

- DesafioUmTest
- DesafioDoisTest

Informe Chrome ou Firefox para selecionar o browser

*mvn clean test -Dtest=DesafioUmTest -Denv.BROWSER=firefox*

Para execução da suíte em paralelo

*mvn clean test -Dsuite.testng=desafios -Denv.BROWSER=chrome*

Sera gerado report com nome de Extent.html na raiz do projeto


* Foi criada uma branch "develop" utilizando design patterns page factory
* Foi refatorado o método para criação de relatórios informando a data e hora da execução em sua nomenclatura
* Branch develop está utilizando framework cucumber em bdd e em seu relatorio de testes 
 