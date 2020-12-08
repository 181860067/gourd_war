import javafx.application.Platform;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DataClient implements Runnable
{
    String host;
    int port;
    SceneSwitch ss;

    DataClient(String host, int port, SceneSwitch ss)
    {
        this.host = host;
        this.port = port;
        this.ss = ss;
    }


    @Override
    public void run()
    {
        try
        {
            startClient();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void startClient() throws IOException
    {
        Socket echoSocket = new Socket("127.0.0.1", 59091);
        Platform.runLater(() -> ss.finishConnect());

        PrintWriter output =
                new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(echoSocket.getInputStream()));
        String words;

        while ((words = in.readLine()) != null)
        {
            System.out.println("data: " + words);
        }
        echoSocket.close();
    }
}
