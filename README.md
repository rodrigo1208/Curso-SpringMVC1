# Curso-SpringMVC1
Curso de SpringMVC da Alura

### Exercicio de validação e conversão de dados

  Para a validação dos dados foi utilizada uma biblioteca de validação com as seguintes dependencias:
```xml
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>1.0.0.GA</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>4.2.0.Final</version>
</dependency>
```
  Foi necessario implementar uma interface do próprio Spring chamada Validator, e seus dois metodos.
No controller foi necessario implementar um método chamado initBinder() com a marcação @InitBinder e esse método receberia o ObjecValidator criado.
  Para mais informações, acessar ProdutoController.
