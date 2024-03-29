package pl.lublin.wsei.java.cwiczenia;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class CopyFromUrl {


    public static void main(String[] args) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        long startTime = System.currentTimeMillis();
        URL url = new URL("https://filesamples.com/samples/image/tiff/sample_1920%C3%971280.tiff");

        try {
            in = new BufferedInputStream(url.openStream());
            out = new BufferedOutputStream(new FileOutputStream("imt_copyurl.tiff"));
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch(IOException e ){
            System.out.println("IOException " + e.getMessage());
            e.printStackTrace();
        } finally {
            if(in!=null) {
                in.close();
            }
            if(out!=null) {
                out.close();
            }
        }
        System.out.println("Czas wykonania: " + (System.currentTimeMillis() - startTime) + "ms.");
    }


}