# prova_4all

Para execu��o dos seguintes testes:

- DesafioUmTest
- DesafioDoisTest

Informe Chrome ou Firefox para selecionar o browser

*mvn clean test -Dtest=DesafioUmTest -Denv.BROWSER=firefox*

Para execu��o da su�te em paralelo

*mvn clean test -Dsuite.testng=desafios -Denv.BROWSER=chrome*

Sera gerado report com nome de Extent.html na raiz do projeto

Foi criado uma branch develop utilizando outro design patterns

para acesso a mesma, execute o comando: "git checkout develop"