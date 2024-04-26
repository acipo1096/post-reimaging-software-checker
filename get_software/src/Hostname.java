import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hostname {

    private String hostname = "powershell.exe hostname";

    public String getHostname() {
        return hostname;
    }

    public String showHostname() {
        try {
            Process powerShellHostname = Runtime.getRuntime().exec(hostname);
            powerShellHostname.getOutputStream().close();
            BufferedReader hostOut = new BufferedReader((new InputStreamReader(powerShellHostname.getInputStream())));
            String hostnameString = hostOut.readLine();
            return hostnameString;


        } catch (Exception e) {
            e.printStackTrace();
            return "Error!";
        }

    }

}
