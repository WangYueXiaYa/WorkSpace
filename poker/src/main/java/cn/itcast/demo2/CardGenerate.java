package cn.itcast.demo2;

public class CardGenerate {
    private Type type;
    private Generate generate;

    public CardGenerate(Generate generate, Type type) {
        this.type = type;
        this.generate = generate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Generate getGenerate() {
        return generate;
    }

    public void setGenerate(Generate generate) {
        this.generate = generate;
    }
}
