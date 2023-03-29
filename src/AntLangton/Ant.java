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
        this.sprite = Settings.SPRITE_ANT_TOP;
        this.state = DirectionAnt.TOP;
        this.y = Settings.SIZE_Y / 2;
        this.x = Settings.SIZE_X / 2;
        this.stateMap.put(DirectionAnt.TOP, Settings.SPRITE_ANT_TOP);
        this.stateMap.put(DirectionAnt.RIGHT, Settings.SPRITE_ANT_RIGHT);
        this.stateMap.put(DirectionAnt.BOTTOM, Settings.SPRITE_ANT_BOTTOM);
        this.stateMap.put(DirectionAnt.LEFT, Settings.SPRITE_ANT_LEFT);
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

    DirectionAnt getState() {
        return state;
    }

    void changeStateAnt(DirectionAnt direction) {
        int index;
        if (direction.equals(DirectionAnt.RIGHT))
            index = getState().ordinal() == DirectionAnt.values().length - 1 ? 0 : getState().ordinal() + 1;
        else if (direction.equals(DirectionAnt.LEFT))
            index = getState().ordinal() == 0 ? DirectionAnt.values().length - 1 : getState().ordinal() - 1;
        else
            index = getState().ordinal();
        this.state = DirectionAnt.values()[index];
        this.sprite = stateMap.get(state);
    }

    void changeCoordinateAnt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}