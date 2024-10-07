 Modelgaem API Rede social

Nomes: Cauã Loch,João Daniel de Liz, João Gabriel Rosso e Vinícius Teixeira Colombo.

## Casos de Uso:
1. Acessar informações de um usuário
2. Manipular os posts de um usuário

## Recursos:
- **usuários**
- **posts**

## Pontos Finais

| Descrição                | URI                                         | Método HTTP | Corpo                                | Resposta Esperada | Erros Esperados                              |
|--------------------------|---------------------------------------------|-------------|--------------------------------------|-------------------|----------------------------------------------|
| Retornar um usuário       | GET /usuarios/{usuario-id}                  | GET         | Vazio                                | 200 OK            | 404 Not Found - usuário não foi encontrado.  |
| Retornar posts de um usuário | GET /usuarios/{usuario-id}/posts            | GET         | Vazio                                | 200 OK            | 404 Not Found - usuário não foi encontrado.  |
| Retornar um post específico | GET /usuarios/{usuario-id}/posts/{post-id}  | GET         | Vazio                                | 200 OK            | 404 Not Found - post não foi encontrado.     |
| Inserir um novo post      | POST /usuarios/{usuario-id}/posts           | POST        | { "conteudo": "Novo post!" }         | 201 Created       | 404 Not Found - usuário não foi encontrado.  |
| Atualizar um post         | PUT /usuarios/{usuario-id}/posts/{post-id}  | PUT         | { "conteudo": "Conteúdo atualizado" }| 200 OK            | 404 Not Found - post não foi encontrado.     |
| Apagar um post            | DELETE /usuarios/{usuario-id}/posts/{post-id}| DELETE      | Vazio                                | 200 OK            | 404 Not Found - post não foi encontrado.     |