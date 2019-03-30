class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    public static final int DEFAULT_AGE = 0;
    private int poids;
    private String couleur;


    private int age = DEFAULT_AGE;
    private int esperanceVie =  ESPERANCE_VIE_DEFAUT;
    private boolean clonee = false;
    public Souris(int poids, String couleur, int age, int esperanceVie){
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = esperanceVie;
        System.out.println("Une nouvelle souris !");
    }
    public Souris(int poids, String couleur, int age){
        this(poids, couleur, age, ESPERANCE_VIE_DEFAUT);
    }
    public Souris(int poids, String couleur){
        this(poids, couleur, DEFAULT_AGE);
    }
    public Souris(Souris other_souris){
        poids = other_souris.poids;
        couleur = other_souris.couleur;
        age = other_souris.age;
        esperanceVie = (4 * other_souris.esperanceVie)/ 5; //avoid typecasting 4/5 to 0
        System.out.println("Clonage d'une souris !");
        clonee = true;
    }

    public String toString(){
        String clonee_text;
        if (clonee){
            clonee_text = ", clonee,";
        }else{
            clonee_text = "";
        }
        return "Une souris "+couleur+clonee_text+" de "+age+" mois et pesant "+poids+" grammes";
    }
    public void vieillir(){
        age +=1;
        if (clonee){
            if (age> (esperanceVie/ 2)){
                couleur = "verte";
            }
        }
    }
    public void evolue(){
        if(age < esperanceVie){
            age = esperanceVie;
            if (clonee) couleur = "verte";
        }
    }

}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
