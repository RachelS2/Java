public class Retangulo extends Figura
{
    public Retangulo(double lado1, double lado2) 
    {
        super(lado1, lado2);
    }

    public void Area()
    {
        System.out.println("A área é: " + Lado1 * Lado2);
    }
} 
