import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        System.out.println("=========================== MENU ===========================");
        System.out.print("\nequacao (Equação → Assembly)\nassembly (Assembly → Equação)\nguia\n\nSua Opção: ");

        Scanner s = new Scanner(System.in);

        switch (s.nextLine()) {

            case "equacao":

                InterpretadorLogic.equation();
                break;

            case "assembly":

                AssemblyLogic.assembly();
                break;

            case "guia":
                System.out.println("1- Digite todas as equações com parênteses\nSintaxe:\n MOV → mover\n ADD → somar\n SUB → subtrair\n DIV → dividir\n MPY → multiplicar");
                break;

            default:

                System.out.println("Opção inválida");
                main(null);
                break;
        }
    }
}
