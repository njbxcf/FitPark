package dgame.fitbark;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;

/**
 * Created by jesse on 2/21/15 under the Apache 2.0 license.
 */
public class ApiAccess {

    private String AuthCode;
    private Net.HttpResponseListener listener;

    public ApiAccess() {
        AuthCode = "b9795369b3e7f65aef74883b8230087a725e5b68f572bf26c3ec1ea51ef1246a";
        MakeRequest();
    }

    public void MakeRequest() {
        listener = new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                Gdx.app.log("Response", httpResponse.getResultAsString());
                //Gdx.app.exit();
            }

            @Override
            public void failed(Throwable t) {
                Gdx.app.error("http failed",t.getMessage());
            }

            @Override
            public void cancelled() {
                Gdx.app.error("http","Cancelled");
            }
        };

        Net.HttpRequest httpPost2 = new Net.HttpRequest(Net.HttpMethods.GET);
        httpPost2.setUrl("http://app.fitbark.com/api/user");
        httpPost2.setHeader("Authorization", "Bearer "+AuthCode);
        Gdx.net.sendHttpRequest(httpPost2, listener);
    }

}
