package CarportUtil;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class ListFactory {
    public static void saveInFile(Material material) throws LoginSampleException {
        //todo save material in text file
        String windows = "dbAccess/materials.txt";
        String mac = "";
        String path=windows;
        File file = new File(path);
        if (!file.exists()){
            path=mac;
        }


       try {
           FileWriter fw = new FileWriter(path, true);
           BufferedWriter out = new BufferedWriter(fw);
           String linie = String.format("%s;%d;%s;%s;%s;%.2f;%s",material.getName(), material.getSize(),
                   material.getUnit(), material.getKeyword(), material.getCategory(), material.getPrice(),
                   material.getPicture());
           out.newLine();
           out.write(linie);
           out.close();
       }catch (IOException ex) {
           ex.printStackTrace();
           throw new LoginSampleException(ex.getMessage());
       }
    }
}
