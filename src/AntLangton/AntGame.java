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
        String direction = "right";
        if (tempSprite == Settings.spriteAreaWhite) {
            direction = "right";
            switch (ant.getState()) {
                case TOP:
                    newY = y == Settings.sizeY - 1 ? 0 : y + 1;
                    break;
                case RIGHT:
                    newX = x == Settings.sizeX - 1 ? 0 : x + 1;
                    break;
                case BOTTOM:
                    newY = y == 0 ? Settings.sizeY - 1 : y - 1;
                    break;
                case LEFT:
                    newX = x == 0 ? Settings.sizeX - 1 : x - 1;
                    break;
            }
        } else if (tempSprite == Settings.spriteAreaBleak) {
            direction = "left";
            switch (ant.getState()) {
                case TOP:
                    newY = y == 0 ? Settings.sizeY : y - 1;
                    break;
                case RIGHT:
                    newX = x == 0 ? Settings.sizeX : x - 1;
                    break;
                case BOTTOM:
                    newY = y == Settings.sizeY - 1 ? 0 : y + 1;
                    break;
                case LEFT:
                    newX = x == Settings.sizeX - 1 ? 0 : x + 1;
                    break;
            }
        }
        ant.changeStateAnt(direction);
        ant.changeCoordinateAnt(newX, newY);
        area.setSprite(tempSprite == Settings.spriteAreaWhite ? Settings.spriteAreaBleak : Settings.spriteAreaWhite, x, y);
        tempSprite = area.getSprite(newX, newY);
        area.setSprite(ant.getSprite(), newX, newY);
    }
}