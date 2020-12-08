import com.sun.security.ntlm.Server;
import javafx.application.Platform;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.lang.Runnable;
import java.util.Scanner;


public class DataServer implements Runnable
{
    SceneSwitch ss;

    DataServer(SceneSwitch ss)
    {
        this.ss = ss;
    }

    @Override
    public void run()
    {
        try
        {
            startServer();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void startServer() throws IOException
    {
        ServerSocket server = new ServerSocket(59091);
        Socket clientSocket = server.accept();
        // callback fx func on non-fx thread
        Platform.runLater(() -> ss.finishConnect());


        BufferedReader input =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);

//        while (cin.hasNext())
        {
//            out.println(cin.nextLine());
//            String line = input.readLine();
//            System.out.println("clientSocket:" + line);
//
//            if (line.equals("exit"))
//            {
//                System.out.println("clientSocket exit");
//            }
//            else
//            {
//                System.out.println("clientSocket " + line);
//            }
        }
    }


}