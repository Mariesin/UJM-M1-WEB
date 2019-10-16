package projet.popngo;

public class Comment{
    private Person source;
    private Person target;
    private String text;

    public Person getSource() {
        return source;
    }

    public void setSource(Person source) {
        this.source = source;
    }

    public Person getTarget() {
        return target;
    }

    public void setTarget(Person target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment(Person source, Person target, String text) {
        this.source = source;
        this.target = target;
        this.text = text;
    }
}