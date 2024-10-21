## Projeto de Aplicação Android: TMDB Movie App

Este projeto é uma aplicação Android para exibir informações sobre filmes utilizando a API do The Movie Database (TMDB).

### 1. Introdução

O objetivo deste projeto é desenvolver uma aplicação Android que permite aos usuários:

* Buscar filmes por título, gênero, data de lançamento, etc.
* Visualizar detalhes de um filme específico, incluindo sinopse, elenco, pôster, trailer, etc.
* Salvar filmes favoritos para acesso rápido.

### 2. Pré-requisitos

* **Android Studio:** Versão mais recente recomendada.
* **Kotlin:** Linguagem de programação utilizada para desenvolvimento Android.
* **API do TMDB:**  Cadastre-se no site TMDB ([https://www.themoviedb.org/](https://www.themoviedb.org/)) e obtenha sua chave API em "Perfil -> Configurações".

### 3. Instalação

1. **Clone este repositório:**
```bash
git clone https://github.com/seu-usuario/tmdb-movie-app.git
```

2. **Importe o projeto no Android Studio:**
    * Abra o Android Studio.
    * Vá em "File -> Open" e selecione o diretório clonado do projeto.

### 4. Configuração

1. **API Key:**
    * Crie na raiz do projeto o arquivo  `\cine-app\apiKey.properties`.
    * Defina o valor da chave API do TMDB na variável `API_KEY`:
    ```kotlin
    const val API_KEY = "sua_api_key"
    ```

2. **URLs base:**
    * As URLs base para a API do TMDB e para as imagens dos filmes estão definidas no arquivo `\cine-app\apiKey.properties`:
    ```kotlin
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w1280"
    ```
### 5. Documentação da API

* **Documentação completa da API do TMDB:** [https://developer.themoviedb.org/docs/getting-started](https://developer.themoviedb.org/docs/getting-started)
* **Informações detalhadas sobre a API de filmes:** [https://developer.themoviedb.org/reference/movie-details](https://developer.themoviedb.org/reference/movie-details)
