public class AbilityTrack {
    private boolean[] abilities;

    public AbilityTrack() {
        this.abilities = new boolean[5]; // Example: 5 abilities
        // Initialize to false (no abilities unlocked initially)
        for (int i = 0; i < abilities.length; i++) {
            abilities[i] = false;
        }
    }

    public void unlockAbility(int abilityIndex) {
        if (abilityIndex >= 0 && abilityIndex < abilities.length) {
            abilities[abilityIndex] = true;
            System.out.println("Unlocked ability " + (abilityIndex + 1));
        }
    }

    public boolean isAbilityUnlocked(int abilityIndex) {
        return abilities[abilityIndex];
    }
}
