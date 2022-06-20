import java.io.*;
import java.net.*;
import java.util.Arrays;

class Server {
    ServerSocket server = null;
    Socket client = null;

    public static void main(String[] arg) {
        File file = new File("c:\\server");
        if(!file.exists())
            file.mkdir();
        Server s = new Server();
        s.doConnections();
    }

    public void doConnections() {

        try {
            server = new ServerSocket(8888);
            while (true) {
                client = server.accept();
                System.out.println("client is connected");
                ClientThread ct = new ClientThread(client);
                ct.start();
            }
        } catch (Exception e) {
        }
    }
}

class ClientThread extends Thread {
    public Socket client = null;
    public DataInputStream dis = null;
    public DataOutputStream dos = null;
    public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public BufferedReader br = null;
    public String inputFromUser = "";
    public File file = null;

    public ClientThread(Socket c) {
        try {
            client = c;
            dis = new DataInputStream(c.getInputStream());
            dos = new DataOutputStream(c.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        while (true) {
            try {
                String input = dis.readUTF();
                String filename = "", filedata = "";
                byte[] data;
                if(input.equals("LOGIN")){
                    String id = dis.readUTF();
                    String pass = dis.readUTF();
                    if (id.equals("admin") && pass.equals("1234")){
                        System.out.println("login success");
                        dos.writeUTF("login sucess");
                    }
                    else{
                        dos.writeUTF("login fail");
                    }
                }
                else if (input.equals("FILE_SEND_FROM_CLIENT")) {
                    filename = dis.readUTF();
                    filedata = dis.readUTF();
                    System.out.println("filename = " + filename);
                    fos = new FileOutputStream(new File("c:\\server\\" + filename));
                    fos.write(filedata.getBytes());
                    fos.close();
                    System.out.println("file saved");

                } else if (input.equals("DOWNLOAD_FILE")) {
                    filename = dis.readUTF();
                    file = new File("c:\\server\\" + filename);
                    if (file.isFile()) {
                        fis = new FileInputStream(file);
                        data = new byte[fis.available()];
                        fis.read(data);
                        filedata = new String(data);
                        fis.close();
                        dos.writeUTF(filedata);
                    } else {
                        dos.writeUTF(""); // NO FILE FOUND
                    }
                    System.out.println("file download");
                } else if (input.equals("FILE_LIST")) {
                    File file = new File("c:\\server\\");
                    File files[] = file.listFiles();
                    if (files.length ==0){
                        dos.writeUTF("file list is empty");
                    }else {
                        String temp = "";
                        for (File t_file : files) {
                            temp += "filename = " + t_file.getName()+"\n";
                        }
                        System.out.println(temp);
                        dos.writeUTF(temp);
                        System.out.println("filelist");
                    }
                } else {
                    System.out.println("Error at Server");
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }
}