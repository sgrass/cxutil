package org.cx.hash;

/**
 * @author grass
 * @date 2017/10/28
 */
public interface MyMap<K, V> {
    public V put(K k, V v);

    public V get(K k);

    public interface Entry<K, V> {
        public K getKey();

        public V getValue();
    }

}
