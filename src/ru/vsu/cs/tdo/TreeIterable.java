package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

import com.sun.source.tree.Tree;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterable<K extends Comparable<K>, V> implements Iterable<BSTreeMap.MapTreeEntry<K, V>> {
    K key1;
    K key2;
    Stack<BinaryTree.TreeNode<BSTreeMap.MapTreeEntry<K, V>>> stack;
    public TreeIterable(BinaryTree.TreeNode<BSTreeMap.MapTreeEntry<K, V>> treeNode, K key1, K key2) {
        this.key1 = key1;
        this.key2 = key2;
        stack = new Stack<>();
        BinaryTree.TreeNode<BSTreeMap.MapTreeEntry<K, V>> node = treeNode;

        while (node != null) {
            if (node.getValue().key.compareTo(key1) == 0) {
                stack.push(node);
                break;
            } else {
                if (node.getValue().key.compareTo(key1) > 0) {
                    stack.push(node);
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
        }
    }
    @Override
    public Iterator<BSTreeMap.MapTreeEntry<K, V>> iterator() {
        return new TreeIterator(stack, key2);
    }
}
