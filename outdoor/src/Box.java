public class Box<T> {
    T item;

    public void Box(T item){
        this.item = item;
    }

    public void printItem(){
        System.out.println(item.toString());
    }
    /*public void createNewItem(){
        T newInstance = new T();
    }*/
}
