#include <bits/stdc++.h>
using namespace std;

const double Max_diff = 1e-5;

auto Equation = [] (double x) { return x * x * x - 4 * x - 9; };
auto Derivative = [] (double x) { return 3 * x * x - 4; };

double Newton_Raphson_Method(double initial_value)
{
	double x = initial_value;

	while(fabs(Equation(x)) >= Max_diff)
	{
		//applying the formula of newton raphson
		double f_of_x = Equation(x);
		double f_prime_of_x = Derivative(x);

		if(f_prime_of_x == 0)
		{
			cout << "Invalid , divion by zero is not possible" << '\n';
			return 0.00;
		}

		x = x - f_of_x / f_prime_of_x;
	}

	return x;
}


int32_t main()
{
	double initial_value;
	cout << "Enter the initial value : ";
	cin >> initial_value;

	double root = Newton_Raphson_Method(initial_value);

	if(root != 0.00)
	{
		cout << "The root is : " << root << '\n';
	}

	return 0;
}