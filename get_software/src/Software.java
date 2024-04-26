import java.util.ArrayList;
import java.util.List;

public class Software {
    private List<String> softwareMaster = new ArrayList<String>();

    public Software() {
        addSoftware();
    }

    public List<String> getSoftwareMaster() {
        return softwareMaster;
    }
    public void addSoftware() {
        // Create a list to hold the number of software required on each computer
        softwareMaster.add("Adobe Acrobat (64-bit)");
        softwareMaster.add("Adobe After Effects 2023");
        softwareMaster.add("Adobe Animate 2023");
        softwareMaster.add("Adobe Audition 2023");
        softwareMaster.add("Adobe Bridge 2023");
        softwareMaster.add("Adobe Character Animator 2023");
        softwareMaster.add("Adobe Creative Cloud");
        softwareMaster.add("Adobe Dimension");
        softwareMaster.add("Adobe Dreamweaver 2021");
        softwareMaster.add("Adobe Genuine Service");
        softwareMaster.add("Adobe Illustrator 2023");
        softwareMaster.add("Adobe InCopy 2023");
        softwareMaster.add("Adobe InDesign 2023");
        softwareMaster.add("Adobe Lightroom Classic");
        softwareMaster.add("Adobe Media Encoder 2023");
        softwareMaster.add("Adobe Photoshop 2023");
        softwareMaster.add("Adobe Prelude 2022");
        softwareMaster.add("Adobe Premiere Pro 2023");
        softwareMaster.add("Adobe Premiere Rush");
        softwareMaster.add("Adobe.XD"); // Needs to match name in Windows backend
        softwareMaster.add("Audacity 3.5.0");
        softwareMaster.add("Brackets");
        softwareMaster.add("Cisco AnyConnect Network Access Manager");
        softwareMaster.add("Cisco AnyConnect Secure Mobility Client ");
        softwareMaster.add("Citrix Receiver 4.5");
        softwareMaster.add("Complete Anatomy");
        softwareMaster.add("CrowdStrike Windows Sensor");
        softwareMaster.add("EndNote 21");
        softwareMaster.add("Google Chrome");
        softwareMaster.add("HandBrake 1.7.3");
        softwareMaster.add("Hofstra Alerts version 2.0.2");
        softwareMaster.add("IBM SPSS Statistics");
        softwareMaster.add("Java 8 Update 191 (64-bit)");
        softwareMaster.add("Java SE Development Kit 8 Update 191 (64-bit)");
        softwareMaster.add("Lenovo System Update");
        softwareMaster.add("Local Administrator Password Solution");
        softwareMaster.add("MAT CBT Console v4.0");
        softwareMaster.add("Microsoft Edge");
        softwareMaster.add("Microsoft Edge Update");
        softwareMaster.add("Microsoft Edge WebView2 Runtime");
        softwareMaster.add("Microsoft Office LTSC Professional Plus 2021 - en-us");
        softwareMaster.add("Microsoft OneDrive");
        softwareMaster.add("Microsoft Visual C++ 2013 Redistributable (x64) - 12.0.40664");
        softwareMaster.add("Microsoft Visual C++ 2013 Redistributable (x86) - 12.0.40664");
        softwareMaster.add("Microsoft Visual C++ 2015-2022 Redistributable (x64) - 14.32.31326");
        softwareMaster.add("Microsoft Visual C++ 2015-2022 Redistributable (x86) - 14.32.31326");
        softwareMaster.add("Mozilla Firefox (x64 en-US)");
        softwareMaster.add("Mozilla Maintenance Service");
        softwareMaster.add("MySQL Connector/ODBC 5.2(a)");
        softwareMaster.add("Notepad++ (64-bit x64)");
        softwareMaster.add("ParseHub 54.0.1 (x86 en-US)");
        softwareMaster.add("Poll Everywhere");
        softwareMaster.add("R for Windows 4.3.2");
        softwareMaster.add("RStudio");
        softwareMaster.add("ResearchSoft Direct Export Helper");
        softwareMaster.add("SALT 20 Clinical");
        softwareMaster.add("SALT PDF Printer");
        softwareMaster.add("Sassafras KeyServer Platform Client");
        softwareMaster.add("UXP WebView Support");
        softwareMaster.add("Universal Imaging Utility - Live Version");
        softwareMaster.add("VLC media player");
        softwareMaster.add("Zoom Workplace (64-bit)");
    }       

    public List<String> displaySoftware() {
        return softwareMaster;
    }
}
