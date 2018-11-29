public class Outer {
    String data = "外部类別";

    public class Inner {
        String data = "內部类別";

        public String getOuterData() {
            return Outer.this.data;
        }
    }
}
