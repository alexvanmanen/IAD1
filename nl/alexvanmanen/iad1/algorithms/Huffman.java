package iad1.nl.alexvanmanen.iad1.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
	char character;
	int occurences = 1;
	Node left;
	Node right;
	String code = "";

	public Node(char c) {
		character = c;
	}

	@Override
	public int compareTo(Node n) {

		return new Integer(this.occurences).compareTo(new Integer(n.occurences));
	}

	public String toString() {
		return character + " " + occurences + " " + code;
	}
}

public class Huffman {

	public static void main(String[] args) {
		String textToCompress = "Huffman is a great compression algorithm";
		Huffman huffman = new Huffman();
		huffman.compressText(textToCompress);
	}
	
	public void compressText(String textToCompress){
		System.out.println("Length of the text to compress is: " + textToCompress.length());
		List<Node> result = countOccurences(textToCompress);
		Collections.sort(result);
		List<Node> tree = generateTree(result);
		codingTree(tree);
		printListOfCharacters(result);
		printCompromessedText(textToCompress, result);
	}

	private void printListOfCharacters(List<Node> result) {
		System.out.println("List of characters");
		for (Node n : result) {
			System.out.println(n);
		}
		System.out.println("");
	}

	private void printCompromessedText(String textToCompress, List<Node> nodes) {
		StringBuffer result = new StringBuffer();
		for (Character c : textToCompress.toCharArray()) {
			for (Node n : nodes) {
				if (n.character == c.charValue()) {
					result.append(n.code);
				}
			}
		}
		System.out.println("text compressed in bits: " + result.toString());
	}

	private void codingTree(List<Node> tree) {
		codingNodes(tree.get(0), "");
	}

	private void codingNodes(Node node, String code) {
		node.code = code;
		if (node.left != null) {
			codingNodes(node.left, code + "0");
		}
		if (node.right != null) {
			codingNodes(node.right, code + "1");
		}
	}

	private List<Node> generateTree(List<Node> result) {
		List<Node> tree = new ArrayList<Node>(result);
		while (tree.size() >= 2) {
			combineLowestTwoValues(tree);
			Collections.sort(tree);
		}
		return tree;
	}

	private void combineLowestTwoValues(List<Node> tree) {
		Node n1 = tree.remove(0);
		Node n2 = tree.remove(0);
		Node newNode = new Node('*');
		newNode.occurences = n1.occurences + n2.occurences;
		newNode.left = n1;
		newNode.right = n2;
		tree.add(newNode);
	}

	private List<Node> countOccurences(String textToCompress) {
		char[] arrayOfText = textToCompress.toCharArray();
		List<Node> result = new ArrayList<Node>();

		int found = -1;
		for (int i = 0; i < arrayOfText.length; i++) {
			for (int j = 0; j < result.size(); j++) {
				if (result.get(j) != null && result.get(j).character == arrayOfText[i]) {
					found = j;
				}
			}
			if (found >= 0) {
				result.get(found).occurences++;
			} else {
				result.add(new Node(arrayOfText[i]));
			}
			found = -1;
		}
		return result;
	}

}
