package acsse.csc2a.model;

import acsse.csc2a.visitor.AbstractCharacterVisitable;
import acsse.csc2a.visitor.AbstractCharacterVisitor;

public class Rogue implements AbstractCharacterVisitable {

    // Base speed attribute for the Rogue character
    private double baseSpeed;

    /**
     * Constructs a new Rogue character with the given base speed.
     * 
     * @param baseSpeed The initial base speed value for the Rogue.
     */
    public Rogue(double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    /**
     * Returns the base speed of the Rogue.
     * 
     * @return baseSpeed The Rogue's base speed.
     */
    public double getBaseSpeed() {
        return baseSpeed;
    }

    /**
     * Accepts a visitor object to perform an operation on this Rogue character.
     * This method is part of the Visitor Design Pattern.
     * 
     * @param visitor The visitor object implementing AbstractCharacterVisitor.
     */
    @Override
    public void accept(AbstractCharacterVisitor visitor) {
        // Call the visitor's visit method
        visitor.visit(this);
    }
}
