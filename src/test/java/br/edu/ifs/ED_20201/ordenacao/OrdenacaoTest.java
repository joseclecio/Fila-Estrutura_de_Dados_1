package br.edu.ifs.ED_20201.ordenacao;

import org.junit.jupiter.api.Timeout;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 5, unit =  TimeUnit.SECONDS)
public abstract class OrdenacaoTest {



    protected IOrdenacao motor;
    public void setUp() {

    }


    final int[] SAIDA_ESPERADA = new int[]{1,2,3,4,5,6,7,8,9,10};
    @org.junit.jupiter.api.Test
    @Timeout(value = 5, unit =  TimeUnit.SECONDS)
    public void ordenarEntradaCrescenteTest() {
        int[] entrada = new int[]{1,2,3,4,5,6,7,8,9,10};
        motor.ordenar(entrada);
        assertArrayEquals(SAIDA_ESPERADA, entrada);
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 5, unit =  TimeUnit.SECONDS)
    public void ordenarEntradaDecrescenteTest() {
        int[] entrada = new int[]{10,9,8,7,6,5,4,3,2,1};
        motor.ordenar(entrada);
        assertArrayEquals(SAIDA_ESPERADA, entrada);
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 5, unit =  TimeUnit.SECONDS)
    public void ordenarEntradaAleatoriaTest() {
        int[] entrada = new int[]{10,1,9,2,3,8,4,7,6,5};
        motor.ordenar(entrada);
        assertArrayEquals(SAIDA_ESPERADA, entrada);
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 5, unit =  TimeUnit.SECONDS)
    public void ordenarEntradaAleatoriaComRepeticaoDadosTest() {
        int[] entrada = new int[]{10,5,2,3,8,4,7,6,5,10};
        int[] saida   = new int[]{2,3,4,5,5,6,7,8,10,10};
        motor.ordenar(entrada);
        assertArrayEquals(saida, entrada);
    }
    @org.junit.jupiter.api.Test
    @Timeout(value = 5, unit =  TimeUnit.SECONDS)
    public void ordenarEntradaVaziaTest() {
        int[] entrada = new int[0];
        int[] saida   = new int[0];
        motor.ordenar(entrada);
        assertArrayEquals(saida, entrada);
    }
}