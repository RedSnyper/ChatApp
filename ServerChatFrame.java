import java.io.*;
import java.net.Socket;
import java.rmi.server.ExportException;

public class ServerChatFrame {
    private Socket socket;
    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    private ChatFrame chatFrame = null;
    public ServerChatFrame() throws IOException {
        //socket = new Socket("localhost", 5000);
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(),true);
        chatFrame = new ChatFrame();
    }
//    public void fetchUserName()
//    {
//        writer.println(LoginPage.getUserName());
//
//
//    }



}
