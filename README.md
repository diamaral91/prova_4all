# prova_4all

Para execu��o dos seguintes testes:

- DesafioUmTest
- DesafioDoisTest

Informe Chrome ou Firefox para selecionar o browser

*mvn clean test -Dtest=DesafioUmTest -Denv.BROWSER=firefox*

Para execu��o da su�te em paralelo

*mvn clean test -Dsuite.testng=desafios -Denv.BROWSER=chrome*

Sera gerado report com nome de Extent.html na raiz do projeto


* Foi criada uma branch "develop" utilizando design patterns page factory
* Foi refatorado o m�todo para cria��o de relat�rios informando a data e hora da execu��o em sua nomenclatura
* Branch develop est� utilizando framework cucumber em bdd e em seu relatorio de testes 
 