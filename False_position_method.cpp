#include <bits/stdc++.h>
using namespace std;

const double Max_diff = 1e-5;

auto Equation = [] (double x) { return x * x * x - 4 * x - 9; };

double False_Position_Method(double a,double b)
{
	//the product should be a negative value
	if(Equation(a) * Equation(b) >= 0)
	{
		cout << "Given interval is not valid" << '\n';
		return 0.0;
	}

	double c = a;
	while((b - a) >= Max_diff)
	{
		//applying the formula of false position method
		c = ( a * Equation(b) - b * Equation(a) ) / (Equation(b) - Equation(a));

		//checking if we got the root
		if(fabs(Equation(c)) < Max_diff)
		{
			break;
		}

		//swapping the value of the interval
		if(Equation(c) * Equation(a) < 0)
		{
			b = c;
		}
		else 
		{
			a = c;
		}
	}

	return c;
}

int32_t main()
{
	double a,b;
	cout << "Enter the interval [a,b] : " ;
	cin >> a >> b;

	double root = False_Position_Method(a,b);

	if(root != 0.0)
	{
		cout << "The root is : " << root << '\n';
	}

	return 0;
}