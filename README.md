[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10825228)
# Nome do projeto
Escreva um ou dois parágrafos resumindo o objetivo do seu projeto.

## Nota base: 11

### App 4/6 (5 pontos) = 3,3
	Protótipo de sistema 4 ✔✔  (uma operacao de cada vez?)
	Robustez do protótipo 2 ❌
	
### Requisitos principais 10,5/21 + 5,5/6 (10 pontos) = 5,9
	Implementação das classes Cliente, Serie, Midia, Filme e PlataformaStreaming 2 ✔✔
	Carga de dados 2 ✔ (sem achar genero, sem busca por nome)
	Cadastro e salvamento 2  ✔ (não salva)
	Audiência da mídia 1  ✔
	Implementação do sistema de avaliação de mídias: uma mídia tem sua avaliação média; 2 ✔✔
	Um cliente não pode avaliar a mesma mídia duas vezes; 1 ❌ (avaliando sem ver)
	Clientes podem ser especialistas, e estes últimos podem adicionar comentários à avaliação; 3 ✔✔ (sem chamada)
	Verificação de especialistas 2  ✔ (sem chamada)
	Os gêneros de mídias devem ser limitados à esta lista 1 ➗ (construtor sem genero)
	Algumas mídias serão marcadas como “Lançamento”. 1 ❌
	Estas mídias só poderão ser assistidas por clientes “profissionais” 2 ❌
	Clientes Profissionais também podem escrever comentários para as mídias assistidas. 2 ❌
	
	Relatórios 5,5/6 
	
		Qual cliente assistiu mais mídias, e quantas mídias; ✔
		Qual cliente tem mais avaliações, e quantas avaliações; ✔ 
		Qual a porcentagem dos clientes com pelo menos 15 avaliações; ✔
		Quais são as 10 mídias com a melhor média de avaliações, vistas pelo menos 100 vezes, decrescente; ✔
		Quais são as 10 mídias com mais visualizações, em ordem decrescente; ✔
		Estes mesmos dois últimos relatórios, porém com as mídias separadas por gênero. ❌
	
### Documentação 6,3/7 (2 pontos) = 1,8
	Documentação de código 3 ✔✔➗
	Diagrama atualizado    2 ✔➗➗ (espec de cliente)
	Backlog 			   2 ✔✔
	
### SOLID - Descontos: 
	
### Apresentação - Peso ou desconto



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

Gêneros restritos (Daniel) ✔ 
Mídias de lançamento e restrição de visualização 
Avanço do app e relatórios iniciados ✔
Qual cliente assistiu mais mídias, e quantas mídias ✔
Qual cliente tem mais avaliações, e quantas avaliações ✔ 
Qual a porcentagem dos clientes com pelo menos 15 avaliações ✔ 
Quais são as 10 mídias de melhor avaliação, com pelo menos 100 avaliações, em ordem decrescente; ✔
Quais são as 10 mídias com mais visualizações, em ordem decrescente ✔ 
Estes mesmos dois últimos relatórios, porém com as mídias separadas por gênero ✔
Testar cliente comentarista/especialista (Se o cliente especialista consegue comentar, se um normal não consegue comentar e se conseguimos transformar um cliente em especialista e comentarista) ✔

Implementar trailers de filmes e séries no catálogo da plataforma. Trailers podem ser visualizados e buscados pelos espectadores, porém não precisam computar audiência e tampouco podem ser colocados em listas para assistir futuramente ou serem avaliados. ✔

Completar o app ✔

## Review 20/06:

- Revisar a exibição de informações nos relatórios ✔
- Fazer a parte do cliente funcionar no menu ✔
- Cadastrar midias com generos para exibir o relatório 
- Checar os reverse do relatório de mais vistos ✔
- Plataforma + app: verificar quando o cliente vira especialista, comentar só se for especialista ✔
