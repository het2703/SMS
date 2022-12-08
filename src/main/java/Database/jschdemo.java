package Database;
import java.io.ByteArrayOutputStream;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class jschdemo {


    public static void main(String args[]) throws Exception {
        String host = "your.ssh.server";
        String username = "username";
        String password = "password";
        int port = 22;
        String command = "ls";
        listFiles(username, password, host, port, command);
    }

    public static String listFiles(String host, String username,
                                   String password, int port, String command) throws Exception {
        Session session = null;
        ChannelExec channel = null;
        String response = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.setErrStream(errorStream);
            channel.connect();
            while (channel.isConnected()) {
                Thread.sleep(100);
            }
            response = new String(responseStream.toByteArray());
            String errorResponse = new String(errorStream.toByteArray());
            if(!errorResponse.isEmpty()) {
                throw new Exception(errorResponse);
            }
        } finally {
            if (session != null)
                session.disconnect();
            if (channel != null)
                channel.disconnect();
        }
        return response;
    }
}
