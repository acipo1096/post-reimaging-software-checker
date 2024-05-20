import java.util.ArrayList;
import java.util.List;


public class Software {
    Hostname host = new Hostname();

    private List<String> softwareMaster = new ArrayList<String>();

    String hostnameCheck = host.showHostname();

    public Software() {
        addSoftware();
    }

    public List<String> getSoftwareMaster() {
        return softwareMaster;
    }
    public void addSoftware() {
        // Create a list to hold the number of software required on each computer

        // For brevity and privacy, only select software is being displayed on this "master list"
        softwareMaster.add("Adobe Acrobat (64-bit)");
        softwareMaster.add("Google Chrome");
        softwareMaster.add("Microsoft Edge");
        softwareMaster.add("Microsoft Office LTSC Professional Plus 2021 - en-us");
        softwareMaster.add("Microsoft OneDrive");
        softwareMaster.add("Mozilla Firefox (x64 en-US)");
        softwareMaster.add("VLC media player");
        softwareMaster.add("Zoom Workplace (64-bit)");

        // Certain computers don't need certain software. If a hostname doesn't match, remove the software from the master list
        // Why do it this way? What if software is installed and shouldn't be? The program won't catch it.
        if (!"hostname".equals(hostnameCheck) && !"hostname2".equals(hostnameCheck)) {
            softwareMaster.remove("Zoom Workplace (64-bit)");
        }

    }       

    public List<String> displaySoftware() {
        return softwareMaster;
    }
}
