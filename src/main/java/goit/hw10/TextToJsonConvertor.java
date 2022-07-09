package goit.hw10;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class TextToJsonConvertor {

    public void convert ( String filePath, String jsonFilePath ) throws Exception {
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader ( new FileReader( filePath ) );
            writer = new FileWriter ( jsonFilePath );

            ArrayList<User> users = new ArrayList (  );
            String line = "";
            int counter = 0;

            while ((line = reader.readLine()) != null) {

                if ( counter++ == 0 ) { // Пропускаем первую строку
                    continue;
                }

                String [] parts = line .split ( "\\s" );    // Пропускаем пустые строки
                if ( parts .length != 2 ) {
                    continue;
                }

                users .add ( new User ( parts [0], parts [1] ) );
            }

            new Gson() .toJson ( users, writer );
        } finally {
            if ( reader != null ) {
                reader .close (  );
            }
            if ( writer != null ) {
                writer .close (  );
            }
        }
    }

    public static void main(String[] args) {
        try {
            new TextToJsonConvertor (  ) .convert ("file.txt", "user.json" );
        } catch ( FileNotFoundException fnfe ) {
            System.err.println ( "File not found" );
        } catch ( IOException ioe ) {
            System.err.println ( "Error while reading from file" );
        } catch ( Exception e ) {
            System.err.println ( "Common error" );
        }
    }
}
