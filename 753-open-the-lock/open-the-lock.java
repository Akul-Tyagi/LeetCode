class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> de = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> q = new LinkedList();
        q.offer("0000");

        int level =0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                String curr = q.poll();
                if(de.contains(curr)){
                    size--;
                    continue;
                }

                if(curr.equals(target)){
                    return level;
                }

                StringBuilder sb = new StringBuilder(curr);
                for(int i=0; i<4;i++){
                    char pos = sb.charAt(i);
                    String s1 = sb.substring(0,i) +(pos == '9'?0: pos - '0' +1) +sb.substring(i+1);
                    String s2 = sb.substring(0,i) + (pos =='0'? 9: pos - '0' -1 ) + sb.substring(i+1);

                    if(!visited.contains(s1) && !de.contains(s1)){
                        q.offer(s1);
                        visited.add(s1);
                    }

                    if(!visited.contains(s2) && !de.contains(s2)){
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++; 
        }
        return -1;
    }
}