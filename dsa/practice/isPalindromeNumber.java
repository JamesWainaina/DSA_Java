public boolean isPlaindrome(int x){
    if (x < 0)
        return flase;
    }

    long reversed = 0;
    long temp = x;

    while (temp != 0){
        int digit = (int) (temp % 10);
        reversed = reversed * 10 + digit;
        temp /= 10;
    }
    return (reversed == x);
  }
}
