package org.qme.installer;

import java.io.File;
import java.io.IOException;

/**
 * Installation for Mac - nearly identical to that for Linux.
 * @since 1.0.0
 */
import org.qme.release.QmeRelease;

import javax.swing.*;

public class MacInstaller extends Installer {

    /**
     * Same as Linux
     */
    public MacInstaller() {
        steps = 4;
    }

    /**
     * Install in home directory.
     * @param release which version
     */
    @Override
    public void install(QmeRelease release) {
        System.out.println("Installing for mac ...");
        coreInstall(release.getVersion(), System.getProperty("user.home"));
    }

    @Override
    public boolean isInstalled(String version) {
        return new File(
                System.getProperty("user.home") + "/.qme/"
                        + version + "/" + version + ".jar"
        ).exists();
    }

    @Override
    public void launchVersion(String version) {
        try {
            Runtime.getRuntime().exec(
                    "java -XstartOnFirstThread -jar " +
                            System.getProperty("user.home") + "/.qme/"
                            + version + "/" + version + ".jar"
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error has occurred.");
            System.exit(-1);
        }
    }
}
