package CarportUtil;

import DBAccess.MaterialMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
            String[] PriceToDouble = LinieOfMaterial[6].split(",");

            double price = Double.parseDouble(PriceToDouble[0] + "." + PriceToDouble[1]);
            String picture = LinieOfMaterial[7];
            String[] SpendingToDouble = LinieOfMaterial[8].split(",");

            double spending = Double.parseDouble(SpendingToDouble[0] + "." + SpendingToDouble[1]);

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

    public static ArrayList<Material>[] splitMaterialsByUnits(ArrayList<Material> materialList) {
        ArrayList[] splitedLists = new ArrayList[2];
        ArrayList<Material> packages = new ArrayList<>();
        ArrayList<Material> other = new ArrayList<>();
        splitedLists[0] = packages;
        splitedLists[1] = other;
        for (Material material : materialList) {
            if (material.getUnit().equals("pk.")) {
                splitedLists[0].add(material);
            } else splitedLists[1].add(material);
        }

        return splitedLists;
    }


    public static ArrayList<Material> sortMaterialsUnitPackage(ArrayList<Material> materialsByPackage) {
        ArrayList<Material> sorted = new ArrayList<>();
        Material[] matArr = new Material[materialsByPackage.size()];

        for (int i = 0; i < materialsByPackage.size(); i++) {
            matArr[i] = materialsByPackage.get(i);
        }

        for (int i = 0; i < matArr.length; i++) {
            if (matArr[i].getName().equals("boom")) {
                i++;

            } else {
                for (int j = i + 1; j < matArr.length; j++) {
                    if (matArr[i].equals(matArr[j])) {
                        matArr[j].setName("boom");
                        int size = matArr[i].getSize();
                        String comm = matArr[i].getComment() + ", " + matArr[j].getComment();
                        matArr[i].setSize(size + matArr[j].getSize());

                        matArr[i].setComment(comm);
                    }
                }
            }
        }


        for (int i = 0; i < matArr.length; i++) {
            if (!matArr[i].getName().equals("boom")) {
                sorted.add(matArr[i]);
            }
        }

        for (Material material : sorted) {
            String comment = material.getComment();
            String[] strArr = comment.split(", ");
            ArrayList<String> commentsList = new ArrayList<>();
            for (int i = 0; i < strArr.length; i++) {
                commentsList.add(strArr[i]);
            }
            Collections.sort(commentsList);

            for (int i = 0; i < commentsList.size() - 1; i++) {
                if (commentsList.get(i).equals(commentsList.get(i + 1))) {
                    commentsList.set(i, "boom");
                }
            }
            String newComment = "";
            int indexOfFirstUniq = 0;
            for (int i = 0; i < commentsList.size(); i++) {
                if (!commentsList.get(i).equals("boom")) {
                    newComment = commentsList.get(i);
                    indexOfFirstUniq = i;
                    break;
                }
            }
            for (int i = indexOfFirstUniq + 1; i < commentsList.size(); i++) {
                if (!commentsList.get(i).equals("boom")) {
                    newComment = newComment + ", " + commentsList.get(i);
                }

            }
            material.setComment(newComment);

        }

        return sorted;
    }

    public static ArrayList<Material> sortMaterialsOtherUnit(ArrayList<Material> materialsByOtherUnit) {
        ArrayList<Material> sorted = new ArrayList<>();
        Material[] matArr = new Material[materialsByOtherUnit.size()];

        for (int i = 0; i < materialsByOtherUnit.size(); i++) {
            matArr[i] = materialsByOtherUnit.get(i);
        }

        for (int i = 0; i < matArr.length; i++) {
            if (matArr[i].getName().equals("boom")) {
                i++;

            } else {
                for (int j = i + 1; j < matArr.length; j++) {
                    if (matArr[i].equals(matArr[j])) {
                        matArr[j].setName("boom");
                        int amount = matArr[i].getAmount();
                        String comm = matArr[i].getComment() + ", " + matArr[j].getComment();
                        matArr[i].setAmount(amount + matArr[j].getAmount());

                        matArr[i].setComment(comm);
                    }
                }
            }
        }


        for (int i = 0; i < matArr.length; i++) {
            if (!matArr[i].getName().equals("boom")) {
                sorted.add(matArr[i]);
            }
        }

        for (Material material : sorted) {
            String comment = material.getComment();
            String[] strArr = comment.split(", ");
            ArrayList<String> commentsList = new ArrayList<>();
            for (int i = 0; i < strArr.length; i++) {
                commentsList.add(strArr[i]);
            }
            Collections.sort(commentsList);

            for (int i = 0; i < commentsList.size() - 1; i++) {
                if (commentsList.get(i).equals(commentsList.get(i + 1))) {
                    commentsList.set(i, "boom");
                }
            }
            String newComment = "";
            int indexOfFirstUniq = 0;
            for (int i = 0; i < commentsList.size(); i++) {
                if (!commentsList.get(i).equals("boom")) {
                    newComment = commentsList.get(i);
                    indexOfFirstUniq = i;
                    break;
                }
            }
            for (int i = indexOfFirstUniq + 1; i < commentsList.size(); i++) {
                if (!commentsList.get(i).equals("boom")) {
                    newComment = newComment + ", " + commentsList.get(i);
                }

            }
            material.setComment(newComment);

        }

        return sorted;
    }

    public static void setPackages(ArrayList<Material> materials) throws LoginSampleException {

        for (Material material : materials) {

            int availableSize = MaterialMapper.getPackageSize(material.getName());
            int quantity;

            int size = material.getSize();
            int rest = size % availableSize;
            if (rest == 0) {
                quantity = size / availableSize;
            } else {
                quantity = (size - rest) / availableSize + 1;
            }
            material.setAmount(quantity);
            material.setAvailablesize(1);
        }

    }


    public static String setLengths(ArrayList<Material> materials) throws LoginSampleException {
        String msg1 = "Følgende: ";
        String msg2 = " findes ikke i databasen, som er langt nok. " +
                "Du kan bestille en ekstra funktionalitet for kun 500 kr for at kunne tilføje vare til databasen."
                + "Indtil videre den tilgængelig længde er lige med den du skal bruge. Hilsen, IT folk";
        for (Material material : materials) {

            ArrayList<Integer> availableSizesFromDB = MaterialMapper.getLengths(material.getName());


            int size = material.getSize();

            if (material.getSize() > availableSizesFromDB.get(availableSizesFromDB.size() - 1)) {
                material.setAvailablesize(material.getSize());
                msg1 = msg1 + material.getName() + ", ";
            } else if (size < availableSizesFromDB.get(0)) {
                material.setAvailablesize(availableSizesFromDB.get(0));
            } else

                for (int i = 0; i < availableSizesFromDB.size(); i++) {
                    if (size >= availableSizesFromDB.get(i) && size < availableSizesFromDB.get(i + 1)) {
                        material.setAvailablesize(availableSizesFromDB.get(i));
                        break;
                    } else i++;
                }
        }
        if (msg1.equals("Følgende: ")) {
            return "Beregning af den tilgængelig længde til hver material lykkedes";
        } else
            return msg1 + msg2;
    }


}