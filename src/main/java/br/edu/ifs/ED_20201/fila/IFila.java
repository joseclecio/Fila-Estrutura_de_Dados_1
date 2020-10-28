package br.edu.ifs.ED_20201.fila;

public interface IFila<T> {
    public void incluir(T valor) throws FilaCheiaException;
    public T remover() throws FilaVaziaException;
    public int getQtd();
    public int getQtdMaxSuportada();
    public boolean estaVazia();
    public void limpar();
    public T visualizarProximo() throws FilaVaziaException;
}
