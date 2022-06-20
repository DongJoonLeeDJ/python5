import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public Socket client = null;
    public DataInputStream dis = null;
    public DataOutputStream dos = null;
    public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public BufferedReader br = null;
    public String inputFromUser = "";

    public static void main(String[] args) {
        File file = new File("c:\\client");
        if(!file.exists())
            file.mkdir();
        Client c = new Client();
        c.doConnections();
    }

    public void doConnections() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            client = new Socket("127.0.0.1", 8888);
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());

        } catch (Exception e) {
            System.out.println("Unable to Connect to Server");
        }

        while (true) {
            try {
                System.out.println("Please Make a Choice : \n0.login\n1.upload file \n2.download file\n3.file list \nYour Choice: ");
                inputFromUser = br.readLine();
                int i = Integer.parseInt(inputFromUser);
                switch (i) {
                    case 0:
                        login();
                        break;
                    case 1:
                        sendFile();
                        break;
                    case 2:
                        receiveFile();
                        break;
                    case 3:
                        filelist();
                        break;
                    default:
                        System.out.println("Invalid Option !");
                }
            } catch (Exception e) {
                System.out.println("Some Error Occured!");
            }
        }
    }

    public void login() {
        try {
            String id = "", pass = "";
            System.out.println("ID : ");
            id = br.readLine();
            System.out.println("PASS : ");
            pass = br.readLine();
            dos.writeUTF("LOGIN");
            dos.writeUTF(id);
            dos.writeUTF(pass);
            String result = dis.readUTF();
            System.out.println("login check = " +result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFile() {
        try {
            String filename = "", filedata = "";
            File file;
            byte[] data;
            System.out.println("Enter the filename: ");
            filename = br.readLine();
            file = new File(filename);
            if (file.isFile()) {
                fis = new FileInputStream(file);
                data = new byte[fis.available()];
                fis.read(data);
                fis.close();
                filedata = new String(data);
                dos.writeUTF("FILE_SEND_FROM_CLIENT");
                dos.writeUTF(file.getName());
                dos.writeUTF(filedata);
                System.out.println("File Send Successful!");
            } else {
                System.out.println("File Not Found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveFile() {
        try {
            String filename = "", filedata = "";
            System.out.println("Enter the filename: ");
            filename = br.readLine();
            dos.writeUTF("DOWNLOAD_FILE");
            dos.writeUTF(filename);
            filedata = dis.readUTF();
            if (filedata.equals("")) {
                System.out.println("No Such File");
            } else {
                fos = new FileOutputStream("c:\\client\\"+filename);
                fos.write(filedata.getBytes());
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filelist() {
        try {
            String filename = "", filedata = "";
            dos.writeUTF("FILE_LIST");
            filedata = dis.readUTF();
            System.out.println(filedata);

        } catch (Exception e) {
        }
    }
}