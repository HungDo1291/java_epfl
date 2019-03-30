class Rectangle{
    private double largeur;
    private double hauteur;

    public Rectangle(double lr, double hr){
        largeur = lr;
        hauteur = hr;
    }
}

class A{
    protected int number;
    public A(){
        number = 20;
    }
    public void print(){
        System.out.println(getPrefix()+": "+number);
    }

    protected String getPrefix(){
        return "A"+number;
    }
}

class B extends A{
    protected int number = 10;
    protected  String getPrefix(){
        return "B"+number;
    }
}

class C extends B{
    public C(){
        super();
    }
    protected  String getPrefix(){
        return "C"+number;
    }
}

public class Quiz {
    public static void main(String[] args){
        //test Rectangle
        Rectangle r1 = new Rectangle(2,1);
        Rectangle r2 = new Rectangle(2,1);
        System.out.println(r1 == r2);
        System.out.println(r1.equals(r2));
        System.out.println(r2.equals(r1));

        //test class a,b,c
        C c = new C();
        c.print();
        B b = new B();
        b.print();
        A ab = new B();
        ab.print();

        ((B) c).print();//same as c.print()
        ((A) c).print();// same as c.print()
    }
}
