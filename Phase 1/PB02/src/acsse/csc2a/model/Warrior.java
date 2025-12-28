package acsse.csc2a.model;

import acsse.csc2a.visitor.AbstractCharacterVisitable;
import acsse.csc2a.visitor.AbstractCharacterVisitor;

public class Warrior implements AbstractCharacterVisitable {

    // Base damage attribute for the Warrior character
    private double baseDamage;

    /**
     * Constructs a Warrior with the base damage.
     * 
     * @param baseDamage The initial damage level of the Warrior.
     */
    public Warrior(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    /**
     * Retrieves the base damage of the Warrior.
     * 
     * @return baseDamage The Warrior's current base damage.
     */
    public double getBaseDamage() {
        return baseDamage;
    }

    /**
     * Accepts a visitor object that implements AbstractCharacterVisitor.
     * This method enables external operations to be performed on this Warrior.
     * 
     * @param visitor The visitor applying effects or operations on the Warrior.
     */
    @Override
    public void accept(AbstractCharacterVisitor visitor) {
        // Call the appropriate visit method on the visitor for Warrior
        visitor.visit(this);
    }	
}
