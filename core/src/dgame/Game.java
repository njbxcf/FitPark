package dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dgame.fitbark.ApiAccess;
import dgame.graphics.UI;
import dgame.graphics.UIElement;
import dgame.scenes.Hood;
import dgame.scenes.Lawn;
import dgame.graphics.Renderer;
import dgame.scenes.Shop;

public class Game extends ApplicationAdapter {

    Renderer renderLawn, renderShop, renderHood;
    Entities entities;
    Batch batch;
    public UI uiLawn, uiShop, uiHood;
    BitmapFont font;

	@Override
	public void create () {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.setScale(2,3);

        Lawn lawn = new Lawn();
        Shop shop = new Shop();
        Hood hood = new Hood();
        GameState.ToLawn();

        renderLawn = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        renderLawn.SetScene(lawn);
        uiLawn = new UI();

        renderShop = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        renderShop.SetScene(shop);
        uiShop = new UI();

        renderHood = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
        renderHood.SetScene(hood);
        uiHood = new UI();

        entities = new Entities();
        batch = new SpriteBatch();

        UIElement shopBag = new UIElement(new Texture("store-btn.png"), 0);
        shopBag.SetX(25);
        shopBag.SetY(25);
        uiLawn.AddUIElement(shopBag);
        uiHood.AddUIElement(shopBag);

        UIElement hoodHouse = new UIElement(new Texture("backto-neighborhood.png"), 1);
        hoodHouse.SetX(1280-225);
        hoodHouse.SetY(25);
        uiLawn.AddUIElement(hoodHouse);
        uiShop.AddUIElement(hoodHouse);

        UIElement house = new UIElement(new Texture("backhome.png"), 2);
        house.SetX(1280-140);
        house.SetY(25);
        uiHood.AddUIElement(house);

        UIElement house2 = new UIElement(new Texture("backhome.png"), 2);
        house2.SetX(25);
        house2.SetY(25);
        uiShop.AddUIElement(house2);

        Entity bone = new Entity(new Texture("shopbone.png"));
        bone.SetX(570);
        bone.SetY(535);
        bone.cost = 1000;
        entities.AddEntity(bone);

        Entity food1 = new Entity(new Texture("dogfood.png"));
        food1.SetX(570);
        food1.SetY(385);
        food1.cost = 10000;
        entities.AddEntity(food1);

        Entity food2 = new Entity(new Texture("purina-1.png"));
        food2.SetX(570);
        food2.SetY(255);
        food2.cost = 10000;
        entities.AddEntity(food2);

        Entity food3 = new Entity(new Texture("purina-2.png"));
        food3.SetX(570);
        food3.SetY(140);
        food3.cost = 10000;
        entities.AddEntity(food3);

        ApiAccess apiAccess = new ApiAccess();
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(0.48f, 0.78f, 0.34f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.enableBlending();

        if(GameState.scene==0) {
            uiLawn.Process(entities);
            renderLawn.Draw(batch);
            uiLawn.Draw(batch);
            font.draw(batch, ""+GameState.points+" points", 510, 65);
        }
        else if (GameState.scene==1) {
            uiShop.Process(entities);
            renderShop.Draw(batch);
            uiShop.Draw(batch);
            entities.Draw(batch);
            font.draw(batch, ""+GameState.points+" points", 510, 65);
        } else {
            uiHood.Process(entities);
            renderHood.Draw(batch);
            uiHood.Draw(batch);
        }

        batch.end();
	}
}
