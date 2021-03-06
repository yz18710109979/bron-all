package com.jy.bron.core.utils;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Concurrent Hash Set implement by {@link ConcurrentHashMap}.
 *
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public class ConcurrentHashSet<E> extends AbstractSet<E> {
    
    private ConcurrentHashMap<E, Boolean> map;
    
    public ConcurrentHashSet() {
        super();
        map = new ConcurrentHashMap<E, Boolean>();
    }
    
    @Override
    public int size() {
        return map.size();
    }
    
    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }
    
    /**
     * The original implement <p>map.keySet().iterator()</p> need jdk8, so it can work.
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new HashSet<E>(map.keySet()).iterator();
    }
    
    @Override
    public boolean add(E o) {
        return map.putIfAbsent(o, Boolean.TRUE) == null;
    }
    
    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }
    
    @Override
    public void clear() {
        map.clear();
    }
}
