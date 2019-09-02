#include <iostream>
#include <vector>
#include <string>

using std::vector;
using std::cout;
void MergeList(const vector<int>& left, const vector<int>& right, 
    vector<int>* result) {
    if (result == nullptr) {
        return;
    }
    int l = 0, r = 0;
    
    while (l < left.size() && r < right.size()) {
        
        if (left.at(l) <= right.at(r)) {
            result->push_back(left.at(l)); 
            ++l;
        } else {
            result->push_back(right.at(r));   
            ++r;
        }  
    }
    
    while (l < left.size()) {
        result->push_back(left.at(l)); 
        ++l;       
    }
    while (r < right.size()) {
        result->push_back(right.at(r)); 
        ++r;       
    }

    return;

}

vector<int>  MergeSort(const vector<int>& to_be_sort, 
            int len) {
    if (len <= 1) {
        return to_be_sort;
    }
    vector<int> result;
    vector<int> left_array (to_be_sort.begin(),to_be_sort.begin() + len/2);
    vector<int> right_array (to_be_sort.begin() + len/2, to_be_sort.end());

    vector<int> left = MergeSort(left_array, len/2);

    vector<int> right = MergeSort(right_array, len - len/2);
    
    MergeList(left, right, &result);
     
    return result;

}

int main()
{
    vector<int> test_1 {5,2,1};
    vector<int> test_2 {10,9,7,3,3545,67,3,-1,4};
    vector<int> result = MergeSort(test_2, test_2.size());
    
    for (const auto& e : result) {    
        cout<<e<<",";
    }
}