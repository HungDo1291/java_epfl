import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

    protected String code;
    protected int anee_d_emission;
    protected String pays_d_origine;
    protected double valeur_faciale;

    public Timbre(String code, int anee_d_emission, String pays_d_origine,
                  double valeur_faciale){
        this.code = code;
        this.anee_d_emission = anee_d_emission;
        this.pays_d_origine = pays_d_origine;
        this.valeur_faciale = valeur_faciale;
    }
    public Timbre(String code, int anee_d_emission, String pays_d_origine){
        this(code, anee_d_emission, pays_d_origine, VALEUR_TIMBRE_DEFAUT);
    }
    public Timbre(String code, int anee_d_emission){
        this(code, anee_d_emission, PAYS_DEFAUT);
    }
    public Timbre(String code){
        this(code, ANNEE_COURANTE);
    }
    public Timbre(){
        this(CODE_DEFAUT);
    }



    public double vente(){
        int age = age();
        if (age<5)return valeur_faciale;
        else return 2.5*age*valeur_faciale;
    }
    public String toString(){
        return "Timbre de code "+code+" datant de "+anee_d_emission+" (provenance " +
                pays_d_origine+") ayant pour valeur faciale "+valeur_faciale+" francs";

    }
    public int age(){
        return ANNEE_COURANTE - anee_d_emission;
    }
    public String getCode() {return code;}
    public int getAnnee(){ return anee_d_emission;}
    public String getPays(){ return pays_d_origine;}
    public double getValeurFaciale(){return valeur_faciale;}
}
class Rare extends Timbre{
    private int nombre_exemplaires;
    public Rare(String code, int anee_d_emission, String pays_d_origine,
            double valeur_faciale, int nombre_exemplaires){
        super(code, anee_d_emission, pays_d_origine, valeur_faciale);
        this.nombre_exemplaires = nombre_exemplaires;
    }
    public Rare(String code, int anee_d_emission, String pays_d_origine,
                int nombre_exemplaires){
        super(code, anee_d_emission, pays_d_origine);
        this.nombre_exemplaires = nombre_exemplaires;
    }
    public Rare(String code, int anee_d_emission, int nombre_exemplaires){
        super(code, anee_d_emission);
        this.nombre_exemplaires = nombre_exemplaires;
    }
    public Rare(String code, int nombre_exemplaires){
        super(code);
        this.nombre_exemplaires = nombre_exemplaires;
    }
    public Rare(int nombre_exemplaires){
        super();
        this.nombre_exemplaires = nombre_exemplaires;
    }

    public int getExemplaires(){return nombre_exemplaires;}
    public String toString(){
        return super.toString()+"\nNombre d’exemplaires -> "+nombre_exemplaires;
    }
    public double vente(){
        int prix_base;
        if (nombre_exemplaires < 100) prix_base = 600;
        else{
            if (nombre_exemplaires < 1000) prix_base = 400;
            else prix_base = 50;
        }
        return  prix_base * (age() / 10.0);
    }
}
class Commemoratif extends Timbre{
    public Commemoratif(String code, int anee_d_emission, String pays_d_origine,
                        double valeur_faciale){
        super(code, anee_d_emission, pays_d_origine, valeur_faciale);
    }
    public Commemoratif(String code, int anee_d_emission, String pays_d_origine){
        super( code, anee_d_emission, pays_d_origine);
    }

    public Commemoratif(String code, int anee_d_emission)
    {
        super(code, anee_d_emission);
    }
    public Commemoratif(String code)
    {
        super(code);
    }
    public Commemoratif()
    {
        super();
    }
    public String toString(){
        return super.toString()+"\nTimbre celebrant un evenement";
    }
    public double vente(){
        return 2 * super.vente();
    }
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

