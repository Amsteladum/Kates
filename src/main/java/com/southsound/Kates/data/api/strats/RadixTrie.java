package com.southsound.Kates.data.api.strats;

import com.southsound.Kates.data.User;
//import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

//import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

class RadixTrieEdge {
    RadixTrieNode destination;
    String label;
}

class RadixTrieNode {
    boolean isKeyNode;
    HashMap<String, RadixTrieNode> children;

    public RadixTrieNode() {}

    public RadixTrieNode(HashMap<String, RadixTrieNode> children, boolean storedKey) {
        this.children = children;
        this.children = new HashMap<>();
        this.isKeyNode = storedKey;
    }

    public String getToStringCode() {
        return this.children.toString();
    }

    public <T> RadixTrieNode matchEdge(String key, T value, Integer keyIndex) {
        HashMap<String, RadixTrieNode> children = new HashMap<>();
        this.children = children;
        RadixTrieNode node = new RadixTrieNode();

        Set<RadixTrieNode> reducedChild = new HashSet<>();

        reducedChild.add(node);

        if (keyIndex == key.length()) {
            Map<String, T> mapOfChildren = Map.ofEntries(Map.entry(key, value));
            //children.forEach(()-> children.merge(() -> trie.matchEdge(node, key)));
            HashMap<String, RadixTrieNode> child = new HashMap<>(Map.of(key, node));

            key = mapOfChildren.toString();
        }
        else if (keyIndex > children.size()) { // TODO code ... Ghosted code functions.
            reducedChild.removeIf(child->Character.isDigit(child.getToStringCode().charAt(keyIndex)));
            key = reducedChild.toString();
        }
        else {
            String finalKey = key;
            Consumer<String> output = s -> s.getChars(keyIndex, keyIndex + 1, finalKey.toCharArray(), keyIndex + 2);

            for (Map.Entry<String, RadixTrieNode> entry: children.entrySet()) {
                String keyNode = entry.getKey();
                RadixTrieNode trieNode = entry.getValue();
                System.out.println("Key Node: " + keyNode + ", Radix Trie Node: " + trieNode + "\n");

                key = entry.toString();
            }
        }

        return matchEdge(key, value, keyIndex);
    } // TODO Method 'matchEdge()' recurses infinitely, and can only end by throwing an exception.
}

public class RadixTrie {
    RadixTrie root;
    RadixTrieNode radixTrieNode;
    HashMap<String, RadixTrieNode> children = new HashMap<>();
    User user;

    public RadixTrie getRoot() {
        return root;
    }

    public String getToStringCode() {
        return this.children.toString();
    }

	public RadixTrie(RadixTrie root, RadixTrieNode radixTrieNode) {
        this.root = root;
        this.radixTrieNode = radixTrieNode;
        this.radixTrieNode = new RadixTrieNode();
    }

    public RadixTrieNode longestCommonPrefix(RadixTrieNode node, HashMap<String, RadixTrieNode> string, String prefix) {
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

    public RadixTrieNode search(RadixTrieNode node, HashMap<String, RadixTrieNode> string) {
        this.children = string;

        if (StringUtils.isEmpty(user.getUser()))
            return node.isKeyNode ? radixTrieNode : node;

        return search(node, string);
    }
}

/*Listing 6.1 class Trie

    #type Char[]
    Alphabet
     
    class Node
      #type boolean
      keyNode
     
      #type HashMap<Char, Node>
      children
     
      function Node(storesKey)
        for char in Alphabet do
          this.children[char] ← null
        this.keyNode ← storesKey
     
    class Trie
      #type Node
      root
     
      function Trie()
        root ← new Node(false)
*
* Algorithms and Data Structures in Action, Authors: Marcello La Rocca
* */