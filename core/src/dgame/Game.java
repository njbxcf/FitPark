package dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import dgame.fitbark.ApiAccess;
import dgame.graphics.Renderer;

public class Game extends ApplicationAdapter {

    Renderer renderSetup;

	@Override
	public void create () {
        renderSetup = new Renderer(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
	}

	@Override
	public void render () {
        renderSetup.DrawLawn();
        ApiAccess apiAccess = new ApiAccess();
	}
}
