#include <iostream>
using namespace std;
int main()
{
    int x = 0;
    cin >> x;
    while (x != 0)
    {
        if (x % 2 == 0)
        {
            cout << "P\n";
        }
        else
        {
            cout << "I\n";
        }
        cin >> x;
    }
}