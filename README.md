着重介绍了非递归算法，特别是非递归后续遍历 


新增- Rsa 通用平台下的算法 见RsaUtil android上和通用java平台有所区别需要单独引用包


Java代码 复制代码 收藏代码
1.package edu.cumt.jnotnull;  
2.  
3.import java.util.Stack;  
4.  
5.public class BinaryTree {  
6.    protected Node root;  
7.  
8.    public BinaryTree(Node root) {  
9.        this.root = root;  
10.    }  
11.  
12.    public Node getRoot() {  
13.        return root;  
14.    }  
15.  
16.    /** 构造树 */  
17.    public static Node init() {  
18.        Node a = new Node('A');  
19.        Node b = new Node('B', null, a);  
20.        Node c = new Node('C');  
21.        Node d = new Node('D', b, c);  
22.        Node e = new Node('E');  
23.        Node f = new Node('F', e, null);  
24.        Node g = new Node('G', null, f);  
25.        Node h = new Node('H', d, g);  
26.        return h;// root  
27.    }  
28.  
29.    /** 访问节点 */  
30.    public static void visit(Node p) {  
31.        System.out.print(p.getKey() + " ");  
32.    }  
33.  
34.    /** 递归实现前序遍历 */  
35.    protected static void preorder(Node p) {  
36.        if (p != null) {  
37.            visit(p);  
38.            preorder(p.getLeft());  
39.            preorder(p.getRight());  
40.        }  
41.    }  
42.  
43.    /** 递归实现中序遍历 */  
44.    protected static void inorder(Node p) {  
45.        if (p != null) {  
46.            inorder(p.getLeft());  
47.            visit(p);  
48.            inorder(p.getRight());  
49.        }  
50.    }  
51.  
52.    /** 递归实现后序遍历 */  
53.    protected static void postorder(Node p) {  
54.        if (p != null) {  
55.            postorder(p.getLeft());  
56.            postorder(p.getRight());  
57.            visit(p);  
58.        }  
59.    }  
60.  
61.    /** 非递归实现前序遍历 */  
62.    protected static void iterativePreorder(Node p) {  
63.        Stack<Node> stack = new Stack<Node>();  
64.        if (p != null) {  
65.            stack.push(p);  
66.            while (!stack.empty()) {  
67.                p = stack.pop();  
68.                visit(p);  
69.                if (p.getRight() != null)  
70.                    stack.push(p.getRight());  
71.                if (p.getLeft() != null)  
72.                    stack.push(p.getLeft());  
73.            }  
74.        }  
75.    }  
76.  
77.    /** 非递归实现前序遍历2 */  
78.    protected static void iterativePreorder2(Node p) {  
79.        Stack<Node> stack = new Stack<Node>();  
80.        Node node = p;  
81.        while (node != null || stack.size() > 0) {  
82.            while (node != null) {//压入所有的左节点，压入前访问它  
83.                visit(node);  
84.                stack.push(node);  
85.                node = node.getLeft();  
86.            }  
87.            if (stack.size() > 0) {//  
88.                node = stack.pop();  
89.                node = node.getRight();  
90.            }  
91.        }  
92.    }  
93.  
94.    /** 非递归实现后序遍历 */  
95.    protected static void iterativePostorder(Node p) {  
96.        Node q = p;  
97.        Stack<Node> stack = new Stack<Node>();  
98.        while (p != null) {  
99.            // 左子树入栈  
100.            for (; p.getLeft() != null; p = p.getLeft())  
101.                stack.push(p);  
102.            // 当前节点无右子或右子已经输出  
103.            while (p != null && (p.getRight() == null || p.getRight() == q)) {  
104.                visit(p);  
105.                q = p;// 记录上一个已输出节点  
106.                if (stack.empty())  
107.                    return;  
108.                p = stack.pop();  
109.            }  
110.            // 处理右子  
111.            stack.push(p);  
112.            p = p.getRight();  
113.        }  
114.    }  
115.  
116.    /** 非递归实现后序遍历 双栈法 */  
117.    protected static void iterativePostorder2(Node p) {  
118.        Stack<Node> lstack = new Stack<Node>();  
119.        Stack<Node> rstack = new Stack<Node>();  
120.        Node node = p, right;  
121.        do {  
122.            while (node != null) {  
123.                right = node.getRight();  
124.                lstack.push(node);  
125.                rstack.push(right);  
126.                node = node.getLeft();  
127.            }  
128.            node = lstack.pop();  
129.            right = rstack.pop();  
130.            if (right == null) {  
131.                visit(node);  
132.            } else {  
133.                lstack.push(node);  
134.                rstack.push(null);  
135.            }  
136.            node = right;  
137.        } while (lstack.size() > 0 || rstack.size() > 0);  
138.    }  
139.  
140.    /** 非递归实现后序遍历 单栈法*/  
141.    protected static void iterativePostorder3(Node p) {  
142.        Stack<Node> stack = new Stack<Node>();  
143.        Node node = p, prev = p;  
144.        while (node != null || stack.size() > 0) {  
145.            while (node != null) {  
146.                stack.push(node);  
147.                node = node.getLeft();  
148.            }  
149.            if (stack.size() > 0) {  
150.                Node temp = stack.peek().getRight();  
151.                if (temp == null || temp == prev) {  
152.                    node = stack.pop();  
153.                    visit(node);  
154.                    prev = node;  
155.                    node = null;  
156.                } else {  
157.                    node = temp;  
158.                }  
159.            }  
160.  
161.        }  
162.    }  
163.  
164.    /** 非递归实现后序遍历4 双栈法*/  
165.    protected static void iterativePostorder4(Node p) {  
166.        Stack<Node> stack = new Stack<Node>();  
167.        Stack<Node> temp = new Stack<Node>();  
168.        Node node = p;  
169.        while (node != null || stack.size() > 0) {  
170.            while (node != null) {  
171.                temp.push(node);  
172.                stack.push(node);  
173.                node = node.getRight();  
174.            }  
175.            if (stack.size() > 0) {  
176.                node = stack.pop();  
177.                node = node.getLeft();  
178.            }  
179.        }  
180.        while (temp.size() > 0) {  
181.            node = temp.pop();  
182.            visit(node);  
183.        }  
184.    }  
185.  
186.    /** 非递归实现中序遍历 */  
187.    protected static void iterativeInorder(Node p) {  
188.        Stack<Node> stack = new Stack<Node>();  
189.        while (p != null) {  
190.            while (p != null) {  
191.                if (p.getRight() != null)  
192.                    stack.push(p.getRight());// 当前节点右子入栈  
193.                stack.push(p);// 当前节点入栈  
194.                p = p.getLeft();  
195.            }  
196.            p = stack.pop();  
197.            while (!stack.empty() && p.getRight() == null) {  
198.                visit(p);  
199.                p = stack.pop();  
200.            }  
201.            visit(p);  
202.            if (!stack.empty())  
203.                p = stack.pop();  
204.            else  
205.                p = null;  
206.        }  
207.    }  
208.  
209.    /** 非递归实现中序遍历2 */  
210.    protected static void iterativeInorder2(Node p) {  
211.        Stack<Node> stack = new Stack<Node>();  
212.        Node node = p;  
213.        while (node != null || stack.size() > 0) {  
214.            while (node != null) {  
215.                stack.push(node);  
216.                node = node.getLeft();  
217.            }  
218.            if (stack.size() > 0) {  
219.                node = stack.pop();  
220.                visit(node);  
221.                node = node.getRight();  
222.            }  
223.        }  
224.    }  
225.  
226.    /** 
227.     * @param args 
228.     */  
229.    public static void main(String[] args) {  
230.        BinaryTree tree = new BinaryTree(init());  
231.        System.out.print(" Pre-Order:");  
232.        preorder(tree.getRoot());  
233.        System.out.println();  
234.        System.out.print("  In-Order:");  
235.        inorder(tree.getRoot());  
236.        System.out.println();  
237.        System.out.print("Post-Order:");  
238.        postorder(tree.getRoot());  
239.        System.out.println();  
240.        System.out.print(" Pre-Order:");  
241.        iterativePreorder(tree.getRoot());  
242.        System.out.println();  
243.        System.out.print("Pre-Order2:");  
244.        iterativePreorder2(tree.getRoot());  
245.        System.out.println();  
246.        System.out.print("  In-Order:");  
247.        iterativeInorder(tree.getRoot());  
248.        System.out.println();  
249.        System.out.print(" In-Order2:");  
250.        iterativeInorder2(tree.getRoot());  
251.        System.out.println();  
252.        System.out.print(" Post-Order:");  
253.        iterativePostorder(tree.getRoot());  
254.        System.out.println();  
255.        System.out.print("Post-Order2:");  
256.        iterativePostorder2(tree.getRoot());  
257.        System.out.println();  
258.        System.out.print("Post-Order3:");  
259.        iterativePostorder3(tree.getRoot());  
260.        System.out.println();  
261.        System.out.print("Post-Order4:");  
262.        iterativePostorder4(tree.getRoot());  
263.        System.out.println();  
264.  
265.    }  
266.  
267.}  
