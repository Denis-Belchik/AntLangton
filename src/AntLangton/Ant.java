package AntLangton;

import java.util.HashMap;

class Ant {
    enum Direction {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    private final HashMap<Direction, Character> stateMap = new HashMap<>();
    private Direction state;
    private int x, y;
    private char spriteAnt, spriteArea;

    Ant(int x, int y, char spriteArea) {
        this.spriteAnt = Settings.SPRITE_ANT_TOP;    // как выглядит муравей
        this.spriteArea = spriteArea;                // на какой клетке он сейчас стоит
        this.state = Direction.TOP;                  // куда смотрит муравей
        this.y = y;
        this.x = x;
        this.stateMap.put(Direction.TOP, Settings.SPRITE_ANT_TOP);
        this.stateMap.put(Direction.RIGHT, Settings.SPRITE_ANT_RIGHT);
        this.stateMap.put(Direction.BOTTOM, Settings.SPRITE_ANT_BOTTOM);
        this.stateMap.put(Direction.LEFT, Settings.SPRITE_ANT_LEFT);
    }

    void changeStateAnt(Direction direction) {
        int index;
        if (direction.equals(Direction.RIGHT))
            index = getState().ordinal() == Direction.values().length - 1 ? 0 : getState().ordinal() + 1;
        else if (direction.equals(Direction.LEFT))
            index = getState().ordinal() == 0 ? Direction.values().length - 1 : getState().ordinal() - 1;
        else
            index = getState().ordinal();
        this.state = Direction.values()[index];
        this.spriteAnt = stateMap.get(state);
    }

    void changeCoordinateAnt(Direction direction) {
        int newX = x;
        int newY = y;
        if(direction == Direction.RIGHT){
            switch (getState()) {
                case TOP:
                    newY = y == Settings.SIZE_Y - 1 ? 0 : y + 1;
                    break;
                case RIGHT:
                    newX = x == Settings.SIZE_X - 1 ? 0 : x + 1;
                    break;
                case BOTTOM:
                    newY = y == 0 ? Settings.SIZE_Y - 1 : y - 1;
                    break;
                case LEFT:
                    newX = x == 0 ? Settings.SIZE_X - 1 : x - 1;
                    break;
            }
        } else if (direction == Direction.LEFT) {
            switch (getState()) {
                case TOP:
                    newY = y == 0 ? Settings.SIZE_Y - 1 : y - 1;
                    break;
                case RIGHT:
                    newX = x == 0 ? Settings.SIZE_X - 1 : x - 1;
                    break;
                case BOTTOM:
                    newY = y == Settings.SIZE_Y - 1 ? 0 : y + 1;
                    break;
                case LEFT:
                    newX = x == Settings.SIZE_X - 1 ? 0 : x + 1;
                    break;
            }
        }
        this.x = newX;
        this.y = newY;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    char getSpriteAnt() {
        return spriteAnt;
    }

    Direction getState() {
        return state;
    }

    char getSpriteArea() {
        return spriteArea;
    }

    void setSpriteArea(char spriteArea) {
        this.spriteArea = spriteArea;
    }
}