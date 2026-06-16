public class Day9{
static class College implements AutoCloseable{
    College(){
        System.out.println("College Opened");
    }
    @Override
    public void close() throws Exception {
        System.out.println("College Closed");
    }
}
static class Department extends College{
    Department(){
        System.out.println("Department of AIDS Have opened");
    }
    @Override
    public void close() throws Exception {
        System.out.println("Department of AIDS Has Closed");
        super.close();
    }
}
static class Year extends Department{
    Year(){
        System.out.println("I-Year of AIDS Have opened");
    }
    @Override
    public void close() throws Exception {
        System.out.println("I-Year of AIDS Has Closed");
        super.close();
    }
}
static void main() throws Exception {
    try(Year year = new Year()){

    }

}
}