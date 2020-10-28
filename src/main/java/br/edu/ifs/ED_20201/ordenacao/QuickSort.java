package br.edu.ifs.ED_20201.ordenacao;

public class QuickSort implements IOrdenacao {

    @Override
    public void ordenar(int[] valores) {
        ordenar(valores, 0, valores.length-1);
    }
    private void trocar(int[] valores, int posA, int posB){
        int temp = valores[posA];
        valores[posA]= valores[posB];
        valores[posB] = temp;
    }
    private void ordenar(int[] valores, int inicio, int fim){
        if ( inicio < fim){
            int posPivo = particao(valores, inicio, fim);
            ordenar(valores, inicio, posPivo);
            ordenar(valores, posPivo+1, fim);
        }
    }

    protected int particao (int[] valores, int inicio, int fim){
        int pivo = valores[(inicio+fim)/2];
        int i = inicio;
        int j = fim;
        while (i < j){
            while (valores[j] > pivo){
                j--;
            }
            while (valores[i] < pivo){
                i++;
            }
            if( i < j ) {
                trocar(valores, i, j);
            }
        }
        return j;
    }


}
