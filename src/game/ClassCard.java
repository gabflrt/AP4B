package game;

class ClassCard extends Card {

    private String classe;

    ClassCard() {
        super();
        this.classe = "";
    }

    ClassCard(String name, String description, String image, String classe) {
        super(name, description, image);
        this.classe = classe;
    }

    /**
     * Getter for the class of a player
     * 
     * @return the class of a player
     */
    String getClasse() {
        return this.classe;
    }

    /**
     * Setter for the class of a player
     * 
     * @param classe the class of a player
     */
    void setClasse(String classe) {
        this.classe = classe;
    }
}
