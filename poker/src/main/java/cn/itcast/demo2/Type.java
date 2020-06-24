package cn.itcast.demo2;

public enum Type {
    SPADE(1),HEART(2),CLUB(3),DIAMOND(4);
    private int i;

    Type(int index){
        this.i=index;
    }//构造花色的方法

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
