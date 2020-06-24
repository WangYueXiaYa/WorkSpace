package cn.itcast.demo2;

public class Main {
    public static void main(String[] args) {
       CardGenerate[] black={new CardGenerate(Generate.TWO,Type.HEART),new CardGenerate(Generate.THREE,Type.DIAMOND)
               ,new CardGenerate(Generate.FIVE,Type.SPADE),new CardGenerate(Generate.NINE,Type.CLUB)
               ,new CardGenerate(Generate.K,Type.DIAMOND)};
       CardGenerate[] white={new CardGenerate(Generate.TWO,Type.CLUB),new CardGenerate(Generate.THREE,Type.HEART)
                ,new CardGenerate(Generate.FOUR,Type.SPADE),new CardGenerate(Generate.EIGHT,Type.CLUB)
                ,new CardGenerate(Generate.A,Type.HEART)};

        CardComplete cs1=new CardComplete(black);
        CardComplete cs2=new CardComplete(white);
        if (cs1.compareTo(cs2)==1){
            System.out.println("Black wins");
        }
        else if (cs1.compareTo(cs2)==-1){
            System.out.println("White wins");
        }
        else
            System.out.println("Tie");

    }

}
