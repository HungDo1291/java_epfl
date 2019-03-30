import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Piece{
    private String nom;
    public Piece(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    public String toString(){
        return nom;
    }
}
class Composant{
    private Piece piece;
    private int quantite;
    public Composant(Piece piece, int quantite){
        this.piece = piece;
        this.quantite = quantite;
    }
    public Piece getPiece(){
        return piece;
    }
    public int getQuantite(){
        return quantite;
    }
}

class Simple extends Piece{
    private String orientation = "aucune";
    public Simple(String nom, String orientation){
        super(nom);
        this.orientation = orientation;
    }
    public Simple(String nom){
        super(nom);
    }
    public String getOrientation(){
        return orientation;
    }
    public String toString(){
        if (orientation == "aucune"){
            return super.toString();
        }else{
            return super.toString() + " " + orientation;
        }
    }
}
class Composee extends Piece{
    private ArrayList<Piece> pieces= new ArrayList<>();
    private int taille_max;
    public Composee(String nom, int taille_max){
        super(nom);
        this.taille_max = taille_max;
    }
    public int taille() {
        return pieces.size();
    }
    public int tailleMax(){
        return taille_max;
    }
    public void construire(Piece piece){
        if (taille() < tailleMax()) {
            pieces.add(piece);
        }else{
            System.out.println("Construction impossible");
        }
    }
    public String toString(){
        String output_string;
        output_string = getNom() +"(";
        for (int i = 0; i < pieces.size(); i++) {
            Piece p = pieces.get(i);
            output_string +=   p.toString() ;
            if (i<(pieces.size()-1)){
                output_string += ",";
            }
        }
        output_string +=")";
        return output_string;
    }

}
class Construction{
    private ArrayList<Composant> composants = new ArrayList<>();
    private int taille_max;
    public Construction(int taille_max){
        this.taille_max = taille_max;
    }
    public int taille(){
        return composants.size();
    }
    public int tailleMax(){
        return taille_max;
    }
    public void ajouterComposant(Piece piece, int quantite){
        if(taille() < tailleMax()){
            Composant c = new Composant(piece, quantite);
            composants.add(c);
        }else{
            System.out.println("Ajout de composant impossible");
        }
    }
    public String toString(){
        String output_string;
        output_string = "";
        for (int i = 0; i < composants.size(); i++) {
            Composant c = composants.get(i);
            output_string +=  c.getPiece().toString()+" (quantite "+c.getQuantite() +")\n";
        }
        return output_string;
    }
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
