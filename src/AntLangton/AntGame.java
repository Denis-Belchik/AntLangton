package AntLangton;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AntGame {
    private final Area area = new Area();
    private final ArrayList<Ant> antArrayList = new ArrayList<>();
    private final int countAnt;

    public AntGame(int count) {
        this.countAnt = count;
        for (int i = 0; i < count; i++) {
            int xAnt = random(0, Settings.SIZE_X);
            int yAnt = random(0, Settings.SIZE_Y);
            antArrayList.add(new Ant(xAnt, yAnt, area.getSprite(xAnt, yAnt)));
            area.setSprite(antArrayList.get(i).getSpriteAnt(), antArrayList.get(i).getX(), antArrayList.get(i).getY());
        }
    }

    public void play(int step) throws InterruptedException {
        System.out.println("Итерация 0 ");
        area.printGrid();
        System.out.println();
        for (int i = 1; i <= step; i++) {
            TimeUnit.SECONDS.sleep(1);
            for (int j = 0; j < countAnt; j++) {
                move(antArrayList.get(j));
            }
            System.out.println("Итерация " + i);
            area.printGrid();
            System.out.println();
        }
    }

    private void move(Ant ant) {
        int x = ant.getX();
        int y = ant.getY();
        Ant.Direction direction;                                      // направление поворота муравья

        if (ant.getSpriteArea() == Settings.SPRITE_AREA_WHITE)        // на какой клетки стоим, белая? черная?
            direction = Ant.Direction.RIGHT;                          // меняем направление
         else if (ant.getSpriteArea() == Settings.SPRITE_AREA_BLEAK)
            direction = Ant.Direction.LEFT;
        else
            direction = ant.getState();

        ant.changeCoordinateAnt(direction);                            // смена координат положения муравья
        ant.changeStateAnt(direction);                                 // смена направления и спрайта муравья

        // красим клетку в противоположный цвет после ухода муравья
        area.setSprite(ant.getSpriteArea() == Settings.SPRITE_AREA_WHITE ? Settings.SPRITE_AREA_BLEAK : Settings.SPRITE_AREA_WHITE, x, y);
        ant.setSpriteArea(area.getSprite(ant.getX(), ant.getY()));     // запоминаем цвет клетки на которую встал муравей
        area.setSprite(ant.getSpriteAnt(), ant.getX(), ant.getY());    // устанавливаем текущий спрайт муравя
    }

    private int random(int first, int last) {
        return new Random().nextInt(first, last);
    }
}