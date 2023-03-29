package AntLangton;

import java.util.Arrays;

class Area {
    private final char[][] grid = new char[Settings.SIZE_X][Settings.SIZE_Y];

    Area() {
        for (char[] chars : grid) {
            Arrays.fill(chars, Settings.SPRITE_AREA_WHITE);
        }
    }

    void printGrid() {
        for (char[] chars : grid) {
            for (char val : chars) {
                System.out.print("|" + val);
            }
            System.out.println();
        }
    }

    void setSprite(char sprite, int coordinateX, int coordinateY) {
        grid[coordinateX][coordinateY] = sprite;
    }

    char getSprite(int x, int y) {
        return grid[x][y];
    }
}