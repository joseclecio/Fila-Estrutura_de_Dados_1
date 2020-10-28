package br.edu.ifs.ED_20201.pilha;

import br.edu.ifs.ED_20201.pilha.PilhaCheiaException;
import br.edu.ifs.ED_20201.pilha.PilhaInteiro;
import br.edu.ifs.ED_20201.pilha.PilhaVaziaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class PilhaInteiroTest {

    IPilha<Integer> pilha;
    @BeforeEach
    void setUp() {
        pilha = new PilhaInteiro();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void empilhar_1Elemento_ComPilhaVaziaTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        assertThat(pilha.getTopo()).isEqualTo(1);
        assertThat(pilha.getQtd()).isEqualTo(1);
    }
    @Test
    void empilhar_NElementosTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        assertThat(pilha.getTopo()).isEqualTo(1);

        pilha.empilhar(2);
        assertThat(pilha.getTopo()).isEqualTo(2);
        pilha.empilhar(3);
        assertThat(pilha.getTopo()).isEqualTo(3);
        assertThat(pilha.getQtd()).isEqualTo(3);
    }


    @Test
    void desempilhar() throws PilhaVaziaException, PilhaCheiaException {
        int i = 0;
        for(; i< 3; i++) {
            pilha.empilhar(i);
        }
        while (!pilha.estahVazia()){
            assertThat(pilha.getQtd()).isEqualTo(i);
            assertThat(pilha.desempilhar()).isEqualTo(--i);
        }
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.desempilhar());
    }

    @Test
    void desempilhar_MaisQueOPossivelTest() throws PilhaVaziaException, PilhaCheiaException {
        for(int i = 0; i< 3; i++) {
            pilha.empilhar(i);
        }
        for(int i = 0; i< 3; i++) {
            pilha.desempilhar();
        }

        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.desempilhar());
    }
    @Test
    void desempilhar_PilhaVaziaErrorTest() {
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.desempilhar());
    }

    @Test
    void pilhaCheiaExceptionTest() throws PilhaCheiaException {
        for( int i =0; i < 10; i++){
            pilha.empilhar(i);
        }
        assertThatExceptionOfType(PilhaCheiaException.class).isThrownBy(() -> pilha.empilhar(10));
    }

    @Test
    void getTopo_0ElementoTest() {
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.getTopo());
    }

    @Test
    void getTopo_1ElementoTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        assertThat(pilha.getTopo()).isEqualTo(1);
    }


    @Test
    void getQtd_Pilha_1_ElementoTest() throws PilhaCheiaException {
        pilha.empilhar(1);
        assertThat(pilha.getQtd()).isEqualTo(1);
    }
    @Test
    void getQtd_Pilha_0_ElementosTest() {
        assertThat(pilha.getQtd()).isEqualTo(0);
    }

    @Test
    void estahVazia_NaConstrucaoTest() {
        assertThat(pilha.estahVazia()).isEqualTo(true);
        assertThatExceptionOfType(PilhaVaziaException.class).isThrownBy(() -> pilha.getTopo());

    }
    @Test
    void estahVazia_PosRemocaoTest() throws PilhaCheiaException, PilhaVaziaException {
        pilha.empilhar(1);
        pilha.desempilhar();
        assertThat(pilha.estahVazia()).isEqualTo(true);
    }

    @Test
    void naoEstahVazia_PosInclusao() throws PilhaCheiaException {
        pilha.empilhar(1);
        assertThat(pilha.estahVazia()).isEqualTo(false);
    }
}