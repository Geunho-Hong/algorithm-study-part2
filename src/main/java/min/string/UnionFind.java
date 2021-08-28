package min.string;

public class UnionFind {

    public static void main(String[] args) {
        int[] parent = new int[11];

        for (int i = 1; i < parent.length - 1; i++)
            parent[i] = i;

        union(parent, 1, 2);
        union(parent, 2, 3);
        union(parent, 3, 4);
        union(parent, 5, 6);
        union(parent, 6, 7);
        union(parent, 7, 8);
        System.out.printf("1과 5는 연결되어 있나요? %s\n", isConnect(parent, 1, 5));

        union(parent, 2, 8);
        System.out.printf("1과 5는 연결되어 있나요? %s", isConnect(parent, 1, 5));
    }

    // 부모 노드 찾기
    public static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    // 두 부모 노드 합치기
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    public static boolean isConnect(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        return a == b;
    }

}
