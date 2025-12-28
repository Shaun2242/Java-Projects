package acsse.csc2a.visitor;

import acsse.csc2a.model.Mage;
import acsse.csc2a.model.Rogue;
import acsse.csc2a.model.Warrior;

public class BuffVisitor implements AbstractCharacterVisitor {

    /**
     * Applies a damage buff to a Warrior character.
     * 
     * @param warrior The Warrior to apply the buff to.
     */
    @Override
    public void visit(Warrior warrior) {
        double buffedDamage = warrior.getBaseDamage() + 10;
        System.out.println("Warrior Buffed Damage: " + buffedDamage);
    }

    /**
     * Applies a mana buff to a Mage character.
     * 
     * @param mage The Mage to apply the buff to.
     */
    @Override
    public void visit(Mage mage) {
        double buffedMana = mage.getBaseMana() + 25;
        System.out.println("Mage Buffed Mana: " + buffedMana);
    }

    /**
     * Applies a speed buff to a Rogue character.
     * 
     * @param rogue The Rogue to apply the buff to.
     */
    @Override
    public void visit(Rogue rogue) {
        double buffedSpeed = rogue.getBaseSpeed() * 1.5;
        System.out.println("Rogue Buffed Speed: " + buffedSpeed);
    }

}
