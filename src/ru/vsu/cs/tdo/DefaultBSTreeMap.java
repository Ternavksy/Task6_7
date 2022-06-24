package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

import java.util.Iterator;
import java.util.Stack;

public class DefaultBSTreeMap<K extends Comparable<K>, V> implements BSTreeMap<K, V>, Iterable<BSTreeMap.MapTreeEntry<K, V>> {
    K key1;
    K key2;

    public DefaultBSTreeMap() {

    }

    private final BSTree<BSTreeMap.MapTreeEntry<K, V>> tree = new DefaultBSTree<>();

    @Override
    public BSTree<BSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
    public String getDelimitedLineFromTreeKey1Key2(K key1, K key2) {
        this.key1 = key1;
        this.key2 = key2;
        StringBuilder answer = new StringBuilder("");
        for (MapTreeEntry<K, V> value: this) {
            String str = value.value + " ";
            answer.append(str);
        }

        return new String(answer);
    }


    @Override
    public Iterator<MapTreeEntry<K, V>> iterator() {
        return inOrderValues(tree.getRoot(), key1, key2).iterator();
    }

    public Iterable<MapTreeEntry<K, V>> inOrderValues(BinaryTree.TreeNode<MapTreeEntry<K, V>> treeNode, K key1, K key2) {
        return new TreeIterable(treeNode, key1, key2);
    }
}
