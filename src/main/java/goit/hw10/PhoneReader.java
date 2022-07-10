package goit.hw10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneReader {

    public void read ( String filePath ) throws Exception {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader ( new FileReader ( filePath ) );
            String line = "";
            while ((line = reader.readLine()) != null) {
                if ( isValid ( line ) ) {
                    System.out.println ( line );
                }
            }
        } finally {
            if ( reader != null ) {
                reader .close (  );
            }
        }
    }

    private boolean isValid ( String line ) {
        if (
            line .matches ( "\\d{3}-\\d{3}-\\d{4}" ) ||
            line .matches ( "\\(\\d{3}\\)\\s\\d{3}-\\d{4}" )
        ) {
            return true;
        }
        return false;
    }

    public static void main ( String [] args ) {
        try {
            new PhoneReader(  ) .read ("file-phones.txt");
        } catch ( FileNotFoundException fnfe ) {
            System.err.println ( "File not found" );
        } catch ( IOException ioe ) {
            System.err.println ( "Error while reading from file" );
        } catch ( Exception e ) {
            System.err.println ( "Common error" );
        }
    }
}
