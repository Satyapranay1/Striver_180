//Prime Numbers upto N
public ArrayList<Integer> primeTillN(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] sieve = new boolean[n + 1];
    for (int i = 2; i * i <= n; i++){
        if (!sieve[i]) {
            for (int p = i * i; p <= n; p += i) {
                sieve[p] = true;
            }
        }
    }
    for (int i = 2; i <= n; i++){
        if (!sieve[i]) ans.add(i);
    }
    return ans;
}

void main() {
    int n = 50;

    ArrayList<Integer> result = primeTillN(n);

    System.out.println("Prime Numbers till " + n + ": " + result);
}