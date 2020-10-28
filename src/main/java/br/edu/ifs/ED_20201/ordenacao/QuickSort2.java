/*
 * @(#)QSortAlgorithm.java	1.6f 95/01/31 James Gosling
 *
 * Copyright (c) 1994-1995 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL or COMMERCIAL purposes and
 * without fee is hereby granted.
 * Please refer to the file http://java.sun.com/copy_trademarks.html
 * for further important copyright and trademark information and to
 * http://java.sun.com/licensing.html for further important licensing
 * information for the Java (tm) Technology.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
 * CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
 * PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
 * NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
 * SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
 * SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
 * PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES").  SUN
 * SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
 * HIGH RISK ACTIVITIES.
 */

/**
 * A quick sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author James Gosling
 * @version 	1.6f, 31 Jan 1995
 */
/**
 * 19 Feb 1996: Fixed to avoid infinite loop discoved by Paul Haeberli.
 *              Misbehaviour expressed when the pivot element was not unique.
 *              -Jason Harrison
 *
 * 21 Jun 1996: Modified code based on comments from Paul Haeberli, and
 *              Peter Schweizer (Peter.Schweizer@mni.fh-giessen.de).
 *              Used Daeron Meyer's (daeron@geom.umn.edu) code for the
 *              new pivoting code. - Jason Harrison
 *
 * 09 Jan 1998: Another set of bug fixes by Thomas Everth (everth@wave.co.nz)
 *              and John Brzustowski (jbrzusto@gpu.srv.ualberta.ca).
 *
 * 09 Out 2020: Tradução para o português, remoção de comentários e
 *              exception
 */


package br.edu.ifs.ED_20201.ordenacao;

public class QuickSort2 implements IOrdenacao {
    @Override
    public void ordenar(int[] valores) {
        ordenar(valores, 0, valores.length-1);
    }
    public void ordenar(int[] valores, int inicio, int fim) {
        int lo = inicio;
        int hi = fim;
        if (lo >= hi) {
            return;
        }
        else if( lo == hi - 1 ) {
            if (valores[lo] > valores[hi]) {
                int T = valores[lo];
                valores[lo] = valores[hi];
                valores[hi] = T;
            }
            return;
        }
        int pivot = valores[(lo + hi) / 2];
        valores[(lo + hi) / 2] = valores[hi];
        valores[hi] = pivot;

        while( lo < hi ) {

            while (valores[lo] <= pivot && lo < hi) {
                lo++;
            }

            while (pivot <= valores[hi] && lo < hi ) {
                hi--;
            }

            if( lo < hi ) {
                int T = valores[lo];
                valores[lo] = valores[hi];
                valores[hi] = T;
            }
        }


        valores[fim] = valores[hi];
        valores[hi] = pivot;

        ordenar(valores, inicio, lo-1);
        ordenar(valores, hi+1, fim);
    }
}