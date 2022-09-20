class TestVar {
    static public void main(String args[]) {
    float f = 12.34f;
    Float F = Float.valueOf(f); // de float vers Float
    String s;
    F = Float.valueOf("12.34"); // de String vers Float
    f = Float.parseFloat ("12.34"); // de String vers float
    f = F.floatValue(); // de Float vers float
    s = F.toString(); // de Float vers String
    s = String.valueOf(f); // de float vers String
    System.out.println("string"+s);
    }

}