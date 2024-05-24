import java.util.Scanner;
public class Program {
    public static void main(String[] args) throws Exception {
        System.out.println("Insira o número que corresponde a figura geométrica desejada: ");
        System.out.println("[1] quadrado");
        System.out.println("[2] retângulo");
        System.out.println("[3] triângulo");
        System.out.println("[4] círculo");
        Scanner input = new Scanner(System.in);
        int figura = input.nextInt();
        if (figura == 1)
        {   
            double lado = Print(1);
            Figura quadrado = new Quadrado(lado);
            quadrado.Area();
        }
        else if (figura == 2)
        {   
            double lado1 = Print(1);
            double lado2 = Print(2);
            Figura quadrado = new Retangulo(lado1, lado2);
            quadrado.Area();
        }

        else if (figura == 3)
        {   
            double lado1 = Print(1);
            double lado2 = Print(2);
            double lado3 = Print(3);
            Figura triangulo = new Triangulo(lado1, lado2, lado3);
            triangulo.Area();
        }

        else if (figura == 4)
        {           
            System.out.println("Insira o raio do círculo: ");

            double raio = input.nextDouble();

            Figura circulo = new Circulo(raio);
            circulo.Area();
        }

        else System.out.println("Opção inválida. Reinicie o programa e tente novamente.");
        input.close();

    }

    public static double Print(int index)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o " + index + "º lado da figura: ");
        return input.nextDouble();
    }
}
