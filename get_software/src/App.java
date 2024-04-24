import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException{

        // Can I create an array, or something proper, to compare the installed software with?
        // EDIT: List might be better right now so I can compare
        List<String> software = new ArrayList<String>();
        software.add("Adobe Acrobat (64-bit)");
        software.add("Adobe Creative Cloud");
        software.add("Cisco AnyConnect Secure Mobility Client");

        System.out.println(software);

        System.out.println("");


        // Get version
        // Thanks for this script: https://superuser.com/questions/1603763/how-can-i-run-a-single-command-to-show-all-installed-applications-in-windows-10
        String command2 = "powershell.exe foreach ($UKey in 'HKLM:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKLM:\\SOFTWARE\\Wow6432node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKCU:\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*','HKCU:\\SOFTWARE\\Wow6432node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\*'){foreach ($Product in (Get-ItemProperty $UKey -ErrorAction SilentlyContinue)){if($Product.DisplayName -and $Product.SystemComponent -ne 1){$Product.DisplayName}}}";
        
        // Executes the command but returns a memory location only - no output
        Process powerShellProcess = Runtime.getRuntime().exec(command2);

        // Get the results
        powerShellProcess.getOutputStream().close();
        String line;
        int count = 0;
        BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

        // At this point, the software has been collected, but it's not in alphabetical order

        // Create new List
        List<String> sortedLine = new ArrayList<String>();

        // Append each list item to the Java List and increment the total # of software
        while ((line = stdout.readLine()) != null) {
            sortedLine.add(line);
            count++;

        }
        // Sort and print the software list & count
        Collections.sort(sortedLine);
        for (String element : sortedLine) {
            System.out.println(element);
        }
        System.out.println("------------------------------");
        System.out.println("Total Software Installed: " + count);
    }
}