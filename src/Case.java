public class Case {
    private int ligne;
    private int colonne;
    private NatureTerrain nature;

    public Case(int ligne, int colonne, NatureTerrain nature){
        this.setLigne(ligne);
        this.setColonne(colonne);
        this.setNature(nature);
    }
    public int getLigne(){
        return this.ligne;
    }
    public int getColonne(){
        return this.colonne;
    }
    public NatureTerrain getNature(){
        return this.nature;
    }
    
    public void setLigne(int ligne){
        if (ligne<0){ //Vérification si la ligne n'est pas négatif
            throw new IllegalArgumentException("Le numéro de ligne doit être positif !");
        }
        this.ligne = ligne;
    }
    public void setColonne(int colonne){
        if (colonne<0){ // Vérification si la colonne n'est pas négatif 
            throw new IllegalArgumentException("Le numéro de colonne doit être positif !");
        }
        this.colonne = colonne;
    }
    public void setNature(NatureTerrain nature){
        this.nature = nature; 
    }
    public boolean memeCase(Case autre){ // Si c'est les même case
        return ligne ==autre.ligne && colonne==autre.colonne;
    }


}
