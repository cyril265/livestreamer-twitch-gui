package de.bisquallisoft.twitch.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;

public class IOUtils {


    private static final Logger log = LoggerFactory.getLogger(IOUtils.class);


    public static InputStream downloadFile(String link) {
        try {
            URL url = new URL(link);
            BufferedInputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();

            return new ByteArrayInputStream(response);
        } catch (IOException e) {
            log.error("Error downloading file", e);
        }
        return null;
    }

}
