import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Battle
{
    Scene battleScene;
    DataServer server;
    DataClient client;
    boolean isServer = false;

    Battle(boolean isServer, SceneSwitch ss)
    {
        this.isServer = isServer;
        server = new DataServer(ss);
        initScene();
    }

    Battle(boolean isServer, String host, int port, SceneSwitch ss)
    {
        this.isServer = isServer;
        client = new DataClient(host, port, ss);
        initScene();
    }

    private void initScene()
    {
        Pane pane = new Pane();
        Image img1 = new Image("/resources/battle_tmp.jpg");
        pane.getChildren().add(new ImageView(img1));
        battleScene = new Scene(pane, 800, 600);
    }


    public void start()
    {


    }

    public void startConnection()
    {
        if (isServer)
        {
            new Thread(server).start();
        }
        else
        {
            new Thread(client).start();
        }
    }


    public final Scene getScene()
    {
        return battleScene;
    }

}
