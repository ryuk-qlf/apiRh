package fr.facil.facilapi.utils;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class ApacheFtp {

    /*

    String server = "80.11.12.120";
        String user = "FacilFtp";
        String password = "facil";

    FTPClient ftpClient = new FTPClient();

        ftpClient.connect(server, 21);
        ftpClient.login(user, password);

     */

    private String server;

    private String user;

    private String password;

    private static FTPClient client = new FTPClient();

    public ApacheFtp(String server, String user, String password) {
        this.server = server;
        this.user = user;
        this.password = password;


    }

    public void setConection() throws IOException {
        client.connect(server, 21);
        client.login(user, password);
        client.enterLocalPassiveMode();
    }

    public static FTPClient getClient() {
        return client;
    }

    public static void setDisconnect() throws IOException {
        client.disconnect();
    }
}
