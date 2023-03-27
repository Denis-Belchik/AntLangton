package AntLangton;

import java.util.HashMap;

class Ant {
    enum DirectionAnt {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    private final HashMap<DirectionAnt, Character> stateMap = new HashMap<>();
    private DirectionAnt state;
    private int x, y;
    private char sprite;

    Ant() {
        this.sprite = Settings.spriteAntTop;
        this.state = DirectionAnt.TOP;
        this.y = Settings.sizeY / 2;
        this.x = Settings.sizeX / 2;
        this.stateMap.put(DirectionAnt.TOP, Settings.spriteAntTop);
        this.stateMap.put(DirectionAnt.RIGHT, Settings.spriteAntRight);
        this.stateMap.put(DirectionAnt.BOTTOM, Settings.spriteAntBottom);
        this.stateMap.put(DirectionAnt.LEFT, Settings.spriteAntLeft);
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

    DirectionAnt getState() {
        return state;
    }

    void setState(DirectionAnt state) {
        this.state = state;
    }

    void changeStateAnt(DirectionAnt direction) {
        int index;
        if (direction.equals(DirectionAnt.RIGHT))
            index = getState().ordinal() == DirectionAnt.values().length - 1 ? 0 : getState().ordinal() + 1;
        else if (direction.equals(DirectionAnt.LEFT))
            index = getState().ordinal() == 0 ? DirectionAnt.values().length - 1 : getState().ordinal() - 1;
        else
            index = getState().ordinal();
        setState(DirectionAnt.values()[index]);
        setSprite(stateMap.get(state));
    }

    void changeCoordinateAnt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}