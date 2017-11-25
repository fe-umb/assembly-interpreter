import java.util.Scanner;

public class AssemblyLogic {

    public static void assembly() {

        String currentOperation = ""; // operação atual
        String finalEquation = ""; // equação final
        char op1 = '0', op2 = '0'; // operandos

        String[] partitions = new String[26]; // Esse array armazena os trechos de operações

        Scanner s = new Scanner(System.in);

        while (!currentOperation.equals("END")) { // loop infinito enquanto end não for recebido

            currentOperation = s.nextLine().toUpperCase();

            if (!currentOperation.equals("END")) { // operandos são o 4º e o 6 caracter

                op1 = currentOperation.charAt(4);
                op2 = currentOperation.charAt(6);
            }

            switch (currentOperation.substring(0, 3)) { // define a operação baseado nos primeiros três caracteres

                case "ADD":

                    partitions[op1-65] = new StringBuilder(partitions[op1-65]).append(" + ").append(op2).append(')').insert(0, '(').toString();
                    finalEquation = partitions[op1-65];
                    break;

                case "SUB":

                    partitions[op1-65] = new StringBuilder(partitions[op1-65]).append(" - ").append(op2).append(')').insert(0, '(').toString();
                    finalEquation = partitions[op1-65];
                    break;

                case "MPY":

                    partitions[op1-65] = new StringBuilder(partitions[op1-65]).append(" * ").append(op2).append(')').insert(0, '(').toString();
                    finalEquation = partitions[op1-65];
                    break;

                case "DIV":

                    partitions[op1-65] = new StringBuilder(partitions[op1-65]).append(" / ").append(op2).append(')').insert(0, '(').toString();
                    finalEquation = partitions[op1-65];
                    break;

                case "END":

                    for (int i = 0; i < finalEquation.length(); i++) {

                        if ((int) finalEquation.charAt(i) >= 65 && (int) finalEquation.charAt(i) <= 90 && partitions[finalEquation.charAt(i)-65] != null) {
                    
                            finalEquation = new StringBuilder(finalEquation).replace(i, i + 1, partitions[finalEquation.charAt(i)]).toString();
                        }
                    }
                    
                    System.out.println(finalEquation);

                case "MOV":
                    
                    partitions[op1-65] = String.valueOf(op2);
                    break;

                default:
                    break;
            }
        }
    }
}
