package br.edu.ifs.ED_20201.ordenacao;

import org.junit.jupiter.api.BeforeEach;

class MergeSortSemVetorAuxiliarTest extends OrdenacaoTest {
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        motor = new MergeSortSemVetorAuxiliar();
    }
}