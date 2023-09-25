package jcrapi2.build;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class ReleaseVersionChecker {

    public static void main(String[] args) {
        String versionTxt = readFileToString(args[0]).substring(1);
        String pom = readFileToString(args[1]);
        int start = pom.indexOf("<version>");
        int end = pom.indexOf("</version>");
        String pomVersion = pom.substring(start + 9, end);
        if (!versionTxt.equals(pomVersion)) {
            log.error("*************************************************");
            log.error("*** POM VERSION DON'T MATCHES VERSION.TXT !!! ***");
            log.error("*************************************************");
            throw new IllegalStateException("Versions are not matching!");
        }
    }

    private static String readFileToString(String filename) {
        File file = new File(filename);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return new String(fileInputStream.readAllBytes());
        } catch (IOException e) {
            throw new IllegalStateException(
                    "release version checker could not read file: " + filename);
        }
    }
}
