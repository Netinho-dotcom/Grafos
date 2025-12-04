# 🔗 Implementação de Grafos em Java

## 📋 Descrição

Este projeto implementa uma estrutura de dados de **Grafo** completa em Java, utilizando **Lista de Adjacências** para representação eficiente. O sistema permite criar, manipular e analisar grafos direcionados e não direcionados, com suporte a algoritmos clássicos de busca e análise.

### Problema
Grafos são fundamentais para modelar relações e conexões em diversos domínios: redes sociais, mapas, redes de computadores, fluxos de trabalho, etc. Este projeto oferece uma solução completa para trabalhar com essas estruturas.

### Solução
Implementação robusta com:
- Representação eficiente usando listas de adjacências
- Algoritmos de busca (BFS e DFS)
- Análise de conectividade e detecção de ciclos
- Interface simples e extensível

---
## Vídeo Explicativo: https://www.youtube.com/watch?v=SBWbc9FP1Uw
---

## 💻 Linguagem e Versão

- **Linguagem:** Java
- **Versão Mínima:** Java 8+
- **Versão Recomendada:** Java 11+

## 🚀 Instruções de Execução

### Compilação

```bash
javac Main.java
```

### Execução

```bash
java Main
```

### Exemplo Completo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/grafos-java.git
cd grafos-java

# Compile
javac Main.java

# Execute
java Main
```

## 📊 Exemplos de Entrada/Saída

### Entrada (no código):

```java
Grafo g1 = new Grafo(5, false);
g1.addAresta(0, 1);
g1.addAresta(0, 4);
g1.addAresta(1, 2);
g1.addAresta(1, 3);
g1.addAresta(1, 4);
g1.addAresta(2, 3);
g1.addAresta(3, 4);
```

### Saída:

```
=== GRAFO NÃO DIRECIONADO ===

Grafo (Não Direcionado):
0 -> 1 4 
1 -> 0 2 3 4 
2 -> 1 3 
3 -> 1 2 4 
4 -> 0 1 3 

BFS: 0 1 4 2 3 
DFS: 0 1 2 3 4 
É conexo? true
Tem ciclo? true
Grau do vértice 1: 4

=== GRAFO DIRECIONADO ===

Grafo (Direcionado):
0 -> 1 2 
1 -> 2 
2 -> 0 3 
3 -> 3 

BFS: 2 0 3 1 
DFS: 2 0 1 3
```

## ✅ Requisitos Implementados

### Requisitos Mínimos
- ✅ Estrutura de dados Grafo com lista de adjacências
- ✅ Operações básicas: adicionar e remover arestas
- ✅ Suporte para grafos direcionados e não direcionados
- ✅ Algoritmo de Busca em Largura (BFS)
- ✅ Algoritmo de Busca em Profundidade (DFS)
- ✅ Método para imprimir o grafo

### Requisitos Avançados
- ✅ Verificação de conectividade do grafo
- ✅ Detecção de ciclos
- ✅ Cálculo do grau de vértices
- ✅ Código bem documentado e organizado
- ✅ Exemplos práticos de uso
- ✅ Tratamento para grafos direcionados e não direcionados

## 📚 Estrutura do Código

```
📁 grafos-java/
├── Main.java           # Classe principal com exemplos
├── Grafo.java         # (integrado no Main.java)
└── README.md          # Este arquivo
```

## 🔧 Funcionalidades

| Método | Descrição |
|--------|-----------|
| `addAresta(origem, destino)` | Adiciona uma aresta entre dois vértices |
| `removeAresta(origem, destino)` | Remove uma aresta |
| `bfs(inicio)` | Busca em Largura a partir de um vértice |
| `dfs(inicio)` | Busca em Profundidade a partir de um vértice |
| `isConexo()` | Verifica se o grafo é conexo |
| `temCiclo()` | Detecta a presença de ciclos |
| `getGrau(vertice)` | Retorna o grau de um vértice |
| `imprimir()` | Imprime a representação do grafo |

