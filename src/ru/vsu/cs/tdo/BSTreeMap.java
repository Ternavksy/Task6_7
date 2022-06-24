package ru.vsu.cs.shepliakovvladislavvyacheslavovich;



import java.util.*;

/**
 * Интерфейс словаря на базе двоичного дерева поиска (BinarySearchTree) с
 * реализацией по умолчанию
 *
 * @param <K>
 * @param <V>
 */
public interface BSTreeMap<K extends Comparable<? super K>, V> {

    class MapTreeEntry<K extends Comparable<? super K>, V> implements Map.Entry<K, V>, Comparable<MapTreeEntry<K, V>> {

        public K key;
        public V value;

        public MapTreeEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(MapTreeEntry<K, V> o) {
            return this.key.compareTo(o.key);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    BSTree<MapTreeEntry<K, V>> getTree();


    default int size() {
        return getTree().size();
    }


    default boolean isEmpty() {
        return size() <= 0;
    }


    default boolean containsKey(Object key) {
        return getTree().contains(new MapTreeEntry((K) key, null));
    }


    default boolean containsValue(Object value) {
        for (MapTreeEntry<K, V> entry : getTree()) {
            if (entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }


    default V get(Object key) {
        MapTreeEntry<K, V> entry = getTree().get(new MapTreeEntry((K) key, null));
        return (entry == null) ? null : entry.value;
    }


    default V put(K key, V value) {
        MapTreeEntry<K, V> entry = getTree().put(new MapTreeEntry(key, value));
        return entry == null ? null : entry.value;
    }


    default V remove(Object key) {
        MapTreeEntry<K, V> entry = getTree().remove(new MapTreeEntry((K) key, null));
        return entry == null ? null : entry.value;
    }


    default void putAll(Map<? extends K, ? extends V> m) {
        m.entrySet().forEach((entry) -> {
            getTree().put(new MapTreeEntry(entry.getKey(), entry.getValue()));
        });
    }


    default void clear() {
        getTree().clear();
    }


}
