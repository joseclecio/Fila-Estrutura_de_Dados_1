package br.edu.ifs.ED_20201.ordenacao;

import org.junit.jupiter.api.BeforeEach;

class InsertionSortTest extends OrdenacaoTest {
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        motor = new InsertionSort();
    }
}