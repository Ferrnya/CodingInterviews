package chapter7;
import java.util.*;

public class P326_commonParent {
	public static class CommonTree{
		char val;
		List<CommonTree> children;
		public CommonTree(char val) {
			this.val = val;
			children = new LinkedList<>();
		}
		public void addChild(CommonTree... children) {
			for(CommonTree child:children)
			    this.children.add(child);
		}	
	}
	
	public static char findParent(CommonTree root,CommonTree node1,CommonTree node2) {
		List<CommonTree> path1 = new ArrayList<>();
		List<CommonTree> path2 = new ArrayList<>();
		getPath(root,node1,path1);
		getPath(root,node2,path2);
		CommonTree lastParent = null;
		for(int i=0;i<path1.size()&&i<path2.size();i++) {
			if(path1.get(i)==path2.get(i))
				lastParent = path1.get(i);
			else
				continue;
		}
		return lastParent.val;
	}
	
	public static boolean getPath(CommonTree root,CommonTree node,List<CommonTree> curPath) {
		if(root==node)
			return true;
		curPath.add(root);
		
		for(CommonTree child:root.children) {
			if(getPath(child,node,curPath))
				return true;
		}
		curPath.remove(curPath.size()-1);
		return false;
	}
	
	public static void main(String[] args){
        CommonTree root = new CommonTree('A');
        CommonTree b = new CommonTree('B');
        CommonTree c = new CommonTree('C');
        CommonTree d = new CommonTree('D');
        CommonTree e = new CommonTree('E');
        CommonTree f = new CommonTree('F');
        CommonTree g = new CommonTree('G');
        CommonTree h = new CommonTree('H');
        CommonTree i = new CommonTree('I');
        CommonTree j = new CommonTree('J');
        root.addChild(b,c);
        b.addChild(d,e);
        d.addChild(f,g);
        e.addChild(h,i,j);
        System.out.println(findParent(root,f,h));
        System.out.println(findParent(root,h,i));

    }
}
