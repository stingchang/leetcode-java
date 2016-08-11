public class Solution {
  if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())  
 3         return 0; 
 4         
 5         LinkedList<String> wordQueue = new LinkedList<String>();
 6         int level = 1; //the start string already count for 1
 7         int curnum = 1;//the candidate num on current level
 8         int nextnum = 0;//counter for next level
 9         
10         wordQueue.add(start);
11         
12         while(!wordQueue.isEmpty()){
13             String word = wordQueue.poll();
14             curnum--;
15             
16             for(int i = 0; i < word.length(); i++){
17                 char[] wordunit = word.toCharArray();
18                 for(char j = 'a'; j <= 'z'; j++){
19                     wordunit[i] = j;
20                     String temp = new String(wordunit);  
21                     
22                     if(temp.equals(end))
23                         return level+1;
24                     if(dict.contains(temp)){
25                         wordQueue.add(temp);
26                         nextnum++;
27                         dict.remove(temp);
28                     }
29                 }
30             }
31             
32             if(curnum == 0){
33                 curnum = nextnum;
34                 nextnum = 0;
35                 level++;
36             }
37         }
38         
39         return 0;

}