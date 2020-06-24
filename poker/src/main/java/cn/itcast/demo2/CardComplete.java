package cn.itcast.demo2;


import java.util.Arrays;
import java.util.Comparator;

public class CardComplete implements Comparable{
   private CardGenerate[] cards = new CardGenerate[5];

    public CardComplete(CardGenerate[] cards) {
        this.cards = cards;
        Arrays.sort(cards, new cmp());
    }

    public int getvalue(int i){
        CardGenerate c= cards[i];
        return c.getGenerate().getIndex();

    }
    public boolean isHigh() {
        if(isFlush()|isStraightFlush()|isStraight() |isFullHouse()|isThree()|isFour()|getPair() == 2|getPair() == 1)
            return false;
        else
            return true;
    }
    public int comparemiddle(Object o) {
        if (this.getvalue(2)>((CardComplete) o).getvalue(2))
            return 1;
        else return -1;
    }
    public int comparehigh(Object o) {
        for(int i=1;i<5;i++){
            if (this.getvalue(5-i)!=((CardComplete) o).getvalue(5-i)){
                if (this.getvalue(5-i)>((CardComplete) o).getvalue(5-i)){
                    return 1;
                }
                else return -1;
            }
        }
        return 0;
    }
    public int getPair() {
        int res = 0;
        for(int i=0;i<5;i++){
            for(int j=i+1;j<5;j++){
                if(cards[i].getGenerate()==cards[j].getGenerate())
                    res++;
            }
        }
        return res;
    }
    public int getPairone() {
        for(int i=0;i<5;i++){
            for(int j=i+1;j<5;j++){
                if(cards[i].getGenerate().getIndex()==cards[j].getGenerate().getIndex())
                    return cards[i].getGenerate().getIndex();
            }
        }
        return 0;
    }
    public int[] getPairtwo() {
        int res=0;
        int[] pairArray={};
        for(int i=0;i<5;i++){
            for(int j=i+1;j<5;j++){
                if(cards[i].getGenerate().getIndex()==cards[j].getGenerate().getIndex())
                    pairArray[res]=cards[res].getGenerate().getIndex();
                res++;}
        }
        if (pairArray[0]>pairArray[1]){
            int a=pairArray[0];
            pairArray[1]=a;
            pairArray[0]=pairArray[1];
        }

        return pairArray;
    }
    public int comparePairtwo(Object o) {
        for(int i=0;i<2;i++) {
            if (this.getPairtwo()[i] != ((CardComplete) o).getPairtwo()[i]) {
                if (this.getPairtwo()[i] > ((CardComplete) o).getPairtwo()[i]) {
                    return 1;
                } else if (this.getPairtwo()[i] < ((CardComplete) o).getPairtwo()[i]) {
                    return -1;
                }
            }
        }
        return this.comparehigh(o);
    }




    public int comparePairone(Object o) {
        if(this.getPairone()!=((CardComplete) o).getPairone()) {
            if (this.getPairone() > ( (CardComplete) o).getPairone()) {
                return 1;
            } else return -1;
        }
        else {
            return this.comparehigh(o);
        }


    }



    public boolean isThree() {//三条
        return (getPair()==3);
    }

    public boolean isStraight() {//顺子
        int a = cards[4].getGenerate().getIndex() - cards[3].getGenerate().getIndex();
        int b = cards[3].getGenerate().getIndex() - cards[2].getGenerate().getIndex();
        int c = cards[2].getGenerate().getIndex() - cards[1].getGenerate().getIndex();
        int d = cards[1].getGenerate().getIndex() - cards[0].getGenerate().getIndex();
        if (a == b && b == c && c == d) {
            return true;
        } else if (a == b && b == c && d == 9) {
            // return 2;
            return true;
        }
        return false;
    }
    public boolean isFlush() {
        for (int i = 0; i < 4; i++) {
            if (cards[i].getType() != cards[i + 1].getType())
                return false;
        }
        return true;
    }
    public boolean isFullHouse() {//葫芦
        return (getPair() == 4);
    }//葫芦


    public boolean isFour() {//铁支
        return (getPair()==6);
    }//铁支

    public boolean isStraightFlush() {//同花顺
        return (isStraight()) && isFlush();
    }


    public int getPoints() {
        if (isStraightFlush())
            return 90;
        else if (isFour())
            return 80;
        else if (isFullHouse())
            return 70;
        else if (isFlush())
            return 60;
        else if (isStraight())
            return 50;
        else if (isThree())
            return 40;
        else if (getPair() == 2)
            return 30;
        else if (getPair() == 1)
            return 20;
        else
            return 10;
    }

    public int comparelevelTo(Object o) {

        if (isFour()|isThree()|isFullHouse()){
            return comparemiddle(o);
        }
        else if (isStraight()|isStraightFlush()|isHigh()|isFlush()) {
            return comparehigh(o);
        }
        else if (getPair()==2) {
            return comparePairtwo(o);
        }
        else if (getPair()==1) {
            return comparePairone(o);
        }

        return 0;
    }


    @Override
    public int compareTo(Object o) {

        if (this.getPoints() != ((CardComplete) o).getPoints()) {
            if (this.getPoints() > ((CardComplete) o).getPoints())
                return 1;
            else
                return -1;
        } else
            // return 0;
            return this.comparelevelTo(o);
    }

    class cmp implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            CardGenerate c1 = (CardGenerate) o1;
            CardGenerate c2 = (CardGenerate) o2;
            if (c1.getGenerate().getIndex() != c2.getGenerate().getIndex())
                return c1.getGenerate().getIndex() > c2.getGenerate().getIndex() ? 1 : -1;
            else
                return 0;
        }
    }
}

