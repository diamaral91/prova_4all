# prova_4all

Para execução dos seguintes testes:

- DesafioUmTest
- DesafioDoisTest

Informe Chrome ou Firefox para selecionar o browser

*mvn clean test -Dtest=<nome-do-teste> -Denv.BROWSER=<browser>*

Para execução da suíte em paralelo

*mvn clean test -Dsuite.testng=desafios -Denv.BROWSER=<browser>*

Sera gerado report com nome de Extent.html na raiz do projeto