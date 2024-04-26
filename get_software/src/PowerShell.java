import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class PowerShell {

    Hostname hostname = new Hostname();
    String hostname2 = hostname.showHostname();

    private String command = "powershell.exe foreach ($UKey in 'HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKLM:\\SOFTWARE\\Wow6432node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKCU:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKCU:\\SOFTWARE\\Wow6432node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*'){foreach ($Product in (Get-ItemProperty $UKey -ErrorAction SilentlyContinue)){if($Product.DisplayName -and $Product.SystemComponent -ne 1){$Product.DisplayName}}}";
    private String adobeXD = "powershell.exe (Get-AppxPackage -Name \"*XD\").Name";
    private String completeAnatomy = "powershell.exe (Get-AppxPackage -Name \"*Anatomy*\").Name\"";
    private List<String> sortedLine = new ArrayList<String>();

    public PowerShell() {
        countSoftwareFromPC();
    }
    
    public String getCommand() {
        return command;
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
            Process powerShellAdobeXD = Runtime.getRuntime().exec(adobeXD);
            Process powerShellCompleteAnatomy= Runtime.getRuntime().exec(completeAnatomy);

            powerShellAdobeXD.getOutputStream().close();
            powerShellCompleteAnatomy.getOutputStream().close();

            BufferedReader adobeXDOut = new BufferedReader((new InputStreamReader(powerShellAdobeXD.getInputStream())));
            BufferedReader completeAnatomyOut = new BufferedReader((new InputStreamReader(powerShellCompleteAnatomy.getInputStream())));

            // Get the results
            powerShellProcess.getOutputStream().close();
            String line;
            int count = 0;
            BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

            System.out.println("SOFTWARE INSTALLED ON " + hostname2);
            System.out.println("----------------------------------------");

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

            // if (hostnameString != "SOM0219001" || hostnameString  != "SOM0219002" || hostnameString != "SOM0219003" || hostnameString != "SOM0219004") {
            //     sortedLine.remove("PaperCut MF Client");
            //     System.out.println(sortedLine.remove("PaperCut MF Client"));
            //     System.out.println(hostnameString);
            //     System.out.println(hostnameString.getClass().getSimpleName());
            // }

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
