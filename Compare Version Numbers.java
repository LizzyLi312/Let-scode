class Solution {
    public int compareVersion(String version1, String version2) {
        //cc
        String[] v1 = version1.split("\\."); // \\ is escape character in java. the out out would be /.
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for(int i = 0; i < len; i++){
            Integer a = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer b = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            int compare = a.compareTo(b); //since we used Integer as type so we can use compareTo
            if(compare != 0) return compare;
        }
        return 0;
    }
}
//time: O(max(s1.length(), s2.length()))
//space: //time: O(max(s1.length(), s2.length()))

class Solution {
    public int compareVersion(String version1, String version2) {
        int temp1 = 0, temp2 = 0;
        int i = 0, j = 0;
        while(i < version1.length() || j < version2.length()){
            temp1 = 0;
            temp2 = 0;
            //calculate each chunk of number between every . .
            while(i < version1.length() && version1.charAt(i) != '.'){
                temp1 = temp1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            while(j < version2.length() && version2.charAt(j) != '.'){
                temp2 = temp2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            if(temp1 > temp2) return 1;
            else if(temp1 < temp2) return -1;
            else{
                j++;
                i++;
            }
        }
        return 0;
    }
}
//time: O(max(s1.length(), s2.length()))
//space: O(1)
