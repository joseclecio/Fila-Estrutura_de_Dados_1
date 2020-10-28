package br.edu.ifs.ED_20201.fila.testeFila;

import br.edu.ifs.ED_20201.fila.FilaCheiaException;
import br.edu.ifs.ED_20201.fila.FilaInteirosInfinita;
import br.edu.ifs.ED_20201.fila.FilaVaziaException;

import java.util.Scanner;

public class TesteFilaInteirosInfinita {

    public static void main(String[] args) throws FilaCheiaException, FilaVaziaException {
        FilaInteirosInfinita fila = new FilaInteirosInfinita(Integer.class);

        Scanner leitor = new Scanner(System.in);
        int opc, e;
        String menu =
                "\n1 - Adiciona na fila" +
                "\n2 - Remove da fila" +
                "\n3 - Exibe a fila" +
                "\n4 - Está vazia?"+
                "\n5 - Visualizar próximo da fila"+
                "\n6 - Limpar fila"+
                "\n7 - Sair";

        do {
            System.out.println(menu);
            opc = leitor.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Elemento: ");
                    e = leitor.nextInt();
                    fila.incluir(e);
                    break;
                case 2:
                    System.out.println("Removido o elemento: " + fila.remover());
                    break;
                case 3:
                    System.out.println(fila);
                    break;
                case 4:
                    System.out.println(fila.estaVazia());
                    break;
                case 5:
                    System.out.println("O próximo da fila é: "+fila.visualizarProximo());
                    break;
                case 6:
                    fila.limpar();
                    System.out.println("Fila Limpa!!");
                    break;
                case 7:
                    System.exit(0);
            }
        } while(true);

    }
}
