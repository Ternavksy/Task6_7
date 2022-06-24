package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

/**
 * Реализация словаря на базе простого (наивного) дерева поиска
 *
 * @param <K>
 * @param <V>
 */
public class SimpleBSTreeMap<K extends Comparable<K>, V> implements BSTreeMap<K, V> {

    private final BSTree<BSTreeMap.MapTreeEntry<K, V>> tree = new SimpleBSTree<>();

    @Override
    public BSTree<BSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
