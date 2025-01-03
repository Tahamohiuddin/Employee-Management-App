#include <iostream>
#include <vector>
#include <string>

struct Employee {
    int id;
    std::string name;
    std::string role;
    double salary;
};

void generateReport(const std::vector<Employee>& employees) {
    std::cout << "Employee Report:\n";
    double totalSalary = 0;
    for (const auto& emp : employees) {
        std::cout << "ID: " << emp.id << ", Name: " << emp.name << ", Role: " << emp.role << ", Salary: $" << emp.salary << "\n";
        totalSalary += emp.salary;
    }
    std::cout << "Total Salary Expense: $" << totalSalary << "\n";
}

int main() {
    std::vector<Employee> employees = {
        {1, "John Doe", "Developer", 80000},
        {2, "Jane Smith", "Manager", 95000}
    };

    generateReport(employees);
    return 0;
}
