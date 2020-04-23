package FunctionLayer;

public class Material {

        private int materialID;
        private String name;
        private int size;
        private String unit;
        private String keyword;
        private double price;
        private String comment;

        public Material(int materialID, String name, int size)
        {
            this.materialID = materialID;
            this.name = name;
            this.size = size;
        }

        //Getters
        public int getMaterialID() {
            return materialID;
        }
        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        //Setters
        public void setMaterialID(int materialID) {
            this.materialID = materialID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSize(int size) {
            this.size = size;
        }
}

