package com.company;

import java.util.ArrayList;
import java.util.Vector;
import java.util.TreeSet;
import java.util.HashMap;

public class Singleton {
    Vector<AbstractRabbit> arr=new Vector();
    TreeSet ids = new TreeSet();
    HashMap<Long, Integer> BirthTimes = new HashMap();
    private static Singleton instance;

    private Singleton(){}

    public Vector<AbstractRabbit> GetVector()
    {
     return arr;
    }

    public void refreshVector(){
        arr.clear();
    }

    public TreeSet GetIds() { return ids; }

    public void refreshIds() { ids.clear(); }

    public HashMap GetBirthTimes() { return BirthTimes; }

    public void refreshBirthTimes() { BirthTimes.clear(); }

    public static Singleton getInstance()
    {
        if(instance==null)
            instance=new Singleton();
        return instance;
    }
}
