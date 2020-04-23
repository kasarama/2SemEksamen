package FunctionLayer;

public class Material {

        private int materialID;
        private String name;
        private int size;
        private String unit;
        private String keyword;
        private String category;

        public Material(int materialID, String name, int size, String unit, String keyword, String category)
        {
            this.materialID = materialID;
            this.name = name;
            this.size = size;
            this.unit = unit;
            this.keyword = keyword;
            this.category = category;
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

        public String getUnit() {
            return unit;
        }

        public String getKeyword() {
            return keyword;
        }

        public String getCategory() {
            return category;
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

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public void setCategory(String category) {
            this.category = category;
        }
}

