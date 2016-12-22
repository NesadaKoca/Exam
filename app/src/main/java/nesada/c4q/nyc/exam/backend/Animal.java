package nesada.c4q.nyc.exam.backend;

public class Animal {
    private String name;
    private String textColor;
    private String background;

    public Animal(String name, String textColor, String background){
        this.name = name;
        this.textColor = textColor;
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getBackground() {
        return background;
    }
}
