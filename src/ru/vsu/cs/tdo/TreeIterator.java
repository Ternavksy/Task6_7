package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator <K extends Comparable<K>, V> implements Iterator<BSTreeMap.MapTreeEntry<K, V>> {
    Stack<BinaryTree.TreeNode<BSTreeMap.MapTreeEntry<K, V>>> stack;
    K key2;

    public TreeIterator(Stack<BinaryTree.TreeNode<BSTreeMap.MapTreeEntry<K, V>>> stack, K key2) {
        this.stack = stack;
        this.key2 = key2;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public BSTreeMap.MapTreeEntry<K, V> next() {

        BinaryTree.TreeNode<BSTreeMap.MapTreeEntry<K, V>> node = stack.pop();
        BSTreeMap.MapTreeEntry<K, V> result = node.getValue();
        if (node.getValue().key.compareTo(key2) == 0) {
            stack.clear();
            return result;
        }
        if (node.getRight() != null) {
            node = node.getRight();
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }
        return result;
    }
}
