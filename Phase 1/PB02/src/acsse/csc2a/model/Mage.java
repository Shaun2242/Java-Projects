package acsse.csc2a.model;

import acsse.csc2a.visitor.AbstractCharacterVisitable;
import acsse.csc2a.visitor.AbstractCharacterVisitor;

public class Mage implements AbstractCharacterVisitable {

    // Base mana attribute for the Mage character
    private double baseMana;

    /**
     * Constructs a Mage character with the base mana.
     * 
     * @param baseMana The initial mana level of the Mage.
     */
    public Mage(double baseMana) {
        this.baseMana = baseMana;
    }

    /**
     * Retrieves the base mana value of the Mage.
     * 
     * @return baseMana The Mage's current base mana level.
     */
    public double getBaseMana() {
        return baseMana;
    }

    /**
     * Accepts a visitor object that implements AbstractCharacterVisitor.
     * This method allows the visitor to apply operations specific to the Mage.
     * 
     * @param visitor The visitor applying effects or operations on the Mage.
     */
    @Override
    public void accept(AbstractCharacterVisitor visitor) {
        // Call the visit method on the visitor for the Mage
        visitor.visit(this);
    }

}
