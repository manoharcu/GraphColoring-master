/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package graphcolor;
//import java.awt.Color;
//import java.util.Iterator;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
//import org.graphstream.ui.spriteManager.*;
/**
 *
 * @author user
 */
public class graphcolor{ 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    /**
     * @param args the command line arguments
     */

	@SuppressWarnings("null")
	public static void main(String args[]) {
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new SingleGraph("Graph");
		graph.addAttribute("ui.stylesheet", "node {fill-color: blue, green, red, yellow;text-mode:normal;"
                        + "text-background-mode: plain; fill-mode: dyn-plain;text-size:15;size-mode:fit;"
                        + "text-alignment:above;text-mode:truncated;text-background-mode:rounded-box;}");

                Scanner scan = new Scanner(System.in);
                Node[] x = new Node[100];
                String[] nodeName = new String[100] ;
                String[] color= {};
                
                int n;
                System.out.println("Enter number of nodes (Max nodes 10)");
                n= scan.nextInt();
                int count =1;
                float colorNum = 1;
                
                for(int i=0; i<n; i++)
                {
                System.out.println("Enter name of "+count+" node ");
                nodeName[i] = scan.next();
                x[i] = graph.addNode(nodeName[i]);
                x[i].addAttribute("ui.color", colorNum);
                colorNum-=0.1;
                count++;
                }
                graph.setAutoCreate( true );
                for(int j=0; j<n; j++)
                for(int k=0; k<n; k++)
                {
                    if(j!=k && j<=k)
                    {
                    graph.addEdge(nodeName[k].concat(nodeName[j]), nodeName[j], nodeName[k]);
                    
                    }
                }
                for (Node node : graph) {
                    node.addAttribute("ui.label", node.getId());
                }

                
                float[] getColor = new float[10];
                int it1=0;
                int it2=0;
                graph.display();
        }
}

    

