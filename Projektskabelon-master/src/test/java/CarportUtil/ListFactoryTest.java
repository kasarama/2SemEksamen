package CarportUtil;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class ListFactoryTest {
ArrayList<Material> materialList = new ArrayList<>();
ArrayList<Material>[] splited=new ArrayList[2];
Material m1 = new Material("dog", 100,0, "pk.",0,"roof" );

Material m2 = new Material("dog", 100,10, "m",20,"wall" );

Material m3 = new Material("cat", 100,0, "pk.",0,"door" );

Material m4 = new Material("horse", 110,0, "pk.",0,"door" );

Material m5 = new Material("dog", 100,0, "pk.",0,"roof" );

Material m6 = new Material("dog", 50,0, "pk.",0,"wall" );

Material m7 = new Material("dog", 100,10, "m",10,"roof" );

Material m8 = new Material("rat", 1,1, "stk",100,"roof" );

Material m9 = new Material("horse", 10,0, "pk.",0,"door" );

Material m10 = new Material("cow", 1,1, "stk",100,"roof" );

Material m11= new Material("rat", 100,1, "stk",0,"wall" );

Material m12 = new Material("cat", 200,0, "pk.",0,"roof" );

Material m13 = new Material("dog", 25,0, "pk.",0,"wall" );

    //String name, int size, int availablesize, String unit, int amount, String comment
    @Before
    public void setUp() throws Exception {
        materialList.add(m1);
        materialList.add(m2);
        materialList.add(m3);
        materialList.add(m4);
        materialList.add(m5);
        materialList.add(m6);
        materialList.add(m7);
        materialList.add(m8);
        materialList.add(m9);
        materialList.add(m10);
        materialList.add(m11);
        materialList.add(m12);
        materialList.add(m13);
    }
    @Test
    public void equalMaterials (){
        assertTrue(m8.equals(m10));
    }

    @Test
    public void splitMaterialsByUnits() {
        splited=ListFactory.splitMaterialsByUnits(materialList);
        Integer[]sizes = {splited[0].size(),splited[1].size(), (splited[0].size()+splited[1].size())};
        Integer[]expectedSizes={8,5,13};
        for (Material material:splited[0]) {
            System.out.println(material.getName()+material.getSize()+material.getAvailablesize()+material.getUnit());
        }
        assertEquals(expectedSizes,sizes);
    }



    @Test
    public void sortMaterialsPackage() throws LoginSampleException {

        splited=ListFactory.splitMaterialsByUnits(materialList);
        ArrayList<Material> justPackages=splited[0];
        ArrayList<Material> sorted= ListFactory.sortMaterialsUnitPackage(justPackages);
        for (Material material: sorted) {
            System.out.println(material.getName()+material.getSize()+material.getUnit()+" "+material.getComment());

        }
        assertEquals(3,sorted.size());
    }

    @Test
    public void sortMaterialsOtherUnit() throws LoginSampleException {
materialList.add(new Material("horse", 10,0, "ss.",10,"door"));
materialList.add(new Material("horse", 10,0, "ss.",10,"roof"));
materialList.add(new Material("horse", 10,0, "ss.",10,"wall"));
materialList.add(new Material("rat", 0,0, "stk",18,"car"));
        splited=ListFactory.splitMaterialsByUnits(materialList);
        ArrayList<Material> otherUnits=splited[1];
        for (Material material: otherUnits) {
            System.out.println(material.getName()+" siez: "+material.getSize()+" unit "+material.getUnit()+
                    " available size: "+ material.getAvailablesize()+" amount: "+material.getAmount()+" comment "+material.getComment());

        }

        System.out.println();
        System.out.println();
        ArrayList<Material> sorted= ListFactory.sortMaterialsOtherUnit(otherUnits);
        for (Material material: sorted) {
            System.out.println(material.getName()+" siez: "+material.getSize()+" unit "+material.getUnit()+
                    " available size: "+ material.getAvailablesize()+" amount: "+material.getAmount()+" comment "+material.getComment());

        }
        assertEquals(3,sorted.size());

    }

    @Test
    public void sortingStrings() {
        ArrayList<String> strings= new ArrayList<>();
        strings.add("cdo");
        strings.add("cdo");
        strings.add("cdo");
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("abc");
        strings.add("abc");
        strings.add("abc");
        strings.add("Magdalena");
        strings.add("magdalena");
        strings.add("magdalena");
        strings.add("magdalena");
        strings.add("Magdalena");
        strings.add("magdalena");
        strings.add("magdalena");
        strings.add("aab");
        strings.add("aab");
        strings.add("aab");
        strings.add("aab");
        strings.add("aab");

        Collections.sort(strings);



        for (int i = 0; i < strings.size()-1; i++) {
            if (strings.get(i).equals(strings.get(i+1) ) ){
                strings.set(i,"boom");
            }
        }
        for (String s:strings) {
            System.out.println(s);
        }


        String newComment = "";
        int indexOfFirstUniq = 0;
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("Is testing String on index " + i);
            if (!strings.get(i).equals("boom")) {
                newComment = strings.get(i);
                indexOfFirstUniq = i;
                break;
            }
        }
        System.out.println(indexOfFirstUniq);

        for (int i = indexOfFirstUniq+1; i < strings.size(); i++) {
            if (!strings.get(i).equals("boom")) {
                newComment = newComment + ", " + strings.get(i);
                System.out.println(newComment);
            }

        }
    }


}