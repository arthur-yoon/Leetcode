class Solution {
    fun tribonacci(n: Int): Int {
        var t0 = 0
        var t1 = 1
        var t2 = 1
        var current = 0

        if (n == 0) return t0
        if (n == 1) return t1
        if (n == 2) return t2

        for (i in 3 .. n) { // ex) n = 3 -> 4
            current = t0 + t1 + t2 // current = 0- > 0 + 1 + 1 -> 1 + 1 + 2
            t0 = t1 // t0 = 0 -> 1 -> 2
            t1 = t2 // t1 = 1 -> 1 -> 2 
            t2 = current // t2 = 1 -> 2 -> 4
        }
        return current
    }
}

// 0 1 1 2
// 점화식 Tn+3 = Tn + Tn+1 + Tn+2 
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4