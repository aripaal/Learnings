package com.mylearnings.designpattern;

public class Builder {
    static class Employee{

        private  String name;
        private int age;
        private float salary;
        private String sex;
        private String jobTitle;

        private Employee(){};

        public Employee(BuilderHelper builderHelper) {
            this.name = builderHelper.name;
            this.age = builderHelper.age;
            this.salary = builderHelper.salary;
            this.sex = builderHelper.sex;
            this.jobTitle = builderHelper.jobTitle;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sal=" + salary +
                    ", sex='" + sex + '\'' +
                    ", jobTitle='" + jobTitle + '\'' +
                    '}';
        }
        public static class BuilderHelper{
            private  String name;
            private int age;
            private float salary;
            private String sex;
            private String jobTitle;

            public BuilderHelper(String name, int age, float salary) {
                this.name = name;
                this.age = age;
                this.salary = salary;
            }

            public BuilderHelper setSex(String sex) {
                this.sex = sex;
                return this;
            }

            public BuilderHelper setJobTitle(String jobTitle) {
                this.jobTitle = jobTitle;
                return this;
            }
            public Employee build(){
                return new Employee(this);
            }
        }
    }

    public static void main(String ...args){
        Employee emp = new Employee.BuilderHelper("Arijit",34,56000.00f).build();
        Employee emp2 = new Employee.BuilderHelper("Ahmed",34,59000.00f).setJobTitle("Manager").setSex("M").build();
        System.out.println(emp);
        System.out.println(emp2);
    }


}
