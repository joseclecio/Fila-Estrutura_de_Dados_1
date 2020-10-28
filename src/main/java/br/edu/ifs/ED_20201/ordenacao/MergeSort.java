package br.edu.ifs.ED_20201.ordenacao;

public class MergeSort implements IOrdenacao {

    @Override
    public void ordenar(int valores[]) {
        ordenar(valores, 0, valores.length - 1);
    }
    private void ordenar(int valores[], int inicio, int fim) {
        if ( inicio < fim) {
            int meio = (inicio + fim) / 2;
            ordenar(valores, inicio, meio);
            ordenar(valores, meio + 1, fim);
            juntar(valores, inicio, meio, fim);
        }
    }

    private void juntar(int[] valores, int inicio, int meio, int fim) {
        int inicioValoresEsquerda = inicio;
        int fimValoresEsquerda = meio;
        int inicioValoresDireita = meio +1;
        int fimValoresDireita = fim;
        int[] vetorTemporario = new int[fim-inicio+1];
        int posTemp = 0;
        while (inicioValoresEsquerda <= meio && inicioValoresDireita <=fim){
            if(valores[inicioValoresEsquerda] < valores[inicioValoresDireita] ){
                vetorTemporario[posTemp] = valores[inicioValoresEsquerda];
                inicioValoresEsquerda++;
            } else {
                vetorTemporario[posTemp] = valores[inicioValoresDireita];
                inicioValoresDireita++;
            }
            posTemp++;
        }
        for(int i = inicioValoresEsquerda; i <= meio; i++){
            vetorTemporario[posTemp] = valores[i];
            posTemp++;
        }
        for(int i = inicioValoresDireita; i <= fim; i++){
            vetorTemporario[posTemp] = valores[i];
            posTemp++;
        }
        for(int i = 0; i < posTemp; i ++){
            valores[inicio+i] = vetorTemporario[i];
        }
    }
}
