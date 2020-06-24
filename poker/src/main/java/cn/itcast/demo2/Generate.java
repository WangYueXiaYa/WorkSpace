package cn.itcast.demo2;

public enum Generate {
    TWO("2",2),THREE("3",3),FOUR("4",4),FIVE("5",5),
    S("6",6),SEVEN("7",7),EIGHT("8",8),NINE("9",9),TEN("10",10),
    J("J",11),Q("Q",12),K("K",13),A("A",14);
    private String type;
    private int index;
    Generate(String type,int index){
        this.type = type;
        this.index =index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
