public class Circulo extends Figura
{
    public Circulo(double raio) 
    {
        super(raio);
    }

    public void Area()
    {
        System.out.println("A área é: " + (Lado1*Lado1) * 3.14 + " cm.");
    }
} 

