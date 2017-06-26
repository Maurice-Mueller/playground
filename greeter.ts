function greeter(person: string) {
    return "Hello, " + person
}

var user = "Jane User"

greeter(user)

interface Person {
    firstName: string
    lastName: string
}

function greetInterface(person: Person) {
    return "Hello " + person.firstName + " " + person.lastName;
}

var interfaceUser = {firstName: "jane", lastName: "user"}

greetInterface(interfaceUser)

class Student {
    fullName: string
    constructor(public firstName, public lastName) {
        this.fullName = firstName + ' ' + lastName
    }
}

var student = new Student("Jane", "User")

greetInterface(student)

function greetStudent(student: Student) {
    return "Hello " + student.fullName
}

greetStudent(student)