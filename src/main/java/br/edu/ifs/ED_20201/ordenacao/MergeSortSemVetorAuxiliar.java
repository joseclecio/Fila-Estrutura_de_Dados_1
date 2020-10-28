/*
 * @(#)MergeSortAlgorithm.java	1.0 95/06/23 Jason Harrison
 *
 * Copyright (c) 1995 University of British Columbia
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * UBC MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UBC SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

/**
 * A merge sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author Jason Harrison@cs.ubc.ca
 * @version 	1.1, 12 Jan 1998
 */
package br.edu.ifs.ED_20201.ordenacao;

public class MergeSortSemVetorAuxiliar implements IOrdenacao {

    @Override
    public void ordenar(int valores[]) {
        ordenar(valores, 0, valores.length - 1);

    }
    private void ordenar(int valores[], int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }
        int meio = (inicio + fim) / 2;

        ordenar(valores, inicio, meio);
        ordenar(valores, meio + 1, fim);

        int fimListaA = meio;
        int inicioListaB = meio + 1;
        while ((inicio <= fimListaA) && (inicioListaB <= fim)) {

            if (valores[inicio] < valores[inicioListaB]) {
                inicio++;
            } else {
                int menorValor = valores[inicioListaB];
                for (int k = inicioListaB - 1; k >= inicio; k--) {
                    valores[k+1] = valores[k];
                }
                valores[inicio] = menorValor;
                inicio++;
                fimListaA++;
                inicioListaB++;
            }
        }
    }
}
