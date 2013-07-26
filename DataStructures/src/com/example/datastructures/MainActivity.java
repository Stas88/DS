package com.example.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.andreaszeiser.jalousie.Jalousie;

public class MainActivity extends Activity {
	
	
	private static final String TAG = "MainActivity";
	
	List list;
	
	TextView contains_linkedlist_text;
	TextView contains_arraylist_text;
	TextView fill_linkedlist_text;
	TextView fill_arraylist_text;
	TextView getfirst_linkedlist_text;
	TextView getfirst_arraylist_text;
	TextView getlast_linkedlist_text;
	TextView getlast_arraylist_text;
    TextView getmid_arraylist_text;
    TextView getmid_linkedlist_text;
    
    
    //Adding
    TextView addfirst_linkedlist_text;
    TextView addfirst_arraylist_text;
    TextView addlast_linkedlist_text;
    TextView addlast_arraylist_text;
    TextView addmid_arraylist_text;
    TextView addmid_linkedlist_text;

    //Removing
    TextView removefirst_linkedlist_text;
    TextView removefirst_arraylist_text;
    TextView removelast_linkedlist_text;
    TextView removelast_arraylist_text;
    TextView removemid_arraylist_text;
    TextView removemid_linkedlist_text;

    //Hashmap
    TextView fill_hashmap_text;
    TextView containsKey_hashmap;
    TextView containsVaue_hashmap;
    TextView get_hashmap;
    TextView remove_hashmap;

    //Hashset
    TextView fill_hashset_text;
    TextView contains_hashset_text;
    TextView remove_hashset_text;


    //Treemap
    TextView fill_treemap_text;
    TextView containsKey_treemap;
    TextView containsVaue_treemap;
    TextView get_treemap;
    TextView remove_treemap;

    //Treeset
    TextView fill_treeset_text;
    TextView contains_treeset_text;
    TextView remove_treeset_text;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        
        initViews();
        /*
       
        
        new LinkedListListTask().execute();
        new HashMapListTask().execute();
        new TreeMapListTask().execute();
        new HashSetListTask().execute();
        new TreeSetListTask().execute();
         */
    }
    
    public void onClickArrayList(View v) {
    	 final Jalousie jalousie = (Jalousie)v;
    	 if(jalousie.expand()) {
    		 new ArrayListTask().execute();
    	 } else {
    		 jalousie.collapse();
    	 }
    }
    
    public void onClickLinkedList(View v) {
   	 final Jalousie jalousie = (Jalousie)v;
   	 if(jalousie.expand()) {
   		 new LinkedListTask().execute();
   	 } else {
   		 jalousie.collapse();
   	 }
   }
    
    public void onClickHashSet(View v) {
      	 final Jalousie jalousie = (Jalousie)v;
      	 if(jalousie.expand()) {
      		 new HashSetTask().execute();
      	 } else {
      		 jalousie.collapse();
      	 }
      }

    public void onClickTreeSet(View v) {
     	 final Jalousie jalousie = (Jalousie)v;
     	 if(jalousie.expand()) {
     		 new TreeSetTask().execute();
     	 } else {
     		 jalousie.collapse();
     	 }
     }
    
    
    public void onClickHashMap(View v) {
    	 final Jalousie jalousie = (Jalousie)v;
    	 if(jalousie.expand()) {
    		 new HashMapTask().execute();
    	 } else {
    		 jalousie.collapse();
    	 }
    }
    
    public void onClickTreeMap(View v) {
   	 final Jalousie jalousie = (Jalousie)v;
   	 if(jalousie.expand()) {
   		 new TreeMapTask().execute();
   	 } else {
   		 jalousie.collapse();
   	 }
   }
   
    
    public long fillStringList(int size) {
    	long start = System.nanoTime();
    	for(int i = 0; i < size; i++) {
    		list.add(""+i);
    	}
    	return  System.nanoTime() - start;
    }
    
    public long containsList(Object o) {
    	long start = System.nanoTime();
    	list.contains(o);
    	return  System.nanoTime() - start;
    }
    
    public long getFirstInList() {
    	long start = System.nanoTime();
    	Object a  = list.get(0);
    	return  System.nanoTime() - start;
    }
    
    public long getLastInList() {
    	long start = System.nanoTime();
    	Object a  = list.get(list.size()-1);
    	return  System.nanoTime() - start;
    }
    
    public long getMidInList() {
    	long start = System.nanoTime();
    	Object a  = list.get(list.size()/2);
    	return  System.nanoTime() - start;
    }


    public long addFirstInList() {
        long start = System.nanoTime();
        list.add(0, "X");
        return  System.nanoTime() - start;
    }

    public long addLastInList() {
        long start = System.nanoTime();
        list.add(list.size()-1, "Y");
        return  System.nanoTime() - start;
    }



    public long addMidInList() {
        long start = System.nanoTime();
        list.add(list.size()/2, "Z");
        return  System.nanoTime() - start;
    }

    public long removeFirstInList() {
        long start = System.nanoTime();
        list.remove(0);
        return  System.nanoTime() - start;
    }

    public long removeLastInList() {
        long start = System.nanoTime();
        list.remove(list.size()-1);
        return  System.nanoTime() - start;
    }

    public long removeMidInList() {
        long start = System.nanoTime();
        list.remove(list.size()/2);
        return  System.nanoTime() - start;
    }


    private void initViews() {

        //Initializaton
        contains_arraylist_text = (TextView)findViewById(R.id.contains_arraylist_text);
        contains_linkedlist_text = (TextView)findViewById(R.id.contains_linkedlist_text);
        fill_arraylist_text = (TextView)findViewById(R.id.fill_arraylist_text);
        fill_linkedlist_text = (TextView)findViewById(R.id.fill_linkedlist_text);
        getfirst_arraylist_text = (TextView)findViewById(R.id.getfirst_arraylist_text);
        getfirst_linkedlist_text = (TextView)findViewById(R.id.getfirst_linkedlist_text);
        getlast_arraylist_text = (TextView)findViewById(R.id.getlast_arraylist_text);
        getlast_linkedlist_text = (TextView)findViewById(R.id.getlast_linkedlist_text);
        getmid_arraylist_text = (TextView)findViewById(R.id.getmid_arraylist_text);
        getmid_linkedlist_text = (TextView)findViewById(R.id.getmid_linkedlist_text);


        addfirst_linkedlist_text = (TextView)findViewById(R.id.addfirst_linkedlist_text);
        addfirst_arraylist_text = (TextView)findViewById(R.id.addfirst_arraylist_text);
        addlast_arraylist_text = (TextView)findViewById(R.id.addlast_arraylist_text);
        addlast_linkedlist_text = (TextView)findViewById(R.id.addlast_linkedlist_text);
        addmid_arraylist_text = (TextView)findViewById(R.id.addmid_arraylist_text);
        addmid_linkedlist_text = (TextView)findViewById(R.id.addmid_linkedlist_text);

        removefirst_linkedlist_text = (TextView)findViewById(R.id.removefirst_linkedlist_text);
        removefirst_arraylist_text = (TextView)findViewById(R.id.removefirst_arraylist_text);
        removelast_arraylist_text = (TextView)findViewById(R.id.removelast_arraylist_text);
        removelast_linkedlist_text = (TextView)findViewById(R.id.removelast_linkedlist_text);
        removemid_arraylist_text = (TextView)findViewById(R.id.removemid_arraylist_text);
        removemid_linkedlist_text = (TextView)findViewById(R.id.removemid_linkedlist_text);





        //Hashmap
        fill_hashmap_text = (TextView)findViewById(R.id.fill_hashmap_text);
        containsKey_hashmap = (TextView)findViewById(R.id.contains_key_hashmap_text);
        containsVaue_hashmap =(TextView)findViewById(R.id.contains_value_hashmap_text);
        get_hashmap = (TextView)findViewById(R.id.get_hashmap_text);
        remove_hashmap = (TextView)findViewById(R.id.remove_hashmap_text);

        //Hashset
        fill_hashset_text = (TextView)findViewById(R.id.fill_hashset_text);
        contains_hashset_text = (TextView)findViewById(R.id.contains_hashset_text);
        remove_hashset_text = (TextView)findViewById(R.id.remove_hashset_text);

        //Treemap
        fill_treemap_text = (TextView)findViewById(R.id.filling_treemap);
        containsKey_treemap = (TextView)findViewById(R.id.contains_key_treemap_text);
        containsVaue_treemap =(TextView)findViewById(R.id.contains_value_treemap_text);
        get_treemap = (TextView)findViewById(R.id.get_treemap_text);
        remove_treemap = (TextView)findViewById(R.id.remove_treemap_text);

        //Treeset
        fill_treeset_text = (TextView)findViewById(R.id.fill_treeset_text);
        contains_treeset_text = (TextView)findViewById(R.id.contains_treeset_text);
        remove_treeset_text = (TextView)findViewById(R.id.remove_treeset_text);
    }




    private class ArrayListTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> stringList = new ArrayList<String>();
            list = new ArrayList<String>();
            stringList.add(fillStringList(10000) + " ns");
            stringList.add(containsList("XYZ") + " ns");
            stringList.add(getFirstInList() + " ns");
            stringList.add(getLastInList() + " ns");
            stringList.add(getMidInList() + " ns");
            stringList.add(addLastInList() + " ns");
            stringList.add(addFirstInList() + " ns");
            stringList.add(addMidInList() + " ns");
            stringList.add(removeFirstInList() + " ns");
            stringList.add(removeLastInList() + " ns");
            stringList.add(removeMidInList() + " ns");
            return stringList;
        }



        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(ArrayList<String> result) {
            fill_arraylist_text.setText(result.get(0));
            contains_arraylist_text.setText(result.get(1));
            getfirst_arraylist_text.setText(result.get(2));
            getlast_arraylist_text.setText(result.get(3));
            getmid_arraylist_text.setText(result.get(4));
            addlast_arraylist_text.setText(result.get(5));
            addfirst_arraylist_text.setText(result.get(6));
            addmid_arraylist_text.setText(result.get(7));
            removefirst_arraylist_text.setText(result.get(8));
            removelast_arraylist_text.setText(result.get(9));
            removemid_arraylist_text.setText(result.get(10));

        }
    }


    private class LinkedListTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> stringList = new ArrayList<String>();
            list = new LinkedList<String>();
            stringList.add(fillStringList(10000) + " ns");
            stringList.add(containsList("XYZ") + " ns");
            stringList.add(getFirstInList() + " ns");
            stringList.add(getLastInList() + " ns");
            stringList.add(getMidInList() + " ns");
            stringList.add(addLastInList() + " ns");
            stringList.add(addFirstInList() + " ns");
            stringList.add(addMidInList() + " ns");
            stringList.add(removeFirstInList() + " ns");
            stringList.add(removeLastInList() + " ns");
            stringList.add(removeMidInList() + " ns");
            return stringList;
        }



        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(ArrayList<String> result) {
            fill_linkedlist_text.setText(result.get(0));
            contains_linkedlist_text.setText(result.get(1));
            getfirst_linkedlist_text.setText(result.get(2));
            getlast_linkedlist_text.setText(result.get(3));
            getmid_linkedlist_text.setText(result.get(4));
            addlast_linkedlist_text.setText(result.get(5));
            addfirst_linkedlist_text.setText(result.get(6));
            addmid_linkedlist_text.setText(result.get(7));
            removefirst_linkedlist_text.setText(result.get(8));
            removelast_linkedlist_text.setText(result.get(9));
            removemid_linkedlist_text.setText(result.get(10));

        }
    }


    private class HashMapTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> stringList = new ArrayList<String>();
            Hashmap map = new Hashmap();
            stringList.add(map.fill(10000)+ " ns");
            stringList.add(map.containsKey(5000)+" ns");
            stringList.add(map.containsValue(5000 + "") + " ns");
            stringList.add(map.get(50000) + " ns");
            stringList.add(map.remove(50000)+" ns");
            return stringList;
        }



        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(ArrayList<String> result) {
            fill_hashmap_text.setText(result.get(0));
            containsKey_hashmap.setText(result.get(1));
            containsVaue_hashmap.setText(result.get(2));
            get_hashmap.setText(result.get(3));
            remove_hashmap.setText(result.get(4));

        }
    }

    private class TreeMapTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> stringList = new ArrayList<String>();
            Treemap map = new Treemap();
            stringList.add(map.fill(10000)+ " ns");
            stringList.add(map.containsKey(5000)+" ns");
            stringList.add(map.containsValue(5000 + "") + " ns");
            stringList.add(map.get(50000) + " ns");
            stringList.add(map.remove(50000)+" ns");
            return stringList;
        }



        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(ArrayList<String> result) {
            fill_treemap_text.setText(result.get(0));
            containsKey_treemap.setText(result.get(1));
            containsVaue_treemap.setText(result.get(2));
            get_treemap.setText(result.get(3));
            remove_treemap.setText(result.get(4));

        }
    }



    private class TreeSetTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> stringList = new ArrayList<String>();
            Treeset set = new Treeset();
            stringList.add(set.fill(10000)+" ns");
            stringList.add(set.contains(""+5000)+"ns");
            stringList.add(set.remove(""+5000)+" ns");
            return stringList;
        }



        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(ArrayList<String> result) {
            fill_treeset_text.setText(result.get(0));
            contains_treeset_text.setText(result.get(1));
            remove_treeset_text.setText(result.get(2));
        }
    }



    private class HashSetTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> stringList = new ArrayList<String>();
            Hashset set = new Hashset();
            stringList.add(set.fill(10000)+" ns");
            stringList.add(set.contains(""+5000)+"ns");
            stringList.add(set.remove(""+5000)+" ns");
            return stringList;
        }



        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(ArrayList<String> result) {
            fill_hashset_text.setText(result.get(0));
            contains_hashset_text.setText(result.get(1));
            remove_hashset_text.setText(result.get(2));
        }
    }
}
