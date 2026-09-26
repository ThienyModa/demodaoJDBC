# demodaoJDBC  

Projeto de estudo demonstrando o padrão **DAO (Data Access Object)** com **JDBC** em Java, sobre um banco MySQL com as tabelas `seller` e `department`.  
  
## Objetivo  
  
Implementar um CRUD completo desacoplando a camada de aplicação do JDBC por meio de interfaces e uma factory — o programa depende apenas de `SellerDao`, nunca de `SellerDaoJDBC`.  
  
## Estrutura
src/
├── Application/Program.java # ponto de entrada: testa todas as operações
├── db/
│ ├── DB.java # conexão, leitura do db.properties, close de recursos
│ ├── DbException.java # exceção runtime para SQLException
│ └── DbIntegrityException.java
└── model/
├── entidades/ # Seller, Departament
└── Dao/
├── DaoFactory.java # instancia o DAO injetando a Connection
├── SellerDao.java # contrato CRUD
├── DepartmentDao.java # contrato (sem implementação)
└── IMPL/
└── SellerDaoJDBC.java # implementação JDBC

## Conceitos aplicados  
  
- **Padrão DAO**: interface define o contrato; implementação isolada em `IMPL`  
- **Factory + injeção de dependência**: `DaoFactory.createSellerDao()` retorna a interface com `Connection` injetada no construtor  
- **PreparedStatement**: queries parametrizadas contra SQL injection  
- **RETURN_GENERATED_KEYS**: recupera o id auto-incremento no `insert`  
- **Mapeamento ResultSet → objetos**: `instantiateSeller`/`instantiateDepartament` com `INNER JOIN`  
- **Cache de entidades com `HashMap`**: reutiliza a mesma instância de `Departament` para vários sellers  
- **Exceções checked → runtime**: `SQLException` encapsulada em `DbException`  
- **Config externa**: credenciais em `db.properties`, fora do código  
  
