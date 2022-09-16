# Desafio Final do Treinamento "If Black Then Code" - Gama Academy - IBM

## **Hello Bank**
<br> 

Construção de API de um banco fictício para gerenciar transações.

<br>

## 📑 Arquitetura do Projeto

```
├──📁 HELLOBANK
    ├──📁 src
    |   └─ 📁 main
    |   |   └─ 📁 java\com\helloBank\desafio
    |   |   |   └─ 📁 controllers
    |   |   |   |   └─📄ClienteController.java 
    |   |   |   |   └─📄ContaController.java 
    |   |   |   |   └─📄TransacaoController.java 
    |   |   |   └─ 📁 models
    |   |   |   |   └─📄Cliente.java  
    |   |   |   |   └─📄Conta.java 
    |   |   |   |   └─📄Transacao.java   
    |   |   |   └─ 📁 repositories
    |   |   |   |   └─📄ClienteRepository.java  
    |   |   |   |   └─📄ContaRepository.java 
    |   |   |   |   └─📄TransacaoRepository.java 
    |   |   |   └─ 📁 Services
    |   |   |   |   └─📄ClienteService.java  
    |   |   |   |   └─📄ContaService.java 
    |   |   |   |   └─📄TransacaoService.java 
    │   |   |   └─📄DesafioApplication.java    
    |   |   └─ 📁 resources   
    |   |   |   └─📄Application.properties
    |   └─ 📁 test\java\com\helloBank\desafio
    |   |   └─📄DesafioApplicationTests.java
    ├──📁 target
    ├─📄.gitignore      
    ├─📄 pom.xml
    ├─📄 README.md  
    ├─📄 run.sh
    └─📄 start.sh
```

## 🛣️ Rotas
<br>

### Métodos POST/GET/PUT/DELETE - *Clientes* 
<br>

<div align = "center">

|  Método  |                  Rota                       |                     Descrição                                |
| :------: | :-------------------------------------:     | :-------------------------------------------------------:    |
|  `POST`  | localhost:8080/clientes                 |    Cadastra novo cliente                  |
|  `GET`   | localhost:8080/clientes                   |    Lista de todos os clientes                        |
|  `GET`   | localhost:8080/clientes/:id                 |             Busca cliente por número de registro                                     |
|   `PUT`  |  localhost:8080/clientes/:id        |       Atualizar os dados dos clientes buscando por ID                  |
| `DELETE` |  localhost:8080/clientes/:id        |                      Deletar registro de cliente buscando por ID          |

</div>
<br>

### Métodos POST/GET - *Conta* 
<br>

<div align = "center">

|  Método  |                  Rota                       |                     Descrição                                |
| :------: | :-------------------------------------:     | :-------------------------------------------------------:    |
|  `POST`  | localhost:8080/conta                 |    Cadastra nova conta                  |
|  `GET`   | localhost:8080/conta/:id                 |             Busca conta por número de cpf do cliente                                     |


</div>
<br>

### Métodos POST/GET - *Transação* 
<br>

<div align = "center">

|  Método  |                  Rota                       |                     Descrição                                |
| :------: | :-------------------------------------:     | :-------------------------------------------------------:    |
|  `POST`  | localhost:8080/transacao                 |    Cadastra nova transação                  |
|  `GET`   | localhost:8080/transacao                   |    Lista de todos as transações do cliente                        |

</div>
<br>

## 👩🏿‍🤝‍👨🏾Equipe 01
<br>

<br>

- [Bruno]()

- [Eliza Pimentel](https://www.linkedin.com/in/eliza-pimentel/) 
<br>

- [Marcele Montalvao](https://www.linkedin.com/in/marcele-montalvao/)
<br>

- [Priscila Souza](https://www.linkedin.com/in/prisciladsouza/)
<br>

- [Samuel Leal](https://www.linkedin.com/in/samuelluizrl/)

