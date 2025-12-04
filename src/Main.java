import java.util.*;

// Classe que representa um Grafo usando Lista de Adjacências
class Grafo {
    private int numVertices;
    private LinkedList<Integer>[] adjList;
    private boolean direcionado;

    // Construtor
    public Grafo(int vertices, boolean direcionado) {
        this.numVertices = vertices;
        this.direcionado = direcionado;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Adiciona uma aresta entre dois vértices
    public void addAresta(int origem, int destino) {
        adjList[origem].add(destino);
        if (!direcionado) {
            adjList[destino].add(origem);
        }
    }

    // Remove uma aresta
    public void removeAresta(int origem, int destino) {
        adjList[origem].remove(Integer.valueOf(destino));
        if (!direcionado) {
            adjList[destino].remove(Integer.valueOf(origem));
        }
    }

    // Busca em Largura (BFS)
    public void bfs(int inicio) {
        boolean[] visitado = new boolean[numVertices];
        Queue<Integer> fila = new LinkedList<>();

        visitado[inicio] = true;
        fila.add(inicio);

        System.out.print("BFS: ");
        while (!fila.isEmpty()) {
            int v = fila.poll();
            System.out.print(v + " ");

            for (int adj : adjList[v]) {
                if (!visitado[adj]) {
                    visitado[adj] = true;
                    fila.add(adj);
                }
            }
        }
        System.out.println();
    }

    // Busca em Profundidade (DFS)
    public void dfs(int inicio) {
        boolean[] visitado = new boolean[numVertices];
        System.out.print("DFS: ");
        dfsUtil(inicio, visitado);
        System.out.println();
    }

    private void dfsUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(v + " ");

        for (int adj : adjList[v]) {
            if (!visitado[adj]) {
                dfsUtil(adj, visitado);
            }
        }
    }

    // Verifica se o grafo é conexo
    public boolean isConexo() {
        boolean[] visitado = new boolean[numVertices];
        dfsUtil(0, visitado);

        for (boolean v : visitado) {
            if (!v) return false;
        }
        return true;
    }

    // Detecta ciclo em grafo não direcionado
    public boolean temCiclo() {
        boolean[] visitado = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                if (temCicloUtil(i, visitado, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean temCicloUtil(int v, boolean[] visitado, int pai) {
        visitado[v] = true;

        for (int adj : adjList[v]) {
            if (!visitado[adj]) {
                if (temCicloUtil(adj, visitado, v)) {
                    return true;
                }
            } else if (adj != pai) {
                return true;
            }
        }
        return false;
    }

    // Imprime o grafo
    public void imprimir() {
        System.out.println("\nGrafo (" + (direcionado ? "Direcionado" : "Não Direcionado") + "):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            for (int adj : adjList[i]) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }

    // Obtém grau de um vértice
    public int getGrau(int v) {
        return adjList[v].size();
    }
}

// Classe principal com exemplos
public class Main {
    public static void main(String[] args) {
        // Exemplo 1: Grafo não direcionado
        System.out.println(" GRAFO NÃO DIRECIONADO ");
        Grafo g1 = new Grafo(5, false);
        g1.addAresta(0, 1);
        g1.addAresta(0, 4);
        g1.addAresta(1, 2);
        g1.addAresta(1, 3);
        g1.addAresta(1, 4);
        g1.addAresta(2, 3);
        g1.addAresta(3, 4);

        g1.imprimir();
        g1.bfs(0);
        g1.dfs(0);
        System.out.println("É conexo? " + g1.isConexo());
        System.out.println("Tem ciclo? " + g1.temCiclo());
        System.out.println("Grau do vértice 1: " + g1.getGrau(1));

        // Exemplo 2: Grafo direcionado
        System.out.println("\nGRAFO DIRECIONADO ");
        Grafo g2 = new Grafo(4, true);
        g2.addAresta(0, 1);
        g2.addAresta(0, 2);
        g2.addAresta(1, 2);
        g2.addAresta(2, 0);
        g2.addAresta(2, 3);
        g2.addAresta(3, 3);

        g2.imprimir();
        g2.bfs(2);
        g2.dfs(2);
    }
}