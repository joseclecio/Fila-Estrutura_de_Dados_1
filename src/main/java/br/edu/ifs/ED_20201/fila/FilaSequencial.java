package br.edu.ifs.ED_20201.fila;

public class FilaSequencial<T> implements IFila<T> {
    private int max;
    private int inicio;
    private int fim;
    private T[] dados;
    public FilaSequencial(Class<T> dataType){
        this.max = 10;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
        this.inicio = -1;
        this.fim=-1;
    }
    public void incluir(T valor) throws FilaCheiaException {

    }
    public T remover() throws FilaVaziaException{
        return null;

    }
    public int getQtd() {
        return  100000;
    }

    @Override
    public int getQtdMaxSuportada() {
        return 0;
    }

    public boolean estaVazia() {
        return false;
    }
    public void limpar(){

    }

    public T visualizarProximo() throws FilaVaziaException{
        return null;
    }

}
