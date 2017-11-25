import java.util.Scanner;

public class InterpretadorLogic {

        static String exp = "";
        static String assembly = "";
        static int varCounter = 0;
        static int globalCounter = 0;

    public static void equation() {


        Scanner s = new Scanner(System.in);
        
        exp = s.nextLine();
        
        char op;

        for (int i = exp.length() - 1; i > 0; i--) { // Primeiro for loop

            if (exp.charAt(i) == '(') { // Operações dentro de ()

                if (exp.charAt(i + 1) == 'R') {
                    op = exp.charAt(i + 3); // define a operação encontrada dentro dos ()
                } else {
                    op = exp.charAt(i + 2);
                }

                switch (op) { // Ao entrar no switch, 'i' guarda a posição do último parênteses da equação

                    case '/':

                        div(i);
                        break;

                    case '*':

                        mpy(i);
                        break;

                    case '-':

                        sub(i);
                        break;

                    case '+':

                        add(i);
                        break;

                    default:
                        break;
                }
            } // Operações dentro de ()
        }// Primeiro for loop

        exp = String.valueOf(new StringBuilder(exp).deleteCharAt(0)); // Remove primeiro (
        exp = String.valueOf(new StringBuilder(exp).deleteCharAt(exp.length() - 1)); // Remove último )
        System.out.println(exp);

        do {

            for (int i = exp.length() - 1; i > 0; i--) {

                if (exp.charAt(i) == '/') {

                    varCounter++;

                    globalCounter += 10;
                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?
                    
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 2) + exp.charAt(i - 1));
                    } else {
                        
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 1));
                    }

                    globalCounter += 10;
                    assembly = assembly.concat("\n" + globalCounter + " DIV " + "R" + varCounter + ", ");

                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?

                        if (exp.charAt(i + 1) != 'R') { // Segundo operando não é um registrador?

                            assembly += exp.charAt(i + 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 2, ("R" + varCounter)).toString();

                        } else { // Segundo operando é um registrador?

                            assembly += exp.charAt(i - 2);
                            assembly += exp.charAt(i - 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 3, ("R" + varCounter)).toString();
                        }

                    } else if (exp.charAt(i + 1) == 'R') { // Segundo operando é um registrador? O primeiro já não é

                        assembly += exp.charAt(i + 1);
                        assembly += exp.charAt(i + 2);
                        exp = new StringBuilder(exp).replace(i - 1, i +32, ("R" + varCounter)).toString();

                    } else { // Nem o primeiro, nem o segundo operando, são registradores.

                        assembly += exp.charAt(i + 1);
                        exp = new StringBuilder(exp).replace(i - 1, i + 2, ("R" + varCounter)).toString();
                    }
                    
                    System.out.println(exp);
                }
            }
            
            for (int i = exp.length() - 1; i > 0; i--) {

                if (exp.charAt(i) == '*') {

                    varCounter++;

                    globalCounter += 10;
                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?
                    
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 2) + exp.charAt(i - 1));
                    } else {
                        
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 1));
                    }

                    globalCounter += 10;
                    assembly = assembly.concat("\n" + globalCounter + " MPY " + "R" + varCounter + ", ");

                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?

                        if (exp.charAt(i + 1) != 'R') { // Segundo operando não é um registrador?

                            assembly += exp.charAt(i + 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 2, ("R" + varCounter)).toString();

                        } else { // Segundo operando é um registrador?

                            assembly += exp.charAt(i - 2);
                            assembly += exp.charAt(i - 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 3, ("R" + varCounter)).toString();
                        }

                    } else if (exp.charAt(i + 1) == 'R') { // Segundo operando é um registrador? O primeiro já não é

                        assembly += exp.charAt(i + 1);
                        assembly += exp.charAt(i + 2);
                        exp = new StringBuilder(exp).replace(i - 1, i +32, ("R" + varCounter)).toString();

                    } else { // Nem o primeiro, nem o segundo operando, são registradores.

                        assembly += exp.charAt(i + 1);
                        exp = new StringBuilder(exp).replace(i - 1, i + 2, ("R" + varCounter)).toString();
                    }
                    
                    System.out.println(exp);
                }
            }
            
            for (int i = exp.length() - 1; i > 0; i--) {

                if (exp.charAt(i) == '-') {

                    varCounter++;

                    globalCounter += 10;
                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?
                    
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 2) + exp.charAt(i - 1));
                    } else {
                        
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 1));
                    }

                    globalCounter += 10;
                    assembly = assembly.concat("\n" + globalCounter + " SUB " + "R" + varCounter + ", ");

                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?

                        if (exp.charAt(i + 1) != 'R') { // Segundo operando não é um registrador?

                            assembly += exp.charAt(i + 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 2, ("R" + varCounter)).toString();

                        } else { // Segundo operando é um registrador?

                            assembly += exp.charAt(i - 2);
                            assembly += exp.charAt(i - 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 3, ("R" + varCounter)).toString();
                        }

                    } else if (exp.charAt(i + 1) == 'R') { // Segundo operando é um registrador? O primeiro já não é

                        assembly += exp.charAt(i + 1);
                        assembly += exp.charAt(i + 2);
                        exp = new StringBuilder(exp).replace(i - 1, i +32, ("R" + varCounter)).toString();

                    } else { // Nem o primeiro, nem o segundo operando, são registradores.

                        assembly += exp.charAt(i + 1);
                        exp = new StringBuilder(exp).replace(i - 1, i + 2, ("R" + varCounter)).toString();
                    }
                    
                    System.out.println(exp);
                }
            }
            
            for (int i = exp.length() - 1; i > 0; i--) {

                if (exp.charAt(i) == '+') {

                    varCounter++;

                    globalCounter += 10;
                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?
                    
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 2) + exp.charAt(i - 1));
                    } else {
                        
                        assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i - 1));
                    }

                    globalCounter += 10;
                    assembly = assembly.concat("\n" + globalCounter + " ADD " + "R" + varCounter + ", ");

                    if (exp.charAt(i - 2) == 'R') { // Primeiro operando é um registrador?

                        if (exp.charAt(i + 1) != 'R') { // Segundo operando não é um registrador?

                            assembly += exp.charAt(i + 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 2, ("R" + varCounter)).toString();

                        } else { // Segundo operando é um registrador?

                            assembly += exp.charAt(i - 2);
                            assembly += exp.charAt(i - 1);
                            exp = new StringBuilder(exp).replace(i - 2, i + 3, ("R" + varCounter)).toString();
                        }

                    } else if (exp.charAt(i + 1) == 'R') { // Segundo operando é um registrador? O primeiro já não é

                        assembly += exp.charAt(i + 1);
                        assembly += exp.charAt(i + 2);
                        exp = new StringBuilder(exp).replace(i - 1, i +32, ("R" + varCounter)).toString();

                    } else { // Nem o primeiro, nem o segundo operando, são registradores.

                        assembly += exp.charAt(i + 1);
                        exp = new StringBuilder(exp).replace(i - 1, i + 2, ("R" + varCounter)).toString();
                    }
                    
                    System.out.println(exp);
                }
            }

        } while (exp.length() != ("R" + varCounter).length());

        System.out.print(assembly);
    }

    public static void div(int i) {

        varCounter++;

        globalCounter += 10;
        if (exp.charAt(i + 3) == 'R') {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1) + exp.charAt(i + 2));
        } else {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1));
        }

        globalCounter += 10;
        assembly = assembly.concat("\n" + globalCounter + " DIV " + "R" + varCounter + ", ");

        if (exp.charAt(i + 1) == 'R') { // Primeiro operando é um registrador?

            if (exp.charAt(i + 4) != 'R') { // Segundo operando não é um registrador?

                assembly += exp.charAt(i + 4);
                exp = new StringBuilder(exp).replace(i, i + 6, ("R" + varCounter)).toString();

            } else { // Segundo operando é um registrador?

                assembly += exp.charAt(i + 4);
                assembly += exp.charAt(i + 5);
                exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();
            }

        } else if (exp.charAt(i + 3) == 'R') { // Segundo operando é um registrador? O primeiro já não é

            assembly += exp.charAt(i + 4);
            assembly += exp.charAt(i + 5);
            exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();

        } else { // Nem o primeiro, nem o segundo operando, são registradores.

            assembly += exp.charAt(i + 3);
            exp = new StringBuilder(exp).replace(i, i + 5, ("R" + varCounter)).toString();
        }

        System.out.println(exp);
    }

    public static void mpy(int i) {

        varCounter++;

        globalCounter += 10;
        if (exp.charAt(i + 3) == 'R') {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1) + exp.charAt(i + 2));
        } else {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1));
        }

        globalCounter += 10;
        assembly = assembly.concat("\n" + globalCounter + " MUL " + "R" + varCounter + ", ");

        if (exp.charAt(i + 1) == 'R') { // Primeiro operando é um registrador?

            if (exp.charAt(i + 4) != 'R') { // Segundo operando não é um registrador?

                assembly += exp.charAt(i + 4);
                exp = new StringBuilder(exp).replace(i, i + 6, ("R" + varCounter)).toString();

            } else { // Segundo operando é um registrador?

                assembly += exp.charAt(i + 4);
                assembly += exp.charAt(i + 5);
                exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();
            }

        } else if (exp.charAt(i + 3) == 'R') { // Segundo operando é um registrador? O primeiro já não é

            assembly += exp.charAt(i + 4);
            assembly += exp.charAt(i + 5);
            exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();

        } else { // Nem o primeiro, nem o segundo operando, são registradores.

            assembly += exp.charAt(i + 3);
            exp = new StringBuilder(exp).replace(i, i + 5, ("R" + varCounter)).toString();
        }

        System.out.println(exp);
    }

    public static void sub(int i) {

        varCounter++;

        globalCounter += 10;
        if (exp.charAt(i + 3) == 'R') {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1) + exp.charAt(i + 2));
        } else {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1));
        }

        globalCounter += 10;
        assembly = assembly.concat("\n" + globalCounter + " SUB " + "R" + varCounter + ", ");

        if (exp.charAt(i + 1) == 'R') { // Primeiro operando é um registrador?

            if (exp.charAt(i + 4) != 'R') { // Segundo operando não é um registrador?

                assembly += exp.charAt(i + 4);
                exp = new StringBuilder(exp).replace(i, i + 6, ("R" + varCounter)).toString();

            } else { // Segundo operando é um registrador?

                assembly += exp.charAt(i + 4);
                assembly += exp.charAt(i + 5);
                exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();
            }

        } else if (exp.charAt(i + 3) == 'R') { // Segundo operando é um registrador? O primeiro já não é

            assembly += exp.charAt(i + 4);
            assembly += exp.charAt(i + 5);
            exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();

        } else { // Nem o primeiro, nem o segundo operando, são registradores.

            assembly += exp.charAt(i + 3);
            exp = new StringBuilder(exp).replace(i, i + 5, ("R" + varCounter)).toString();
        }

        System.out.println(exp);
    }

    public static void add(int i) {

        varCounter++;

        globalCounter += 10;
        if (exp.charAt(i + 3) == 'R') {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1) + exp.charAt(i + 2));
        } else {
            assembly = assembly.concat("\n" + globalCounter + " MOV " + "R" + varCounter + ", " + exp.charAt(i + 1));
        }

        globalCounter += 10;
        assembly = assembly.concat("\n" + globalCounter + " DIV " + "R" + varCounter + ", ");

        if (exp.charAt(i + 1) == 'R') { // Primeiro operando é um registrador?

            if (exp.charAt(i + 4) != 'R') { // Segundo operando não é um registrador?

                assembly += exp.charAt(i + 4);
                exp = new StringBuilder(exp).replace(i, i + 6, ("R" + varCounter)).toString();

            } else { // Segundo operando é um registrador?

                assembly += exp.charAt(i + 4);
                assembly += exp.charAt(i + 5);
                exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();
            }

        } else if (exp.charAt(i + 3) == 'R') { // Segundo operando é um registrador? O primeiro já não é

            assembly += exp.charAt(i + 4);
            assembly += exp.charAt(i + 5);
            exp = new StringBuilder(exp).replace(i, i + 7, ("R" + varCounter)).toString();

        } else { // Nem o primeiro, nem o segundo operando, são registradores.

            assembly += exp.charAt(i + 3);
            exp = new StringBuilder(exp).replace(i, i + 5, ("R" + varCounter)).toString();
        }

        System.out.println(exp);
    }
}