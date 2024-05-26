public class Triangulo extends Figura
{
    public Triangulo(double base, double altura) 
    {
        super(base, altura);
    }

    public void Area()
    {
        System.out.println("A área é: " + (Lado1 * Lado2)/2);
    }
} 
