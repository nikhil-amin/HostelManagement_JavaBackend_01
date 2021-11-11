package com.hostelmanagement.backend.util;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class LinkedCaseInsensitiveHashMap<K, V> extends LinkedHashMap<K, V> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public V put(K k, V v){
        return super.put(k, v);
    }

    @Override
    public V get(Object k){
        if(k.getClass().equals(String.class)){
            for(Object s : this.keySet()){
                if(k.toString().equalsIgnoreCase(s.toString())){
                    return super.get(s);
                }
            }
            return super.get(k);
        }else{
            return super.get(k);
        }
    }
}
