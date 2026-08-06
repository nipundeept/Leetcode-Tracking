int productOfDigits(int num) {
    int product;
    product = 1;
    while (num != 0) {
        product = product * (num % 10);
        num /= 10;
    }
    return product;
}
int smallestNumber(int n, int t) {
    while (true) {
        if ((productOfDigits(n)) % t == 0) {
            return n;
        }
        n++;
    }
    return -1;
}
