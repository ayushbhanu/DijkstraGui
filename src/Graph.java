import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class node{
	 int nodeNo;
	 int weight;
	node(int nodeNo, int weight){
		this.nodeNo=nodeNo;
		this.weight=weight;
		}}

public class Graph extends MouseHandler{
	private static int v;
	private int trav=0;
	protected int count=0,p=0;
	private LinkedList<node> ll[];
	private int a[], traverNode[],nodePath[];
	Graph(int v){
        addMouseListener(this);  
		this.v=v;
		vertices=v;
		ll=new LinkedList[v];
		for(int i=0;i<v;i++) {
			
			ll[i]=new LinkedList<>();		}		
				 a=new int[v];
		 Arrays.fill(a, Integer.MAX_VALUE);
		  traverNode=new int [20];
		  nodePath=new int[20];}
	
public	void addpath(int start,int end,int weight) {
		
		node nod=new node(end,weight);
		node nod2=new node(start,weight);
		if(ifPathExist(start, end)) {return;}
		else {
		ll[start].add(nod);
		ll[end].add(nod2);
		}}
	
	boolean ifPathExist(int start,int end) {
		
		Iterator itr=ll[start].iterator();
		while(itr.hasNext()) {
			
node n=(node) itr.next();			
			if(n.nodeNo==end)
				return true;}
		
		return false;}
	
	int  min(int arr[]) {
	trav++;
			int min=Integer.MAX_VALUE,mini=0;
		for(int i=0;i<arr.length;i++) {
			
			if(a[i]==Integer.MIN_VALUE)
			continue;
			else {
				if(a[i]<min) {
				min=a[i];
				mini=i;
				}}}
		
		traverNode[trav]=min;
		nodePath[trav]=mini;
		count++;
		return mini;
			
		}
	
	void shortPath() {
		int i=0;
		a[0]=0;
		traverNode[0]=a[0];
nodePath[0]=0;
		while(i!=v-1) {	
		Iterator itr=ll[i].iterator();
		
		while(itr.hasNext()) {
node n=(node)itr.next();
if(a[n.nodeNo]==Integer.MIN_VALUE)continue;
if(n.weight+a[i]<a[n.nodeNo]) {
			a[n.nodeNo]=n.weight+a[i];}	}
		a[i]=Integer.MIN_VALUE;
		
		System.out.print(" \n");

for(int in=0;in<a.length;in++) {
			
			System.out.print(a[in]+" ");}
i=min(a);
System.out.println(i);
		}
		
		for(int in=0;in<a.length;in++) {
			
			System.out.print(a[in]+" ");}}
	
	void path(){
		int k=count;
		for(int i=count-1;i>=0;i--) {

			int differ=traverNode[i]-traverNode[k];
			if(Math.abs(differ)==iterate(nodePath[i],nodePath[k])) {
				path[p]=nodePath[k];p++;	
			k=i;
			}}
		path[p]=0;
		for(int i=0;i<=p;i++) {
			
			System.out.println(path[i]);	
		}
        prinShorttPath( path,this);		
	}
	
	int iterate(int start,int end) {
		
		Iterator itr=ll[start].iterator();
		while(itr.hasNext()) {
			
			node n=(node)itr.next();
			//System.out.println(n.nodeNo);
			if(n.nodeNo==end) {
			//	System.out.println(n.nodeNo+"->"+start+"===="+n.weight);

			return n.weight;
			}}
		return 0;}
	
	public static void main(String[] args) {
		 System.out.println("Tell no of vertices");
	   	  Scanner sc=new Scanner(System.in);
		  v=sc.nextInt();

		Graph graph=new Graph(v);
		 graph.setBasic();
		 graph.  b.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			             graph. addedge(graph);} }); 
		graph. b1.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
					graph.shortPath();
					graph.path();
			        }  
			      });}}
