public class TestingClass {
    private int val;
    public TestingClass(int val) {
        this.val = val;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(val);
    }
}
