package br.edu.ifs.ED_20201.fila;

import java.util.Arrays;

public class FilaInteirosInfinita<T> extends FilaSequencial<Integer> {
    private int max;
    private int inicio;
    private int fim;
    private T[] dados;
    private int tamanho;

    public FilaInteirosInfinita(Class<T> dataType) {
        super(Integer.class);
        this.max = 10;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
        this.inicio = -1;
        this.fim = -1;
        this.tamanho = 0;
    }

    @Override
    public void incluir(Integer valor) throws FilaCheiaException {
        expandirFila();

        if (estaCheia()) {

            //System.out.println("Está Cheia!");
            throw new FilaCheiaException("Fila Cheia !");

        } else {
            if (fim == -1) //Se a parte de trás da fila é o fim da matriz, volte para a frente
                inicio = fim = 0;
            else
                fim = (fim + 1) % dados.length;
            dados[fim] = (T) valor;
        }
        tamanho++;
    }

    @Override
    public Integer remover() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila vazia !");
        }
        T element = dados[inicio];
        dados[inicio] = null; // para coleta de lixo

        if (inicio == fim)
            inicio = fim = -1;
        else
            inicio = (inicio + 1) % dados.length;

        tamanho--;
        return (Integer) element;
    }

    @Override
    public int getQtd() {
        //return  100000;

        if (estaVazia())
            return 0;
        else {
            int n = dados.length;

            return ((n + this.fim - this.inicio) % n) + 1;
        }
    }

    @Override
    public int getQtdMaxSuportada() {
        return dados.length;
    }

    @Override
    public boolean estaVazia() {
        return inicio == -1;
        //return getInicio() == -1; pode ser assim tbm
    }

    public boolean estaCheia() {
        return inicio == ((fim + 1) % dados.length);
        //return (getQtd() == getQtdMaxSuportada());
    }

    @Override
    public void limpar() {
         /*
        if (inicio != -1 && fim != -1) {
            inicio = -1;
            fim = -1;
        }
         */

        for (int i = 0; i < getQtdMaxSuportada(); i++) {
            dados[i] = null;

        }

        inicio = -1;
        fim = -1;
        tamanho = 0;
    }

    @Override
    public Integer visualizarProximo() throws FilaVaziaException {
        if (this.estaVazia()) {
            throw new FilaVaziaException("Fila vazia !");
        }
        return (Integer) this.dados[inicio]; //sempre ertorna para visualizar o inicio da fila
    }

    public void expandirFila() { //método para expandir a fila

        if (tamanho == dados.length) {
            T[] newItens = (T[]) new Object[dados.length * 2];
            for (int a = 0; a < dados.length; a++) {
                newItens[a] = dados[ (inicio + a) % dados.length];
            }
            dados = newItens;
            inicio = 0;
            fim = tamanho - 1;
        }

        /*
        if (this.tamanho == this.dados.length) {
            T[] elementosNovos = (T[]) new Object[this.dados.length * 2];
            for (int i = 0; i < this.dados.length; i++) {
                elementosNovos[i] = this.dados[i];
            }
            this.dados = elementosNovos;
        }

         */
    }

    @Override
    public String toString() {
        return "FilaInteirosInfinita{" +
                "max=" + max +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", dados=" + Arrays.toString(dados) +
                ", tamanho=" + tamanho +
                '}';
    }
}
