package com.ninelements.nineelementsonewatch.models;

/**
 * Created by sebastiandeutsch on 08.07.14.
 */
public class Character {
    private boolean on;

    private char character;

    public Character(char character) {
        this.character = character;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public char getCharacter() {
        return character;
    }
}
