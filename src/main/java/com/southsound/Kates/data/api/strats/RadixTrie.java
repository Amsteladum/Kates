package com.southsound.Kates.data.api.strats;

import com.southsound.Kates.data.User;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class StringSet {

    @NotNull public String set;

    public String getSet() {
        return set;
    }
}

class RadixTrieEdge {
    RadixTrieNode destination;
    String label;
}

class RadixTrieNode {
    boolean isKeyNode;
    HashMap<String, RadixTrieEdge> children;

    public RadixTrieNode(HashMap<String, RadixTrieEdge> children, boolean storedKey) {
        this.children = children;
        this.children = new HashMap<>();
        this.isKeyNode = storedKey;
    }
}

public class RadixTrie {
    RadixTrieNode root;
    HashMap<String, RadixTrieEdge> children = new HashMap<>();
    User user;

    public RadixTrie() {
        this.root = new RadixTrieNode(children,false);
    }

    public RadixTrieNode longestCommonPrefix(RadixTrieNode node, HashMap<String, RadixTrieEdge> string, String prefix) {
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

    public RadixTrieNode search(RadixTrieNode node, HashMap<String, RadixTrieEdge> string) {
        this.children = string;

        if (StringUtils.isEmpty(user.getUser()))
            return node.isKeyNode ? root : node;

        return search(node, string);
    }

    public RadixTrieNode matchEdge(RadixTrieNode node, HashMap<String, RadixTrieEdge> string) {
        node = new RadixTrieNode(children, false);
        //Char c = string.toString().chars(); // TODO code ...

        if (node.children == null)
            return matchEdge(null, string);
        else {
            RadixTrieNode edge, prefix, suffixString, suffixEdge;
            // TODO code ...
            edge = node;

            //prefix = longestCommonPrefix(node, string, prefix); // TODO Possible replacement of function parameters as a lambda operation.
            //suffixString = longestCommonPrefix(node, string, prefix);
            //suffixEdge = longestCommonPrefix(node, string, prefix);

            Set<Map.Entry<String, RadixTrieEdge>> entrySet = string.entrySet();

            return matchEdge(node, string);
        }
    }
}
