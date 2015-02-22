package dgame.graphics;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class Gardener {

    private static final int PlantCount = 30;
    private static final int PlantSpacing = 10;

    private static boolean loaded = false;
    private static Texture[] textures = new Texture[6];

    public static void Garden(Lawn lawn) {
        if(!loaded)
            LoadPlants();
        ArrayList<Plant> plants = new ArrayList<Plant>();

        for(int i=0;i<PlantCount;i++) {
            int key = 5;
            double rand = Math.random();
            if (rand < 0.4)
                key = 0;
            else if (rand < 0.8)
                key = 1;
            else if (rand < 0.85)
                key = 2;
            else if (rand < 0.9)
                key = 3;
            else if (rand < 0.95)
                key = 4;
            Plant temp;
            int count = 0;
            do {
                temp = new Plant(textures[key]);
                temp.SetX((int) Math.floor(Math.random() * 1280));
                temp.SetY((int) Math.floor(Math.random() * 500));
            } while (IsOverlapping(temp, plants) && count++<5);
            count=0;
            plants.add(temp);
        }
        for (Plant plant : plants) {
            lawn.AddPlant(plant);
        }
    }

    private static boolean IsOverlapping(Plant plant, ArrayList<Plant> list) {
        for (Plant plant1 : list)
            if(plant.GetX()+plant.GetWidth()+PlantSpacing >= plant1.GetX()-PlantSpacing && plant.GetX()-PlantSpacing <= plant1.GetX()+plant1.GetWidth()+PlantSpacing
                    && plant.GetY()+plant.GetHeight()+PlantSpacing >= plant1.GetY()-PlantSpacing && plant.GetY()-PlantSpacing <= plant1.GetY()+plant1.GetHeight()+PlantSpacing)
                return true;
        return false;
    }

    private static void LoadPlants() {
        loaded = true;
        textures[0] = new Texture("grass-left.png");
        textures[1] = new Texture("grass-right.png");
        textures[2] = new Texture("rose.png");
        textures[3] = new Texture("marigold.png");
        textures[4] = new Texture("red-flower.png");
        textures[5] = new Texture("purple-flower.png");
    }

}
