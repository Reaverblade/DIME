package dime;

import net.minecraft.entity.player.EntityPlayer;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;

/**
 * Created by OkuBlade.
 */
public class SelectedStats {
    public HashMap<String, Selection> selectedPoints = new HashMap<String, Selection>();
    public Selection getSelectionForPlayer(EntityPlayer p){
        if(!selectedPoints.containsKey(p.getCommandSenderName())){
            selectedPoints.put(p.getCommandSenderName(), new Selection());
        }
        return selectedPoints.get(p.getCommandSenderName());
    }
    public static class Selection {
        public int pointToSet = 0;
       public Point minSelection, maxSelection;
       public Selection(){
           reset();
       }
       public void setPoint(int x, int y, int z){
           Point thePoint = pointToSet == 0? minSelection : maxSelection;
              thePoint.set(x, y, z);
           if(pointToSet > 0) {
               pointToSet = 0;
           }else{
               pointToSet = 1;
           }
       }

       public boolean isSet(){
           return minSelection.isSet && maxSelection.isSet;
       }
       public void reset(){
           minSelection = new Point();
           maxSelection = new Point();
       }
    }

    public static class Point {
        public int x, y, z;
        public boolean isSet = false;
        public void set(int sx, int sy, int sz){
          x = sx;
          y = sy;
          z = sz;
          isSet = true;
        }
    }
}