package CarportUtil;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Magdalena
 */
public class ListFactory {
    public static void saveInFile(Material material) throws LoginSampleException {
        //todo save material in text file
        String windows = "dbAccess/materials.txt";
        String path = windows;
        File file = new File(path);

        try {

            FileWriter fw = new FileWriter(path, true);
            BufferedWriter out = new BufferedWriter(fw);
            String linie = String.format("%s;%d;%d;%s;%s;%s;%.2f;%s;%.2f", material.getName(), material.getWidth(),
                    material.getThickness(), material.getUnit(), material.getKeyword(), material.getCategory(),
                    material.getPrice(), material.getPicture(), material.getSpending());
            out.newLine();
            out.write(linie);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Material> materialsFromFile(String path) throws LoginSampleException {
        //todo read data from textfile to send them to DB

        ArrayList<Material> materials = new ArrayList<>();
        if (path.equals("")) {
            path = "dbAccess/materials.txt";
        }

        ArrayList<String[]> materialsFromFile = attributesFromFile(path);

        for (String[] LinieOfMaterial : materialsFromFile) {
            Material material = new Material();
            String name = LinieOfMaterial[0];
            int width = Integer.parseInt(LinieOfMaterial[1]);
            int thickness = Integer.parseInt(LinieOfMaterial[2]);
            String unit = LinieOfMaterial[3];
            String keyword = LinieOfMaterial[4];
            String category = LinieOfMaterial[5];
            String[] PriceToDouble=LinieOfMaterial[6].split(",");

            double price = Double.parseDouble(PriceToDouble[0]+"."+PriceToDouble[1]);
            String picture = LinieOfMaterial[7];
            String[] SpendingToDouble=LinieOfMaterial[8].split(",");

            double spending = Double.parseDouble(SpendingToDouble[0]+"."+SpendingToDouble[1]);

            material.setName(name);
            material.setWidth(width);
            material.setThickness(thickness);
            material.setUnit(unit);
            material.setKeyword(keyword);
            material.setCategory(category);
            material.setPrice(price);
            material.setPicture(picture);
            material.setSpending(spending);

            materials.add(material);


        }
        return materials;
    }


    public static ArrayList attributesFromFile(String path) throws LoginSampleException {
        ArrayList<String[]> materials = new ArrayList<>();
        try {
                File myObj = new File(path);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String material = myReader.nextLine();
                    String[] attributes = material.split(";");
                    materials.add(attributes);
                }
                myReader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
        return materials;
    }


    public static ArrayList<Material> sortMaterialList(ArrayList<Material> materialList) {

        for (int i = 0; i < materialList.size(); i++) {

            for (Material material : materialList) {
                if (materialList.get(i).equals(material.getName())) {

                }

            }
        }
        return new ArrayList<Material>();
    }
}