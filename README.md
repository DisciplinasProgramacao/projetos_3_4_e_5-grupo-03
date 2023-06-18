[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10825228)
# Nome do projeto
Escreva um ou dois parágrafos resumindo o objetivo do seu projeto.

# Comentários - Projeto 4

## Nota base: 12

### Comentários

- sem documentação neste arquivo, aqui em cima
- get/sets desnecessários no cliente (encapsulamento)
- usa equals de mídia no cliente, mas mídia não tem equals
- sem toString na mídia para exibir média e outras informacoes
- olhem a confusão: avaliação na mídia e cliente guarda os comentários em separado?
- por definição, um especialista pode comentar. Não tem como negar isso dentro do 'adicionarComentário'. Caso seja negado, precisa voltar para categoria regular.

----
	
- Aderência às classes do diagrama: 1,6/2 pontos
	- Diagrama com arquivo fora do padrão
	- Avaliações na mídia
	
- Requisitos de corretamente implementados: 8,8/14 pontos
    - só pode avaliar o que tiver visto		2/2 pontos
    - avaliar, calcular e exibir media 		1,8/2 pontos
    - cliente não pode avaliar 2x			1/3 pontos
    - especialistas podem comentar			2/4 pontos
    - verificação de especialistas			2/3 pontos
	
- Documentação de código: 1/2 pontos
    - Cliente especialista, avaliação, app.

- Implementação na aula inicial: 0,6/2 pontos (02/05)
    - arquivos JavaDoc  ✔️
    - diagrama atualizado ❌
    - backlog de pendências ❌

----

## Alunos integrantes da equipe
* Vitor Lany Freitas Ferreira
* Augusto Baldiotti Mendonça Alvares
* Daniel de Rezende Leão
* Caio Elias Rodrigues Araujo


## Professores responsáveis

* João Caram Santos de Oliveira

## Documentação ✔
Atualização do diagrama UML ✔ 
Implementação e teste da classe PlataformaStreaming ✔ 
Método(s) para carregamento dos dados ✔ 
Criação de um pequeno aplicativo para chamar o carregamento dos dados ✔ 
Classe filme e carga do catálogo de filmes ✔ 
Primeira versão do protótipo do aplicativo ✔ 
Cadastro de novas entidades ✔ 
Salvar dados das entidades ✔ 
Robustez no sistema principal ✔ 
Implementação e teste da classe avaliação ✔ 
Finalizar documentação ✔ 
Gerar javadoc ✔ 

## Novos Requisitos:

Gêneros restritos (Daniel) ✔ (Perguntar ao Caram se temos que fornecer um método para cadastrar junto das midias a categiria)
Mídias de lançamento e restrição de visualização (Caio)
Avanço do app e relatórios iniciados (Augusto)
Existem mídias restritas marcadas como “lançamento”. Somente os clientes profissionais podem fazer operações com estas mídias (Vitor) 
Qual cliente assistiu mais mídias, e quantas mídias (Daniel)
Qual cliente tem mais avaliações, e quantas avaliações (Caio)
Qual a porcentagem dos clientes com pelo menos 15 avaliações (Augusto)
Quais são as 10 mídias de melhor avaliação, com pelo menos 100 avaliações, em ordem decrescente; (Vitor)
Quais são as 10 mídias com mais visualizações, em ordem decrescente (Daniel, Caio, Augusto, Vitor)
Estes mesmos dois últimos relatórios, porém com as mídias separadas por gênero (Daniel, Caio, Augusto, Vitor)

Testar cliente comentarista/especialista (Se o cliente especialista consegue comentar, se um normal não consegue comentar e se conseguimos transformar um cliente em especialista e comentarista)

Implementar trailers de filmes e séries no catálogo da plataforma. Trailers podem ser visualizados e buscados pelos espectadores, porém não precisam computar audiência e tampouco podem ser colocados em listas para assistir futuramente ou serem avaliados.

Completar o app

