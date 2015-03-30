double pow(double x, int n) {
	if(n < 0)return 1.0/power(x,-n);
	return power(x,n);
}
double power(double x, int n){
	if(n == 0)return 1;
	if(n == 1)return x;
	double r = pow(x, n >> 1);
	r *= r;
	if((n & 1) == 1){
		r *= x;
	}
	return r;
}