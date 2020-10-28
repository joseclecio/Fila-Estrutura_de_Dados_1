package br.edu.ifs.ED_20201.fila;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;
class FilaInteirosTest {

    FilaInteiros fila;
    @BeforeEach
    void setUp() {
        fila = new FilaInteiros();
    }

    @Test
    void incluir_UmElemento() throws FilaCheiaException, FilaVaziaException {
        fila.incluir(1);
        assertThat(fila.getQtd()).isEqualTo(1);
        assertThat(fila.remover()).isEqualTo(1);
    }

    @Test
    void incluir_MaisDeUmElemento() throws FilaCheiaException, FilaVaziaException {
        for(int i = 0; i < 5; i++){
            fila.incluir(i);
        }
        assertThat(fila.getQtd()).isEqualTo(5);
        assertThat(fila.remover()).isEqualTo(0);
        int get_qtd = fila.getQtd();
        for(int i = 0; i < get_qtd; i++){
            assertThat(fila.remover()).isEqualTo(i+1);
        }
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    void remover_MaisQueOPossivel() throws FilaCheiaException, FilaVaziaException {
        fila.incluir(1);
        fila.remover();
        assertThatExceptionOfType(FilaVaziaException.class).isThrownBy(() -> fila.remover());
        assertThat(fila.estaVazia()).isTrue();
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    void remover() throws FilaCheiaException, FilaVaziaException {
        for(int i =0; i < 5; i++){
            fila.incluir(i);
        }
        for(int i = 0; i < 5; i++) {
            assertThat(fila.remover()).isEqualTo(i);
        }
    }

    @Test
    void getQtd_FilaVaziaTest() {
        assertThat(fila.getQtd()).isEqualTo(0);
    }

    @Test
    void estaVazia_FilaVaziaTest() {
        assertThat(fila.estaVazia()).isTrue();
    }

    @Test
    void limpar_FilaComItensTest() throws FilaCheiaException {
        fila.incluir(1);
        fila.limpar();
        assertThat(fila.estaVazia()).isTrue();
        assertThat(fila.getQtd()).isZero();;
    }

    @Test
    void limpar_FilaVazia() {
        fila.limpar();
        assertThat(fila.estaVazia()).isTrue();
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    void visualizarProximo() {
    }
}