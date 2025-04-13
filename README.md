# Integração MySQL + Java (Spring Boot)
## Configurações do Projeto
- Projeto feito com Maven
- Java 21
- **Dependências**: Spring Web, Spring Data JPA, MySQL Driver, Lombok
## Estrutura do Projeto
```css
biblioteca/
├── src/main/java/com/exemplo/biblioteca/
│   ├── model/          → Entidades JPA
│   ├── repository/     → Interfaces CRUD
│   ├── controller/     → Endpoints REST
│   └── BibliotecaApplication.java
└── src/main/resources/
    └── application.properties
```
## Executando a aplicação
```bash
mvn spring-boot:run
```