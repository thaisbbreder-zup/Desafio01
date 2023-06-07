/*
1. Solicitar que o usuário escolha o nível:
    fácil (números de 1 a 10),
    médio (números de 1 a 50)
    difícil (números de 1 a 100).
2. Gerar um número aleatório acordo com o nível escolhido.
3. Solicitar que o usuário informe um número inteiro.
        3.1 Se for o mesmo número, o usuário ganha 10 pontos.
        3.2 Se for diferente, comparar os dois números:
        3.2.1 Se for um número maior ou um número menor, o usuário ganha 5 pontos.
        3.2.2 Senão, o usuário perde.
  ps: se for um número fora do intervalo definido pelo nível: ERRO
4. Exibir o resultado
5. Perguntar se deseja jogar novamente.
        5.1 Sim: reiniciar e acumular a pontuação.
        5.2 Não: Exibir a pontuação, os números corretos e os errados;
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumeroAleatorio {
    public static void main(String[] args) {
        System.out.println("----------------- ADIVINHE O NÚMERO QUE ESTOU PENSANDO----------------- ");

        Scanner entradaDoUsuario = new Scanner(System.in);

        //variáveis
        int numAleatorio = 0;
        int pontuacaoFinal = 0;
        boolean jogarNovamente = true;
        List<Integer> respostaUsuario = new ArrayList<>();
        List<Integer> respostaSistema = new ArrayList<>();
        int[] limiteSuperior = new int[]{10, 50, 100};

        //gerador de números aleatorios
        Random gerador = new Random();

        do {
            int nivel;
            int numUsuario;
            boolean entradaNivelInvalido = true;
            boolean entradaValorInvalido = true;
            do {
                //pergunta o nível
                System.out.println("\nVamos começar o jogo!" +
                        "\nDigite 1 para FÁCIL " +
                        "\nDigite 2 para MÉDIO " +
                        "\nDigite 3 para DÍFICL");
                nivel = entradaDoUsuario.nextInt();

                if (nivel < 1 || nivel > 3) {
                    entradaNivelInvalido = true;
                    System.out.println("----- ERRO: Digite um nível válido! -----");
                } else {
                    entradaNivelInvalido = false;
                }
            } while (entradaNivelInvalido);

            //pergunta o número
            do {
                System.out.printf("\nEscolha um número entre 0 e %d: ", limiteSuperior[nivel - 1]);
                numUsuario = entradaDoUsuario.nextInt();

                if (numUsuario < 0 || numUsuario > limiteSuperior[nivel - 1]) {
                    System.out.println("----- ERRO: O número escolhido está fora dos limites do nível! -----");
                    entradaValorInvalido = true;
                } else {
                    entradaValorInvalido = false;
                }
            } while (entradaValorInvalido);
            respostaUsuario.add(numUsuario);

            //gera um número de acordo com o nível
            System.out.print("Número gerado: ");
            if (nivel == 1) {
                numAleatorio = gerador.nextInt(11);
            } else if (nivel == 2) {
                numAleatorio = gerador.nextInt(51);
            } else if (nivel == 3) {
                numAleatorio = gerador.nextInt(101);
            }
            System.out.print(numAleatorio);
            respostaSistema.add(numAleatorio);

            // compara se o numero informado pelo usuário é igual ao número aleatório
            if (numUsuario == numAleatorio) {
                pontuacaoFinal += 10;
                System.out.println("\nParabéns! Você acertou e acumulou 10 pontos!!!");
                 //compara se o número informado é 1 número maior ou menor que o aleatório
            } else if (numUsuario == numAleatorio + 1 || numUsuario == numAleatorio - 1) {
                pontuacaoFinal = 5;
                System.out.println("\nUauuu, passou perto!! Você acumulou 5 pontos!!!");
             } else {
                System.out.println("\nQue pena, você errou e não acumulou pontos =(");
             }

            System.out.println("\nDeseja jogar novamente? " +
                    "\nDigite 1 para SIM " +
                    "\nDigite 2 para NÃO");
            int opcao = entradaDoUsuario.nextInt();

            if (opcao == 1) {
                jogarNovamente = true;
            } else {
                jogarNovamente = false;

            }
        } while (jogarNovamente);

        System.out.println("\nFinalizamos o jogo. " +
                "\nOs números que voce escolheu foram: " + respostaUsuario +
                "\nOs números que o sistema escolheu foram: " + respostaSistema +
                "\nSua pontuação final foi de " + pontuacaoFinal + " pontos!");
    }
}


