package com.southsound.Kates.data.api.strats;

import com.southsound.Kates.data.User;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Muncher {
    String stringOf(String string);
    Integer integerOf(Integer integer);
    <T> HashMap<T, RadixTrie> hashMapOf(HashMap<T, RadixTrie> hashMap);
}

class RadixTrieEdge {
    RadixTrieNode destination;
    String label;
}

class RadixTrieNode {
    boolean isKeyNode;
    HashMap<String, RadixTrie> children;

    public RadixTrieNode() {}

    public RadixTrieNode(HashMap<String, RadixTrie> children, boolean storedKey) {
        this.children = children;
        this.children = new HashMap<>();
        this.isKeyNode = storedKey;
    }

    public <T> RadixTrieNode(String key, T value, Integer keyIndex) {
        HashMap<String, RadixTrie> children = new HashMap<>();
        RadixTrieNode node = new RadixTrieNode();
        RadixTrie trie = new RadixTrie(null, node);

        if (keyIndex == key.length()) {
            this.children = children;
            Map<String, T> mapOfChildren = Map.ofEntries(Map.entry(key, value));
            //children.forEach(()-> children.merge(() -> trie.matchEdge(node, key)));
        }
        else if (keyIndex > trie.size()) { // TODO code ... Ghosted code functions.
            Set<RadixTrie> reduceChild = new HashSet<>();
            reduceChild.removeIf(child->Character.isDigit(child.getReferenceCode().charAt(keyIndex)));
        }
        else {
            Set<RadixTrie> replaceChild = new HashSet<>();
            replaceChild.stream().map(child->Character.toUpperCase(child.charAt(keyIndex)) +
                    child.substring(1))
                    .collect(Collectors.toSet())
                    .forEach(output);
        }
    } // TODO Outputting (function) closure for each condition.
}

public class RadixTrie {
    RadixTrie root;
    RadixTrieNode radixTrieNode;
    HashMap<String, RadixTrie> children = new HashMap<>();
    User user;

    public RadixTrie getRoot() {
        return root;
    }

    public RadixTrie(RadixTrie root, RadixTrieNode radixTrieNode) {
        this.root = root;
        this.radixTrieNode = radixTrieNode;
        this.radixTrieNode = new RadixTrieNode();
    }

    public RadixTrieNode longestCommonPrefix(RadixTrieNode node, HashMap<String, RadixTrie> string, String prefix) {
        if (!StringUtils.isEmpty(string))
            if (node.isKeyNode)
                longestCommonPrefix(node, string, prefix);
            else return null; // longestCommonPrefix(null, null, null)

        if (!StringUtils.isEmpty(node.children.size() == 0))
            return null; // longestCommonPrefix(null, null, null)
        else {
            RadixTrieNode result = search(node, string);
            if (result != null)
                return result;
            else if (node.isKeyNode)
                return longestCommonPrefix(node, string, prefix);
            else return null; // longestCommonPrefix(null, null, null)
        }
    }

    public RadixTrieNode search(RadixTrieNode node, HashMap<String, RadixTrie> string) {
        this.children = string;

        if (StringUtils.isEmpty(user.getUser()))
            return node.isKeyNode ? radixTrieNode : node;

        return search(node, string);
    }

    public RadixTrie matchEdge(RadixTrieNode node, HashMap<String, RadixTrie> string) {
        node = new RadixTrieNode(children, false);
        //Char c = string.toString().chars(); // TODO code ...

        if (node.children == null)
            return matchEdge(null, string);
        else {
            RadixTrieNode edge, prefix, suffixString, suffixEdge;
            // TODO code ... Lambda Operations, Stream.
            edge = node;

            //prefix = longestCommonPrefix(node, string, prefix); // TODO Possible replacement of function parameters as a lambda operation.
            //suffixString = longestCommonPrefix(node, string, prefix);
            //suffixEdge = longestCommonPrefix(node, string, prefix);

            Set<Map.Entry<String, RadixTrie>> entrySet = string.entrySet();

            return matchEdge(node, string);
        }
    }
}
