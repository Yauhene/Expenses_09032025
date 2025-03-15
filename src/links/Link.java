package links;

public class Link<T> {
    private Link prev;
    private Link next;
    private final T element;

    public Link(T element) {
        this.element = element;
    }

    public T getLink() {
        return element;
    }

    public T getElement() {
        return element;
    }

}
