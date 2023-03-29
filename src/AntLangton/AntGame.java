package AntLangton;

import java.util.concurrent.TimeUnit;

public class AntGame {
    private final Area area = new Area();
    private final Ant ant = new Ant();
    private char tempSprite = area.getSprite(ant.getX(), ant.getY());

    public AntGame() {
        area.setSprite(ant.getSprite(), ant.getX(), ant.getY());
    }

    public void play(int step) throws InterruptedException {
        System.out.println("Итерация 0 " + tempSprite);
        area.printGrid();
        System.out.println();
        for (int i = 1; i <= step; i++) {
            TimeUnit.SECONDS.sleep(1);
            move();
            System.out.println("Итерация " + i + " " + tempSprite);
            area.printGrid();
            System.out.println();
        }
    }

    private void move() {
        int x = ant.getX();
        int y = ant.getY();
        int newX = x;
        int newY = y;
        Ant.DirectionAnt direction = ant.getState();
        if (tempSprite == Settings.SPRITE_AREA_WHITE) {
            direction = Ant.DirectionAnt.RIGHT;
            switch (ant.getState()) {
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
        } else if (tempSprite == Settings.SPRITE_AREA_BLEAK) {
            direction = Ant.DirectionAnt.LEFT;
            switch (ant.getState()) {
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
        ant.changeStateAnt(direction);
        ant.changeCoordinateAnt(newX, newY);

        area.setSprite(tempSprite == Settings.SPRITE_AREA_WHITE ? Settings.SPRITE_AREA_BLEAK : Settings.SPRITE_AREA_WHITE, x, y);
        tempSprite = area.getSprite(newX, newY);
        area.setSprite(ant.getSprite(), ant.getX(), ant.getY());
    }
}