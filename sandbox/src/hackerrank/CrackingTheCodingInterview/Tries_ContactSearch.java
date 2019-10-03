package hackerrank.CrackingTheCodingInterview;

import java.util.HashMap;

public class Tries_ContactSearch {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("hack");
        trie.add("hackerrank");
        trie.find("hac");
        trie.find("hak");
    }
}


class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public int size = 0; // this was the main trick to decrease runtime to pass tests.

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void add(String str) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}
