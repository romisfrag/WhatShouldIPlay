package romisfrag.whatshouldiplay.input_output;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Created by delgado on 07/11/17.
 */

public class StorageManager {

    public Context ctxt;

    public StorageManager(Context ctxt){
        this.ctxt = ctxt;
    }

    public boolean isFileHere(String fileName){
        File file = new File(ctxt.getFilesDir(), fileName);
        return file.exists();
    }


    public void saveString(String fileName,String content){

        File file = new File(ctxt.getFilesDir(), fileName);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
            Toast.makeText(ctxt, "God save the queen", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(ctxt, "saveString : can't save", Toast.LENGTH_SHORT).show();
        }
    }

    public String readFile(String fileName){

        String res = "";

        File file = new File(ctxt.getFilesDir(), fileName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                res += sCurrentLine;
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(ctxt, "readFile : can't open", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(ctxt, "readFile : can't read", Toast.LENGTH_SHORT).show();
        }
        return res;
    }


}
