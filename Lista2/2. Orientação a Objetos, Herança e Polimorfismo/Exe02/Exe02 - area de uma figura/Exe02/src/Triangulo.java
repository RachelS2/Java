public class Triangulo extends Figura
{
    public Triangulo(double lado1, double lado2, double lado3) 
    {
        super(lado1, lado2, lado3);
    }

    public void Area()
    {
        System.out.println("A área é: " + Lado1 * Lado2 * Lado3);
    }
} 
