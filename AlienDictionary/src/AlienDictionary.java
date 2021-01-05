import java.util.*;

public class AlienDictionary {
    //LeetCode 269 problem - HARD
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett", "rftt"};
        //to create a graph
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        //to calculate in degree
        int[] inDegree = new int[26];
        graph = buildGraph(graph, inDegree, words);
        System.out.println(bfs(graph, inDegree));
        //System.out.println(inDegree['w' - 'a']);
    }

    private static String bfs(Map<Character, HashSet<Character>> graph, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        //adding char in queue who has 0 inDegree
        for(Character ch : graph.keySet()) {
            if(inDegree[ch - 'a'] == 0)
                q.offer(ch);
        }
        while(!q.isEmpty()) {
            char out = q.poll();
            sb.append(out);
            for(char in : graph.get(out)) {
                inDegree[in - 'a']--;
                if(inDegree[in - 'a'] == 0)
                    q.offer(in);
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }

    public static Map<Character, HashSet<Character>> buildGraph(Map<Character, HashSet<Character>> graph, int[] inDegree, String[] words) {
        //creating map and allocating memory
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
            }
        }

        for(int i=1; i<words.length; i++) {
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for(int j=0; j<len; j++) {
                char out = first.charAt(j);
                char in = second.charAt(j);
                if( out != in) {
                    graph.get(out).add(in);
                    inDegree[in - 'a']++;
                    break;
                }

                if (j + 1 == len && first.length() > second.length()) {
                    graph.clear();
                    return graph;
                }
            }
        }
        return graph;
    }
}
