#include <bits/stdc++.h>
using namespace std;

const double Max_diff = 1e-5;

auto Equation = [](double x) { return x * x * x - 4 * x - 9; };

double Bisection_Method(double a,double b)
{
	//the product of f(a) and f(b) have to be negative otherwise it won't work
	if(Equation(a) * Equation(b) >= 0)
	{
		cout << "Given interval is not valid" << '\n';
		return 0;
	}

	double c = a;
	while((b - a) >= Max_diff)
	{
		//finding the midpoint
		c = (a + b) / 2;

		//checking if we got our desired root if we do we will break the loop and return or root
		if(fabs(Equation(c)) < Max_diff or (b - a) < Max_diff)
		{
			break;
		}

		//switching our interval
		if(Equation(c) * Equation(a) < 0)
		{
			b = c;
		}
		else 
		{
			a = c;
		}
	}

	//returning our final root to main function
	return c;
}

int32_t main()
{
	//taking input of the interval
	double a,b;
	cout << "Enter the interval [a,b] : " ;
	cin >> a >> b;

	//calling the function to calculate the root
	double root = Bisection_Method(a,b);
	
	//if root is not zero then we have a valid answer
	if(root != 0.00)
	{
		cout << "The root is : " << root << '\n';
	}

	return 0;
}
