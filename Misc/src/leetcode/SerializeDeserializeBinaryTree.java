package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import binaryTrees.BinaryTreeNode;

public class SerializeDeserializeBinaryTree {
	
	public void serializeDeSerializeBT(BinaryTreeNode root){
		
		String serializedString= serializeBinaryTree(root, new StringBuffer());
		Queue<String> queue = new LinkedList<String>();
		queue.addAll(Arrays.asList(serializedString.split(",")));
		BinaryTreeNode node = deserializeBinaryTree(queue);
		System.out.println(node);
		
	}
	
	
	public String serializeBinaryTree(BinaryTreeNode root,StringBuffer res){
		
		if(root==null){
			res.append("X,");
			
		}else{
		res.append(""+root.data+",");
		serializeBinaryTree(root.leftNode,res);
		serializeBinaryTree(root.rightNode,res);
		}
		return res.substring(0, res.length()-1);
	}
	
	public BinaryTreeNode deserializeBinaryTree(Queue<String> nodes){
		
		String val = nodes.remove();
		if(val.equals("X"))
			return null;
		else{
		BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(val));
		node.leftNode=deserializeBinaryTree(nodes);
		node.rightNode=deserializeBinaryTree(nodes);
		return node;
		}
	
	}

	public static void main(String[] args) {
		SerializeDeserializeBinaryTree sdbt = new SerializeDeserializeBinaryTree();
		sdbt.serializeDeSerializeBT(BinaryTreeNode.createTree4());
		System.out.println();
	}

}
