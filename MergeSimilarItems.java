import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> temp = new HashMap<>();
        for(int i=0; i<items1.length; i++){
            temp.put(items1[i][0], items1[i][1]);
        }
        for(int i=0; i<items2.length; i++){
            if(temp.containsKey(items2[i][0])){
                temp.put(items2[i][0], temp.get(items2[i][0])+items2[i][1]);
            }else{
                temp.put(items2[i][0],items2[i][1]);
            }
        }
        List<List<Integer>> out = new ArrayList<>();
        for(int a : temp.keySet()){
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(temp.get(a));
            out.add(list);
        }

        Collections.sort(out, (a, b) -> Integer.compare(a.get(0),b.get(0)));
        return out;
    }
}
