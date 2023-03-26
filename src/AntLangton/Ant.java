package AntLangton;

import java.util.HashMap;

class Ant {
    enum StateAnt {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    private final HashMap<StateAnt, Character> stateMap = new HashMap<>();
    private StateAnt state;
    private int x, y;
    private char sprite;

    Ant() {
        this.sprite = Settings.spriteAntTop;
        this.state = StateAnt.TOP;
        this.y = Settings.sizeY / 2;
        this.x = Settings.sizeX / 2;
        this.stateMap.put(StateAnt.TOP, Settings.spriteAntTop);
        this.stateMap.put(StateAnt.RIGHT, Settings.spriteAntRight);
        this.stateMap.put(StateAnt.BOTTOM, Settings.spriteAntBottom);
        this.stateMap.put(StateAnt.LEFT, Settings.spriteAntLeft);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    char getSprite() {
        return sprite;
    }

    void setSprite(char sprite) {
        this.sprite = sprite;
    }

    StateAnt getState() {
        return state;
    }

    void setState(StateAnt state) {
        this.state = state;
    }

    void changeStateAnt(String direction) {
        int index;
        if (direction.equals("right"))
            index = getState().ordinal() == Ant.StateAnt.values().length - 1 ? 0 : getState().ordinal() + 1;
        else
            index = getState().ordinal() == 0 ? Ant.StateAnt.values().length - 1 : getState().ordinal() - 1;
        setState(Ant.StateAnt.values()[index]);
        setSprite(stateMap.get(state));
    }

    void changeCoordinateAnt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}