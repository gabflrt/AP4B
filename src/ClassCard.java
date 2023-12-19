public class ClassCard extends Card {

    private String classe;

    ClassCard() {
        super();
        this.classe = "";
    }

    ClassCard(String name, String description, String classe) {
        super(name, description);
        this.classe = classe;
    }

    /**
     * Getter for the class of a player
     * @return the class of a player
     */
    public String getClasse() {
        return this.classe;
    }

    /**
     * Setter for the class of a player
     * @param classe the class of a player
     */
    public void setClasse(String classe) {
        this.classe = classe;
    }
}
