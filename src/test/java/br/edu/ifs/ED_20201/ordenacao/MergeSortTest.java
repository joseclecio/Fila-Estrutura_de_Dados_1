package br.edu.ifs.ED_20201.ordenacao;

import org.junit.jupiter.api.BeforeEach;

class MergeSortTest extends OrdenacaoTest {
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        motor = new MergeSort();
    }
}