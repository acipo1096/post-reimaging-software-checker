import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        PowerShell powershell = new PowerShell();
        Software software = new Software();

        System.out.println("");
        System.out.println("CHECKING FOR MISSING SOFTWARE...");

        // Subtracts the software listed on the computer from the software from the main list
        List<String> softwareMasterList = software.displaySoftware();
        List<String> sortedLine = powershell.showPCSoftware();
        softwareMasterList.removeAll(sortedLine);

        // Pauses the program for one second for readability
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Returns the missing software and the count of each
        if (softwareMasterList.size() == 0) {
            System.out.println("Scan complete. All software successfully installed!");
        }
        else {
            System.out.println("Scan complete. This computer is missing " + softwareMasterList.size() + " software: ");
            for (String element2 : softwareMasterList) {
                System.out.println(element2);
            }
        }

    }
}