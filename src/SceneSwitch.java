import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

import javafx.scene.text.Text;

import java.io.IOException;
import java.net.InetAddress;


public class SceneSwitch
{
    Stage stage;
    Scene startScene;
    Scene connectScene;
    Scene serverScene;
    Scene clientScene;
    Battle battle;
    final int WINDOW_WIDTH=800;
    final int WINDOW_HEIGHT=600;

    SceneSwitch(Stage stage)
    {
        this.stage = stage;
    }

    private void initStartScene()
    {
        Pane pane = new Pane();
        Image img1 = new Image("/resources/temp1.jpg");
        ImageView imageView=new ImageView(img1);
        pane.getChildren().add(imageView);
        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());
        Button bt1 = new Button("start");
        bt1.setOnAction(e -> stage.setScene(connectScene));
        pane.getChildren().add(bt1);
        startScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private void initConnectScene()
    {
        Pane pane = new Pane();
        Image img1 = new Image("/resources/temp1.jpg");
        pane.getChildren().add(new ImageView(img1));
        Button clientBtn = new Button("Client");
        clientBtn.relocate(300, 100);
        Button serverBtn = new Button("Server");
        serverBtn.relocate(300, 200);
        Button backBtn = new Button("返回");
        clientBtn.setOnAction(e -> stage.setScene(clientScene));
        serverBtn.setOnAction(e -> {
            stage.setScene(serverScene);
            battle = new Battle(true, this);
            battle.startConnection();
        });
        backBtn.setOnAction(e -> stage.setScene(startScene));
        pane.getChildren().addAll(clientBtn, serverBtn, backBtn);
        connectScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void finishConnect()
    {
        stage.setScene(battle.getScene());
        battle.start();
    }



    private void initServerScene()
    {
        Pane pane = new Pane();
        InetAddress addr;
        try
        {
            addr = InetAddress.getLocalHost();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        Text text = new Text(200, 100, "主机"+addr.getHostAddress() + "等待连接...");
        pane.getChildren().add(text);
        serverScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private void initClientScene()
    {
        FlowPane pane = new FlowPane();
        TextField textHost = new TextField();
        TextField textPort = new TextField();
        pane.getChildren().addAll(new Label("host"), textHost);
        pane.getChildren().addAll(new Label("port"), textPort);
        Button bt = new Button("connect");
        bt.setOnAction(e -> {
            battle = new Battle(false, textHost.getText(),
                    Integer.parseInt(textPort.getText()), this);
            battle.startConnection();
        });
        pane.getChildren().add(bt);
        clientScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void start()
    {
        initStartScene();
        initConnectScene();
        initServerScene();
        initClientScene();
        stage.setTitle("葫芦娃大战妖精");
        stage.setScene(startScene);
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.getIcons().add(new Image("/resources/gourd_icon.png"));
        stage.show();
    }
}
