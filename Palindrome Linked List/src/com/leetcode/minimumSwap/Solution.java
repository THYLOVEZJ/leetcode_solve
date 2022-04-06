package com.leetcode.minimumSwap;

/***
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-strings-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minimumSwap(String s1, String s2) {
        /***
         *  s1:x    s2:y
         *  S2:y    s1:x
         *  对于x,y这种情况，我们只需要判断x,y的个数，除2就是需要交换的次数，因为xx,yy只需要交换一次即可。
         *  而对于y,x这种情况，同理，我们只需要除2就是要交换的次数
         *  而此时如果还有剩余，我们判断剩下的个数，如果两种剩下的个数不相等，那么直接返回-1
         *  否则，我们给剩下的个数×2
         */
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            }
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }
        int res = 0;
        res += xy / 2;
        res += yx / 2;
        if (xy % 2 != yx % 2) {
            return -1;
        }
        res += xy % 2 * 2;
        return res;
    }
}
