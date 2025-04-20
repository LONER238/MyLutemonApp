package com.example.project_lutemon;

class Battle {
    public String fight(Lutemon a, Lutemon b) {
        StringBuilder log = new StringBuilder();
        Lutemon attacker = a, defender = b;
        while (attacker.isAlive() && defender.isAlive()) {
            log.append(attacker.getName()).append(" attacks ").append(defender.getName()).append("\n");
            defender.defend(attacker.getAttackPower());
            if (defender.isAlive()) {
                log.append(defender.getName()).append(" manages to escape death.\n");
                // swap roles
                Lutemon temp = attacker;
                attacker = defender;
                defender = temp;
            } else {
                log.append(defender.getName()).append(" gets killed.\nBattle is over.\n");
                attacker.gainExperience();
                return log.toString();
            }
        }
        return log.toString();
    }
}


