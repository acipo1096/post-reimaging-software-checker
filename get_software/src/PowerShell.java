import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class PowerShell {

    private String command = "powershell.exe foreach ($UKey in 'HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKLM:\\SOFTWARE\\Wow6432node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKCU:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKCU:\\SOFTWARE\\Wow6432node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*'){foreach ($Product in (Get-ItemProperty $UKey -ErrorAction SilentlyContinue)){if($Product.DisplayName -and $Product.SystemComponent -ne 1){$Product.DisplayName}}}";
    private String hostname = "powershell.exe hostname";
    private String adobeXD = "powershell.exe (Get-AppxPackage -Name \"*XD\").Name";
    private String completeAnatomy = "powershell.exe (Get-AppxPackage -Name \"*Anatomy*\").Name\"";
    private List<String> sortedLine = new ArrayList<String>();

    public PowerShell() {
        countSoftwareFromPC();
    }
    
    public String getCommand() {
        return command;
    }

    public String getHostname() {
        return hostname;
    }

    public String getAdobeXD() {
        return adobeXD;
    }

    public String getCompleteAnatomy() {
        return completeAnatomy;
    }

    public List<String> getSortedLine() {
        return sortedLine;
    }

    public void countSoftwareFromPC() {
        try {
            // Thanks for this script:
            // https://superuser.com/questions/1603763/how-can-i-run-a-single-command-to-show-all-installed-applications-in-windows-10

            // Executes the command but returns a memory location only - no output
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            Process powerShellHostname = Runtime.getRuntime().exec(hostname);
            Process powerShellAdobeXD = Runtime.getRuntime().exec(adobeXD);
            Process powerShellCompleteAnatomy= Runtime.getRuntime().exec(completeAnatomy);

            powerShellHostname.getOutputStream().close();
            powerShellAdobeXD.getOutputStream().close();
            powerShellCompleteAnatomy.getOutputStream().close();

            BufferedReader hostOut = new BufferedReader((new InputStreamReader(powerShellHostname.getInputStream())));
            BufferedReader adobeXDOut = new BufferedReader((new InputStreamReader(powerShellAdobeXD.getInputStream())));
            BufferedReader completeAnatomyOut = new BufferedReader((new InputStreamReader(powerShellCompleteAnatomy.getInputStream())));

            // Get the results
            powerShellProcess.getOutputStream().close();
            String line;
            int count = 0;
            BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

            System.out.println("SOFTWARE INSTALLED ON " + hostOut.readLine());
            System.out.println("------------------------------");

            // At this point, the software has been collected, but it's not in alphabetical order
            // Append each list item to the Java List and increment the total # of software 
            
            while ((line = stdout.readLine()) != null) {
                sortedLine.add(line);
                count++;

            }

            // Append Windows store apps to list, but only if they exist. Need to use readLine() to convert type from BufferedReader to String
            // Also need to declare new String variables, otherwise the program throws an error
            String adobeXDString;
            String completeAnatomyString;

            while((adobeXDString = adobeXDOut.readLine()) != null) {
                sortedLine.add(adobeXDString);
            }

            while ((completeAnatomyString = completeAnatomyOut.readLine()) != null) {
                sortedLine.add(completeAnatomyString);
            }

            // Sort alphabetically  and print the software list & count
            Collections.sort(sortedLine);
            for (String element : sortedLine) {
                System.out.println(element);
            }
            System.out.println("------------------------------");
            System.out.println("Total Software Installed: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> showPCSoftware() {
        return sortedLine;
    }
}
