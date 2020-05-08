package CarportUtil;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class ListFactory {
    public static void saveInFile(Material material, double spending) throws LoginSampleException {
        //todo save material in text file
        String windows = "dbAccess/materials.txt";
        String path=windows;
        File file = new File(path);

        try {

            FileWriter fw = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(fw);
            String linie = String.format("%s;%d;%d;%s;%s;%s;%.2f;%s;%.2",material.getName(), material.getWidth(),
                    material.getThickness(), material.getUnit(), material.getKeyword(), material.getCategory(),
                    material.getPrice(), material.getPicture(),spending);
            out.newLine();
            out.write(linie);
            out.close();
        }catch (IOException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static ArrayList<Material> readFromFile(){
        //todo read data from textfile to send them to DB
        ArrayList<Material> materials= new ArrayList<>();
        return materials;
    }

    public static ArrayList<Material> sortMaterialList(ArrayList<Material> materialList){

        for (int i = 0; i < materialList.size(); i++) {

            for (Material material : materialList) {
                if (materialList.get(i).equals(material.getName())){

                }

            }
        }return new ArrayList<Material>();
    }
}