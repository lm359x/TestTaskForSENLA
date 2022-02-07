package task5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Safe {
    public Safe(int capacity){
        this.capacity=capacity;
        maxs=new ArrayList<>();
        sets=new ArrayList<>();
    }
    public void fill(ArrayList<Box> list){//составление вариантов
        Collections.sort(list);
        int size=list.size();
        int[] m = new int[size];
        ArrayList<Box> tmpList = new ArrayList<Box>();
        tmpList.addAll(list);
        ArrayList<Box> set = new ArrayList<Box>();

        m[0]=0;
        int load=0;
        for(int i=1;i<size;++i){
            int max = 0;
            int index = -1;
            for(int j=0;j<tmpList.size();++j){
                Box box = tmpList.get(j);
                if(box.getWorth()>max&&box.getVolume()+load<capacity){
                    max=box.getWorth();
                    index=j;
                }
            }
            if(index==-1){
                break;
            }
            m[i]=m[i-1]+tmpList.get(index).getWorth();
            load+=tmpList.get(index).getVolume();
            set.add(tmpList.get(index));
            tmpList.remove(index);
        }
        int max = 0;
        for(int i=0;i<size;++i){
            if (m[i]>max)
                max=m[i];
        }
        maxs.add(max);
        sets.add(set);
        if(list.size()>1) {//удаляем из найденного набора поочередно элементы, рекурсивно находим максимумы для "обрезанных" наборов
            for (int i = 0; i < set.size(); ++i) {
                ArrayList<Box> reducedBoxes= new ArrayList<Box>();
                reducedBoxes.addAll(list);
                reducedBoxes.remove(set.get(i));
                fill(reducedBoxes);
            }
        }else{
            return;
        }
    }
    public void print(){//отбор лучшего из вариантов
        int max=0;
        int index=-1;
        for(int i=0;i<maxs.size();++i){
            if(max< maxs.get(i)){
                max=maxs.get(i);
                index=i;
            }
        }
        if(index==-1) {
            System.out.println("Nothing found.");
            return;
        }
        System.out.println(max);
        System.out.println(sets.get(index));
    }

    public int getCapacity() {
        return capacity;
    }
    private ArrayList<Integer> maxs;
    private ArrayList<ArrayList<Box>> sets;
    private int capacity;
}
