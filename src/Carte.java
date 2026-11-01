import java.util.ArrayList;


public class Carte {
    private int tailleCases;
    private int nbColonnes;
    private int nbLignes;
    private ArrayList<Case> cases = new ArrayList<Case>(); //Matrice en forme de tableau ArrayList car on ajoute des éléments et pour rechercher un élément o(n) (0,0)[0] , (0,1)[1], etc...

    public Carte(int tailleCase,int nbLignes, int nbColonnes){
        this.setTailleCases(tailleCases);
        this.setNbColonnes(nbColonnes);
        this.setNbLignes(nbLignes);
        this.setCases(); // Initialisation du tableau matrice
    }
    
    public int getTailleCases(){
        return this.tailleCases;
    }
    public int getNbLignes(){
        return this.nbLignes;
    }
    public int getNbColonnes(){
        return this.nbColonnes;
    }
    public Case getCase(int ligne,int colonne){
        Case c ;
        c = new Case(ligne, colonne,null); // Je ne suis pas sûre j'ai null pour nature terrain à la fin je ne sais pas si on a le droit 
        return c;
    }
    public void setTailleCases(int tailleCases){
        if (tailleCases<=0){
            throw new IllegalArgumentException("La taille de la case doit être strictement positif !");
        }
        this.tailleCases = tailleCases;
    }
    public void setNbColonnes(int nbColonnes){
        if (nbColonnes<=0){
            throw new IllegalArgumentException("Le nombre de colonnes doit être strictement positif !");
        }
        this.nbColonnes = nbColonnes;
    }
    public void setNbLignes(int nbLignes){
        if (nbLignes<=0){
            throw new IllegalArgumentException("Le nombre de ligne doit être strictemnt positif !");
        }
        this.nbLignes = nbLignes;
    }
    public void setCases(){
        for (int j = 0;j<nbLignes;j++){
            for (int s = 0;s<nbColonnes;s++){
                cases.add(new Case(j,s,null));
            }
        }
    }
    public boolean caseExiste(Case src){ //Fonction qui vérifie si la case est bien dans la carte 
        if (src.getLigne()>getNbLignes() |src.getColonne()>getNbColonnes()){ // Je n'ai pas mis <0 car dans Case on a déja les vérifications  
            return false;
        }
        return true;
    }
    public boolean voisinExiste(Case src, Direction dir){ //Fonction qui permet de vérifier si on a un voisin proche qui n'est pas hors de la carte 
        if (caseExiste(src)==false){
            return false;
        }
       switch (dir) {
            case NORD:
                if (src.getLigne()-1<0){
                    return false;
                }
                
            case SUD:
                if (src.getLigne()+1>nbLignes){
                    return false;
                }
            case EST :
                if (src.getColonne()+1>nbColonnes){
                    return false;
                }
            case OUEST:
                if (src.getColonne()-1<0){
                    return false;
                }
            default :
                System.out.println("Direction inconnue"); 
        }
        return true;
    } 

    public Case getVoisin(Case src, Direction dir){ //On veut obtenir la case du voisin et selon moi  elle permet de faire un déplacement d'une case 
        if (caseExiste(src)==false){
            throw new IllegalArgumentException("La case source n'est pas dans la carte !");
        }
        if (voisinExiste(src, dir)==false){
            throw new IllegalArgumentException("Le voisin n'existe pas !");
        }
        Case voisin = new Case(0, 0, null);
        switch (dir) {
            case NORD:
                voisin = getCase((src.getLigne())-1, src.getColonne());
                break;
            case SUD:
                voisin = getCase((src.getLigne())+1, src.getColonne());
                break;
            case EST :
                voisin = getCase(src.getLigne(), (src.getColonne())+1);
                break;
            case OUEST:
                voisin = getCase(src.getLigne(), (src.getColonne())-1);
                break;
            default :
                System.out.println("Direction inconnue");  
        }
        return voisin;
    }
    
}
