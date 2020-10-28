package br.edu.ifs.ED_20201.ordenacao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


class QuickSortTest extends OrdenacaoTest {
    @Override
    @BeforeEach
    @Timeout(value = 5, unit =  TimeUnit.SECONDS)
    public void setUp() {
        super.setUp();
        motor = new QuickSort();
    }

}