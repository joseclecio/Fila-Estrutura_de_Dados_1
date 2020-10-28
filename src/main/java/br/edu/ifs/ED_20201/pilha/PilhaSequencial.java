package br.edu.ifs.ED_20201.pilha;

public class PilhaSequencial<T> implements IPilha<T>{

    public PilhaSequencial(Class<T> dataType){
        this.max = 10;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
        this.qtd = -1;
    }
    T[] dados;
    int qtd;
    int max;
    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        if (getQtd() < max){
            dados[++qtd] = valor;
        }
        else {
            throw new PilhaCheiaException();
        }
    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        if ( estahVazia() ){
            throw new PilhaVaziaException();
        } else{
            T temp = dados[qtd];
            qtd--;
            return temp;
        }
    }

    @Override
    public T getTopo() throws PilhaVaziaException{
        if ( estahVazia() ){
            throw new PilhaVaziaException();
        } else{
            return dados[qtd];
        }
    }

    @Override
    public int getQtd() {
        return qtd +1;
    }

    @Override
    public boolean estahVazia() {
        return getQtd() == 0;
    }
}
